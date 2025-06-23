package com.kwad.framework.filedownloader.services;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class h {
    private ThreadPoolExecutor aiS;
    private int aiU;
    private SparseArray<DownloadLaunchRunnable> aiR = new SparseArray<>();
    private final String aiT = "Network";
    private int aiV = 0;

    public h(int i) {
        this.aiS = com.kwad.framework.filedownloader.f.b.q(i, "Network");
        this.aiU = i;
    }

    private synchronized void xj() {
        try {
            SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
            int size = this.aiR.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.aiR.keyAt(i);
                DownloadLaunchRunnable downloadLaunchRunnable = this.aiR.get(keyAt);
                if (downloadLaunchRunnable.isAlive()) {
                    sparseArray.put(keyAt, downloadLaunchRunnable);
                }
            }
            this.aiR = sparseArray;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.wc();
        synchronized (this) {
            this.aiR.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.aiS.execute(downloadLaunchRunnable);
        int i = this.aiV;
        if (i >= 600) {
            xj();
            this.aiV = 0;
        } else {
            this.aiV = i + 1;
        }
    }

    public final boolean bK(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.aiR.get(i);
        if (downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive()) {
            return true;
        }
        return false;
    }

    public final synchronized boolean bx(int i) {
        if (xk() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int bL = com.kwad.framework.filedownloader.f.e.bL(i);
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.aiU), Integer.valueOf(bL));
        }
        List<Runnable> shutdownNow = this.aiS.shutdownNow();
        this.aiS = com.kwad.framework.filedownloader.f.b.q(bL, "Network");
        if (shutdownNow.size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.aiU = bL;
        return true;
    }

    public final void cancel(int i) {
        xj();
        synchronized (this) {
            try {
                DownloadLaunchRunnable downloadLaunchRunnable = this.aiR.get(i);
                if (downloadLaunchRunnable != null) {
                    downloadLaunchRunnable.pause();
                    boolean remove = this.aiS.remove(downloadLaunchRunnable);
                    if (com.kwad.framework.filedownloader.f.d.ajb) {
                        com.kwad.framework.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                    }
                }
                this.aiR.remove(i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int o(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.aiR.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadLaunchRunnable valueAt = this.aiR.valueAt(i2);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i && str.equals(valueAt.wh())) {
                return valueAt.getId();
            }
        }
        return 0;
    }

    public final synchronized int xk() {
        xj();
        return this.aiR.size();
    }

    public final synchronized List<Integer> xl() {
        ArrayList arrayList;
        xj();
        arrayList = new ArrayList();
        for (int i = 0; i < this.aiR.size(); i++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.aiR;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i)).getId()));
        }
        return arrayList;
    }
}
