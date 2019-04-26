package com.farhan.newsapp.network;

import com.farhan.newsapp.model.NewsResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Farhan on 25,April,2019
 */
public interface NewsApiService {

    String API_KEY = "235c5dc256a84e8c84656c06a75faa08";
    String BASE_URL = "https://newsapi.org";

    @Headers("X-Api-Key:" + API_KEY)
    @GET("/v2/top-headlines")
    Observable<NewsResponse> getNewsHeadlines(
            @Query("country") String country
    );
}
