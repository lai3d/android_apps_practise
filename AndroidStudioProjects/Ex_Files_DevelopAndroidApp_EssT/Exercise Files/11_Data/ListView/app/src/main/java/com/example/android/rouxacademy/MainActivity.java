package com.example.android.rouxacademy;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    public static final String COURSE_TITLE = "courseTitle";
    public static final int DETAIL_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Course> data = DataProvider.getData();
        Iterator<Course> iterator = data.iterator();

        StringBuilder builder = new StringBuilder();

        while (iterator.hasNext()) {
            Course course = iterator.next();
            builder.append(course.getTitle())
                   .append("\n");
        }

        TextView tv = (TextView) findViewById(R.id.tvCourseList);
        tv.setText(builder.toString());
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
