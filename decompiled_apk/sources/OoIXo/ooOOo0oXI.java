package OoIXo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class ooOOo0oXI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public ArrayList f2349II0xO0 = new ArrayList();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public x0XOIxOo f2350oIX0oI;

    public ooOOo0oXI(x0XOIxOo x0xoixoo) {
        this.f2350oIX0oI = x0xoixoo;
    }

    public void I0Io(int i) {
        this.f2350oIX0oI.oX(i);
    }

    public void II0xO0(int i) {
        this.f2350oIX0oI.I0X0x0oIo(i);
    }

    public void X0o0xo(int i) {
        this.f2350oIX0oI.XoI0Ixx0(i);
    }

    public void XO(jxl.write.biff.IIX0o iIX0o) throws IOException {
        iIX0o.XO(this.f2350oIX0oI);
        Iterator it = this.f2349II0xO0.iterator();
        while (it.hasNext()) {
            iIX0o.XO((oO) it.next());
        }
    }

    public void oIX0oI(oO oOVar) {
        this.f2349II0xO0.add(oOVar);
    }

    public void oxoX(int i) {
        this.f2350oIX0oI.Xo0(i);
    }
}
