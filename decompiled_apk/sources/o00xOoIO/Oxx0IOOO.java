package o00xOoIO;

import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes13.dex */
public class Oxx0IOOO extends com.univocity.parsers.common.II0xO0<II0XooXoX> {

    /* renamed from: IIX0o, reason: collision with root package name */
    public char f31046IIX0o;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public char f31047O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public char f31048OxI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public char f31049X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public boolean f31050XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public boolean f31051XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public boolean f31052XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public char f31053o00;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public char f31054oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public boolean f31055ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public boolean[] f31056xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public boolean f31057xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f31058xxX;

    public Oxx0IOOO(II0XooXoX iI0XooXoX) {
        this((Writer) null, iI0XooXoX);
    }

    public final boolean IOoo(int i, String str) {
        int length = str.length();
        if (this.f31054oo0xXOI0I == 0) {
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt == this.f31053o00 || charAt == this.f31046IIX0o) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (charAt2 == this.f31053o00 || charAt2 == this.f31046IIX0o || (charAt2 < this.f31054oo0xXOI0I && this.f31056xI[charAt2])) {
                return true;
            }
            i++;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.univocity.parsers.common.II0xO0
    /* renamed from: XI, reason: merged with bridge method [inline-methods] */
    public final void IIXOooo(II0XooXoX iI0XooXoX) {
        II0xO0 iI0xO0 = (II0xO0) iI0XooXoX.xxIXOIIO();
        this.f31053o00 = iI0xO0.Oo();
        this.f31048OxI = iI0xO0.IXxxXO();
        this.f31047O0xOxO = iI0xO0.Oxx0xo();
        this.f31049X0IIOO = ((II0xO0) iI0XooXoX.xxIXOIIO()).x0xO0oo();
        this.f31046IIX0o = iI0xO0.Oxx0IOOO();
        this.f31058xxX = iI0XooXoX.XOxIOxOx();
        this.f31050XI0IXoo = iI0XooXoX.OOXIXo();
        this.f31051XIxXXX0x0 = iI0XooXoX.oOoXoXO();
        this.f31052XxX0x0xxx = iI0XooXoX.OI0();
        this.f31057xXxxox0I = !iI0XooXoX.Io();
        this.f31055ooXIXxIX = !iI0XooXoX.o0();
        this.f31056xI = null;
        this.f31054oo0xXOI0I = (char) 0;
        int length = iI0XooXoX.x0o().length;
        boolean I0oOoX2 = iI0XooXoX.I0oOoX();
        char[] copyOf = Arrays.copyOf(iI0XooXoX.x0o(), length + (I0oOoX2 ? 1 : 0));
        if (I0oOoX2) {
            copyOf[length] = this.f31048OxI;
        }
        for (char c : copyOf) {
            if (this.f31054oo0xXOI0I < c) {
                this.f31054oo0xXOI0I = c;
            }
        }
        char c2 = this.f31054oo0xXOI0I;
        if (c2 != 0) {
            int i = (char) (c2 + 1);
            this.f31054oo0xXOI0I = i;
            boolean[] zArr = new boolean[i];
            this.f31056xI = zArr;
            Arrays.fill(zArr, false);
            for (char c3 : copyOf) {
                this.f31056xI[c3] = true;
            }
        }
    }

    public final void XOxxooXI(int i, String str) {
        char c;
        int length = str.length();
        int i2 = i;
        char c2 = 0;
        while (i < length) {
            c2 = str.charAt(i);
            if (c2 == this.f31048OxI || c2 == this.f31046IIX0o || c2 == this.f31047O0xOxO) {
                this.f27038x0XOIxOo.oOoXoXO(str, i2, i);
                i2 = i + 1;
                if (c2 == this.f31048OxI && this.f31057xXxxox0I) {
                    this.f27038x0XOIxOo.append(this.f31047O0xOxO);
                } else if (c2 == this.f31047O0xOxO && this.f31057xXxxox0I && (c = this.f31049X0IIOO) != 0) {
                    this.f27038x0XOIxOo.append(c);
                }
                this.f27038x0XOIxOo.append(c2);
            }
            i++;
        }
        this.f27038x0XOIxOo.oOoXoXO(str, i2, i);
        if (c2 <= ' ' && this.f31051XIxXXX0x0) {
            this.f27038x0XOIxOo.Oxx0xo();
        }
    }

    @Override // com.univocity.parsers.common.II0xO0
    public void o0(Object[] objArr) {
        for (int i = 0; i < objArr.length; i++) {
            if (i != 0) {
                II0XooXoX(this.f31053o00);
            }
            if (this.f31055ooXIXxIX) {
                this.f27038x0XOIxOo.oO(false);
            }
            String OxxIIOOXO2 = OxxIIOOXO(objArr[i]);
            int length = this.f27038x0XOIxOo.length();
            boolean oXxOI0oIx2 = oXxOI0oIx(this.f31058xxX, OxxIIOOXO2);
            if (this.f27038x0XOIxOo.length() == length) {
                if (oXxOI0oIx2) {
                    if (OxxIIOOXO2 == null) {
                        oXxOI0oIx(false, this.f27035oOoXoXO);
                    } else {
                        oXxOI0oIx(true, this.f27036ooOOo0oXI);
                    }
                } else {
                    oXxOI0oIx(false, this.f27035oOoXoXO);
                }
            }
            if (oXxOI0oIx2) {
                II0XooXoX(this.f31048OxI);
                xxIXOIIO();
                II0XooXoX(this.f31048OxI);
                if (this.f31055ooXIXxIX) {
                    this.f27038x0XOIxOo.oO(true);
                }
            } else {
                xxIXOIIO();
            }
        }
    }

    public final boolean oXxOI0oIx(boolean z, String str) {
        int i;
        char c;
        if (str == null) {
            str = this.f27035oOoXoXO;
        }
        if (str == null) {
            return z;
        }
        if (this.f31050XI0IXoo) {
            i = com.univocity.parsers.common.II0xO0.XoX(str);
        } else {
            i = 0;
        }
        int length = str.length();
        if (i < length && str.charAt(i) == this.f31048OxI) {
            z = true;
        }
        if (z) {
            XOxxooXI(i, str);
            return true;
        }
        int i2 = i;
        char c2 = 0;
        while (i < length) {
            c2 = str.charAt(i);
            if (c2 == this.f31048OxI || c2 == this.f31053o00 || c2 == this.f31046IIX0o || c2 == this.f31047O0xOxO || (c2 < this.f31054oo0xXOI0I && this.f31056xI[c2])) {
                this.f27038x0XOIxOo.oOoXoXO(str, i2, i);
                i2 = i + 1;
                if (c2 == this.f31048OxI) {
                    if (IOoo(i, str)) {
                        XOxxooXI(i, str);
                        return true;
                    }
                    if (this.f31052XxX0x0xxx) {
                        XOxxooXI(i, str);
                    } else {
                        this.f27038x0XOIxOo.oOoXoXO(str, i, length);
                        if (this.f31051XIxXXX0x0 && str.charAt(length - 1) <= ' ') {
                            this.f27038x0XOIxOo.Oxx0xo();
                        }
                    }
                    return z;
                }
                if (c2 == this.f31047O0xOxO && this.f31057xXxxox0I && (c = this.f31049X0IIOO) != 0 && this.f31052XxX0x0xxx) {
                    this.f27038x0XOIxOo.append(c);
                } else if (c2 == this.f31053o00 || c2 == this.f31046IIX0o || (c2 < this.f31054oo0xXOI0I && this.f31056xI[c2])) {
                    XOxxooXI(i, str);
                    return true;
                }
                this.f27038x0XOIxOo.append(c2);
            }
            i++;
        }
        this.f27038x0XOIxOo.oOoXoXO(str, i2, i);
        if (c2 <= ' ' && this.f31051XIxXXX0x0) {
            this.f27038x0XOIxOo.Oxx0xo();
        }
        return z;
    }

    public Oxx0IOOO(Writer writer, II0XooXoX iI0XooXoX) {
        super(writer, iI0XooXoX);
    }

    public Oxx0IOOO(File file, II0XooXoX iI0XooXoX) {
        super(file, iI0XooXoX);
    }

    public Oxx0IOOO(File file, String str, II0XooXoX iI0XooXoX) {
        super(file, str, iI0XooXoX);
    }

    public Oxx0IOOO(File file, Charset charset, II0XooXoX iI0XooXoX) {
        super(file, charset, iI0XooXoX);
    }

    public Oxx0IOOO(OutputStream outputStream, II0XooXoX iI0XooXoX) {
        super(outputStream, iI0XooXoX);
    }

    public Oxx0IOOO(OutputStream outputStream, String str, II0XooXoX iI0XooXoX) {
        super(outputStream, str, iI0XooXoX);
    }

    public Oxx0IOOO(OutputStream outputStream, Charset charset, II0XooXoX iI0XooXoX) {
        super(outputStream, charset, iI0XooXoX);
    }
}
