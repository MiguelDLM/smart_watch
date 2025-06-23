package org.apache.commons.text;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Arrays;

@Deprecated
/* loaded from: classes6.dex */
public abstract class xxIXOIIO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final xxIXOIIO f33120oIX0oI = new oIX0oI(',');

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final xxIXOIIO f33116II0xO0 = new oIX0oI('\t');

    /* renamed from: I0Io, reason: collision with root package name */
    public static final xxIXOIIO f33114I0Io = new oIX0oI(TokenParser.SP);

    /* renamed from: oxoX, reason: collision with root package name */
    public static final xxIXOIIO f33121oxoX = new II0xO0(" \t\n\r\f".toCharArray());

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final xxIXOIIO f33118X0o0xo = new X0o0xo();

    /* renamed from: XO, reason: collision with root package name */
    public static final xxIXOIIO f33119XO = new oIX0oI('\'');

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final xxIXOIIO f33117Oxx0IOOO = new oIX0oI('\"');

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final xxIXOIIO f33115II0XooXoX = new II0xO0("'\"".toCharArray());

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final xxIXOIIO f33122xxIXOIIO = new I0Io();

    /* loaded from: classes6.dex */
    public static final class I0Io extends xxIXOIIO {
        @Override // org.apache.commons.text.xxIXOIIO
        public int Oxx0IOOO(char[] cArr, int i, int i2, int i3) {
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 extends xxIXOIIO {

        /* renamed from: xoIox, reason: collision with root package name */
        public final char[] f33123xoIox;

        public II0xO0(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.f33123xoIox = cArr2;
            Arrays.sort(cArr2);
        }

        @Override // org.apache.commons.text.xxIXOIIO
        public int Oxx0IOOO(char[] cArr, int i, int i2, int i3) {
            if (Arrays.binarySearch(this.f33123xoIox, cArr[i]) >= 0) {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static final class X0o0xo extends xxIXOIIO {
        @Override // org.apache.commons.text.xxIXOIIO
        public int Oxx0IOOO(char[] cArr, int i, int i2, int i3) {
            if (cArr[i] <= ' ') {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends xxIXOIIO {

        /* renamed from: xoIox, reason: collision with root package name */
        public final char f33124xoIox;

        public oIX0oI(char c) {
            this.f33124xoIox = c;
        }

        @Override // org.apache.commons.text.xxIXOIIO
        public int Oxx0IOOO(char[] cArr, int i, int i2, int i3) {
            if (this.f33124xoIox == cArr[i]) {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oxoX extends xxIXOIIO {

        /* renamed from: xoIox, reason: collision with root package name */
        public final char[] f33125xoIox;

        public oxoX(String str) {
            this.f33125xoIox = str.toCharArray();
        }

        @Override // org.apache.commons.text.xxIXOIIO
        public int Oxx0IOOO(char[] cArr, int i, int i2, int i3) {
            int length = this.f33125xoIox.length;
            if (i + length > i3) {
                return 0;
            }
            int i4 = 0;
            while (true) {
                char[] cArr2 = this.f33125xoIox;
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
            return super.toString() + TokenParser.SP + Arrays.toString(this.f33125xoIox);
        }
    }

    public static xxIXOIIO I0Io(char... cArr) {
        if (org.apache.commons.lang3.oxoX.x0(cArr)) {
            return f33122xxIXOIIO;
        }
        if (cArr.length == 1) {
            return new oIX0oI(cArr[0]);
        }
        return new II0xO0(cArr);
    }

    public static xxIXOIIO II0XooXoX() {
        return f33122xxIXOIIO;
    }

    public static xxIXOIIO II0xO0(String str) {
        if (str != null && str.length() != 0) {
            if (str.length() == 1) {
                return new oIX0oI(str.charAt(0));
            }
            return new II0xO0(str.toCharArray());
        }
        return f33122xxIXOIIO;
    }

    public static xxIXOIIO OOXIXo() {
        return f33114I0Io;
    }

    public static xxIXOIIO X0o0xo() {
        return f33117Oxx0IOOO;
    }

    public static xxIXOIIO oIX0oI(char c) {
        return new oIX0oI(c);
    }

    public static xxIXOIIO oO() {
        return f33118X0o0xo;
    }

    public static xxIXOIIO oOoXoXO() {
        return f33121oxoX;
    }

    public static xxIXOIIO ooOOo0oXI(String str) {
        if (str != null && str.length() != 0) {
            return new oxoX(str);
        }
        return f33122xxIXOIIO;
    }

    public static xxIXOIIO oxoX() {
        return f33120oIX0oI;
    }

    public static xxIXOIIO x0XOIxOo() {
        return f33116II0xO0;
    }

    public static xxIXOIIO xoIox() {
        return f33119XO;
    }

    public static xxIXOIIO xxIXOIIO() {
        return f33115II0XooXoX;
    }

    public abstract int Oxx0IOOO(char[] cArr, int i, int i2, int i3);

    public int XO(char[] cArr, int i) {
        return Oxx0IOOO(cArr, i, 0, cArr.length);
    }
}
