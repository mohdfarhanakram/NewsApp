package com.farhan.newsapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.farhan.newsapp.repository.NewsRepository;

import javax.inject.Inject;

import dagger.android.DaggerActivity;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Farhan on 25,April,2019
 */
public class BaseActivity extends DaggerActivity {

    public void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
