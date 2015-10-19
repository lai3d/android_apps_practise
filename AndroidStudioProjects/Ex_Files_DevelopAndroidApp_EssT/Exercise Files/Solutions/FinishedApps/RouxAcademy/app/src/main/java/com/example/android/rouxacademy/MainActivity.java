package com.example.android.rouxacademy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    protected List<Course> courseData;

    protected Course aCourse;
    public final static String EXTRA_COURSE_NUMBER = "EXTRA_COURSE_NUMBER";
    public final static String EXTRA_TITLE = "EXTRA_TITLE";
    public final static String EXTRA_DESC = "EXTRA_DESC";
    public final static String EXTRA_IMAGE = "EXTRA_IMAGE";
    public final static String EXTRA_CREDITS = "EXTRA_CREDITS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(getResources().getString(R.string.roux_academy));

        courseData = DataManager.getData();

        ArrayAdapter<Course> myAdapter = new ArrayAdapter <>(this,
                android.R.layout.simple_list_item_1, courseData);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = courseData.get(position);
                displayDetail(course);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_display_detail) {
            displayDetail(courseData.get(0));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayDetail(Course course) {

        Intent intent = new Intent(this, CourseDetailActivity.class);
        intent.putExtra(EXTRA_COURSE_NUMBER, course.getCourseNumber());
        intent.putExtra(EXTRA_TITLE, course.getTitle());
        intent.putExtra(EXTRA_DESC, course.getDescription());
        intent.putExtra(EXTRA_IMAGE, course.getImageName());
        intent.putExtra(EXTRA_CREDITS, course.getCredits());

        startActivity(intent);
    }

}
