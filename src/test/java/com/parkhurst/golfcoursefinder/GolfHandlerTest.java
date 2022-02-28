package com.parkhurst.golfcoursefinder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GolfHandlerTest {

    //Fields
    static GolfHandler golfH;

    @BeforeAll
    static void setup() throws IOException {
        System.out.println("Executing Setup");
        golfH = new GolfHandler();
    }
    @BeforeEach
    void prep(){
        golfH.setDistance(5);
    }

    @Tag("Distance")
    @Test
    void testDistance() {
        System.out.println("Executing Test 1");
        golfH.setDistance(25);
        System.out.println(String.format("Expected %d and got %d",25,golfH.getDistance()));
        assertEquals(25,golfH.getDistance());
    }

    @Tag("Url1")
    @Test
    void testUrl1(){
        System.out.println("Executing Test 2");
        // 06820
        String[] longLatArr = new String[2];
        longLatArr[1]="-73.481568";
        longLatArr[0]="41.075974";
        golfH.setLongLat(longLatArr);
        String tempS=golfH.urlBuilder();
        //?radius=%d&lat=%s&lng=%s
        System.out.println(String.format("Expected %s and got %s","?radius=5&lat=-73.481568&lng=41.075974",tempS));
        assertEquals("?radius=5&lat=-73.481568&lng=41.075974",tempS);

    }

    @Tag("Url2")
    @Test
    void testUrl2(){
        System.out.println("Executing Test 3");
        //01111
        String[] longLatArr = new String[2];
        longLatArr[1]="-72.5905";
        longLatArr[0]="42.1015";
        golfH.setLongLat(longLatArr);
        String tempS=golfH.urlBuilder();
        System.out.println(String.format("Expected %s and got %s","?radius=5&lat=-72.5905&lng=42.1015",tempS));
        assertEquals(tempS,"?radius=5&lat=-72.5905&lng=42.1015");
    }
}