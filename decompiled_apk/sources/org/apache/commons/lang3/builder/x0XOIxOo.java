package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class x0XOIxOo implements oIX0oI<String> {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static volatile ToStringStyle f32665Oxx0xo = ToStringStyle.DEFAULT_STYLE;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final ToStringStyle f32666IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final Object f32667Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final StringBuffer f32668XO;

    public x0XOIxOo(Object obj) {
        this(obj, null, null);
    }

    public static String I0X0x0oIo(Object obj, ToStringStyle toStringStyle, boolean z) {
        return ooOOo0oXI.xoO0xx0(obj, toStringStyle, z, false, null);
    }

    public static String XX0(Object obj, ToStringStyle toStringStyle) {
        return ooOOo0oXI.IIxOXoOo0(obj, toStringStyle);
    }

    public static void Xo0(ToStringStyle toStringStyle) {
        f32665Oxx0xo = (ToStringStyle) xoIxX.xo0x(toStringStyle, "The style must not be null", new Object[0]);
    }

    public static <T> String oX(T t, ToStringStyle toStringStyle, boolean z, Class<? super T> cls) {
        return ooOOo0oXI.xoO0xx0(t, toStringStyle, z, false, cls);
    }

    public static ToStringStyle oxxXoxO() {
        return f32665Oxx0xo;
    }

    public static String xXOx(Object obj) {
        return ooOOo0oXI.OOXIxO0(obj);
    }

    public x0XOIxOo I0Io(double d) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, d);
        return this;
    }

    @Override // org.apache.commons.lang3.builder.oIX0oI
    /* renamed from: I0oOoX, reason: merged with bridge method [inline-methods] */
    public String build() {
        return toString();
    }

    public x0XOIxOo II0XooXoX(String str, byte b) {
        this.f32666IXxxXO.append(this.f32668XO, str, b);
        return this;
    }

    public x0XOIxOo II0xO0(char c) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, c);
        return this;
    }

    public x0XOIxOo IIX0o(String str, short[] sArr, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, sArr, Boolean.valueOf(z));
        return this;
    }

    public x0XOIxOo IIXOooo(String str, double[] dArr) {
        this.f32666IXxxXO.append(this.f32668XO, str, dArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo IO(int[] iArr) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, iArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo IXxxXO(String str, byte[] bArr) {
        this.f32666IXxxXO.append(this.f32668XO, str, bArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo Io(Object obj) {
        ObjectUtils.XIxXXX0x0(oxXx0IX(), obj);
        return this;
    }

    public x0XOIxOo IoOoX(byte[] bArr) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, bArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo O0xOxO(String str, int[] iArr) {
        this.f32666IXxxXO.append(this.f32668XO, str, iArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo OI0(boolean[] zArr) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, zArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo OOXIXo(String str, float f) {
        this.f32666IXxxXO.append(this.f32668XO, str, f);
        return this;
    }

    public x0XOIxOo Oo(String str, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, z);
        return this;
    }

    public x0XOIxOo OxI(String str, float[] fArr, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, fArr, Boolean.valueOf(z));
        return this;
    }

    public x0XOIxOo Oxx0IOOO(Object obj) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, obj, (Boolean) null);
        return this;
    }

    public x0XOIxOo Oxx0xo(String str, byte[] bArr, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, bArr, Boolean.valueOf(z));
        return this;
    }

    public x0XOIxOo OxxIIOOXO(String str, char[] cArr, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, cArr, Boolean.valueOf(z));
        return this;
    }

    public x0XOIxOo X00IoxXI(float[] fArr) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, fArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo X0IIOO(String str, int[] iArr, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, iArr, Boolean.valueOf(z));
        return this;
    }

    public x0XOIxOo X0o0xo(int i) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, i);
        return this;
    }

    public x0XOIxOo XI0IXoo(String str, long[] jArr) {
        this.f32666IXxxXO.append(this.f32668XO, str, jArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo XIxXXX0x0(String str, long[] jArr, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, jArr, Boolean.valueOf(z));
        return this;
    }

    public x0XOIxOo XO(long j) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, j);
        return this;
    }

    public x0XOIxOo XOxIOxOx(short[] sArr) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, sArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo XX(String str) {
        if (str != null) {
            this.f32666IXxxXO.appendToString(this.f32668XO, str);
        }
        return this;
    }

    public Object XoX() {
        return this.f32667Oo;
    }

    public x0XOIxOo Xx000oIo(double[] dArr) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, dArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo XxX0x0xxx(String str, Object[] objArr, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, objArr, Boolean.valueOf(z));
        return this;
    }

    public x0XOIxOo o0(String str) {
        if (str != null) {
            this.f32666IXxxXO.appendSuper(this.f32668XO, str);
        }
        return this;
    }

    public x0XOIxOo o00(String str, float[] fArr) {
        this.f32666IXxxXO.append(this.f32668XO, str, fArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo oI0IIXIo(String str, char[] cArr) {
        this.f32666IXxxXO.append(this.f32668XO, str, cArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo oIX0oI(byte b) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, b);
        return this;
    }

    public x0XOIxOo oO(String str, Object obj, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, obj, Boolean.valueOf(z));
        return this;
    }

    public x0XOIxOo oOXoIIIo(char[] cArr) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, cArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo oOoXoXO(String str, int i) {
        this.f32666IXxxXO.append(this.f32668XO, str, i);
        return this;
    }

    public x0XOIxOo oo(boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, z);
        return this;
    }

    public x0XOIxOo oo0xXOI0I(short s) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, s);
        return this;
    }

    public x0XOIxOo ooOOo0oXI(String str, long j) {
        this.f32666IXxxXO.append(this.f32668XO, str, j);
        return this;
    }

    public x0XOIxOo ooXIXxIX(String str, boolean[] zArr) {
        this.f32666IXxxXO.append(this.f32668XO, str, zArr, (Boolean) null);
        return this;
    }

    public StringBuffer oxXx0IX() {
        return this.f32668XO;
    }

    public x0XOIxOo oxoX(float f) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, f);
        return this;
    }

    public String toString() {
        if (XoX() == null) {
            oxXx0IX().append(xo0x().getNullText());
        } else {
            this.f32666IXxxXO.appendEnd(oxXx0IX(), XoX());
        }
        return oxXx0IX().toString();
    }

    public x0XOIxOo x0XOIxOo(String str, Object obj) {
        this.f32666IXxxXO.append(this.f32668XO, str, obj, (Boolean) null);
        return this;
    }

    public x0XOIxOo x0o(Object[] objArr) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, objArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo x0xO0oo(String str, short s) {
        this.f32666IXxxXO.append(this.f32668XO, str, s);
        return this;
    }

    public x0XOIxOo xI(String str, boolean[] zArr, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, zArr, Boolean.valueOf(z));
        return this;
    }

    public x0XOIxOo xII(long[] jArr) {
        this.f32666IXxxXO.append(this.f32668XO, (String) null, jArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo xXxxox0I(String str, short[] sArr) {
        this.f32666IXxxXO.append(this.f32668XO, str, sArr, (Boolean) null);
        return this;
    }

    public ToStringStyle xo0x() {
        return this.f32666IXxxXO;
    }

    public x0XOIxOo xoIox(String str, double d) {
        this.f32666IXxxXO.append(this.f32668XO, str, d);
        return this;
    }

    public x0XOIxOo xoXoI(String str, double[] dArr, boolean z) {
        this.f32666IXxxXO.append(this.f32668XO, str, dArr, Boolean.valueOf(z));
        return this;
    }

    public x0XOIxOo xxIXOIIO(String str, char c) {
        this.f32666IXxxXO.append(this.f32668XO, str, c);
        return this;
    }

    public x0XOIxOo xxX(String str, Object[] objArr) {
        this.f32666IXxxXO.append(this.f32668XO, str, objArr, (Boolean) null);
        return this;
    }

    public x0XOIxOo(Object obj, ToStringStyle toStringStyle) {
        this(obj, toStringStyle, null);
    }

    public x0XOIxOo(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        toStringStyle = toStringStyle == null ? oxxXoxO() : toStringStyle;
        stringBuffer = stringBuffer == null ? new StringBuffer(512) : stringBuffer;
        this.f32668XO = stringBuffer;
        this.f32666IXxxXO = toStringStyle;
        this.f32667Oo = obj;
        toStringStyle.appendStart(stringBuffer, obj);
    }
}
