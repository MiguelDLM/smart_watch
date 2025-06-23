package com.kwad.components.core.c;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.az;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class l implements c {
    @Nullable
    @WorkerThread
    public static AdResultData d(com.kwad.components.core.request.model.a aVar) {
        a mU = a.mU();
        if (mU == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<h> a2 = mU.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, e.s(aVar.getPosId()).nb());
        if (com.kwad.sdk.core.config.d.Di()) {
            k(a2);
        }
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        Collections.sort(a2);
        return h.j(a2.subList(0, Math.min(a2.size(), adNum)));
    }

    private static void k(List<h> list) {
        if (list == null) {
            return;
        }
        Iterator<h> it = list.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (g.nf().a(next)) {
                com.kwad.sdk.core.e.c.d("StrategyLocalCacheFirst", "filterByMemCached contain: " + next.nm());
                it.remove();
            }
        }
    }

    @Override // com.kwad.components.core.c.c
    public final void c(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Gr().submit(new az() { // from class: com.kwad.components.core.c.l.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                AdResultData d = l.d(aVar);
                if (d != null && !d.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, d, true);
                } else {
                    com.kwad.components.core.request.model.a aVar2 = aVar;
                    n.a(aVar2, new j(aVar2));
                }
            }
        });
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyLocalCacheFirst";
    }
}
