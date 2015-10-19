package com.example.android.rouxacademy;

import android.content.Intent;

public class Course {

    private int courseNumber;

    private String title;
    private String description;
    private double credits;

    public Course(int courseNumber, String title, String description, double credits) {
        this.courseNumber = courseNumber;
        this.title = title;
        this.description = description;
        this.credits = credits;
    }

    public Course(Intent intent) {
        courseNumber = intent.getIntExtra(MainActivity.EXTRA_COURSE_NUMBER, 0);
        title = intent.getStringExtra(MainActivity.EXTRA_TITLE);
        description = intent.getStringExtra(MainActivity.EXTRA_DESC);
        credits = intent.getDoubleExtra(MainActivity.EXTRA_CREDITS, 0);
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getCredits() {
        return credits;
    }

    public String getImageName() {
        return "image_" + courseNumber;
    }

    @Override
    public String toString() {
        return title;
    }
}
