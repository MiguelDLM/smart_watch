package com.baidu.location.c.b;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class b implements a {
    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            if (a.c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String b(android.content.Context r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 28
            if (r0 > r2) goto L20
            java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Exception -> L1c
            java.lang.String r3 = "mounted"
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Exception -> L1c
            if (r0 == 0) goto L20
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L1c
            java.lang.String r0 = r0.getPath()     // Catch: java.lang.Exception -> L1c
            goto L21
        L1c:
            r0 = move-exception
            r0.printStackTrace()
        L20:
            r0 = r1
        L21:
            if (r0 != 0) goto L36
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 <= r2) goto L36
            if (r4 == 0) goto L36
            java.lang.String r0 = android.os.Environment.DIRECTORY_MOVIES     // Catch: java.lang.Exception -> L34
            java.io.File r4 = r4.getExternalFilesDir(r0)     // Catch: java.lang.Exception -> L34
            java.lang.String r0 = r4.getAbsolutePath()     // Catch: java.lang.Exception -> L34
            goto L36
        L34:
            r0 = r1
        L36:
            if (r0 == 0) goto L5d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L58
            r4.<init>()     // Catch: java.lang.Exception -> L58
            r4.append(r0)     // Catch: java.lang.Exception -> L58
            java.lang.String r2 = "/baidu/tempdata"
            r4.append(r2)     // Catch: java.lang.Exception -> L58
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L58
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> L58
            r2.<init>(r4)     // Catch: java.lang.Exception -> L58
            boolean r4 = r2.exists()     // Catch: java.lang.Exception -> L58
            if (r4 != 0) goto L5d
            r2.mkdirs()     // Catch: java.lang.Exception -> L58
            goto L5d
        L58:
            r4 = move-exception
            r4.printStackTrace()
            goto L5e
        L5d:
            r1 = r0
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.b.b.b(android.content.Context):java.lang.String");
    }

    public static int a(Object obj, String str) throws Exception {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, null)).intValue();
    }

    public static String a(Context context) {
        String b = b(context);
        if (b == null) {
            return null;
        }
        return b + "/baidu/tempdata";
    }
}
