package com.example.android.rouxacademy;

public class Course {

    private int courseNumber = 10101;
    private String title = "Designing a Basic Digital Character I";
    private String description = "This course covers the creation of a basic, engaging character model, from concept development through sketching and modeling of the character. Students will be expected to research and pitch a design and background story, creating concept drawings, storyboards, animatics, and a traditional clay maquette. In the modeling portion of the course, you will construct a basic rig with 3D modeling tools, resulting in a fully animate-able character that can be skinned in any major 3D software package.";
    private double credits = 3;

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


}
