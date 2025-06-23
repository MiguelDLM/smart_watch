package com.kwad.sdk.l.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class a {
    private final List<b> aOm = new ArrayList();

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.aOm.add(bVar);
        }
    }

    public final boolean onBackPressed() {
        Iterator<b> it = this.aOm.iterator();
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.aOm.remove(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i) {
        if (bVar != null) {
            this.aOm.add(i, bVar);
        }
    }
}
