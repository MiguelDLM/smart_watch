package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes8.dex */
public final class c {
    public static String[] a(File file) {
        String[] a2 = com.bytedance.pangle.util.a.b.a(file);
        if (TextUtils.isEmpty(a2[0])) {
            return com.bytedance.pangle.util.a.a.a(file);
        }
        return a2;
    }
}
