package jxl.biff.formula;

import java.util.Stack;

/* loaded from: classes6.dex */
public class IoOoo implements XX {

    /* renamed from: xoIox, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27689xoIox = XxIIOXIXx.X0o0xo.Oxx0IOOO(IoOoo.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f27691II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public xIoXXXIXo.I0Io f27692II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public OoIXo.x0o f27693Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public OxxIIOOXO f27695XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public byte[] f27696oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public OI0 f27697oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public XOxIOxOx f27698xxIXOIIO;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f27690I0Io = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Stack f27694X0o0xo = new Stack();

    public IoOoo(byte[] bArr, xIoXXXIXo.I0Io i0Io, OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO, XOxIOxOx xOxIOxOx) {
        this.f27696oIX0oI = bArr;
        this.f27692II0xO0 = i0Io;
        this.f27695XO = oxxIIOOXO;
        this.f27693Oxx0IOOO = x0oVar;
        this.f27691II0XooXoX = o0xOxO;
        this.f27698xxIXOIIO = xOxIOxOx;
        XxIIOXIXx.oIX0oI.oIX0oI(this.f27693Oxx0IOOO != null);
    }

    @Override // jxl.biff.formula.XX
    public byte[] I0Io() {
        return this.f27697oxoX.oxoX();
    }

    @Override // jxl.biff.formula.XX
    public boolean II0XooXoX() {
        this.f27697oxoX.Oxx0IOOO();
        return this.f27697oxoX.II0XooXoX();
    }

    public final void II0xO0(O0Xx o0Xx) throws FormulaException {
        int i = this.f27690I0Io;
        this.f27690I0Io = i + o0Xx.read(this.f27696oIX0oI, i);
        Stack stack = this.f27694X0o0xo;
        this.f27694X0o0xo = new Stack();
        oxoX(o0Xx.IXxxXO());
        OI0[] oi0Arr = new OI0[this.f27694X0o0xo.size()];
        int i2 = 0;
        while (!this.f27694X0o0xo.isEmpty()) {
            oi0Arr[i2] = (OI0) this.f27694X0o0xo.pop();
            i2++;
        }
        o0Xx.xoXoI(oi0Arr);
        this.f27694X0o0xo = stack;
        stack.push(o0Xx);
    }

    @Override // jxl.biff.formula.XX
    public void OOXIXo(int i, int i2, boolean z) {
        this.f27697oxoX.II0xO0(i, i2, z);
    }

    @Override // jxl.biff.formula.XX
    public String Oxx0IOOO() {
        StringBuffer stringBuffer = new StringBuffer();
        this.f27697oxoX.XO(stringBuffer);
        return stringBuffer.toString();
    }

    public final void oIX0oI(xII xii) {
        xii.Oxx0xo(this.f27694X0o0xo);
        this.f27694X0o0xo.push(xii);
    }

    @Override // jxl.biff.formula.XX
    public void oOoXoXO(int i, int i2, boolean z) {
        this.f27697oxoX.I0Io(i, i2, z);
    }

    @Override // jxl.biff.formula.XX
    public void ooOOo0oXI(int i, int i2, boolean z) {
        this.f27697oxoX.OOXIXo(i, i2, z);
    }

    public final void oxoX(int i) throws FormulaException {
        boolean z;
        X0o0xo x0o0xo;
        Stack stack = new Stack();
        int i2 = this.f27690I0Io + i;
        while (true) {
            int i3 = this.f27690I0Io;
            if (i3 < i2) {
                byte b = this.f27696oIX0oI[i3];
                this.f27690I0Io = i3 + 1;
                xoxXI oxoX2 = xoxXI.oxoX(b);
                xoxXI xoxxi = xoxXI.f28026X00IoxXI;
                if (oxoX2 != xoxxi) {
                    if (oxoX2 != xoxxi) {
                        z = true;
                    } else {
                        z = false;
                    }
                    XxIIOXIXx.oIX0oI.oIX0oI(z);
                    if (oxoX2 == xoxXI.f28012I0Io) {
                        xoIox xoiox = new xoIox(this.f27692II0xO0);
                        int i4 = this.f27690I0Io;
                        this.f27690I0Io = i4 + xoiox.read(this.f27696oIX0oI, i4);
                        this.f27694X0o0xo.push(xoiox);
                    } else if (oxoX2 == xoxXI.f28020OOXIXo) {
                        OOXIXo oOXIXo = new OOXIXo();
                        int i5 = this.f27690I0Io;
                        this.f27690I0Io = i5 + oOXIXo.read(this.f27696oIX0oI, i5);
                        this.f27694X0o0xo.push(oOXIXo);
                    } else if (oxoX2 == xoxXI.f28023Oxx0IOOO) {
                        oI0IIXIo oi0iixio = new oI0IIXIo();
                        int i6 = this.f27690I0Io;
                        this.f27690I0Io = i6 + oi0iixio.read(this.f27696oIX0oI, i6);
                        this.f27694X0o0xo.push(oi0iixio);
                    } else if (oxoX2 == xoxXI.f28038oOoXoXO) {
                        xXOx xxox = new xXOx(this.f27692II0xO0);
                        int i7 = this.f27690I0Io;
                        this.f27690I0Io = i7 + xxox.read(this.f27696oIX0oI, i7);
                        this.f27694X0o0xo.push(xxox);
                    } else if (oxoX2 == xoxXI.f28043oxoX) {
                        xxIXOIIO xxixoiio = new xxIXOIIO(this.f27692II0xO0, this.f27695XO);
                        int i8 = this.f27690I0Io;
                        this.f27690I0Io = i8 + xxixoiio.read(this.f27696oIX0oI, i8);
                        this.f27694X0o0xo.push(xxixoiio);
                    } else if (oxoX2 == xoxXI.f28036oO) {
                        I0Io i0Io = new I0Io();
                        int i9 = this.f27690I0Io;
                        this.f27690I0Io = i9 + i0Io.read(this.f27696oIX0oI, i9);
                        this.f27694X0o0xo.push(i0Io);
                    } else if (oxoX2 == xoxXI.f28041ooOOo0oXI) {
                        xo0x xo0xVar = new xo0x(this.f27692II0xO0);
                        int i10 = this.f27690I0Io;
                        this.f27690I0Io = i10 + xo0xVar.read(this.f27696oIX0oI, i10);
                        this.f27694X0o0xo.push(xo0xVar);
                    } else if (oxoX2 == xoxXI.f28017IXxxXO) {
                        II0xO0 iI0xO0 = new II0xO0(this.f27695XO);
                        int i11 = this.f27690I0Io;
                        this.f27690I0Io = i11 + iI0xO0.read(this.f27696oIX0oI, i11);
                        this.f27694X0o0xo.push(iI0xO0);
                    } else if (oxoX2 == xoxXI.f28021Oo) {
                        oo0xXOI0I oo0xxoi0i = new oo0xXOI0I();
                        int i12 = this.f27690I0Io;
                        this.f27690I0Io = i12 + oo0xxoi0i.read(this.f27696oIX0oI, i12);
                        oo0xxoi0i.oO(this.f27698xxIXOIIO);
                        this.f27694X0o0xo.push(oo0xxoi0i);
                    } else if (oxoX2 == xoxXI.f28045x0xO0oo) {
                        IoOoX ioOoX = new IoOoX(this.f27693Oxx0IOOO);
                        int i13 = this.f27690I0Io;
                        this.f27690I0Io = i13 + ioOoX.read(this.f27696oIX0oI, i13);
                        ioOoX.oO(this.f27698xxIXOIIO);
                        this.f27694X0o0xo.push(ioOoX);
                    } else if (oxoX2 == xoxXI.f28050xxIXOIIO) {
                        XI0IXoo xI0IXoo = new XI0IXoo();
                        int i14 = this.f27690I0Io;
                        this.f27690I0Io = i14 + xI0IXoo.read(this.f27696oIX0oI, i14);
                        this.f27694X0o0xo.push(xI0IXoo);
                    } else if (oxoX2 == xoxXI.f28048xoIox) {
                        IXxxXO iXxxXO = new IXxxXO();
                        int i15 = this.f27690I0Io;
                        this.f27690I0Io = i15 + iXxxXO.read(this.f27696oIX0oI, i15);
                        this.f27694X0o0xo.push(iXxxXO);
                    } else if (oxoX2 == xoxXI.f28013II0XooXoX) {
                        Oxx0IOOO oxx0IOOO = new Oxx0IOOO();
                        int i16 = this.f27690I0Io;
                        this.f27690I0Io = i16 + oxx0IOOO.read(this.f27696oIX0oI, i16);
                        this.f27694X0o0xo.push(oxx0IOOO);
                    } else if (oxoX2 == xoxXI.f28031XO) {
                        XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this.f27691II0XooXoX);
                        int i17 = this.f27690I0Io;
                        this.f27690I0Io = i17 + xoI0Ixx0.read(this.f27696oIX0oI, i17);
                        this.f27694X0o0xo.push(xoI0Ixx0);
                    } else if (oxoX2 == xoxXI.f28028X0o0xo) {
                        ooXIXxIX ooxixxix = new ooXIXxIX();
                        int i18 = this.f27690I0Io;
                        this.f27690I0Io = i18 + ooxixxix.read(this.f27696oIX0oI, i18);
                        this.f27694X0o0xo.push(ooxixxix);
                    } else if (oxoX2 == xoxXI.f28024Oxx0xo) {
                        OO0x0xX oO0x0xX = new OO0x0xX();
                        int i19 = this.f27690I0Io;
                        this.f27690I0Io = i19 + oO0x0xX.read(this.f27696oIX0oI, i19);
                        oIX0oI(oO0x0xX);
                    } else if (oxoX2 == xoxXI.f28035oI0IIXIo) {
                        xoIxX xoixx = new xoIxX();
                        int i20 = this.f27690I0Io;
                        this.f27690I0Io = i20 + xoixx.read(this.f27696oIX0oI, i20);
                        oIX0oI(xoixx);
                    } else if (oxoX2 == xoxXI.f28025OxxIIOOXO) {
                        I0oOoX i0oOoX = new I0oOoX();
                        int i21 = this.f27690I0Io;
                        this.f27690I0Io = i21 + i0oOoX.read(this.f27696oIX0oI, i21);
                        oIX0oI(i0oOoX);
                    } else if (oxoX2 == xoxXI.f28034o00) {
                        I0oOIX i0oOIX = new I0oOIX();
                        int i22 = this.f27690I0Io;
                        this.f27690I0Io = i22 + i0oOIX.read(this.f27696oIX0oI, i22);
                        oIX0oI(i0oOIX);
                    } else if (oxoX2 == xoxXI.f28049xoXoI) {
                        oIX0oI oix0oi = new oIX0oI();
                        int i23 = this.f27690I0Io;
                        this.f27690I0Io = i23 + oix0oi.read(this.f27696oIX0oI, i23);
                        oIX0oI(oix0oi);
                    } else if (oxoX2 == xoxXI.f28022OxI) {
                        xI xIVar = new xI();
                        int i24 = this.f27690I0Io;
                        this.f27690I0Io = i24 + xIVar.read(this.f27696oIX0oI, i24);
                        oIX0oI(xIVar);
                    } else if (oxoX2 == xoxXI.f28019O0xOxO) {
                        x0xO0oo x0xo0oo = new x0xO0oo();
                        int i25 = this.f27690I0Io;
                        this.f27690I0Io = i25 + x0xo0oo.read(this.f27696oIX0oI, i25);
                        oIX0oI(x0xo0oo);
                    } else if (oxoX2 == xoxXI.f28029XI0IXoo) {
                        oO oOVar = new oO();
                        int i26 = this.f27690I0Io;
                        this.f27690I0Io = i26 + oOVar.read(this.f27696oIX0oI, i26);
                        oIX0oI(oOVar);
                    } else if (oxoX2 == xoxXI.f28027X0IIOO) {
                        XoX xoX2 = new XoX();
                        int i27 = this.f27690I0Io;
                        this.f27690I0Io = i27 + xoX2.read(this.f27696oIX0oI, i27);
                        oIX0oI(xoX2);
                    } else if (oxoX2 == xoxXI.f28030XIxXXX0x0) {
                        xxX xxx2 = new xxX();
                        int i28 = this.f27690I0Io;
                        this.f27690I0Io = i28 + xxx2.read(this.f27696oIX0oI, i28);
                        oIX0oI(xxx2);
                    } else if (oxoX2 == xoxXI.f28051xxX) {
                        XIxXXX0x0 xIxXXX0x0 = new XIxXXX0x0();
                        int i29 = this.f27690I0Io;
                        this.f27690I0Io = i29 + xIxXXX0x0.read(this.f27696oIX0oI, i29);
                        oIX0oI(xIxXXX0x0);
                    } else if (oxoX2 == xoxXI.f28015IIX0o) {
                        X0IIOO x0iioo = new X0IIOO();
                        int i30 = this.f27690I0Io;
                        this.f27690I0Io = i30 + x0iioo.read(this.f27696oIX0oI, i30);
                        oIX0oI(x0iioo);
                    } else if (oxoX2 == xoxXI.f28047xXxxox0I) {
                        O0xOxO o0xOxO = new O0xOxO();
                        int i31 = this.f27690I0Io;
                        this.f27690I0Io = i31 + o0xOxO.read(this.f27696oIX0oI, i31);
                        oIX0oI(o0xOxO);
                    } else if (oxoX2 == xoxXI.f28042ooXIXxIX) {
                        oOXoIIIo ooxoiiio = new oOXoIIIo();
                        int i32 = this.f27690I0Io;
                        this.f27690I0Io = i32 + ooxoiiio.read(this.f27696oIX0oI, i32);
                        oIX0oI(ooxoiiio);
                    } else if (oxoX2 == xoxXI.f28033XxX0x0xxx) {
                        Oxx0xo oxx0xo = new Oxx0xo();
                        int i33 = this.f27690I0Io;
                        this.f27690I0Io = i33 + oxx0xo.read(this.f27696oIX0oI, i33);
                        oIX0oI(oxx0xo);
                    } else if (oxoX2 == xoxXI.f28016IIXOooo) {
                        x0o x0oVar = new x0o();
                        int i34 = this.f27690I0Io;
                        this.f27690I0Io = i34 + x0oVar.read(this.f27696oIX0oI, i34);
                        oIX0oI(x0oVar);
                    } else if (oxoX2 == xoxXI.f28037oOXoIIIo) {
                        X0o0xo x0o0xo2 = new X0o0xo(this.f27691II0XooXoX);
                        int i35 = this.f27690I0Io;
                        this.f27690I0Io = i35 + x0o0xo2.read(this.f27696oIX0oI, i35);
                        if (x0o0xo2.XI0IXoo()) {
                            oIX0oI(x0o0xo2);
                        } else if (x0o0xo2.X0IIOO()) {
                            stack.push(x0o0xo2);
                        }
                    } else if (oxoX2 == xoxXI.f28039oo) {
                        II0XooXoX iI0XooXoX = new II0XooXoX(this.f27691II0XooXoX);
                        int i36 = this.f27690I0Io;
                        this.f27690I0Io = i36 + iI0XooXoX.read(this.f27696oIX0oI, i36);
                        oIX0oI(iI0XooXoX);
                    } else if (oxoX2 == xoxXI.f28018IoOoX) {
                        Ioxxx ioxxx = new Ioxxx(this.f27691II0XooXoX);
                        int i37 = this.f27690I0Io;
                        this.f27690I0Io = i37 + ioxxx.read(this.f27696oIX0oI, i37);
                        if (ioxxx.xoXoI() != o00.f27828Oxx0IOOO) {
                            oIX0oI(ioxxx);
                        } else {
                            ioxxx.Oxx0xo(this.f27694X0o0xo);
                            if (stack.empty()) {
                                x0o0xo = new X0o0xo(this.f27691II0XooXoX);
                            } else {
                                x0o0xo = (X0o0xo) stack.pop();
                            }
                            x0o0xo.XIxXXX0x0(ioxxx);
                            this.f27694X0o0xo.push(x0o0xo);
                        }
                    } else if (oxoX2 == xoxXI.f28032Xx000oIo) {
                        II0xO0(new xXxxox0I());
                    } else if (oxoX2 == xoxXI.f28044x0XOIxOo) {
                        II0xO0(new XxX0x0xxx());
                    }
                } else {
                    throw new FormulaException(FormulaException.UNRECOGNIZED_TOKEN, b);
                }
            } else {
                return;
            }
        }
    }

    @Override // jxl.biff.formula.XX
    public void parse() throws FormulaException {
        oxoX(this.f27696oIX0oI.length);
        this.f27697oxoX = (OI0) this.f27694X0o0xo.pop();
        XxIIOXIXx.oIX0oI.oIX0oI(this.f27694X0o0xo.empty());
    }

    @Override // jxl.biff.formula.XX
    public void xoIox(int i, int i2, boolean z) {
        this.f27697oxoX.xoIox(i, i2, z);
    }

    @Override // jxl.biff.formula.XX
    public void xxIXOIIO(int i, int i2) {
        this.f27697oxoX.oIX0oI(i, i2);
    }
}
