package com.garmin.fit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public class ooXIXxIX extends IXxOIOO {

    /* renamed from: OX, reason: collision with root package name */
    public final List<oIXoXx0> f14971OX;

    /* renamed from: oXIoO, reason: collision with root package name */
    public final List<XxI> f14972oXIoO;

    public ooXIXxIX() {
        this.f14971OX = new ArrayList();
        this.f14972oXIoO = new ArrayList();
    }

    @Override // com.garmin.fit.IXxOIOO, com.garmin.fit.IXIxx0
    public void II0xO0(oIXoXx0 oixoxx0) {
        this.f14971OX.add(oixoxx0);
        Iterator<XxI> it = this.f14972oXIoO.iterator();
        while (it.hasNext()) {
            it.next().oIX0oI(oixoxx0);
        }
    }

    public void IxO0Oxo() {
        Iterator<XxI> it = this.f14972oXIoO.iterator();
        while (it.hasNext()) {
            it.next().II0xO0(this.f14971OX);
        }
        Iterator<oIXoXx0> it2 = this.f14971OX.iterator();
        while (it2.hasNext()) {
            super.II0xO0(it2.next());
        }
    }

    public void XoOOx0IX(XxI xxI) {
        this.f14972oXIoO.add(xxI);
    }

    public ooXIXxIX(Decode decode) {
        super(decode);
        this.f14971OX = new ArrayList();
        this.f14972oXIoO = new ArrayList();
    }
}
