package com.garmin.fit;

import java.util.Iterator;

/* loaded from: classes9.dex */
public class Xox0o implements OxIxx0 {
    public final boolean I0Io(xooxxX xooxxx) {
        if (xooxxx.f15597X0o0xo.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.garmin.fit.OxIxx0
    public boolean II0xO0(oIXoXx0 oixoxx0) {
        if (I0Io(new xooxxX(oixoxx0))) {
            return false;
        }
        Iterator<X0xII0I> it = oixoxx0.XIXIxO().iterator();
        while (it.hasNext()) {
            if ((it.next().oxIIX0o() & 31) > 13) {
                return false;
            }
        }
        return true;
    }

    @Override // com.garmin.fit.OxIxx0
    public boolean oIX0oI(xooxxX xooxxx) {
        if (I0Io(xooxxx)) {
            return false;
        }
        Iterator<XXXI> it = xooxxx.II0XooXoX().iterator();
        while (it.hasNext()) {
            if ((it.next().oxoX() & 31) > 13) {
                return false;
            }
        }
        return true;
    }
}
