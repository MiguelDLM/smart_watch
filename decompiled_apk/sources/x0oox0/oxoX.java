package x0oox0;

import java.util.Arrays;

/* loaded from: classes13.dex */
public class oxoX implements II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public char[] f34039II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final char[] f34041oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final String f34042oxoX;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f34038I0Io = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f34040X0o0xo = 0;

    public oxoX(int i, String str) {
        this.f34039II0xO0 = new char[i];
        this.f34042oxoX = str;
        if (str == null) {
            this.f34041oIX0oI = null;
        } else {
            this.f34041oIX0oI = str.toCharArray();
        }
    }

    @Override // x0oox0.II0xO0
    public void I0Io() {
        this.f34040X0o0xo = 0;
    }

    @Override // x0oox0.II0xO0
    public String II0XooXoX() {
        String str = this.f34042oxoX;
        int i = this.f34038I0Io;
        int i2 = this.f34040X0o0xo;
        if (i > i2) {
            str = new String(this.f34039II0xO0, 0, i - i2);
        }
        this.f34038I0Io = 0;
        this.f34040X0o0xo = 0;
        return str;
    }

    @Override // x0oox0.II0xO0
    public void II0xO0(char c, char c2) {
        char[] cArr = this.f34039II0xO0;
        int i = this.f34038I0Io;
        this.f34038I0Io = i + 1;
        cArr[i] = c;
        if (c == c2) {
            this.f34040X0o0xo++;
        } else {
            this.f34040X0o0xo = 0;
        }
    }

    public void OOXIXo(oxoX oxox) {
        System.arraycopy(oxox.f34039II0xO0, 0, this.f34039II0xO0, this.f34038I0Io, oxox.f34038I0Io - oxox.f34040X0o0xo);
        this.f34038I0Io += oxox.f34038I0Io - oxox.f34040X0o0xo;
        oxox.reset();
    }

    @Override // x0oox0.II0xO0
    public int Oxx0IOOO() {
        return this.f34040X0o0xo;
    }

    @Override // x0oox0.II0xO0
    public void X0o0xo(char c) {
        char[] cArr = this.f34039II0xO0;
        System.arraycopy(cArr, 0, cArr, 1, this.f34038I0Io);
        this.f34039II0xO0[0] = c;
        this.f34038I0Io++;
    }

    @Override // x0oox0.II0xO0
    public char[] XO() {
        char[] cArr = this.f34041oIX0oI;
        int i = this.f34038I0Io;
        int i2 = this.f34040X0o0xo;
        if (i > i2) {
            cArr = Arrays.copyOf(this.f34039II0xO0, i - i2);
        }
        this.f34038I0Io = 0;
        this.f34040X0o0xo = 0;
        return cArr;
    }

    @Override // x0oox0.II0xO0
    public void append(char c) {
        char[] cArr = this.f34039II0xO0;
        int i = this.f34038I0Io;
        this.f34038I0Io = i + 1;
        cArr[i] = c;
    }

    @Override // x0oox0.II0xO0
    public final int length() {
        return this.f34038I0Io - this.f34040X0o0xo;
    }

    @Override // x0oox0.II0xO0
    public void oIX0oI(char c, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            char[] cArr = this.f34039II0xO0;
            int i3 = this.f34038I0Io;
            this.f34038I0Io = i3 + 1;
            cArr[i3] = c;
        }
    }

    @Override // x0oox0.II0xO0
    public char[] oxoX() {
        return this.f34039II0xO0;
    }

    @Override // x0oox0.II0xO0
    public void reset() {
        this.f34038I0Io = 0;
        this.f34040X0o0xo = 0;
    }

    public String toString() {
        int i = this.f34038I0Io;
        int i2 = this.f34040X0o0xo;
        if (i <= i2) {
            return this.f34042oxoX;
        }
        return new String(this.f34039II0xO0, 0, i - i2);
    }

    @Override // x0oox0.II0xO0
    public void xoIox(char c) {
        char[] cArr = this.f34039II0xO0;
        int i = this.f34038I0Io;
        this.f34038I0Io = i + 1;
        cArr[i] = c;
        if (c <= ' ') {
            this.f34040X0o0xo++;
        } else {
            this.f34040X0o0xo = 0;
        }
    }

    @Override // x0oox0.II0xO0
    public void xxIXOIIO(char c, char c2) {
        char[] cArr = this.f34039II0xO0;
        int i = this.f34038I0Io;
        this.f34038I0Io = i + 1;
        cArr[i] = c;
        if (c > ' ' && c != c2) {
            this.f34040X0o0xo = 0;
        } else {
            this.f34040X0o0xo++;
        }
    }
}
