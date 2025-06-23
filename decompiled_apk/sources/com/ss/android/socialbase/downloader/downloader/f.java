package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes13.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f26275a = "f";
    private final boolean b;
    private DownloadInfo c;
    private final j d;
    private final Handler e;
    private DownloadTask f;
    private SparseArray<IDownloadListener> g;
    private SparseArray<IDownloadListener> h;
    private SparseArray<IDownloadListener> i;
    private boolean j = false;
    private volatile long k = 0;
    private final AtomicLong l = new AtomicLong();
    private boolean m = false;
    private int n;
    private long o;
    private com.ss.android.socialbase.downloader.depend.n p;
    private x q;

    public f(DownloadTask downloadTask, Handler handler) {
        this.f = downloadTask;
        j();
        this.e = handler;
        this.d = c.y();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.b = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_start_with_file_exist_update_error");
        } else {
            this.b = false;
        }
    }

    private void j() {
        DownloadTask downloadTask = this.f;
        if (downloadTask != null) {
            this.c = downloadTask.getDownloadInfo();
            this.g = this.f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            this.i = this.f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.h = this.f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
            this.p = this.f.getDepend();
            this.q = this.f.getMonitorDepend();
        }
    }

    private void k() {
        ExecutorService l = c.l();
        if (l != null) {
            l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.d.i(f.this.c.getId());
                    f.this.a(1, (BaseException) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.c.a.b(f26275a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.c.setFirstSuccess(false);
                this.c.setSuccessByCache(false);
                a(-3, (BaseException) null);
                this.d.c(this.c.getId(), this.c.getTotalBytes());
                this.d.d(this.c.getId());
                this.d.m(this.c.getId());
            } catch (BaseException e) {
                a(e);
            }
        } catch (Throwable th) {
            a(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "onCompleted")));
        }
    }

    private void m() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers = this.f.getDownloadCompleteHandlers();
        if (!downloadCompleteHandlers.isEmpty()) {
            DownloadInfo downloadInfo = this.c;
            a(11, (BaseException) null);
            this.d.a(downloadInfo);
            for (com.ss.android.socialbase.downloader.depend.m mVar : downloadCompleteHandlers) {
                try {
                    if (mVar.b(downloadInfo)) {
                        mVar.a(downloadInfo);
                        this.d.a(downloadInfo);
                    }
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    throw new BaseException(1071, th);
                }
            }
        }
    }

    public void d() {
        this.c.setStatus(-2);
        try {
            this.d.d(this.c.getId(), this.c.getCurBytes());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-2, (BaseException) null);
    }

    public void e() {
        this.c.setStatus(-7);
        try {
            this.d.j(this.c.getId());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-7, (BaseException) null);
    }

    public void f() {
        this.c.setFirstDownload(false);
        if (!this.c.isIgnoreDataVerify() && this.c.getCurBytes() != this.c.getTotalBytes()) {
            com.ss.android.socialbase.downloader.c.a.b(f26275a, this.c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.c.getByteInvalidRetryStatus()));
            return;
        }
        if (this.c.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(f26275a, this.c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.c.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.c.isIgnoreDataVerify() && this.c.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(f26275a, this.c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.c.getByteInvalidRetryStatus()));
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b(f26275a, "" + this.c.getName() + " onCompleted start save file as target name");
        x xVar = this.q;
        DownloadTask downloadTask = this.f;
        if (downloadTask != null) {
            xVar = downloadTask.getMonitorDepend();
        }
        com.ss.android.socialbase.downloader.i.f.a(this.c, xVar, new ai() { // from class: com.ss.android.socialbase.downloader.downloader.f.2
            @Override // com.ss.android.socialbase.downloader.depend.ai
            public void a() {
                f.this.l();
            }

            @Override // com.ss.android.socialbase.downloader.depend.ai
            public void a(BaseException baseException) {
                String str = f.f26275a;
                StringBuilder sb = new StringBuilder();
                sb.append("saveFileAsTargetName onFailed : ");
                sb.append(baseException != null ? baseException.getErrorMessage() : "");
                com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
                f.this.a(baseException);
            }
        });
    }

    public void g() throws BaseException {
        if (this.b) {
            m();
            com.ss.android.socialbase.downloader.c.a.b(f26275a, "onCompleteForFileExist");
            this.c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.d.c(this.c.getId(), this.c.getTotalBytes());
            this.d.d(this.c.getId());
            this.d.a(this.c);
            this.d.m(this.c.getId());
            return;
        }
        m();
        com.ss.android.socialbase.downloader.c.a.b(f26275a, "onCompleteForFileExist");
        this.c.setSuccessByCache(true);
        a(-3, (BaseException) null);
        this.d.c(this.c.getId(), this.c.getTotalBytes());
        this.d.d(this.c.getId());
        this.d.m(this.c.getId());
    }

    public void h() {
        this.c.setStatus(8);
        this.c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a D = c.D();
        if (D != null) {
            D.a(this.c.getId(), this.f.getHashCodeForSameTask(), 8);
        }
    }

    public void b() {
        if (this.c.canSkipStatusHandler()) {
            this.c.changeSkipStatus();
            return;
        }
        this.d.g(this.c.getId());
        if (this.c.isFirstDownload()) {
            a(6, (BaseException) null);
        }
        a(2, (BaseException) null);
    }

    public void c() {
        a(-4, (BaseException) null);
    }

    private BaseException c(BaseException baseException) {
        Context O;
        if (com.ss.android.socialbase.downloader.g.a.a(this.c.getId()).a("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.i.f.i(baseException) || (O = c.O()) == null || com.ss.android.socialbase.downloader.i.f.c(O)) {
            return baseException;
        }
        return new BaseException(this.c.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void a() {
        if (this.c.canSkipStatusHandler()) {
            return;
        }
        this.c.setStatus(1);
        k();
    }

    public void a(long j, String str, String str2) {
        this.c.setTotalBytes(j);
        this.c.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.c.getName())) {
            this.c.setName(str2);
        }
        try {
            this.d.a(this.c.getId(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(3, (BaseException) null);
        this.o = this.c.getMinByteIntervalForPostToMainThread(j);
        this.n = this.c.getMinProgressTimeMsInterval();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.a().e();
    }

    private void b(BaseException baseException) {
        Log.d(f26275a, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.d.f(this.c.getId());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                try {
                    this.d.b(this.c.getId(), this.c.getCurBytes());
                } catch (SQLiteException unused) {
                    this.d.f(this.c.getId());
                }
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
        BaseException c = c(baseException);
        this.c.setFailedException(c);
        a(c instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, c);
        if (com.ss.android.socialbase.downloader.g.a.a(this.c.getId()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.a().a(this.c);
        }
    }

    public boolean a(long j) {
        this.l.addAndGet(j);
        this.c.increaseCurBytes(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    private boolean b(long j) {
        boolean z = true;
        if (!this.m) {
            this.m = true;
            return true;
        }
        long j2 = j - this.k;
        if (this.l.get() < this.o && j2 < this.n) {
            z = false;
        }
        if (z) {
            this.k = j;
            this.l.set(0L);
        }
        return z;
    }

    public void a(BaseException baseException, boolean z) {
        this.c.setFirstDownload(false);
        this.l.set(0L);
        b(baseException, z);
    }

    public void a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        this.c.setFirstDownload(false);
        this.l.set(0L);
        this.d.h(this.c.getId());
        a(z ? 10 : 9, baseException, true);
    }

    private void b(BaseException baseException, boolean z) {
        this.d.h(this.c.getId());
        a(z ? 7 : 5, baseException);
    }

    public void a(BaseException baseException) {
        this.c.setFirstDownload(false);
        b(baseException);
    }

    public void a(String str) throws BaseException {
        com.ss.android.socialbase.downloader.c.a.b(f26275a, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.c.getName());
        if (this.b) {
            com.ss.android.socialbase.downloader.i.f.a(this.c, str);
            m();
            this.c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.d.a(this.c);
            return;
        }
        this.d.a(this.c);
        com.ss.android.socialbase.downloader.i.f.a(this.c, str);
        this.c.setSuccessByCache(true);
        m();
        a(-3, (BaseException) null);
    }

    private boolean a(long j, boolean z) {
        boolean z2 = false;
        if (this.c.getCurBytes() == this.c.getTotalBytes()) {
            try {
                this.d.a(this.c.getId(), this.c.getCurBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        if (this.j) {
            this.j = false;
            this.c.setStatus(4);
        }
        if (this.c.isNeedPostProgress() && z) {
            z2 = true;
        }
        a(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, BaseException baseException) {
        a(i, baseException, true);
    }

    private void a(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.c.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        j();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.c.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.c.updateDownloadTime();
            }
        }
        if (!this.c.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.d.a.a(this.f, baseException, i);
        }
        if (i == 6) {
            this.c.setStatus(2);
        } else if (i == -6) {
            this.c.setStatus(-3);
        } else {
            this.c.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.c.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADING) {
                this.c.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADED);
            }
            if (this.c.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                this.c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.c.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.c.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.i.c.a(i, this.h, true, this.c, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.e != null && (((sparseArray = this.g) != null && sparseArray.size() > 0) || ((sparseArray2 = this.i) != null && sparseArray2.size() > 0 && (this.c.canShowNotification() || this.c.isAutoInstallWithoutNotification())))) {
            this.e.obtainMessage(i, this.c.getId(), this.f.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.a D = c.D();
        if (D != null) {
            D.a(this.c.getId(), this.f.getHashCodeForSameTask(), i);
        }
    }
}
