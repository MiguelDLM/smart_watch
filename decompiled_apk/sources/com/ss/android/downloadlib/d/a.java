package com.ss.android.downloadlib.d;

import android.os.Build;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bb;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.c;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.appdownloader.e.d;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class a {

    /* renamed from: com.ss.android.downloadlib.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C1045a {

        /* renamed from: a, reason: collision with root package name */
        private static a f26097a = new a();
    }

    public static a a() {
        return C1045a.f26097a;
    }

    public void b(long j, int i) {
        a(j, i, (DownloadInfo) null);
    }

    private a() {
    }

    public void a(long j, int i) {
        e e = f.a().e(j);
        if (e.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendClickEvent ModelBox notValid");
            return;
        }
        if (e.c.isEnableClickEvent()) {
            int i2 = 1;
            DownloadEventConfig downloadEventConfig = e.c;
            String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String a2 = m.a(e.c.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(d.a() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.i.f.c(k.a())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(clickItemTag, a2, jSONObject, e);
            if (!"click".equals(a2) || e.b == null) {
                return;
            }
            c.a().a(j, e.b.getLogExtra());
        }
    }

    public void b(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.a.b a2 = f.a().a(downloadInfo);
        if (a2 == null) {
            com.ss.android.downloadlib.e.c.a().a("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (a2.c.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                a2.d(baseException.getErrorCode());
                a2.a(baseException.getErrorMessage());
            }
            a2.y();
            jSONObject.put("download_failed_times", a2.x());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("has_send_download_failed_finally", a2.d.get() ? 1 : 2);
            com.ss.android.downloadlib.g.f.a(a2, jSONObject);
            jSONObject.put("is_update_download", a2.V() ? 1 : 2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(a2.j(), "download_failed", jSONObject, a2);
        i.a().a(a2);
    }

    public void a(long j, int i, DownloadInfo downloadInfo) {
        String a2;
        e e = f.a().e(j);
        if (e.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        m.a(jSONObject, "download_scene", Integer.valueOf(e.t()));
        if (i == 1) {
            a2 = m.a(e.c.getStorageDenyLabel(), "storage_deny");
        } else if (i == 2) {
            a2 = m.a(e.c.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.g.f.a(downloadInfo, jSONObject);
        } else if (i == 3) {
            a2 = m.a(e.c.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.g.f.b(downloadInfo, jSONObject);
        } else if (i == 4) {
            a2 = m.a(e.c.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
        } else if (i != 5) {
            a2 = null;
        } else {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.g.f.a(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.a.b(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            a2 = m.a(e.c.getClickInstallLabel(), "click_install");
        }
        a(null, a2, jSONObject, 0L, 1, e);
    }

    public void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        a((String) null, str, aVar);
    }

    public void b(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        a((String) null, str, jSONObject, aVar);
    }

    public void a(String str, int i, e eVar) {
        a(null, str, null, i, 0, eVar);
    }

    public void a(long j, boolean z, int i) {
        e e = f.a().e(j);
        if (e.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (e.b.getQuickAppModel() == null) {
            return;
        }
        DownloadModel downloadModel = e.b;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, e);
    }

    public void a(long j, BaseException baseException) {
        e e = f.a().e(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b("download_failed", jSONObject, e);
    }

    public void a(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.a.b a2 = f.a().a(downloadInfo);
        if (a2 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            a2.a(System.currentTimeMillis());
            a(a2.j(), "download_resume", jSONObject, a2);
            i.a().a(a2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        a(bVar.j(), "install_finish", jSONObject, bVar);
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.a.b a2;
        if (downloadInfo == null || (a2 = f.a().a(downloadInfo)) == null || a2.c.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(a2.E()));
            jSONObject.putOpt("fail_msg", a2.F());
            jSONObject.put("download_failed_times", a2.x());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (a2.H() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - a2.H());
            }
            if (a2.B() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - a2.B());
            }
            jSONObject.put("is_update_download", a2.V() ? 1 : 2);
            jSONObject.put("can_show_notification", d.a() ? 1 : 2);
            jSONObject.put("has_send_download_failed_finally", a2.d.get() ? 1 : 2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(a2.j(), "download_cancel", jSONObject, a2);
    }

    public void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        a(str, (JSONObject) null, aVar);
    }

    public void a(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadad.api.a.a d = f.a().d(j);
        if (d != null) {
            a(str, jSONObject, d);
            return;
        }
        e e = f.a().e(j);
        if (e.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendUnityEvent ModelBox notValid");
        } else {
            a(str, jSONObject, e);
        }
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        m.a(jSONObject2, "unity_label", str);
        a("embeded_ad", "ttdownloader_unity", m.a(jSONObject, jSONObject2), aVar);
    }

    public void a(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        b(str, new e(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void a(String str, long j) {
        com.ss.android.downloadad.api.a.b d = f.a().d(j);
        if (d != null) {
            b(str, d);
        } else {
            b(str, f.a().e(j));
        }
    }

    public void a(String str, String str2, com.ss.android.downloadad.api.a.a aVar) {
        a(str, str2, (JSONObject) null, aVar);
    }

    public void a(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        a(str, str2, jSONObject, 0L, 0, aVar);
    }

    private void a(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.downloadad.api.a.a aVar) {
        if (aVar == null) {
            com.ss.android.downloadlib.e.c.a().a("onEvent data null");
            return;
        }
        if ((aVar instanceof e) && ((e) aVar).x()) {
            com.ss.android.downloadlib.e.c.a().a("onEvent ModelBox notValid");
            return;
        }
        try {
            c.a c = new c.a().a(m.a(str, aVar.j(), "embeded_ad")).b(str2).b(aVar.c()).a(aVar.b()).c(aVar.d());
            if (j <= 0) {
                j = aVar.l();
            }
            c.a a2 = c.b(j).d(aVar.i()).a(aVar.n()).a(m.a(a(aVar), jSONObject)).b(aVar.k()).a(aVar.o());
            if (i <= 0) {
                i = 2;
            }
            a(a2.a(i).a(aVar.m()).a());
        } catch (Exception e) {
            com.ss.android.downloadlib.e.c.a().a(e, "onEvent");
        }
    }

    private JSONObject a(com.ss.android.downloadad.api.a.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            m.a(aVar.g(), jSONObject);
            m.a(aVar.p(), jSONObject);
            jSONObject.putOpt("download_url", aVar.a());
            jSONObject.putOpt(bb.G, aVar.e());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.f.e.h());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.f.e.i());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(aVar.h()));
            if (aVar.h() == 2) {
                com.ss.android.downloadlib.g.f.b(jSONObject, aVar);
            }
            if (com.ss.android.socialbase.appdownloader.f.e.p()) {
                com.ss.android.downloadlib.g.f.a(jSONObject);
            }
        } catch (Exception e) {
            k.u().a(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void a(com.ss.android.download.api.model.c cVar) {
        if (k.b() == null) {
            return;
        }
        if (cVar.m()) {
            k.b().a(cVar);
        } else {
            k.b().b(cVar);
        }
    }
}
