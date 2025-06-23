package com.kwad.framework.filedownloader;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.d;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class c implements com.kwad.framework.filedownloader.a, a.InterfaceC0823a, d.a {
    private final x aeE;
    private final x.a aeF;
    private int aeG;
    private ArrayList<Object> aeH;
    private String aeI;
    private String aeJ;
    private boolean aeK;
    private com.kwad.framework.filedownloader.d.b aeL;
    private i aeM;
    private Object aeN;
    private final Object aeW;
    private final String mUrl;
    private int aeO = 0;
    private boolean aeP = false;
    private boolean aeQ = false;
    private int aeR = 100;
    private int aeS = 10;
    private boolean aeT = false;
    volatile int aeU = 0;
    private boolean aeV = false;
    private final Object aeX = new Object();
    private volatile boolean aeY = false;

    /* loaded from: classes11.dex */
    public static final class a implements a.b {
        private final c aeZ;

        public /* synthetic */ a(c cVar, byte b) {
            this(cVar);
        }

        @Override // com.kwad.framework.filedownloader.a.b
        public final int uP() {
            int id = this.aeZ.getId();
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            h.vf().c(this.aeZ);
            return id;
        }

        private a(c cVar) {
            this.aeZ = cVar;
            c.a(cVar, true);
        }
    }

    public c(String str) {
        this.mUrl = str;
        Object obj = new Object();
        this.aeW = obj;
        d dVar = new d(this, obj);
        this.aeE = dVar;
        this.aeF = dVar;
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.aeV = true;
        return true;
    }

    private boolean uR() {
        if (this.aeE.uz() != 0) {
            return true;
        }
        return false;
    }

    private int uS() {
        if (uR()) {
            if (isRunning()) {
                throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
            }
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.aeE.toString());
        }
        if (!us()) {
            uK();
        }
        this.aeE.uY();
        return getId();
    }

    private void uT() {
        if (this.aeL == null) {
            synchronized (this.aeX) {
                try {
                    if (this.aeL == null) {
                        this.aeL = new com.kwad.framework.filedownloader.d.b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a aX(int i) {
        this.aeO = 3;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final boolean aY(int i) {
        if (getId() == i) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a ba(boolean z) {
        this.aeT = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bb(boolean z) {
        this.aeP = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bc(String str) {
        return c(str, false);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bd(String str) {
        if (this.aeL == null) {
            synchronized (this.aeX) {
                try {
                    if (this.aeL == null) {
                        return this;
                    }
                } finally {
                }
            }
        }
        this.aeL.bp(str);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final void be(String str) {
        this.aeJ = str;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a c(String str, boolean z) {
        this.aeI = str;
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "setPath %s", str);
        }
        this.aeK = z;
        if (z) {
            this.aeJ = null;
        } else {
            this.aeJ = new File(str).getName();
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean cancel() {
        return pause();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a e(Object obj) {
        this.aeN = obj;
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final void free() {
        this.aeE.free();
        if (h.vf().a(this)) {
            this.aeY = false;
        }
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getFilename() {
        return this.aeJ;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getId() {
        int i = this.aeG;
        if (i != 0) {
            return i;
        }
        if (!TextUtils.isEmpty(this.aeI) && !TextUtils.isEmpty(this.mUrl)) {
            int g = com.kwad.framework.filedownloader.f.f.g(this.mUrl, this.aeI, this.aeK);
            this.aeG = g;
            return g;
        }
        return 0;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getPath() {
        return this.aeI;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileSoFarBytes() {
        if (this.aeE.uZ() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.aeE.uZ();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileTotalBytes() {
        if (this.aeE.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.aeE.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSpeed() {
        return this.aeE.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long getStatusUpdateTime() {
        return this.aeE.getStatusUpdateTime();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Object getTag() {
        return this.aeN;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getTargetFilePath() {
        return com.kwad.framework.filedownloader.f.f.a(getPath(), uv(), getFilename());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getUrl() {
        return this.mUrl;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final boolean isOver() {
        return com.kwad.framework.filedownloader.d.d.bF(uz());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean isRunning() {
        if (r.vy().vC().d(this)) {
            return true;
        }
        return com.kwad.framework.filedownloader.d.d.bG(uz());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean pause() {
        boolean pause;
        synchronized (this.aeW) {
            pause = this.aeE.pause();
        }
        return pause;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int start() {
        if (!this.aeV) {
            return uS();
        }
        throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a t(String str, String str2) {
        uT();
        this.aeL.x(str, str2);
        return this;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.b("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean uA() {
        return this.aeT;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Throwable uB() {
        return this.aeE.uB();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int uC() {
        return this.aeO;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int uD() {
        return this.aeE.uD();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean uE() {
        return this.aeP;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean uF() {
        return this.aeE.uF();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean uG() {
        return this.aeQ;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final com.kwad.framework.filedownloader.a uH() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final x.a uI() {
        return this.aeF;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final int uJ() {
        return this.aeU;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final void uK() {
        int hashCode;
        if (uw() != null) {
            hashCode = uw().hashCode();
        } else {
            hashCode = hashCode();
        }
        this.aeU = hashCode;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final boolean uL() {
        return this.aeY;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final void uM() {
        this.aeY = true;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final void uN() {
        uS();
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0823a
    public final boolean uO() {
        ArrayList<Object> arrayList = this.aeH;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final com.kwad.framework.filedownloader.d.b uU() {
        return this.aeL;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final a.InterfaceC0823a uV() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final ArrayList<Object> uW() {
        return this.aeH;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final a.b uq() {
        return new a(this, (byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean ur() {
        if (isRunning()) {
            com.kwad.framework.filedownloader.f.d.d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.aeU = 0;
        this.aeV = false;
        this.aeY = false;
        this.aeE.reset();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean us() {
        if (this.aeU != 0) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int ut() {
        return this.aeR;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int uu() {
        return this.aeS;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean uv() {
        return this.aeK;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final i uw() {
        return this.aeM;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long ux() {
        return this.aeE.uZ();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long uy() {
        return this.aeE.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final byte uz() {
        return this.aeE.uz();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a a(i iVar) {
        this.aeM = iVar;
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "setListener %s", iVar);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bc(boolean z) {
        this.aeQ = z;
        return this;
    }
}
