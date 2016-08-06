package com.airballdigital.duckduckgo.Api;

import com.airballdigital.duckduckgo.Models.Responses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Allen Carden on 8/6/2016.
 */
public interface SearchApi {

    @GET("/?format=json&pretty=1&skip_disambig=1")
    Call<Responses> getAllResults(@Query("q") String query);
}
