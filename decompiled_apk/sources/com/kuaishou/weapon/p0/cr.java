package com.kuaishou.weapon.p0;

/* loaded from: classes11.dex */
public class cr {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f18363a = false;
    private static volatile boolean b = true;

    static {
        try {
            f18363a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", null).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", null).invoke(null, null), null)).booleanValue();
        } catch (Exception unused) {
            f18363a = false;
        }
        b = System.getProperty("java.vm.version").startsWith("2");
    }

    public static boolean a() {
        return f18363a;
    }

    public static boolean b() {
        return b;
    }
}
