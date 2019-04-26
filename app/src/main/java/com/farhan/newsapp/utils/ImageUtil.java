package com.farhan.newsapp.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.farhan.newsapp.R;

/**
 * Created by Farhan on 25,April,2019
 */
public class ImageUtil {

    public static void loadThumbnailImage(ImageView imageView, String url, String articleUrl) {
        Context context = imageView.getContext();
        if (url == null) {
            String iconUrl = "https://besticon-demo.herokuapp.com/icon?url=%s&size=80..120..200";
            url = String.format(iconUrl, Uri.parse(articleUrl).getAuthority());
        }
        Glide.with(imageView)
                .load(url)
                .apply(NewsGlideModule.roundedCornerImage(new RequestOptions(), imageView.getContext(), 4))
                .placeholder(context.getResources().getDrawable(R.color.cardBackground))
                .into(imageView);
    }


    public static void loadImage(ImageView imageView, String url, String articleUrl) {
        Context context = imageView.getContext();
        if (url == null) {
            String iconUrl = "https://besticon-demo.herokuapp.com/icon?url=%s&size=80..120..200";
            url = String.format(iconUrl, Uri.parse(articleUrl).getAuthority());
        }
        Glide.with(imageView)
                .load(url)
                .apply(NewsGlideModule.roundedCornerImage(new RequestOptions(), imageView.getContext(), 0))
                .placeholder(context.getResources().getDrawable(R.color.cardBackground))
                .into(imageView);
    }
}
