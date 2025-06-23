package com.kwad.library.solder.lib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public final class e implements com.kwad.library.solder.lib.a.d {
    private final com.kwad.library.solder.lib.ext.c ajN;
    private final com.kwad.library.solder.lib.a.c ajP;
    private final com.kwad.library.solder.lib.a.f ajQ;
    private final com.kwad.library.solder.lib.a.b ajR;
    private final com.kwad.library.solder.lib.ext.a ajS;
    private Map<String, b> ajT;

    /* loaded from: classes11.dex */
    public static abstract class a {
        final com.kwad.library.solder.lib.a.d ajX;

        /* renamed from: com.kwad.library.solder.lib.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0835a extends a {
            public C0835a(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.ajX.xD().g(eVar);
            }
        }

        /* loaded from: classes11.dex */
        public static class b extends a {
            public b(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.ajX.xE().k(eVar);
            }
        }

        public a(com.kwad.library.solder.lib.a.d dVar) {
            this.ajX = dVar;
        }

        public static a a(com.kwad.library.solder.lib.a.d dVar, int i) {
            if (i != 1) {
                return new C0835a(dVar);
            }
            return new b(dVar);
        }

        public abstract void j(com.kwad.library.solder.lib.a.e eVar);
    }

    /* loaded from: classes11.dex */
    public static class b {
        private final com.kwad.library.solder.lib.a.e ajY;
        private final Future<com.kwad.library.solder.lib.a.e> ajZ;

        public b(com.kwad.library.solder.lib.a.e eVar, Future<com.kwad.library.solder.lib.a.e> future) {
            this.ajY = eVar;
            this.ajZ = future;
        }

        public final void cancel() {
            this.ajY.cancel();
            this.ajZ.cancel(true);
        }
    }

    public e(com.kwad.library.solder.lib.a.c cVar, com.kwad.library.solder.lib.a.f fVar, com.kwad.library.solder.lib.a.b bVar, com.kwad.library.solder.lib.ext.c cVar2, com.kwad.library.solder.lib.ext.a aVar) {
        this.ajP = cVar;
        this.ajQ = fVar;
        this.ajR = bVar;
        this.ajN = cVar2;
        this.ajS = aVar;
    }

    private b b(@NonNull final com.kwad.library.solder.lib.a.e eVar, @NonNull final a aVar) {
        b bK = bK(eVar.xT());
        if (bK != null) {
            bK.cancel();
        }
        eVar.a(this);
        b bVar = new b(eVar, this.ajN.ym().submit(new Callable<com.kwad.library.solder.lib.a.e>() { // from class: com.kwad.library.solder.lib.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: xH, reason: merged with bridge method [inline-methods] */
            public com.kwad.library.solder.lib.a.e call() {
                return e.this.a(eVar, aVar);
            }
        }));
        a(eVar.xT(), bVar);
        return bVar;
    }

    @Nullable
    private synchronized b bK(String str) {
        Map<String, b> d = d(this.ajT);
        this.ajT = d;
        if (str != null) {
            return d.get(str);
        }
        return null;
    }

    private static Map<String, b> d(Map<String, b> map) {
        if (map == null || map == Collections.EMPTY_MAP) {
            return new HashMap();
        }
        return map;
    }

    public final com.kwad.library.solder.lib.a.e a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull a aVar) {
        if (eVar.xP() == null) {
            eVar.a(this);
        }
        eVar.xT();
        eVar.xQ();
        aVar.j(eVar);
        return eVar;
    }

    public final void i(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        b bK = bK(eVar.xT());
        if (bK != null) {
            bK.cancel();
        }
        a(eVar.xT(), (b) null);
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.c xC() {
        return this.ajN;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.c xD() {
        return this.ajP;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.f xE() {
        return this.ajQ;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.b xF() {
        return this.ajR;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.a xG() {
        return this.ajS;
    }

    public final b a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull int i) {
        return b(eVar, a.a(this, 16));
    }

    private synchronized void a(String str, b bVar) {
        Map<String, b> d = d(this.ajT);
        this.ajT = d;
        if (str != null) {
            d.put(str, bVar);
        }
    }
}
