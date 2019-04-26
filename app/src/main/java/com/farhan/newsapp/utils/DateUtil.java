package com.farhan.newsapp.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import java.sql.Timestamp;

/**
 * Created by Farhan on 25,April,2019
 */
public class DateUtil {

    public static String getSourceAndTime(String sourceName, Timestamp date) {
        return sourceName + " • " + getElapsedTime(date.getTime());
    }

    public static String getElapsedTime(long utcTimeString) {
        long timeElapsedInSeconds = (System.currentTimeMillis() - utcTimeString) / 1000;

        if (timeElapsedInSeconds < 60) {
            return "less than 1m";
        } else if (timeElapsedInSeconds < 3600) {
            timeElapsedInSeconds = timeElapsedInSeconds / 60;
            return timeElapsedInSeconds + "m";
        } else if (timeElapsedInSeconds < 86400) {
            timeElapsedInSeconds = timeElapsedInSeconds / 3600;
            return timeElapsedInSeconds + "h";
        } else {
            timeElapsedInSeconds = timeElapsedInSeconds / 86400;
            return timeElapsedInSeconds + "d";
        }
    }
}
