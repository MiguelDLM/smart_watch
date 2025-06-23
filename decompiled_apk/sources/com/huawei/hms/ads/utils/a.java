package com.huawei.hms.ads.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.d;
import com.huawei.openalliance.ad.utils.g;

/* loaded from: classes10.dex */
public class a {
    private static final String Code = "AppDownloadUtils";

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r1.S() > 0) goto L9;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.huawei.openalliance.ad.download.app.k Code(com.huawei.openalliance.ad.download.app.AppDownloadTask r1) {
        /*
            int r0 = r1.B()
            switch(r0) {
                case 0: goto L16;
                case 1: goto L1f;
                case 2: goto L1c;
                case 3: goto L19;
                case 4: goto L10;
                case 5: goto Ld;
                case 6: goto La;
                default: goto L7;
            }
        L7:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.DOWNLOAD
            goto L21
        La:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.INSTALLED
            goto L21
        Ld:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.INSTALLING
            goto L21
        L10:
            int r1 = r1.S()
            if (r1 <= 0) goto L7
        L16:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.PAUSE
            goto L21
        L19:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.INSTALL
            goto L21
        L1c:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.DOWNLOADING
            goto L21
        L1f:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.WAITING
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.utils.a.Code(com.huawei.openalliance.ad.download.app.AppDownloadTask):com.huawei.openalliance.ad.download.app.k");
    }

    public static String Code(Context context, AppInfo appInfo) {
        if (context == null || appInfo == null) {
            return "";
        }
        if (!TextUtils.isEmpty(appInfo.n())) {
            return appInfo.n();
        }
        int i = R.string.hiad_download_download;
        if ("11".equals(appInfo.i())) {
            i = R.string.hiad_download_install;
            if (appInfo.U() == 1) {
                i = R.string.hiad_preinstall_restore_and_open;
            }
        }
        return Code(appInfo.l(), context.getString(i));
    }

    public static String Code(Context context, AppInfo appInfo, int i) {
        int i2;
        if (context == null || appInfo == null) {
            return "";
        }
        String m = appInfo.m();
        if (!Code(appInfo)) {
            i2 = R.string.hiad_download_open;
        } else {
            if (i == 1) {
                return context.getString(R.string.hiad_app_preordered);
            }
            i2 = R.string.hiad_app_preorder;
        }
        return Code(context, appInfo, m, i2);
    }

    public static String Code(Context context, AppInfo appInfo, String str) {
        return (appInfo == null || context == null || g.V(context, appInfo.Code()) == null || !TextUtils.isEmpty(appInfo.Q())) ? str : context.getString(R.string.hiad_download_open);
    }

    private static String Code(Context context, AppInfo appInfo, String str, int i) {
        return !TextUtils.isEmpty(appInfo.o()) ? appInfo.o() : Code(str, context.getString(i));
    }

    public static String Code(String str, String str2) {
        return (TextUtils.isEmpty(str) || (!(bc.B() && bc.Code.equalsIgnoreCase(d.V())) && bc.B())) ? str2 : str;
    }

    public static boolean Code(AppInfo appInfo) {
        return (appInfo == null || TextUtils.isEmpty(appInfo.Q())) ? false : true;
    }
}
