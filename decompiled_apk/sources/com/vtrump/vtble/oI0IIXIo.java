package com.vtrump.vtble;

import java.util.HashMap;

/* loaded from: classes13.dex */
public class oI0IIXIo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final oI0IIXIo f27493oIX0oI = new oI0IIXIo();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static HashMap<String, StringBuffer> f27492II0xO0 = new HashMap<>();

    public static String I0Io(String str) {
        StringBuffer stringBuffer = f27492II0xO0.get(str);
        return stringBuffer == null ? "" : stringBuffer.toString();
    }

    public static oI0IIXIo II0xO0() {
        return f27493oIX0oI;
    }

    public static void oIX0oI(String str, String str2, boolean z) {
        if (z) {
            f27492II0xO0.put(str, new StringBuffer());
        }
        StringBuffer stringBuffer = f27492II0xO0.get(str);
        if (stringBuffer == null) {
            stringBuffer = new StringBuffer();
        }
        if (stringBuffer.length() == 0) {
            stringBuffer.append(" -------> ");
        }
        stringBuffer.append(str2);
    }
}
