package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0823a> afW = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC0823a interfaceC0823a) {
        if (!this.afW.isEmpty() && this.afW.contains(interfaceC0823a)) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC0823a interfaceC0823a) {
        if (!this.afW.isEmpty()) {
            synchronized (this.afW) {
                this.afW.remove(interfaceC0823a);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC0823a interfaceC0823a) {
        r.vy();
        if (!r.vA()) {
            synchronized (this.afW) {
                try {
                    r.vy();
                    if (!r.vA()) {
                        if (com.kwad.framework.filedownloader.f.d.ajb) {
                            com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0823a.uH().getId()));
                        }
                        n.vq().av(com.kwad.framework.filedownloader.f.c.xp());
                        if (!this.afW.contains(interfaceC0823a)) {
                            interfaceC0823a.free();
                            this.afW.add(interfaceC0823a);
                        }
                        return true;
                    }
                } finally {
                }
            }
        }
        e(interfaceC0823a);
        return false;
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void va() {
        w vB = r.vy().vB();
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.afW) {
            try {
                List<a.InterfaceC0823a> list = (List) this.afW.clone();
                this.afW.clear();
                ArrayList arrayList = new ArrayList(vB.vF());
                for (a.InterfaceC0823a interfaceC0823a : list) {
                    int uJ = interfaceC0823a.uJ();
                    if (vB.bh(uJ)) {
                        interfaceC0823a.uH().uq().uP();
                        if (!arrayList.contains(Integer.valueOf(uJ))) {
                            arrayList.add(Integer.valueOf(uJ));
                        }
                    } else {
                        interfaceC0823a.uN();
                    }
                }
                vB.p(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void vb() {
        if (vc() == DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            w vB = r.vy().vB();
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.vf().size()));
            }
            if (h.vf().size() > 0) {
                synchronized (this.afW) {
                    try {
                        h.vf().o(this.afW);
                        Iterator<a.InterfaceC0823a> it = this.afW.iterator();
                        while (it.hasNext()) {
                            it.next().free();
                        }
                        vB.vE();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                r.vy().vz();
                return;
            }
            return;
        }
        if (h.vf().size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.vf().size()));
        }
    }
}
