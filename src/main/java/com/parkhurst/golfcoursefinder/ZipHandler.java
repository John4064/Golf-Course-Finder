package com.parkhurst.golfcoursefinder;



import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.json.*;
import java.io.IOException;
import java.util.Objects;

import static com.parkhurst.golfcoursefinder.PropertyHandler.getPropValues;

public class ZipHandler extends Handler{
    private String apiKey;
    private String url;

    private String preZip;

    public ZipHandler() throws IOException {
        String[] propArr = getPropValues();
        url = propArr[3];
        apiKey= propArr[1];
    }

    private String makeCall() throws IOException {
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
     * @param zipcode a zipcode length 6
     * @brief Uses google api to convert a zipcode to longitude and lattitude
     * @return
     */
    public String[] zipToLL(@NotNull String zipcode) throws IOException {
        if(zipcode.length()!=5){
            return null;
        }
        String[] ans = new String[2];
        preZip=zipcode;
        System.out.println(makeCall());
        return ans;
    }
}
