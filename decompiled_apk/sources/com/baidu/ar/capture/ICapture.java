package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;

/* loaded from: classes7.dex */
public interface ICapture {
    void capture(ICallbackWith<ICaptureResult> iCallbackWith);

    void sendBase64ImageToLua(String... strArr);

    void sendImageToLua(Bitmap... bitmapArr);

    void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener);

    void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith);
}
