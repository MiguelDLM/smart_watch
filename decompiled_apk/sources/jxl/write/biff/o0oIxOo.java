package jxl.write.biff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import jxl.write.WriteException;

/* loaded from: classes6.dex */
public final class o0oIxOo {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28806O0xOxO = XxIIOXIXx.X0o0xo.Oxx0IOOO(o0oIxOo.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28807I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28808II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public oXIO0o0XI[] f28809II0xO0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public xxIXOIIO f28811IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public ArrayList f28812OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public xoIxX f28813Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public XOxxooXI f28814OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public xIoXXXIXo.xoXoI f28815Oxx0IOOO;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public X0xOO.Xx000oIo f28817OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public X00IoxXI f28818X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public xI f28819XO;

    /* renamed from: o00, reason: collision with root package name */
    public int f28820o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public TreeSet f28821oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public IIX0o f28822oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public OoIXo.OxxIIOOXO f28823oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public ArrayList f28824oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public OoIXo.oIX0oI f28825ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28826oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public ArrayList f28827x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public XX0 f28828x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public ArrayList f28829xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f28830xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public ArrayList f28831xxIXOIIO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public OoIXo.XOxIOxOx f28816Oxx0xo = new OoIXo.XOxIOxOx();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f28810IIXOooo = false;

    public o0oIxOo(IIX0o iIX0o, XOxxooXI xOxxooXI, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f28822oIX0oI = iIX0o;
        this.f28814OxI = xOxxooXI;
        this.f28808II0XooXoX = o0xOxO;
        this.f28817OxxIIOOXO = new X0xOO.Xx000oIo(o0xOxO);
    }

    public final xIoXXXIXo.I0Io[] I0Io(int i) {
        oOoXoXO oooxoxo;
        int i2 = this.f28807I0Io - 1;
        boolean z = false;
        while (i2 >= 0 && !z) {
            oXIO0o0XI oxio0o0xi = this.f28809II0xO0[i2];
            if (oxio0o0xi == null || oxio0o0xi.Xo0(i) == null) {
                i2--;
            } else {
                z = true;
            }
        }
        xIoXXXIXo.I0Io[] i0IoArr = new xIoXXXIXo.I0Io[i2 + 1];
        for (int i3 = 0; i3 <= i2; i3++) {
            oXIO0o0XI oxio0o0xi2 = this.f28809II0xO0[i3];
            if (oxio0o0xi2 != null) {
                oooxoxo = oxio0o0xi2.Xo0(i);
            } else {
                oooxoxo = null;
            }
            i0IoArr[i3] = oooxoxo;
        }
        return i0IoArr;
    }

    public void II0XooXoX(xxIXOIIO xxixoiio) {
        this.f28811IXxxXO = xxixoiio;
    }

    public X0xOO.X0o0xo[] II0xO0() {
        return this.f28817OxxIIOOXO.oIX0oI();
    }

    public void IXxxXO(oXIO0o0XI[] oxio0o0xiArr, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, XX0 xx02, TreeSet treeSet, int i, int i2) {
        this.f28809II0xO0 = oxio0o0xiArr;
        this.f28831xxIXOIIO = arrayList;
        this.f28829xoIox = arrayList2;
        this.f28812OOXIXo = arrayList3;
        this.f28828x0xO0oo = xx02;
        this.f28821oI0IIXIo = treeSet;
        this.f28830xoXoI = i;
        this.f28820o00 = i2;
    }

    public void OOXIXo(ArrayList arrayList) {
        this.f28824oOoXoXO = arrayList;
    }

    public void Oo(OoIXo.XOxIOxOx xOxIOxOx) {
        if (xOxIOxOx != null) {
            this.f28816Oxx0xo = xOxIOxOx;
        }
    }

    public void Oxx0IOOO(OoIXo.oIX0oI oix0oi) {
        this.f28825ooOOo0oXI = oix0oi;
    }

    public void Oxx0xo() throws IOException {
        boolean z;
        boolean z2;
        int i;
        if (this.f28809II0xO0 != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        if (this.f28810IIXOooo) {
            this.f28817OxxIIOOXO.oxoX(this.f28822oIX0oI);
            return;
        }
        this.f28822oIX0oI.XO(new II0xO0(II0xO0.f28571Oxx0IOOO));
        int i2 = this.f28807I0Io;
        int i3 = i2 / 32;
        if (i2 - (i3 * 32) != 0) {
            i3++;
        }
        int I0Io2 = this.f28822oIX0oI.I0Io();
        OI0 oi0 = new OI0(0, this.f28807I0Io, i3);
        this.f28822oIX0oI.XO(oi0);
        if (this.f28815Oxx0IOOO.oIX0oI()) {
            this.f28822oIX0oI.XO(new OOXIXo(OOXIXo.f28678Oxx0IOOO));
        } else {
            this.f28822oIX0oI.XO(new OOXIXo(OOXIXo.f28679XO));
        }
        this.f28822oIX0oI.XO(new xoIox(100));
        this.f28822oIX0oI.XO(new xX0IIXIx0());
        this.f28822oIX0oI.XO(new I0oOoX(false));
        this.f28822oIX0oI.XO(new OxI(0.001d));
        this.f28822oIX0oI.XO(new xOoOIoI(this.f28815Oxx0IOOO.IIX0o()));
        this.f28822oIX0oI.XO(new XX0xXo(this.f28815Oxx0IOOO.xxX()));
        this.f28822oIX0oI.XO(new xxIO(this.f28815Oxx0IOOO.XIxXXX0x0()));
        this.f28822oIX0oI.XO(new oOXoIIIo(true));
        Xx000oIo xx000oIo = new Xx000oIo();
        xx000oIo.oX(this.f28820o00 + 1);
        xx000oIo.Xo0(this.f28830xoXoI + 1);
        this.f28822oIX0oI.XO(xx000oIo);
        int XO2 = this.f28815Oxx0IOOO.XO();
        if (this.f28815Oxx0IOOO.XO() != 255) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f28822oIX0oI.XO(new o00(XO2, z2));
        if (this.f28830xoXoI > 0) {
            this.f28816Oxx0xo.Xo0(true);
        }
        if (this.f28820o00 > 0) {
            this.f28816Oxx0xo.I0X0x0oIo(true);
        }
        this.f28816Oxx0xo.oX(this.f28815Oxx0IOOO.xoIox());
        this.f28822oIX0oI.XO(this.f28816Oxx0xo);
        if (this.f28831xxIXOIIO.size() > 0) {
            int size = this.f28831xxIXOIIO.size();
            int[] iArr = new int[size];
            for (int i4 = 0; i4 < size; i4++) {
                iArr[i4] = ((Integer) this.f28831xxIXOIIO.get(i4)).intValue();
            }
            this.f28822oIX0oI.XO(new x0o(iArr));
        }
        if (this.f28829xoIox.size() > 0) {
            int size2 = this.f28829xoIox.size();
            int[] iArr2 = new int[size2];
            for (int i5 = 0; i5 < size2; i5++) {
                iArr2[i5] = ((Integer) this.f28829xoIox.get(i5)).intValue();
            }
            this.f28822oIX0oI.XO(new IoXIXo(iArr2));
        }
        this.f28822oIX0oI.XO(new X00IoxXI(this.f28815Oxx0IOOO.x0XOIxOo().toString()));
        this.f28822oIX0oI.XO(new xI(this.f28815Oxx0IOOO.oOoXoXO().toString()));
        this.f28822oIX0oI.XO(new xII(this.f28815Oxx0IOOO.IO()));
        this.f28822oIX0oI.XO(new O0IxXx(this.f28815Oxx0IOOO.XOxIOxOx()));
        if (this.f28815Oxx0IOOO.IXxxXO() != this.f28815Oxx0IOOO.Oxx0IOOO()) {
            this.f28822oIX0oI.XO(new XoX(this.f28815Oxx0IOOO.IXxxXO()));
        }
        if (this.f28815Oxx0IOOO.ooXIXxIX() != this.f28815Oxx0IOOO.Oxx0IOOO()) {
            this.f28822oIX0oI.XO(new XIXIX(this.f28815Oxx0IOOO.ooXIXxIX()));
        }
        if (this.f28815Oxx0IOOO.oo() != this.f28815Oxx0IOOO.X0o0xo()) {
            this.f28822oIX0oI.XO(new oI(this.f28815Oxx0IOOO.oo()));
        }
        if (this.f28815Oxx0IOOO.II0xO0() != this.f28815Oxx0IOOO.X0o0xo()) {
            this.f28822oIX0oI.XO(new Oxx0IOOO(this.f28815Oxx0IOOO.II0xO0()));
        }
        xoIxX xoixx = this.f28813Oo;
        if (xoixx != null) {
            this.f28822oIX0oI.XO(xoixx);
        }
        this.f28822oIX0oI.XO(new xI0oxI00(this.f28815Oxx0IOOO));
        if (this.f28815Oxx0IOOO.xII()) {
            this.f28822oIX0oI.XO(new XI0oooXX(this.f28815Oxx0IOOO.xII()));
            this.f28822oIX0oI.XO(new Ox0O(this.f28815Oxx0IOOO.xII()));
            this.f28822oIX0oI.XO(new IoOoo(this.f28815Oxx0IOOO.xII()));
            if (this.f28815Oxx0IOOO.O0xOxO() != null) {
                this.f28822oIX0oI.XO(new XIo0oOXIx(this.f28815Oxx0IOOO.O0xOxO()));
            } else if (this.f28815Oxx0IOOO.X0IIOO() != 0) {
                this.f28822oIX0oI.XO(new XIo0oOXIx(this.f28815Oxx0IOOO.X0IIOO()));
            }
        }
        oi0.I0X0x0oIo(this.f28822oIX0oI.I0Io());
        this.f28822oIX0oI.XO(new xoXoI(this.f28815Oxx0IOOO.oxoX()));
        oIXoXx0.IIXOooo Oxx0IOOO2 = this.f28814OxI.IIxOXoOo0().o0().Oxx0IOOO();
        oIXoXx0.IIXOooo II0xO02 = this.f28814OxI.IIxOXoOo0().o0().II0xO0();
        Iterator it = this.f28821oI0IIXIo.iterator();
        while (it.hasNext()) {
            oO oOVar = (oO) it.next();
            if (oOVar.oIX0oI() < 256) {
                this.f28822oIX0oI.XO(oOVar);
            }
            OoIXo.XX oX2 = oOVar.oX();
            if (oX2 != Oxx0IOOO2 && oOVar.oIX0oI() < 256) {
                xIoXXXIXo.I0Io[] I0Io3 = I0Io(oOVar.oIX0oI());
                for (int i6 = 0; i6 < I0Io3.length; i6++) {
                    xIoXXXIXo.I0Io i0Io = I0Io3[i6];
                    if (i0Io != null && (i0Io.xoIox() == Oxx0IOOO2 || I0Io3[i6].xoIox() == II0xO02)) {
                        ((oIXoXx0.oI0IIXIo) I0Io3[i6]).xxX(oX2);
                    }
                }
            }
        }
        OoIXo.oIX0oI oix0oi = this.f28825ooOOo0oXI;
        if (oix0oi != null) {
            oix0oi.II0xO0(this.f28822oIX0oI);
        }
        this.f28822oIX0oI.XO(new O0xOxO(this.f28807I0Io, this.f28826oxoX));
        for (int i7 = 0; i7 < i3; i7++) {
            Oxx0xo oxx0xo = new Oxx0xo(this.f28822oIX0oI.I0Io());
            int i8 = i7 * 32;
            int min = Math.min(32, this.f28807I0Io - i8);
            int i9 = i8;
            boolean z3 = true;
            while (true) {
                i = i8 + min;
                if (i9 >= i) {
                    break;
                }
                oXIO0o0XI oxio0o0xi = this.f28809II0xO0[i9];
                if (oxio0o0xi != null) {
                    oxio0o0xi.xoO0xx0(this.f28822oIX0oI);
                    if (z3) {
                        oxx0xo.I0X0x0oIo(this.f28822oIX0oI.I0Io());
                        z3 = false;
                    }
                }
                i9++;
            }
            while (i8 < i) {
                if (this.f28809II0xO0[i8] != null) {
                    oxx0xo.XX0(this.f28822oIX0oI.I0Io());
                    this.f28809II0xO0[i8].OX00O0xII(this.f28822oIX0oI);
                }
                i8++;
            }
            oi0.XX0(this.f28822oIX0oI.I0Io());
            oxx0xo.oX(this.f28822oIX0oI.I0Io());
            this.f28822oIX0oI.XO(oxx0xo);
        }
        if (!this.f28808II0XooXoX.X0o0xo()) {
            this.f28817OxxIIOOXO.oxoX(this.f28822oIX0oI);
        }
        this.f28822oIX0oI.XO(new x0OxxIOxX(this.f28815Oxx0IOOO));
        if (this.f28815Oxx0IOOO.x0xO0oo() == 0 && this.f28815Oxx0IOOO.IoOoX() == 0) {
            this.f28822oIX0oI.XO(new xx0X0(xx0X0.f29042OOXIXo, 0, 0));
        } else {
            this.f28822oIX0oI.XO(new OO0x0xX(this.f28815Oxx0IOOO.x0xO0oo(), this.f28815Oxx0IOOO.IoOoX()));
            this.f28822oIX0oI.XO(new xx0X0(xx0X0.f29042OOXIXo, 0, 0));
            if (this.f28815Oxx0IOOO.x0xO0oo() != 0) {
                this.f28822oIX0oI.XO(new xx0X0(xx0X0.f29044xxIXOIIO, this.f28815Oxx0IOOO.x0xO0oo(), 0));
            }
            if (this.f28815Oxx0IOOO.IoOoX() != 0) {
                this.f28822oIX0oI.XO(new xx0X0(xx0X0.f29043xoIox, 0, this.f28815Oxx0IOOO.IoOoX()));
            }
            if (this.f28815Oxx0IOOO.x0xO0oo() != 0 && this.f28815Oxx0IOOO.IoOoX() != 0) {
                this.f28822oIX0oI.XO(new xx0X0(xx0X0.f29041II0XooXoX, this.f28815Oxx0IOOO.x0xO0oo(), this.f28815Oxx0IOOO.IoOoX()));
            }
            this.f28822oIX0oI.XO(new xxOXOOoIX());
        }
        if (this.f28815Oxx0IOOO.Xx000oIo() != 100) {
            this.f28822oIX0oI.XO(new oOo(this.f28815Oxx0IOOO.Xx000oIo()));
        }
        this.f28828x0xO0oo.xoIox(this.f28822oIX0oI);
        Iterator it2 = this.f28812OOXIXo.iterator();
        while (it2.hasNext()) {
            this.f28822oIX0oI.XO((oIXoXx0.o00) it2.next());
        }
        xxIXOIIO xxixoiio = this.f28811IXxxXO;
        if (xxixoiio != null) {
            this.f28822oIX0oI.XO(xxixoiio);
        }
        if (this.f28823oO != null || this.f28827x0XOIxOo.size() > 0) {
            oI0IIXIo();
        }
        ArrayList arrayList = this.f28824oOoXoXO;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it3 = this.f28824oOoXoXO.iterator();
            while (it3.hasNext()) {
                ((OoIXo.ooOOo0oXI) it3.next()).XO(this.f28822oIX0oI);
            }
        }
        this.f28822oIX0oI.XO(new X0IIOO());
        this.f28822oIX0oI.oxoX(oi0.xo0x(), I0Io2 + 4);
    }

    public final X00IoxXI X0o0xo() {
        return this.f28818X0o0xo;
    }

    public OoIXo.XOxIOxOx XO() {
        return this.f28816Oxx0xo;
    }

    public final void oI0IIXIo() throws IOException {
        int i;
        if (this.f28823oO != null && this.f28827x0XOIxOo.size() == 0) {
            this.f28823oO.oOoXoXO(this.f28822oIX0oI);
            return;
        }
        if (this.f28823oO == null && this.f28827x0XOIxOo.size() > 0) {
            if (this.f28814OxI.xxIO() != null) {
                i = this.f28814OxI.xxIO().Oxx0IOOO();
            } else {
                i = -1;
            }
            this.f28823oO = new OoIXo.OxxIIOOXO(i, this.f28814OxI.IIxOXoOo0(), this.f28814OxI.IIxOXoOo0(), this.f28808II0XooXoX);
        }
        Iterator it = this.f28827x0XOIxOo.iterator();
        while (it.hasNext()) {
            oOoXoXO oooxoxo = (oOoXoXO) it.next();
            xIoXXXIXo.oxoX XO2 = oooxoxo.XO();
            if (!XO2.XO().oIX0oI()) {
                if (!XO2.XO().I0Io()) {
                    this.f28823oO.oIX0oI(new OoIXo.xoXoI(XO2.XO()));
                } else if (oooxoxo.oIX0oI() == XO2.XO().X0o0xo() && oooxoxo.II0xO0() == XO2.XO().XO()) {
                    this.f28823oO.oIX0oI(new OoIXo.xoXoI(XO2.XO()));
                }
            }
        }
        this.f28823oO.oOoXoXO(this.f28822oIX0oI);
    }

    public void oIX0oI() {
        xIoXXXIXo.OxxIIOOXO[] oxoX2 = this.f28828x0xO0oo.oxoX();
        ArrayList arrayList = new ArrayList();
        for (xIoXXXIXo.OxxIIOOXO oxxIIOOXO : oxoX2) {
            xIoXXXIXo.I0Io oIX0oI2 = oxxIIOOXO.oIX0oI();
            OoIXo.XX xx2 = (OoIXo.XX) oIX0oI2.xoIox();
            if (xx2 != null && xx2.oOoXoXO() && !xx2.IoOoo()) {
                try {
                    ooOOo0oXI ooooo0oxi = new ooOOo0oXI(xx2);
                    xIoXXXIXo.I0Io II0xO02 = oxxIIOOXO.II0xO0();
                    oI0X0.I0Io i0Io = oI0X0.I0Io.f31366I0Io;
                    oI0X0.oxoX oxox = oI0X0.oxoX.f31584oxoX;
                    oI0X0.XO xo2 = oI0X0.XO.f31413XO;
                    ooooo0oxi.XIXIX(i0Io, oxox, xo2);
                    oI0X0.I0Io i0Io2 = oI0X0.I0Io.f31370XO;
                    ooooo0oxi.XIXIX(i0Io2, xx2.oxxXoxO(i0Io2), xx2.I0oOoX(i0Io2));
                    oI0X0.I0Io i0Io3 = oI0X0.I0Io.f31371oxoX;
                    ooooo0oxi.XIXIX(i0Io3, xx2.oxxXoxO(i0Io3), xx2.I0oOoX(i0Io3));
                    if (oIX0oI2.II0xO0() == II0xO02.II0xO0()) {
                        oI0X0.I0Io i0Io4 = oI0X0.I0Io.f31369X0o0xo;
                        ooooo0oxi.XIXIX(i0Io4, xx2.oxxXoxO(i0Io4), xx2.I0oOoX(i0Io4));
                    }
                    if (oIX0oI2.oIX0oI() == II0xO02.oIX0oI()) {
                        oI0X0.I0Io i0Io5 = oI0X0.I0Io.f31368Oxx0IOOO;
                        ooooo0oxi.XIXIX(i0Io5, xx2.oxxXoxO(i0Io5), xx2.I0oOoX(i0Io5));
                    }
                    int indexOf = arrayList.indexOf(ooooo0oxi);
                    if (indexOf != -1) {
                        ooooo0oxi = (ooOOo0oXI) arrayList.get(indexOf);
                    } else {
                        arrayList.add(ooooo0oxi);
                    }
                    ((oIXoXx0.oI0IIXIo) oIX0oI2).xxX(ooooo0oxi);
                    if (II0xO02.II0xO0() > oIX0oI2.II0xO0()) {
                        if (II0xO02.oIX0oI() != oIX0oI2.oIX0oI()) {
                            ooOOo0oXI ooooo0oxi2 = new ooOOo0oXI(xx2);
                            ooooo0oxi2.XIXIX(i0Io, oxox, xo2);
                            ooooo0oxi2.XIXIX(i0Io2, xx2.oxxXoxO(i0Io2), xx2.I0oOoX(i0Io2));
                            oI0X0.I0Io i0Io6 = oI0X0.I0Io.f31369X0o0xo;
                            ooooo0oxi2.XIXIX(i0Io6, xx2.oxxXoxO(i0Io6), xx2.I0oOoX(i0Io6));
                            int indexOf2 = arrayList.indexOf(ooooo0oxi2);
                            if (indexOf2 != -1) {
                                ooooo0oxi2 = (ooOOo0oXI) arrayList.get(indexOf2);
                            } else {
                                arrayList.add(ooooo0oxi2);
                            }
                            this.f28814OxI.o00(new oIXoXx0.II0xO0(oIX0oI2.oIX0oI(), II0xO02.II0xO0(), ooooo0oxi2));
                        }
                        for (int II0xO03 = oIX0oI2.II0xO0() + 1; II0xO03 < II0xO02.II0xO0(); II0xO03++) {
                            ooOOo0oXI ooooo0oxi3 = new ooOOo0oXI(xx2);
                            ooooo0oxi3.XIXIX(oI0X0.I0Io.f31366I0Io, oI0X0.oxoX.f31584oxoX, oI0X0.XO.f31413XO);
                            oI0X0.I0Io i0Io7 = oI0X0.I0Io.f31370XO;
                            ooooo0oxi3.XIXIX(i0Io7, xx2.oxxXoxO(i0Io7), xx2.I0oOoX(i0Io7));
                            if (oIX0oI2.oIX0oI() == II0xO02.oIX0oI()) {
                                oI0X0.I0Io i0Io8 = oI0X0.I0Io.f31368Oxx0IOOO;
                                ooooo0oxi3.XIXIX(i0Io8, xx2.oxxXoxO(i0Io8), xx2.I0oOoX(i0Io8));
                            }
                            int indexOf3 = arrayList.indexOf(ooooo0oxi3);
                            if (indexOf3 != -1) {
                                ooooo0oxi3 = (ooOOo0oXI) arrayList.get(indexOf3);
                            } else {
                                arrayList.add(ooooo0oxi3);
                            }
                            this.f28814OxI.o00(new oIXoXx0.II0xO0(oIX0oI2.oIX0oI(), II0xO03, ooooo0oxi3));
                        }
                    }
                    if (II0xO02.oIX0oI() > oIX0oI2.oIX0oI()) {
                        if (II0xO02.II0xO0() != oIX0oI2.II0xO0()) {
                            ooOOo0oXI ooooo0oxi4 = new ooOOo0oXI(xx2);
                            ooooo0oxi4.XIXIX(oI0X0.I0Io.f31366I0Io, oI0X0.oxoX.f31584oxoX, oI0X0.XO.f31413XO);
                            oI0X0.I0Io i0Io9 = oI0X0.I0Io.f31368Oxx0IOOO;
                            ooooo0oxi4.XIXIX(i0Io9, xx2.oxxXoxO(i0Io9), xx2.I0oOoX(i0Io9));
                            oI0X0.I0Io i0Io10 = oI0X0.I0Io.f31371oxoX;
                            ooooo0oxi4.XIXIX(i0Io10, xx2.oxxXoxO(i0Io10), xx2.I0oOoX(i0Io10));
                            int indexOf4 = arrayList.indexOf(ooooo0oxi4);
                            if (indexOf4 != -1) {
                                ooooo0oxi4 = (ooOOo0oXI) arrayList.get(indexOf4);
                            } else {
                                arrayList.add(ooooo0oxi4);
                            }
                            this.f28814OxI.o00(new oIXoXx0.II0xO0(II0xO02.oIX0oI(), oIX0oI2.II0xO0(), ooooo0oxi4));
                        }
                        for (int II0xO04 = oIX0oI2.II0xO0() + 1; II0xO04 < II0xO02.II0xO0(); II0xO04++) {
                            ooOOo0oXI ooooo0oxi5 = new ooOOo0oXI(xx2);
                            ooooo0oxi5.XIXIX(oI0X0.I0Io.f31366I0Io, oI0X0.oxoX.f31584oxoX, oI0X0.XO.f31413XO);
                            oI0X0.I0Io i0Io11 = oI0X0.I0Io.f31368Oxx0IOOO;
                            ooooo0oxi5.XIXIX(i0Io11, xx2.oxxXoxO(i0Io11), xx2.I0oOoX(i0Io11));
                            int indexOf5 = arrayList.indexOf(ooooo0oxi5);
                            if (indexOf5 != -1) {
                                ooooo0oxi5 = (ooOOo0oXI) arrayList.get(indexOf5);
                            } else {
                                arrayList.add(ooooo0oxi5);
                            }
                            this.f28814OxI.o00(new oIXoXx0.II0xO0(II0xO02.oIX0oI(), II0xO04, ooooo0oxi5));
                        }
                        for (int oIX0oI3 = oIX0oI2.oIX0oI() + 1; oIX0oI3 < II0xO02.oIX0oI(); oIX0oI3++) {
                            ooOOo0oXI ooooo0oxi6 = new ooOOo0oXI(xx2);
                            ooooo0oxi6.XIXIX(oI0X0.I0Io.f31366I0Io, oI0X0.oxoX.f31584oxoX, oI0X0.XO.f31413XO);
                            oI0X0.I0Io i0Io12 = oI0X0.I0Io.f31371oxoX;
                            ooooo0oxi6.XIXIX(i0Io12, xx2.oxxXoxO(i0Io12), xx2.I0oOoX(i0Io12));
                            if (oIX0oI2.II0xO0() == II0xO02.II0xO0()) {
                                oI0X0.I0Io i0Io13 = oI0X0.I0Io.f31369X0o0xo;
                                ooooo0oxi6.XIXIX(i0Io13, xx2.oxxXoxO(i0Io13), xx2.I0oOoX(i0Io13));
                            }
                            int indexOf6 = arrayList.indexOf(ooooo0oxi6);
                            if (indexOf6 != -1) {
                                ooooo0oxi6 = (ooOOo0oXI) arrayList.get(indexOf6);
                            } else {
                                arrayList.add(ooooo0oxi6);
                            }
                            this.f28814OxI.o00(new oIXoXx0.II0xO0(oIX0oI3, oIX0oI2.II0xO0(), ooooo0oxi6));
                        }
                    }
                    if (II0xO02.oIX0oI() > oIX0oI2.oIX0oI() || II0xO02.II0xO0() > oIX0oI2.II0xO0()) {
                        ooOOo0oXI ooooo0oxi7 = new ooOOo0oXI(xx2);
                        ooooo0oxi7.XIXIX(oI0X0.I0Io.f31366I0Io, oI0X0.oxoX.f31584oxoX, oI0X0.XO.f31413XO);
                        oI0X0.I0Io i0Io14 = oI0X0.I0Io.f31368Oxx0IOOO;
                        ooooo0oxi7.XIXIX(i0Io14, xx2.oxxXoxO(i0Io14), xx2.I0oOoX(i0Io14));
                        oI0X0.I0Io i0Io15 = oI0X0.I0Io.f31369X0o0xo;
                        ooooo0oxi7.XIXIX(i0Io15, xx2.oxxXoxO(i0Io15), xx2.I0oOoX(i0Io15));
                        if (II0xO02.II0xO0() == oIX0oI2.II0xO0()) {
                            oI0X0.I0Io i0Io16 = oI0X0.I0Io.f31371oxoX;
                            ooooo0oxi7.XIXIX(i0Io16, xx2.oxxXoxO(i0Io16), xx2.I0oOoX(i0Io16));
                        }
                        if (II0xO02.oIX0oI() == oIX0oI2.oIX0oI()) {
                            oI0X0.I0Io i0Io17 = oI0X0.I0Io.f31370XO;
                            ooooo0oxi7.XIXIX(i0Io17, xx2.oxxXoxO(i0Io17), xx2.I0oOoX(i0Io17));
                        }
                        int indexOf7 = arrayList.indexOf(ooooo0oxi7);
                        if (indexOf7 != -1) {
                            ooooo0oxi7 = (ooOOo0oXI) arrayList.get(indexOf7);
                        } else {
                            arrayList.add(ooooo0oxi7);
                        }
                        this.f28814OxI.o00(new oIXoXx0.II0xO0(II0xO02.oIX0oI(), II0xO02.II0xO0(), ooooo0oxi7));
                        for (int oIX0oI4 = oIX0oI2.oIX0oI() + 1; oIX0oI4 < II0xO02.oIX0oI(); oIX0oI4++) {
                            ooOOo0oXI ooooo0oxi8 = new ooOOo0oXI(xx2);
                            ooooo0oxi8.XIXIX(oI0X0.I0Io.f31366I0Io, oI0X0.oxoX.f31584oxoX, oI0X0.XO.f31413XO);
                            oI0X0.I0Io i0Io18 = oI0X0.I0Io.f31369X0o0xo;
                            ooooo0oxi8.XIXIX(i0Io18, xx2.oxxXoxO(i0Io18), xx2.I0oOoX(i0Io18));
                            if (oIX0oI2.II0xO0() == II0xO02.II0xO0()) {
                                oI0X0.I0Io i0Io19 = oI0X0.I0Io.f31371oxoX;
                                ooooo0oxi8.XIXIX(i0Io19, xx2.oxxXoxO(i0Io19), xx2.I0oOoX(i0Io19));
                            }
                            int indexOf8 = arrayList.indexOf(ooooo0oxi8);
                            if (indexOf8 != -1) {
                                ooooo0oxi8 = (ooOOo0oXI) arrayList.get(indexOf8);
                            } else {
                                arrayList.add(ooooo0oxi8);
                            }
                            this.f28814OxI.o00(new oIXoXx0.II0xO0(oIX0oI4, II0xO02.II0xO0(), ooooo0oxi8));
                        }
                    }
                } catch (WriteException e) {
                    f28806O0xOxO.ooOOo0oXI(e.toString());
                }
            }
        }
    }

    public void oO(xoIxX xoixx) {
        this.f28813Oo = xoixx;
    }

    public void oOoXoXO(OoIXo.OxxIIOOXO oxxIIOOXO, ArrayList arrayList) {
        this.f28823oO = oxxIIOOXO;
        this.f28827x0XOIxOo = arrayList;
    }

    public void ooOOo0oXI(int i, int i2) {
        this.f28807I0Io = i;
        this.f28826oxoX = i2;
    }

    public final xI oxoX() {
        return this.f28819XO;
    }

    public void x0XOIxOo(ArrayList arrayList, boolean z) {
        this.f28817OxxIIOOXO.I0Io(arrayList, z);
    }

    public void x0xO0oo(xIoXXXIXo.xoXoI xoxoi) {
        this.f28815Oxx0IOOO = xoxoi;
    }

    public void xoIox(X0xOO.X0o0xo[] x0o0xoArr) {
        this.f28817OxxIIOOXO.II0xO0(x0o0xoArr);
    }

    public void xxIXOIIO() {
        this.f28810IIXOooo = true;
    }
}
