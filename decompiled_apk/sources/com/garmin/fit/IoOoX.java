package com.garmin.fit;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class IoOoX implements oxOIoIx {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public oo0xXOI0I f11936oIX0oI = new oo0xXOI0I();

    /* renamed from: II0xO0, reason: collision with root package name */
    public ArrayList<oOXoIIIo> f11935II0xO0 = new ArrayList<>();

    public void I0Io(oOXoIIIo ooxoiiio) {
        this.f11935II0xO0.remove(ooxoiiio);
    }

    public void II0xO0(oOXoIIIo ooxoiiio) {
        this.f11935II0xO0.add(ooxoiiio);
    }

    @Override // com.garmin.fit.oxOIoIx
    public void oIX0oI(oI00o oi00o) {
        this.f11936oIX0oI.IOoo(oi00o);
        Iterator<oOXoIIIo> it = this.f11935II0xO0.iterator();
        while (it.hasNext()) {
            it.next().oIX0oI(this.f11936oIX0oI);
        }
    }
}
