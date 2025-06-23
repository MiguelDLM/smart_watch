package com.baidu.nplatform.comapi.map;

import android.graphics.Bitmap;
import com.baidu.navisdk.jni.nativeif.JNISDKMap;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes8.dex */
public class k {
    private static final String b = "k";

    /* renamed from: a, reason: collision with root package name */
    private JNISDKMap f9518a = null;

    public void a() {
        if (this.f9518a == null) {
            this.f9518a = new JNISDKMap();
        }
    }

    public void b() {
        this.f9518a = null;
    }

    public boolean a(Bitmap bitmap, int i) {
        if (this.f9518a != null && com.baidu.navisdk.module.init.a.a() && bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int byteCount = (bitmap.getByteCount() * 8) / (width * height);
            byte[] a2 = a(bitmap);
            if (a2 != null && bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && byteCount > 0) {
                return a(width, height, a2, bitmap.getByteCount(), byteCount, i);
            }
            LogUtil.e(b, "setDIYImageToMap --> width=" + width + ", height= " + height + ", bits=" + byteCount + ", length=" + bitmap.getByteCount());
        }
        return false;
    }

    private static byte[] a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
        return byteArray;
    }

    private boolean a(int i, int i2, byte[] bArr, int i3, int i4, int i5) {
        if (this.f9518a == null || !com.baidu.navisdk.module.init.a.a()) {
            return false;
        }
        boolean SetDIYImageToMap = this.f9518a.SetDIYImageToMap(i, i2, bArr, i3, i4, i5);
        LogUtil.e(b, "setRouteSearchStatus: imgWidth = " + i + ", imgHeight = " + i2 + ", imageData = , imageLen = " + i3 + ", bits = " + i4 + ", imageType = " + i5 + ",result = " + SetDIYImageToMap);
        return SetDIYImageToMap;
    }

    public boolean a(int i) {
        if (this.f9518a == null || !com.baidu.navisdk.module.init.a.a()) {
            return false;
        }
        boolean ClearDIYImage = this.f9518a.ClearDIYImage(i);
        LogUtil.e(b, "setRouteSearchStatus: imageType = " + i + ",result = " + ClearDIYImage);
        return ClearDIYImage;
    }

    public boolean a(boolean z, int i) {
        if (this.f9518a == null || !com.baidu.navisdk.module.init.a.a()) {
            return false;
        }
        boolean SetDIYImageStatus = this.f9518a.SetDIYImageStatus(z, i);
        LogUtil.e(b, "setRouteSearchStatus: status = " + z + ", imageType = " + i + ",result = " + SetDIYImageStatus);
        return SetDIYImageStatus;
    }

    public boolean a(boolean z) {
        if (this.f9518a == null || !com.baidu.navisdk.module.init.a.a()) {
            return false;
        }
        boolean SetPreOrderMode = this.f9518a.SetPreOrderMode(z);
        LogUtil.e(b, "setPreOrderMode: preOrderMode = " + z);
        return SetPreOrderMode;
    }
}
