package com.example.calculatrice;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

final class Otls {


    static boolean isNotEmptyString(String text) {
        return (text != null
                && !text.trim().equals("null")
                && text.trim().length() > 0
                && !TextUtils.isEmpty(text.trim()));
    }

    static boolean isValidFloat(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    static boolean isNumberPhone(String s) {
        return Pattern.compile("^\\d{3}\\d{3}\\d{4}$").matcher(s).find();
    }


    static Bitmap screenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return bitmap;
    }

    static void shareUp(Activity activity, String sujet, String body, Bitmap image){
        Intent shareIntent;
        Uri bmpUri = null;
        //Bitmap bitmap= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.ic_launcher);
        if(image != null){
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/Share.png";
            OutputStream out;
            File file=new File(path);
            try {
                out = new FileOutputStream(file);
                image.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            path=file.getPath();
            bmpUri = Uri.parse("file://"+path);
        }

        shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if(image != null) shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, sujet);
        shareIntent.putExtra(Intent.EXTRA_TEXT,body);
        shareIntent.setType(image != null ? "image/png" : "text/plain");
        activity.startActivity(Intent.createChooser(shareIntent,"Share with"));

    }
}
