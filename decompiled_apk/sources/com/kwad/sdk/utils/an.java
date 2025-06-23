package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.provider.Settings;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes11.dex */
public final class an {
    private static Map<String, Integer> aQC;
    private static Set<String> aQD;
    private static Method aQE;

    static {
        HashSet hashSet = new HashSet();
        aQD = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        aQD.add("android.permission.WRITE_SETTINGS");
        aQD.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int aq(Context context, String str) {
        int ar;
        if (aQC == null) {
            h(ak.cD(context));
        }
        if (aQD.contains(str) && (ar = ar(context, str)) != -2) {
            return ar;
        }
        int as = as(context, str);
        if (as != -2) {
            return as;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return as;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0030. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int ar(android.content.Context r4, java.lang.String r5) {
        /*
            r5.hashCode()
            r0 = 23
            r1 = -1
            r2 = 0
            int r3 = r5.hashCode()
            switch(r3) {
                case -2078357533: goto L26;
                case -1561629405: goto L1b;
                case 1777263169: goto L10;
                default: goto Le;
            }
        Le:
            r5 = -1
            goto L30
        L10:
            java.lang.String r3 = "android.permission.REQUEST_INSTALL_PACKAGES"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L19
            goto Le
        L19:
            r5 = 2
            goto L30
        L1b:
            java.lang.String r3 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L24
            goto Le
        L24:
            r5 = 1
            goto L30
        L26:
            java.lang.String r3 = "android.permission.WRITE_SETTINGS"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L2f
            goto Le
        L2f:
            r5 = 0
        L30:
            switch(r5) {
                case 0: goto L52;
                case 1: goto L42;
                case 2: goto L34;
                default: goto L33;
            }
        L33:
            goto L5d
        L34:
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r5 < r0) goto L5d
            boolean r4 = com.kwad.sdk.utils.ak.cC(r4)
            if (r4 == 0) goto L5e
        L40:
            r1 = 0
            goto L5e
        L42:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r0) goto L5d
            boolean r4 = com.alimm.tanx.core.utils.oIX0oI.oIX0oI(r4)     // Catch: java.lang.Throwable -> L4d
            if (r4 == 0) goto L5e
            goto L40
        L4d:
            r4 = move-exception
            com.kwad.sdk.core.e.c.printStackTraceOnly(r4)
            goto L5d
        L52:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r0) goto L5d
            boolean r4 = com.baidu.navisdk.util.common.oIX0oI.oIX0oI(r4)     // Catch: java.lang.Throwable -> L5d
            if (r4 == 0) goto L5e
            goto L40
        L5d:
            r1 = -2
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.an.ar(android.content.Context, java.lang.String):int");
    }

    private static int as(Context context, String str) {
        if (aQC == null || str == null || !aQC.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = aQC.get(str);
            if (num == null) {
                return -2;
            }
            if (aQE == null) {
                Class cls = Integer.TYPE;
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class);
                aQE = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            if (((Integer) aQE.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0) {
                return 0;
            }
            return -1;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return 0;
        }
    }

    public static boolean cE(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i = 0;
        }
        if (i != 1) {
            return false;
        }
        return true;
    }

    private static String gQ(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
        if (lastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(lastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    private static void h(String[] strArr) {
        if (strArr == null) {
            return;
        }
        aQC = new HashMap();
        for (String str : strArr) {
            try {
                Integer num = (Integer) s.c((Class<?>) AppOpsManager.class, "OP_" + gQ(str));
                if (num.intValue() >= 0) {
                    aQC.put(str, num);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
