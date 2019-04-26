package com.farhan.newsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Farhan on 25,April,2019
 */
public class NewsResponse {

    private String status;
    private int totalResults;

    @SerializedName("articles")
    private List<News> newsList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
