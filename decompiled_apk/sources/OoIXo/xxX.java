package OoIXo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class xxX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f2557II0xO0 = 4;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ArrayList f2558oIX0oI = new ArrayList();

    public xI I0Io() {
        boolean z;
        xI xIVar = new xI(this.f2558oIX0oI.size() + 1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            XIxXXX0x0 xIxXXX0x0 = (XIxXXX0x0) this.f2558oIX0oI.get(i);
            arrayList.add(xIxXXX0x0);
            xIVar.II0xO0(xIxXXX0x0.XX0(), xIxXXX0x0.XX0());
        }
        int i2 = 0;
        for (int i3 = 4; i3 < this.f2558oIX0oI.size(); i3++) {
            XIxXXX0x0 xIxXXX0x02 = (XIxXXX0x0) this.f2558oIX0oI.get(i3);
            Iterator it = arrayList.iterator();
            boolean z2 = false;
            while (it.hasNext() && !z2) {
                XIxXXX0x0 xIxXXX0x03 = (XIxXXX0x0) it.next();
                if (xIxXXX0x02.equals(xIxXXX0x03)) {
                    xIVar.II0xO0(xIxXXX0x02.XX0(), xIVar.oIX0oI(xIxXXX0x03.XX0()));
                    i2++;
                    z2 = true;
                }
            }
            if (!z2) {
                arrayList.add(xIxXXX0x02);
                int XX02 = xIxXXX0x02.XX0() - i2;
                if (XX02 > 4) {
                    z = true;
                } else {
                    z = false;
                }
                XxIIOXIXx.oIX0oI.oIX0oI(z);
                xIVar.II0xO0(xIxXXX0x02.XX0(), XX02);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            XIxXXX0x0 xIxXXX0x04 = (XIxXXX0x0) it2.next();
            xIxXXX0x04.initialize(xIVar.oIX0oI(xIxXXX0x04.XX0()));
        }
        this.f2558oIX0oI = arrayList;
        return xIVar;
    }

    public XIxXXX0x0 II0xO0(int i) {
        if (i > 4) {
            i--;
        }
        return (XIxXXX0x0) this.f2558oIX0oI.get(i);
    }

    public void oIX0oI(XIxXXX0x0 xIxXXX0x0) {
        if (!xIxXXX0x0.isInitialized()) {
            int size = this.f2558oIX0oI.size();
            if (size >= 4) {
                size++;
            }
            xIxXXX0x0.initialize(size);
            this.f2558oIX0oI.add(xIxXXX0x0);
        }
    }

    public void oxoX(jxl.write.biff.IIX0o iIX0o) throws IOException {
        Iterator it = this.f2558oIX0oI.iterator();
        while (it.hasNext()) {
            iIX0o.XO((XIxXXX0x0) it.next());
        }
    }
}
