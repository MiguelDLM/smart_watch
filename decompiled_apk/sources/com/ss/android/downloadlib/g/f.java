package com.ss.android.downloadlib.g;

import XIXIX.OOXIXo;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class f {
    public static void a(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            c(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            if (a2 == null) {
                return;
            }
            jSONObject.put("is_update_download", a2.V() ? 1 : 2);
            a(a2, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.a.b a2;
        if (jSONObject == null || (a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        try {
            c(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - a2.T()));
            jSONObject.putOpt("click_download_size", Long.valueOf(a2.U()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            a2.A();
            com.ss.android.downloadlib.addownload.b.i.a().a(a2);
            jSONObject.put("click_pause_times", a2.z());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? OOXIXo.f3760XO : curBytes / totalBytes);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            long H = a2.H();
            if (H > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - H);
            }
            long B = a2.B();
            if (B > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - B);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(a2.E()));
            jSONObject.putOpt("fail_msg", a2.F());
            jSONObject.put("download_failed_times", a2.x());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(DownloadInfo downloadInfo, JSONObject jSONObject) {
        int i;
        int i2;
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo.getId());
                if (a2 != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(a2.T()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(a2.U()));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        int i3 = 2;
        if (com.ss.android.socialbase.appdownloader.e.d.a()) {
            i = 1;
        } else {
            i = 2;
        }
        jSONObject.putOpt("permission_notification", Integer.valueOf(i));
        if (com.ss.android.socialbase.downloader.i.f.c(com.ss.android.downloadlib.addownload.k.a())) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        jSONObject.putOpt("network_available", Integer.valueOf(i2));
        if (com.ss.android.socialbase.downloader.i.f.b(com.ss.android.downloadlib.addownload.k.a())) {
            i3 = 1;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i3));
    }

    public static void a(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", bVar.X() ? 1 : 0);
            jSONObject.put("origin_mime_type", bVar.W());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray e = com.ss.android.socialbase.downloader.g.a.a(i).e("ah_report_config");
        if (e != null) {
            for (int i2 = 0; i2 < e.length(); i2++) {
                try {
                    String string = e.getString(i2);
                    g.a a2 = com.ss.android.socialbase.appdownloader.f.a.a(string);
                    if (a2 != null) {
                        jSONObject.put(string.replaceAll("\\.", "_"), a2.f() + "_" + a2.g());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.c.O()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, m.a(aVar.f(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void a(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.f.d.a());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.f.d.c());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.f.d.d());
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.d.a(com.ss.android.downloadlib.addownload.k.a()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.d.e() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.f.d.b());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.d.b(com.ss.android.downloadlib.addownload.k.a()) ? 1 : 2));
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.d.f() ? 1 : 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject b(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, com.ss.android.socialbase.appdownloader.f.e.j().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(m.b(com.ss.android.downloadlib.addownload.k.a(), com.ss.android.socialbase.appdownloader.f.e.j())));
        m.a(jSONObject, com.ss.android.socialbase.appdownloader.f.e.j().replaceAll("\\.", "_") + " versionName", m.c(com.ss.android.downloadlib.addownload.k.a(), com.ss.android.socialbase.appdownloader.f.e.j()));
        return jSONObject;
    }
}
