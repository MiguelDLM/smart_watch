package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;

/* loaded from: classes11.dex */
public final class b {
    private com.kwad.framework.filedownloader.services.c agH;
    private c.a agI;
    private c.b agJ;
    private c.e agK;
    private volatile com.kwad.framework.filedownloader.b.a agL;
    private c.d agM;

    /* loaded from: classes11.dex */
    public static final class a {
        private static final b agN = new b();
    }

    public static b vS() {
        return a.agN;
    }

    private c.a vX() {
        c.a aVar = this.agI;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            try {
                if (this.agI == null) {
                    this.agI = wa().wY();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.agI;
    }

    private c.b vY() {
        c.b bVar = this.agJ;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            try {
                if (this.agJ == null) {
                    this.agJ = wa().wX();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.agJ;
    }

    private c.e vZ() {
        c.e eVar = this.agK;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            try {
                if (this.agK == null) {
                    this.agK = wa().wW();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.agK;
    }

    private com.kwad.framework.filedownloader.services.c wa() {
        com.kwad.framework.filedownloader.services.c cVar = this.agH;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            try {
                if (this.agH == null) {
                    this.agH = new com.kwad.framework.filedownloader.services.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.agH;
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.agH = new com.kwad.framework.filedownloader.services.c(bVar);
            this.agJ = null;
            this.agK = null;
            this.agL = null;
            this.agM = null;
        }
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.agH = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }

    public final com.kwad.framework.filedownloader.a.b bk(String str) {
        try {
            return vY().bh(str);
        } catch (Throwable unused) {
            c.b bVar = new c.b();
            this.agJ = bVar;
            return bVar.bh(str);
        }
    }

    public final c.d vT() {
        c.d dVar = this.agM;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            try {
                if (this.agM == null) {
                    this.agM = wa().wZ();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.agM;
    }

    public final synchronized com.kwad.framework.filedownloader.b.a vU() {
        if (this.agL != null) {
            return this.agL;
        }
        this.agL = wa().wV();
        a(this.agL.vJ());
        return this.agL;
    }

    public final int vV() {
        return wa().vV();
    }

    public final boolean vW() {
        vZ();
        return true;
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return vZ().c(file);
    }

    public final int a(int i, String str, String str2, long j) {
        return vX().O(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x001f, B:5:0x0025, B:7:0x0034, B:9:0x003a, B:11:0x0041, B:13:0x0047, B:16:0x0058, B:19:0x00dd, B:22:0x0064, B:24:0x006f, B:26:0x007e, B:28:0x008d, B:30:0x0093, B:32:0x009b, B:33:0x00b8, B:35:0x00bf, B:38:0x00cc, B:41:0x00d7, B:43:0x00e6, B:45:0x00fc, B:47:0x0100, B:48:0x011b, B:49:0x0126, B:55:0x0055), top: B:2:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(com.kwad.framework.filedownloader.b.a.InterfaceC0824a r27) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.b.a(com.kwad.framework.filedownloader.b.a$a):void");
    }
}
