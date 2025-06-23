package com.baidu.navisdk.bluetooth;

import android.os.Build;

/* loaded from: classes7.dex */
public class a {
    public static boolean a() {
        if (Build.VERSION.SDK_INT > 22) {
            return true;
        }
        return false;
    }
}
