package com.superfun.connectivitymonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;

/**
 * Created by CgPanda on 27/10/15.
 */
public class NetworkReceiver extends BroadcastReceiver {

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
            Toast.makeText(context, "WiFi Connected", Toast.LENGTH_LONG).show();
            UnityPlayer.UnitySendMessage("ConnectivityMonitor", "NotifyNetworkType", "wifi");
        }
        else if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE)
        {
            Toast.makeText(context, "Mobile Connected", Toast.LENGTH_LONG).show();
            UnityPlayer.UnitySendMessage("ConnectivityMonitor", "NotifyNetworkType", "mobile");
        }
        else
        {
            Toast.makeText(context, "Lost Connection", Toast.LENGTH_LONG).show();
            UnityPlayer.UnitySendMessage("ConnectivityMonitor", "NotifyNetworkType", "lost");
        }
    }
}
