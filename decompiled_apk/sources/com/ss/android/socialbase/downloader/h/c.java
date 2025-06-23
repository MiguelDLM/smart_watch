package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.k;
import com.ss.android.socialbase.downloader.f.n;
import com.ss.android.socialbase.downloader.impls.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.b;
import com.ss.android.socialbase.downloader.network.i;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class c implements f, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f26303a = "c";
    private r A;
    private String E;
    private long G;
    private long H;
    private final com.ss.android.socialbase.downloader.g.a I;
    private Future b;
    private final DownloadTask c;
    private AtomicInteger e;
    private volatile com.ss.android.socialbase.downloader.downloader.e g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final AtomicBoolean m;
    private final j o;
    private DownloadInfo p;
    private com.ss.android.socialbase.downloader.downloader.h q;
    private final com.ss.android.socialbase.downloader.downloader.h r;
    private com.ss.android.socialbase.downloader.downloader.g s;
    private final com.ss.android.socialbase.downloader.downloader.g t;
    private s u;
    private final com.ss.android.socialbase.downloader.downloader.f v;
    private volatile BaseException w;
    private i x;
    private com.ss.android.socialbase.downloader.network.g y;
    private w z;
    private volatile boolean d = false;
    private final ArrayList<b> f = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.constants.h n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
    private volatile int B = 5;
    private boolean C = false;
    private boolean D = false;
    private boolean F = false;
    private int J = 0;
    private volatile k K = null;

    public c(DownloadTask downloadTask, Handler handler) {
        this.c = downloadTask;
        if (downloadTask != null) {
            this.p = downloadTask.getDownloadInfo();
            this.q = downloadTask.getChunkStrategy();
            this.s = downloadTask.getChunkAdjustCalculator();
            this.z = downloadTask.getForbiddenHandler();
            this.A = downloadTask.getDiskSpaceHandler();
            this.u = a(downloadTask);
            this.I = com.ss.android.socialbase.downloader.g.a.a(this.p.getId());
        } else {
            this.I = com.ss.android.socialbase.downloader.g.a.c();
        }
        h();
        this.o = com.ss.android.socialbase.downloader.downloader.c.y();
        this.r = com.ss.android.socialbase.downloader.downloader.c.J();
        this.t = com.ss.android.socialbase.downloader.downloader.c.L();
        this.v = new com.ss.android.socialbase.downloader.downloader.f(downloadTask, handler);
        this.m = new AtomicBoolean(true);
    }

    private long A() {
        return this.u.a(this.p.getCurRetryTimeInTotal(), this.p.getTotalRetryCount());
    }

    private void B() throws com.ss.android.socialbase.downloader.exception.i, BaseException {
        com.ss.android.socialbase.downloader.impls.a D;
        int id = this.p.getId();
        int a2 = com.ss.android.socialbase.downloader.downloader.c.a(this.p);
        if (this.p.isDownloaded() && !this.p.isExpiredRedownload() && !this.F) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo b = this.o.b(a2);
        if (b != null && (D = com.ss.android.socialbase.downloader.downloader.c.D()) != null && b.getId() != id && b.equalsTask(this.p)) {
            if (!D.a(b.getId())) {
                List<com.ss.android.socialbase.downloader.model.b> c = this.o.c(a2);
                com.ss.android.socialbase.downloader.i.f.a(this.p);
                this.o.f(a2);
                if (b.isBreakpointAvailable()) {
                    this.p.copyFromCacheData(b, false);
                    this.o.a(this.p);
                    if (c != null) {
                        for (com.ss.android.socialbase.downloader.model.b bVar : c) {
                            bVar.b(id);
                            this.o.a(bVar);
                        }
                    }
                    throw new com.ss.android.socialbase.downloader.exception.i("retry task because id generator changed");
                }
                return;
            }
            this.o.f(id);
            throw new BaseException(1025, "another same task is downloading");
        }
    }

    private boolean C() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
            return false;
        }
        if ((this.i && this.p.getChunkCount() <= 1) || this.p.isChunkDowngradeRetryUsed() || !this.j || this.l) {
            return false;
        }
        return true;
    }

    private void D() throws BaseException {
        long j;
        int a2;
        try {
            j = com.ss.android.socialbase.downloader.i.f.d(this.p.getTempPath());
        } catch (BaseException unused) {
            j = 0;
        }
        String str = f26303a;
        com.ss.android.socialbase.downloader.c.a.c(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.i.f.a(j) + "MB");
        if (j > 0) {
            long totalBytes = this.p.getTotalBytes() - this.p.getCurBytes();
            if (j < totalBytes && (a2 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = j - (a2 * 1048576);
                com.ss.android.socialbase.downloader.c.a.c(str, "checkSpaceOverflowInProgress: minKeep  = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.f.a(j2) + "MB");
                if (j2 > 0) {
                    this.G = this.p.getCurBytes() + j2 + 1048576;
                    return;
                } else {
                    this.G = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.d(j, totalBytes);
                }
            }
        }
        this.G = 0L;
    }

    private void E() throws com.ss.android.socialbase.downloader.exception.f {
        if (this.p.isOnlyWifi() && !com.ss.android.socialbase.downloader.i.f.a(com.ss.android.socialbase.downloader.downloader.c.O(), com.kuaishou.weapon.p0.g.b)) {
            throw new com.ss.android.socialbase.downloader.exception.f(1019, String.format("download task need permission:%s", com.kuaishou.weapon.p0.g.b));
        }
        if (this.p.isDownloadWithWifiValid()) {
            if (this.p.isPauseReserveWithWifiValid()) {
                return;
            } else {
                throw new com.ss.android.socialbase.downloader.exception.e();
            }
        }
        throw new com.ss.android.socialbase.downloader.exception.c();
    }

    private void F() throws BaseException {
        if (!TextUtils.isEmpty(this.p.getSavePath())) {
            if (!TextUtils.isEmpty(this.p.getName())) {
                File file = new File(this.p.getSavePath());
                if (!file.exists()) {
                    boolean mkdirs = file.mkdirs();
                    if (!mkdirs && !file.exists()) {
                        int i = 0;
                        if (com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("opt_mkdir_failed", 0) == 1) {
                            while (!mkdirs) {
                                int i2 = i + 1;
                                if (i >= 3) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                    mkdirs = file.mkdirs();
                                    i = i2;
                                } catch (InterruptedException unused) {
                                }
                            }
                            if (!mkdirs && !file.exists()) {
                                if (com.ss.android.socialbase.downloader.i.f.d(this.p.getSavePath()) < 16384) {
                                    throw new BaseException(1006, "download savePath directory can not created:" + this.p.getSavePath());
                                }
                                throw new BaseException(1030, "download savePath directory can not created:" + this.p.getSavePath());
                            }
                            return;
                        }
                        throw new BaseException(1030, "download savePath directory can not created:" + this.p.getSavePath());
                    }
                    return;
                }
                if (!file.isDirectory()) {
                    if (com.ss.android.socialbase.downloader.i.d.b(this.p)) {
                        file.delete();
                        if (!file.mkdirs() && !file.exists()) {
                            throw new BaseException(ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not directory:path=" + this.p.getSavePath());
                        }
                        return;
                    }
                    throw new BaseException(ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not a directory:" + this.p.getSavePath());
                }
                return;
            }
            throw new BaseException(1029, "download name can not be empty");
        }
        throw new BaseException(1028, "download savePath can not be empty");
    }

    private void G() {
        boolean z;
        long f = com.ss.android.socialbase.downloader.i.f.f(this.p);
        long curBytes = this.p.getCurBytes();
        if (f != curBytes) {
            com.ss.android.socialbase.downloader.c.a.d(f26303a, "checkTaskCanResume: offset = " + f + ", curBytes = " + curBytes);
        }
        this.p.setCurBytes(f);
        if (f > 0) {
            z = true;
        } else {
            z = false;
        }
        this.i = z;
        if (!z && !this.F) {
            com.ss.android.socialbase.downloader.c.a.c(f26303a, "checkTaskCanResume: deleteAllDownloadFiles");
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.f.a(this.p);
        }
    }

    private void H() {
        com.ss.android.socialbase.downloader.c.a.d(f26303a, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.f.a(this.p);
            this.i = false;
            this.p.resetDataForEtagEndure("");
            this.o.a(this.p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void I() {
        try {
            Iterator it = ((ArrayList) this.f.clone()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.b();
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.c.a.c(f26303a, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        com.ss.android.socialbase.downloader.impls.a D;
        if (!v() && (D = com.ss.android.socialbase.downloader.downloader.c.D()) != null) {
            D.l(this.p.getId());
        }
    }

    private boolean K() {
        return false;
    }

    private void h() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.p.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.e;
        if (atomicInteger == null) {
            this.e = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private boolean i() {
        int status = this.p.getStatus();
        if (status == 1 || this.p.canSkipStatusHandler()) {
            return true;
        }
        if (status != -2 && status != -4) {
            b(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
            return false;
        }
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00ed: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:80:0x00fa (LINE:238), block:B:79:0x00ed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3 A[Catch: all -> 0x00d4, TryCatch #4 {all -> 0x00d4, blocks: (B:34:0x00af, B:36:0x00b3, B:38:0x00b7, B:60:0x00ea), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j() throws com.ss.android.socialbase.downloader.exception.a {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.j():void");
    }

    private void k() {
        int i;
        Process.setThreadPriority(10);
        try {
            DownloadInfo downloadInfo = this.p;
            if (downloadInfo != null && this.H > 0) {
                downloadInfo.increaseDownloadPrepareTime(System.currentTimeMillis() - this.H);
            }
        } catch (Throwable unused) {
        }
        try {
            IDownloadInterceptor interceptor = this.c.getInterceptor();
            if (interceptor != null) {
                if (interceptor.intercepte()) {
                    this.v.e();
                    return;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!i()) {
            x monitorDepend = this.c.getMonitorDepend();
            DownloadInfo downloadInfo2 = this.p;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo3 = this.p;
            if (downloadInfo3 != null) {
                i = downloadInfo3.getStatus();
            } else {
                i = 0;
            }
            com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo2, baseException, i);
            return;
        }
        while (true) {
            l();
            if (this.C) {
                if (this.B > 0) {
                    this.B--;
                } else {
                    if (this.p.getCurBytes() != this.p.getTotalBytes()) {
                        com.ss.android.socialbase.downloader.c.a.b(f26303a, this.p.getErrorBytesLog());
                        this.v.a(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                        return;
                    }
                    if (this.p.getCurBytes() <= 0) {
                        com.ss.android.socialbase.downloader.c.a.b(f26303a, this.p.getErrorBytesLog());
                        this.v.a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                        return;
                    }
                    if (this.p.getTotalBytes() <= 0) {
                        com.ss.android.socialbase.downloader.c.a.b(f26303a, this.p.getErrorBytesLog());
                        this.v.a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    private void l() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.b> c;
        long j;
        boolean z2;
        try {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
            this.p.updateStartDownloadTime();
            this.p.resetRealStartDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            this.p.setFirstSpeedTime(-1L);
            try {
                j();
                z = false;
            } catch (com.ss.android.socialbase.downloader.exception.a e) {
                com.ss.android.socialbase.downloader.c.a.b(f26303a, "file exist " + e.a());
                this.E = e.a();
                z = true;
            }
            if (!this.C) {
                this.v.b();
            }
            this.C = false;
            if (v()) {
                p();
                return;
            }
            if (!TextUtils.isEmpty(this.E) && z) {
                if (this.p.isExpiredRedownload()) {
                    this.F = com.ss.android.socialbase.downloader.i.f.d(this.p);
                }
                if (!this.F) {
                    m();
                    p();
                    return;
                }
            }
            while (!v()) {
                try {
                    try {
                        try {
                            try {
                                F();
                                B();
                                E();
                                c = this.o.c(this.p.getId());
                                G();
                            } catch (com.ss.android.socialbase.downloader.exception.i e2) {
                                try {
                                    com.ss.android.socialbase.downloader.c.a.d(f26303a, "downloadInner: retry throwable for " + e2.a());
                                    if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                                        AtomicInteger atomicInteger = this.e;
                                        if (atomicInteger != null && atomicInteger.get() > 0) {
                                            this.p.updateCurRetryTime(this.e.decrementAndGet());
                                            this.p.setStatus(5);
                                        } else if (this.e != null) {
                                            if (this.p.trySwitchToNextBackupUrl()) {
                                                this.p.setStatus(5);
                                                this.e.set(this.p.getRetryCount());
                                                this.p.updateCurRetryTime(this.e.get());
                                            } else {
                                                b(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.p.getRetryCount()), e2.a())));
                                            }
                                        } else {
                                            b(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e2.a()));
                                        }
                                        s();
                                    }
                                } catch (Throwable th) {
                                    s();
                                    throw th;
                                }
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.a unused) {
                            m();
                        }
                    } catch (BaseException e3) {
                        com.ss.android.socialbase.downloader.c.a.d(f26303a, "downloadInner: baseException = " + e3);
                        if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                            if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                                if (a(e3)) {
                                    if (com.ss.android.socialbase.downloader.i.f.a(e3)) {
                                        H();
                                    }
                                    if (a(e3, 0L) != com.ss.android.socialbase.downloader.exception.h.RETURN) {
                                        s();
                                    } else {
                                        s();
                                        p();
                                        return;
                                    }
                                } else {
                                    b(e3);
                                }
                            }
                            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
                            s();
                            p();
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.c.a.d(f26303a, "downloadInner: throwable =  " + th2);
                    if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                        b(new BaseException(1045, th2));
                    }
                }
                if (n()) {
                    com.ss.android.socialbase.downloader.c.a.c(f26303a, "downloadSegments return");
                    s();
                    p();
                    return;
                }
                String connectionUrl = this.p.getConnectionUrl();
                if (v()) {
                    s();
                    p();
                    return;
                }
                if (this.i) {
                    j = com.ss.android.socialbase.downloader.i.f.e(this.p);
                } else {
                    j = 0;
                }
                com.ss.android.socialbase.downloader.model.b a2 = a(this.p, j);
                List<com.ss.android.socialbase.downloader.model.c> a3 = a(a2);
                com.ss.android.socialbase.downloader.i.f.a(a3, this.p);
                com.ss.android.socialbase.downloader.i.f.b(a3, this.p);
                this.p.setPreconnectLevel(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    a(connectionUrl, a3, j);
                    this.p.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                    if (v()) {
                        s();
                        p();
                        return;
                    }
                    long totalBytes = this.p.getTotalBytes();
                    a(totalBytes);
                    int a4 = a(totalBytes, c);
                    if (v()) {
                        s();
                        p();
                        return;
                    }
                    if (a4 > 0) {
                        if (a4 == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.h = z2;
                        if (z2) {
                            if (this.x == null) {
                                try {
                                    currentTimeMillis2 = System.currentTimeMillis();
                                    a(connectionUrl, a3);
                                    this.p.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                                } finally {
                                }
                            }
                            if (v()) {
                                s();
                                p();
                                return;
                            } else {
                                this.p.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                                o();
                                a(a2, connectionUrl, this.x);
                            }
                        } else {
                            if (!this.p.isNeedReuseFirstConnection()) {
                                r();
                            }
                            if (v()) {
                                s();
                                p();
                                return;
                            } else {
                                o();
                                this.p.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                                if (this.i) {
                                    a(a4, c);
                                } else {
                                    a(totalBytes, a4);
                                }
                            }
                        }
                        s();
                        p();
                        return;
                    }
                    throw new BaseException(1032, "chunkCount is 0");
                } finally {
                }
            }
            p();
        } catch (Throwable th3) {
            p();
            throw th3;
        }
    }

    private void m() {
        com.ss.android.socialbase.downloader.c.a.b(f26303a, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_end_for_file_exist_error", true)) {
            if (this.E.equals(this.p.getName())) {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.E.equals(this.p.getTargetFilePath())) {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private boolean n() throws BaseException, InterruptedException {
        if (this.p.isExpiredRedownload() || this.p.getChunkCount() != 1 || this.p.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject d = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).d("segment_config");
        List<com.ss.android.socialbase.downloader.f.i> n = this.o.n(this.p.getId());
        if (this.p.getCurBytes() > 0) {
            if (n == null || n.isEmpty()) {
                return false;
            }
            if (d == null) {
                d = new JSONObject();
            }
        }
        if (d == null) {
            return false;
        }
        this.K = new k(this.p, n.a(d), this);
        if (v()) {
            com.ss.android.socialbase.downloader.c.a.c(f26303a, "downloadSegments: is stopped by user");
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                this.K.a();
            } else {
                this.K.b();
            }
            return true;
        }
        return this.K.a(n);
    }

    private void o() {
        int retryCount;
        if (com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("reset_retain_retry_times", 0) == 1 && this.J < 3) {
            AtomicInteger atomicInteger = this.e;
            if (this.p.isBackUpUrlUsed()) {
                retryCount = this.p.getBackUpUrlRetryCount();
            } else {
                retryCount = this.p.getRetryCount();
            }
            atomicInteger.set(retryCount);
            this.J++;
        }
    }

    private void p() {
        boolean z;
        boolean z2;
        boolean z3;
        com.ss.android.socialbase.downloader.c.a.b(f26303a, "endDownloadRunnable::runStatus=" + this.n);
        int i = 0;
        if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE && this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
            z = true;
        } else {
            z = false;
        }
        try {
            z2 = w();
            z3 = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.v.a((BaseException) e);
            } else {
                this.v.a(new BaseException(1046, e));
            }
            z2 = true;
            z3 = true;
        }
        if (!z2 && !z3) {
            this.C = true;
            com.ss.android.socialbase.downloader.c.a.b(f26303a, "jump to restart");
            return;
        }
        this.m.set(false);
        if (z) {
            try {
                com.ss.android.socialbase.downloader.impls.a D = com.ss.android.socialbase.downloader.downloader.c.D();
                if (D != null) {
                    D.a(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                x monitorDepend = this.c.getMonitorDepend();
                DownloadInfo downloadInfo = this.p;
                BaseException baseException = new BaseException(1014, com.ss.android.socialbase.downloader.i.f.b(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.p;
                if (downloadInfo2 != null) {
                    i = downloadInfo2.getStatus();
                }
                com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, i);
            }
        }
    }

    private void q() {
        com.ss.android.socialbase.downloader.network.g gVar = this.y;
        if (gVar != null) {
            gVar.c();
            this.y = null;
        }
    }

    private void r() {
        i iVar = this.x;
        if (iVar != null) {
            iVar.d();
            this.x = null;
        }
    }

    private void s() {
        q();
        r();
    }

    private void t() throws BaseException {
        if (this.g != null) {
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                this.p.setStatus(-4);
                this.g.c();
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                this.p.setStatus(-2);
                this.g.b();
            } else {
                this.g.d();
            }
        }
    }

    private boolean u() {
        if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED && this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
            return false;
        }
        return true;
    }

    private boolean v() {
        if (!u() && this.p.getStatus() != -2) {
            return false;
        }
        if (!u()) {
            if (this.p.getStatus() == -2) {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
                return true;
            }
            if (this.p.getStatus() == -4) {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED;
                return true;
            }
            return true;
        }
        return true;
    }

    private boolean w() {
        if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ERROR) {
            this.v.a(this.w);
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
            this.v.c();
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
            this.v.d();
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.v.g();
            } catch (BaseException e) {
                this.v.a(e);
            }
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.v.a(this.E);
            } catch (BaseException e2) {
                this.v.a(e2);
            }
        } else {
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.v.a(this.w, false);
                return false;
            }
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            com.ss.android.socialbase.downloader.constants.h hVar = this.n;
            com.ss.android.socialbase.downloader.constants.h hVar2 = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY;
            if (hVar == hVar2 && !x()) {
                com.ss.android.socialbase.downloader.c.a.b(f26303a, "doTaskStatusHandle retryDelay");
                z();
                if (this.n == hVar2) {
                    return true;
                }
                return false;
            }
            try {
                if (!y()) {
                    return false;
                }
                this.v.f();
                com.ss.android.socialbase.downloader.impls.r.a().d();
            } catch (Throwable th) {
                b(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private boolean x() {
        if (this.p.getChunkCount() <= 1) {
            if (this.p.getCurBytes() <= 0 || this.p.getCurBytes() != this.p.getTotalBytes()) {
                return false;
            }
            return true;
        }
        List<com.ss.android.socialbase.downloader.model.b> c = this.o.c(this.p.getId());
        if (c == null || c.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.b bVar : c) {
            if (bVar == null || !bVar.i()) {
                return false;
            }
        }
        return true;
    }

    private boolean y() {
        if (this.p.isChunked()) {
            DownloadInfo downloadInfo = this.p;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        com.ss.android.socialbase.downloader.c.a.c(f26303a, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.p.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.p.getTotalBytes());
        if (this.p.getCurBytes() > 0) {
            if (!this.p.isIgnoreDataVerify()) {
                if (this.p.getTotalBytes() > 0 && this.p.getCurBytes() == this.p.getTotalBytes()) {
                    return true;
                }
            } else {
                return true;
            }
        }
        this.p.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.p.reset();
        this.o.a(this.p);
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.f.a(this.p);
        return false;
    }

    private void z() {
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
    }

    public void b() {
        com.ss.android.socialbase.downloader.constants.h hVar = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED;
        this.n = hVar;
        if (this.K != null) {
            this.K.a();
        }
        if (this.g != null) {
            this.g.c();
        }
        if (this.K == null && this.g == null) {
            s();
            this.n = hVar;
            p();
        }
        I();
    }

    public DownloadTask c() {
        return this.c;
    }

    public boolean d() {
        return this.m.get();
    }

    public int e() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public void f() {
        this.H = System.currentTimeMillis();
        this.v.a();
    }

    public Future g() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.c.a(this.c, 3);
        try {
            com.ss.android.socialbase.downloader.network.b.a().b();
            k();
            com.ss.android.socialbase.downloader.network.b.a().c();
            com.ss.android.socialbase.downloader.downloader.c.b(this.c, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.b.a().c();
            throw th;
        }
    }

    private boolean d(BaseException baseException) {
        AtomicInteger atomicInteger = this.e;
        boolean z = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.p.trySwitchToNextBackupUrl()) {
                    this.e.set(this.p.getBackUpUrlRetryCount());
                    this.p.updateCurRetryTime(this.e.get());
                } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.p.canReplaceHttpForRetry())) {
                    this.e.set(this.p.getRetryCount());
                    this.p.updateCurRetryTime(this.e.get());
                    this.p.setHttpsToHttpRetryUsed(true);
                } else {
                    b(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.e), String.valueOf(this.p.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                z = false;
            }
            if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY && z) {
                this.p.updateCurRetryTime(this.e.decrementAndGet());
            }
            return false;
        }
        b(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void c(BaseException baseException) {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        a(baseException, false);
    }

    public void a() {
        com.ss.android.socialbase.downloader.constants.h hVar = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
        this.n = hVar;
        if (this.K != null) {
            this.K.b();
        }
        if (this.g != null) {
            this.g.b();
        }
        if (this.K == null && this.g == null) {
            s();
            this.n = hVar;
            p();
        }
        try {
            Iterator it = ((ArrayList) this.f.clone()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j) {
        i iVar = this.x;
        if (iVar != null && (iVar instanceof com.ss.android.socialbase.downloader.network.a)) {
            try {
                ((com.ss.android.socialbase.downloader.network.a) iVar).a(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void b(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        com.ss.android.socialbase.downloader.network.a.c a2;
        boolean z = true;
        if (this.p.getChunkCount() == 1 && (a2 = com.ss.android.socialbase.downloader.network.a.a.a().a(str, list)) != null) {
            this.y = a2;
            this.p.setPreconnectLevel(1);
        }
        if (this.y == null && !this.D && this.p.isHeadConnectionAvailable()) {
            try {
                int b = this.I.b("net_lib_strategy");
                if (this.I.a("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.y = com.ss.android.socialbase.downloader.downloader.c.a(str, list, b, z, this.p);
            } catch (Throwable th) {
                this.p.setHeadConnectionException(com.ss.android.socialbase.downloader.i.f.j(th));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
    
        if (r9 <= 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int a(long r7, java.util.List<com.ss.android.socialbase.downloader.model.b> r9) {
        /*
            r6 = this;
            r0 = 0
            boolean r1 = r6.C()
            r2 = 1
            if (r1 == 0) goto L5e
            boolean r1 = r6.i
            if (r1 == 0) goto L1a
            if (r9 == 0) goto L13
            int r9 = r9.size()
            goto L5c
        L13:
            com.ss.android.socialbase.downloader.model.DownloadInfo r9 = r6.p
            int r9 = r9.getChunkCount()
            goto L5c
        L1a:
            com.ss.android.socialbase.downloader.downloader.h r9 = r6.q
            if (r9 == 0) goto L23
            int r9 = r9.a(r7)
            goto L29
        L23:
            com.ss.android.socialbase.downloader.downloader.h r9 = r6.r
            int r9 = r9.a(r7)
        L29:
            com.ss.android.socialbase.downloader.network.k r1 = com.ss.android.socialbase.downloader.network.k.a()
            com.ss.android.socialbase.downloader.network.l r1 = r1.b()
            java.lang.String r3 = com.ss.android.socialbase.downloader.h.c.f26303a
            java.lang.String r4 = r1.name()
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r0] = r4
            java.lang.String r4 = "NetworkQuality is : %s"
            java.lang.String r4 = java.lang.String.format(r4, r5)
            com.ss.android.socialbase.downloader.c.a.b(r3, r4)
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r6.p
            java.lang.String r4 = r1.name()
            r3.setNetworkQuality(r4)
            com.ss.android.socialbase.downloader.downloader.g r3 = r6.s
            if (r3 == 0) goto L56
            int r9 = r3.a(r9, r1)
            goto L5c
        L56:
            com.ss.android.socialbase.downloader.downloader.g r3 = r6.t
            int r9 = r3.a(r9, r1)
        L5c:
            if (r9 > 0) goto L5f
        L5e:
            r9 = 1
        L5f:
            boolean r1 = com.ss.android.socialbase.downloader.c.a.a()
            if (r1 == 0) goto L88
            java.lang.String r1 = com.ss.android.socialbase.downloader.h.c.f26303a
            java.lang.String r3 = java.lang.String.valueOf(r9)
            com.ss.android.socialbase.downloader.model.DownloadInfo r4 = r6.p
            java.lang.String r4 = r4.getName()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r0] = r3
            r8[r2] = r4
            r0 = 2
            r8[r0] = r7
            java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r7 = java.lang.String.format(r7, r8)
            com.ss.android.socialbase.downloader.c.a.b(r1, r7)
        L88:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(long, java.util.List):int");
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean b(long j) throws BaseException {
        if (this.G > 0 && this.p.getCurBytes() > this.G) {
            D();
        }
        return this.v.a(j);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void b(BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.b(f26303a, "onError:" + baseException.getMessage());
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ERROR;
        this.w = baseException;
        I();
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        b(str, list, j);
        com.ss.android.socialbase.downloader.network.g gVar = this.y;
        if (gVar != null) {
            try {
                a(str, gVar, j);
            } catch (Throwable unused) {
                this.D = true;
            }
        }
        if (this.y == null || this.D) {
            a(str, list);
            a(str, this.x, j);
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        i iVar;
        if (this.x != null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.a.d b = this.p.getChunkCount() == 1 ? com.ss.android.socialbase.downloader.network.a.a.a().b(str, list) : null;
        try {
            if (b != null) {
                a(this.x);
                this.p.setPreconnectLevel(2);
                this.x = b;
            } else {
                try {
                    try {
                        iVar = com.ss.android.socialbase.downloader.downloader.c.a(this.p.isNeedDefaultHttpServiceBackUp(), this.p.getMaxBytes(), str, null, list, this.I.b("net_lib_strategy"), this.I.a("monitor_download_connect", 0) > 0, this.p);
                        this.x = iVar;
                    } catch (BaseException e) {
                        throw e;
                    }
                } catch (Throwable th) {
                    if (this.p.isExpiredRedownload() && com.ss.android.socialbase.downloader.i.f.g(th) && com.ss.android.socialbase.downloader.i.f.c(list)) {
                        com.ss.android.socialbase.downloader.c.a.b(f26303a, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.p.getCacheControl());
                        long i = com.ss.android.socialbase.downloader.i.f.i(this.p.getCacheControl());
                        if (i <= 0) {
                            i = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("default_304_max_age", 300);
                        }
                        this.p.setCacheExpiredTime(System.currentTimeMillis() + (i * 1000));
                        throw new com.ss.android.socialbase.downloader.exception.a(this.E);
                    }
                    if (com.ss.android.socialbase.downloader.i.f.f(th)) {
                        a("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.i.f.e(th)) {
                        a("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.i.f.a(th, "CreateFirstConnection");
                    }
                    iVar = this.x;
                }
                a(iVar);
            }
            if (this.x == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            a(this.x);
            throw th2;
        }
    }

    public static com.ss.android.socialbase.downloader.model.b a(DownloadInfo downloadInfo, long j) {
        return new b.a(downloadInfo.getId()).a(-1).a(0L).e(j).b(j).c(0L).d(downloadInfo.getTotalBytes() - j).a();
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(com.ss.android.socialbase.downloader.model.b bVar) {
        List<com.ss.android.socialbase.downloader.model.c> a2 = com.ss.android.socialbase.downloader.i.f.a(this.p.getExtraHeaders(), this.p.geteTag(), bVar);
        if (this.p.isExpiredRedownload() && this.F && this.p.getLastModified() != null) {
            a2.add(new com.ss.android.socialbase.downloader.model.c("if-modified-since", this.p.getLastModified()));
            a2.add(new com.ss.android.socialbase.downloader.model.c("download-tc21-1-15", "download-tc21-1-15"));
            com.ss.android.socialbase.downloader.c.a.b(f26303a, "dcache::add head IF_MODIFIED_SINCE=" + this.p.getLastModified());
        }
        return a2;
    }

    private void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) throws BaseException {
        if (list.size() == i) {
            a(list, this.p.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    private void a(long j, int i) throws BaseException {
        long j2 = j / i;
        int id = this.p.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            com.ss.android.socialbase.downloader.model.b a2 = new b.a(id).a(i2).a(j3).e(j3).b(j3).c(i2 == i + (-1) ? 0L : (j3 + j2) - 1).a();
            arrayList.add(a2);
            this.o.a(a2);
            j3 += j2;
            i2++;
        }
        this.p.setChunkCount(i);
        this.o.a(id, i);
        a(arrayList, j);
    }

    private void a(List<com.ss.android.socialbase.downloader.model.b> list, long j) throws BaseException {
        long p;
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                if (bVar.p() == 0) {
                    p = j - bVar.n();
                } else {
                    p = (bVar.p() - bVar.n()) + 1;
                }
                if (p > 0) {
                    bVar.a(p);
                    if (this.p.isNeedReuseFirstConnection() && this.x != null && (!this.p.isHeadConnectionAvailable() || this.D)) {
                        if (bVar.s() == 0) {
                            this.f.add(new b(bVar, this.c, this.x, this));
                        } else if (bVar.s() > 0) {
                            this.f.add(new b(bVar, this.c, this));
                        }
                    } else {
                        this.f.add(new b(bVar, this.c, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.i.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f.size());
            Iterator<b> it = this.f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                    next.b();
                } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                    next.a();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> d = com.ss.android.socialbase.downloader.impls.e.d(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.e.e(d)) {
                    if (v()) {
                        return;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (d == null || d.isEmpty()) {
                    return;
                }
                for (Future future : d) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f.size());
        Iterator<b> it2 = this.f.iterator();
        while (it2.hasNext()) {
            b next2 = it2.next();
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                next2.b();
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                next2.a();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (v()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.e.c(arrayList2);
        } catch (InterruptedException e) {
            throw new BaseException(1020, e);
        }
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, String str, i iVar) throws BaseException {
        bVar.a(this.p.getTotalBytes() - bVar.n());
        this.p.setChunkCount(1);
        this.o.a(this.p.getId(), 1);
        this.g = new com.ss.android.socialbase.downloader.downloader.e(this.p, str, iVar, bVar, this);
        t();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:6|7|8|(4:10|(1:12)|13|(2:15|(4:17|(2:19|(1:21)(2:56|57))(1:58)|22|(8:24|(1:26)|27|28|29|30|31|32))(2:59|(6:61|28|29|30|31|32)(4:62|(1:64)(1:67)|65|66))))(2:69|(4:71|(1:73)(1:76)|74|75)(2:77|(2:79|80)))|68|27|28|29|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0177, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0179, code lost:
    
        com.ss.android.socialbase.downloader.c.a.e(com.ss.android.socialbase.downloader.h.c.f26303a, "checkSpaceOverflow: setLength1 e = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x019b, code lost:
    
        if (r7 >= r24) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01a7, code lost:
    
        r9.b(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01ab, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01ad, code lost:
    
        com.ss.android.socialbase.downloader.c.a.e(com.ss.android.socialbase.downloader.h.c.f26303a, "checkSpaceOverflow: setLength2 ex = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01c9, code lost:
    
        if (r4 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01d1, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.realsil.sdk.dfu.image.constants.SubBinId.Bbpro.DSP_UI_PARAMETER_FILE, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01d2, code lost:
    
        if (r4 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01e3, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.realsil.sdk.dfu.image.constants.SubBinId.Bbpro.DSP_UI_PARAMETER_FILE, r0);
     */
    @Override // com.ss.android.socialbase.downloader.h.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r24) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(long):void");
    }

    private boolean a(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.k || this.j)) {
            return (i == 201 || i == 416) && this.p.getCurBytes() > 0;
        }
        return true;
    }

    private void a(String str, String str2) throws com.ss.android.socialbase.downloader.exception.i {
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.f.a(this.p);
        this.i = false;
        this.p.resetDataForEtagEndure(str);
        this.o.a(this.p);
        throw new com.ss.android.socialbase.downloader.exception.i(str2);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(String str, com.ss.android.socialbase.downloader.network.g gVar, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        com.ss.android.socialbase.downloader.network.g gVar2;
        String str2;
        long j2;
        if (gVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.model.d dVar = new com.ss.android.socialbase.downloader.model.d(str, gVar);
            int i = dVar.c;
            String d = dVar.d();
            if (TextUtils.isEmpty(this.p.getMimeType()) && !TextUtils.isEmpty(d)) {
                this.p.setMimeType(d);
            }
            boolean b = dVar.b();
            this.j = b;
            this.p.setSupportPartial(b);
            this.k = dVar.a();
            String str3 = this.p.geteTag();
            String c = dVar.c();
            String f = dVar.f();
            String g = dVar.g();
            String str4 = f26303a;
            com.ss.android.socialbase.downloader.c.a.b(str4, "dcache=responseCode=" + i + " last_modified=" + f + " CACHE_CONTROL=" + g + " max-age=" + dVar.k() + " isDeleteCacheIfCheckFailed=" + this.p.isDeleteCacheIfCheckFailed());
            StringBuilder sb = new StringBuilder();
            sb.append("dcache=firstOffset=");
            sb.append(j);
            sb.append(" cur=");
            sb.append(f);
            sb.append(" before=");
            sb.append(this.p.getLastModified());
            sb.append(" cur=");
            String str5 = c;
            sb.append(dVar.j());
            sb.append(" before=");
            sb.append(this.p.getTotalBytes());
            com.ss.android.socialbase.downloader.c.a.b(str4, sb.toString());
            if (!TextUtils.isEmpty(g)) {
                this.p.setCacheControl(g);
                if (dVar.k() > 0) {
                    this.p.setCacheExpiredTime(System.currentTimeMillis() + (dVar.k() * 1000));
                }
            }
            if (this.p.isExpiredRedownload() && this.F && !TextUtils.isEmpty(this.E)) {
                if (i == 304 || ((!TextUtils.isEmpty(this.p.getLastModified()) || !this.p.isDeleteCacheIfCheckFailed()) && TextUtils.equals(f, this.p.getLastModified()))) {
                    com.ss.android.socialbase.downloader.c.a.b(str4, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + f);
                    throw new com.ss.android.socialbase.downloader.exception.a(this.E);
                }
                com.ss.android.socialbase.downloader.i.f.a(this.p);
            }
            if (j > 0 && this.p.isExpiredRedownload() && !TextUtils.equals(f, this.p.getLastModified())) {
                com.ss.android.socialbase.downloader.c.a.b(str4, "dcache cdn file change, so retry");
                a("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(f)) {
                this.p.setLastModified(f);
            }
            if (a(i, str3, str5)) {
                gVar2 = gVar;
                if (gVar2 instanceof i) {
                    if (!TextUtils.isEmpty(str3) && str3.equals(str5)) {
                        str5 = "";
                    }
                    a(str5, "eTag of server file changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.b(1002, i, "");
                }
            } else {
                gVar2 = gVar;
            }
            if (!this.j && !this.k) {
                if (i == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.b(1004, i, "response code error : " + i);
            }
            if (this.k && j > 0) {
                if (gVar2 instanceof i) {
                    a("", "http head request not support");
                } else {
                    throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            long h = dVar.h();
            if (!(gVar2 instanceof i) && h < 0 && com.ss.android.socialbase.downloader.i.d.a(this.p)) {
                throw new BaseException(1004, "");
            }
            if (!TextUtils.isEmpty(this.p.getName())) {
                str2 = "";
            } else {
                str2 = com.ss.android.socialbase.downloader.i.f.a(gVar2, this.p.getUrl());
            }
            boolean i2 = dVar.i();
            this.l = i2;
            if (!i2 && h == 0 && !(gVar2 instanceof i)) {
                throw new BaseException(1004, "");
            }
            if (i2) {
                j2 = -1;
            } else {
                String b2 = com.ss.android.socialbase.downloader.i.f.b(gVar2, "Content-Range");
                com.ss.android.socialbase.downloader.c.a.c(str4, "firstConnection: contentRange = " + b2);
                if (!TextUtils.isEmpty(b2) && this.I.b("fix_get_total_bytes", true)) {
                    j2 = com.ss.android.socialbase.downloader.i.f.b(b2);
                    com.ss.android.socialbase.downloader.c.a.c(str4, "firstConnection: 1 totalLength = " + j2);
                } else {
                    long j3 = j + h;
                    com.ss.android.socialbase.downloader.c.a.e(str4, "firstConnection: 2 totalLength = " + j3 + ", contentLength = " + h);
                    j2 = j3;
                }
            }
            if (!TextUtils.isEmpty(this.p.getTaskKey()) && this.p.getTotalBytes() > 0 && j2 != this.p.getTotalBytes()) {
                if (gVar2 instanceof i) {
                    a("", "file totalLength changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.b(1002, i, "");
                }
            }
            if (v()) {
                return;
            }
            if (this.p.getExpectFileLength() > 0 && com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).b("force_check_file_length") == 1 && this.p.getExpectFileLength() != j2) {
                throw new BaseException(1070, "expectFileLength = " + this.p.getExpectFileLength() + " , totalLength = " + j2);
            }
            this.v.a(j2, str5, str2);
        } catch (BaseException e) {
            throw e;
        } catch (com.ss.android.socialbase.downloader.exception.i e2) {
            throw e2;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.i.f.a(th, "HandleFirstConnection");
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(b bVar) {
        if (this.h) {
            return;
        }
        synchronized (this) {
            this.f.remove(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean a(BaseException baseException) {
        if (this.K != null && com.ss.android.socialbase.downloader.i.f.i(baseException) && this.e.get() < this.p.getRetryCount()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.i.f.b(baseException)) {
            if (this.h && !this.d) {
                com.ss.android.socialbase.downloader.i.f.a(this.p);
                this.d = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.e;
        if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.p.hasNextBackupUrl()) {
            if (baseException == null) {
                return false;
            }
            if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.p.canReplaceHttpForRetry()) {
                return false;
            }
        }
        return !(baseException instanceof com.ss.android.socialbase.downloader.exception.f);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(BaseException baseException, boolean z) {
        com.ss.android.socialbase.downloader.c.a.b(f26303a, "onAllChunkRetryWithReset");
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.w = baseException;
        I();
        if (z ? d(baseException) : false) {
            return;
        }
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.p.setForbiddenBackupUrls(list, this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.a D = com.ss.android.socialbase.downloader.downloader.c.D();
        if (D != null) {
            D.l(this.p.getId());
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.h a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j) {
        if (u()) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.i.f.h(baseException))) {
            return a(baseException, j);
        }
        this.w = baseException;
        this.p.increaseCurBytes(-j);
        this.o.a(this.p);
        if (d(baseException)) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.f fVar = this.v;
        com.ss.android.socialbase.downloader.constants.h hVar = this.n;
        com.ss.android.socialbase.downloader.constants.h hVar2 = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY;
        fVar.a(bVar, baseException, hVar == hVar2);
        if (this.n != hVar2 && this.p.isNeedRetryDelay()) {
            long A = A();
            if (A > 0) {
                com.ss.android.socialbase.downloader.c.a.c(f26303a, "onSingleChunkRetry with delay time " + A);
                try {
                    Thread.sleep(A);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.c.a.d(f26303a, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.h.CONTINUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00fc  */
    @Override // com.ss.android.socialbase.downloader.h.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.ss.android.socialbase.downloader.exception.h a(com.ss.android.socialbase.downloader.exception.BaseException r9, long r10) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(com.ss.android.socialbase.downloader.exception.BaseException, long):com.ss.android.socialbase.downloader.exception.h");
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public synchronized com.ss.android.socialbase.downloader.model.b a(int i) {
        com.ss.android.socialbase.downloader.model.b a2;
        if (this.p.getChunkCount() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.b> c = this.o.c(this.p.getId());
        if (c != null && !c.isEmpty()) {
            for (int i2 = 0; i2 < c.size(); i2++) {
                com.ss.android.socialbase.downloader.model.b bVar = c.get(i2);
                if (bVar != null && (a2 = a(bVar, i)) != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(com.ss.android.socialbase.downloader.network.g gVar) {
        if (gVar != null) {
            try {
                int b = gVar.b();
                this.p.setHttpStatusCode(b);
                this.p.setHttpStatusMessage(com.ss.android.socialbase.downloader.i.b.a(b));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.p.setHttpStatusCode(-1);
        this.p.setHttpStatusMessage("");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x006c, code lost:
    
        if (r9.f() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ss.android.socialbase.downloader.model.b a(com.ss.android.socialbase.downloader.model.b r9, int r10) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(com.ss.android.socialbase.downloader.model.b, int):com.ss.android.socialbase.downloader.model.b");
    }

    private s a(DownloadTask downloadTask) {
        s retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new q(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.c.M();
    }

    public void a(Future future) {
        this.b = future;
    }
}
