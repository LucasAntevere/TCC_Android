package com.lucas.antevere.brechlivre.tasks;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.lucas.antevere.brechlivre.R;
import com.lucas.antevere.brechlivre.utils.ImageLoaderAnimation;

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
            return Bitmap.createScaledBitmap(mIcon11, 250, 250, true);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    protected void onPostExecute(Bitmap result) {
        //bmImage.setImageBitmap(result);
        //bmImage.startAnimation(AnimationUtils.loadAnimation(bmImage.getContext(), R.anim.image_show));
        ImageLoaderAnimation.setAnimation(bmImage, result);
    }
}
