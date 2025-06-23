package com.baidu.navisdk.util.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* loaded from: classes8.dex */
public class k {
    public static Bitmap a(String str) {
        try {
            return BitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
