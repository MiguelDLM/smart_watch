package com.hp.hpl.sparta;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: classes10.dex */
public class x0xO0oo {
    public static X0o0xo I0Io(String str, InputStream inputStream, x0XOIxOo x0xoixoo) throws ParseException, IOException {
        oIX0oI oix0oi = new oIX0oI();
        new OOXIXo(str, inputStream, x0xoixoo, null, oix0oi);
        return oix0oi.oxoX();
    }

    public static X0o0xo II0XooXoX(byte[] bArr) throws ParseException, IOException {
        oIX0oI oix0oi = new oIX0oI();
        new OOXIXo("file:anonymous-string", new ByteArrayInputStream(bArr), null, null, oix0oi);
        return oix0oi.oxoX();
    }

    public static X0o0xo II0xO0(String str, InputStream inputStream) throws ParseException, IOException {
        oIX0oI oix0oi = new oIX0oI();
        new OOXIXo(str, inputStream, null, null, oix0oi);
        return oix0oi.oxoX();
    }

    public static void IXxxXO(char[] cArr, ooOOo0oXI ooooo0oxi) throws ParseException, IOException {
        new oOoXoXO("file:anonymous-string", cArr, (x0XOIxOo) null, (String) null, ooooo0oxi);
    }

    public static void OOXIXo(String str, InputStream inputStream, ooOOo0oXI ooooo0oxi) throws ParseException, IOException {
        new OOXIXo(str, inputStream, null, null, ooooo0oxi);
    }

    public static void Oo(byte[] bArr, ooOOo0oXI ooooo0oxi) throws ParseException, IOException {
        new OOXIXo("file:anonymous-string", new ByteArrayInputStream(bArr), null, null, ooooo0oxi);
    }

    public static X0o0xo Oxx0IOOO(String str, Reader reader, x0XOIxOo x0xoixoo, String str2) throws ParseException, EncodingMismatchException, IOException {
        oIX0oI oix0oi = new oIX0oI();
        new oOoXoXO(str, reader, x0xoixoo, str2, oix0oi);
        return oix0oi.oxoX();
    }

    public static X0o0xo X0o0xo(String str, Reader reader) throws ParseException, IOException {
        oIX0oI oix0oi = new oIX0oI();
        new oOoXoXO(str, reader, (x0XOIxOo) null, (String) null, oix0oi);
        return oix0oi.oxoX();
    }

    public static X0o0xo XO(String str, Reader reader, x0XOIxOo x0xoixoo) throws ParseException, IOException {
        oIX0oI oix0oi = new oIX0oI();
        new oOoXoXO(str, reader, x0xoixoo, (String) null, oix0oi);
        return oix0oi.oxoX();
    }

    public static X0o0xo oIX0oI(String str) throws ParseException, IOException {
        return xxIXOIIO(str.toCharArray());
    }

    public static void oO(String str, Reader reader, x0XOIxOo x0xoixoo, ooOOo0oXI ooooo0oxi) throws ParseException, IOException {
        new oOoXoXO(str, reader, x0xoixoo, (String) null, ooooo0oxi);
    }

    public static void oOoXoXO(String str, InputStream inputStream, x0XOIxOo x0xoixoo, ooOOo0oXI ooooo0oxi) throws ParseException, IOException {
        new OOXIXo(str, inputStream, x0xoixoo, null, ooooo0oxi);
    }

    public static void ooOOo0oXI(String str, InputStream inputStream, x0XOIxOo x0xoixoo, String str2, ooOOo0oXI ooooo0oxi) throws ParseException, IOException {
        new OOXIXo(str, inputStream, x0xoixoo, str2, ooooo0oxi);
    }

    public static X0o0xo oxoX(String str, InputStream inputStream, x0XOIxOo x0xoixoo, String str2) throws ParseException, IOException {
        oIX0oI oix0oi = new oIX0oI();
        new OOXIXo(str, inputStream, x0xoixoo, str2, oix0oi);
        return oix0oi.oxoX();
    }

    public static void x0XOIxOo(String str, Reader reader, ooOOo0oXI ooooo0oxi) throws ParseException, IOException {
        new oOoXoXO(str, reader, (x0XOIxOo) null, (String) null, ooooo0oxi);
    }

    public static void x0xO0oo(String str, Reader reader, x0XOIxOo x0xoixoo, String str2, ooOOo0oXI ooooo0oxi) throws ParseException, EncodingMismatchException, IOException {
        new oOoXoXO(str, reader, x0xoixoo, str2, ooooo0oxi);
    }

    public static void xoIox(String str, ooOOo0oXI ooooo0oxi) throws ParseException, IOException {
        IXxxXO(str.toCharArray(), ooooo0oxi);
    }

    public static X0o0xo xxIXOIIO(char[] cArr) throws ParseException, IOException {
        oIX0oI oix0oi = new oIX0oI();
        new oOoXoXO("file:anonymous-string", cArr, (x0XOIxOo) null, (String) null, oix0oi);
        return oix0oi.oxoX();
    }
}
