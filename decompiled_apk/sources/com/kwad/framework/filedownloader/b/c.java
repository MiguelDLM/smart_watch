package com.kwad.framework.filedownloader.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes11.dex */
public final class c implements a {
    private volatile Thread agl;
    private Handler handler;
    private volatile List<Integer> agj = new CopyOnWriteArrayList();
    private AtomicInteger agk = new AtomicInteger();
    private final b agg = new b();
    private final d agh = new d();
    private final long agi = com.kwad.framework.filedownloader.f.e.xr().ajd;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.bA("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwad.framework.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (c.this.agl != null) {
                        LockSupport.unpark(c.this.agl);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.agk.set(i);
                    c.this.bp(i);
                    c.this.agj.add(Integer.valueOf(i));
                    return false;
                } finally {
                    c.this.agk.set(0);
                    if (c.this.agl != null) {
                        LockSupport.unpark(c.this.agl);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i) {
        this.agh.b(this.agg.bk(i));
        List<com.kwad.framework.filedownloader.d.a> bl = this.agg.bl(i);
        this.agh.bm(i);
        Iterator<com.kwad.framework.filedownloader.d.a> it = bl.iterator();
        while (it.hasNext()) {
            this.agh.a(it.next());
        }
    }

    private boolean bq(int i) {
        if (!this.agj.contains(Integer.valueOf(i))) {
            return true;
        }
        return false;
    }

    private void br(int i) {
        this.handler.removeMessages(i);
        if (this.agk.get() == i) {
            this.agl = Thread.currentThread();
            this.handler.sendEmptyMessage(0);
            LockSupport.park();
            return;
        }
        bp(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i) {
        this.handler.sendEmptyMessageDelayed(i, this.agi);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bk(int i) {
        return this.agg.bk(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bl(int i) {
        return this.agg.bl(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bm(int i) {
        this.agg.bm(i);
        if (bq(i)) {
            return;
        }
        this.agh.bm(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bn(int i) {
        this.agh.bn(i);
        return this.agg.bn(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bo(int i) {
        this.agg.bo(i);
        if (bq(i)) {
            return;
        }
        this.agh.bo(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        this.agg.clear();
        this.agh.clear();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
        this.agg.d(i, j);
        if (bq(i)) {
            br(i);
        }
        this.agh.d(i, j);
        this.agj.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i, int i2) {
        this.agg.s(i, i2);
        if (bq(i)) {
            return;
        }
        this.agh.s(i, i2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0824a vJ() {
        d dVar = this.agh;
        b bVar = this.agg;
        return dVar.a(bVar.agd, bVar.age);
    }

    public static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.agl = null;
        return null;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i, long j) {
        this.agg.b(i, j);
        if (bq(i)) {
            return;
        }
        this.agh.b(i, j);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        this.agg.c(i, j);
        if (bq(i)) {
            this.handler.removeMessages(i);
            if (this.agk.get() == i) {
                this.agl = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.agj.remove(Integer.valueOf(i));
        }
        this.agh.c(i, j);
        this.agj.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        this.agg.a(aVar);
        if (bq(aVar.getId())) {
            return;
        }
        this.agh.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        this.agg.b(cVar);
        if (bq(cVar.getId())) {
            return;
        }
        this.agh.b(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        this.agg.a(i, i2, j);
        if (bq(i)) {
            return;
        }
        this.agh.a(i, i2, j);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
        this.agg.a(i, str, j, j2, i2);
        if (bq(i)) {
            return;
        }
        this.agh.a(i, str, j, j2, i2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
        this.agg.a(i, j, str, str2);
        if (bq(i)) {
            return;
        }
        this.agh.a(i, j, str, str2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
        this.agg.a(i, th);
        if (bq(i)) {
            return;
        }
        this.agh.a(i, th);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
        this.agg.a(i, th, j);
        if (bq(i)) {
            br(i);
        }
        this.agh.a(i, th, j);
        this.agj.remove(Integer.valueOf(i));
    }
}
