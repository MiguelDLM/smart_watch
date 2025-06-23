package O0Xx;

import com.garmin.fit.IXIxx0;
import com.garmin.fit.O0xO0;
import com.garmin.fit.oIXoXx0;
import com.garmin.fit.x0OxxIOxX;
import com.garmin.fit.xooxxX;
import com.garmin.fit.xx0o0O;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class oOoXoXO implements IXIxx0, O0xO0, xx0o0O {

    /* renamed from: I0Io, reason: collision with root package name */
    public HashSet<String> f1446I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public HashSet<String> f1450X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public HashSet<String> f1451XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public HashSet<String> f1453oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ArrayList<IXIxx0> f1452oIX0oI = new ArrayList<>();

    /* renamed from: II0xO0, reason: collision with root package name */
    public ArrayList<O0xO0> f1448II0xO0 = new ArrayList<>();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f1449Oxx0IOOO = true;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f1447II0XooXoX = true;

    public void II0XooXoX(HashSet<String> hashSet) {
        if (this.f1446I0Io == null) {
            this.f1453oxoX = hashSet;
            if (hashSet.contains("none")) {
                this.f1449Oxx0IOOO = false;
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Setting both an include filter and an exclude filter not supported.");
    }

    @Override // com.garmin.fit.IXIxx0
    public void II0xO0(oIXoXx0 oixoxx0) {
        if (this.f1447II0XooXoX) {
            HashSet<String> hashSet = this.f1450X0o0xo;
            if (hashSet != null && !hashSet.isEmpty()) {
                if (!this.f1450X0o0xo.contains(oixoxx0.x0OIX00oO())) {
                    return;
                }
            } else {
                HashSet<String> hashSet2 = this.f1451XO;
                if (hashSet2 != null && !hashSet2.isEmpty() && this.f1451XO.contains(oixoxx0.x0OIX00oO())) {
                    return;
                }
            }
            Iterator<IXIxx0> it = this.f1452oIX0oI.iterator();
            while (it.hasNext()) {
                it.next().II0xO0(oixoxx0);
            }
        }
    }

    public void Oxx0IOOO(HashSet<String> hashSet) {
        this.f1450X0o0xo = hashSet;
        if (hashSet.contains("none")) {
            this.f1447II0XooXoX = false;
        }
    }

    public void X0o0xo(O0xO0 o0xO0) {
        if (o0xO0 != null && !this.f1448II0xO0.contains(o0xO0)) {
            this.f1448II0xO0.add(o0xO0);
        }
    }

    public void XO(HashSet<String> hashSet) {
        this.f1451XO = hashSet;
        if (hashSet.contains("none")) {
            this.f1447II0XooXoX = false;
        }
    }

    @Override // com.garmin.fit.xx0o0O
    public void oIX0oI(IXIxx0 iXIxx0) {
        if (iXIxx0 != null && !this.f1452oIX0oI.contains(iXIxx0)) {
            this.f1452oIX0oI.add(iXIxx0);
        }
    }

    @Override // com.garmin.fit.O0xO0
    public void oxoX(xooxxX xooxxx) {
        oIXoXx0 XO2 = x0OxxIOxX.XO(xooxxx.xoIox());
        if (this.f1449Oxx0IOOO) {
            HashSet<String> hashSet = this.f1446I0Io;
            if (hashSet != null && !hashSet.isEmpty()) {
                if (!this.f1446I0Io.contains(XO2.x0OIX00oO())) {
                    return;
                }
            } else {
                HashSet<String> hashSet2 = this.f1453oxoX;
                if (hashSet2 != null && !hashSet2.isEmpty() && this.f1453oxoX.contains(XO2.x0OIX00oO())) {
                    return;
                }
            }
            Iterator<O0xO0> it = this.f1448II0xO0.iterator();
            while (it.hasNext()) {
                it.next().oxoX(xooxxx);
            }
        }
    }

    public void xxIXOIIO(HashSet<String> hashSet) {
        if (this.f1453oxoX == null) {
            this.f1446I0Io = hashSet;
            if (hashSet.contains("none")) {
                this.f1449Oxx0IOOO = false;
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Setting both an include filter and an exclude filter not supported.");
    }
}
