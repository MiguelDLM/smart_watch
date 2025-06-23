package org.apache.commons.lang3;

import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public class OOXIXo {
    public static String I0Io(String str) {
        if (str == null) {
            return Charset.defaultCharset().name();
        }
        return str;
    }

    public static Charset II0xO0(Charset charset) {
        if (charset == null) {
            return Charset.defaultCharset();
        }
        return charset;
    }

    public static Charset oIX0oI(String str) {
        if (str == null) {
            return Charset.defaultCharset();
        }
        return Charset.forName(str);
    }
}
