package com.kwad.components.core.s;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes11.dex */
public final class c {
    private Set<b> TL;

    /* loaded from: classes11.dex */
    public static class a {
        private static c TM = new c(0);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onPageClose();
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static c rD() {
        return a.TM;
    }

    public final void a(b bVar) {
        this.TL.add(bVar);
    }

    public final void b(b bVar) {
        this.TL.remove(bVar);
    }

    public final void rE() {
        if (this.TL.size() == 0) {
            return;
        }
        Iterator<b> it = this.TL.iterator();
        while (it.hasNext()) {
            it.next().onPageClose();
        }
    }

    private c() {
        this.TL = new HashSet();
    }
}
