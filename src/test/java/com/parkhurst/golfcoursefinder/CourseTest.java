package com.parkhurst.golfcoursefinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.parkhurst.golfcoursefinder.Course.*;
class CourseTest {
    Course testCourse;
    @BeforeEach
    void setUp() {
        this.testCourse = new Course("Pebble Beach", "01010", 3.0F);
    }

    @Test
    void getName() {
        assertEquals(this.testCourse.getName(),"Pebble Beach");
    }

    @Test
    void getZipcode() {
        assertEquals(this.testCourse.getZipcode(),"01010");
    }

    @Test
    void getDistance() {
        assertEquals(this.testCourse.getDistance(),3.0);
    }
}