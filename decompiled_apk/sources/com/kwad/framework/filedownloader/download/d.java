package com.kwad.framework.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes11.dex */
public final class d implements Handler.Callback {
    private final com.kwad.framework.filedownloader.d.c agQ;
    private volatile Thread agl;
    private final int ahA;
    private final int ahB;
    private long ahC;
    private HandlerThread ahD;
    private volatile boolean ahG;
    private final a ahy;
    private final int ahz;
    private Handler handler;
    private volatile boolean ahE = false;
    private volatile long ahk = 0;
    private final AtomicLong ahF = new AtomicLong();
    private boolean ahH = true;
    private final com.kwad.framework.filedownloader.b.a agL = b.vS().vU();

    /* loaded from: classes11.dex */
    public static class a {
        private boolean ahI;
        private Exception ahJ;
        private int ahK;

        public final void be(boolean z) {
            this.ahI = z;
        }

        public final void bu(int i) {
            this.ahK = i;
        }

        public final void f(Exception exc) {
            this.ahJ = exc;
        }

        public final Exception getException() {
            return this.ahJ;
        }

        public final int uD() {
            return this.ahK;
        }

        public final boolean wu() {
            return this.ahI;
        }
    }

    public d(com.kwad.framework.filedownloader.d.c cVar, int i, int i2, int i3) {
        this.agQ = cVar;
        this.ahA = i2 < 5 ? 5 : i2;
        this.ahB = i3;
        this.ahy = new a();
        this.ahz = i;
    }

    private boolean P(long j) {
        if (this.ahH) {
            this.ahH = false;
            return true;
        }
        long j2 = j - this.ahk;
        if (this.ahC != -1 && this.ahF.get() >= this.ahC && j2 >= this.ahA) {
            return true;
        }
        return false;
    }

    private synchronized void b(Message message) {
        if (!this.ahD.isAlive()) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e) {
            if (!this.ahD.isAlive()) {
                if (com.kwad.framework.filedownloader.f.d.ajb) {
                    com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    return;
                }
                return;
            }
            throw e;
        }
    }

    private Exception d(Exception exc) {
        long length;
        String wh = this.agQ.wh();
        if ((this.agQ.isChunked() || com.kwad.framework.filedownloader.f.e.xr().ajh) && (exc instanceof IOException) && new File(wh).exists()) {
            long availableBytes = h.getAvailableBytes(wh);
            if (availableBytes <= 4096) {
                File file = new File(wh);
                if (!file.exists()) {
                    com.kwad.framework.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
                    length = 0;
                } else {
                    length = file.length();
                }
                return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc);
            }
            return exc;
        }
        return exc;
    }

    private void e(Exception exc) {
        Exception exc2;
        Exception d = d(exc);
        if (d instanceof SQLiteFullException) {
            a((SQLiteFullException) d);
            exc2 = d;
        } else {
            try {
                this.agQ.d((byte) -1);
                this.agQ.br(exc.toString());
                this.agL.a(this.agQ.getId(), d, this.agQ.wP());
                exc2 = d;
            } catch (SQLiteFullException e) {
                SQLiteFullException sQLiteFullException = e;
                a(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.ahy.f(exc2);
        c((byte) -1);
    }

    private static long h(long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        if (j == -1) {
            return 1L;
        }
        long j3 = j / (j2 + 1);
        if (j3 <= 0) {
            return 1L;
        }
        return j3;
    }

    private void wq() {
        String wh = this.agQ.wh();
        String targetFilePath = this.agQ.getTargetFilePath();
        File file = new File(wh);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (file2.delete()) {
                    com.kwad.framework.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
                } else {
                    throw new IOException(com.kwad.framework.filedownloader.f.f.b("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
            }
            if (file.renameTo(file2)) {
                if (file.exists() && !file.delete()) {
                    com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", wh);
                    return;
                }
                return;
            }
            throw new IOException(com.kwad.framework.filedownloader.f.f.b("Can't rename the  temp downloaded file(%s) to the target file(%s)", wh, targetFilePath));
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", wh);
            }
            throw th;
        }
    }

    private void wr() {
        wq();
        this.agQ.d((byte) -3);
        this.agL.c(this.agQ.getId(), this.agQ.getTotal());
        this.agL.bm(this.agQ.getId());
        c((byte) -3);
        if (com.kwad.framework.filedownloader.f.e.xr().aji) {
            com.kwad.framework.filedownloader.services.f.f(this.agQ);
        }
    }

    private boolean ws() {
        if (this.agQ.isChunked()) {
            com.kwad.framework.filedownloader.d.c cVar = this.agQ;
            cVar.U(cVar.wP());
        } else if (this.agQ.wP() != this.agQ.getTotal()) {
            c(new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("sofar[%d] not equal total[%d]", Long.valueOf(this.agQ.wP()), Long.valueOf(this.agQ.getTotal()))));
            return true;
        }
        return false;
    }

    private void wt() {
        this.agQ.d((byte) -2);
        this.agL.d(this.agQ.getId(), this.agQ.wP());
        c((byte) -2);
    }

    public final void a(boolean z, long j, String str, String str2) {
        String wQ = this.agQ.wQ();
        if (wQ != null && !wQ.equals(str)) {
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, wQ));
        }
        this.ahy.be(z);
        this.agQ.d((byte) 2);
        this.agQ.U(j);
        this.agQ.bq(str);
        this.agQ.bs(str2);
        this.agL.a(this.agQ.getId(), j, str, str2);
        c((byte) 2);
        this.ahC = h(j, this.ahB);
        this.ahG = true;
    }

    public final void c(Exception exc) {
        e(exc);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            r0 = 1
            r4.ahE = r0
            int r1 = r5.what
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L19
            r2 = 5
            if (r1 == r2) goto Ld
            goto L20
        Ld:
            java.lang.Object r1 = r5.obj     // Catch: java.lang.Throwable -> L17
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L17
            int r5 = r5.arg1     // Catch: java.lang.Throwable -> L17
            r4.a(r1, r5)     // Catch: java.lang.Throwable -> L17
            goto L20
        L17:
            r5 = move-exception
            goto L2c
        L19:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L17
            r4.b(r1, r0)     // Catch: java.lang.Throwable -> L17
        L20:
            r4.ahE = r3
            java.lang.Thread r5 = r4.agl
            if (r5 == 0) goto L2b
            java.lang.Thread r5 = r4.agl
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L2b:
            return r0
        L2c:
            r4.ahE = r3
            java.lang.Thread r0 = r4.agl
            if (r0 == 0) goto L37
            java.lang.Thread r0 = r4.agl
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L37:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.d.handleMessage(android.os.Message):boolean");
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.ahD;
        if (handlerThread != null && handlerThread.isAlive()) {
            return true;
        }
        return false;
    }

    public final void onProgress(long j) {
        this.ahF.addAndGet(j);
        this.agQ.T(j);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean P = P(elapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(elapsedRealtime, P);
        } else if (P) {
            b(handler.obtainMessage(3));
        }
    }

    public final void wk() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.ahD.quit();
            this.agl = Thread.currentThread();
            while (this.ahE) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.agl = null;
        }
    }

    public final void wl() {
        this.agQ.d((byte) 1);
        this.agL.bo(this.agQ.getId());
        c((byte) 1);
    }

    public final void wm() {
        this.agQ.d((byte) 6);
        c((byte) 6);
        this.agL.bj(this.agQ.getId());
    }

    public final void wn() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.ahD = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.ahD.getLooper(), this);
    }

    public final void wo() {
        wt();
    }

    public final void wp() {
        if (ws()) {
            return;
        }
        wr();
    }

    private void c(byte b) {
        if (b == -2) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.agQ.getId()));
                return;
            }
            return;
        }
        com.kwad.framework.filedownloader.message.e.wJ().s(com.kwad.framework.filedownloader.message.f.a(b, this.agQ, this.ahy));
    }

    private void b(long j, boolean z) {
        if (this.agQ.wP() == this.agQ.getTotal()) {
            this.agL.b(this.agQ.getId(), this.agQ.wP());
            return;
        }
        if (this.ahG) {
            this.ahG = false;
            this.agQ.d((byte) 3);
        }
        if (z) {
            this.ahk = j;
            c((byte) 3);
            this.ahF.set(0L);
        }
    }

    public final void a(Exception exc, int i, long j) {
        this.ahF.set(0L);
        this.agQ.T(-j);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i);
        } else {
            b(handler.obtainMessage(5, i, 0, exc));
        }
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id = this.agQ.getId();
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.agQ.br(sQLiteFullException.toString());
        this.agQ.d((byte) -1);
        this.agL.bn(id);
        this.agL.bm(id);
    }

    private void a(Exception exc, int i) {
        Exception d = d(exc);
        this.ahy.f(d);
        this.ahy.bu(this.ahz - i);
        this.agQ.d((byte) 5);
        this.agQ.br(d.toString());
        this.agL.a(this.agQ.getId(), d);
        c((byte) 5);
    }
}
