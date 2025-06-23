package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.face.IFaceResultData;

/* loaded from: classes7.dex */
public interface ICaptureResult {
    IFaceResultData getFaceData();

    Bitmap getOriginPhoto();

    Bitmap getOutputPhoto();

    int getPhotoHeight();

    int getPhotoWidth();

    long getTimestamp();

    void release();
}
