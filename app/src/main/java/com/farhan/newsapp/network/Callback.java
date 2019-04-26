package com.farhan.newsapp.network;

/**
 * Created by Farhan on 25,April,2019
 */
public abstract class Callback<T> {
    public abstract void returnResult(T t);
    public abstract void returnError(String message);
}
