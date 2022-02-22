package com.parkhurst.golfcoursefinder;



import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import static com.parkhurst.golfcoursefinder.PropertyHandler.getPropValues;

public class ZipHandler {
    private String apiKey;
    private String url;

    public ZipHandler() throws IOException {
        String[] propArr = getPropValues();
        url = propArr[3];
        apiKey= propArr[1];
    }

    /**
     * @param zipcode a zipcode length 6
     * @brief Uses google api to convert a zipcode to longitude and lattitude
     * @return
     */
    public String[] zipToLL(@NotNull String zipcode){
        if(zipcode.length()!=5){
            return null;
        }
        String[] ans = new String[2];


        return ans;
    }
}
