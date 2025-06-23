package com.huawei.hms.ads;

import android.content.Context;
import android.content.Intent;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public class fz implements gd {
    public static final String Code = "appInfo";
    public static final String I = "downloadSource";
    public static final String V = "contentRecord";
    private static final String Z = "AppNotificationBaseAction";

    @Override // com.huawei.hms.ads.gd
    public void Code(Context context, Intent intent) {
        StringBuilder sb;
        String str;
        try {
            com.huawei.openalliance.ad.inter.data.AppInfo appInfo = (com.huawei.openalliance.ad.inter.data.AppInfo) intent.getSerializableExtra("appInfo");
            AdContentData adContentData = (AdContentData) intent.getSerializableExtra("contentRecord");
            int intExtra = intent.getIntExtra(I, 1);
            if (appInfo != null && adContentData != null) {
                if (ge.Code(context).I(appInfo.Code())) {
                    Code(context, appInfo, adContentData, intExtra);
                    ge.Code(context).V(appInfo.Code());
                } else {
                    fb.V(Z, "packageName may be illegal:" + appInfo.Code());
                }
            }
        } catch (IllegalStateException e) {
            e = e;
            sb = new StringBuilder();
            str = "AppNotificationBaseAction.onReceive IllegalStateException:";
            sb.append(str);
            sb.append(e.getClass().getSimpleName());
            fb.I(Z, sb.toString());
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str = "AppNotificationBaseAction.onReceive Exception:";
            sb.append(str);
            sb.append(e.getClass().getSimpleName());
            fb.I(Z, sb.toString());
        }
    }

    public void Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, int i) {
        fb.V(Z, "do nothing at base action!");
    }
}
