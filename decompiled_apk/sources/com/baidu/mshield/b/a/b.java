package com.baidu.mshield.b.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes7.dex */
public class b {
    public static String[] a(String str) {
        String[] strArr = {"", "", "", ""};
        try {
            File file = new File(str);
            if (file.exists()) {
                if (Build.VERSION.SDK_INT <= 22) {
                    strArr[2] = a(file.lastModified(), "yyyy-MM-dd HH:mm:ss");
                    return strArr;
                }
                for (String str2 : f.a("stat " + file.getAbsolutePath(), false).b.split("\\|")) {
                    if (str2.contains("Device")) {
                        String[] split = str2.split("Inode:");
                        if (split.length > 1) {
                            String[] split2 = split[1].split("Links");
                            if (split2.length > 0) {
                                strArr[0] = split2[0].trim();
                            }
                        }
                    }
                    if (str2.contains("Access") && !str2.contains(JNISearchConst.KEY_UID)) {
                        com.baidu.mshield.b.c.a.b("access " + str2);
                        String[] split3 = str2.split("Access:");
                        if (split3.length > 1) {
                            strArr[1] = split3[1].trim();
                        }
                    }
                    if (str2.contains("Modify")) {
                        com.baidu.mshield.b.c.a.b("Modify " + str2);
                        String[] split4 = str2.split("Modify:");
                        if (split4.length > 1) {
                            strArr[2] = split4[1].trim();
                        }
                    }
                    if (str2.contains("Change")) {
                        com.baidu.mshield.b.c.a.b("Change " + str2);
                        String[] split5 = str2.split("Change:");
                        if (split5.length > 1) {
                            strArr[3] = split5[1].trim();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
        return strArr;
    }

    public static String a(long j, String str) {
        if (j >= 0) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return new SimpleDateFormat(str).format(new Date(j));
                }
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
            }
        }
        return "";
    }
}
