package com.parkhurst.golfcoursefinder;



import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import static com.parkhurst.golfcoursefinder.PropertyLoader.getPropValues;

public class ZipHandler extends Handler{
    private String apiKey;
    private String url;

    public ZipHandler() throws IOException {
        String[] propArr = getPropValues();
        //Check if null
        url = propArr[3];
        apiKey= propArr[1];
        //apiKey= propArr[1];
    }

    /**@param preZip This is the zipcode for the apiCAll
     * @brief This method makes the api call based on the Zipcode parameter
     * @return Jsonarray as a String
     * @throws IOException
     */
    @NotNull
    private String makeCall(String preZip) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url+"/?zipcode="+preZip)
                .get()
                .addHeader("x-rapidapi-host", "us-zip-code-information.p.rapidapi.com")
                .addHeader("x-rapidapi-key", apiKey)
                .build();

        Response response = client.newCall(request).execute();
        return Objects.requireNonNull(response.body()).string();
    }

    /**
     * @param preParse: The json array we get from our API call
     * @return A String array of length two of Lattiude,longitude
     */
    protected String[] parseStr(String preParse){
        String[] longLatArr = new String[2];
        final JSONArray obj = new JSONArray(preParse);
        try{
            JSONObject jsonobject = obj.getJSONObject(0);
            longLatArr[0]=jsonobject.getString("Latitude");
            longLatArr[1]= jsonobject.getString("Longitude");
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error on Reading API CALL");
        }
        return longLatArr;
    }

    /**
     * @param zipcode a zipcode length 6
     * @brief Uses google api to convert a zipcode to longitude and lattitude
     * @return
     */
    public String[] zipToLL(@NotNull String zipcode) throws IOException {
        if(zipcode.length()!=5){
            return null;
        }
        return parseStr(makeCall(zipcode));
    }
}
