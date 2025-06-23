package com.baidu.navisdk.util.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* loaded from: classes8.dex */
public class b {
    public static Bitmap a(byte[] bArr) {
        try {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap a(String str) {
        try {
            return BitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
