package com.farhan.newsapp.di.builder;

import com.farhan.newsapp.di.module.NewsRepositoryModule;
import com.farhan.newsapp.ui.NewsListActivity;
import com.farhan.newsapp.ui.WebViewActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Farhan on 25,April,2019
 */
@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector
    public abstract NewsListActivity bindNewsListActivity();

    @ContributesAndroidInjector
    public abstract WebViewActivity bindWebViewActivity();
}
