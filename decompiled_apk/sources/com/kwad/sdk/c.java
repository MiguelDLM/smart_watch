package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.r;
import com.kwad.framework.filedownloader.services.c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.k;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes11.dex */
public final class c {
    private com.kwad.sdk.a alk;
    private d alm;
    private Context mContext;
    private final Map<Integer, DownloadTask> ali = new ConcurrentHashMap();
    private final Map<String, Integer> alj = new ConcurrentHashMap();
    private boolean all = false;

    /* loaded from: classes11.dex */
    public static final class a {
        private static final c alp = new c();
    }

    private void bT(int i) {
        DownloadTask downloadTask = this.ali.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    public static void bW(String str) {
        if (str == null) {
            return;
        }
        q.delete(com.kwad.framework.filedownloader.f.f.bw(str));
        q.delete(str);
    }

    private void h(@NonNull DownloadTask downloadTask) {
        this.ali.remove(Integer.valueOf(downloadTask.getId()));
        this.alj.remove(downloadTask.getUrl());
    }

    public static c yq() {
        return a.alp;
    }

    public static boolean yt() {
        try {
            Class.forName("com.kwad.sdk.api.proxy.app.BaseFragmentActivity.RequestInstallPermissionActivity");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void yu() {
        k.a aVar;
        try {
            aVar = new k.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.vS().b(new c.b().bH(Integer.MAX_VALUE).a(aVar));
            this.all = true;
        }
    }

    private static void yv() {
        k.a aVar;
        try {
            aVar = new k.a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.vS().b(new c.b().bH(Integer.MAX_VALUE).a(aVar));
        }
    }

    public final int a(@NonNull DownloadTask.DownloadRequest downloadRequest, com.kwad.sdk.a aVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            yu();
        } else if (this.all) {
            yv();
        }
        if (this.ali.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            bT(downloadTask.getId());
        } else {
            this.ali.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.alj.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
        }
        a(downloadTask.getId(), null, this.alk);
        return downloadTask.getId();
    }

    public final DownloadTask bS(int i) {
        return this.ali.get(Integer.valueOf(i));
    }

    public final void bU(int i) {
        DownloadTask bS = bS(i);
        if (bS == null) {
            return;
        }
        if (bS.isUserPause()) {
            resume(i);
        } else {
            pause(i);
        }
    }

    public final void cancel(int i) {
        DownloadTask downloadTask = this.ali.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.cancel();
            h(downloadTask);
        }
    }

    public final void g(DownloadTask downloadTask) {
        final String bx = ae.bx(downloadTask.getUrl());
        al.a(downloadTask.getTargetFilePath(), new al.a() { // from class: com.kwad.sdk.c.2
            @Override // com.kwad.sdk.utils.al.a
            public final void d(Throwable th) {
                com.kwad.sdk.core.download.b.DO().f(bx, th);
            }

            @Override // com.kwad.sdk.utils.al.a
            public final void oK() {
                com.kwad.sdk.core.download.b.DO().dO(bx);
            }
        });
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final void init(@NonNull Context context) {
        this.mContext = context;
        r.a(context, new c.b().bH(Integer.MAX_VALUE).a(new c.a() { // from class: com.kwad.sdk.c.1
            @Override // com.kwad.framework.filedownloader.services.c.a
            public final c.b vY() {
                try {
                    k.a aVar = new k.a(false);
                    aVar.bh("");
                    return aVar;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }));
    }

    public final void pause(int i) {
        DownloadTask downloadTask = this.ali.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public final void resume(int i) {
        a(i, (DownloadTask.DownloadRequest) null);
    }

    public final File yr() {
        return ax.cZ(this.mContext);
    }

    public final d ys() {
        if (this.alm == null) {
            this.alm = new com.kwad.sdk.core.download.b.a();
        }
        return this.alm;
    }

    public final boolean yw() {
        Iterator<Map.Entry<Integer, DownloadTask>> it = this.ali.entrySet().iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                DownloadTask value = it.next().getValue();
                if (value != null) {
                    int status = value.getStatus();
                    if (status != -2 && status != 1 && status != 2 && status != 3 && status != 5 && status != 6 && status != 10 && status != 11 && Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > 120000) {
                        z = true;
                    }
                }
            }
            return z;
        }
    }

    private void a(int i, com.kwad.sdk.a... aVarArr) {
        DownloadTask downloadTask = this.ali.get(Integer.valueOf(i));
        if (downloadTask != null) {
            for (int i2 = 0; i2 < 2; i2++) {
                com.kwad.sdk.a aVar = aVarArr[i2];
                if (aVar != null) {
                    aVar.setId(i);
                    downloadTask.addListener(aVar);
                }
            }
        }
    }

    public final void a(com.kwad.sdk.a aVar) {
        this.alk = aVar;
    }

    private void a(int i, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.ali.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }
}
