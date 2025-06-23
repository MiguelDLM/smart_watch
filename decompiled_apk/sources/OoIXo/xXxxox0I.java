package OoIXo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jxl.biff.NumFormatRecordsException;

/* loaded from: classes6.dex */
public class xXxxox0I {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f2536II0XooXoX = 164;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2537Oxx0IOOO = XxIIOXIXx.X0o0xo.Oxx0IOOO(xXxxox0I.class);

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f2538xoIox = 21;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f2539xxIXOIIO = 441;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public xxX f2542X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public IoOoX f2543XO;

    /* renamed from: I0Io, reason: collision with root package name */
    public ArrayList f2540I0Io = new ArrayList(10);

    /* renamed from: oIX0oI, reason: collision with root package name */
    public HashMap f2544oIX0oI = new HashMap(10);

    /* renamed from: II0xO0, reason: collision with root package name */
    public ArrayList f2541II0xO0 = new ArrayList(10);

    /* renamed from: oxoX, reason: collision with root package name */
    public int f2545oxoX = 164;

    public xXxxox0I(xxX xxx2) {
        this.f2542X0o0xo = xxx2;
    }

    public oI0X0.x0XOIxOo I0Io(oI0X0.XO xo2) {
        IoOoX ioOoX = this.f2543XO;
        if (ioOoX == null) {
            return xo2.oxoX();
        }
        return ioOoX.XX0(xo2);
    }

    public final int II0XooXoX() {
        return this.f2541II0xO0.size();
    }

    public final void II0xO0(XX xx2) throws NumFormatRecordsException {
        if (!xx2.isInitialized()) {
            xx2.O0Xx(this.f2540I0Io.size(), this, this.f2542X0o0xo);
            this.f2540I0Io.add(xx2);
        } else if (xx2.XoI0Ixx0() >= this.f2540I0Io.size()) {
            this.f2540I0Io.add(xx2);
        }
    }

    public final boolean OOXIXo(int i) {
        XX xx2 = (XX) this.f2540I0Io.get(i);
        if (xx2.xoxXI()) {
            return true;
        }
        XxX0x0xxx xxX0x0xxx = (XxX0x0xxx) this.f2544oIX0oI.get(new Integer(xx2.I0X0x0oIo()));
        if (xxX0x0xxx == null) {
            return false;
        }
        return xxX0x0xxx.I0X0x0oIo();
    }

    public void Oo(jxl.write.biff.IIX0o iIX0o) throws IOException {
        Iterator it = this.f2541II0xO0.iterator();
        while (it.hasNext()) {
            iIX0o.XO((XxX0x0xxx) it.next());
        }
        Iterator it2 = this.f2540I0Io.iterator();
        while (it2.hasNext()) {
            iIX0o.XO((XX) it2.next());
        }
        iIX0o.XO(new II0XooXoX(16, 3));
        iIX0o.XO(new II0XooXoX(17, 6));
        iIX0o.XO(new II0XooXoX(18, 4));
        iIX0o.XO(new II0XooXoX(19, 7));
        iIX0o.XO(new II0XooXoX(0, 0));
        iIX0o.XO(new II0XooXoX(20, 5));
    }

    public final NumberFormat Oxx0IOOO(int i) {
        XX xx2 = (XX) this.f2540I0Io.get(i);
        if (xx2.OO()) {
            return xx2.X00IoxXI();
        }
        XxX0x0xxx xxX0x0xxx = (XxX0x0xxx) this.f2544oIX0oI.get(new Integer(xx2.I0X0x0oIo()));
        if (xxX0x0xxx == null || !xxX0x0xxx.oX()) {
            return null;
        }
        return xxX0x0xxx.X00IoxXI();
    }

    public final xxX X0o0xo() {
        return this.f2542X0o0xo;
    }

    public XxX0x0xxx XO(int i) {
        return (XxX0x0xxx) this.f2544oIX0oI.get(new Integer(i));
    }

    public final void oIX0oI(o00 o00Var) throws NumFormatRecordsException {
        if (o00Var.isInitialized() && o00Var.OxI() >= 441) {
            f2537Oxx0IOOO.ooOOo0oXI("Format index exceeds Excel maximum - assigning custom number");
            o00Var.initialize(this.f2545oxoX);
            this.f2545oxoX++;
        }
        if (!o00Var.isInitialized()) {
            o00Var.initialize(this.f2545oxoX);
            this.f2545oxoX++;
        }
        if (this.f2545oxoX <= 441) {
            if (o00Var.OxI() >= this.f2545oxoX) {
                this.f2545oxoX = o00Var.OxI() + 1;
            }
            if (!o00Var.xII()) {
                this.f2541II0xO0.add(o00Var);
                this.f2544oIX0oI.put(new Integer(o00Var.OxI()), o00Var);
                return;
            }
            return;
        }
        this.f2545oxoX = f2539xxIXOIIO;
        throw new NumFormatRecordsException();
    }

    public void oO(oI0X0.XO xo2, int i, int i2, int i3) {
        if (this.f2543XO == null) {
            this.f2543XO = new IoOoX();
        }
        this.f2543XO.Xo0(xo2, i, i2, i3);
    }

    public xI oOoXoXO(xI xIVar, xI xIVar2) {
        Iterator it = this.f2540I0Io.iterator();
        while (it.hasNext()) {
            XX xx2 = (XX) it.next();
            if (xx2.I0X0x0oIo() >= 164) {
                xx2.XIo0oOXIx(xIVar2.oIX0oI(xx2.I0X0x0oIo()));
            }
            xx2.OO0x0xX(xIVar.oIX0oI(xx2.XX0()));
        }
        ArrayList arrayList = new ArrayList(21);
        xI xIVar3 = new xI(this.f2540I0Io.size());
        int min = Math.min(21, this.f2540I0Io.size());
        for (int i = 0; i < min; i++) {
            arrayList.add(this.f2540I0Io.get(i));
            xIVar3.II0xO0(i, i);
        }
        if (min < 21) {
            f2537Oxx0IOOO.ooOOo0oXI("There are less than the expected minimum number of XF records");
            return xIVar3;
        }
        int i2 = 0;
        for (int i3 = 21; i3 < this.f2540I0Io.size(); i3++) {
            XX xx3 = (XX) this.f2540I0Io.get(i3);
            Iterator it2 = arrayList.iterator();
            boolean z = false;
            while (it2.hasNext() && !z) {
                XX xx4 = (XX) it2.next();
                if (xx4.equals(xx3)) {
                    xIVar3.II0xO0(i3, xIVar3.oIX0oI(xx4.XoI0Ixx0()));
                    i2++;
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(xx3);
                xIVar3.II0xO0(i3, i3 - i2);
            }
        }
        Iterator it3 = this.f2540I0Io.iterator();
        while (it3.hasNext()) {
            ((XX) it3.next()).xoIxX(xIVar3);
        }
        this.f2540I0Io = arrayList;
        return xIVar3;
    }

    public xI ooOOo0oXI() {
        ArrayList arrayList = new ArrayList();
        xI xIVar = new xI(this.f2545oxoX);
        Iterator it = this.f2541II0xO0.iterator();
        int i = 0;
        while (it.hasNext()) {
            o00 o00Var = (o00) it.next();
            XxIIOXIXx.oIX0oI.oIX0oI(!o00Var.xII());
            Iterator it2 = arrayList.iterator();
            boolean z = false;
            while (it2.hasNext() && !z) {
                o00 o00Var2 = (o00) it2.next();
                if (o00Var2.equals(o00Var)) {
                    xIVar.II0xO0(o00Var.OxI(), xIVar.oIX0oI(o00Var2.OxI()));
                    i++;
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(o00Var);
                if (o00Var.OxI() - i > 441) {
                    f2537Oxx0IOOO.ooOOo0oXI("Too many number formats - using default format.");
                }
                xIVar.II0xO0(o00Var.OxI(), o00Var.OxI() - i);
            }
        }
        this.f2541II0xO0 = arrayList;
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            o00 o00Var3 = (o00) it3.next();
            o00Var3.initialize(xIVar.oIX0oI(o00Var3.OxI()));
        }
        return xIVar;
    }

    public final DateFormat oxoX(int i) {
        XX xx2 = (XX) this.f2540I0Io.get(i);
        if (xx2.xoxXI()) {
            return xx2.x0o();
        }
        XxX0x0xxx xxX0x0xxx = (XxX0x0xxx) this.f2544oIX0oI.get(new Integer(xx2.I0X0x0oIo()));
        if (xxX0x0xxx == null || !xxX0x0xxx.I0X0x0oIo()) {
            return null;
        }
        return xxX0x0xxx.x0o();
    }

    public xI x0XOIxOo() {
        return this.f2542X0o0xo.I0Io();
    }

    public void x0xO0oo(IoOoX ioOoX) {
        this.f2543XO = ioOoX;
    }

    public final XX xoIox(int i) {
        return (XX) this.f2540I0Io.get(i);
    }

    public IoOoX xxIXOIIO() {
        return this.f2543XO;
    }
}
