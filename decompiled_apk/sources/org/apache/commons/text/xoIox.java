package org.apache.commons.text;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.xoIxX;

@Deprecated
/* loaded from: classes6.dex */
public class xoIox {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final char f33105xxIXOIIO = '$';

    /* renamed from: I0Io, reason: collision with root package name */
    public xxIXOIIO f33106I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f33107II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public xxIXOIIO f33108II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f33109Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public II0XooXoX<?> f33110X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f33111XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public char f33112oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public xxIXOIIO f33113oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final xxIXOIIO f33104xoIox = xxIXOIIO.ooOOo0oXI(ooOOo0oXI.f33075ooOOo0oXI);

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final xxIXOIIO f33102OOXIXo = xxIXOIIO.ooOOo0oXI(ooOOo0oXI.f33074oOoXoXO);

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final xxIXOIIO f33103oOoXoXO = xxIXOIIO.ooOOo0oXI(ooOOo0oXI.f33072OOXIXo);

    public xoIox() {
        this((II0XooXoX<?>) null, f33104xoIox, f33102OOXIXo, '$');
    }

    public static String oO(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return ooOOo0oXI(obj, hashMap);
    }

    public static <V> String ooOOo0oXI(Object obj, Map<String, V> map) {
        return new xoIox(map).oOoXoXO(obj);
    }

    public static <V> String x0XOIxOo(Object obj, Map<String, V> map, String str, String str2) {
        return new xoIox(map, str, str2).oOoXoXO(obj);
    }

    public static String xxX(Object obj) {
        return new xoIox(II0XooXoX.X0o0xo()).oOoXoXO(obj);
    }

    public xxIXOIIO I0Io() {
        return this.f33113oxoX;
    }

    public boolean II0XooXoX() {
        return this.f33111XO;
    }

    public char II0xO0() {
        return this.f33112oIX0oI;
    }

    public void IIX0o(boolean z) {
        this.f33111XO = z;
    }

    public String IIXOooo(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(cArr.length).append(cArr);
        Io(append, 0, cArr.length);
        return append.toString();
    }

    public void IO(II0XooXoX<?> iI0XooXoX) {
        this.f33110X0o0xo = iI0XooXoX;
    }

    public String IXxxXO(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        Io(append, 0, append.length());
        return append.toString();
    }

    public boolean Io(StrBuilder strBuilder, int i, int i2) {
        if (OI0(strBuilder, i, i2, null) > 0) {
            return true;
        }
        return false;
    }

    public xoIox IoOoX(xxIXOIIO xxixoiio) {
        this.f33113oxoX = xxixoiio;
        return this;
    }

    public boolean O0xOxO(StringBuilder sb) {
        if (sb == null) {
            return false;
        }
        return X0IIOO(sb, 0, sb.length());
    }

    public final int OI0(StrBuilder strBuilder, int i, int i2, List<String> list) {
        boolean z;
        xxIXOIIO xxixoiio;
        char c;
        boolean z2;
        int i3;
        int i4;
        String str;
        int i5;
        xxIXOIIO oxoX2 = oxoX();
        xxIXOIIO XO2 = XO();
        char II0xO02 = II0xO0();
        xxIXOIIO I0Io2 = I0Io();
        boolean II0XooXoX2 = II0XooXoX();
        boolean Oxx0IOOO2 = Oxx0IOOO();
        if (list == null) {
            z = true;
        } else {
            z = false;
        }
        int i6 = i;
        int i7 = i + i2;
        int i8 = 0;
        int i9 = 0;
        char[] cArr = strBuilder.buffer;
        List<String> list2 = list;
        while (i6 < i7) {
            int Oxx0IOOO3 = oxoX2.Oxx0IOOO(cArr, i6, i, i7);
            if (Oxx0IOOO3 == 0) {
                i6++;
                xxixoiio = XO2;
                c = II0xO02;
                z2 = z;
                i3 = i7;
            } else {
                if (i6 > i) {
                    int i10 = i6 - 1;
                    z2 = z;
                    if (cArr[i10] == II0xO02) {
                        if (this.f33109Oxx0IOOO) {
                            i6++;
                            z = z2;
                        } else {
                            strBuilder.deleteCharAt(i10);
                            i8--;
                            xxixoiio = XO2;
                            c = II0xO02;
                            cArr = strBuilder.buffer;
                            i3 = i7 - 1;
                            i9 = 1;
                        }
                    }
                } else {
                    z2 = z;
                }
                int i11 = i6 + Oxx0IOOO3;
                int i12 = i11;
                int i13 = 0;
                while (true) {
                    if (i12 < i7) {
                        if (II0XooXoX2 && oxoX2.Oxx0IOOO(cArr, i12, i, i7) != 0) {
                            i13++;
                            i12 += oxoX2.Oxx0IOOO(cArr, i12, i, i7);
                        } else {
                            int Oxx0IOOO4 = XO2.Oxx0IOOO(cArr, i12, i, i7);
                            if (Oxx0IOOO4 == 0) {
                                i12++;
                            } else if (i13 == 0) {
                                xxixoiio = XO2;
                                c = II0xO02;
                                String str2 = new String(cArr, i11, (i12 - i6) - Oxx0IOOO3);
                                if (II0XooXoX2) {
                                    StrBuilder strBuilder2 = new StrBuilder(str2);
                                    Io(strBuilder2, 0, strBuilder2.length());
                                    str2 = strBuilder2.toString();
                                }
                                int i14 = i12 + Oxx0IOOO4;
                                if (I0Io2 != null) {
                                    char[] charArray = str2.toCharArray();
                                    i4 = i7;
                                    for (int i15 = 0; i15 < charArray.length && (II0XooXoX2 || oxoX2.Oxx0IOOO(charArray, i15, i15, charArray.length) == 0); i15++) {
                                        if (I0Io2.XO(charArray, i15) != 0) {
                                            int XO3 = I0Io2.XO(charArray, i15);
                                            String substring = str2.substring(0, i15);
                                            str = str2.substring(i15 + XO3);
                                            str2 = substring;
                                            break;
                                        }
                                    }
                                } else {
                                    i4 = i7;
                                }
                                str = null;
                                if (list2 == null) {
                                    list2 = new ArrayList<>();
                                    list2.add(new String(cArr, i, i2));
                                }
                                oIX0oI(str2, list2);
                                list2.add(str2);
                                String XxX0x0xxx2 = XxX0x0xxx(str2, strBuilder, i6, i14);
                                if (XxX0x0xxx2 != null) {
                                    str = XxX0x0xxx2;
                                }
                                if (str != null) {
                                    int length = str.length();
                                    strBuilder.replace(i6, i14, str);
                                    if (!Oxx0IOOO2) {
                                        i5 = OI0(strBuilder, i6, length, list2);
                                    } else {
                                        i5 = 0;
                                    }
                                    int i16 = (i5 + length) - (i14 - i6);
                                    i3 = i4 + i16;
                                    i8 += i16;
                                    cArr = strBuilder.buffer;
                                    i6 = i14 + i16;
                                    i9 = 1;
                                } else {
                                    i3 = i4;
                                    i6 = i14;
                                }
                                list2.remove(list2.size() - 1);
                            } else {
                                i13--;
                                i12 += Oxx0IOOO4;
                                i7 = i7;
                            }
                        }
                    } else {
                        xxixoiio = XO2;
                        c = II0xO02;
                        i3 = i7;
                        i6 = i12;
                        break;
                    }
                }
            }
            i7 = i3;
            z = z2;
            XO2 = xxixoiio;
            II0xO02 = c;
        }
        if (z) {
            return i9;
        }
        return i8;
    }

    public String OOXIXo(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(charSequence, i, i2);
        Io(append, 0, i2);
        return append.toString();
    }

    public String Oo(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(str, i, i2);
        if (!Io(append, 0, i2)) {
            return str.substring(i, i2 + i);
        }
        return append.toString();
    }

    public boolean OxI(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        if (!Io(append, 0, i2)) {
            return false;
        }
        stringBuffer.replace(i, i2 + i, append.toString());
        return true;
    }

    public boolean Oxx0IOOO() {
        return this.f33107II0XooXoX;
    }

    public String Oxx0xo(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        Io(append, 0, i2);
        return append.toString();
    }

    public String OxxIIOOXO(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(strBuilder, i, i2);
        Io(append, 0, i2);
        return append.toString();
    }

    public xoIox X00IoxXI(xxIXOIIO xxixoiio) {
        boolean z;
        if (xxixoiio != null) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Variable prefix matcher must not be null!", new Object[0]);
        this.f33108II0xO0 = xxixoiio;
        return this;
    }

    public boolean X0IIOO(StringBuilder sb, int i, int i2) {
        if (sb == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i2).append(sb, i, i2);
        if (!Io(append, 0, i2)) {
            return false;
        }
        sb.replace(i, i2 + i, append.toString());
        return true;
    }

    public II0XooXoX<?> X0o0xo() {
        return this.f33110X0o0xo;
    }

    public boolean XI0IXoo(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return Io(strBuilder, 0, strBuilder.length());
    }

    public boolean XIxXXX0x0(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return false;
        }
        return Io(strBuilder, i, i2);
    }

    public xxIXOIIO XO() {
        return this.f33106I0Io;
    }

    public xoIox XOxIOxOx(xxIXOIIO xxixoiio) {
        boolean z;
        if (xxixoiio != null) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Variable suffix matcher must not be null!", new Object[0]);
        this.f33106I0Io = xxixoiio;
        return this;
    }

    public xoIox Xx000oIo(String str) {
        boolean z;
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Variable prefix must not be null!", new Object[0]);
        return X00IoxXI(xxIXOIIO.ooOOo0oXI(str));
    }

    public String XxX0x0xxx(String str, StrBuilder strBuilder, int i, int i2) {
        II0XooXoX<?> X0o0xo2 = X0o0xo();
        if (X0o0xo2 == null) {
            return null;
        }
        return X0o0xo2.lookup(str);
    }

    public boolean o00(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return OxI(stringBuffer, 0, stringBuffer.length());
    }

    public String oI0IIXIo(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
        Io(append, 0, append.length());
        return append.toString();
    }

    public final void oIX0oI(String str, List<String> list) {
        if (!list.contains(str)) {
            return;
        }
        StrBuilder strBuilder = new StrBuilder(256);
        strBuilder.append("Infinite loop in property interpolation of ");
        strBuilder.append(list.remove(0));
        strBuilder.append(": ");
        strBuilder.appendWithSeparators(list, "->");
        throw new IllegalStateException(strBuilder.toString());
    }

    public xoIox oOXoIIIo(char c) {
        return X00IoxXI(xxIXOIIO.oIX0oI(c));
    }

    public String oOoXoXO(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder append = new StrBuilder().append(obj);
        Io(append, 0, append.length());
        return append.toString();
    }

    public xoIox oo(String str) {
        if (str != null && str.length() != 0) {
            return IoOoX(xxIXOIIO.ooOOo0oXI(str));
        }
        IoOoX(null);
        return this;
    }

    public xoIox oo0xXOI0I(char c) {
        return IoOoX(xxIXOIIO.oIX0oI(c));
    }

    public void ooXIXxIX(char c) {
        this.f33112oIX0oI = c;
    }

    public xxIXOIIO oxoX() {
        return this.f33108II0xO0;
    }

    public xoIox x0o(String str) {
        boolean z;
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Variable suffix must not be null!", new Object[0]);
        return XOxIOxOx(xxIXOIIO.ooOOo0oXI(str));
    }

    public String x0xO0oo(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        if (!Io(strBuilder, 0, str.length())) {
            return str;
        }
        return strBuilder.toString();
    }

    public void xI(boolean z) {
        this.f33109Oxx0IOOO = z;
    }

    public xoIox xII(char c) {
        return XOxIOxOx(xxIXOIIO.oIX0oI(c));
    }

    public void xXxxox0I(boolean z) {
        this.f33107II0XooXoX = z;
    }

    public String xoIox(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return OOXIXo(charSequence, 0, charSequence.length());
    }

    public String xoXoI(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(cArr, i, i2);
        Io(append, 0, i2);
        return append.toString();
    }

    public boolean xxIXOIIO() {
        return this.f33109Oxx0IOOO;
    }

    public <V> xoIox(Map<String, V> map) {
        this((II0XooXoX<?>) II0XooXoX.II0xO0(map), f33104xoIox, f33102OOXIXo, '$');
    }

    public <V> xoIox(Map<String, V> map, String str, String str2) {
        this((II0XooXoX<?>) II0XooXoX.II0xO0(map), str, str2, '$');
    }

    public <V> xoIox(Map<String, V> map, String str, String str2, char c) {
        this((II0XooXoX<?>) II0XooXoX.II0xO0(map), str, str2, c);
    }

    public <V> xoIox(Map<String, V> map, String str, String str2, char c, String str3) {
        this((II0XooXoX<?>) II0XooXoX.II0xO0(map), str, str2, c, str3);
    }

    public xoIox(II0XooXoX<?> iI0XooXoX) {
        this(iI0XooXoX, f33104xoIox, f33102OOXIXo, '$');
    }

    public xoIox(II0XooXoX<?> iI0XooXoX, String str, String str2, char c) {
        this.f33109Oxx0IOOO = false;
        IO(iI0XooXoX);
        Xx000oIo(str);
        x0o(str2);
        ooXIXxIX(c);
        IoOoX(f33103oOoXoXO);
    }

    public xoIox(II0XooXoX<?> iI0XooXoX, String str, String str2, char c, String str3) {
        this.f33109Oxx0IOOO = false;
        IO(iI0XooXoX);
        Xx000oIo(str);
        x0o(str2);
        ooXIXxIX(c);
        oo(str3);
    }

    public xoIox(II0XooXoX<?> iI0XooXoX, xxIXOIIO xxixoiio, xxIXOIIO xxixoiio2, char c) {
        this(iI0XooXoX, xxixoiio, xxixoiio2, c, f33103oOoXoXO);
    }

    public xoIox(II0XooXoX<?> iI0XooXoX, xxIXOIIO xxixoiio, xxIXOIIO xxixoiio2, char c, xxIXOIIO xxixoiio3) {
        this.f33109Oxx0IOOO = false;
        IO(iI0XooXoX);
        X00IoxXI(xxixoiio);
        XOxIOxOx(xxixoiio2);
        ooXIXxIX(c);
        IoOoX(xxixoiio3);
    }
}
