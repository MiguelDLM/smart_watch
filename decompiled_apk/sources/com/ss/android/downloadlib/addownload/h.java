package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.g.j;
import com.ss.android.downloadlib.g.n;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class h implements n.a {

    /* renamed from: a, reason: collision with root package name */
    public com.ss.android.downloadlib.addownload.b.e f26049a;
    private long b;
    private boolean c = false;
    private e d;
    private b e;

    /* loaded from: classes11.dex */
    public static class a extends com.ss.android.socialbase.downloader.depend.a {

        /* renamed from: a, reason: collision with root package name */
        private com.ss.android.downloadlib.g.n f26053a;

        public a(com.ss.android.downloadlib.g.n nVar) {
            this.f26053a = nVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.a, com.ss.android.socialbase.downloader.depend.s
        public void a(DownloadInfo downloadInfo) {
            a(downloadInfo, 11);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            a(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            a(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            a(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            a(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            a(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            a(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            a(downloadInfo, -3);
        }

        private void a(DownloadInfo downloadInfo, int i) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i;
            this.f26053a.sendMessage(obtain);
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(DownloadInfo downloadInfo);
    }

    public h(e eVar) {
        this.d = eVar;
    }

    private boolean c() {
        return d() && e();
    }

    private boolean d() {
        DownloadModel downloadModel = this.f26049a.b;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.f26049a.b.getDownloadUrl())) ? false : true;
    }

    private boolean e() {
        return this.f26049a.d.isAddToDownloadManage();
    }

    private boolean f() {
        return com.ss.android.downloadlib.g.m.a(this.f26049a.b) && i.a(this.f26049a.d.getLinkMode());
    }

    @Override // com.ss.android.downloadlib.g.n.a
    public void a(Message message) {
    }

    public void b(@Nullable DownloadInfo downloadInfo) {
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(downloadInfo);
            this.e = null;
        }
    }

    private boolean e(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.g.m.a(this.f26049a.b) && f(downloadInfo);
    }

    private boolean f(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.i.f.d(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    public void c(DownloadInfo downloadInfo) {
        if (!i.a(this.f26049a.b) || this.c) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("file_status", (downloadInfo == null || !com.ss.android.downloadlib.g.m.b(downloadInfo.getTargetFilePath())) ? 2 : 1, this.f26049a);
        this.c = true;
    }

    public void a(long j) {
        this.b = j;
        com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        this.f26049a = e;
        if (e.x()) {
            com.ss.android.downloadlib.e.c.a().a("setAdId ModelBox notValid");
        }
    }

    private void b(final t tVar) {
        String str;
        if (com.ss.android.downloadlib.g.j.b(com.kuaishou.weapon.p0.g.j)) {
            if (tVar != null) {
                tVar.a();
                return;
            }
            return;
        }
        if (com.ss.android.downloadlib.g.m.a()) {
            str = "android.permission.READ_MEDIA_IMAGES";
            if (com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_VIDEO")) {
                if (tVar != null) {
                    tVar.a();
                    return;
                }
                return;
            }
        } else {
            str = com.kuaishou.weapon.p0.g.i;
        }
        com.ss.android.downloadlib.g.j.a(new String[]{str}, new j.a() { // from class: com.ss.android.downloadlib.addownload.h.2
            @Override // com.ss.android.downloadlib.g.j.a
            public void a() {
                t tVar2 = tVar;
                if (tVar2 != null) {
                    tVar2.a();
                }
            }

            @Override // com.ss.android.downloadlib.g.j.a
            public void a(String str2) {
                t tVar2 = tVar;
                if (tVar2 != null) {
                    tVar2.a(str2);
                }
            }
        });
    }

    public boolean d(DownloadInfo downloadInfo) {
        return f() || e(downloadInfo);
    }

    public void a(DownloadInfo downloadInfo) {
        this.c = false;
        b(downloadInfo);
    }

    public boolean a(Context context, int i, boolean z) {
        if (com.ss.android.downloadlib.g.m.a(this.f26049a.b)) {
            com.ss.android.downloadad.api.a.b d = com.ss.android.downloadlib.addownload.b.f.a().d(this.f26049a.f25969a);
            if (d != null) {
                com.ss.android.socialbase.downloader.notification.b.a().f(d.s());
            }
            return com.ss.android.downloadlib.b.a.a(this.f26049a);
        }
        if (a(i) && !TextUtils.isEmpty(this.f26049a.b.getPackageName()) && k.j().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.b.a.a(this.f26049a, i)) {
                return true;
            }
            return this.d.i() && this.d.d(true);
        }
        if (!z || this.f26049a.d.getDownloadMode() != 4 || this.d.e()) {
            return false;
        }
        this.d.c(true);
        return true;
    }

    @Nullable
    public String b() {
        File externalFilesDir = k.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    @NonNull
    public static List<com.ss.android.download.api.download.a> b(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.a) {
                    arrayList.add((com.ss.android.download.api.download.a) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a) {
                            arrayList.add((com.ss.android.download.api.download.a) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.a) {
                            arrayList.add((com.ss.android.download.api.download.a) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean a(int i) {
        if (this.f26049a.d.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.f26049a.d.getDownloadMode() == 2 && i == 1 && k.j().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean a(int i, DownloadModel downloadModel) {
        return com.ss.android.socialbase.appdownloader.f.e.c() && a(i) && !com.ss.android.downloadlib.g.m.a(downloadModel);
    }

    public boolean a(boolean z) {
        return !z && this.f26049a.d.getDownloadMode() == 1;
    }

    public void a(@NonNull final t tVar) {
        if (!TextUtils.isEmpty(this.f26049a.b.getFilePath())) {
            String filePath = this.f26049a.b.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                tVar.a();
                return;
            } else {
                try {
                    if (filePath.startsWith(k.a().getExternalCacheDir().getParent())) {
                        tVar.a();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
        }
        b(new t() { // from class: com.ss.android.downloadlib.addownload.h.1
            @Override // com.ss.android.download.api.config.t
            public void a() {
                tVar.a();
            }

            @Override // com.ss.android.download.api.config.t
            public void a(String str) {
                k.d().a(1, k.a(), h.this.f26049a.b, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.d.a.a().b(h.this.b, 1);
                tVar.a(str);
            }
        });
    }

    public void a(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        b bVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i = message.arg1;
        if (i != 1 && i != 6 && i == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.g a2 = com.ss.android.downloadlib.g.a();
                com.ss.android.downloadlib.addownload.b.e eVar = this.f26049a;
                a2.a(eVar.b, eVar.d, eVar.c);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.d.a.a().a(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        j.a(downloadShortInfo);
        int a3 = com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) && (bVar = this.e) != null) {
            bVar.a(downloadInfo);
            this.e = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : a(map)) {
            if (a3 != 1) {
                if (a3 == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, j.a(downloadInfo.getId(), curBytes));
                } else if (a3 == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.g.m.a(this.f26049a.b)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, j.a(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.ss.android.download.api.download.a> it = b(map).iterator();
                while (it.hasNext()) {
                    it.next().a(downloadInfo);
                }
            }
        }
    }

    public void a() {
        if (this.e == null) {
            this.e = new b() { // from class: com.ss.android.downloadlib.addownload.h.3
                @Override // com.ss.android.downloadlib.addownload.h.b
                public void a(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.d.a.a().a(h.this.b, 2, downloadInfo);
                }
            };
        }
    }

    public int a(Context context, IDownloadListener iDownloadListener) {
        com.ss.android.downloadlib.addownload.c.a aVar;
        com.ss.android.socialbase.downloader.model.c a2;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.f26049a.b.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (k.j().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.f26049a.b.getLogExtra()) && (a2 = a(this.f26049a.b.getLogExtra())) != null) {
            arrayList.add(a2);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(entry.getKey(), entry.getValue()));
                }
            }
        }
        String a3 = com.ss.android.downloadlib.g.d.a(String.valueOf(this.f26049a.b.getId()), this.f26049a.b.getNotificationJumpUrl(), this.f26049a.b.isShowToast(), String.valueOf(this.f26049a.b.getModelType()));
        com.ss.android.socialbase.downloader.g.a b2 = com.ss.android.downloadlib.g.e.b(this.f26049a.b);
        JSONObject a4 = com.ss.android.downloadlib.g.e.a(this.f26049a.b);
        if (!this.f26049a.d.enableAH()) {
            a4 = com.ss.android.downloadlib.g.m.a(a4);
            com.ss.android.downloadlib.g.m.a(a4, "ah_plans", new JSONArray());
        }
        int executorGroup = this.f26049a.b.getExecutorGroup();
        if (this.f26049a.b.isAd() || i.b(this.f26049a.b)) {
            executorGroup = 4;
        }
        String a5 = a(b2);
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.c.a(this.f26049a.b.getDownloadUrl(), a5));
        if (downloadInfo != null && 3 == this.f26049a.b.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.f o = new com.ss.android.socialbase.appdownloader.f(context, this.f26049a.b.getDownloadUrl()).b(this.f26049a.b.getBackupUrls()).a(this.f26049a.b.getName()).e(a3).a(arrayList).a(this.f26049a.b.isShowNotification()).c(this.f26049a.b.isNeedWifi()).b(this.f26049a.b.getFileName()).c(a5).k(this.f26049a.b.getAppIcon()).h(this.f26049a.b.getMd5()).j(this.f26049a.b.getSdkMonitorScene()).a(this.f26049a.b.getExpectFileLength()).a(iDownloadListener).l(this.f26049a.b.needIndependentProcess() || b2.a("need_independent_process", 0) == 1).a(this.f26049a.b.getDownloadFileUriProvider()).b(this.f26049a.b.autoInstallWithoutNotification()).g(this.f26049a.b.getPackageName()).d(1000).e(100).a(a4).i(true).j(true).b(b2.a("retry_count", 5)).c(b2.a("backup_url_retry_count", 0)).j(true).m(b2.a("need_head_connection", 0) == 1).d(b2.a("need_https_to_http_retry", 0) == 1).h(b2.a("need_chunk_downgrade_retry", 1) == 1).g(b2.a("need_retry_delay", 0) == 1).i(b2.c("retry_delay_time_array")).k(b2.a("need_reuse_runnable", 0) == 1).f(executorGroup).p(this.f26049a.b.isAutoInstall()).o(this.f26049a.b.distinctDir());
        if (!TextUtils.isEmpty(this.f26049a.b.getMimeType())) {
            o.f(this.f26049a.b.getMimeType());
        } else {
            o.f("application/vnd.android.package-archive");
        }
        if (b2.a("notification_opt_2", 0) == 1) {
            o.a(false);
            o.b(true);
        }
        if (b2.a("clear_space_use_disk_handler", 0) == 1) {
            aVar = new com.ss.android.downloadlib.addownload.c.a();
            o.a(aVar);
        } else {
            aVar = null;
        }
        DownloadModel downloadModel = this.f26049a.b;
        if ((downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) downloadModel).getTaskKey())) {
            o.d(((AdDownloadModel) this.f26049a.b).getTaskKey());
        }
        int a6 = i.a(this.f26049a, c(), o);
        if (aVar != null) {
            aVar.a(a6);
        }
        return a6;
    }

    private String a(com.ss.android.socialbase.downloader.g.a aVar) {
        boolean z;
        String str;
        if (!TextUtils.isEmpty(this.f26049a.b.getFilePath())) {
            return this.f26049a.b.getFilePath();
        }
        DownloadInfo a2 = com.ss.android.socialbase.appdownloader.d.j().a(k.a(), this.f26049a.b.getDownloadUrl());
        if (!com.ss.android.downloadlib.g.m.a()) {
            z = com.ss.android.downloadlib.g.j.b(com.kuaishou.weapon.p0.g.j);
        } else {
            z = com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_VIDEO");
        }
        String b2 = b();
        if (a2 != null && !TextUtils.isEmpty(a2.getSavePath())) {
            String savePath = a2.getSavePath();
            if (z || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(b2)) {
                    if (savePath.startsWith(b2)) {
                        return savePath;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).cancel(a2.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(z ? 1 : 2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("label_external_permission", jSONObject, this.f26049a);
        try {
            str = com.ss.android.socialbase.appdownloader.c.b();
        } catch (Exception unused) {
            str = null;
        }
        int a3 = com.ss.android.downloadlib.g.e.a(aVar);
        if (a3 != 0) {
            if (a3 != 4 && (z || a3 != 2)) {
                if ((a3 == 3 || (!z && a3 == 1)) && !TextUtils.isEmpty(b2)) {
                    return b2;
                }
            } else {
                File filesDir = k.a().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return str;
    }

    public void a(DownloadInfo downloadInfo, boolean z) {
        if (this.f26049a.b == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (i.a(this.f26049a.b)) {
                com.ss.android.downloadlib.d.a.a().a(this.b, 2);
            } else if (z && com.ss.android.downloadlib.d.c.a().c() && (status == -2 || status == -3)) {
                com.ss.android.downloadlib.d.a.a().a(this.b, 2);
            }
        } else {
            com.ss.android.downloadlib.d.a.a().a(this.b, 2);
        }
        switch (status) {
            case -4:
            case -1:
                a();
                com.ss.android.downloadlib.addownload.b.f a2 = com.ss.android.downloadlib.addownload.b.f.a();
                com.ss.android.downloadlib.addownload.b.e eVar = this.f26049a;
                a2.a(new com.ss.android.downloadad.api.a.b(eVar.b, eVar.c, eVar.d, downloadInfo.getId()));
                return;
            case -3:
                if (com.ss.android.downloadlib.g.m.a(this.f26049a.b)) {
                    com.ss.android.downloadlib.e.c.a().b("SUCCESSED isInstalledApp");
                    return;
                }
                com.ss.android.downloadlib.d.a.a().a(this.b, 5, downloadInfo);
                if (z && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.b, this.f26049a.b.getLogExtra())) {
                    com.ss.android.downloadlib.d.a.a().a(this.b, 2);
                    return;
                }
                return;
            case -2:
                com.ss.android.downloadlib.d.a.a().a(this.b, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.b, this.f26049a.b.getLogExtra())) {
                    com.ss.android.downloadlib.d.a.a().a(this.b, 2);
                    return;
                }
                return;
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
                com.ss.android.downloadlib.d.a.a().a(this.b, 3, downloadInfo);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.ss.android.socialbase.downloader.model.DownloadInfo r7, com.ss.android.download.api.model.DownloadShortInfo r8, java.util.List<com.ss.android.download.api.download.DownloadStatusChangeListener> r9) {
        /*
            r6 = this;
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L7
            return
        L7:
            if (r7 == 0) goto La8
            if (r8 != 0) goto Ld
            goto La8
        Ld:
            r0 = 0
            long r1 = r7.getTotalBytes()     // Catch: java.lang.Exception -> L27
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L2b
            long r1 = r7.getCurBytes()     // Catch: java.lang.Exception -> L27
            r3 = 100
            long r1 = r1 * r3
            long r3 = r7.getTotalBytes()     // Catch: java.lang.Exception -> L27
            long r1 = r1 / r3
            int r2 = (int) r1
            goto L2c
        L27:
            r1 = move-exception
            r1.printStackTrace()
        L2b:
            r2 = 0
        L2c:
            if (r2 >= 0) goto L2f
            goto L30
        L2f:
            r0 = r2
        L30:
            r8.updateFromNewDownloadInfo(r7)
            com.ss.android.downloadlib.addownload.j.a(r8)
            java.util.Iterator r9 = r9.iterator()
        L3a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto La7
            java.lang.Object r1 = r9.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r1 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r1
            int r2 = r7.getStatus()
            switch(r2) {
                case -4: goto L92;
                case -3: goto L80;
                case -2: goto L74;
                case -1: goto L70;
                case 0: goto L92;
                case 1: goto L64;
                case 2: goto L64;
                case 3: goto L64;
                case 4: goto L64;
                case 5: goto L64;
                case 6: goto L4d;
                case 7: goto L64;
                case 8: goto L64;
                case 9: goto L4d;
                case 10: goto L4d;
                case 11: goto L4e;
                default: goto L4d;
            }
        L4d:
            goto L3a
        L4e:
            boolean r2 = r1 instanceof com.ss.android.download.api.download.a
            if (r2 == 0) goto L58
            com.ss.android.download.api.download.a r1 = (com.ss.android.download.api.download.a) r1
            r1.a(r7)
            goto L3a
        L58:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.j.a(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L64:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.j.a(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L70:
            r1.onDownloadFailed(r8)
            goto L3a
        L74:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.j.a(r2, r0)
            r1.onDownloadPaused(r8, r2)
            goto L3a
        L80:
            com.ss.android.downloadlib.addownload.b.e r2 = r6.f26049a
            com.ss.android.download.api.download.DownloadModel r2 = r2.b
            boolean r2 = com.ss.android.downloadlib.g.m.a(r2)
            if (r2 == 0) goto L8e
            r1.onInstalled(r8)
            goto L3a
        L8e:
            r1.onDownloadFinished(r8)
            goto L3a
        L92:
            com.ss.android.downloadlib.addownload.b.e r2 = r6.f26049a
            com.ss.android.download.api.download.DownloadModel r2 = r2.b
            boolean r2 = com.ss.android.downloadlib.g.m.a(r2)
            if (r2 == 0) goto La3
            r2 = -3
            r8.status = r2
            r1.onInstalled(r8)
            goto L3a
        La3:
            r1.onIdle()
            goto L3a
        La7:
            return
        La8:
            java.util.Iterator r7 = r9.iterator()
        Lac:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lbc
            java.lang.Object r8 = r7.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r8 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r8
            r8.onIdle()
            goto Lac
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.h.a(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.download.api.model.DownloadShortInfo, java.util.List):void");
    }

    @NonNull
    public static List<DownloadStatusChangeListener> a(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private com.ss.android.socialbase.downloader.model.c a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.model.c("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e) {
            k.u().a(e, "parseLogExtra Error");
            return null;
        }
    }
}
