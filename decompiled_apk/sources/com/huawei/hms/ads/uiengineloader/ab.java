package com.huawei.hms.ads.uiengineloader;

import OI0.oxoX;

/* loaded from: classes10.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17330a = "EmuiUtil";
    private static final String b = "EMUI_SDK_INT";
    private static final String c = "com.huawei.android.os.BuildEx$VERSION";
    private static final int d = -1;
    private static final int e = 7;
    private static final int f = 8;
    private static final int g = 9;
    private static final int h = 10;
    private static final int i = 11;
    private static final int j = 14;
    private static final int k = 15;
    private static final int l = 17;
    private static final int m = 30;
    private static final int n = 31;
    private static final int o = 40;
    private static final int p = 41;
    private static final int q = 50;
    private static final int r = 60;
    private static final int s = 81;
    private static final int t = 90;
    private static int u = -1;
    private static int v = d();

    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.ab.<clinit>():void");
    }

    public static boolean a() {
        return u == 50;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b() {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.ab.b():void");
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, oxoX.f1509II0XooXoX);
            af.a(f17330a, "isNeed2UseHwEmui :");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    u = 30;
                    return;
                }
                if (str.contains("EmotionUI_3.1")) {
                    u = 31;
                    return;
                }
                if (str.contains("EmotionUI_4.0")) {
                    u = 40;
                    return;
                }
                if (str.contains("EmotionUI_4.1")) {
                    u = 41;
                    return;
                }
                if (str.contains("EmotionUI_5.0")) {
                    u = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    u = 60;
                } else {
                    u = -1;
                }
            }
        } catch (Throwable th) {
            af.d(f17330a, "dealTypeUnknow Exception:" + th.getClass().getSimpleName());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int d() {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "EmuiUtil"
            java.lang.String r3 = "com.huawei.android.os.BuildEx$VERSION"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L22 java.lang.NoSuchFieldException -> L25 java.lang.IllegalAccessException -> L28 java.lang.ClassNotFoundException -> L2b
            java.lang.String r4 = "EMUI_SDK_INT"
            java.lang.reflect.Field r4 = r3.getDeclaredField(r4)     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L22 java.lang.NoSuchFieldException -> L25 java.lang.IllegalAccessException -> L28 java.lang.ClassNotFoundException -> L2b
            java.lang.reflect.Field[] r5 = new java.lang.reflect.Field[r1]     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L22 java.lang.NoSuchFieldException -> L25 java.lang.IllegalAccessException -> L28 java.lang.ClassNotFoundException -> L2b
            r5[r0] = r4     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L22 java.lang.NoSuchFieldException -> L25 java.lang.IllegalAccessException -> L28 java.lang.ClassNotFoundException -> L2b
            java.lang.reflect.AccessibleObject.setAccessible(r5, r1)     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L22 java.lang.NoSuchFieldException -> L25 java.lang.IllegalAccessException -> L28 java.lang.ClassNotFoundException -> L2b
            java.lang.Object r1 = r4.get(r3)     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L22 java.lang.NoSuchFieldException -> L25 java.lang.IllegalAccessException -> L28 java.lang.ClassNotFoundException -> L2b
            goto L2f
        L1c:
            java.lang.String r1 = "getEMUIVersionCode exception "
        L1e:
            com.huawei.hms.ads.uiengineloader.af.c(r2, r1)
            goto L2e
        L22:
            java.lang.String r1 = "getEMUIVersionCode SecurityException"
            goto L1e
        L25:
            java.lang.String r1 = "getEMUIVersionCode NoSuchFieldException"
            goto L1e
        L28:
            java.lang.String r1 = "getEMUIVersionCode IllegalAccessException"
            goto L1e
        L2b:
            java.lang.String r1 = "getEMUIVersionCode ClassNotFoundException"
            goto L1e
        L2e:
            r1 = 0
        L2f:
            boolean r2 = r1 instanceof java.lang.Integer
            if (r2 != 0) goto L34
            return r0
        L34:
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r0 = r1.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.ab.d():int");
    }
}
