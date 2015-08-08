package com.example.firsttask.Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by HP PROBOOK 450 on 4/28/2015.
 */

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;


    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    @Override


    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon = null;

        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon = BitmapFactory.decodeStream(in);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        return mIcon;

    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    protected void onPostExecute(Bitmap result) {

        bmImage.setImageBitmap(result);

    }
}

