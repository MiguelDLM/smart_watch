package com.baidu.navisdk.util.common;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class h0 {
    public static String a() {
        return m0.j().e();
    }

    public static long b() {
        try {
            if (d() == 0) {
                StatFs c = c();
                return c.getBlockSizeLong() * c.getFreeBlocksLong();
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    private static StatFs c() {
        if (TextUtils.isEmpty(m0.j().e())) {
            return new StatFs(Environment.getExternalStorageDirectory().getPath());
        }
        try {
            return new StatFs(m0.j().e());
        } catch (Exception unused) {
            return new StatFs(Environment.getExternalStorageDirectory().getPath());
        }
    }

    public static int d() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState == null || "bad_removal".equals(externalStorageState)) {
            return 2;
        }
        if ("checking".equals(externalStorageState) || "mounted".equals(externalStorageState)) {
            return 0;
        }
        if ("mounted_ro".equals(externalStorageState) || "nofs".equals(externalStorageState)) {
            return 2;
        }
        if ("removed".equals(externalStorageState) || "shared".equals(externalStorageState)) {
            return 3;
        }
        if ("unmountable".equals(externalStorageState)) {
            return 2;
        }
        if (!"unmounted".equals(externalStorageState)) {
            return 0;
        }
        return 3;
    }
}
