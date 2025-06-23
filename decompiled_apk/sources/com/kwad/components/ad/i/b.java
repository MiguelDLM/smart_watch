package com.kwad.components.ad.i;

import com.kwad.components.core.proxy.h;
import com.kwad.components.core.proxy.i;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes11.dex */
public class b implements com.kwad.components.core.internal.api.b {
    private static final Object nG = new Object();
    private static volatile b nH;
    private Set<Integer> nI = new HashSet();
    private List<c> nJ = new ArrayList();
    private Map<com.kwad.components.core.internal.api.a, Object> nK = new WeakHashMap();
    private Map<com.kwad.components.core.proxy.c, Object> nL = new WeakHashMap();
    private i nM = new i() { // from class: com.kwad.components.ad.i.b.1
        @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.core.c.c
        /* renamed from: a */
        public final void d(com.kwad.components.core.proxy.c cVar) {
            super.d(cVar);
            b.this.nL.put(cVar, b.nG);
        }

        @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.core.c.c
        /* renamed from: b */
        public final void c(com.kwad.components.core.proxy.c cVar) {
            super.c(cVar);
            b.this.nL.remove(cVar);
            if (b.this.nL.isEmpty()) {
                b.this.eK();
            }
        }
    };

    private b() {
        h.qG().a(this.nM);
        this.nI.add(2);
        this.nI.add(3);
        this.nI.add(13);
        this.nI.add(6);
    }

    private boolean A(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return this.nI.contains(Integer.valueOf(adTemplate.adStyle));
    }

    private void e(com.kwad.components.core.internal.api.a aVar) {
        this.nK.put(aVar, nG);
        if (g(aVar)) {
            c cVar = new c(aVar);
            cVar.eN();
            this.nJ.add(cVar);
        }
    }

    public static b eJ() {
        if (nH == null) {
            synchronized (b.class) {
                try {
                    if (nH == null) {
                        nH = new b();
                    }
                } finally {
                }
            }
        }
        return nH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eK() {
        boolean eL = eL();
        com.kwad.sdk.core.e.c.d("KsAdGlobalWatcher", "checkCurrentPage noSDKPage: " + eL);
        if (eL) {
            Iterator<c> it = this.nJ.iterator();
            while (it.hasNext()) {
                it.next().eP();
            }
        }
    }

    private void f(com.kwad.components.core.internal.api.a aVar) {
        this.nK.remove(aVar);
        Iterator<c> it = this.nJ.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        if (A(aVar.getAdTemplate())) {
            eK();
        }
    }

    private static boolean g(com.kwad.components.core.internal.api.a aVar) {
        if (!aVar.ag()) {
            return false;
        }
        return com.kwad.sdk.core.response.b.a.cV(com.kwad.sdk.core.response.b.e.dS(aVar.getAdTemplate()));
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void c(com.kwad.components.core.internal.api.a aVar) {
        e(aVar);
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void d(com.kwad.components.core.internal.api.a aVar) {
        f(aVar);
        b(aVar);
    }

    public final synchronized boolean eL() {
        Iterator<com.kwad.components.core.internal.api.a> it = this.nK.keySet().iterator();
        while (it.hasNext()) {
            if (A(it.next().getAdTemplate())) {
                return false;
            }
        }
        return this.nL.isEmpty();
    }

    public final void a(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void b(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.nJ.remove(cVar);
        }
    }
}
