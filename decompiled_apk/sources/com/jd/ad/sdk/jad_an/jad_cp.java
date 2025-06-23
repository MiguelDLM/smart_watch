package com.jd.ad.sdk.jad_an;

import java.io.File;
import java.io.FileInputStream;

/* loaded from: classes10.dex */
public final class jad_cp {
    public static String jad_an = "";
    public static String jad_bo = "";
    public static String jad_cp = "";
    public static String jad_dq = "";
    public static String jad_er = "";
    public static String jad_fs = "";
    public static String jad_hu = "";
    public static String jad_jt = "";

    public static boolean jad_an() {
        File file = new File("/proc/tty/drivers");
        if (!file.exists() || !file.canRead()) {
            return false;
        }
        byte[] bArr = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new String(bArr).indexOf("goldfish") != -1;
    }

    public static boolean jad_bo() {
        try {
            String[] strArr = {"/dev/socket/qemud", "/dev/qemu_pipe"};
            boolean z = false;
            for (int i = 0; i < 2; i++) {
                if (new File(strArr[i]).exists()) {
                    z = true;
                }
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean jad_cp() {
        try {
            if (!new File("/system/bin/su").exists() && !new File("/system/xbin/su").exists() && !new File("/su/bin/su").exists()) {
                if (!new File("/su/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
