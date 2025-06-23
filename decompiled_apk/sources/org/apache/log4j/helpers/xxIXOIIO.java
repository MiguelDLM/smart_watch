package org.apache.log4j.helpers;

import java.io.PrintStream;

/* loaded from: classes6.dex */
public class xxIXOIIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static boolean f33331I0Io = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f33332II0xO0 = "log4j.configDebug";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f33333Oxx0IOOO = "log4j:WARN ";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f33334X0o0xo = "log4j: ";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f33335XO = "log4j:ERROR ";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33336oIX0oI = "log4j.debug";

    /* renamed from: oxoX, reason: collision with root package name */
    public static boolean f33337oxoX = false;

    static {
        String X0o0xo2 = oOoXoXO.X0o0xo(f33336oIX0oI, null);
        if (X0o0xo2 == null) {
            X0o0xo2 = oOoXoXO.X0o0xo(f33332II0xO0, null);
        }
        if (X0o0xo2 != null) {
            f33331I0Io = oOoXoXO.xoIox(X0o0xo2, true);
        }
    }

    public static void I0Io(String str) {
        if (f33337oxoX) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f33335XO);
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
    }

    public static void II0XooXoX(String str, Throwable th) {
        if (f33337oxoX) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f33333Oxx0IOOO);
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
        if (th != null) {
            th.printStackTrace();
        }
    }

    public static void II0xO0(String str, Throwable th) {
        if (f33331I0Io && !f33337oxoX) {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(f33334X0o0xo);
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
            if (th != null) {
                th.printStackTrace(printStream);
            }
        }
    }

    public static void Oxx0IOOO(String str) {
        if (f33337oxoX) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f33333Oxx0IOOO);
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
    }

    public static void X0o0xo(boolean z) {
        f33331I0Io = z;
    }

    public static void XO(boolean z) {
        f33337oxoX = z;
    }

    public static void oIX0oI(String str) {
        if (f33331I0Io && !f33337oxoX) {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(f33334X0o0xo);
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
        }
    }

    public static void oxoX(String str, Throwable th) {
        if (f33337oxoX) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f33335XO);
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
        if (th != null) {
            th.printStackTrace();
        }
    }
}
