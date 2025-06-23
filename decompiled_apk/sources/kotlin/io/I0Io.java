package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

@XO0OX.xxIXOIIO(name = "ConsoleKt")
/* loaded from: classes6.dex */
public final class I0Io {
    @xx0o0O.XO
    public static final void I0Io(double d) {
        System.out.print(d);
    }

    @xx0o0O.XO
    public static final void II0XooXoX(short s) {
        System.out.print(Short.valueOf(s));
    }

    @xx0o0O.XO
    public static final void II0xO0(char c) {
        System.out.print(c);
    }

    @OXOo.oOoXoXO
    public static final String IIXOooo() {
        oOoXoXO oooxoxo = oOoXoXO.f29231oIX0oI;
        InputStream in = System.in;
        IIX0o.oO(in, "in");
        Charset defaultCharset = Charset.defaultCharset();
        IIX0o.oO(defaultCharset, "defaultCharset(...)");
        return oooxoxo.oxoX(in, defaultCharset);
    }

    @xx0o0O.XO
    public static final void IXxxXO(Object obj) {
        System.out.println(obj);
    }

    @xx0o0O.XO
    public static final void OOXIXo() {
        System.out.println();
    }

    @xx0o0O.XO
    public static final void Oo(long j) {
        System.out.println(j);
    }

    @xx0o0O.XO
    public static final void Oxx0IOOO(Object obj) {
        System.out.print(obj);
    }

    @xx0o0O.XO
    public static final void Oxx0xo(short s) {
        System.out.println(Short.valueOf(s));
    }

    @xx0o0O.XO
    public static final void OxxIIOOXO(char[] message) {
        IIX0o.x0xO0oo(message, "message");
        System.out.println(message);
    }

    @xx0o0O.XO
    public static final void X0o0xo(int i) {
        System.out.print(i);
    }

    @xx0o0O.XO
    public static final void XO(long j) {
        System.out.print(j);
    }

    @oxxXoxO(version = "1.6")
    @OXOo.oOoXoXO
    public static final String o00() {
        return IIXOooo();
    }

    @xx0o0O.XO
    public static final void oI0IIXIo(boolean z) {
        System.out.println(z);
    }

    @xx0o0O.XO
    public static final void oIX0oI(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    @xx0o0O.XO
    public static final void oO(float f) {
        System.out.println(f);
    }

    @xx0o0O.XO
    public static final void oOoXoXO(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    @xx0o0O.XO
    public static final void ooOOo0oXI(char c) {
        System.out.println(c);
    }

    @xx0o0O.XO
    public static final void oxoX(float f) {
        System.out.print(f);
    }

    @xx0o0O.XO
    public static final void x0XOIxOo(double d) {
        System.out.println(d);
    }

    @xx0o0O.XO
    public static final void x0xO0oo(int i) {
        System.out.println(i);
    }

    @xx0o0O.XO
    public static final void xoIox(char[] message) {
        IIX0o.x0xO0oo(message, "message");
        System.out.print(message);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.6")
    public static final String xoXoI() {
        String o002 = o00();
        if (o002 != null) {
            return o002;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    @xx0o0O.XO
    public static final void xxIXOIIO(boolean z) {
        System.out.print(z);
    }
}
