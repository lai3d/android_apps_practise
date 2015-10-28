package com.superfun.gallerylibrary;

import android.content.Intent;
import android.database.*;
import android.net.Uri;
import android.provider.MediaStore;
import android.app.Activity;
import android.os.Bundle;
import com.unity3d.player.*;

public class Gallery extends Activity {
    int PHOTO_GALLERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PHOTO_GALLERY);
    }

    // it will fire when user pick photo from gallery
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == RESULT_OK && requestCode == PHOTO_GALLERY && data != null)
        {
            Uri uri = data.getData();
            Cursor cursor = MediaStore.Images.Media.query(getContentResolver(), uri, null, null, null);
            cursor.moveToFirst();
            String photoPath = cursor.getString(0);

            UnityPlayer.UnitySendMessage("Gallery", "OnPhotoPick", photoPath);
            Gallery.this.finish();
        }
    }
}
