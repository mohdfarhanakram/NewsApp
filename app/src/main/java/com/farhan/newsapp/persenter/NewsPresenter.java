package com.farhan.newsapp.persenter;

import com.farhan.newsapp.model.News;
import com.farhan.newsapp.network.Callback;
import com.farhan.newsapp.repository.NewsRepository;
import com.farhan.newsapp.utils.TinyDB;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Farhan on 25,April,2019
 */
public class NewsPresenter implements NewsContract.Presenter{

    private NewsContract.View view;
    private NewsRepository newsRepository;

    @Inject
    public NewsPresenter(NewsContract.View view,NewsRepository newsRepository) {
        this.view = view;
        this.newsRepository = newsRepository;
    }

    @Override
    public void start() {

    }

    @Override
    public void loadNews() {
        view.init();
        newsRepository.loadNewsHeadLines(new Callback<List<News>>() {
            @Override
            public void returnResult(List<News> news) {
                view.loadNewsInList(news);
            }

            @Override
            public void returnError(String message) {
               view.showError(message);
            }
        });
    }
}
