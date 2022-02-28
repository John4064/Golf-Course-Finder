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
    private int distRange;


    public GolfHandler() throws IOException {
        String[] propArr = getPropValues();
        //Check if null
        url = propArr[0];
        apiKey= propArr[1];
        distRange = 25;
    }

    /**
     * @brief formats the string for the apiurl with given lattitude and longitude
     * @return the url formatted
     */
    private String urlBuilder(){
        return String.format("?radius=%d&lat=%s&lng=%s",distRange,latitude,longitude);
    }

    /**
     * @brief This method just handles API calls to the desired destination!
     * @return Returns the jsonobject as a string
     * @throws IOException
     */
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

    /**
     * @param longLatArr
     * @brief This is the meat of the handler it is what is called and uses the data given to communicate/parse
     * /process/save
     * @return Returns an arraylist of courseObjects
     * @throws IOException
     */
    public ArrayList<Course> courseLookup(String[] longLatArr) throws IOException {
        //Setup a properties Folder
        latitude = longLatArr[1];
        longitude = longLatArr[0];
        url += urlBuilder();
        String preParse;
        try {
            preParse = makeCall();
        } catch (Exception e) {
            System.out.println("Error on api call");
            return null;
        }
        ArrayList<Course> courseList = new ArrayList<Course>();

        //{"courses": [{"name": "Poppy Hills Golf Course", "zip_code": "93953", "distance": 0.5}, {"name": "Spyglass Hill Golf Course", "zip_code": "93953", "distance": 0.8}, {"name": "Spyglass Hill Golf Course", "zip_code": "93953", "distance": 0.8}, {"name": "Dunes Course at Monterey Peninsula Country Club", "zip_code": "93953", "distance": 0.9}, {"name": "Cypress Point Club", "zip_code": "93953", "distance": 1.1}, {"name": "Cypress Point Club", "zip_code": "93953", "distance": 1.1}, {"name": "Golf Links Course at Pebble Beach Golf Links", "zip_code": "93953", "distance": 1.3}, {"name": "The Links at Spanish Bay", "zip_code": "93953", "distance": 1.5}, {"name": "Pacific Grove Municipal Golf Course", "zip_code": "93950", "distance": 3.3}, {"name": "Del Monte Golf Course", "zip_code": "93940", "distance": 4.1}, {"name": "Naval Postgraduate School Golf Course", "zip_code": "93940", "distance": 4.4}, {"name": "West Course at Rancho Canada Golf Club", "zip_code": "93923", "distance": 4.5}, {"name": "Quail Lodge Resort & Golf Club", "zip_code": "93923", "distance": 6.5}, {"name": "The Bayonet Course at Bayonet/Black Horse Golf Course", "zip_code": "93955", "distance": 7.6}, {"name": "Laguna Seca Ranch Golf Club", "zip_code": "93940", "distance": 8.8}, {"name": "Carmel Valley Ranch Resort", "zip_code": "93923", "distance": 9.1}, {"name": "Tehama Golf Club", "zip_code": "93923", "distance": 9.1}, {"name": "Pasadera Country Club", "zip_code": "93940", "distance": 9.6}]}
        final JSONObject jsonOrigin = new JSONObject(preParse);
        JSONArray jsonCourseArr = jsonOrigin.getJSONArray("courses");
        try {

            for(int i = 0; i< jsonCourseArr.length();i++){
                JSONObject jsonobject = jsonCourseArr.getJSONObject(i);

                Course localCour = new Course(jsonobject.getString("name"), jsonobject.getString("zip_code"),
                        jsonobject.getFloat("distance"));
                courseList.add(localCour);
                //longLatArr[0]=jsonobject.getString("Latitude");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error on Reading API CALL");
        }

        return courseList;
    }

    /**@param newDist The new desired distanced
     * @brief changes the distance the golf api searchs
     */
    public void setDistance(int newDist){
        distRange = newDist;
        return;
    }
}
