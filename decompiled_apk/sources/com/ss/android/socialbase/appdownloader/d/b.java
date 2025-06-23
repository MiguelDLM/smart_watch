package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes13.dex */
public class b implements l {

    /* renamed from: a, reason: collision with root package name */
    private List<Integer> f26172a;
    private BroadcastReceiver b;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g n = d.j().n();
        if (n != null) {
            n.a(list);
        }
        Context O = c.O();
        if (O == null) {
            return;
        }
        boolean b = f.b(O);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            a(O, it.next(), b, i);
        }
        List<Integer> list2 = this.f26172a;
        if (list2 == null || list2.isEmpty() || this.b != null) {
            return;
        }
        this.b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (!f.b(applicationContext)) {
                    return;
                }
                com.ss.android.socialbase.downloader.c.a.b("LaunchResume", "onReceive : wifi connected !!!");
                c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (b.this.f26172a != null && !b.this.f26172a.isEmpty()) {
                                int size = b.this.f26172a.size();
                                Integer[] numArr = new Integer[size];
                                b.this.f26172a.toArray(numArr);
                                b.this.f26172a.clear();
                                for (int i2 = 0; i2 < size; i2++) {
                                    DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                    if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                        b.this.a(applicationContext, downloadInfo, true, 2);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                try {
                    applicationContext.unregisterReceiver(b.this.b);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                b.this.b = null;
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            O.registerReceiver(this.b, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.b = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<String> a() {
        return com.ss.android.socialbase.appdownloader.c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(final List<DownloadInfo> list, final int i) {
        if (f.d()) {
            c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.b(list, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            b(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, DownloadInfo downloadInfo, boolean z, int i) {
        int i2;
        if (downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        boolean z2 = false;
        if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
            com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            int a3 = a2.a("failed_resume_max_count", 0);
            double a4 = a2.a("failed_resume_max_hours", 72.0d);
            double a5 = a2.a("failed_resume_min_hours", 12.0d);
            long currentTimeMillis = System.currentTimeMillis();
            boolean z3 = downloadInfo.getFailedResumeCount() < a3 && ((double) (currentTimeMillis - downloadInfo.getLastDownloadTime())) < a4 * 3600000.0d && ((double) (currentTimeMillis - downloadInfo.getLastFailedResumeTime())) > a5 * 3600000.0d;
            if (downloadInfo.isPauseReserveOnWifi() && z) {
                z3 = true;
            }
            if (z3) {
                boolean z4 = a2.a("failed_resume_need_wifi", 1) == 1;
                boolean z5 = a2.a("failed_resume_need_wait_wifi", 0) == 1;
                if (!z && z4 && z5) {
                    if (this.f26172a == null) {
                        this.f26172a = new ArrayList();
                    }
                    int id = downloadInfo.getId();
                    if (!this.f26172a.contains(Integer.valueOf(id))) {
                        this.f26172a.add(Integer.valueOf(id));
                    }
                    downloadInfo.setOnlyWifi(true);
                    r.a().a(downloadInfo);
                } else {
                    com.ss.android.socialbase.appdownloader.c.a(downloadInfo, true, z4);
                    downloadInfo.setLastFailedResumeTime(currentTimeMillis);
                    downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                    downloadInfo.updateSpData();
                    if (downloadInfo.isPauseReserveOnWifi() && z) {
                        downloadInfo.setDownloadFromReserveWifi(true);
                        com.ss.android.socialbase.downloader.downloader.r o = d.j().o();
                        if (o != null) {
                            o.a(downloadInfo, 5, i);
                        }
                    }
                    z2 = true;
                }
            }
            com.ss.android.socialbase.downloader.c.a.c("LaunchResume", "launchResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
            g n = d.j().n();
            if (n != null) {
                n.a(downloadInfo, z2);
                return;
            }
            return;
        }
        if (realStatus != -3 || !a(downloadInfo)) {
            if (realStatus == -2) {
                if (!downloadInfo.isPauseReserveOnWifi()) {
                    a(downloadInfo, context);
                    return;
                }
                if (z) {
                    com.ss.android.socialbase.appdownloader.c.a(downloadInfo, true, true);
                    downloadInfo.updateSpData();
                    downloadInfo.setDownloadFromReserveWifi(true);
                    g n2 = d.j().n();
                    if (n2 != null) {
                        n2.a(downloadInfo, true);
                    }
                    com.ss.android.socialbase.downloader.downloader.r o2 = d.j().o();
                    if (o2 != null) {
                        o2.a(downloadInfo, 5, i);
                        return;
                    }
                    return;
                }
                if (this.f26172a == null) {
                    this.f26172a = new ArrayList();
                }
                int id2 = downloadInfo.getId();
                if (!this.f26172a.contains(Integer.valueOf(id2))) {
                    this.f26172a.add(Integer.valueOf(id2));
                }
                r.a().a(downloadInfo);
                a(downloadInfo, context);
                return;
            }
            return;
        }
        com.ss.android.socialbase.downloader.g.a a6 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        if (com.ss.android.socialbase.appdownloader.c.a(context, downloadInfo)) {
            return;
        }
        int a7 = a6.a("uninstall_resume_max_count", 0);
        double a8 = a6.a("uninstall_resume_max_hours", 72.0d);
        double a9 = a6.a("uninstall_resume_min_hours", 12.0d);
        long currentTimeMillis2 = System.currentTimeMillis();
        boolean z6 = downloadInfo.getUninstallResumeCount() < a7 && ((double) (currentTimeMillis2 - downloadInfo.getLastDownloadTime())) < a8 * 3600000.0d && ((double) (currentTimeMillis2 - downloadInfo.getLastUninstallResumeTime())) > a9 * 3600000.0d;
        com.ss.android.socialbase.downloader.c.a.c("LaunchResume", "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z6);
        if (z6) {
            com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
            if (e == null) {
                i2 = 1;
                com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.b.a().a(aVar);
                e = aVar;
            } else {
                i2 = 1;
                e.a(downloadInfo);
            }
            e.b(downloadInfo.getTotalBytes());
            e.a(downloadInfo.getTotalBytes());
            e.a(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setLastUninstallResumeTime(currentTimeMillis2);
            downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + i2);
            downloadInfo.updateSpData();
        }
    }

    private void a(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        int a3 = a2.a("paused_resume_max_count", 0);
        double a4 = a2.a("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount >= a3 || System.currentTimeMillis() - downloadInfo.getLastDownloadTime() >= a4 * 3600000.0d) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
        if (e == null) {
            e = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
            com.ss.android.socialbase.downloader.notification.b.a().a(e);
        } else {
            e.a(downloadInfo);
        }
        e.b(downloadInfo.getTotalBytes());
        e.a(downloadInfo.getCurBytes());
        e.a(downloadInfo.getStatus(), null, false, false);
        downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
        downloadInfo.updateSpData();
    }

    private boolean a(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("uninstall_can_not_resume_for_force_task", false)) {
            return f.a(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
