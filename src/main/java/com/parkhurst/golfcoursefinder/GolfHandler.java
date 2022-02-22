package com.parkhurst.golfcoursefinder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import static com.parkhurst.golfcoursefinder.PropertyHandler.getPropValues;

/**
 * @author John parkhurst
 */

public class GolfHandler extends Handler {
    //Fields
    private String apiKey;
    private String url;
    private String longitude;
    private String latitude;


    public GolfHandler() throws IOException {
        String[] propArr = getPropValues();
        url = propArr[0];
        apiKey= propArr[1];
    }

    private String urlBuilder(){
        return String.format("?radius=10&lat=%s&lng=%s",latitude,longitude);
    }
    private String makeCall() throws IOException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("x-rapidapi-host", "golf-course-finder.p.rapidapi.com")
                .addHeader("x-rapidapi-key", apiKey)
                .build();
        Response response = client.newCall(request).execute();
        return Objects.requireNonNull(response.body()).string();
    }

    public ArrayList<Course> courseLookup(String[] longLatArr) throws IOException {
        //Setup a properties Folder
        latitude = longLatArr[0];
        longitude = longLatArr[1];
        url += urlBuilder();
        String preParse;
        try {
            preParse = makeCall();
        } catch (Exception e) {
            System.out.println("Error on api call");
            return null;
        }
        ArrayList<Course> courseList = new ArrayList<Course>();
        final JSONArray obj = new JSONArray(preParse);
        try {

            for(int i = 0; i< obj.length();i++){
                JSONObject jsonobject = obj.getJSONObject(i);
                //new Course("Pebble Beach", "06902", 4),
                System.out.println(jsonobject.getString("name"));
                System.out.println(jsonobject.getString("zip_code"));
                System.out.println(jsonobject.getString("distance"));
                //longLatArr[0]=jsonobject.getString("Latitude");

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error on Reading API CALL");
        }
        return courseList;
    }
}
