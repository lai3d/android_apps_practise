package com.example.cgpanda.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.widget.Toast;


/**
 * Created by CgPanda on 20/10/15.
 */
public class NetworkReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        ConnectivityManager conn = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();

        // Checks the user prefs and the network connection. Based on the result, decides whether
        // to refresh the display or keep the current display.
        // If the userpref is Wi-Fi only, checks to see if the device has a Wi-Fi connection.
        if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI)
        {
            Toast.makeText(context, R.string.wifi_connection, Toast.LENGTH_SHORT).show();
        }
        else if(networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE)
        {
            Toast.makeText(context, R.string.mobile_connection, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, R.string.lost_connection, Toast.LENGTH_SHORT).show();
        }
    }

}