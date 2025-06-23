package org.apache.log4j.helpers;

/* loaded from: classes6.dex */
public class oI0IIXIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f33268I0Io = "]]&gt;";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f33269II0xO0 = "]]>";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f33270X0o0xo = 3;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33271oIX0oI = "<![CDATA[";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f33272oxoX = "]]>]]&gt;<![CDATA[";

    public static String II0xO0(String str) {
        if (str != null && str.length() != 0) {
            StringBuffer stringBuffer = new StringBuffer(str.length() + 6);
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == '<') {
                    stringBuffer.append("&lt;");
                } else if (charAt == '>') {
                    stringBuffer.append("&gt;");
                } else {
                    stringBuffer.append(charAt);
                }
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public static void oIX0oI(StringBuffer stringBuffer, String str) {
        if (str == null) {
            stringBuffer.append("");
            return;
        }
        int indexOf = str.indexOf(f33269II0xO0);
        if (indexOf < 0) {
            stringBuffer.append(str);
            return;
        }
        int i = 0;
        while (indexOf > -1) {
            stringBuffer.append(str.substring(i, indexOf));
            stringBuffer.append(f33272oxoX);
            i = f33270X0o0xo + indexOf;
            if (i < str.length()) {
                indexOf = str.indexOf(f33269II0xO0, i);
            } else {
                return;
            }
        }
        stringBuffer.append(str.substring(i));
    }
}
