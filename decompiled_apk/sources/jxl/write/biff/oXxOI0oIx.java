package jxl.write.biff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import jxl.biff.NumFormatRecordsException;
import jxl.biff.formula.FormulaException;
import jxl.write.WriteException;

/* loaded from: classes6.dex */
public class oXxOI0oIx {

    /* renamed from: xI, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28884xI = XxIIOXIXx.X0o0xo.Oxx0IOOO(oxIIX0o.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28885I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public oXIO0o0XI[] f28886II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public XOxxooXI f28887II0xO0;

    /* renamed from: IIX0o, reason: collision with root package name */
    public HashMap f28888IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public xxIXOIIO f28889IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public ArrayList f28890IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public ArrayList f28891O0xOxO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public ArrayList f28892OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public ArrayList f28893Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public ArrayList f28894OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public XX0 f28895Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public OoIXo.XOxIOxOx f28896Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public xoIxX f28897OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f28898X0IIOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public TreeSet f28899X0o0xo;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f28900XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f28901XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public XX0 f28902XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public OoIXo.xXxxox0I f28903XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public ArrayList f28904o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public xoIxX f28905oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public XOxxooXI f28906oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public o0oIxOo f28907oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public ArrayList f28908oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public OoIXo.OxxIIOOXO f28909ooOOo0oXI;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public HashMap f28910ooXIXxIX;

    /* renamed from: oxoX, reason: collision with root package name */
    public TreeSet f28911oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public OoIXo.OxxIIOOXO f28912x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public ArrayList f28913x0xO0oo;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public HashMap f28914xXxxox0I;

    /* renamed from: xoIox, reason: collision with root package name */
    public ArrayList f28915xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public xxIXOIIO f28916xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public ArrayList f28917xxIXOIIO;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f28918xxX = false;

    public oXxOI0oIx(oIXoXx0.O0xOxO o0xOxO, oIXoXx0.O0xOxO o0xOxO2) {
        this.f28906oIX0oI = (XOxxooXI) o0xOxO;
        XOxxooXI xOxxooXI = (XOxxooXI) o0xOxO2;
        this.f28887II0xO0 = xOxxooXI;
        this.f28885I0Io = xOxxooXI.IIxOXoOo0().Io();
    }

    public final oIXoXx0.oI0IIXIo I0Io(xIoXXXIXo.I0Io i0Io) {
        oIXoXx0.oI0IIXIo o002 = o00(i0Io);
        if (o002 == null) {
            return o002;
        }
        if (o002 instanceof ooOx) {
            ooOx ooox = (ooOx) o002;
            if (!ooox.IIxOXoOo0(this.f28906oIX0oI.IIxOXoOo0(), this.f28906oIX0oI.IIxOXoOo0(), this.f28885I0Io)) {
                try {
                    f28884xI.ooOOo0oXI("Formula " + ooox.Oxx0IOOO() + " in cell " + OoIXo.oOoXoXO.oIX0oI(i0Io.oIX0oI(), i0Io.II0xO0()) + " cannot be imported because it references another  sheet from the source workbook");
                } catch (FormulaException e) {
                    f28884xI.ooOOo0oXI("Formula  in cell " + OoIXo.oOoXoXO.oIX0oI(i0Io.oIX0oI(), i0Io.II0xO0()) + " cannot be imported:  " + e.getMessage());
                }
                o002 = new oIXoXx0.oOoXoXO(i0Io.oIX0oI(), i0Io.II0xO0(), "\"ERROR\"");
            }
        }
        oI0X0.X0o0xo xoIox2 = o002.xoIox();
        oIXoXx0.IIXOooo iIXOooo = (oIXoXx0.IIXOooo) this.f28914xXxxox0I.get(new Integer(((OoIXo.XX) xoIox2).XoI0Ixx0()));
        if (iIXOooo == null) {
            iIXOooo = oIX0oI(xoIox2);
        }
        o002.xxX(iIXOooo);
        return o002;
    }

    public int II0XooXoX() {
        return this.f28900XI0IXoo;
    }

    public void II0xO0() {
        OxI();
        Iterator it = this.f28911oxoX.iterator();
        while (it.hasNext()) {
            this.f28899X0o0xo.add(new oO((oO) it.next()));
        }
        for (xIoXXXIXo.OxxIIOOXO oxxIIOOXO : this.f28902XO.oxoX()) {
            this.f28895Oxx0IOOO.oIX0oI(new OoIXo.X00IoxXI((OoIXo.X00IoxXI) oxxIIOOXO, this.f28887II0xO0));
        }
        int i = 0;
        while (true) {
            try {
                oXIO0o0XI[] oxio0o0xiArr = this.f28886II0XooXoX;
                if (i >= oxio0o0xiArr.length) {
                    break;
                }
                oXIO0o0XI oxio0o0xi = oxio0o0xiArr[i];
                if (oxio0o0xi != null && (!oxio0o0xi.xxIO() || oxio0o0xi.Ioxxx())) {
                    this.f28887II0xO0.OOXIxO0(i).I0(oxio0o0xi.xoxXI(), oxio0o0xi.XX0xXo(), oxio0o0xi.Ioxxx(), oxio0o0xi.I0oOIX(), oxio0o0xi.XoI0Ixx0(), oxio0o0xi.IoOoo());
                }
                i++;
            } catch (RowsExceededException unused) {
                XxIIOXIXx.oIX0oI.oIX0oI(false);
            }
        }
        this.f28892OOXIXo = new ArrayList(this.f28917xxIXOIIO);
        this.f28908oOoXoXO = new ArrayList(this.f28915xoIox);
        if (this.f28909ooOOo0oXI != null) {
            this.f28912x0XOIxOo = new OoIXo.OxxIIOOXO(this.f28909ooOOo0oXI, this.f28887II0xO0.IIxOXoOo0(), this.f28887II0xO0.IIxOXoOo0(), this.f28887II0xO0.IIxOXoOo0().Io());
        }
        this.f28907oO.xoIox(this.f28906oIX0oI.XIo0oOXIx());
        Iterator it2 = this.f28913x0xO0oo.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next instanceof X0xOO.Oxx0xo) {
                oIXoXx0.OxI oxI = new oIXoXx0.OxI((X0xOO.Oxx0xo) next, this.f28887II0xO0.IIxOXoOo0().x0o());
                this.f28893Oo.add(oxI);
                this.f28890IXxxXO.add(oxI);
            }
        }
        this.f28907oO.Oo(this.f28896Oxx0xo);
        if (this.f28905oI0IIXIo != null) {
            this.f28897OxxIIOOXO = new xoIxX(this.f28905oI0IIXIo);
        }
        if (this.f28889IIXOooo != null) {
            this.f28916xoXoI = new xxIXOIIO(this.f28889IIXOooo);
        }
        Iterator it3 = this.f28904o00.iterator();
        while (it3.hasNext()) {
            this.f28894OxI.add(new oIXoXx0.o00((oIXoXx0.o00) it3.next(), this.f28887II0xO0));
        }
    }

    public void IIXOooo(ArrayList arrayList) {
        this.f28891O0xOxO = arrayList;
    }

    public void IXxxXO(xoIxX xoixx) {
        this.f28905oI0IIXIo = xoixx;
    }

    public void OOXIXo(xxIXOIIO xxixoiio) {
        this.f28889IIXOooo = xxixoiio;
    }

    public void Oo(XX0 xx02, XX0 xx03) {
        this.f28902XO = xx02;
        this.f28895Oxx0IOOO = xx03;
    }

    public void OxI() {
        boolean z;
        int OxxIIOOXO2 = this.f28906oIX0oI.OxxIIOOXO();
        for (int i = 0; i < OxxIIOOXO2; i++) {
            for (xIoXXXIXo.I0Io i0Io : this.f28906oIX0oI.x0o(i)) {
                oIXoXx0.oI0IIXIo o002 = o00(i0Io);
                if (o002 != null) {
                    try {
                        this.f28887II0xO0.o00(o002);
                        if (o002.XO() != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z & o002.XO().xxIXOIIO()) {
                            this.f28891O0xOxO.add(o002);
                        }
                    } catch (WriteException unused) {
                        XxIIOXIXx.oIX0oI.oIX0oI(false);
                    }
                }
            }
        }
        this.f28898X0IIOO = this.f28887II0xO0.OxxIIOOXO();
    }

    public int Oxx0IOOO() {
        return this.f28901XIxXXX0x0;
    }

    public void Oxx0xo(ArrayList arrayList, ArrayList arrayList2) {
        this.f28917xxIXOIIO = arrayList;
        this.f28892OOXIXo = arrayList2;
    }

    public void OxxIIOOXO(o0oIxOo o0oixoo) {
        this.f28907oO = o0oixoo;
    }

    public xxIXOIIO X0o0xo() {
        return this.f28916xoXoI;
    }

    public OoIXo.OxxIIOOXO XO() {
        return this.f28912x0XOIxOo;
    }

    public final oIXoXx0.oI0IIXIo o00(xIoXXXIXo.I0Io i0Io) {
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

    public void oI0IIXIo(oXIO0o0XI[] oxio0o0xiArr) {
        this.f28886II0XooXoX = oxio0o0xiArr;
    }

    public final oIXoXx0.IIXOooo oIX0oI(oI0X0.X0o0xo x0o0xo) {
        try {
            OoIXo.XX xx2 = (OoIXo.XX) x0o0xo;
            oIXoXx0.IIXOooo iIXOooo = new oIXoXx0.IIXOooo(xx2);
            this.f28903XxX0x0xxx.II0xO0(iIXOooo);
            this.f28914xXxxox0I.put(new Integer(xx2.XoI0Ixx0()), iIXOooo);
            this.f28888IIX0o.put(new Integer(xx2.XX0()), new Integer(iIXOooo.XX0()));
            this.f28910ooXIXxIX.put(new Integer(xx2.I0X0x0oIo()), new Integer(iIXOooo.I0X0x0oIo()));
            return iIXOooo;
        } catch (NumFormatRecordsException unused) {
            f28884xI.ooOOo0oXI("Maximum number of format records exceeded.  Using default format.");
            return oIXoXx0.X0IIOO.f31668I0Io;
        }
    }

    public void oO(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        this.f28913x0xO0oo = arrayList;
        this.f28893Oo = arrayList2;
        this.f28890IXxxXO = arrayList3;
    }

    public void oOoXoXO(ArrayList arrayList, ArrayList arrayList2) {
        this.f28915xoIox = arrayList;
        this.f28908oOoXoXO = arrayList2;
    }

    public void ooOOo0oXI(TreeSet treeSet, TreeSet treeSet2) {
        this.f28911oxoX = treeSet;
        this.f28899X0o0xo = treeSet2;
    }

    public void oxoX() {
        boolean z;
        int OxxIIOOXO2 = this.f28906oIX0oI.OxxIIOOXO();
        for (int i = 0; i < OxxIIOOXO2; i++) {
            for (xIoXXXIXo.I0Io i0Io : this.f28906oIX0oI.x0o(i)) {
                oIXoXx0.oI0IIXIo I0Io2 = I0Io(i0Io);
                if (I0Io2 != null) {
                    try {
                        this.f28887II0xO0.o00(I0Io2);
                        if (I0Io2.XO() != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z & I0Io2.XO().xxIXOIIO()) {
                            this.f28891O0xOxO.add(I0Io2);
                        }
                    } catch (WriteException unused) {
                        XxIIOXIXx.oIX0oI.oIX0oI(false);
                    }
                }
            }
        }
    }

    public void x0XOIxOo(OoIXo.OxxIIOOXO oxxIIOOXO) {
        this.f28909ooOOo0oXI = oxxIIOOXO;
    }

    public void x0xO0oo(ArrayList arrayList, ArrayList arrayList2) {
        this.f28904o00 = arrayList;
        this.f28894OxI = arrayList2;
    }

    public boolean xoIox() {
        return this.f28918xxX;
    }

    public void xoXoI(OoIXo.XOxIOxOx xOxIOxOx) {
        this.f28896Oxx0xo = xOxIOxOx;
    }

    public xoIxX xxIXOIIO() {
        return this.f28897OxxIIOOXO;
    }
}
