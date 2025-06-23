package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import com.kwad.framework.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class g implements y {
    private final h aiQ = new h(com.kwad.framework.filedownloader.download.b.vS().vV());

    private boolean bI(int i) {
        return a(xh().bk(i));
    }

    private static com.kwad.framework.filedownloader.b.a xh() {
        return com.kwad.framework.filedownloader.download.b.vS().vU();
    }

    @Override // com.kwad.framework.filedownloader.y
    public final boolean a(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean bK = this.aiQ.bK(cVar.getId());
        if (com.kwad.framework.filedownloader.d.d.bF(cVar.uz())) {
            if (bK) {
                return true;
            }
        } else {
            if (bK) {
                return true;
            }
            com.kwad.framework.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.uz()));
        }
        return false;
    }

    public final synchronized void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        com.kwad.framework.filedownloader.d.c cVar;
        List<com.kwad.framework.filedownloader.d.a> list;
        String a2;
        String bw;
        boolean z4 = true;
        synchronized (this) {
            try {
                if (com.kwad.framework.filedownloader.f.d.ajb) {
                    com.kwad.framework.filedownloader.f.d.c(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
                }
                int g = com.kwad.framework.filedownloader.f.f.g(str, str2, z);
                com.kwad.framework.filedownloader.b.a xh = xh();
                com.kwad.framework.filedownloader.d.c bk = xh.bk(g);
                if (z || bk != null) {
                    cVar = bk;
                    list = null;
                } else {
                    int g2 = com.kwad.framework.filedownloader.f.f.g(str, com.kwad.framework.filedownloader.f.f.bz(str2), true);
                    com.kwad.framework.filedownloader.d.c bk2 = xh.bk(g2);
                    if (bk2 == null || !str2.equals(bk2.getTargetFilePath())) {
                        list = null;
                    } else {
                        if (com.kwad.framework.filedownloader.f.d.ajb) {
                            com.kwad.framework.filedownloader.f.d.c(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(g), Integer.valueOf(g2));
                        }
                        list = xh.bl(g2);
                    }
                    cVar = bk2;
                }
                if (com.kwad.framework.filedownloader.f.c.a(g, cVar, (y) this, true)) {
                    if (com.kwad.framework.filedownloader.f.d.ajb) {
                        com.kwad.framework.filedownloader.f.d.c(this, "has already started download %d", Integer.valueOf(g));
                    }
                    return;
                }
                if (cVar != null) {
                    a2 = cVar.getTargetFilePath();
                } else {
                    a2 = com.kwad.framework.filedownloader.f.f.a(str2, z, (String) null);
                }
                String str3 = a2;
                if (com.kwad.framework.filedownloader.f.c.a(g, str3, z2, true)) {
                    if (com.kwad.framework.filedownloader.f.d.ajb) {
                        com.kwad.framework.filedownloader.f.d.c(this, "has already completed downloading %d", Integer.valueOf(g));
                    }
                    return;
                }
                long wP = cVar != null ? cVar.wP() : 0L;
                if (cVar != null) {
                    bw = cVar.wh();
                } else {
                    bw = com.kwad.framework.filedownloader.f.f.bw(str3);
                }
                if (com.kwad.framework.filedownloader.f.c.a(g, wP, bw, str3, this)) {
                    if (com.kwad.framework.filedownloader.f.d.ajb) {
                        com.kwad.framework.filedownloader.f.d.c(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(g), str3);
                        if (cVar != null) {
                            xh.bn(g);
                            xh.bm(g);
                        }
                    }
                    return;
                }
                if (cVar != null && (cVar.uz() == -2 || cVar.uz() == -1 || cVar.uz() == 1 || cVar.uz() == 6 || cVar.uz() == 2)) {
                    if (cVar.getId() != g) {
                        xh.bn(cVar.getId());
                        xh.bm(cVar.getId());
                        cVar.setId(g);
                        cVar.d(str2, z);
                        if (list != null) {
                            for (com.kwad.framework.filedownloader.d.a aVar : list) {
                                aVar.setId(g);
                                xh.a(aVar);
                            }
                        }
                    } else if (TextUtils.equals(str, cVar.getUrl())) {
                        z4 = false;
                    } else {
                        cVar.setUrl(str);
                    }
                } else {
                    if (cVar == null) {
                        cVar = new com.kwad.framework.filedownloader.d.c();
                    }
                    cVar.setUrl(str);
                    cVar.d(str2, z);
                    cVar.setId(g);
                    cVar.S(0L);
                    cVar.U(0L);
                    cVar.d((byte) 1);
                    cVar.bD(1);
                }
                if (z4) {
                    xh.b(cVar);
                }
                this.aiQ.a(new DownloadLaunchRunnable.a().e(cVar).b(bVar).a(this).a(Integer.valueOf(i2)).b(Integer.valueOf(i)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).c(Integer.valueOf(i3)).wi());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final long bJ(int i) {
        com.kwad.framework.filedownloader.b.a xh = xh();
        com.kwad.framework.filedownloader.d.c bk = xh.bk(i);
        if (bk == null) {
            return 0L;
        }
        int wS = bk.wS();
        if (wS <= 1) {
            return bk.wP();
        }
        List<com.kwad.framework.filedownloader.d.a> bl = xh.bl(i);
        if (bl == null || bl.size() != wS) {
            return 0L;
        }
        return com.kwad.framework.filedownloader.d.a.r(bl);
    }

    public final boolean bd(int i) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i));
        }
        com.kwad.framework.filedownloader.d.c bk = xh().bk(i);
        if (bk == null) {
            return false;
        }
        bk.d((byte) -2);
        this.aiQ.cancel(i);
        return true;
    }

    public final byte be(int i) {
        com.kwad.framework.filedownloader.d.c bk = xh().bk(i);
        if (bk == null) {
            return (byte) 0;
        }
        return bk.uz();
    }

    public final boolean bf(int i) {
        if (i == 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        }
        if (bI(i)) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        }
        com.kwad.framework.filedownloader.b.a xh = xh();
        xh.bn(i);
        xh.bm(i);
        return true;
    }

    public final synchronized boolean bx(int i) {
        return this.aiQ.bx(i);
    }

    public final long bz(int i) {
        com.kwad.framework.filedownloader.d.c bk = xh().bk(i);
        if (bk == null) {
            return 0L;
        }
        return bk.getTotal();
    }

    public final boolean isIdle() {
        if (this.aiQ.xk() <= 0) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.y
    public final int o(String str, int i) {
        return this.aiQ.o(str, i);
    }

    public final void wz() {
        xh().clear();
    }

    public final void xi() {
        List<Integer> xl = this.aiQ.xl();
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(xl.size()));
        }
        Iterator<Integer> it = xl.iterator();
        while (it.hasNext()) {
            bd(it.next().intValue());
        }
    }

    public final boolean y(String str, String str2) {
        return bI(com.kwad.framework.filedownloader.f.f.A(str, str2));
    }
}
