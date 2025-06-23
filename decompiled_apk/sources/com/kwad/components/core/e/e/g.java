package com.kwad.components.core.e.e;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class g {
    private final List<f> LW;

    /* loaded from: classes11.dex */
    public static class a {
        private static final g LX = new g(0);
    }

    public /* synthetic */ g(byte b) {
        this();
    }

    public static g oQ() {
        return a.LX;
    }

    public final void a(f fVar) {
        this.LW.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.LW.remove(fVar);
        }
    }

    public final void oR() {
        Iterator<f> it = this.LW.iterator();
        while (it.hasNext()) {
            it.next().show();
        }
    }

    public final void oS() {
        Iterator<f> it = this.LW.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
        }
    }

    private g() {
        this.LW = new CopyOnWriteArrayList();
    }
}
