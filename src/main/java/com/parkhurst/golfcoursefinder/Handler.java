package com.parkhurst.golfcoursefinder;

import java.io.IOException;

import static com.parkhurst.golfcoursefinder.PropertyHandler.getPropValues;

/**
 * @author John Parkhurst
 */
//TODO: create a parent handler object for ziphandler, golfhandler, prophandler that they inherit from
public class Handler {

    protected String apiKey;
    private String url;

    public Handler() throws IOException {
        String[] propArr = getPropValues();
        apiKey= propArr[1];

    }
}
