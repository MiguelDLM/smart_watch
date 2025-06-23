package x0oox0;

import com.univocity.parsers.common.OOXIXo;
import com.univocity.parsers.common.input.EOFException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes13.dex */
public abstract class oIX0oI implements I0Io {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final char f34019II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public char f34024Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public char f34027XO;

    /* renamed from: oO, reason: collision with root package name */
    public int f34029oO;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public char[] f34034x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public long f34035xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public long f34036xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final II0xO0 f34028oIX0oI = xxIXOIIO.OOXIXo();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final StringBuilder f34020II0xO0 = new StringBuilder(50);

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f34018I0Io = false;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public List<XO> f34026X0o0xo = null;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public char f34022OOXIXo = 0;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public char f34030oOoXoXO = 0;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public char f34031ooOOo0oXI = 0;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public char f34033x0XOIxOo = 0;

    /* renamed from: Oo, reason: collision with root package name */
    public int f34023Oo = -1;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f34021IXxxXO = false;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f34025Oxx0xo = true;

    /* renamed from: oxoX, reason: collision with root package name */
    public final boolean f34032oxoX = true;

    /* renamed from: x0oox0.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C1149oIX0oI extends Oxx0IOOO {
        public C1149oIX0oI() {
        }

        @Override // x0oox0.Oxx0IOOO
        public void II0xO0(char c, char c2) {
            if (c != 0) {
                oIX0oI.this.f34018I0Io = true;
                oIX0oI.this.f34027XO = c;
                oIX0oI.this.f34024Oxx0IOOO = c2;
                return;
            }
            oIX0oI.this.OxI(OOXIXo.II0XooXoX());
        }
    }

    public oIX0oI(char c) {
        X0IIOO();
        this.f34027XO = (char) 0;
        this.f34024Oxx0IOOO = (char) 0;
        this.f34019II0XooXoX = c;
    }

    @Override // x0oox0.I0Io
    public final long I0Io() {
        return this.f34036xxIXOIIO;
    }

    @Override // x0oox0.I0Io
    public final char II0XooXoX(char c, II0xO0 iI0xO0) {
        if (iI0xO0 == this.f34028oIX0oI) {
            while (c != this.f34022OOXIXo && c != this.f34019II0XooXoX) {
                c = Oxx0IOOO();
            }
        } else {
            oxoX oxox = (oxoX) iI0xO0;
            while (c != this.f34022OOXIXo && c != this.f34019II0XooXoX) {
                char[] cArr = oxox.f34039II0xO0;
                int i = oxox.f34038I0Io;
                oxox.f34038I0Io = i + 1;
                cArr[i] = c;
                c = Oxx0IOOO();
            }
        }
        return c;
    }

    @Override // x0oox0.I0Io
    public final void II0xO0(char c) {
        this.f34022OOXIXo = c;
    }

    @Override // x0oox0.I0Io
    public final void IXxxXO(char c) {
        this.f34031ooOOo0oXI = c;
    }

    public abstract void O0xOxO(Reader reader);

    @Override // x0oox0.I0Io
    public final long OOXIXo() {
        return this.f34035xoIox + this.f34029oO;
    }

    @Override // x0oox0.I0Io
    public final void Oo(Reader reader) {
        stop();
        O0xOxO(reader);
        this.f34036xxIXOIIO = 0L;
        this.f34018I0Io = false;
        X0IIOO();
        XIxXXX0x0();
        if (this.f34023Oo > 0) {
            this.f34029oO++;
        }
    }

    public final void OxI(char[] cArr) {
        if (cArr != null && cArr.length != 0) {
            if (cArr.length <= 2) {
                char c = 0;
                this.f34027XO = cArr[0];
                if (cArr.length == 2) {
                    c = cArr[1];
                }
                this.f34024Oxx0IOOO = c;
                return;
            }
            throw new IllegalArgumentException("Invalid line separator. Up to 2 characters are expected. Got " + cArr.length + " characters.");
        }
        throw new IllegalArgumentException("Invalid line separator. Expected 1 to 2 characters");
    }

    @Override // x0oox0.I0Io
    public final char Oxx0IOOO() {
        char c;
        if (this.f34023Oo == -1) {
            XI0IXoo();
        }
        char[] cArr = this.f34034x0xO0oo;
        int i = this.f34029oO;
        char c2 = cArr[i - 1];
        if (i >= this.f34023Oo) {
            XIxXXX0x0();
        }
        int i2 = this.f34029oO;
        int i3 = i2 + 1;
        this.f34029oO = i3;
        if (this.f34027XO == c2 && ((c = this.f34024Oxx0IOOO) == 0 || (this.f34023Oo != -1 && c == this.f34034x0xO0oo[i2]))) {
            this.f34036xxIXOIIO++;
            if (this.f34025Oxx0xo) {
                if (c == 0) {
                    return this.f34019II0XooXoX;
                }
                c2 = this.f34019II0XooXoX;
                int i4 = this.f34023Oo;
                if (i3 >= i4) {
                    if (i4 != -1) {
                        XIxXXX0x0();
                    } else {
                        XI0IXoo();
                    }
                }
                this.f34029oO++;
            }
        }
        return c2;
    }

    public final void X0IIOO() {
        if (this.f34032oxoX && !this.f34018I0Io) {
            xoXoI(new C1149oIX0oI());
        }
    }

    @Override // x0oox0.I0Io
    public final char X0o0xo(char c, II0xO0 iI0xO0) {
        if (iI0xO0 == this.f34028oIX0oI) {
            while (c != this.f34022OOXIXo && c != this.f34019II0XooXoX) {
                c = Oxx0IOOO();
            }
        } else {
            oxoX oxox = (oxoX) iI0xO0;
            while (c != this.f34022OOXIXo && c != this.f34019II0XooXoX) {
                char[] cArr = oxox.f34039II0xO0;
                int i = oxox.f34038I0Io;
                oxox.f34038I0Io = i + 1;
                cArr[i] = c;
                if (c <= ' ') {
                    oxox.f34040X0o0xo++;
                } else {
                    oxox.f34040X0o0xo = 0;
                }
                c = Oxx0IOOO();
            }
        }
        return c;
    }

    public final void XI0IXoo() {
        if (this.f34021IXxxXO) {
            this.f34036xxIXOIIO++;
        }
        throw new EOFException();
    }

    public final void XIxXXX0x0() {
        o00();
        this.f34035xoIox += this.f34029oO;
        this.f34029oO = 0;
        if (this.f34023Oo == -1) {
            stop();
            this.f34021IXxxXO = true;
        }
        List<XO> list = this.f34026X0o0xo;
        if (list != null) {
            try {
                Iterator<XO> it = list.iterator();
                while (it.hasNext()) {
                    it.next().oIX0oI(this.f34034x0xO0oo, this.f34023Oo);
                }
            } finally {
                this.f34026X0o0xo = null;
            }
        }
    }

    @Override // x0oox0.I0Io
    public final char XO(char c) {
        while (c <= ' ' && c != this.f34022OOXIXo && c != this.f34019II0XooXoX) {
            c = Oxx0IOOO();
        }
        return c;
    }

    public abstract void o00();

    @Override // x0oox0.I0Io
    public final void oIX0oI(long j) {
        long j2;
        if (j < 1) {
            return;
        }
        long j3 = this.f34036xxIXOIIO + j;
        do {
            try {
                Oxx0IOOO();
                j2 = this.f34036xxIXOIIO;
            } catch (EOFException unused) {
                throw new IllegalArgumentException("Unable to skip " + j + " lines from line " + (j3 - j) + ". End of input reached");
            }
        } while (j2 < j3);
        if (j2 >= j) {
            return;
        }
        throw new IllegalArgumentException("Unable to skip " + j + " lines from line " + (j3 - j) + ". End of input reached");
    }

    @Override // x0oox0.I0Io
    public final char oO(char c, II0xO0 iI0xO0) {
        if (iI0xO0 == this.f34028oIX0oI) {
            while (c != this.f34022OOXIXo && c != this.f34019II0XooXoX && c != this.f34030oOoXoXO) {
                c = Oxx0IOOO();
            }
        } else {
            oxoX oxox = (oxoX) iI0xO0;
            while (c != this.f34022OOXIXo && c != this.f34019II0XooXoX && c != this.f34030oOoXoXO) {
                char[] cArr = oxox.f34039II0xO0;
                int i = oxox.f34038I0Io;
                oxox.f34038I0Io = i + 1;
                cArr[i] = c;
                if (c <= ' ') {
                    oxox.f34040X0o0xo++;
                } else {
                    oxox.f34040X0o0xo = 0;
                }
                c = Oxx0IOOO();
            }
        }
        return c;
    }

    @Override // x0oox0.I0Io
    public final void oOoXoXO(char c) {
        this.f34030oOoXoXO = c;
    }

    @Override // x0oox0.I0Io
    public final char ooOOo0oXI(char c, II0xO0 iI0xO0) {
        if (iI0xO0 == this.f34028oIX0oI) {
            while (c != this.f34030oOoXoXO && c != this.f34031ooOOo0oXI && c != this.f34033x0XOIxOo) {
                c = Oxx0IOOO();
            }
        } else {
            oxoX oxox = (oxoX) iI0xO0;
            while (c != this.f34030oOoXoXO && c != this.f34031ooOOo0oXI && c != this.f34033x0XOIxOo) {
                char[] cArr = oxox.f34039II0xO0;
                int i = oxox.f34038I0Io;
                oxox.f34038I0Io = i + 1;
                cArr[i] = c;
                c = Oxx0IOOO();
            }
        }
        return c;
    }

    @Override // x0oox0.I0Io
    public final void oxoX(char c) {
        this.f34033x0XOIxOo = c;
    }

    @Override // x0oox0.I0Io
    public final void x0XOIxOo(boolean z) {
        this.f34025Oxx0xo = z;
    }

    @Override // x0oox0.I0Io
    public char[] x0xO0oo() {
        char c = this.f34024Oxx0IOOO;
        if (c != 0) {
            return new char[]{this.f34027XO, c};
        }
        return new char[]{this.f34027XO};
    }

    @Override // x0oox0.I0Io
    public String xoIox() {
        this.f34020II0xO0.setLength(0);
        long j = this.f34036xxIXOIIO + 1;
        while (true) {
            try {
                char Oxx0IOOO2 = Oxx0IOOO();
                if (this.f34036xxIXOIIO < j) {
                    this.f34020II0xO0.append(Oxx0IOOO2);
                } else {
                    return this.f34020II0xO0.toString();
                }
            } catch (EOFException unused) {
                return this.f34020II0xO0.toString();
            }
        }
    }

    public final void xoXoI(XO xo2) {
        if (xo2 == null) {
            return;
        }
        if (this.f34026X0o0xo == null) {
            this.f34026X0o0xo = new ArrayList();
        }
        this.f34026X0o0xo.add(xo2);
    }

    @Override // x0oox0.I0Io
    public final char xxIXOIIO(char c, II0xO0 iI0xO0) {
        if (iI0xO0 == this.f34028oIX0oI) {
            while (c != this.f34022OOXIXo && c != this.f34019II0XooXoX && c != this.f34030oOoXoXO) {
                c = Oxx0IOOO();
            }
        } else {
            oxoX oxox = (oxoX) iI0xO0;
            while (c != this.f34022OOXIXo && c != this.f34019II0XooXoX && c != this.f34030oOoXoXO) {
                char[] cArr = oxox.f34039II0xO0;
                int i = oxox.f34038I0Io;
                oxox.f34038I0Io = i + 1;
                cArr[i] = c;
                c = Oxx0IOOO();
            }
        }
        return c;
    }

    public oIX0oI(char[] cArr, char c) {
        this.f34019II0XooXoX = c;
        OxI(cArr);
    }
}
