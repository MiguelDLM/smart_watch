package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes11.dex */
final class q {
    private final b afL = new b();

    /* loaded from: classes11.dex */
    public static class a {
        private static final q afM = new q();

        static {
            com.kwad.framework.filedownloader.message.e.wJ().a(new aa());
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        private ThreadPoolExecutor afN;
        private LinkedBlockingQueue<Runnable> afO;

        public b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.afO = linkedBlockingQueue;
            this.afN = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.afO.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.afN.execute(new c(bVar));
        }
    }

    /* loaded from: classes11.dex */
    public static class c implements Runnable {
        private final x.b afP;
        private boolean afQ = false;

        public c(x.b bVar) {
            this.afP = bVar;
        }

        public final boolean equals(Object obj) {
            if (!super.equals(obj) && obj != this.afP) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.afQ) {
                return;
            }
            this.afP.start();
        }
    }

    public static q vw() {
        return a.afM;
    }

    public final synchronized void a(x.b bVar) {
        this.afL.c(bVar);
    }

    public final synchronized void b(x.b bVar) {
        this.afL.b(bVar);
    }
}
