package x0oox0;

import com.univocity.parsers.common.input.EOFException;
import java.io.Reader;
import java.util.Arrays;

/* loaded from: classes13.dex */
public class II0XooXoX implements I0Io {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final char f34013X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public char f34014XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final I0Io f34015oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public char[] f34012II0xO0 = new char[0];

    /* renamed from: I0Io, reason: collision with root package name */
    public int f34011I0Io = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f34016oxoX = 0;

    public II0XooXoX(I0Io i0Io, char c) {
        this.f34015oIX0oI = i0Io;
        this.f34013X0o0xo = c;
    }

    @Override // x0oox0.I0Io
    public long I0Io() {
        return this.f34015oIX0oI.I0Io();
    }

    @Override // x0oox0.I0Io
    public char II0XooXoX(char c, II0xO0 iI0xO0) {
        return this.f34015oIX0oI.II0XooXoX(c, iI0xO0);
    }

    @Override // x0oox0.I0Io
    public void II0xO0(char c) {
        this.f34014XO = c;
        this.f34015oIX0oI.II0xO0(c);
    }

    public boolean IIXOooo(char c, char[] cArr) {
        if (cArr.length > this.f34011I0Io - this.f34016oxoX || cArr[0] != c) {
            return false;
        }
        for (int i = 1; i < cArr.length; i++) {
            if (cArr[i] != this.f34012II0xO0[(i - 1) + this.f34016oxoX]) {
                return false;
            }
        }
        return true;
    }

    @Override // x0oox0.I0Io
    public void IXxxXO(char c) {
        this.f34015oIX0oI.IXxxXO(c);
    }

    @Override // x0oox0.I0Io
    public long OOXIXo() {
        return this.f34015oIX0oI.OOXIXo();
    }

    @Override // x0oox0.I0Io
    public void Oo(Reader reader) {
        this.f34015oIX0oI.Oo(reader);
    }

    @Override // x0oox0.I0Io
    public char Oxx0IOOO() {
        int i = this.f34016oxoX;
        if (i >= this.f34011I0Io) {
            return this.f34015oIX0oI.Oxx0IOOO();
        }
        char[] cArr = this.f34012II0xO0;
        this.f34016oxoX = i + 1;
        return cArr[i];
    }

    public String Oxx0xo() {
        int i = this.f34016oxoX;
        int i2 = this.f34011I0Io;
        if (i >= i2) {
            return "";
        }
        return new String(this.f34012II0xO0, i, i2);
    }

    public void OxxIIOOXO(int i) {
        int i2 = i + (this.f34011I0Io - this.f34016oxoX);
        char[] cArr = this.f34012II0xO0;
        if (cArr.length < i2) {
            this.f34012II0xO0 = Arrays.copyOf(cArr, i2);
        }
        if (this.f34016oxoX >= this.f34011I0Io) {
            this.f34016oxoX = 0;
            this.f34011I0Io = 0;
        }
        try {
            int i3 = i2 - this.f34011I0Io;
            while (true) {
                int i4 = i3 - 1;
                if (i3 > 0) {
                    this.f34012II0xO0[this.f34011I0Io] = this.f34015oIX0oI.Oxx0IOOO();
                    this.f34011I0Io++;
                    i3 = i4;
                } else {
                    return;
                }
            }
        } catch (EOFException unused) {
        }
    }

    @Override // x0oox0.I0Io
    public char X0o0xo(char c, II0xO0 iI0xO0) {
        return this.f34015oIX0oI.X0o0xo(c, iI0xO0);
    }

    @Override // x0oox0.I0Io
    public char XO(char c) {
        while (true) {
            int i = this.f34016oxoX;
            if (i >= this.f34011I0Io || c > ' ' || c == this.f34014XO || c == this.f34013X0o0xo) {
                break;
            }
            char[] cArr = this.f34012II0xO0;
            this.f34016oxoX = i + 1;
            c = cArr[i];
        }
        return this.f34015oIX0oI.XO(c);
    }

    public String oI0IIXIo(char c) {
        if (this.f34016oxoX >= this.f34011I0Io) {
            return String.valueOf(c);
        }
        return c + new String(this.f34012II0xO0, this.f34016oxoX, this.f34011I0Io - 1);
    }

    @Override // x0oox0.I0Io
    public void oIX0oI(long j) {
        this.f34015oIX0oI.oIX0oI(j);
    }

    @Override // x0oox0.I0Io
    public char oO(char c, II0xO0 iI0xO0) {
        return this.f34015oIX0oI.oO(c, iI0xO0);
    }

    @Override // x0oox0.I0Io
    public void oOoXoXO(char c) {
        this.f34015oIX0oI.oOoXoXO(c);
    }

    @Override // x0oox0.I0Io
    public char ooOOo0oXI(char c, II0xO0 iI0xO0) {
        return this.f34015oIX0oI.ooOOo0oXI(c, iI0xO0);
    }

    @Override // x0oox0.I0Io
    public void oxoX(char c) {
        this.f34015oIX0oI.oxoX(c);
    }

    @Override // x0oox0.I0Io
    public void stop() {
        this.f34015oIX0oI.stop();
    }

    @Override // x0oox0.I0Io
    public void x0XOIxOo(boolean z) {
        this.f34015oIX0oI.x0XOIxOo(z);
    }

    @Override // x0oox0.I0Io
    public char[] x0xO0oo() {
        return this.f34015oIX0oI.x0xO0oo();
    }

    @Override // x0oox0.I0Io
    public String xoIox() {
        return this.f34015oIX0oI.xoIox();
    }

    public boolean xoXoI(char[] cArr) {
        if (cArr.length > this.f34011I0Io - this.f34016oxoX) {
            return false;
        }
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] != this.f34012II0xO0[this.f34016oxoX + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // x0oox0.I0Io
    public char xxIXOIIO(char c, II0xO0 iI0xO0) {
        return this.f34015oIX0oI.xxIXOIIO(c, iI0xO0);
    }
}
