package com.parkhurst.golfcoursefinder;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import org.jetbrains.annotations.NotNull;

public class ZipHandler {

    private static final String GEO_CODE_SERVER = "http://maps.googleapis.com/maps/api/geocode/json?";



    /**
     * @param zipcode a zipcode length 6
     * @brief Uses google api to convert a zipcode to longitude and lattitude
     * @return
     */
    public static String[] zipToLL(@NotNull String zipcode){
        String[] ans = new String[2];
        if(zipcode.length()!=5){
            return null;
        }


        return ans;
    }
}
