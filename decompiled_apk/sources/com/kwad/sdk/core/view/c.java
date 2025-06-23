package com.kwad.sdk.core.view;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class c {
    private List<b> aEU = new CopyOnWriteArrayList();

    public final void a(b bVar) {
        this.aEU.add(bVar);
    }

    public final void b(b bVar) {
        this.aEU.remove(bVar);
    }

    public final void j(View view, boolean z) {
        Iterator<b> it = this.aEU.iterator();
        while (it.hasNext()) {
            it.next().i(view, z);
        }
    }
}
