package com.ss.android.downloadlib.addownload.c;

import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private DownloadInfo f25981a;

    public b(DownloadInfo downloadInfo) {
        this.f25981a = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.downloadad.api.a.b a2;
        if (this.f25981a == null || (a2 = f.a().a(this.f25981a)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_task", a2);
        long longValue = Double.valueOf((com.ss.android.downloadlib.g.e.a(this.f25981a.getId()) + 1.0d) * this.f25981a.getTotalBytes()).longValue() - this.f25981a.getCurBytes();
        long b = m.b(0L);
        if (k.n() != null) {
            k.n().e();
        }
        c.a();
        c.b();
        if (com.ss.android.downloadlib.g.e.g(a2.s())) {
            c.a(k.a());
        }
        long b2 = m.b(0L);
        if (b2 >= longValue) {
            a2.l("1");
            i.a().a(a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(b2 - b));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, a2);
            Downloader.getInstance(k.a()).restart(this.f25981a.getId());
            return;
        }
        if (k.n() != null) {
            a2.d(false);
            d.a().a(a2.a(), new e() { // from class: com.ss.android.downloadlib.addownload.c.b.1
            });
            if (k.n().a(this.f25981a.getId(), this.f25981a.getUrl(), true, longValue)) {
                a2.e(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject2, a2);
    }
}
