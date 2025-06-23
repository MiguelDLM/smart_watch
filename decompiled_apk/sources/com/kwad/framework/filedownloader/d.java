package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.s;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class d implements a.c, x, x.a, x.b {
    private final Object aeW;
    private t afa;
    private final a afb;
    private volatile long afd;
    private final s.b aff;
    private final s.a afg;
    private long afh;
    private long afi;
    private int afj;
    private boolean afk;
    private boolean afl;
    private String afm;
    private volatile byte afc = 0;
    private Throwable afe = null;
    private boolean afn = false;

    /* loaded from: classes11.dex */
    public interface a {
        void be(String str);

        com.kwad.framework.filedownloader.d.b uU();

        a.InterfaceC0823a uV();

        ArrayList<Object> uW();
    }

    public d(a aVar, Object obj) {
        this.aeW = obj;
        this.afb = aVar;
        b bVar = new b();
        this.aff = bVar;
        this.afg = bVar;
        this.afa = new k(aVar.uV(), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(MessageSnapshot messageSnapshot) {
        int i;
        com.kwad.framework.filedownloader.a uH = this.afb.uV().uH();
        byte uz = messageSnapshot.uz();
        b(uz);
        this.afk = messageSnapshot.uF();
        if (uz != -4) {
            if (uz != -3) {
                if (uz != -1) {
                    if (uz != 1) {
                        if (uz != 2) {
                            if (uz != 3) {
                                if (uz != 5) {
                                    if (uz == 6) {
                                        this.afa.g(messageSnapshot);
                                        return;
                                    }
                                    return;
                                } else {
                                    this.afh = messageSnapshot.wG();
                                    this.afe = messageSnapshot.wH();
                                    this.afj = messageSnapshot.uD();
                                    this.aff.reset();
                                    this.afa.k(messageSnapshot);
                                    return;
                                }
                            }
                            this.afh = messageSnapshot.wG();
                            this.aff.N(messageSnapshot.wG());
                            this.afa.i(messageSnapshot);
                            return;
                        }
                        this.afi = messageSnapshot.wE();
                        this.afl = messageSnapshot.wu();
                        this.afm = messageSnapshot.getEtag();
                        String fileName = messageSnapshot.getFileName();
                        if (fileName != null) {
                            if (uH.getFilename() != null) {
                                com.kwad.framework.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", uH.getFilename(), fileName);
                            }
                            this.afb.be(fileName);
                        }
                        this.aff.start(this.afh);
                        this.afa.h(messageSnapshot);
                        return;
                    }
                    this.afh = messageSnapshot.wG();
                    this.afi = messageSnapshot.wE();
                    this.afa.f(messageSnapshot);
                    return;
                }
                this.afe = messageSnapshot.wH();
                this.afh = messageSnapshot.wG();
                h.vf().a(this.afb.uV(), messageSnapshot);
                return;
            }
            this.afn = messageSnapshot.wF();
            this.afh = messageSnapshot.wE();
            this.afi = messageSnapshot.wE();
            h.vf().a(this.afb.uV(), messageSnapshot);
            return;
        }
        this.aff.reset();
        int aZ = h.vf().aZ(uH.getId());
        if (aZ <= 1 && uH.uv()) {
            i = h.vf().aZ(com.kwad.framework.filedownloader.f.f.A(uH.getUrl(), uH.getTargetFilePath()));
        } else {
            i = 0;
        }
        if (aZ + i <= 1) {
            byte be = n.vq().be(uH.getId());
            com.kwad.framework.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(uH.getId()), Integer.valueOf(be));
            if (com.kwad.framework.filedownloader.d.d.bG(be)) {
                b((byte) 1);
                this.afi = messageSnapshot.wE();
                long wG = messageSnapshot.wG();
                this.afh = wG;
                this.aff.start(wG);
                this.afa.f(((MessageSnapshot.a) messageSnapshot).wI());
                return;
            }
        }
        h.vf().a(this.afb.uV(), messageSnapshot);
    }

    private int getId() {
        return this.afb.uV().uH().getId();
    }

    private void prepare() {
        File file;
        com.kwad.framework.filedownloader.a uH = this.afb.uV().uH();
        if (uH.getPath() == null) {
            uH.bc(com.kwad.framework.filedownloader.f.f.bu(uH.getUrl()));
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "save Path is null to %s", uH.getPath());
            }
        }
        if (uH.uv()) {
            file = new File(uH.getPath());
        } else {
            String bz = com.kwad.framework.filedownloader.f.f.bz(uH.getPath());
            if (bz != null) {
                file = new File(bz);
            } else {
                throw new InvalidParameterException(com.kwad.framework.filedownloader.f.f.b("the provided mPath[%s] is invalid, can't find its directory", uH.getPath()));
            }
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwad.framework.filedownloader.f.f.b("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.t(uz(), messageSnapshot.uz())) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.afc), Byte.valueOf(uz()), Integer.valueOf(getId()));
            }
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        byte uz = uz();
        byte uz2 = messageSnapshot.uz();
        if (-2 == uz && com.kwad.framework.filedownloader.d.d.bG(uz2)) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
            }
            return true;
        }
        if (!com.kwad.framework.filedownloader.d.d.u(uz, uz2)) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.afc), Byte.valueOf(uz()), Integer.valueOf(getId()));
            }
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.f(this.afb.uV().uH())) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        if (!this.afb.uV().uH().uv() || messageSnapshot.uz() != -4 || uz() != 2) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void free() {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.afc));
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final MessageSnapshot g(Throwable th) {
        b((byte) -1);
        this.afe = th;
        return com.kwad.framework.filedownloader.message.f.a(getId(), uZ(), th);
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.afg.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getStatusUpdateTime() {
        return this.afd;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getTotalBytes() {
        return this.afi;
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void onBegin() {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(uz()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean pause() {
        if (com.kwad.framework.filedownloader.d.d.bF(uz())) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(uz()), Integer.valueOf(this.afb.uV().uH().getId()));
            }
            return false;
        }
        b((byte) -2);
        a.InterfaceC0823a uV = this.afb.uV();
        com.kwad.framework.filedownloader.a uH = uV.uH();
        q.vw().b(this);
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        r.vy();
        if (!r.vA()) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(uH.getId()));
            }
        } else {
            n.vq().bd(uH.getId());
        }
        h.vf().b(uV);
        h.vf().a(uV, com.kwad.framework.filedownloader.message.f.e(uH));
        r.vy().vC().e(uV);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void reset() {
        this.afe = null;
        this.afm = null;
        this.afl = false;
        this.afj = 0;
        this.afn = false;
        this.afk = false;
        this.afh = 0L;
        this.afi = 0L;
        this.aff.reset();
        if (com.kwad.framework.filedownloader.d.d.bF(this.afc)) {
            this.afa.vo();
            this.afa = new k(this.afb.uV(), this);
        } else {
            this.afa.b(this.afb.uV(), this);
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.x.b
    public final void start() {
        if (this.afc != 10) {
            com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.afc));
            return;
        }
        a.InterfaceC0823a uV = this.afb.uV();
        com.kwad.framework.filedownloader.a uH = uV.uH();
        v vC = r.vy().vC();
        try {
            if (vC.f(uV)) {
                return;
            }
            synchronized (this.aeW) {
                try {
                    if (this.afc != 10) {
                        com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.afc));
                        return;
                    }
                    b((byte) 11);
                    h.vf().b(uV);
                    if (com.kwad.framework.filedownloader.f.c.a(uH.getId(), uH.getTargetFilePath(), uH.uA(), true)) {
                        return;
                    }
                    boolean a2 = n.vq().a(uH.getUrl(), uH.getPath(), uH.uv(), uH.ut(), uH.uu(), uH.uC(), uH.uA(), this.afb.uU(), uH.uG());
                    if (this.afc == -2) {
                        com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                        if (a2) {
                            n.vq().bd(getId());
                            return;
                        }
                        return;
                    }
                    if (!a2) {
                        if (!vC.f(uV)) {
                            MessageSnapshot g = g(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                            if (h.vf().a(uV)) {
                                vC.e(uV);
                                h.vf().b(uV);
                            }
                            h.vf().a(uV, g);
                            return;
                        }
                        return;
                    }
                    vC.e(uV);
                } finally {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.vf().a(uV, g(th));
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final Throwable uB() {
        return this.afe;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final int uD() {
        return this.afj;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean uF() {
        return this.afk;
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void uQ() {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(uz()));
        }
        this.aff.end(this.afh);
        if (this.afb.uW() != null) {
            ArrayList arrayList = (ArrayList) this.afb.uW().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
            }
        }
        r.vy().vC().e(this.afb.uV());
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final t uX() {
        return this.afa;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void uY() {
        synchronized (this.aeW) {
            try {
                if (this.afc != 0) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.afc));
                    return;
                }
                b((byte) 10);
                a.InterfaceC0823a uV = this.afb.uV();
                com.kwad.framework.filedownloader.a uH = uV.uH();
                if (com.kwad.framework.filedownloader.f.d.ajb) {
                    com.kwad.framework.filedownloader.f.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", uH.getUrl(), uH.getPath(), uH.uw(), uH.getTag());
                }
                try {
                    prepare();
                    q.vw().a(this);
                } catch (Throwable th) {
                    h.vf().b(uV);
                    h.vf().a(uV, g(th));
                }
                if (com.kwad.framework.filedownloader.f.d.ajb) {
                    com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long uZ() {
        return this.afh;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final byte uz() {
        return this.afc;
    }

    private void b(byte b) {
        this.afc = b;
        this.afd = System.currentTimeMillis();
    }
}
