package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public class h {
    private static volatile h axa;
    private List<a> awZ = new CopyOnWriteArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void a(f fVar, int i);
    }

    private h() {
    }

    public static h Ex() {
        if (axa == null) {
            synchronized (h.class) {
                try {
                    if (axa == null) {
                        axa = new h();
                    }
                } finally {
                }
            }
        }
        return axa;
    }

    public final void a(a aVar) {
        this.awZ.add(aVar);
    }

    public final void b(f fVar, int i) {
        Iterator<a> it = this.awZ.iterator();
        while (it.hasNext()) {
            it.next().a(fVar, i);
        }
    }
}
