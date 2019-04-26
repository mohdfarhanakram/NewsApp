package com.farhan.newsapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.farhan.newsapp.R;
import com.farhan.newsapp.adapter.NewsAdapter;
import com.farhan.newsapp.model.News;
import com.farhan.newsapp.network.NewsApiService;
import com.farhan.newsapp.persenter.NewsContract;
import com.farhan.newsapp.persenter.NewsPresenter;
import com.farhan.newsapp.repository.NewsRepository;
import com.farhan.newsapp.utils.TinyDB;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by Farhan on 25,April,2019
 */
public class NewsListActivity extends BaseActivity implements NewsContract.View, NewsAdapter.NewsClickListener {

    @Inject
    public NewsRepository newsRepository;

    private RecyclerView newsRV;
    private SwipeRefreshLayout loaderView;
    private NewsPresenter newsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupTitle();
        newsRV = findViewById(R.id.newsRV);
        LinearLayoutManager linearLayoutManger = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        newsRV.setLayoutManager(linearLayoutManger);
        loaderView = findViewById(R.id.loaderView);
        loaderView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(newsPresenter!=null){
                    newsPresenter.loadNews();
                }
            }
        });

        newsPresenter = new NewsPresenter(this,newsRepository);
        newsPresenter.loadNews();
    }

    @Override
    public void init() {
        //Show Loader Here
        showLoader();
    }

    @Override
    public void showError(String message) {
       //Show Message
        hideLoader();
        showMessage(message);
    }

    @Override
    public void loadNewsInList(List<News> newsList) {
        //Draw UI
        hideLoader();
        newsRV.setAdapter(new NewsAdapter(this,this,newsList));
    }

    @Override
    public void onClick(News news) {
        Intent intent = new Intent(this,WebViewActivity.class);
        intent.putExtra(WebViewActivity.DETAIL_URL,news.getUrl());
        startActivity(intent);
    }

    private void showLoader(){
        loaderView.setRefreshing(true);
    }

    private void hideLoader(){

        loaderView.setRefreshing(false);
    }

    private void setupTitle(){
        ((TextView)findViewById(R.id.toolbar)).setText(getString(R.string.news_headline));
    }

}
