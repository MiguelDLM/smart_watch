package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes13.dex */
public abstract class a implements h.a {
    private final SparseArray<DownloadTask> b = new SparseArray<>();
    private final SparseArray<DownloadTask> c = new SparseArray<>();
    private final SparseArray<DownloadTask> d = new SparseArray<>();
    private final SparseArray<DownloadTask> e = new SparseArray<>();
    private final SparseArray<DownloadTask> f = new SparseArray<>();
    private final SparseArray<SparseArray<DownloadTask>> g = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.i.h<Integer, DownloadTask> h = new com.ss.android.socialbase.downloader.i.h<>();
    private final SparseArray<Long> i = new SparseArray<>();
    private final LinkedBlockingDeque<DownloadTask> j = new LinkedBlockingDeque<>();

    /* renamed from: a, reason: collision with root package name */
    protected final com.ss.android.socialbase.downloader.h.h f26363a = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.j k = com.ss.android.socialbase.downloader.downloader.c.y();

    private void c(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.j.isEmpty()) {
                a(downloadTask, true);
                this.j.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.j.getFirst().getDownloadId() == downloadTask.getDownloadId() && a(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.j.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DownloadTask next = it.next();
                    if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                        it.remove();
                        break;
                    }
                }
                this.j.put(downloadTask);
                new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f26363a).a();
                return;
            }
            DownloadTask first = this.j.getFirst();
            if (first.getDownloadId() == downloadTask.getDownloadId() && a(downloadTask.getDownloadId())) {
                return;
            }
            e(first.getDownloadId());
            a(downloadTask, true);
            if (first.getDownloadId() != downloadTask.getDownloadId()) {
                this.j.putFirst(downloadTask);
            }
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask o(int i) {
        DownloadTask downloadTask = this.b.get(i);
        if (downloadTask == null) {
            DownloadTask downloadTask2 = this.d.get(i);
            if (downloadTask2 == null) {
                DownloadTask downloadTask3 = this.c.get(i);
                if (downloadTask3 == null) {
                    DownloadTask downloadTask4 = this.e.get(i);
                    if (downloadTask4 == null) {
                        return this.f.get(i);
                    }
                    return downloadTask4;
                }
                return downloadTask3;
            }
            return downloadTask2;
        }
        return downloadTask;
    }

    private void p(int i) {
        DownloadTask first;
        if (this.j.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.j.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.j.poll();
        }
        if (!this.j.isEmpty() && (first = this.j.getFirst()) != null) {
            a(first, true);
        }
    }

    public abstract List<Integer> a();

    public abstract void a(int i, long j);

    public abstract void a(int i, DownloadTask downloadTask);

    public abstract void a(com.ss.android.socialbase.downloader.h.c cVar);

    public abstract boolean a(int i);

    public abstract void b(int i);

    public abstract com.ss.android.socialbase.downloader.h.c c(int i);

    public synchronized DownloadInfo d(int i) {
        DownloadInfo b;
        DownloadTask downloadTask;
        b = this.k.b(i);
        if (b == null && (downloadTask = this.b.get(i)) != null) {
            b = downloadTask.getDownloadInfo();
        }
        return b;
    }

    public synchronized boolean e(int i) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "pause id=" + i);
        DownloadInfo b = this.k.b(i);
        if (b != null && b.getStatus() == 11) {
            return false;
        }
        synchronized (this.b) {
            b(i);
        }
        if (b == null) {
            DownloadTask downloadTask = this.b.get(i);
            if (downloadTask != null) {
                new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f26363a).d();
                return true;
            }
        } else {
            a(b);
            if (b.getStatus() == 1) {
                DownloadTask downloadTask2 = this.b.get(i);
                if (downloadTask2 != null) {
                    new com.ss.android.socialbase.downloader.downloader.f(downloadTask2, this.f26363a).d();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(b.getStatus())) {
                b.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean f(int i) {
        try {
            DownloadTask downloadTask = this.b.get(i);
            if (downloadTask != null) {
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                if (downloadInfo != null) {
                    downloadInfo.setDownloadFromReserveWifi(false);
                }
                a(downloadTask);
            } else {
                g(i);
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    public synchronized boolean g(int i) {
        try {
            DownloadTask downloadTask = this.d.get(i);
            if (downloadTask == null) {
                downloadTask = this.e.get(i);
            }
            if (downloadTask == null) {
                return false;
            }
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            a(downloadTask);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized af h(int i) {
        DownloadTask downloadTask = this.b.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.c.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.d.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.e.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.f.get(i);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationClickCallback();
        }
        return null;
    }

    public synchronized z i(int i) {
        DownloadTask downloadTask = this.b.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.c.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.d.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.e.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.f.get(i);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationEventListener();
        }
        return null;
    }

    public synchronized IDownloadFileUriProvider j(int i) {
        DownloadTask downloadTask = this.b.get(i);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.c.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.d.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.e.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.f.get(i);
        if (downloadTask5 != null) {
            return downloadTask5.getFileUriProvider();
        }
        return null;
    }

    public synchronized boolean k(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.e.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                a(downloadTask, false);
            }
            return true;
        }
        DownloadInfo b = this.k.b(i);
        if (b != null && b.canStartRetryDelayTask()) {
            a(new DownloadTask(b), false);
        }
        return false;
    }

    public synchronized boolean l(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canReStartAsyncTask()) {
                a(downloadTask);
            }
            return true;
        }
        return false;
    }

    public synchronized void m(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.b.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            a(downloadTask);
        }
    }

    public synchronized boolean n(int i) {
        boolean z;
        if (i != 0) {
            try {
                if (this.b.get(i) == null) {
                    if (this.d.get(i) != null) {
                    }
                }
                z = true;
            } finally {
            }
        }
        z = false;
        return z;
    }

    private void b(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.g.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.g.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void a(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int i;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.i.f.c(com.ss.android.socialbase.downloader.downloader.c.O()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f26363a).a(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            a(downloadInfo);
        }
        if (this.d.get(id) != null) {
            this.d.remove(id);
        }
        if (this.c.get(id) != null) {
            this.c.remove(id);
        }
        if (this.e.get(id) != null) {
            this.e.remove(id);
        }
        if (this.f.get(id) != null) {
            this.f.remove(id);
        }
        if (a(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "no downloading task :" + id);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.i.a.a(32768) && (remove = this.h.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.b.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            i = 0;
        } else {
            i = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(i)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + i);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        b(downloadTask);
        this.b.put(id, downloadTask);
        this.i.put(id, Long.valueOf(uptimeMillis));
        a(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(int i, boolean z) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        try {
            DownloadInfo b = this.k.b(i);
            if (b != null) {
                if (z) {
                    com.ss.android.socialbase.downloader.i.f.a(b);
                } else {
                    com.ss.android.socialbase.downloader.i.f.c(b.getTempPath(), b.getTempName());
                }
                b.erase();
            }
            try {
                this.k.f(i);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            a(i, 0, -4);
            if (this.d.get(i) != null) {
                this.d.remove(i);
            }
            if (this.c.get(i) != null) {
                this.c.remove(i);
            }
            this.h.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.g.a.b(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void b(List<String> list) {
        DownloadInfo downloadInfo;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.O())) {
            for (int i = 0; i < this.b.size(); i++) {
                DownloadTask downloadTask = this.b.get(this.b.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && b(downloadInfo)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    a(downloadTask);
                    downloadInfo.setDownloadFromReserveWifi(true);
                    com.ss.android.socialbase.downloader.downloader.r reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).getReserveWifiStatusListener();
                    if (reserveWifiStatusListener != null) {
                        reserveWifiStatusListener.a(downloadInfo, 5, 2);
                    }
                }
            }
        }
    }

    public void c(final int i, final boolean z) {
        DownloadInfo b = this.k.b(i);
        if (b != null) {
            a(b);
        }
        this.f26363a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.a().f(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.c(i);
                a.this.e(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, boolean z) {
        try {
            DownloadInfo b = this.k.b(i);
            if (b != null) {
                com.ss.android.socialbase.downloader.i.f.a(b, z);
                b.erase();
            }
            try {
                this.k.d(i);
                this.k.a(b);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            if (this.d.get(i) != null) {
                this.d.remove(i);
            }
            if (this.c.get(i) != null) {
                this.c.remove(i);
            }
            this.h.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.g.a.b(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void b() {
        List<Integer> a2 = a();
        if (a2 == null) {
            return;
        }
        Iterator<Integer> it = a2.iterator();
        while (it.hasNext()) {
            e(it.next().intValue());
        }
    }

    public void b(final int i, final boolean z) {
        DownloadInfo b = this.k.b(i);
        if (b != null) {
            a(b);
        }
        this.f26363a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.a().f(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask o;
                if (a.this.c(i) == null && (o = a.this.o(i)) != null) {
                    DownloadInfo downloadInfo = o.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = o.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                try {
                                    IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i2));
                                    if (iDownloadListener != null) {
                                        iDownloadListener.onCanceled(downloadInfo);
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
                a.this.d(i, z);
            }
        }, false);
    }

    public synchronized void b(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a(i, i2, iDownloadListener, fVar, z, true);
    }

    public List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = a().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo d = d(it.next().intValue());
            if (d != null && str.equals(d.getMimeType())) {
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            downloadInfo.setDownloadFromReserveWifi(false);
            if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
                c(downloadTask);
            } else {
                a(downloadTask, true);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void b(int i, long j) {
        DownloadInfo b = this.k.b(i);
        if (b != null) {
            b.setThrottleNetSpeed(j);
        }
        a(i, j);
    }

    public synchronized List<DownloadInfo> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> a2 = this.k.a(str);
        if (a2 != null && !a2.isEmpty()) {
            return a2;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            DownloadTask valueAt = this.b.valueAt(i);
            if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                arrayList.add(valueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized boolean a(int i, boolean z) {
        try {
            DownloadTask downloadTask = this.b.get(i);
            if (downloadTask == null && com.ss.android.socialbase.downloader.i.a.a(65536)) {
                downloadTask = o(i);
            }
            if (downloadTask != null) {
                if (!com.ss.android.socialbase.downloader.g.a.a(i).b("fix_on_cancel_call_twice", true)) {
                    new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f26363a).c();
                }
                final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                final SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
                final SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
                this.f26363a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SparseArray sparseArray;
                        SparseArray sparseArray2 = downloadListeners;
                        if (sparseArray2 != null) {
                            synchronized (sparseArray2) {
                                for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                    try {
                                        IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i2));
                                        if (iDownloadListener != null) {
                                            iDownloadListener.onCanceled(downloadInfo);
                                        }
                                    } finally {
                                    }
                                }
                            }
                        }
                        DownloadInfo downloadInfo2 = downloadInfo;
                        if (downloadInfo2 != null && downloadInfo2.canShowNotification() && (sparseArray = downloadListeners2) != null) {
                            synchronized (sparseArray) {
                                for (int i3 = 0; i3 < downloadListeners2.size(); i3++) {
                                    try {
                                        IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i3));
                                        if (iDownloadListener2 != null) {
                                            iDownloadListener2.onCanceled(downloadInfo);
                                        }
                                    } finally {
                                    }
                                }
                            }
                        }
                    }
                });
            }
            DownloadInfo b = this.k.b(i);
            if (com.ss.android.socialbase.downloader.i.a.a(65536)) {
                if (b != null) {
                    b.setStatus(-4);
                }
            } else if (b != null && DownloadStatus.isDownloading(b.getStatus())) {
                b.setStatus(-4);
            }
            b(i, z);
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    private void a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() != 7 && downloadInfo.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_NONE) {
                    return;
                }
                downloadInfo.setStatus(5);
                downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_NONE);
                com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "cancelAlarm");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void a(int i, z zVar) {
        DownloadTask downloadTask = this.b.get(i);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(zVar);
        }
    }

    public synchronized void a(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            try {
                boolean b = com.ss.android.socialbase.downloader.i.a.a(1048576) ? com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.O()) : true;
                for (int i = 0; i < this.d.size(); i++) {
                    DownloadTask downloadTask = this.d.get(this.d.keyAt(i));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || b)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        a(downloadTask);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        try {
            DownloadTask o = o(i);
            if (o == null) {
                o = this.h.get(Integer.valueOf(i));
            }
            if (o != null) {
                o.removeDownloadListener(i2, iDownloadListener, fVar, z);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(int i, int i2, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        DownloadInfo b;
        try {
            DownloadTask o = o(i);
            if (o != null) {
                o.addDownloadListener(i2, iDownloadListener, fVar, z);
                final DownloadInfo downloadInfo = o.getDownloadInfo();
                if (z2) {
                    if (downloadInfo != null) {
                        if (!a(i)) {
                            if (fVar != com.ss.android.socialbase.downloader.constants.f.MAIN) {
                                if (fVar == com.ss.android.socialbase.downloader.constants.f.NOTIFICATION) {
                                }
                            }
                            if (fVar != com.ss.android.socialbase.downloader.constants.f.NOTIFICATION || downloadInfo.canShowNotification()) {
                                this.f26363a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.6
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (iDownloadListener != null) {
                                            if (downloadInfo.getStatus() == -3) {
                                                iDownloadListener.onSuccessed(downloadInfo);
                                            } else if (downloadInfo.getStatus() == -1) {
                                                iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            } else if (com.ss.android.socialbase.downloader.i.a.a(32768) && (b = this.k.b(i)) != null && b.getStatus() != -3) {
                DownloadTask downloadTask = this.h.get(Integer.valueOf(i));
                if (downloadTask == null) {
                    downloadTask = new DownloadTask(b);
                    this.h.put(Integer.valueOf(i), downloadTask);
                }
                downloadTask.addDownloadListener(i2, iDownloadListener, fVar, z);
            }
        } finally {
        }
    }

    private void a(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.i.c.a(i, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.i.c.a(i, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void a(int i, int i2) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.b.remove(i);
            this.g.remove(i);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.g.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.b.remove(i);
                this.g.remove(i);
                return;
            }
            return;
        }
        this.b.remove(i);
    }

    public synchronized void a(int i, int i2, int i3) {
        try {
            if (i3 != -7) {
                if (i3 == -6) {
                    this.c.put(i, this.b.get(i));
                    a(i, i2);
                } else if (i3 == -4) {
                    a(i, i2);
                    p(i);
                } else if (i3 == -3) {
                    this.c.put(i, this.b.get(i));
                    a(i, i2);
                    p(i);
                } else if (i3 != -1) {
                    if (i3 == 7) {
                        DownloadTask downloadTask = this.b.get(i);
                        if (downloadTask != null) {
                            if (this.e.get(i) == null) {
                                this.e.put(i, downloadTask);
                            }
                            a(i, i2);
                        }
                        p(i);
                    } else if (i3 == 8) {
                        DownloadTask downloadTask2 = this.b.get(i);
                        if (downloadTask2 != null && this.f.get(i) == null) {
                            this.f.put(i, downloadTask2);
                        }
                        p(i);
                    }
                }
            }
            DownloadTask downloadTask3 = this.b.get(i);
            if (downloadTask3 != null) {
                if (this.d.get(i) == null) {
                    this.d.put(i, downloadTask3);
                }
                a(i, i2);
            }
            p(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.h.a
    public void a(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "handleMsg id: " + i + " listener hasCode: " + i2);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            try {
                if (i2 == 0) {
                    downloadTask = this.b.get(i);
                } else {
                    SparseArray<DownloadTask> sparseArray = this.g.get(i);
                    if (sparseArray != null) {
                        downloadTask = sparseArray.get(i2);
                    }
                }
                if (downloadTask == null) {
                    return;
                }
                a(message.what, baseException, downloadTask);
                a(i, i2, message.what);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
