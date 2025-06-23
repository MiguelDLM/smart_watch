package com.kwad.components.core.internal.api;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class c {

    @NonNull
    private List<b> MJ = new CopyOnWriteArrayList();
    private boolean MK = false;
    private boolean ML = false;

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.MJ.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.MJ.remove(bVar);
    }

    public final void h(a aVar) {
        com.kwad.sdk.core.e.c.d("KsAdListenerHolder", "notifyAdEnter: " + aVar + ", hadNotifiedEnter: " + this.ML);
        if (this.ML) {
            return;
        }
        Iterator<b> it = this.MJ.iterator();
        while (it.hasNext()) {
            it.next().c(aVar);
        }
        this.ML = true;
    }

    public final void i(a aVar) {
        com.kwad.sdk.core.e.c.d("KsAdListenerHolder", "notifyAdExit: " + aVar + ", hadNotifiedExit: " + this.MK);
        if (this.MK) {
            return;
        }
        Iterator<b> it = this.MJ.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        this.MK = true;
    }
}
