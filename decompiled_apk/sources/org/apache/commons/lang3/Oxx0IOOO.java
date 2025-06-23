package org.apache.commons.lang3;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;

@Deprecated
/* loaded from: classes6.dex */
public class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f32508I0Io = "UTF-16";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f32509II0xO0 = "US-ASCII";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f32510X0o0xo = "UTF-16LE";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f32511XO = "UTF-8";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f32512oIX0oI = "ISO-8859-1";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f32513oxoX = "UTF-16BE";

    @Deprecated
    public static boolean oIX0oI(String str) {
        if (str == null) {
            return false;
        }
        try {
            return Charset.isSupported(str);
        } catch (IllegalCharsetNameException unused) {
            return false;
        }
    }
}
