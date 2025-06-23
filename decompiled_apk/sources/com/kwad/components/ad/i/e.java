package com.kwad.components.ad.i;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class e {
    private final AtomicBoolean oe;
    private final List<com.kwad.components.ad.b.a.b> of;

    /* loaded from: classes11.dex */
    public static class a {
        private static final e og = new e(0);
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e eW() {
        return a.og;
    }

    public final boolean S() {
        return this.oe.get();
    }

    public final void a(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.of.add(bVar);
        }
    }

    public final void b(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.of.remove(bVar);
        }
    }

    public final void eS() {
        this.oe.set(true);
        Iterator<com.kwad.components.ad.b.a.b> it = this.of.iterator();
        while (it.hasNext()) {
            it.next().T();
        }
    }

    public final void eU() {
        this.oe.set(false);
        Iterator<com.kwad.components.ad.b.a.b> it = this.of.iterator();
        while (it.hasNext()) {
            it.next().U();
        }
    }

    private e() {
        this.oe = new AtomicBoolean();
        this.of = new CopyOnWriteArrayList();
    }
}
