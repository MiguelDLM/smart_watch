package jxl.write.biff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
import jxl.biff.NumFormatRecordsException;
import jxl.biff.formula.FormulaException;
import jxl.read.biff.o0;
import jxl.write.WriteException;

/* loaded from: classes6.dex */
public class oxIIX0o {

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28931X0IIOO = XxIIOXIXx.X0o0xo.Oxx0IOOO(oxIIX0o.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28932I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public ArrayList f28933II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public XOxxooXI f28934II0xO0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f28935IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public xoIxX f28936IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public HashMap f28937O0xOxO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public ArrayList f28938OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public X0xOO.oOoXoXO f28939Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public HashMap f28940OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public XX0 f28941Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f28942Oxx0xo = false;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f28943OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public OoIXo.xXxxox0I f28944X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public ArrayList f28945XO;

    /* renamed from: o00, reason: collision with root package name */
    public HashMap f28946o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public xxIXOIIO f28947oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public jxl.read.biff.I0 f28948oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public OoIXo.oIX0oI f28949oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public ArrayList f28950oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public ArrayList f28951ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public TreeSet f28952oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public ArrayList f28953x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public OoIXo.OxxIIOOXO f28954x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public o0oIxOo f28955xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f28956xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public ArrayList f28957xxIXOIIO;

    public oxIIX0o(xIoXXXIXo.IIXOooo iIXOooo, oIXoXx0.O0xOxO o0xOxO) {
        this.f28948oIX0oI = (jxl.read.biff.I0) iIXOooo;
        XOxxooXI xOxxooXI = (XOxxooXI) o0xOxO;
        this.f28934II0xO0 = xOxxooXI;
        this.f28932I0Io = xOxxooXI.IIxOXoOo0().Io();
    }

    public void I0Io() {
        XIxXXX0x0();
    }

    public X0xOO.oOoXoXO II0XooXoX() {
        return this.f28939Oo;
    }

    public void II0xO0() {
        boolean z;
        OoIXo.XX xx2;
        XIxXXX0x0();
        for (jxl.read.biff.oO oOVar : this.f28948oIX0oI.OO0x0xX()) {
            for (int oX2 = oOVar.oX(); oX2 <= oOVar.xXOx(); oX2++) {
                oO oOVar2 = new oO(oOVar, oX2, this.f28944X0o0xo);
                oOVar2.XIo0oOXIx(oOVar.XX0());
                this.f28952oxoX.add(oOVar2);
            }
        }
        for (xIoXXXIXo.oO oOVar3 : this.f28948oIX0oI.Io()) {
            this.f28945XO.add(new oIXoXx0.o00(oOVar3, this.f28934II0xO0));
        }
        for (xIoXXXIXo.OxxIIOOXO oxxIIOOXO : this.f28948oIX0oI.OOXIXo()) {
            this.f28941Oxx0IOOO.oIX0oI(new OoIXo.X00IoxXI((OoIXo.X00IoxXI) oxxIIOOXO, this.f28934II0xO0));
        }
        try {
            jxl.read.biff.x0xO[] OOXIxO02 = this.f28948oIX0oI.OOXIxO0();
            for (int i = 0; i < OOXIxO02.length; i++) {
                oXIO0o0XI OOXIxO03 = this.f28934II0xO0.OOXIxO0(OOXIxO02[i].I0X0x0oIo());
                if (OOXIxO02[i].Xo0()) {
                    xx2 = this.f28944X0o0xo.xoIox(OOXIxO02[i].oX());
                } else {
                    xx2 = null;
                }
                OOXIxO03.I0(OOXIxO02[i].XX0(), OOXIxO02[i].I0oOIX(), OOXIxO02[i].XoI0Ixx0(), OOXIxO02[i].xXOx(), OOXIxO02[i].xo0x(), xx2);
                this.f28943OxxIIOOXO = Math.max(this.f28943OxxIIOOXO, OOXIxO02[i].I0X0x0oIo() + 1);
            }
        } catch (RowsExceededException unused) {
            XxIIOXIXx.oIX0oI.oIX0oI(false);
        }
        int[] ooXIXxIX2 = this.f28948oIX0oI.ooXIXxIX();
        if (ooXIXxIX2 != null) {
            for (int i2 : ooXIXxIX2) {
                this.f28933II0XooXoX.add(new Integer(i2));
            }
        }
        int[] XO2 = this.f28948oIX0oI.XO();
        if (XO2 != null) {
            for (int i3 : XO2) {
                this.f28957xxIXOIIO.add(new Integer(i3));
            }
        }
        this.f28955xoIox.xoIox(this.f28948oIX0oI.xoIxX());
        X0xOO.xoXoI[] XX0xXo2 = this.f28948oIX0oI.XX0xXo();
        for (int i4 = 0; i4 < XX0xXo2.length; i4++) {
            X0xOO.xoXoI xoxoi = XX0xXo2[i4];
            if (xoxoi instanceof X0xOO.Oxx0xo) {
                oIXoXx0.OxI oxI = new oIXoXx0.OxI(XX0xXo2[i4], this.f28934II0xO0.IIxOXoOo0().x0o());
                this.f28938OOXIXo.add(oxI);
                this.f28950oOoXoXO.add(oxI);
            } else if (xoxoi instanceof X0xOO.ooOOo0oXI) {
                X0xOO.ooOOo0oXI ooooo0oxi = new X0xOO.ooOOo0oXI(XX0xXo2[i4], this.f28934II0xO0.IIxOXoOo0().x0o(), this.f28932I0Io);
                this.f28938OOXIXo.add(ooooo0oxi);
                oOoXoXO oooxoxo = (oOoXoXO) this.f28934II0xO0.xoIox(ooooo0oxi.II0xO0(), ooooo0oxi.x0xO0oo());
                if (oooxoxo.XO() != null) {
                    z = true;
                } else {
                    z = false;
                }
                XxIIOXIXx.oIX0oI.oIX0oI(z);
                oooxoxo.Io().Oo(ooooo0oxi);
            } else if (xoxoi instanceof X0xOO.oxoX) {
                this.f28938OOXIXo.add(new X0xOO.oxoX(XX0xXo2[i4], this.f28934II0xO0.IIxOXoOo0().x0o(), this.f28932I0Io));
            } else if (xoxoi instanceof X0xOO.oOoXoXO) {
                this.f28938OOXIXo.add(new X0xOO.oOoXoXO(XX0xXo2[i4], this.f28934II0xO0.IIxOXoOo0().x0o(), this.f28932I0Io));
            } else if (xoxoi instanceof X0xOO.XO) {
                this.f28938OOXIXo.add(new X0xOO.XO(XX0xXo2[i4], this.f28934II0xO0.IIxOXoOo0().x0o(), this.f28932I0Io));
            }
        }
        OoIXo.OxxIIOOXO Ioxxx2 = this.f28948oIX0oI.Ioxxx();
        if (Ioxxx2 != null) {
            OoIXo.OxxIIOOXO oxxIIOOXO2 = new OoIXo.OxxIIOOXO(Ioxxx2, this.f28934II0xO0.IIxOXoOo0(), this.f28934II0xO0.IIxOXoOo0(), this.f28932I0Io);
            this.f28954x0xO0oo = oxxIIOOXO2;
            int II0xO02 = oxxIIOOXO2.II0xO0();
            if (II0xO02 != 0) {
                this.f28939Oo = (X0xOO.oOoXoXO) this.f28938OOXIXo.get(II0xO02);
            }
        }
        OoIXo.ooOOo0oXI[] XIo0oOXIx2 = this.f28948oIX0oI.XIo0oOXIx();
        if (XIo0oOXIx2.length > 0) {
            for (OoIXo.ooOOo0oXI ooooo0oxi2 : XIo0oOXIx2) {
                this.f28951ooOOo0oXI.add(ooooo0oxi2);
            }
        }
        this.f28949oO = this.f28948oIX0oI.OO();
        this.f28955xoIox.Oo(this.f28948oIX0oI.xoO0xx0());
        if (this.f28948oIX0oI.IIxOXoOo0().I0X0x0oIo()) {
            this.f28942Oxx0xo = true;
            this.f28955xoIox.xxIXOIIO();
        }
        if (this.f28948oIX0oI.ox() != null) {
            if (this.f28948oIX0oI.ooOx().xXOx()) {
                f28931X0IIOO.ooOOo0oXI("Cannot copy Biff7 print settings record - ignoring");
            } else {
                this.f28936IXxxXO = new xoIxX(this.f28948oIX0oI.ox());
            }
        }
        if (this.f28948oIX0oI.IoOoo() != null) {
            this.f28947oI0IIXIo = new xxIXOIIO(this.f28948oIX0oI.IoOoo());
        }
        this.f28935IIXOooo = this.f28948oIX0oI.O00XxXI();
        this.f28956xoXoI = this.f28948oIX0oI.o0xxxXXxX();
    }

    public void IIXOooo(ArrayList arrayList) {
        this.f28945XO = arrayList;
    }

    public void IXxxXO(TreeSet treeSet) {
        this.f28952oxoX = treeSet;
    }

    public void O0xOxO(o0oIxOo o0oixoo) {
        this.f28955xoIox = o0oixoo;
    }

    public int OOXIXo() {
        return this.f28935IIXOooo;
    }

    public void Oo(ArrayList arrayList) {
        this.f28957xxIXOIIO = arrayList;
    }

    public void OxI(ArrayList arrayList) {
        this.f28933II0XooXoX = arrayList;
    }

    public xxIXOIIO Oxx0IOOO() {
        return this.f28947oI0IIXIo;
    }

    public void Oxx0xo(ArrayList arrayList) {
        this.f28951ooOOo0oXI = arrayList;
    }

    public void OxxIIOOXO(OoIXo.xXxxox0I xxxxox0i) {
        this.f28944X0o0xo = xxxxox0i;
    }

    public void X0IIOO(ArrayList arrayList) {
        this.f28953x0XOIxOo = arrayList;
    }

    public void X0o0xo() {
        boolean z;
        int OxxIIOOXO2 = this.f28948oIX0oI.OxxIIOOXO();
        for (int i = 0; i < OxxIIOOXO2; i++) {
            for (xIoXXXIXo.I0Io i0Io : this.f28948oIX0oI.x0o(i)) {
                oIXoXx0.oI0IIXIo oxoX2 = oxoX(i0Io);
                if (oxoX2 != null) {
                    try {
                        this.f28934II0xO0.o00(oxoX2);
                        if (oxoX2.XO() != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z & oxoX2.XO().xxIXOIIO()) {
                            this.f28953x0XOIxOo.add(oxoX2);
                        }
                    } catch (WriteException unused) {
                        XxIIOXIXx.oIX0oI.oIX0oI(false);
                    }
                }
            }
        }
    }

    public final oIXoXx0.oI0IIXIo XI0IXoo(xIoXXXIXo.I0Io i0Io) {
        xIoXXXIXo.Oxx0IOOO type = i0Io.getType();
        if (type == xIoXXXIXo.Oxx0IOOO.f34232I0Io) {
            return new oIXoXx0.ooOOo0oXI((xIoXXXIXo.IXxxXO) i0Io);
        }
        if (type == xIoXXXIXo.Oxx0IOOO.f34240oxoX) {
            return new oIXoXx0.x0XOIxOo((xIoXXXIXo.Oxx0xo) i0Io);
        }
        if (type == xIoXXXIXo.Oxx0IOOO.f34239oOoXoXO) {
            return new oIXoXx0.xoIox((xIoXXXIXo.xxIXOIIO) i0Io);
        }
        if (type == xIoXXXIXo.Oxx0IOOO.f34237X0o0xo) {
            return new oIXoXx0.oxoX((xIoXXXIXo.oIX0oI) i0Io);
        }
        if (type == xIoXXXIXo.Oxx0IOOO.f34236Oxx0IOOO) {
            return new xoO0xx0((OoIXo.IIX0o) i0Io);
        }
        if (type == xIoXXXIXo.Oxx0IOOO.f34242xxIXOIIO) {
            return new OX00O0xII((OoIXo.IIX0o) i0Io);
        }
        if (type == xIoXXXIXo.Oxx0IOOO.f34241xoIox) {
            return new OOXIxO0((OoIXo.IIX0o) i0Io);
        }
        if (type == xIoXXXIXo.Oxx0IOOO.f34233II0XooXoX) {
            return new IIxOXoOo0((OoIXo.IIX0o) i0Io);
        }
        if (type == xIoXXXIXo.Oxx0IOOO.f34235OOXIXo) {
            return new I0((OoIXo.IIX0o) i0Io);
        }
        if (type == xIoXXXIXo.Oxx0IOOO.f34234II0xO0 && i0Io.xoIox() != null) {
            return new oIXoXx0.II0xO0(i0Io);
        }
        return null;
    }

    public void XIxXXX0x0() {
        int OxxIIOOXO2 = this.f28948oIX0oI.OxxIIOOXO();
        for (int i = 0; i < OxxIIOOXO2; i++) {
            for (xIoXXXIXo.I0Io i0Io : this.f28948oIX0oI.x0o(i)) {
                oIXoXx0.oI0IIXIo XI0IXoo2 = XI0IXoo(i0Io);
                if (XI0IXoo2 != null) {
                    try {
                        this.f28934II0xO0.o00(XI0IXoo2);
                        if (XI0IXoo2.XO() != null && XI0IXoo2.XO().xxIXOIIO()) {
                            this.f28953x0XOIxOo.add(XI0IXoo2);
                        }
                    } catch (WriteException unused) {
                        XxIIOXIXx.oIX0oI.oIX0oI(false);
                    }
                }
            }
        }
        this.f28943OxxIIOOXO = this.f28934II0xO0.OxxIIOOXO();
    }

    public OoIXo.oIX0oI XO() {
        return this.f28949oO;
    }

    public void o00(XX0 xx02) {
        this.f28941Oxx0IOOO = xx02;
    }

    public void oI0IIXIo(ArrayList arrayList) {
        this.f28938OOXIXo = arrayList;
    }

    public final oIXoXx0.IIXOooo oIX0oI(oI0X0.X0o0xo x0o0xo) {
        try {
            OoIXo.XX xx2 = (OoIXo.XX) x0o0xo;
            oIXoXx0.IIXOooo iIXOooo = new oIXoXx0.IIXOooo(xx2);
            this.f28944X0o0xo.II0xO0(iIXOooo);
            this.f28946o00.put(new Integer(xx2.XoI0Ixx0()), iIXOooo);
            this.f28940OxI.put(new Integer(xx2.XX0()), new Integer(iIXOooo.XX0()));
            this.f28937O0xOxO.put(new Integer(xx2.I0X0x0oIo()), new Integer(iIXOooo.I0X0x0oIo()));
            return iIXOooo;
        } catch (NumFormatRecordsException unused) {
            f28931X0IIOO.ooOOo0oXI("Maximum number of format records exceeded.  Using default format.");
            return oIXoXx0.X0IIOO.f31668I0Io;
        }
    }

    public void oO() {
        boolean z;
        oIXoXx0.IIXOooo iIXOooo;
        this.f28946o00 = new HashMap();
        this.f28940OxI = new HashMap();
        this.f28937O0xOxO = new HashMap();
        X0o0xo();
        for (jxl.read.biff.oO oOVar : this.f28948oIX0oI.OO0x0xX()) {
            for (int oX2 = oOVar.oX(); oX2 <= oOVar.xXOx(); oX2++) {
                oO oOVar2 = new oO(oOVar, oX2);
                oIXoXx0.IIXOooo iIXOooo2 = (oIXoXx0.IIXOooo) this.f28946o00.get(new Integer(oOVar2.xoxXI()));
                if (iIXOooo2 == null) {
                    oIX0oI(this.f28948oIX0oI.X0IIOO(oX2).I0Io());
                }
                oOVar2.x0xO(iIXOooo2);
                oOVar2.XIo0oOXIx(oOVar.XX0());
                this.f28952oxoX.add(oOVar2);
            }
        }
        for (xIoXXXIXo.oO oOVar3 : this.f28948oIX0oI.Io()) {
            this.f28945XO.add(new oIXoXx0.o00(oOVar3, this.f28934II0xO0));
        }
        for (xIoXXXIXo.OxxIIOOXO oxxIIOOXO : this.f28948oIX0oI.OOXIXo()) {
            this.f28941Oxx0IOOO.oIX0oI(new OoIXo.X00IoxXI((OoIXo.X00IoxXI) oxxIIOOXO, this.f28934II0xO0));
        }
        try {
            jxl.read.biff.x0xO[] OOXIxO02 = this.f28948oIX0oI.OOXIxO0();
            for (int i = 0; i < OOXIxO02.length; i++) {
                oXIO0o0XI OOXIxO03 = this.f28934II0xO0.OOXIxO0(OOXIxO02[i].I0X0x0oIo());
                jxl.read.biff.x0xO x0xo = OOXIxO02[i];
                if (x0xo.Xo0()) {
                    iIXOooo = (oIXoXx0.IIXOooo) this.f28946o00.get(new Integer(x0xo.oX()));
                    if (iIXOooo == null) {
                        oIX0oI(this.f28948oIX0oI.Oo(x0xo.I0X0x0oIo()).I0Io());
                    }
                } else {
                    iIXOooo = null;
                }
                OOXIxO03.I0(x0xo.XX0(), x0xo.I0oOIX(), x0xo.XoI0Ixx0(), x0xo.xXOx(), x0xo.xo0x(), iIXOooo);
                this.f28943OxxIIOOXO = Math.max(this.f28943OxxIIOOXO, OOXIxO02[i].I0X0x0oIo() + 1);
            }
        } catch (RowsExceededException unused) {
            XxIIOXIXx.oIX0oI.oIX0oI(false);
        }
        int[] ooXIXxIX2 = this.f28948oIX0oI.ooXIXxIX();
        if (ooXIXxIX2 != null) {
            for (int i2 : ooXIXxIX2) {
                this.f28933II0XooXoX.add(new Integer(i2));
            }
        }
        int[] XO2 = this.f28948oIX0oI.XO();
        if (XO2 != null) {
            for (int i3 : XO2) {
                this.f28957xxIXOIIO.add(new Integer(i3));
            }
        }
        X0xOO.X0o0xo[] xoIxX2 = this.f28948oIX0oI.xoIxX();
        if (xoIxX2 != null && xoIxX2.length > 0) {
            f28931X0IIOO.ooOOo0oXI("Importing of charts is not supported");
        }
        X0xOO.xoXoI[] XX0xXo2 = this.f28948oIX0oI.XX0xXo();
        if (XX0xXo2.length > 0 && this.f28934II0xO0.IIxOXoOo0().x0o() == null) {
            this.f28934II0xO0.IIxOXoOo0().X00IoxXI();
        }
        for (int i4 = 0; i4 < XX0xXo2.length; i4++) {
            X0xOO.xoXoI xoxoi = XX0xXo2[i4];
            if (xoxoi instanceof X0xOO.Oxx0xo) {
                oIXoXx0.OxI oxI = new oIXoXx0.OxI(XX0xXo2[i4].o00(), XX0xXo2[i4].OxI(), XX0xXo2[i4].getWidth(), XX0xXo2[i4].getHeight(), XX0xXo2[i4].I0Io());
                this.f28934II0xO0.IIxOXoOo0().IIX0o(oxI);
                this.f28938OOXIXo.add(oxI);
                this.f28950oOoXoXO.add(oxI);
            } else if (xoxoi instanceof X0xOO.ooOOo0oXI) {
                X0xOO.ooOOo0oXI ooooo0oxi = new X0xOO.ooOOo0oXI(XX0xXo2[i4], this.f28934II0xO0.IIxOXoOo0().x0o(), this.f28932I0Io);
                this.f28938OOXIXo.add(ooooo0oxi);
                oOoXoXO oooxoxo = (oOoXoXO) this.f28934II0xO0.xoIox(ooooo0oxi.II0xO0(), ooooo0oxi.x0xO0oo());
                if (oooxoxo.XO() != null) {
                    z = true;
                } else {
                    z = false;
                }
                XxIIOXIXx.oIX0oI.oIX0oI(z);
                oooxoxo.Io().Oo(ooooo0oxi);
            } else if (xoxoi instanceof X0xOO.oxoX) {
                this.f28938OOXIXo.add(new X0xOO.oxoX(XX0xXo2[i4], this.f28934II0xO0.IIxOXoOo0().x0o(), this.f28932I0Io));
            } else if (xoxoi instanceof X0xOO.oOoXoXO) {
                this.f28938OOXIXo.add(new X0xOO.oOoXoXO(XX0xXo2[i4], this.f28934II0xO0.IIxOXoOo0().x0o(), this.f28932I0Io));
            }
        }
        OoIXo.OxxIIOOXO Ioxxx2 = this.f28948oIX0oI.Ioxxx();
        if (Ioxxx2 != null) {
            OoIXo.OxxIIOOXO oxxIIOOXO2 = new OoIXo.OxxIIOOXO(Ioxxx2, this.f28934II0xO0.IIxOXoOo0(), this.f28934II0xO0.IIxOXoOo0(), this.f28932I0Io);
            this.f28954x0xO0oo = oxxIIOOXO2;
            int II0xO02 = oxxIIOOXO2.II0xO0();
            if (II0xO02 != 0) {
                this.f28939Oo = (X0xOO.oOoXoXO) this.f28938OOXIXo.get(II0xO02);
            }
        }
        this.f28955xoIox.Oo(this.f28948oIX0oI.xoO0xx0());
        if (this.f28948oIX0oI.IIxOXoOo0().I0X0x0oIo()) {
            this.f28942Oxx0xo = true;
            this.f28955xoIox.xxIXOIIO();
        }
        if (this.f28948oIX0oI.ox() != null) {
            if (this.f28948oIX0oI.ooOx().xXOx()) {
                f28931X0IIOO.ooOOo0oXI("Cannot copy Biff7 print settings record - ignoring");
            } else {
                this.f28936IXxxXO = new xoIxX(this.f28948oIX0oI.ox());
            }
        }
        if (this.f28948oIX0oI.IoOoo() != null) {
            this.f28947oI0IIXIo = new xxIXOIIO(this.f28948oIX0oI.IoOoo());
        }
        x0XOIxOo();
        this.f28935IIXOooo = this.f28948oIX0oI.O00XxXI();
        this.f28956xoXoI = this.f28948oIX0oI.o0xxxXXxX();
    }

    public xoIxX oOoXoXO() {
        return this.f28936IXxxXO;
    }

    public int ooOOo0oXI() {
        return this.f28943OxxIIOOXO;
    }

    public final oIXoXx0.oI0IIXIo oxoX(xIoXXXIXo.I0Io i0Io) {
        oIXoXx0.oI0IIXIo XI0IXoo2 = XI0IXoo(i0Io);
        if (XI0IXoo2 == null) {
            return XI0IXoo2;
        }
        if (XI0IXoo2 instanceof ooOx) {
            ooOx ooox = (ooOx) XI0IXoo2;
            if (!ooox.IIxOXoOo0(this.f28948oIX0oI.I0(), this.f28948oIX0oI.I0(), this.f28932I0Io)) {
                try {
                    f28931X0IIOO.ooOOo0oXI("Formula " + ooox.Oxx0IOOO() + " in cell " + OoIXo.oOoXoXO.oIX0oI(i0Io.oIX0oI(), i0Io.II0xO0()) + " cannot be imported because it references another  sheet from the source workbook");
                } catch (FormulaException e) {
                    f28931X0IIOO.ooOOo0oXI("Formula  in cell " + OoIXo.oOoXoXO.oIX0oI(i0Io.oIX0oI(), i0Io.II0xO0()) + " cannot be imported:  " + e.getMessage());
                }
                XI0IXoo2 = new oIXoXx0.oOoXoXO(i0Io.oIX0oI(), i0Io.II0xO0(), "\"ERROR\"");
            }
        }
        oI0X0.X0o0xo xoIox2 = XI0IXoo2.xoIox();
        oIXoXx0.IIXOooo iIXOooo = (oIXoXx0.IIXOooo) this.f28946o00.get(new Integer(((OoIXo.XX) xoIox2).XoI0Ixx0()));
        if (iIXOooo == null) {
            iIXOooo = oIX0oI(xoIox2);
        }
        XI0IXoo2.xxX(iIXOooo);
        return XI0IXoo2;
    }

    public final void x0XOIxOo() {
        int i;
        jxl.read.biff.IIX0 I02 = this.f28948oIX0oI.I0();
        IOoo IIxOXoOo02 = this.f28934II0xO0.IIxOXoOo0();
        int XOxIOxOx2 = I02.XOxIOxOx(this.f28948oIX0oI);
        jxl.read.biff.o0[] o02 = I02.o0();
        String[] Oxx0xo2 = IIxOXoOo02.Oxx0xo();
        for (int i2 = 0; i2 < o02.length; i2++) {
            o0.I0Io[] I0X0x0oIo2 = o02[i2].I0X0x0oIo();
            int i3 = 0;
            while (i3 < I0X0x0oIo2.length) {
                if (XOxIOxOx2 == I02.II0xO0(I0X0x0oIo2[i3].oIX0oI())) {
                    String name = o02[i2].getName();
                    if (Arrays.binarySearch(Oxx0xo2, name) < 0) {
                        i = i3;
                        IIxOXoOo02.xoIox(name, this.f28934II0xO0, I0X0x0oIo2[i3].II0xO0(), I0X0x0oIo2[i3].I0Io(), I0X0x0oIo2[i3].oxoX(), I0X0x0oIo2[i3].X0o0xo());
                    } else {
                        i = i3;
                        f28931X0IIOO.ooOOo0oXI("Named range " + name + " is already present in the destination workbook");
                    }
                } else {
                    i = i3;
                }
                i3 = i + 1;
            }
        }
    }

    public boolean x0xO0oo() {
        return this.f28942Oxx0xo;
    }

    public int xoIox() {
        return this.f28956xoXoI;
    }

    public void xoXoI(ArrayList arrayList) {
        this.f28950oOoXoXO = arrayList;
    }

    public OoIXo.OxxIIOOXO xxIXOIIO() {
        return this.f28954x0xO0oo;
    }
}
