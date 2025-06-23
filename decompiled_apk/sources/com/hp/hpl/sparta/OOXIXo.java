package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* loaded from: classes10.dex */
public class OOXIXo implements oO {

    /* renamed from: I0Io, reason: collision with root package name */
    public oOoXoXO f17139I0Io;

    public OOXIXo(String str, InputStream inputStream, x0XOIxOo x0xoixoo, String str2, ooOOo0oXI ooooo0oxi) throws ParseException, IOException {
        x0XOIxOo x0xoixoo2;
        String str3;
        if (x0xoixoo == null) {
            x0xoixoo2 = oO.f17179oIX0oI;
        } else {
            x0xoixoo2 = x0xoixoo;
        }
        if (inputStream.markSupported()) {
            inputStream.mark(oO.f17178II0xO0);
            byte[] bArr = new byte[4];
            int read = inputStream.read(bArr);
            if (str2 == null) {
                str3 = Oxx0IOOO(str, bArr, read, x0xoixoo2);
            } else {
                str3 = str2;
            }
            try {
                inputStream.reset();
                try {
                    this.f17139I0Io = new oOoXoXO(str, new InputStreamReader(inputStream, XO(str3)), x0xoixoo2, str3, ooooo0oxi);
                    return;
                } catch (IOException unused) {
                    x0xoixoo2.oIX0oI("Problem reading with assumed encoding of " + str3 + " so restarting with euc-jp", str, 1);
                    inputStream.reset();
                    try {
                        this.f17139I0Io = new oOoXoXO(str, new InputStreamReader(inputStream, XO("euc-jp")), x0xoixoo2, (String) null, ooooo0oxi);
                        return;
                    } catch (UnsupportedEncodingException unused2) {
                        throw new ParseException(x0xoixoo2, str, 1, 0, "euc-jp", "\"euc-jp\" is not a supported encoding");
                    }
                }
            } catch (EncodingMismatchException e) {
                String declaredEncoding = e.getDeclaredEncoding();
                x0xoixoo2.oIX0oI("Encoding declaration of " + declaredEncoding + " is different that assumed " + str3 + " so restarting the parsing with the new encoding", str, 1);
                inputStream.reset();
                try {
                    this.f17139I0Io = new oOoXoXO(str, new InputStreamReader(inputStream, XO(declaredEncoding)), x0xoixoo2, (String) null, ooooo0oxi);
                    return;
                } catch (UnsupportedEncodingException unused3) {
                    throw new ParseException(x0xoixoo2, str, 1, 0, declaredEncoding, "\"" + declaredEncoding + "\" is not a supported encoding");
                }
            }
        }
        throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
    }

    public static boolean I0Io(byte[] bArr, int i) {
        if (bArr[0] != ((byte) (i >>> 24)) || bArr[1] != ((byte) ((i >>> 16) & 255)) || bArr[2] != ((byte) ((i >>> 8) & 255)) || bArr[3] != ((byte) (i & 255))) {
            return false;
        }
        return true;
    }

    public static String II0XooXoX(byte b) {
        String hexString = Integer.toHexString(b);
        int length = hexString.length();
        if (length != 1) {
            if (length != 2) {
                return hexString.substring(hexString.length() - 2);
            }
            return hexString;
        }
        return "0" + hexString;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String Oxx0IOOO(java.lang.String r5, byte[] r6, int r7, com.hp.hpl.sparta.x0XOIxOo r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.OOXIXo.Oxx0IOOO(java.lang.String, byte[], int, com.hp.hpl.sparta.x0XOIxOo):java.lang.String");
    }

    public static boolean X0o0xo(byte[] bArr, short s) {
        if (bArr[0] != ((byte) (s >>> 8)) || bArr[1] != ((byte) (s & 255))) {
            return false;
        }
        return true;
    }

    public static String XO(String str) {
        if (str.toLowerCase().equals("utf8")) {
            return "UTF-8";
        }
        return str;
    }

    @Override // com.hp.hpl.sparta.oO
    public int II0xO0() {
        return this.f17139I0Io.II0xO0();
    }

    @Override // com.hp.hpl.sparta.oO
    public String oIX0oI() {
        return this.f17139I0Io.oIX0oI();
    }

    @Override // com.hp.hpl.sparta.oO
    public String toString() {
        return this.f17139I0Io.toString();
    }
}
