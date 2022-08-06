package com.example.todolistvoicecontrol29032022.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static String saveBitmapInternalStorage(Bitmap bitmapImage, Context context, String nameFile) {
        ContextWrapper contextWrapper = new ContextWrapper(context);
        // path to /data/data/yourapp/app_data/assets/images
        File directory = contextWrapper.getDir("images", Context.MODE_PRIVATE);
        // Create assets
        File bitmapFile = new File(directory, nameFile + ".png");

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(bitmapFile);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    public static Bitmap loadBitmapFromStorage(String path) {
        try {
            File file = new File(path);
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
            return bitmap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File createFileNameRecord(Context context) {
        ContextWrapper contextWrapper = new ContextWrapper(context);
        // path to /data/data/yourapp/app_data/assets/record
        File directory = contextWrapper.getDir("record", Context.MODE_PRIVATE);
        return  new File(directory, System.currentTimeMillis() + ".3gp");
    }
}
