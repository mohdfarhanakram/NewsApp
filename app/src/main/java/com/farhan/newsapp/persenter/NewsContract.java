package com.farhan.newsapp.persenter;

import com.farhan.newsapp.model.News;

import java.util.List;

/**
 * Created by Farhan on 25,April,2019
 */
public class NewsContract {

    public interface View {
        void init();
        void showError(String message);
        void loadNewsInList(List<News> newsList);
    }
    public interface Presenter {
        void start();
        void loadNews();
    }
}
