package com.farhan.newsapp.repository;

import com.farhan.newsapp.model.News;
import com.farhan.newsapp.model.NewsResponse;
import com.farhan.newsapp.network.Callback;
import com.farhan.newsapp.network.NewsApiService;
import com.farhan.newsapp.utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Farhan on 25,April,2019
 */

@Singleton
public class NewsRepository {

    private NewsApiService newsApiService;
    private TinyDB tinyDB;


    @Inject
    public NewsRepository(NewsApiService newsApiService, TinyDB tinyDB) {
        this.newsApiService = newsApiService;
        this.tinyDB = tinyDB;
    }

    public void loadNewsHeadLines(final Callback<List<News>> callback){
        // return saved news
        callback.returnResult(tinyDB.getListObject(TinyDB.NEWS,News.class));
        // refresh news
        newsApiService
                .getNewsHeadlines("in")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsResponse newsResponse) {
                        if(newsResponse!=null
                                && "ok".equalsIgnoreCase(newsResponse.getStatus())
                                && newsResponse.getNewsList()!=null){
                            tinyDB.putListObject(TinyDB.NEWS,(ArrayList<News>) newsResponse.getNewsList());
                            callback.returnResult(newsResponse.getNewsList());
                        }else{
                            callback.returnError("Something went wrong");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
