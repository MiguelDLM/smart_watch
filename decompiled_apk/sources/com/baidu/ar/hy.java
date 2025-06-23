package com.baidu.ar;

import java.io.File;

/* loaded from: classes7.dex */
public class hy {
    private static final String TAG = "hy";

    public static void bu(String str) {
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean bv(String str) {
        return new File(str).delete();
    }
}
