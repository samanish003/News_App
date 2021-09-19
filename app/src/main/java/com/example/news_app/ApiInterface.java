package com.example.news_app;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://newsapi.org/v2/";

    @GET("sources")
    Call<mainNews> getNews(
            @Query("apiKey") String apiKey
    );


}
