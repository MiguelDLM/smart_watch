package org.apache.commons.lang3.text;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Arrays;
import org.apache.commons.lang3.xXOx;

@Deprecated
/* loaded from: classes6.dex */
public abstract class oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final oxoX f32810oIX0oI = new oIX0oI(',');

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final oxoX f32806II0xO0 = new oIX0oI('\t');

    /* renamed from: I0Io, reason: collision with root package name */
    public static final oxoX f32804I0Io = new oIX0oI(TokenParser.SP);

    /* renamed from: oxoX, reason: collision with root package name */
    public static final oxoX f32811oxoX = new II0xO0(" \t\n\r\f".toCharArray());

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final oxoX f32808X0o0xo = new X0o0xo();

    /* renamed from: XO, reason: collision with root package name */
    public static final oxoX f32809XO = new oIX0oI('\'');

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final oxoX f32807Oxx0IOOO = new oIX0oI('\"');

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final oxoX f32805II0XooXoX = new II0xO0("'\"".toCharArray());

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final oxoX f32812xxIXOIIO = new I0Io();

    /* loaded from: classes6.dex */
    public static final class I0Io extends oxoX {
        @Override // org.apache.commons.lang3.text.oxoX
        public int Oxx0IOOO(char[] cArr, int i, int i2, int i3) {
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 extends oxoX {

        /* renamed from: xoIox, reason: collision with root package name */
        public final char[] f32813xoIox;

        public II0xO0(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.f32813xoIox = cArr2;
            Arrays.sort(cArr2);
        }

        @Override // org.apache.commons.lang3.text.oxoX
        public int Oxx0IOOO(char[] cArr, int i, int i2, int i3) {
            if (Arrays.binarySearch(this.f32813xoIox, cArr[i]) >= 0) {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static final class X0o0xo extends oxoX {
        @Override // org.apache.commons.lang3.text.oxoX
        public int Oxx0IOOO(char[] cArr, int i, int i2, int i3) {
            if (cArr[i] <= ' ') {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends oxoX {

        /* renamed from: xoIox, reason: collision with root package name */
        public final char f32814xoIox;

        public oIX0oI(char c) {
            this.f32814xoIox = c;
        }

        @Override // org.apache.commons.lang3.text.oxoX
        public int Oxx0IOOO(char[] cArr, int i, int i2, int i3) {
            if (this.f32814xoIox == cArr[i]) {
                return 1;
            }
            return 0;
        }
    }

    /* renamed from: org.apache.commons.lang3.text.oxoX$oxoX, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1138oxoX extends oxoX {

        /* renamed from: xoIox, reason: collision with root package name */
        public final char[] f32815xoIox;

        public C1138oxoX(String str) {
            this.f32815xoIox = str.toCharArray();
        }

        @Override // org.apache.commons.lang3.text.oxoX
        public int Oxx0IOOO(char[] cArr, int i, int i2, int i3) {
            int length = this.f32815xoIox.length;
            if (i + length > i3) {
                return 0;
            }
            int i4 = 0;
            while (true) {
                char[] cArr2 = this.f32815xoIox;
                if (i4 < cArr2.length) {
                    if (cArr2[i4] != cArr[i]) {
                        return 0;
                    }
                    i4++;
                    i++;
                } else {
                    return length;
                }
            }
        }

        public String toString() {
            return super.toString() + TokenParser.SP + Arrays.toString(this.f32815xoIox);
        }
    }

    public static oxoX I0Io(char... cArr) {
        if (cArr != null && cArr.length != 0) {
            if (cArr.length == 1) {
                return new oIX0oI(cArr[0]);
            }
            return new II0xO0(cArr);
        }
        return f32812xxIXOIIO;
    }

    public static oxoX II0XooXoX() {
        return f32812xxIXOIIO;
    }

    public static oxoX II0xO0(String str) {
        if (xXOx.XIXIX(str)) {
            return f32812xxIXOIIO;
        }
        if (str.length() == 1) {
            return new oIX0oI(str.charAt(0));
        }
        return new II0xO0(str.toCharArray());
    }

    public static oxoX OOXIXo() {
        return f32804I0Io;
    }

    public static oxoX X0o0xo() {
        return f32807Oxx0IOOO;
    }

    public static oxoX oIX0oI(char c) {
        return new oIX0oI(c);
    }

    public static oxoX oO() {
        return f32808X0o0xo;
    }

    public static oxoX oOoXoXO() {
        return f32811oxoX;
    }

    public static oxoX ooOOo0oXI(String str) {
        if (xXOx.XIXIX(str)) {
            return f32812xxIXOIIO;
        }
        return new C1138oxoX(str);
    }

    public static oxoX oxoX() {
        return f32810oIX0oI;
    }

    public static oxoX x0XOIxOo() {
        return f32806II0xO0;
    }

    public static oxoX xoIox() {
        return f32809XO;
    }

    public static oxoX xxIXOIIO() {
        return f32805II0XooXoX;
    }

    public abstract int Oxx0IOOO(char[] cArr, int i, int i2, int i3);

    public int XO(char[] cArr, int i) {
        return Oxx0IOOO(cArr, i, 0, cArr.length);
    }
}
