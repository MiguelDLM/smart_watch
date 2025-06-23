package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.appdownloader.c.o;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes13.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f26163a = "d";
    private static volatile d b = null;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;
    private String c;
    private String d;
    private Future i;
    private int j;
    private com.ss.android.socialbase.appdownloader.c.c m;
    private com.ss.android.socialbase.appdownloader.c.d n;
    private com.ss.android.socialbase.appdownloader.c.h o;
    private com.ss.android.socialbase.appdownloader.c.g p;
    private m q;
    private com.ss.android.socialbase.appdownloader.c.f r;
    private j s;
    private ad t;
    private ag u;
    private o v;
    private DownloadReceiver e = new DownloadReceiver();
    private boolean k = false;
    private boolean l = false;

    private d() {
    }

    public static d j() {
        if (b == null) {
            synchronized (d.class) {
                try {
                    if (b == null) {
                        b = new d();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        synchronized (this.e) {
            if (g) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
                intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme("file");
                com.ss.android.socialbase.downloader.downloader.c.O().registerReceiver(this.e, intentFilter);
                com.ss.android.socialbase.downloader.downloader.c.O().registerReceiver(this.e, intentFilter2);
                g = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.ss.android.socialbase.downloader.c.a.b(f26163a, "registerDownloadReceiver mIsRegistered:" + g);
        }
    }

    private void t() {
        r.a(new r.b() { // from class: com.ss.android.socialbase.appdownloader.d.3
            @Override // com.ss.android.socialbase.downloader.impls.r.b
            public void a(DownloadInfo downloadInfo, long j, boolean z, int i) {
                RetryJobSchedulerService.a(downloadInfo, j, z, i);
            }
        });
    }

    public com.ss.android.socialbase.appdownloader.c.h c() {
        return this.o;
    }

    public String d() {
        return this.d;
    }

    public com.ss.android.socialbase.appdownloader.c.f e() {
        return this.r;
    }

    public boolean f() {
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("package_flag_config", 1) == 1) {
            return true;
        }
        return false;
    }

    public j g() {
        return this.s;
    }

    public File h() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).getGlobalSaveDir();
    }

    public String i() {
        return this.c;
    }

    public void k() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(f26163a, "disable app install receiver");
            return;
        }
        synchronized (this.e) {
            try {
                if (h) {
                    return;
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme("package");
                    com.ss.android.socialbase.downloader.downloader.c.O().registerReceiver(this.e, intentFilter);
                    h = true;
                    o oVar = this.v;
                    if (oVar != null) {
                        oVar.a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                com.ss.android.socialbase.downloader.c.a.b(f26163a, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + g);
            } finally {
                b(0);
            }
        }
    }

    public void l() {
        o oVar;
        synchronized (this.e) {
            try {
                if (g) {
                    com.ss.android.socialbase.downloader.downloader.c.O().unregisterReceiver(this.e);
                    if (h && (oVar = this.v) != null) {
                        oVar.b();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            g = false;
            h = false;
        }
        com.ss.android.socialbase.downloader.c.a.b(f26163a, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    public m m() {
        return this.q;
    }

    public com.ss.android.socialbase.appdownloader.c.g n() {
        return this.p;
    }

    public com.ss.android.socialbase.downloader.downloader.r o() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).getReserveWifiStatusListener();
    }

    public ad p() {
        return this.t;
    }

    public ag q() {
        return this.u;
    }

    private void c(Context context) {
        if (context == null || f) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.e.a("application/vnd.android.package-archive");
        com.ss.android.socialbase.downloader.downloader.c.a(context);
        com.ss.android.socialbase.downloader.downloader.c.a(new com.ss.android.socialbase.appdownloader.d.b());
        if (this.l) {
            com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.s();
                }
            }, 5L, TimeUnit.SECONDS);
        } else {
            s();
        }
        t();
        f = true;
    }

    public com.ss.android.socialbase.appdownloader.c.d b() {
        return this.n;
    }

    public com.ss.android.socialbase.appdownloader.c.c a() {
        return this.m;
    }

    public void b(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).setDefaultSavePath(str);
    }

    private void b(int i) {
        this.j = com.ss.android.socialbase.downloader.g.a.c().a("app_install_keep_receiver_time_s", 60);
        com.ss.android.socialbase.downloader.c.a.b(f26163a, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.j);
        if (this.j <= 0) {
            return;
        }
        if (i > 0) {
            this.j = i;
        }
        Future future = this.i;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.i = com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.c.a.b(d.f26163a, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                d.this.l();
                d.this.s();
            }
        }, this.j, TimeUnit.SECONDS);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d = str;
    }

    public void a(j jVar) {
        this.s = jVar;
    }

    @Deprecated
    public void a(Context context, String str, com.ss.android.socialbase.appdownloader.c.c cVar, com.ss.android.socialbase.appdownloader.c.d dVar, com.ss.android.socialbase.appdownloader.c.h hVar) {
        if (cVar != null) {
            this.m = cVar;
        }
        if (dVar != null) {
            this.n = dVar;
        }
        if (hVar != null) {
            this.o = hVar;
        }
        c(context);
    }

    public static boolean a(Context context, int i) {
        return c.a(context, i, true) == 1;
    }

    private DownloadInfo b(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public void a(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    break;
                case -3:
                    c.a(context, i, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i);
                    break;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DownloadInfo> b(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:34|(1:36)|37|(2:41|42)|45|(1:113)(1:52)|53|(2:59|(1:61)(19:62|63|(1:65)|66|(3:68|(2:71|69)|72)|73|74|75|(1:77)(1:110)|78|79|(6:84|(1:107)(1:88)|89|(1:93)|(1:(1:105)(1:104))|106)|108|(1:86)|107|89|(2:91|93)|(0)|106))|112|63|(0)|66|(0)|73|74|75|(0)(0)|78|79|(8:81|84|(0)|107|89|(0)|(0)|106)|108|(0)|107|89|(0)|(0)|106) */
    /* JADX WARN: Removed duplicated region for block: B:110:0x017d A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:75:0x0171, B:77:0x0177, B:78:0x0182, B:110:0x017d), top: B:74:0x0171 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014a A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0011, B:10:0x0024, B:13:0x002d, B:15:0x003b, B:16:0x0047, B:18:0x004f, B:19:0x0058, B:22:0x005f, B:24:0x006b, B:27:0x0077, B:29:0x0085, B:30:0x0089, B:32:0x0090, B:34:0x0099, B:37:0x00a4, B:39:0x00b9, B:45:0x00d3, B:48:0x00ec, B:50:0x00f2, B:53:0x0103, B:55:0x0109, B:57:0x010f, B:59:0x0115, B:61:0x011b, B:62:0x012a, B:63:0x0144, B:65:0x014a, B:66:0x014f, B:68:0x0159, B:69:0x015d, B:71:0x0163, B:73:0x016d, B:79:0x0198, B:81:0x019e, B:86:0x01aa, B:88:0x01b7, B:89:0x01c7, B:91:0x0343, B:93:0x034d, B:96:0x0358, B:98:0x035e, B:100:0x0364, B:102:0x036e, B:104:0x0374, B:105:0x0384), top: B:5:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0159 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0011, B:10:0x0024, B:13:0x002d, B:15:0x003b, B:16:0x0047, B:18:0x004f, B:19:0x0058, B:22:0x005f, B:24:0x006b, B:27:0x0077, B:29:0x0085, B:30:0x0089, B:32:0x0090, B:34:0x0099, B:37:0x00a4, B:39:0x00b9, B:45:0x00d3, B:48:0x00ec, B:50:0x00f2, B:53:0x0103, B:55:0x0109, B:57:0x010f, B:59:0x0115, B:61:0x011b, B:62:0x012a, B:63:0x0144, B:65:0x014a, B:66:0x014f, B:68:0x0159, B:69:0x015d, B:71:0x0163, B:73:0x016d, B:79:0x0198, B:81:0x019e, B:86:0x01aa, B:88:0x01b7, B:89:0x01c7, B:91:0x0343, B:93:0x034d, B:96:0x0358, B:98:0x035e, B:100:0x0364, B:102:0x036e, B:104:0x0374, B:105:0x0384), top: B:5:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0177 A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:75:0x0171, B:77:0x0177, B:78:0x0182, B:110:0x017d), top: B:74:0x0171 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01aa A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0011, B:10:0x0024, B:13:0x002d, B:15:0x003b, B:16:0x0047, B:18:0x004f, B:19:0x0058, B:22:0x005f, B:24:0x006b, B:27:0x0077, B:29:0x0085, B:30:0x0089, B:32:0x0090, B:34:0x0099, B:37:0x00a4, B:39:0x00b9, B:45:0x00d3, B:48:0x00ec, B:50:0x00f2, B:53:0x0103, B:55:0x0109, B:57:0x010f, B:59:0x0115, B:61:0x011b, B:62:0x012a, B:63:0x0144, B:65:0x014a, B:66:0x014f, B:68:0x0159, B:69:0x015d, B:71:0x0163, B:73:0x016d, B:79:0x0198, B:81:0x019e, B:86:0x01aa, B:88:0x01b7, B:89:0x01c7, B:91:0x0343, B:93:0x034d, B:96:0x0358, B:98:0x035e, B:100:0x0364, B:102:0x036e, B:104:0x0374, B:105:0x0384), top: B:5:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0343 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0011, B:10:0x0024, B:13:0x002d, B:15:0x003b, B:16:0x0047, B:18:0x004f, B:19:0x0058, B:22:0x005f, B:24:0x006b, B:27:0x0077, B:29:0x0085, B:30:0x0089, B:32:0x0090, B:34:0x0099, B:37:0x00a4, B:39:0x00b9, B:45:0x00d3, B:48:0x00ec, B:50:0x00f2, B:53:0x0103, B:55:0x0109, B:57:0x010f, B:59:0x0115, B:61:0x011b, B:62:0x012a, B:63:0x0144, B:65:0x014a, B:66:0x014f, B:68:0x0159, B:69:0x015d, B:71:0x0163, B:73:0x016d, B:79:0x0198, B:81:0x019e, B:86:0x01aa, B:88:0x01b7, B:89:0x01c7, B:91:0x0343, B:93:0x034d, B:96:0x0358, B:98:0x035e, B:100:0x0364, B:102:0x036e, B:104:0x0374, B:105:0x0384), top: B:5:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0356  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(com.ss.android.socialbase.appdownloader.f r22) {
        /*
            Method dump skipped, instructions count: 969
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.d.a(com.ss.android.socialbase.appdownloader.f):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b())) {
                    if (cVar.a().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(cVar.a(), cVar.b()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("User-Agent", com.ss.android.socialbase.appdownloader.b.a.f26157a));
        }
        return arrayList;
    }

    public String a(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(com.huawei.hms.ads.dynamicloader.b.b) || c.c(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    private z a(final com.ss.android.socialbase.appdownloader.c.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.appdownloader.d.6
            @Override // com.ss.android.socialbase.downloader.depend.z
            public void a(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            eVar.a(i, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            eVar.a(com.ss.android.socialbase.downloader.downloader.c.O(), str);
                            return;
                        case 10:
                            eVar.a(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                eVar.a(i, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean a(boolean z) {
                return eVar.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public String a() {
                return eVar.a();
            }
        };
    }

    public DownloadInfo a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo a2 = a(context, str, h());
                if (a2 == null) {
                    a2 = a(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a2 == null) {
                    a2 = a(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a2 == null) {
                    a2 = a(context, str, context.getFilesDir());
                }
                return (a2 == null && com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) ? b(context, str) : a2;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.c.a.b(f26163a, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo a(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> a(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public void a(com.ss.android.socialbase.appdownloader.c.g gVar) {
        this.p = gVar;
    }

    public void a(com.ss.android.socialbase.downloader.downloader.r rVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).setReserveWifiStatusListener(rVar);
    }

    public void a(ad adVar) {
        this.t = adVar;
    }

    public void a(ag agVar) {
        this.u = agVar;
    }

    public void a(int i) {
        if (com.ss.android.socialbase.downloader.g.a.c().a("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        k();
        b(i);
    }

    public void a(o oVar) {
        this.v = oVar;
    }

    public void a(boolean z) {
        this.l = z;
    }
}
