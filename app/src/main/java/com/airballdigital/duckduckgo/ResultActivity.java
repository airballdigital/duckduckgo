package com.airballdigital.duckduckgo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.airballdigital.duckduckgo.Adapters.CustomAdapter;
import com.airballdigital.duckduckgo.Api.SearchApi;
import com.airballdigital.duckduckgo.Models.Responses;
import com.airballdigital.duckduckgo.Services.SearchService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity {

    private ListView listView;
    Responses allResponses;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initViews();
        checkSearchTerm();
    }

    void checkSearchTerm()
    {
        String searchTerm = getIntent().getStringExtra("searchTerm");
        if (null == searchTerm) {
            finish();
        } else {
            displayResult(searchTerm);
        }
    }

    void initViews()
    {
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = "" + adapter.getItem(i).getText().toString();
                Toast.makeText(getApplicationContext(), txt + "" , Toast.LENGTH_LONG).show();
            }
        });
    }

    protected void displayResult(String searchTerm) {

        SearchApi api = SearchService.createSearchService(SearchApi.class);

        Call<Responses> call = api.getAllResults(searchTerm);
        call.enqueue(new Callback<Responses>() {
            @Override
            public void onResponse(Call<Responses> call, Response<Responses> response) {

                    allResponses = response.body();
                    adapter = new CustomAdapter(getApplicationContext());
                    adapter.setData(allResponses.getRelatedTopics());
                    listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Responses> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

}
