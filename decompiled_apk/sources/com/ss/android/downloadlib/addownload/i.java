package com.ss.android.downloadlib.addownload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class i {
    public static boolean a(int i) {
        return i == 0 || i == 1;
    }

    public static boolean b(int i) {
        return i == 2 || i == 1;
    }

    public static String c(DownloadModel downloadModel) {
        try {
            if (!TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return new JSONObject(downloadModel.getLogExtra()).optString("clickid");
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String d(DownloadModel downloadModel) {
        try {
            if (!TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return new JSONObject(downloadModel.getLogExtra()).optString(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA);
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean a(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean b(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean a(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, boolean z, com.ss.android.socialbase.appdownloader.f fVar) {
        int i;
        if (fVar == null || TextUtils.isEmpty(fVar.c()) || fVar.b() == null) {
            return 0;
        }
        try {
            i = a(fVar, fVar.c());
        } catch (Throwable th) {
            k.u().a(th, "redirectSavePathIfPossible");
            i = 4;
        }
        fVar.a(i);
        if (i == 0) {
            fVar.a(new com.ss.android.downloadlib.c.a());
        }
        if (!fVar.ac()) {
            fVar.a(new com.ss.android.downloadlib.c.b());
        }
        int a2 = com.ss.android.socialbase.appdownloader.d.j().a(fVar);
        com.ss.android.downloadad.api.a.b a3 = a(eVar, a2);
        com.ss.android.downloadlib.addownload.b.f.a().a(a3);
        a3.g(a2);
        a3.h(System.currentTimeMillis());
        a3.i(0L);
        com.ss.android.socialbase.downloader.g.a a4 = com.ss.android.socialbase.downloader.g.a.a(fVar.ag());
        if (!a(fVar, a4, a2) && eVar.b.isShowToast()) {
            String startToast = eVar.b.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = a4.c("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            k.d().a(2, fVar.b(), eVar.b, startToast, null, 0);
        }
        return a2;
    }

    private static com.ss.android.downloadad.api.a.b a(com.ss.android.downloadlib.addownload.b.e eVar, int i) {
        com.ss.android.downloadad.api.a.b bVar = new com.ss.android.downloadad.api.a.b(eVar.b, eVar.c, eVar.d, i);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("download_event_opt", 1) > 1) {
            try {
                String packageName = eVar.b.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (k.a().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    bVar.h(z);
                }
            } catch (Throwable unused) {
            }
        }
        return bVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
    
        switch(r9) {
            case 0: goto L57;
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L67;
            case 4: goto L57;
            case 5: goto L57;
            case 6: goto L53;
            case 7: goto L67;
            default: goto L76;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009e, code lost:
    
        if (com.ss.android.socialbase.appdownloader.b.b(r7, r12).b != 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a1, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a9, code lost:
    
        if (com.ss.android.socialbase.appdownloader.b.a(r7, r12).b != 0) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(com.ss.android.socialbase.appdownloader.f r11, @androidx.annotation.NonNull com.ss.android.socialbase.downloader.g.a r12, int r13) {
        /*
            java.lang.String r11 = "plan_c"
            r0 = 1
            java.lang.String r1 = "ah_plans"
            org.json.JSONArray r1 = r12.e(r1)
            r2 = 0
            if (r1 == 0) goto Lc7
            int r3 = r1.length()
            if (r3 != 0) goto L14
            goto Lc7
        L14:
            int r3 = r1.length()
            r4 = 0
            r6 = r4
            r5 = 0
        L1b:
            if (r5 >= r3) goto Laf
            org.json.JSONObject r7 = r1.optJSONObject(r5)
            if (r7 == 0) goto Lac
            java.lang.String r8 = "type"
            java.lang.String r8 = r7.optString(r8)
            if (r8 == r11) goto L33
            boolean r9 = com.ss.android.socialbase.appdownloader.f.a.a(r7)
            if (r9 != 0) goto L33
            goto Lac
        L33:
            r8.hashCode()
            r9 = -1
            int r10 = r8.hashCode()
            switch(r10) {
                case -985763637: goto L8a;
                case -985763636: goto L7f;
                case -985763635: goto L76;
                case -985763634: goto L6b;
                case -985763633: goto L60;
                case -985763632: goto L55;
                case -985763631: goto L4a;
                case -985763630: goto L3f;
                default: goto L3e;
            }
        L3e:
            goto L94
        L3f:
            java.lang.String r10 = "plan_h"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L48
            goto L94
        L48:
            r9 = 7
            goto L94
        L4a:
            java.lang.String r10 = "plan_g"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L53
            goto L94
        L53:
            r9 = 6
            goto L94
        L55:
            java.lang.String r10 = "plan_f"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L5e
            goto L94
        L5e:
            r9 = 5
            goto L94
        L60:
            java.lang.String r10 = "plan_e"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L69
            goto L94
        L69:
            r9 = 4
            goto L94
        L6b:
            java.lang.String r10 = "plan_d"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L74
            goto L94
        L74:
            r9 = 3
            goto L94
        L76:
            boolean r8 = r8.equals(r11)
            if (r8 != 0) goto L7d
            goto L94
        L7d:
            r9 = 2
            goto L94
        L7f:
            java.lang.String r10 = "plan_b"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L88
            goto L94
        L88:
            r9 = 1
            goto L94
        L8a:
            java.lang.String r10 = "plan_a"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L93
            goto L94
        L93:
            r9 = 0
        L94:
            switch(r9) {
                case 0: goto La3;
                case 1: goto La3;
                case 2: goto La1;
                case 3: goto Laf;
                case 4: goto La3;
                case 5: goto La3;
                case 6: goto L98;
                case 7: goto Laf;
                default: goto L97;
            }
        L97:
            goto Lac
        L98:
            com.ss.android.socialbase.appdownloader.a r7 = com.ss.android.socialbase.appdownloader.b.b(r7, r12)
            int r7 = r7.b
            if (r7 != 0) goto Lac
            goto Laf
        La1:
            r6 = r7
            goto Lac
        La3:
            com.ss.android.socialbase.appdownloader.a r7 = com.ss.android.socialbase.appdownloader.b.a(r7, r12)
            int r7 = r7.b
            if (r7 != 0) goto Lac
            goto Laf
        Lac:
            int r5 = r5 + r0
            goto L1b
        Laf:
            if (r6 == 0) goto Lc7
            java.lang.String r11 = "show_unknown_source_on_startup"
            int r11 = r6.optInt(r11)
            if (r11 != r0) goto Lc7
            android.content.Context r11 = com.ss.android.socialbase.downloader.downloader.c.O()
            com.ss.android.socialbase.appdownloader.a r12 = new com.ss.android.socialbase.appdownloader.a
            r12.<init>()
            boolean r11 = com.ss.android.socialbase.appdownloader.b.a(r11, r4, r6, r13, r12)
            return r11
        Lc7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.i.a(com.ss.android.socialbase.appdownloader.f, com.ss.android.socialbase.downloader.g.a, int):boolean");
    }

    public static String a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int a(com.ss.android.socialbase.appdownloader.f fVar, String str) {
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(fVar.ag());
        JSONObject d = a2.d("download_dir");
        if (d == null || TextUtils.isEmpty(d.optString("dir_name"))) {
            return -1;
        }
        String d2 = fVar.d();
        String N = fVar.N();
        if (TextUtils.isEmpty(N)) {
            N = com.ss.android.socialbase.appdownloader.c.a(str, d2, fVar.n(), true);
        }
        if (N.length() > 255) {
            N = N.substring(N.length() - 255);
        }
        if (TextUtils.isEmpty(d2)) {
            d2 = N;
        }
        String e = fVar.e();
        if (TextUtils.isEmpty(e)) {
            e = com.ss.android.socialbase.appdownloader.c.b();
        }
        String str2 = e + File.separator + com.ss.android.socialbase.appdownloader.c.a(d2, a2);
        DownloadInfo a3 = com.ss.android.socialbase.appdownloader.d.j().a(fVar.b(), str);
        if (a3 != null && a3.isSavePathRedirected()) {
            fVar.c(a3.getSavePath());
            try {
                fVar.a(new JSONObject(a3.getDownloadSettingString()));
            } catch (Throwable unused) {
            }
            return 0;
        }
        if (a3 != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.d.j().a(N, fVar.n()))) {
            return a3 != null ? 8 : 9;
        }
        int a4 = com.ss.android.socialbase.appdownloader.b.a(a2);
        if (a4 == 0) {
            fVar.c(str2);
        }
        return a4;
    }
}
