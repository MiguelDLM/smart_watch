package com.baidu.mshield.x0.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.List;

/* loaded from: classes7.dex */
public class c {
    public static int a(Context context, String str, List<String> list) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
        if (b(context, str)) {
            return 0;
        }
        if (list != null && list.size() != 0) {
            boolean z = false;
            for (int i = 0; i < list.size(); i++) {
                String str2 = list.get(i);
                if (!TextUtils.isEmpty(str2)) {
                    File file = new File(str2);
                    if (file.exists()) {
                        PackageInfo a2 = a(context, str);
                        if (a2 != null && a2.firstInstallTime >= file.lastModified()) {
                            return 0;
                        }
                        z = true;
                    } else {
                        continue;
                    }
                }
            }
            return !z ? 2 : 1;
        }
        return 1;
    }

    public static boolean b(Context context, String str) {
        try {
            if (new File(context.getExternalFilesDir(null).getParentFile().getParent() + File.separator + str).exists()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return false;
        }
    }

    public static String[] c(Context context, String str) {
        String[] strArr = {"", "", ""};
        try {
            String parent = context.getExternalFilesDir(null).getParentFile().getParent();
            StringBuilder sb = new StringBuilder();
            sb.append(parent);
            String str2 = File.separator;
            sb.append(str2);
            sb.append(str);
            File file = new File(sb.toString());
            if (file.exists()) {
                strArr[0] = file.getAbsolutePath();
            }
            File file2 = new File(parent + str2 + str + str2 + "files");
            if (file2.exists()) {
                strArr[1] = file2.getAbsolutePath();
            }
            File file3 = new File(parent + str2 + str + str2 + "cache");
            if (file3.exists()) {
                strArr[2] = file3.getAbsolutePath();
            }
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
        return strArr;
    }

    public static PackageInfo a(Context context, String str) {
        try {
            return com.baidu.mshield.b.e.c.a(context, str, 0);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return null;
        }
    }
}
