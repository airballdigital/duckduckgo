package com.airballdigital.duckduckgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etSearch;
    private Button btnFindResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        etSearch = (EditText) findViewById(R.id.etSearch);
        btnFindResults = (Button) findViewById(R.id.btnFindResults);
        btnFindResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchTerm = etSearch.getText().toString();

                if (!TextUtils.isEmpty(searchTerm)) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("searchTerm", searchTerm);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "No Search Term!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
