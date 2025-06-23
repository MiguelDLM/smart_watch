package x0oox0;

import com.univocity.parsers.common.OOXIXo;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* loaded from: classes13.dex */
public class xoIox extends oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final char f34043II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final char f34044Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public final char f34045XO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f34046xxIXOIIO;

    public xoIox(int i, String str, OOXIXo oOXIXo) {
        super(i, str);
        this.f34046xxIXOIIO = true;
        char[] X0o0xo2 = oOXIXo.X0o0xo();
        this.f34045XO = X0o0xo2[0];
        this.f34044Oxx0IOOO = X0o0xo2.length > 1 ? X0o0xo2[1] : (char) 0;
        this.f34043II0XooXoX = oOXIXo.Oxx0IOOO();
    }

    @Override // x0oox0.oxoX, x0oox0.II0xO0
    public void II0xO0(char c, char c2) {
        try {
            if (c == this.f34043II0XooXoX && this.f34046xxIXOIIO) {
                super.II0xO0(this.f34045XO, c2);
                char c3 = this.f34044Oxx0IOOO;
                if (c3 != 0) {
                    super.II0xO0(c3, c2);
                }
            } else {
                super.II0xO0(c, c2);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            IXxxXO();
            II0xO0(c, c2);
        }
    }

    public final void IXxxXO() {
        x0xO0oo();
        this.f34038I0Io--;
    }

    @Override // x0oox0.oxoX
    public void OOXIXo(oxoX oxox) {
        try {
            super.OOXIXo(oxox);
        } catch (ArrayIndexOutOfBoundsException unused) {
            Oo(oxox.f34038I0Io);
            super.OOXIXo(oxox);
        }
    }

    public final void Oo(int i) {
        this.f34039II0xO0 = Arrays.copyOf(this.f34039II0xO0, (int) ((this.f34038I0Io + i) * 1.5d));
    }

    public void Oxx0xo() {
        this.f34040X0o0xo = 0;
        for (int i = this.f34038I0Io - 1; i >= 0 && this.f34039II0xO0[i] <= ' '; i--) {
            this.f34040X0o0xo++;
        }
    }

    @Override // x0oox0.oxoX, x0oox0.II0xO0
    public void append(char c) {
        if (c == this.f34043II0XooXoX && this.f34046xxIXOIIO) {
            x0XOIxOo();
        } else {
            ooOOo0oXI(c);
        }
    }

    public void oI0IIXIo(Writer writer) throws IOException {
        int i = this.f34038I0Io;
        int i2 = this.f34040X0o0xo;
        if (i - i2 > 0) {
            writer.write(this.f34039II0xO0, 0, i - i2);
        } else {
            char[] cArr = this.f34041oIX0oI;
            if (cArr != null) {
                writer.write(cArr, 0, cArr.length);
            }
        }
        this.f34038I0Io = 0;
        this.f34040X0o0xo = 0;
    }

    @Override // x0oox0.oxoX, x0oox0.II0xO0
    public void oIX0oI(char c, int i) {
        while (this.f34038I0Io + i > this.f34039II0xO0.length) {
            Oo(i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            char[] cArr = this.f34039II0xO0;
            int i3 = this.f34038I0Io;
            this.f34038I0Io = i3 + 1;
            cArr[i3] = c;
        }
    }

    public void oO(boolean z) {
        this.f34046xxIXOIIO = z;
    }

    public void oOoXoXO(String str, int i, int i2) {
        try {
            str.getChars(i, i2, this.f34039II0xO0, this.f34038I0Io);
        } catch (ArrayIndexOutOfBoundsException unused) {
            Oo(i2 - i);
            str.getChars(i, i2, this.f34039II0xO0, this.f34038I0Io);
        }
        this.f34038I0Io += i2 - i;
    }

    public final void ooOOo0oXI(char c) {
        try {
            char[] cArr = this.f34039II0xO0;
            int i = this.f34038I0Io;
            this.f34038I0Io = i + 1;
            cArr[i] = c;
        } catch (ArrayIndexOutOfBoundsException unused) {
            IXxxXO();
            ooOOo0oXI(c);
        }
    }

    public void x0XOIxOo() {
        if (this.f34038I0Io + 2 >= this.f34039II0xO0.length) {
            x0xO0oo();
        }
        char[] cArr = this.f34039II0xO0;
        int i = this.f34038I0Io;
        int i2 = i + 1;
        this.f34038I0Io = i2;
        cArr[i] = this.f34045XO;
        char c = this.f34044Oxx0IOOO;
        if (c != 0) {
            this.f34038I0Io = i + 2;
            cArr[i2] = c;
        }
    }

    public final void x0xO0oo() {
        this.f34039II0xO0 = Arrays.copyOf(this.f34039II0xO0, (int) (r0.length * 1.5d));
    }

    @Override // x0oox0.oxoX, x0oox0.II0xO0
    public void xoIox(char c) {
        try {
            if (c == this.f34043II0XooXoX && this.f34046xxIXOIIO) {
                super.xoIox(this.f34045XO);
                char c2 = this.f34044Oxx0IOOO;
                if (c2 != 0) {
                    super.xoIox(c2);
                }
            } else {
                super.xoIox(c);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            IXxxXO();
            xoIox(c);
        }
    }

    @Override // x0oox0.oxoX, x0oox0.II0xO0
    public void xxIXOIIO(char c, char c2) {
        try {
            if (c == this.f34043II0XooXoX && this.f34046xxIXOIIO) {
                super.xxIXOIIO(this.f34045XO, c2);
                char c3 = this.f34044Oxx0IOOO;
                if (c3 != 0) {
                    super.xxIXOIIO(c3, c2);
                }
            } else {
                super.xxIXOIIO(c, c2);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            IXxxXO();
            II0xO0(c, c2);
        }
    }
}
