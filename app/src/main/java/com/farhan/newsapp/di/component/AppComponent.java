package com.farhan.newsapp.di.component;

import android.app.Application;

import com.farhan.newsapp.NewsApplication;
import com.farhan.newsapp.di.builder.ActivityBuilder;
import com.farhan.newsapp.di.module.AppModule;
import com.farhan.newsapp.repository.NewsRepository;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by Farhan on 25,April,2019
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
})
public interface AppComponent extends AndroidInjector<NewsApplication> {
    @Override
    void inject(NewsApplication instance);

    @Component.Builder
    @Singleton
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }
    void inject(Application application);
}
