package com.afusion.mobilegame.liarsdice2;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity {

    private NetworkReceiver receiver = new NetworkReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        receiver = new NetworkReceiver();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        this.registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if(receiver != null)
            this.unregisterReceiver(receiver);
    }
}
