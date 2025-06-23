package com.baidu.ar;

import java.io.PrintStream;

/* loaded from: classes7.dex */
public final class qd {
    private static a KA = null;
    private static boolean KB = false;

    /* loaded from: classes7.dex */
    public static final class a extends SecurityManager {
        private a() {
        }

        @Override // java.lang.SecurityManager
        public Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private qd() {
    }

    public static final void c(String str, Throwable th) {
        PrintStream printStream = System.err;
        printStream.println(str);
        printStream.println("Reported exception:");
        th.printStackTrace();
    }

    public static String cT(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean cU(String str) {
        String cT = cT(str);
        if (cT == null) {
            return false;
        }
        return cT.equalsIgnoreCase("true");
    }

    public static final void cV(String str) {
        System.err.println("SLF4J: " + str);
    }

    private static a kk() {
        a aVar = KA;
        if (aVar != null) {
            return aVar;
        }
        if (KB) {
            return null;
        }
        a kl = kl();
        KA = kl;
        KB = true;
        return kl;
    }

    private static a kl() {
        try {
            return new a();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static Class<?> km() {
        int i;
        a kk = kk();
        if (kk == null) {
            return null;
        }
        Class<?>[] classContext = kk.getClassContext();
        String name = qd.class.getName();
        int i2 = 0;
        while (i2 < classContext.length && !name.equals(classContext[i2].getName())) {
            i2++;
        }
        if (i2 >= classContext.length || (i = i2 + 2) >= classContext.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classContext[i];
    }
}
