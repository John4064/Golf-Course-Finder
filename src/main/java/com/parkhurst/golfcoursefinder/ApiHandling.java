package com.parkhurst.golfcoursefinder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ApiHandling {

    public static String courseLookup() throws IOException {
        //Setup a properties Folder
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://golf-course-finder.p.rapidapi.com/courses?radius=10&lat=-121.95035631683683&lng=36.56910381018662")
                .get()
                .addHeader("x-rapidapi-host", "golf-course-finder.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "4350144f3emshedb34f8e05da506p19d449jsn72b1b5861bf1")
                .build();

        Response response = client.newCall(request).execute();
        return "";
    }
}
