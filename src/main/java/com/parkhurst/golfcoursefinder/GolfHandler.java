package com.parkhurst.golfcoursefinder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.Objects;
import static com.parkhurst.golfcoursefinder.PropertyHandler.getPropValues;

/**
 * @author John parkhurst
 */

public class GolfHandler extends Handler {
    //Fields
    private String apiKey;
    private String url;
    private float longitude;
    private float latitude;


    public GolfHandler() throws IOException {
        String[] propArr = getPropValues();
        url = propArr[0];
        apiKey= propArr[1];
    }


    public String courseLookup() throws IOException {
        //Setup a properties Folder
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url+"?radius=10&lat=-121.95035631683683&lng=36.56910381018662")
                .get()
                .addHeader("x-rapidapi-host", "golf-course-finder.p.rapidapi.com")
                .addHeader("x-rapidapi-key", apiKey)
                .build();

        Response response = client.newCall(request).execute();
        return Objects.requireNonNull(response.body()).string();
    }
}
