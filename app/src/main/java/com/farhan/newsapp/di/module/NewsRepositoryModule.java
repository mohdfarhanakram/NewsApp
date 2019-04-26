package com.farhan.newsapp.di.module;

import com.farhan.newsapp.network.NewsApiService;
import com.farhan.newsapp.repository.NewsRepository;
import com.farhan.newsapp.utils.TinyDB;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Farhan on 25,April,2019
 */
@Module
public class NewsRepositoryModule {

    @Provides
    @Singleton
    public NewsRepository provideNewsRepository(NewsApiService newsApiService, TinyDB tinyDB){
        return new NewsRepository(newsApiService,tinyDB);
    }
}
