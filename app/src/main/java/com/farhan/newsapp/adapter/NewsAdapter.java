package com.farhan.newsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.farhan.newsapp.R;
import com.farhan.newsapp.model.News;
import com.farhan.newsapp.utils.DateUtil;
import com.farhan.newsapp.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farhan on 25,April,2019
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.VH> {

    private Context context;
    private List<News> newsArrayList;
    private NewsClickListener listener;


    public NewsAdapter(Context context, NewsClickListener listener, List<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VH(LayoutInflater.from(context).inflate(R.layout.row_news_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        News news = newsArrayList.get(i);
        vh.tvNewsTitle.setText(news.getTitle());
        if(news.getSource()!=null)
           vh.tvNewsSource.setText(DateUtil.getSourceAndTime(news.getSource().getName(),news.getPublishedAt()));
        vh.tvNewsTitle.setText(news.getTitle());

        vh.mainView.setTag(news);
        vh.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick((News) v.getTag());
            }
        });

        if(!TextUtils.isEmpty(news.getUrlToImage())){
            ImageUtil.loadImage(vh.ivNewsImage,news.getUrlToImage(),news.getUrl());
        }

    }

    @Override
    public int getItemCount() {
        return newsArrayList==null?0:newsArrayList.size();
    }

    public static class VH extends RecyclerView.ViewHolder {

        private TextView tvNewsTitle;
        private ImageView ivNewsImage;
        private TextView tvNewsSource;

        private View mainView;

        public VH(@NonNull View itemView) {
            super(itemView);
            tvNewsTitle = itemView.findViewById(R.id.tv_news_title);
            ivNewsImage = itemView.findViewById(R.id.iv_news_image);
            tvNewsSource = itemView.findViewById(R.id.tv_news_source);
            mainView = itemView.findViewById(R.id.card_view);

        }
    }

    public interface NewsClickListener{
        public void onClick(News news);
    }
}
