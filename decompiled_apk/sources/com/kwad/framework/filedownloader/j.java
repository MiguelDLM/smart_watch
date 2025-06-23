package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes11.dex */
public final class j {
    static int afw = 10;
    static int afx = 5;
    private final Executor afs;
    private final LinkedBlockingQueue<t> aft;
    private final Object afu;
    private final ArrayList<t> afv;
    private final Handler handler;

    /* loaded from: classes11.dex */
    public static final class a {
        private static final j afA = new j(0);
    }

    /* loaded from: classes11.dex */
    public static class b implements Handler.Callback {
        private b() {
        }

        private static void a(ArrayList<t> arrayList) {
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null) {
                    next.vl();
                }
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((t) message.obj).vl();
            } else if (i == 2) {
                a((ArrayList) message.obj);
                j.vh().push();
            }
            return true;
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public /* synthetic */ j(byte b2) {
        this();
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.afu) {
            this.aft.offer(tVar);
        }
        push();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        synchronized (this.afu) {
            try {
                if (!this.afv.isEmpty()) {
                    return;
                }
                if (this.aft.isEmpty()) {
                    return;
                }
                int i = 0;
                if (!vi()) {
                    this.aft.drainTo(this.afv);
                } else {
                    int i2 = afw;
                    int min = Math.min(this.aft.size(), afx);
                    while (i < min) {
                        this.afv.add(this.aft.remove());
                        i++;
                    }
                    i = i2;
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.afv), i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static j vh() {
        return a.afA;
    }

    private static boolean vi() {
        if (afw > 0) {
            return true;
        }
        return false;
    }

    private j() {
        this.afs = com.kwad.framework.filedownloader.f.b.q(5, "BlockCompleted");
        this.afu = new Object();
        this.afv = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.aft = new LinkedBlockingQueue<>();
    }

    public final void a(t tVar) {
        a(tVar, false);
    }

    private void a(final t tVar, boolean z) {
        if (tVar.vm()) {
            tVar.vl();
            return;
        }
        if (tVar.vn()) {
            this.afs.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.vl();
                }
            });
            return;
        }
        if (!vi() && !this.aft.isEmpty()) {
            synchronized (this.afu) {
                try {
                    if (!this.aft.isEmpty()) {
                        Iterator<t> it = this.aft.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.aft.clear();
                } finally {
                }
            }
        }
        if (!vi()) {
            b(tVar);
        } else {
            c(tVar);
        }
    }
}
