package com.androidnetworking.interfaces;

import android.graphics.Bitmap;
import com.androidnetworking.error.ANError;

/* loaded from: classes.dex */
public interface BitmapRequestListener {
    void onError(ANError aNError);

    void onResponse(Bitmap bitmap);
}
