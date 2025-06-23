package com.baidu.navisdk.util.common;

import androidx.annotation.NonNull;

/* loaded from: classes8.dex */
public class d0 {
    @NonNull
    public static <T> T a(T t, Object obj) {
        if (t == null && LogUtil.LOGGABLE) {
            LogUtil.e("Preconditions", "checkNotNull --> reference = " + t + ", errorMessage = " + obj);
            LogUtil.printException(String.valueOf(obj), new NullPointerException(String.valueOf(obj)));
        }
        return t;
    }
}
