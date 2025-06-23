package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class d {
    public static a a(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo);
        if (str.equals(com.huawei.hms.ads.dynamicloader.b.f)) {
            return new j(context, a2, downloadInfo.getTargetFilePath());
        }
        if (str.equals(com.huawei.hms.ads.dynamicloader.b.g)) {
            return new k(context, a2, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new l(context, a2, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new g(context, a2, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new h(context, a2, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new i(context, a2, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new c(context, a2, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new m(context, a2, com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.d.j().d(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean a(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        a mVar;
        if (context == null || str == null) {
            return false;
        }
        String b = com.ss.android.socialbase.appdownloader.c.b();
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.ss.android.socialbase.appdownloader.f.e.d() && str.equals(com.huawei.hms.ads.dynamicloader.b.f)) {
            mVar = new j(context, aVar, b);
        } else if (com.ss.android.socialbase.appdownloader.f.e.d() && str.equals(com.huawei.hms.ads.dynamicloader.b.g)) {
            mVar = new k(context, aVar, b);
        } else if (com.ss.android.socialbase.appdownloader.f.e.d() && str.equals("v3")) {
            mVar = new l(context, aVar, b);
        } else if (com.ss.android.socialbase.appdownloader.f.e.e() && str.equals("o1")) {
            mVar = new g(context, aVar, b);
        } else if (com.ss.android.socialbase.appdownloader.f.e.e() && str.equals("o2")) {
            mVar = new h(context, aVar, b);
        } else if (com.ss.android.socialbase.appdownloader.f.e.e() && str.equals("o3")) {
            mVar = new i(context, aVar, b, b, b);
        } else if (com.ss.android.socialbase.appdownloader.f.e.d() && str.equals("custom")) {
            mVar = new c(context, aVar, b, jSONObject);
        } else {
            mVar = (com.ss.android.socialbase.appdownloader.f.e.d() && str.equals("vbi")) ? new m(context, aVar, b) : null;
        }
        return mVar != null && mVar.a();
    }
}
