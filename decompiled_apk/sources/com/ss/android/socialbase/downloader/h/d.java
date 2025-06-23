package com.ss.android.socialbase.downloader.h;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes13.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static ExecutorService f26306a = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("Download_OP_Thread"));
    private int c = 0;
    private volatile SparseArray<c> b = new SparseArray<>();

    public static void a(Runnable runnable) {
        f26306a.execute(runnable);
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.b.size(); i++) {
                int keyAt = this.b.keyAt(i);
                if (!this.b.get(keyAt).d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.b.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void c(int i) {
        synchronized (d.class) {
            try {
                b();
                c cVar = this.b.get(i);
                if (cVar != null) {
                    cVar.a();
                    c(cVar);
                    this.b.remove(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(c cVar) {
        cVar.f();
        synchronized (d.class) {
            try {
                int i = this.c;
                if (i >= 500) {
                    b();
                    this.c = 0;
                } else {
                    this.c = i + 1;
                }
                this.b.put(cVar.e(), cVar);
            } finally {
            }
        }
        DownloadTask c = cVar.c();
        try {
            ExecutorService p = com.ss.android.socialbase.downloader.downloader.c.p();
            if (c != null && c.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(c.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.g.a.c().a("divide_plugin", 1) == 1) {
                    c.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = c.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    p = com.ss.android.socialbase.downloader.downloader.c.n();
                } else if (executorGroup == 4) {
                    p = com.ss.android.socialbase.downloader.downloader.c.o();
                }
            }
            if (p != null) {
                if (com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false)) {
                    cVar.a(p.submit(cVar));
                    return;
                } else {
                    p.execute(cVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.d.a.a(c.getMonitorDepend(), c.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), c.getDownloadInfo() != null ? c.getDownloadInfo().getStatus() : 0);
        } catch (Exception e) {
            if (c != null) {
                com.ss.android.socialbase.downloader.d.a.a(c.getMonitorDepend(), c.getDownloadInfo(), new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(e, "DownloadThreadPoolExecute")), c.getDownloadInfo() != null ? c.getDownloadInfo().getStatus() : 0);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (c != null) {
                com.ss.android.socialbase.downloader.d.a.a(c.getMonitorDepend(), c.getDownloadInfo(), new BaseException(1003, "execute OOM"), c.getDownloadInfo() != null ? c.getDownloadInfo().getStatus() : 0);
            }
            e2.printStackTrace();
        }
    }

    private void c(c cVar) {
        Future g;
        if (cVar == null) {
            return;
        }
        try {
            ExecutorService p = com.ss.android.socialbase.downloader.downloader.c.p();
            DownloadTask c = cVar.c();
            if (c != null && c.getDownloadInfo() != null) {
                int executorGroup = c.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    p = com.ss.android.socialbase.downloader.downloader.c.n();
                } else if (executorGroup == 4) {
                    p = com.ss.android.socialbase.downloader.downloader.c.o();
                }
            }
            if (p == null || !(p instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) p).remove(cVar);
            if (!com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false) || (g = cVar.g()) == null) {
                return;
            }
            g.cancel(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        synchronized (d.class) {
            try {
                if (com.ss.android.socialbase.downloader.i.a.a(524288)) {
                    int indexOfValue = this.b.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.b.removeAt(indexOfValue);
                    }
                } else {
                    this.b.remove(cVar.e());
                }
            } finally {
            }
        }
    }

    public c b(int i) {
        synchronized (d.class) {
            try {
                b();
                c cVar = this.b.get(i);
                if (cVar == null) {
                    return null;
                }
                cVar.b();
                c(cVar);
                this.b.remove(i);
                return cVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean a(int i) {
        synchronized (d.class) {
            try {
                boolean z = false;
                if (this.b != null && this.b.size() > 0) {
                    c cVar = this.b.get(i);
                    if (cVar != null && cVar.d()) {
                        z = true;
                    }
                    return z;
                }
                return false;
            } finally {
            }
        }
    }

    public List<Integer> a() {
        ArrayList arrayList;
        synchronized (d.class) {
            try {
                b();
                arrayList = new ArrayList();
                for (int i = 0; i < this.b.size(); i++) {
                    c cVar = this.b.get(this.b.keyAt(i));
                    if (cVar != null) {
                        arrayList.add(Integer.valueOf(cVar.e()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public void a(int i, long j) {
        c cVar = this.b.get(i);
        if (cVar != null) {
            cVar.c(j);
        }
    }
}
