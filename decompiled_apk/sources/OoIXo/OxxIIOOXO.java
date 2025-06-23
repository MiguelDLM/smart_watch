package OoIXo;

import com.garmin.fit.OxXXx0X;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class OxxIIOOXO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2166II0XooXoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(OxxIIOOXO.class);

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f2167xoIox = 65533;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f2168xxIXOIIO = -1;

    /* renamed from: I0Io, reason: collision with root package name */
    public x0o f2169I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public ArrayList f2170II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f2171Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f2172X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f2173XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public IIXOooo f2174oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public jxl.biff.formula.OxxIIOOXO f2175oxoX;

    public OxxIIOOXO(IIXOooo iIXOooo) {
        this.f2174oIX0oI = iIXOooo;
        this.f2170II0xO0 = new ArrayList(this.f2174oIX0oI.oX());
        this.f2171Oxx0IOOO = false;
    }

    public IIXOooo I0Io() {
        return this.f2174oIX0oI;
    }

    public void II0XooXoX(int i) {
        Iterator it = this.f2170II0xO0.iterator();
        while (it.hasNext()) {
            xoXoI xoxoi = (xoXoI) it.next();
            if (xoxoi.I0X0x0oIo() == i && xoxoi.Xx000oIo() == i) {
                it.remove();
                this.f2174oIX0oI.I0X0x0oIo();
            } else {
                xoxoi.xoxXI(i);
            }
        }
    }

    public int II0xO0() {
        return this.f2173XO;
    }

    public void OOXIXo(int i, int i2, int i3, int i4) {
        Iterator it = this.f2170II0xO0.iterator();
        while (it.hasNext()) {
            xoXoI xoxoi = (xoXoI) it.next();
            if (xoxoi.I0X0x0oIo() == i && xoxoi.Xx000oIo() == i3 && xoxoi.oX() == i2 && xoxoi.Oxx0xo() == i4) {
                it.remove();
                this.f2174oIX0oI.I0X0x0oIo();
                return;
            }
        }
    }

    public void Oxx0IOOO(int i) {
        Iterator it = this.f2170II0xO0.iterator();
        while (it.hasNext()) {
            ((xoXoI) it.next()).I0oOIX(i);
        }
    }

    public xoXoI[] X0o0xo() {
        return (xoXoI[]) this.f2170II0xO0.toArray(new xoXoI[0]);
    }

    public void XO(int i) {
        Iterator it = this.f2170II0xO0.iterator();
        while (it.hasNext()) {
            ((xoXoI) it.next()).O0Xx(i);
        }
    }

    public void oIX0oI(xoXoI xoxoi) {
        boolean z;
        this.f2170II0xO0.add(xoxoi);
        xoxoi.IoOoo(this);
        if (this.f2171Oxx0IOOO) {
            if (this.f2174oIX0oI != null) {
                z = true;
            } else {
                z = false;
            }
            XxIIOXIXx.oIX0oI.oIX0oI(z);
            this.f2174oIX0oI.XX0();
        }
    }

    public void oOoXoXO(jxl.write.biff.IIX0o iIX0o) throws IOException {
        if (this.f2170II0xO0.size() > 65533) {
            f2166II0XooXoX.ooOOo0oXI("Maximum number of data validations exceeded - truncating...");
            boolean z = false;
            ArrayList arrayList = new ArrayList(this.f2170II0xO0.subList(0, OxXXx0X.XXOOoxx0x));
            this.f2170II0xO0 = arrayList;
            if (arrayList.size() <= 65533) {
                z = true;
            }
            XxIIOXIXx.oIX0oI.oIX0oI(z);
        }
        if (this.f2174oIX0oI == null) {
            this.f2174oIX0oI = new IIXOooo(new oI0IIXIo(this.f2173XO, this.f2170II0xO0.size()));
        }
        if (!this.f2174oIX0oI.XoI0Ixx0()) {
            return;
        }
        iIX0o.XO(this.f2174oIX0oI);
        Iterator it = this.f2170II0xO0.iterator();
        while (it.hasNext()) {
            iIX0o.XO((xoXoI) it.next());
        }
    }

    public xoXoI oxoX(int i, int i2) {
        Iterator it = this.f2170II0xO0.iterator();
        boolean z = false;
        xoXoI xoxoi = null;
        while (it.hasNext() && !z) {
            xoXoI xoxoi2 = (xoXoI) it.next();
            if (xoxoi2.I0X0x0oIo() == i && xoxoi2.oX() == i2) {
                z = true;
                xoxoi = xoxoi2;
            }
        }
        return xoxoi;
    }

    public void xoIox(int i) {
        Iterator it = this.f2170II0xO0.iterator();
        while (it.hasNext()) {
            xoXoI xoxoi = (xoXoI) it.next();
            if (xoxoi.oX() == i && xoxoi.Oxx0xo() == i) {
                it.remove();
                this.f2174oIX0oI.I0X0x0oIo();
            } else {
                xoxoi.OO(i);
            }
        }
    }

    public void xxIXOIIO(int i, int i2) {
        Iterator it = this.f2170II0xO0.iterator();
        while (it.hasNext()) {
            xoXoI xoxoi = (xoXoI) it.next();
            if (xoxoi.I0X0x0oIo() == i && xoxoi.Xx000oIo() == i && xoxoi.oX() == i2 && xoxoi.Oxx0xo() == i2) {
                it.remove();
                this.f2174oIX0oI.I0X0x0oIo();
                return;
            }
        }
    }

    public OxxIIOOXO(int i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f2169I0Io = x0oVar;
        this.f2175oxoX = oxxIIOOXO;
        this.f2172X0o0xo = o0xOxO;
        this.f2170II0xO0 = new ArrayList();
        this.f2173XO = i;
        this.f2171Oxx0IOOO = false;
    }

    public OxxIIOOXO(OxxIIOOXO oxxIIOOXO, jxl.biff.formula.OxxIIOOXO oxxIIOOXO2, x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f2169I0Io = x0oVar;
        this.f2175oxoX = oxxIIOOXO2;
        this.f2172X0o0xo = o0xOxO;
        this.f2171Oxx0IOOO = true;
        this.f2174oIX0oI = new IIXOooo(oxxIIOOXO.I0Io());
        this.f2170II0xO0 = new ArrayList();
        for (xoXoI xoxoi : oxxIIOOXO.X0o0xo()) {
            this.f2170II0xO0.add(new xoXoI(xoxoi, this.f2175oxoX, this.f2169I0Io, this.f2172X0o0xo));
        }
    }
}
