package com.baidu.ar.arplay.core.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.lang.ref.SoftReference;

/* loaded from: classes7.dex */
public class ARPFilter {
    private static final String TAG = "ARPFilter";
    private SoftReference<Context> softContext = null;

    private native void nativeAdjustFilterWithAssetTextureParam(String str, String str2, Bitmap bitmap);

    private native String nativeAdjustFilterWithCasePathParam(String str);

    private native void nativeAdjustFilterWithFloatArrayParam(String str, String str2, float[] fArr);

    private native void nativeAdjustFilterWithFloatParam(String str, String str2, float f);

    private native void nativeAdjustFilterWithIntParam(String str, String str2, int i);

    private native String nativeAdjustFilterWithJsonPathParam(String str);

    private native void nativeAdjustFilterWithStringParam(String str, String str2, String str3);

    private native void nativeDisableCaseLutTexture();

    private native void nativeDisableFilterByAuthCode(int i);

    private native void nativeSetAuthPic(Bitmap bitmap, float[] fArr);

    private native void nativeSetWatermark(String str, Bitmap bitmap, float[] fArr);

    public String adjustFilterWithCasePathParam(String str) {
        return nativeAdjustFilterWithCasePathParam(str);
    }

    public void adjustFilterWithFloatArrayParam(String str, String str2, float[] fArr, long j) {
        nativeAdjustFilterWithFloatArrayParam(str, str2, fArr);
    }

    public void adjustFilterWithFloatParam(String str, String str2, float f, long j) {
        nativeAdjustFilterWithFloatParam(str, str2, f);
    }

    public void adjustFilterWithIntParam(String str, String str2, int i, long j) {
        nativeAdjustFilterWithIntParam(str, str2, i);
    }

    public String adjustFilterWithJsonPathParam(String str) {
        return nativeAdjustFilterWithJsonPathParam(str);
    }

    public void adjustFilterWithStringParam(String str, String str2, String str3, long j) {
        SoftReference<Context> softReference;
        Bitmap bitmap;
        if (!str3.contains("android_asset") || (softReference = this.softContext) == null || softReference.get() == null || this.softContext.get().getAssets() == null) {
            nativeAdjustFilterWithStringParam(str, str2, str3);
            return;
        }
        try {
            bitmap = BitmapFactory.decodeStream(this.softContext.get().getAssets().open(str3.substring(str3.lastIndexOf("android_asset") + 14)));
        } catch (IOException e) {
            e.printStackTrace();
            bitmap = null;
        }
        if (bitmap != null) {
            String str4 = "texture_width";
            String str5 = "texture_height";
            String str6 = "texture_byte_array";
            if (str2.contains("/")) {
                String substring = str2.substring(0, str2.lastIndexOf("/") + 1);
                str4 = substring + "texture_width";
                str5 = substring + "texture_height";
                str6 = substring + "texture_byte_array";
            }
            nativeAdjustFilterWithFloatParam(str, str4, bitmap.getWidth());
            nativeAdjustFilterWithFloatParam(str, str5, bitmap.getHeight());
            nativeAdjustFilterWithAssetTextureParam(str, str6, bitmap);
            bitmap.recycle();
        }
    }

    public void destroy() {
        SoftReference<Context> softReference = this.softContext;
        if (softReference != null) {
            softReference.clear();
            this.softContext = null;
        }
    }

    public void disableCaseLutTexture() {
        nativeDisableCaseLutTexture();
    }

    public void disableFilterByAuthCode(int i) {
        nativeDisableFilterByAuthCode(i);
    }

    public void setAuthPic(Bitmap bitmap, float[] fArr) {
        nativeSetAuthPic(bitmap, fArr);
    }

    public void setContext(SoftReference<Context> softReference) {
        if (softReference != null) {
            this.softContext = softReference;
        }
    }

    public void setWatermark(String str, Bitmap bitmap, float[] fArr) {
        nativeSetWatermark(str, bitmap, fArr);
    }
}
