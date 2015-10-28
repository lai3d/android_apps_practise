package com.superfun.gallerylibrary;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by CgPanda on 26/10/15.
 */
public class UnityBinder {

    public static void OpenGallery(Activity activity)
    {
        Intent intent = new Intent(activity, Gallery.class);
        activity.startActivity(intent);
    }
}
