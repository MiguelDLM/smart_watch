package com.baidu.platform.comapi.walknavi.e.a.g;

import java.io.File;

/* loaded from: classes8.dex */
public final class c {
    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            try {
                file.mkdirs();
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        return true;
    }
}
