package com.farhan.newsapp;

import android.app.Application;


import com.farhan.newsapp.di.component.AppComponent;
import com.farhan.newsapp.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


/**
 * Created by Farhan on 25,April,2019
 */
public class NewsApplication extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }


    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

}
