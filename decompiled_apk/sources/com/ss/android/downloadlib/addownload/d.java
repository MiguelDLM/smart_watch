package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Handler f26017a;
    private com.ss.android.downloadlib.addownload.b.e b;
    private AtomicBoolean c = new AtomicBoolean(false);
    private AtomicBoolean d = new AtomicBoolean(false);

    public d(Handler handler) {
        this.f26017a = handler;
    }

    public static long b() {
        if (k.n() != null) {
            return k.n().a();
        }
        return 0L;
    }

    public static /* synthetic */ long c() {
        return d();
    }

    private static long d() {
        return com.ss.android.downloadlib.g.m.b(0L);
    }

    private void b(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j, long j2) {
        bVar.l("1");
        com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, bVar);
    }

    public void a(com.ss.android.downloadlib.addownload.b.e eVar) {
        this.b = eVar;
    }

    public boolean a() {
        return this.d.get();
    }

    public void a(boolean z) {
        this.d.set(z);
    }

    public void a(final int i, final long j, long j2, final e.a aVar) {
        this.d.set(false);
        if (aVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.g.e.f(i) && com.ss.android.downloadlib.g.e.e(i)) {
            long c = com.ss.android.downloadlib.g.e.c(i);
            this.c.set(false);
            final String downloadUrl = this.b.b.getDownloadUrl();
            com.ss.android.downloadad.api.a.b b = com.ss.android.downloadlib.addownload.b.f.a().b(downloadUrl);
            if (b == null) {
                com.ss.android.downloadlib.addownload.b.e eVar = this.b;
                b = new com.ss.android.downloadad.api.a.b(eVar.b, eVar.c, eVar.d, 0);
                com.ss.android.downloadlib.addownload.b.f.a().a(b);
            }
            final com.ss.android.downloadad.api.a.b bVar = b;
            bVar.e(false);
            if (k.n() != null) {
                k.n().a(bVar.b());
            }
            com.ss.android.downloadlib.addownload.c.d.a().a(bVar.a());
            boolean d = com.ss.android.downloadlib.g.e.d(i);
            if (j2 > 0) {
                a(i, downloadUrl, j2, bVar, j, aVar);
            } else if (d) {
                a(downloadUrl, bVar, new e.b() { // from class: com.ss.android.downloadlib.addownload.d.1
                    @Override // com.ss.android.downloadlib.addownload.e.b
                    public void a(long j3) {
                        d.this.a(i, downloadUrl, j3, bVar, j, aVar);
                    }
                });
            } else {
                c = 0;
            }
            this.f26017a.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.c.get()) {
                        return;
                    }
                    d.this.c.set(true);
                    aVar.a();
                }
            }, c);
            return;
        }
        aVar.a();
    }

    private void a(String str, com.ss.android.downloadad.api.a.b bVar, final e.b bVar2) {
        if (bVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.a.b.a(str, new com.ss.android.socialbase.downloader.network.j() { // from class: com.ss.android.downloadlib.addownload.d.3
            @Override // com.ss.android.socialbase.downloader.network.j
            public void a(Map<String, String> map) {
                if (d.this.c.get()) {
                    return;
                }
                d.this.c.set(true);
                long a2 = d.this.a(map);
                if (a2 > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(a2));
                        jSONObject.putOpt("available_space", Long.valueOf(d.c()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                bVar2.a(a2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r18, java.lang.String r19, long r20, final com.ss.android.downloadad.api.a.b r22, long r23, final com.ss.android.downloadlib.addownload.e.a r25) {
        /*
            r17 = this;
            r8 = r17
            r1 = r20
            r9 = r22
            r10 = r25
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.c
            r11 = 1
            r0.set(r11)
            r3 = 0
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L8c
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r0 = "apk_size"
            java.lang.Long r3 = java.lang.Long.valueOf(r20)     // Catch: org.json.JSONException -> L23
            r12.putOpt(r0, r3)     // Catch: org.json.JSONException -> L23
            goto L27
        L23:
            r0 = move-exception
            r0.printStackTrace()
        L27:
            double r3 = com.ss.android.downloadlib.g.e.a(r18)
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            double r0 = (double) r1
            double r3 = r3 * r0
            java.lang.Double r0 = java.lang.Double.valueOf(r3)
            long r0 = r0.longValue()
            long r2 = com.ss.android.downloadlib.g.e.b(r18)
            long r0 = r0 + r2
            long r13 = r0 - r23
            long r15 = d()
            int r0 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r0 >= 0) goto L8c
            r1 = r17
            r2 = r22
            r3 = r12
            r4 = r13
            r6 = r15
            r1.a(r2, r3, r4, r6)
            a(r22)
            long r6 = d()
            int r0 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r0 >= 0) goto L83
            r9.d(r11)
            java.lang.String r0 = r22.a()
            com.ss.android.downloadlib.addownload.c.d r1 = com.ss.android.downloadlib.addownload.c.d.a()
            com.ss.android.downloadlib.addownload.d$4 r2 = new com.ss.android.downloadlib.addownload.d$4
            r2.<init>()
            r1.a(r0, r2)
            r1 = r17
            r2 = r18
            r3 = r22
            r4 = r19
            r5 = r13
            boolean r0 = r1.a(r2, r3, r4, r5)
            if (r0 == 0) goto L8d
            r9.e(r11)
            goto L8d
        L83:
            r1 = r17
            r2 = r22
            r3 = r12
            r4 = r15
            r1.b(r2, r3, r4, r6)
        L8c:
            r0 = 0
        L8d:
            if (r0 != 0) goto L99
            android.os.Handler r0 = r8.f26017a
            com.ss.android.downloadlib.addownload.d$5 r1 = new com.ss.android.downloadlib.addownload.d$5
            r1.<init>()
            r0.post(r1)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.d.a(int, java.lang.String, long, com.ss.android.downloadad.api.a.b, long, com.ss.android.downloadlib.addownload.e$a):void");
    }

    private boolean a(int i, @NonNull com.ss.android.downloadad.api.a.b bVar, String str, long j) {
        if (!com.ss.android.downloadlib.g.e.f(i)) {
            return false;
        }
        if (k.n() != null) {
            return k.n().a(i, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject, bVar);
        return false;
    }

    public static boolean a(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean z = false;
        if (!com.ss.android.downloadlib.g.e.f(id)) {
            return false;
        }
        if (k.n() != null && (z = k.n().a(id, downloadInfo.getUrl(), false, j))) {
            com.ss.android.downloadlib.addownload.c.d.a().a(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.c.e() { // from class: com.ss.android.downloadlib.addownload.d.6
            });
        }
        return z;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void a(int i) {
        if (com.ss.android.downloadlib.g.e.f(i) && k.n() != null && k.n().b()) {
            k.n().c();
        }
    }

    private static void a(com.ss.android.downloadad.api.a.b bVar) {
        long d = d();
        if (k.n() != null) {
            k.n().e();
        }
        com.ss.android.downloadlib.addownload.c.c.a();
        com.ss.android.downloadlib.addownload.c.c.b();
        if (com.ss.android.downloadlib.g.e.g(bVar.s())) {
            com.ss.android.downloadlib.addownload.c.c.a(k.a());
        }
        long d2 = d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(d2 - d));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("clean_quite_finish", jSONObject, bVar);
    }

    private void a(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("clean_space_no_enough_for_download", jSONObject, bVar);
    }
}
