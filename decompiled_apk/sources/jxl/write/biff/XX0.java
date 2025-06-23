package jxl.write.biff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import jxl.write.WriteException;

/* loaded from: classes6.dex */
public class XX0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28763I0Io = XxIIOXIXx.X0o0xo.Oxx0IOOO(XX0.class);

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f28764oxoX = 1020;

    /* renamed from: II0xO0, reason: collision with root package name */
    public oIXoXx0.O0xOxO f28765II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ArrayList f28766oIX0oI = new ArrayList();

    public XX0(oIXoXx0.O0xOxO o0xOxO) {
        this.f28765II0xO0 = o0xOxO;
    }

    public final void I0Io() {
        for (int i = 0; i < this.f28766oIX0oI.size(); i++) {
            try {
                OoIXo.X00IoxXI x00IoxXI = (OoIXo.X00IoxXI) this.f28766oIX0oI.get(i);
                xIoXXXIXo.I0Io oIX0oI2 = x00IoxXI.oIX0oI();
                xIoXXXIXo.I0Io II0xO02 = x00IoxXI.II0xO0();
                boolean z = false;
                for (int oIX0oI3 = oIX0oI2.oIX0oI(); oIX0oI3 <= II0xO02.oIX0oI(); oIX0oI3++) {
                    for (int II0xO03 = oIX0oI2.II0xO0(); II0xO03 <= II0xO02.II0xO0(); II0xO03++) {
                        if (this.f28765II0xO0.XX(oIX0oI3, II0xO03).getType() != xIoXXXIXo.Oxx0IOOO.f34234II0xO0) {
                            if (!z) {
                                z = true;
                            } else {
                                f28763I0Io.ooOOo0oXI("Range " + x00IoxXI + " contains more than one data cell.  Setting the other cells to blank.");
                                this.f28765II0xO0.o00(new oIXoXx0.II0xO0(oIX0oI3, II0xO03));
                            }
                        }
                    }
                }
            } catch (WriteException unused) {
                XxIIOXIXx.oIX0oI.oIX0oI(false);
                return;
            }
        }
    }

    public void II0XooXoX(int i) {
        Iterator it = this.f28766oIX0oI.iterator();
        while (it.hasNext()) {
            OoIXo.X00IoxXI x00IoxXI = (OoIXo.X00IoxXI) it.next();
            if (x00IoxXI.oIX0oI().II0xO0() == i && x00IoxXI.II0xO0().II0xO0() == i) {
                it.remove();
            } else {
                x00IoxXI.xxIXOIIO(i);
            }
        }
    }

    public final void II0xO0() {
        ArrayList arrayList = new ArrayList(this.f28766oIX0oI.size());
        Iterator it = this.f28766oIX0oI.iterator();
        while (it.hasNext()) {
            OoIXo.X00IoxXI x00IoxXI = (OoIXo.X00IoxXI) it.next();
            Iterator it2 = arrayList.iterator();
            boolean z = false;
            while (it2.hasNext() && !z) {
                if (((OoIXo.X00IoxXI) it2.next()).Oxx0IOOO(x00IoxXI)) {
                    f28763I0Io.ooOOo0oXI("Could not merge cells " + x00IoxXI + " as they clash with an existing set of merged cells.");
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(x00IoxXI);
            }
        }
        this.f28766oIX0oI = arrayList;
    }

    public void Oxx0IOOO(int i) {
        Iterator it = this.f28766oIX0oI.iterator();
        while (it.hasNext()) {
            OoIXo.X00IoxXI x00IoxXI = (OoIXo.X00IoxXI) it.next();
            if (x00IoxXI.oIX0oI().oIX0oI() == i && x00IoxXI.II0xO0().oIX0oI() == i) {
                it.remove();
            } else {
                x00IoxXI.II0XooXoX(i);
            }
        }
    }

    public void X0o0xo(int i) {
        Iterator it = this.f28766oIX0oI.iterator();
        while (it.hasNext()) {
            ((OoIXo.X00IoxXI) it.next()).X0o0xo(i);
        }
    }

    public void XO(int i) {
        Iterator it = this.f28766oIX0oI.iterator();
        while (it.hasNext()) {
            ((OoIXo.X00IoxXI) it.next()).XO(i);
        }
    }

    public void oIX0oI(xIoXXXIXo.OxxIIOOXO oxxIIOOXO) {
        this.f28766oIX0oI.add(oxxIIOOXO);
    }

    public xIoXXXIXo.OxxIIOOXO[] oxoX() {
        int size = this.f28766oIX0oI.size();
        xIoXXXIXo.OxxIIOOXO[] oxxIIOOXOArr = new xIoXXXIXo.OxxIIOOXO[size];
        for (int i = 0; i < size; i++) {
            oxxIIOOXOArr[i] = (xIoXXXIXo.OxxIIOOXO) this.f28766oIX0oI.get(i);
        }
        return oxxIIOOXOArr;
    }

    public void xoIox(IIX0o iIX0o) throws IOException {
        if (this.f28766oIX0oI.size() == 0) {
            return;
        }
        if (!((XOxxooXI) this.f28765II0xO0).I0().Oo()) {
            II0xO0();
            I0Io();
        }
        if (this.f28766oIX0oI.size() < 1020) {
            iIX0o.XO(new I0X0x0oIo(this.f28766oIX0oI));
            return;
        }
        int size = (this.f28766oIX0oI.size() / 1020) + 1;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int min = Math.min(1020, this.f28766oIX0oI.size() - i);
            ArrayList arrayList = new ArrayList(min);
            for (int i3 = 0; i3 < min; i3++) {
                arrayList.add(this.f28766oIX0oI.get(i + i3));
            }
            iIX0o.XO(new I0X0x0oIo(arrayList));
            i += min;
        }
    }

    public void xxIXOIIO(xIoXXXIXo.OxxIIOOXO oxxIIOOXO) {
        int indexOf = this.f28766oIX0oI.indexOf(oxxIIOOXO);
        if (indexOf != -1) {
            this.f28766oIX0oI.remove(indexOf);
        }
    }
}
