package com.octopus.ad.internal;

import java.util.ArrayList;

/* loaded from: classes11.dex */
public abstract class oOoXoXO implements oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public long f18655oIX0oI = -1;

    /* renamed from: II0xO0, reason: collision with root package name */
    public ArrayList<String> f18654II0xO0 = new ArrayList<>();

    public void I0Io() {
        this.f18655oIX0oI = System.currentTimeMillis();
    }

    public abstract void II0xO0();

    public void oxoX() {
        if (this.f18654II0xO0.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("Mediation Classes: \n");
        for (int size = this.f18654II0xO0.size(); size > 0; size--) {
            sb.append(String.format("%d: %s\n", Integer.valueOf(size), this.f18654II0xO0.get(size - 1)));
        }
        com.octopus.ad.internal.utilities.oIX0oI.IIXOooo(com.octopus.ad.internal.utilities.oIX0oI.f18683I0Io, sb.toString());
        this.f18654II0xO0.clear();
    }
}
