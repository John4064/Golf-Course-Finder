package com.parkhurst.golfcoursefinder;
//This will be the course object
public class Course {
    protected String name;
    protected String zipcode;
    protected float distance;

    /**
    @param: courseName: Name of course(string)
    @param: courseZip: Zip code of course(string)
    @param: distanceTo: Distance from origin to course
     */
    public Course(String courseName, String courseZip, float distanceTo){
        name  = courseName;
        zipcode = courseZip;
        distance = distanceTo;
    }

    public String getName(){
        return this.name;
    }
    public String getZipcode(){
        return this.zipcode;
    }
    public float getDistance(){
        return this.distance;
    }
}
