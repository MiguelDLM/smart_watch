package org.apache.commons.text;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import o0oIxXOx.OxxIIOOXO;
import o0oIxXOx.XIxXXX0x0;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class ooOOo0oXI {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f33072OOXIXo = ":-";

    /* renamed from: oO, reason: collision with root package name */
    public static final xOx.Oxx0IOOO f33073oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f33074oOoXoXO = "}";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f33075ooOOo0oXI = "${";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final xOx.Oxx0IOOO f33076x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final xOx.Oxx0IOOO f33077x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final char f33078xoIox = '$';

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f33079I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public xOx.Oxx0IOOO f33080II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f33081II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public xOx.Oxx0IOOO f33082Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public xOx.Oxx0IOOO f33083X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f33084XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f33085oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public char f33086oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public OxxIIOOXO f33087xxIXOIIO;

    /* loaded from: classes6.dex */
    public static final class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f33088II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final boolean f33089oIX0oI;

        public String toString() {
            return "Result [altered=" + this.f33089oIX0oI + ", lengthChange=" + this.f33088II0xO0 + "]";
        }

        public II0xO0(boolean z, int i) {
            this.f33089oIX0oI = z;
            this.f33088II0xO0 = i;
        }
    }

    static {
        xOx.II0XooXoX iI0XooXoX = xOx.II0XooXoX.f34478I0Io;
        f33076x0XOIxOo = iI0XooXoX.oOoXoXO(f33075ooOOo0oXI);
        f33073oO = iI0XooXoX.oOoXoXO(f33074oOoXoXO);
        f33077x0xO0oo = iI0XooXoX.oOoXoXO(f33072OOXIXo);
    }

    public ooOOo0oXI() {
        this((OxxIIOOXO) null, f33076x0XOIxOo, f33073oO, '$');
    }

    public static ooOOo0oXI II0xO0() {
        return new ooOOo0oXI(XIxXXX0x0.f31171oIX0oI.x0xO0oo());
    }

    public static String Oo(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return oO(obj, hashMap);
    }

    public static <V> String oO(Object obj, Map<String, V> map) {
        return new ooOOo0oXI(map).x0XOIxOo(obj);
    }

    public static <V> String x0xO0oo(Object obj, Map<String, V> map, String str, String str2) {
        return new ooOOo0oXI(map, str, str2).x0XOIxOo(obj);
    }

    public static String xXxxox0I(Object obj) {
        return new ooOOo0oXI(XIxXXX0x0.f31171oIX0oI.XxX0x0xxx()).x0XOIxOo(obj);
    }

    public char I0Io() {
        return this.f33086oxoX;
    }

    public boolean I0oOoX(TextStringBuilder textStringBuilder, int i, int i2) {
        return XX(textStringBuilder, i, i2, null).f33089oIX0oI;
    }

    public boolean II0XooXoX() {
        return this.f33085oIX0oI;
    }

    public String IIX0o(String str, TextStringBuilder textStringBuilder, int i, int i2) {
        OxxIIOOXO oxoX2 = oxoX();
        if (oxoX2 == null) {
            return null;
        }
        return oxoX2.lookup(str);
    }

    public String IIXOooo(TextStringBuilder textStringBuilder) {
        if (textStringBuilder == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(textStringBuilder.length()).append(textStringBuilder);
        I0oOoX(append, 0, append.length());
        return append.toString();
    }

    public ooOOo0oXI IO(char c) {
        return x0o(xOx.II0XooXoX.f34478I0Io.II0xO0(c));
    }

    public String IXxxXO(String str) {
        if (str == null) {
            return null;
        }
        TextStringBuilder textStringBuilder = new TextStringBuilder(str);
        if (!I0oOoX(textStringBuilder, 0, str.length())) {
            return str;
        }
        return textStringBuilder.toString();
    }

    public ooOOo0oXI Io(String str) {
        boolean z;
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Variable suffix must not be null!", new Object[0]);
        return o0(xOx.II0XooXoX.f34478I0Io.oOoXoXO(str));
    }

    public ooOOo0oXI IoOoX(boolean z) {
        this.f33084XO = z;
        return this;
    }

    public boolean O0xOxO(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return X0IIOO(stringBuffer, 0, stringBuffer.length());
    }

    public ooOOo0oXI OI0(char c) {
        return o0(xOx.II0XooXoX.f34478I0Io.II0xO0(c));
    }

    public boolean OOXIXo() {
        return this.f33084XO;
    }

    public String OxI(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(cArr, i, i2);
        I0oOoX(append, 0, i2);
        return append.toString();
    }

    public xOx.Oxx0IOOO Oxx0IOOO() {
        return this.f33082Oxx0IOOO;
    }

    public String Oxx0xo(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(str, i, i2);
        if (!I0oOoX(append, 0, i2)) {
            return str.substring(i, i2 + i);
        }
        return append.toString();
    }

    public String OxxIIOOXO(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(stringBuffer, i, i2);
        I0oOoX(append, 0, i2);
        return append.toString();
    }

    public ooOOo0oXI X00IoxXI(xOx.Oxx0IOOO oxx0IOOO) {
        this.f33080II0XooXoX = oxx0IOOO;
        return this;
    }

    public boolean X0IIOO(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return false;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(stringBuffer, i, i2);
        if (!I0oOoX(append, 0, i2)) {
            return false;
        }
        stringBuffer.replace(i, i2 + i, append.toString());
        return true;
    }

    public xOx.Oxx0IOOO X0o0xo() {
        return this.f33080II0XooXoX;
    }

    public boolean XI0IXoo(StringBuilder sb) {
        if (sb == null) {
            return false;
        }
        return XIxXXX0x0(sb, 0, sb.length());
    }

    public boolean XIxXXX0x0(StringBuilder sb, int i, int i2) {
        if (sb == null) {
            return false;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(sb, i, i2);
        if (!I0oOoX(append, 0, i2)) {
            return false;
        }
        sb.replace(i, i2 + i, append.toString());
        return true;
    }

    public xOx.Oxx0IOOO XO() {
        return this.f33083X0o0xo;
    }

    public ooOOo0oXI XOxIOxOx(OxxIIOOXO oxxIIOOXO) {
        this.f33087xxIXOIIO = oxxIIOOXO;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.apache.commons.text.ooOOo0oXI.II0xO0 XX(org.apache.commons.text.TextStringBuilder r28, int r29, int r30, java.util.List<java.lang.String> r31) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.text.ooOOo0oXI.XX(org.apache.commons.text.TextStringBuilder, int, int, java.util.List):org.apache.commons.text.ooOOo0oXI$II0xO0");
    }

    public ooOOo0oXI Xx000oIo(String str) {
        if (str != null && str.length() != 0) {
            return X00IoxXI(xOx.II0XooXoX.f34478I0Io.oOoXoXO(str));
        }
        X00IoxXI(null);
        return this;
    }

    public boolean XxX0x0xxx(TextStringBuilder textStringBuilder, int i, int i2) {
        if (textStringBuilder == null) {
            return false;
        }
        return I0oOoX(textStringBuilder, i, i2);
    }

    public ooOOo0oXI o0(xOx.Oxx0IOOO oxx0IOOO) {
        boolean z;
        if (oxx0IOOO != null) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Variable suffix matcher must not be null!", new Object[0]);
        this.f33082Oxx0IOOO = oxx0IOOO;
        return this;
    }

    public String o00(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(cArr.length).append(cArr);
        I0oOoX(append, 0, cArr.length);
        return append.toString();
    }

    public String oI0IIXIo(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(stringBuffer.length()).append(stringBuffer);
        I0oOoX(append, 0, append.length());
        return append.toString();
    }

    public final void oIX0oI(String str, List<String> list) {
        if (!list.contains(str)) {
            return;
        }
        TextStringBuilder textStringBuilder = new TextStringBuilder(256);
        textStringBuilder.append("Infinite loop in property interpolation of ");
        textStringBuilder.append(list.remove(0));
        textStringBuilder.append(": ");
        textStringBuilder.appendWithSeparators(list, "->");
        throw new IllegalStateException(textStringBuilder.toString());
    }

    public ooOOo0oXI oOXoIIIo(char c) {
        return X00IoxXI(xOx.II0XooXoX.f34478I0Io.II0xO0(c));
    }

    public String oOoXoXO(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return ooOOo0oXI(charSequence, 0, charSequence.length());
    }

    public ooOOo0oXI oo(char c) {
        this.f33086oxoX = c;
        return this;
    }

    public ooOOo0oXI oo0xXOI0I(boolean z) {
        this.f33079I0Io = z;
        return this;
    }

    public String ooOOo0oXI(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(charSequence.toString(), i, i2);
        I0oOoX(append, 0, i2);
        return append.toString();
    }

    public ooOOo0oXI ooXIXxIX(boolean z) {
        this.f33085oIX0oI = z;
        return this;
    }

    public OxxIIOOXO oxoX() {
        return this.f33087xxIXOIIO;
    }

    public String x0XOIxOo(Object obj) {
        if (obj == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder().append(obj);
        I0oOoX(append, 0, append.length());
        return append.toString();
    }

    public ooOOo0oXI x0o(xOx.Oxx0IOOO oxx0IOOO) {
        boolean z;
        if (oxx0IOOO != null) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Variable prefix matcher must not be null!", new Object[0]);
        this.f33083X0o0xo = oxx0IOOO;
        return this;
    }

    public ooOOo0oXI xI(boolean z) {
        this.f33081II0xO0 = z;
        return this;
    }

    public ooOOo0oXI xII(String str) {
        boolean z;
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Variable prefix must not be null!", new Object[0]);
        return x0o(xOx.II0XooXoX.f34478I0Io.oOoXoXO(str));
    }

    public boolean xoIox() {
        return this.f33079I0Io;
    }

    public String xoXoI(TextStringBuilder textStringBuilder, int i, int i2) {
        if (textStringBuilder == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(textStringBuilder, i, i2);
        I0oOoX(append, 0, i2);
        return append.toString();
    }

    public boolean xxIXOIIO() {
        return this.f33081II0xO0;
    }

    public boolean xxX(TextStringBuilder textStringBuilder) {
        if (textStringBuilder == null) {
            return false;
        }
        return I0oOoX(textStringBuilder, 0, textStringBuilder.length());
    }

    public <V> ooOOo0oXI(Map<String, V> map) {
        this(XIxXXX0x0.f31171oIX0oI.OxI(map), f33076x0XOIxOo, f33073oO, '$');
    }

    public <V> ooOOo0oXI(Map<String, V> map, String str, String str2) {
        this(XIxXXX0x0.f31171oIX0oI.OxI(map), str, str2, '$');
    }

    public <V> ooOOo0oXI(Map<String, V> map, String str, String str2, char c) {
        this(XIxXXX0x0.f31171oIX0oI.OxI(map), str, str2, c);
    }

    public <V> ooOOo0oXI(Map<String, V> map, String str, String str2, char c, String str3) {
        this(XIxXXX0x0.f31171oIX0oI.OxI(map), str, str2, c, str3);
    }

    public ooOOo0oXI(OxxIIOOXO oxxIIOOXO) {
        this(oxxIIOOXO, f33076x0XOIxOo, f33073oO, '$');
    }

    public ooOOo0oXI(OxxIIOOXO oxxIIOOXO, String str, String str2, char c) {
        XOxIOxOx(oxxIIOOXO);
        xII(str);
        Io(str2);
        oo(c);
        X00IoxXI(f33077x0xO0oo);
    }

    public ooOOo0oXI(OxxIIOOXO oxxIIOOXO, String str, String str2, char c, String str3) {
        XOxIOxOx(oxxIIOOXO);
        xII(str);
        Io(str2);
        oo(c);
        Xx000oIo(str3);
    }

    public ooOOo0oXI(OxxIIOOXO oxxIIOOXO, xOx.Oxx0IOOO oxx0IOOO, xOx.Oxx0IOOO oxx0IOOO2, char c) {
        this(oxxIIOOXO, oxx0IOOO, oxx0IOOO2, c, f33077x0xO0oo);
    }

    public ooOOo0oXI(OxxIIOOXO oxxIIOOXO, xOx.Oxx0IOOO oxx0IOOO, xOx.Oxx0IOOO oxx0IOOO2, char c, xOx.Oxx0IOOO oxx0IOOO3) {
        XOxIOxOx(oxxIIOOXO);
        x0o(oxx0IOOO);
        o0(oxx0IOOO2);
        oo(c);
        X00IoxXI(oxx0IOOO3);
    }

    public ooOOo0oXI(ooOOo0oXI ooooo0oxi) {
        this.f33085oIX0oI = ooooo0oxi.II0XooXoX();
        this.f33081II0xO0 = ooooo0oxi.xxIXOIIO();
        this.f33079I0Io = ooooo0oxi.xoIox();
        this.f33086oxoX = ooooo0oxi.I0Io();
        this.f33083X0o0xo = ooooo0oxi.XO();
        this.f33084XO = ooooo0oxi.OOXIXo();
        this.f33082Oxx0IOOO = ooooo0oxi.Oxx0IOOO();
        this.f33080II0XooXoX = ooooo0oxi.X0o0xo();
        this.f33087xxIXOIIO = ooooo0oxi.oxoX();
    }
}
