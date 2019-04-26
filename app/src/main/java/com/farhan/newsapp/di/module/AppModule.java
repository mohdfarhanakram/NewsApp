package com.farhan.newsapp.di.module;

import android.app.Application;

import com.farhan.newsapp.network.NewsApiService;
import com.farhan.newsapp.repository.NewsRepository;
import com.farhan.newsapp.utils.TinyDB;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Farhan on 25,April,2019
 */

@Module(includes = NewsRepositoryModule.class)
public class AppModule {

    /*
     * The method returns the Gson object
     * */
    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }



    /*
     * The method returns the Okhttp object
     * */
    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
       /* httpClient.cache(cache);
        httpClient.addInterceptor(logging);
        httpClient.addNetworkInterceptor(new RequestInterceptor());*/
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        return httpClient.build();
    }


    /*
     * The method returns the Retrofit object
     * */
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(NewsApiService.BASE_URL)
                .client(okHttpClient)
                .build();
    }

    /*
     *  NewsApiService module.
     *
     * */

    @Provides
    @Singleton
    NewsApiService provideNewsApiService(Retrofit retrofit) {
        return retrofit.create(NewsApiService.class);
    }

    /**
     *  For save data
     */
    @Provides
    @Singleton
    TinyDB provideTinyDb(Application application){
        return new TinyDB(application);
    }

}
