package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.e.b;
import com.kwad.framework.filedownloader.f.c;

/* loaded from: classes11.dex */
public final class c {
    private final b aiF;

    /* loaded from: classes11.dex */
    public interface a {
        c.b vY();
    }

    /* loaded from: classes11.dex */
    public static class b {
        c.InterfaceC0829c aiG;
        Integer aiH;
        c.e aiI;
        c.b aiJ;
        a aiK;
        c.a aiL;
        c.d aiM;

        public final b a(c.b bVar) {
            this.aiJ = bVar;
            return this;
        }

        public final b bH(int i) {
            this.aiH = Integer.MAX_VALUE;
            return this;
        }

        public final String toString() {
            return com.kwad.framework.filedownloader.f.f.b("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.aiG, this.aiH, this.aiI, this.aiJ, this.aiL);
        }

        public final b a(a aVar) {
            this.aiK = aVar;
            return this;
        }
    }

    public c() {
        this.aiF = null;
    }

    private static c.d xa() {
        return new com.kwad.framework.filedownloader.services.b();
    }

    private static int xb() {
        return com.kwad.framework.filedownloader.f.e.xr().ajg;
    }

    private static c.e xc() {
        return new b.a();
    }

    private static c.b xd() {
        return new c.b();
    }

    private static c.a xe() {
        return new com.kwad.framework.filedownloader.a.a();
    }

    public final int vV() {
        b bVar = this.aiF;
        if (bVar == null) {
            return xb();
        }
        Integer num = bVar.aiH;
        if (num != null) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwad.framework.filedownloader.f.e.bL(num.intValue());
        }
        return xb();
    }

    public final com.kwad.framework.filedownloader.b.a wV() {
        c.InterfaceC0829c interfaceC0829c;
        b bVar = this.aiF;
        if (bVar != null && (interfaceC0829c = bVar.aiG) != null) {
            com.kwad.framework.filedownloader.b.a xq = interfaceC0829c.xq();
            if (xq != null) {
                return xq;
            }
            return new com.kwad.framework.filedownloader.b.c();
        }
        return new com.kwad.framework.filedownloader.b.c();
    }

    public final c.e wW() {
        b bVar = this.aiF;
        if (bVar == null) {
            return xc();
        }
        c.e eVar = bVar.aiI;
        if (eVar != null) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return xc();
    }

    public final c.b wX() {
        c.b vY;
        b bVar = this.aiF;
        if (bVar == null) {
            return xd();
        }
        a aVar = bVar.aiK;
        if (aVar != null && (vY = aVar.vY()) != null) {
            return vY;
        }
        return xd();
    }

    public final c.a wY() {
        b bVar = this.aiF;
        if (bVar == null) {
            return xe();
        }
        c.a aVar = bVar.aiL;
        if (aVar != null) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return xe();
    }

    public final c.d wZ() {
        b bVar = this.aiF;
        if (bVar == null) {
            return xa();
        }
        c.d dVar = bVar.aiM;
        if (dVar != null) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return xa();
    }

    public c(b bVar) {
        this.aiF = bVar;
    }
}
