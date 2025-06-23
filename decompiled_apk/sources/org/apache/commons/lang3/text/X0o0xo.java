package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.xXOx;
import org.apache.commons.text.ooOOo0oXI;

@Deprecated
/* loaded from: classes6.dex */
public class X0o0xo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final char f32782II0XooXoX = '$';

    /* renamed from: I0Io, reason: collision with root package name */
    public oxoX f32786I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public oxoX f32787II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f32788Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public I0Io<?> f32789X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f32790XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public char f32791oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public oxoX f32792oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final oxoX f32785xxIXOIIO = oxoX.ooOOo0oXI(ooOOo0oXI.f33075ooOOo0oXI);

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oxoX f32784xoIox = oxoX.ooOOo0oXI(ooOOo0oXI.f33074oOoXoXO);

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oxoX f32783OOXIXo = oxoX.ooOOo0oXI(ooOOo0oXI.f33072OOXIXo);

    public X0o0xo() {
        this((I0Io<?>) null, f32785xxIXOIIO, f32784xoIox, '$');
    }

    public static String XIxXXX0x0(Object obj) {
        return new X0o0xo(I0Io.oxoX()).OOXIXo(obj);
    }

    public static <V> String oOoXoXO(Object obj, Map<String, V> map) {
        return new X0o0xo(map).OOXIXo(obj);
    }

    public static <V> String ooOOo0oXI(Object obj, Map<String, V> map, String str, String str2) {
        return new X0o0xo(map, str, str2).OOXIXo(obj);
    }

    public static String x0XOIxOo(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return oOoXoXO(obj, hashMap);
    }

    public oxoX I0Io() {
        return this.f32792oxoX;
    }

    public boolean II0XooXoX() {
        return this.f32788Oxx0IOOO;
    }

    public char II0xO0() {
        return this.f32791oIX0oI;
    }

    public void IIX0o(boolean z) {
        this.f32788Oxx0IOOO = z;
    }

    public String IIXOooo(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(cArr, i, i2);
        XOxIOxOx(append, 0, i2);
        return append.toString();
    }

    public X0o0xo IO(String str) {
        if (str != null) {
            return xII(oxoX.ooOOo0oXI(str));
        }
        throw new IllegalArgumentException("Variable suffix must not be null.");
    }

    public String IXxxXO(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        XOxIOxOx(append, 0, i2);
        return append.toString();
    }

    public X0o0xo IoOoX(String str) {
        if (str != null) {
            return oOXoIIIo(oxoX.ooOOo0oXI(str));
        }
        throw new IllegalArgumentException("Variable prefix must not be null.");
    }

    public boolean O0xOxO(StringBuilder sb, int i, int i2) {
        if (sb == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i2).append(sb, i, i2);
        if (!XOxIOxOx(append, 0, i2)) {
            return false;
        }
        sb.replace(i, i2 + i, append.toString());
        return true;
    }

    public String OOXIXo(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder append = new StrBuilder().append(obj);
        XOxIOxOx(append, 0, append.length());
        return append.toString();
    }

    public String Oo(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        XOxIOxOx(append, 0, append.length());
        return append.toString();
    }

    public boolean OxI(StringBuilder sb) {
        if (sb == null) {
            return false;
        }
        return O0xOxO(sb, 0, sb.length());
    }

    public boolean Oxx0IOOO() {
        return this.f32790XO;
    }

    public String Oxx0xo(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
        XOxIOxOx(append, 0, append.length());
        return append.toString();
    }

    public String OxxIIOOXO(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(cArr.length).append(cArr);
        XOxIOxOx(append, 0, cArr.length);
        return append.toString();
    }

    public X0o0xo X00IoxXI(char c) {
        return xII(oxoX.oIX0oI(c));
    }

    public boolean X0IIOO(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return XOxIOxOx(strBuilder, 0, strBuilder.length());
    }

    public I0Io<?> X0o0xo() {
        return this.f32789X0o0xo;
    }

    public boolean XI0IXoo(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return false;
        }
        return XOxIOxOx(strBuilder, i, i2);
    }

    public oxoX XO() {
        return this.f32786I0Io;
    }

    public boolean XOxIOxOx(StrBuilder strBuilder, int i, int i2) {
        if (x0o(strBuilder, i, i2, null) > 0) {
            return true;
        }
        return false;
    }

    public void Xx000oIo(I0Io<?> i0Io) {
        this.f32789X0o0xo = i0Io;
    }

    public void XxX0x0xxx(boolean z) {
        this.f32790XO = z;
    }

    public boolean o00(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        if (!XOxIOxOx(append, 0, i2)) {
            return false;
        }
        stringBuffer.replace(i, i2 + i, append.toString());
        return true;
    }

    public String oI0IIXIo(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(strBuilder, i, i2);
        XOxIOxOx(append, 0, i2);
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

    public String oO(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        if (!XOxIOxOx(strBuilder, 0, str.length())) {
            return str;
        }
        return strBuilder.toString();
    }

    public X0o0xo oOXoIIIo(oxoX oxox) {
        if (oxox != null) {
            this.f32787II0xO0 = oxox;
            return this;
        }
        throw new IllegalArgumentException("Variable prefix matcher must not be null.");
    }

    public X0o0xo oo(char c) {
        return oOXoIIIo(oxoX.oIX0oI(c));
    }

    public X0o0xo oo0xXOI0I(oxoX oxox) {
        this.f32792oxoX = oxox;
        return this;
    }

    public X0o0xo ooXIXxIX(char c) {
        return oo0xXOI0I(oxoX.oIX0oI(c));
    }

    public oxoX oxoX() {
        return this.f32787II0xO0;
    }

    public final int x0o(StrBuilder strBuilder, int i, int i2, List<String> list) {
        boolean z;
        oxoX oxox;
        oxoX oxox2;
        char c;
        boolean z2;
        String str;
        int Oxx0IOOO2;
        oxoX oxoX2 = oxoX();
        oxoX XO2 = XO();
        char II0xO02 = II0xO0();
        oxoX I0Io2 = I0Io();
        boolean Oxx0IOOO3 = Oxx0IOOO();
        if (list == null) {
            z = true;
        } else {
            z = false;
        }
        int i3 = i;
        int i4 = i + i2;
        int i5 = 0;
        int i6 = 0;
        char[] cArr = strBuilder.buffer;
        List<String> list2 = list;
        while (i3 < i4) {
            int Oxx0IOOO4 = oxoX2.Oxx0IOOO(cArr, i3, i, i4);
            if (Oxx0IOOO4 == 0) {
                i3++;
                oxox = oxoX2;
                oxox2 = XO2;
                c = II0xO02;
                z2 = z;
            } else {
                if (i3 > i) {
                    int i7 = i3 - 1;
                    if (cArr[i7] == II0xO02) {
                        if (this.f32788Oxx0IOOO) {
                            i3++;
                        } else {
                            strBuilder.deleteCharAt(i7);
                            i5--;
                            i4--;
                            oxox = oxoX2;
                            oxox2 = XO2;
                            c = II0xO02;
                            cArr = strBuilder.buffer;
                            z2 = z;
                            i6 = 1;
                        }
                    }
                }
                int i8 = i3 + Oxx0IOOO4;
                int i9 = i8;
                int i10 = 0;
                while (true) {
                    if (i9 < i4) {
                        if (Oxx0IOOO3 && (Oxx0IOOO2 = oxoX2.Oxx0IOOO(cArr, i9, i, i4)) != 0) {
                            i10++;
                            i9 += Oxx0IOOO2;
                        } else {
                            int Oxx0IOOO5 = XO2.Oxx0IOOO(cArr, i9, i, i4);
                            if (Oxx0IOOO5 == 0) {
                                i9++;
                            } else if (i10 == 0) {
                                oxox2 = XO2;
                                c = II0xO02;
                                String str2 = new String(cArr, i8, (i9 - i3) - Oxx0IOOO4);
                                if (Oxx0IOOO3) {
                                    StrBuilder strBuilder2 = new StrBuilder(str2);
                                    XOxIOxOx(strBuilder2, 0, strBuilder2.length());
                                    str2 = strBuilder2.toString();
                                }
                                int i11 = i9 + Oxx0IOOO5;
                                if (I0Io2 != null) {
                                    char[] charArray = str2.toCharArray();
                                    z2 = z;
                                    int i12 = 0;
                                    while (i12 < charArray.length && (Oxx0IOOO3 || oxoX2.Oxx0IOOO(charArray, i12, i12, charArray.length) == 0)) {
                                        int XO3 = I0Io2.XO(charArray, i12);
                                        if (XO3 != 0) {
                                            oxox = oxoX2;
                                            String substring = str2.substring(0, i12);
                                            str = str2.substring(i12 + XO3);
                                            str2 = substring;
                                            break;
                                        }
                                        i12++;
                                        oxoX2 = oxoX2;
                                    }
                                    oxox = oxoX2;
                                } else {
                                    oxox = oxoX2;
                                    z2 = z;
                                }
                                str = null;
                                if (list2 == null) {
                                    list2 = new ArrayList<>();
                                    list2.add(new String(cArr, i, i2));
                                }
                                oIX0oI(str2, list2);
                                list2.add(str2);
                                String xxX2 = xxX(str2, strBuilder, i3, i11);
                                if (xxX2 != null) {
                                    str = xxX2;
                                }
                                if (str != null) {
                                    int length = str.length();
                                    strBuilder.replace(i3, i11, str);
                                    int x0o2 = (x0o(strBuilder, i3, length, list2) + length) - (i11 - i3);
                                    i4 += x0o2;
                                    i5 += x0o2;
                                    cArr = strBuilder.buffer;
                                    i3 = i11 + x0o2;
                                    i6 = 1;
                                } else {
                                    i3 = i11;
                                }
                                list2.remove(list2.size() - 1);
                            } else {
                                i10--;
                                i9 += Oxx0IOOO5;
                                II0xO02 = II0xO02;
                                oxoX2 = oxoX2;
                            }
                        }
                    } else {
                        oxox = oxoX2;
                        oxox2 = XO2;
                        c = II0xO02;
                        z2 = z;
                        i3 = i9;
                        break;
                    }
                }
            }
            XO2 = oxox2;
            II0xO02 = c;
            z = z2;
            oxoX2 = oxox;
        }
        if (z) {
            return i6;
        }
        return i5;
    }

    public String x0xO0oo(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(str, i, i2);
        if (!XOxIOxOx(append, 0, i2)) {
            return str.substring(i, i2 + i);
        }
        return append.toString();
    }

    public X0o0xo xI(String str) {
        if (xXOx.XIXIX(str)) {
            oo0xXOI0I(null);
            return this;
        }
        return oo0xXOI0I(oxoX.ooOOo0oXI(str));
    }

    public X0o0xo xII(oxoX oxox) {
        if (oxox != null) {
            this.f32786I0Io = oxox;
            return this;
        }
        throw new IllegalArgumentException("Variable suffix matcher must not be null.");
    }

    public void xXxxox0I(char c) {
        this.f32791oIX0oI = c;
    }

    public String xoIox(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(charSequence, i, i2);
        XOxIOxOx(append, 0, i2);
        return append.toString();
    }

    public boolean xoXoI(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return o00(stringBuffer, 0, stringBuffer.length());
    }

    public String xxIXOIIO(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return xoIox(charSequence, 0, charSequence.length());
    }

    public String xxX(String str, StrBuilder strBuilder, int i, int i2) {
        I0Io<?> X0o0xo2 = X0o0xo();
        if (X0o0xo2 == null) {
            return null;
        }
        return X0o0xo2.oIX0oI(str);
    }

    public <V> X0o0xo(Map<String, V> map) {
        this((I0Io<?>) I0Io.II0xO0(map), f32785xxIXOIIO, f32784xoIox, '$');
    }

    public <V> X0o0xo(Map<String, V> map, String str, String str2) {
        this((I0Io<?>) I0Io.II0xO0(map), str, str2, '$');
    }

    public <V> X0o0xo(Map<String, V> map, String str, String str2, char c) {
        this((I0Io<?>) I0Io.II0xO0(map), str, str2, c);
    }

    public <V> X0o0xo(Map<String, V> map, String str, String str2, char c, String str3) {
        this((I0Io<?>) I0Io.II0xO0(map), str, str2, c, str3);
    }

    public X0o0xo(I0Io<?> i0Io) {
        this(i0Io, f32785xxIXOIIO, f32784xoIox, '$');
    }

    public X0o0xo(I0Io<?> i0Io, String str, String str2, char c) {
        this.f32788Oxx0IOOO = false;
        Xx000oIo(i0Io);
        IoOoX(str);
        IO(str2);
        xXxxox0I(c);
        oo0xXOI0I(f32783OOXIXo);
    }

    public X0o0xo(I0Io<?> i0Io, String str, String str2, char c, String str3) {
        this.f32788Oxx0IOOO = false;
        Xx000oIo(i0Io);
        IoOoX(str);
        IO(str2);
        xXxxox0I(c);
        xI(str3);
    }

    public X0o0xo(I0Io<?> i0Io, oxoX oxox, oxoX oxox2, char c) {
        this(i0Io, oxox, oxox2, c, f32783OOXIXo);
    }

    public X0o0xo(I0Io<?> i0Io, oxoX oxox, oxoX oxox2, char c, oxoX oxox3) {
        this.f32788Oxx0IOOO = false;
        Xx000oIo(i0Io);
        oOXoIIIo(oxox);
        xII(oxox2);
        xXxxox0I(c);
        oo0xXOI0I(oxox3);
    }
}
