package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.a.d f26058a;
    private static com.ss.android.downloadlib.addownload.a.c b;

    public static boolean a(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static com.ss.android.downloadlib.addownload.a.c b() {
        return b;
    }

    public static com.ss.android.downloadlib.addownload.a.d a() {
        return f26058a;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.d dVar) {
        f26058a = dVar;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.c cVar) {
        b = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static boolean a(final com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, int i, final com.ss.android.downloadlib.addownload.d.h hVar, final boolean z, final com.ss.android.downloadlib.addownload.a.c cVar) {
        ?? r2;
        if (bVar == null) {
            com.ss.android.downloadlib.e.c.a().a("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.e.c.a().a("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        if (z) {
            r2 = com.ss.android.downloadlib.g.e.c((com.ss.android.downloadad.api.a.a) bVar);
        } else {
            r2 = com.ss.android.downloadlib.g.e.b((com.ss.android.downloadad.api.a.a) bVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf((int) r2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_switch_status", jSONObject, bVar);
        } else {
            com.ss.android.downloadlib.d.a.a().a("pause_reserve_wifi_switch_status", jSONObject, bVar);
        }
        if (r2 == 0 || !a(i) || com.ss.android.socialbase.downloader.i.f.b(k.a())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        a(new com.ss.android.downloadlib.addownload.a.d() { // from class: com.ss.android.downloadlib.addownload.n.1
            @Override // com.ss.android.downloadlib.addownload.a.d
            public void a() {
                n.a((com.ss.android.downloadlib.addownload.a.d) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(k.a()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    r.a().a(downloadInfo2);
                    if (z) {
                        com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_confirm", bVar);
                    } else {
                        com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_confirm", bVar);
                    }
                }
                hVar.a(bVar);
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void b() {
                n.a((com.ss.android.downloadlib.addownload.a.d) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(k.a()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z) {
                    com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_cancel", bVar);
                } else {
                    com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel", bVar);
                }
                hVar.a(bVar);
            }
        });
        if (z && cVar != null) {
            a(new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.n.2
                @Override // com.ss.android.downloadlib.addownload.a.c
                public void a() {
                    com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_delete", com.ss.android.downloadad.api.a.b.this);
                    cVar.a();
                }
            });
        }
        if (z) {
            TTDelegateActivity.a(bVar, "删除");
        } else {
            TTDelegateActivity.b(bVar);
        }
        return true;
    }
}
