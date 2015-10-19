package com.example.android.rouxacademy;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;


public class CourseDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Intent intent = getIntent();
        Course course = new Course(intent);

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(course.getTitle());

        TextView tvDesc = (TextView) findViewById(R.id.tvDescription);
        tvDesc.setText(course.getDescription());

        TextView tvCourseNumber = (TextView) findViewById(R.id.tvCourseNumber);
        tvCourseNumber.setText("Course #: " + course.getCourseNumber());

        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumFractionDigits(1);
        TextView tvCredits = (TextView) findViewById(R.id.tvCredits);
        tvCredits.setText("Credits: " + formatter.format(course.getCredits()));

        int imageId = getResources().getIdentifier(
                course.getImageName(), "drawable", getPackageName());
        if (imageId != 0) {
            ImageView iv = (ImageView) findViewById(R.id.imageView);
            iv.setImageResource(imageId);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
