package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public class fy extends fz {
    private static final String Z = "AppNotificationActivate";

    @Override // com.huawei.hms.ads.fz
    public void Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, int i) {
        if (adContentData == null || appInfo == null) {
            fb.V(Z, "contentRecord is empty");
        } else {
            new com.huawei.openalliance.ad.download.app.h().Code(context, appInfo, adContentData, Integer.valueOf(i), false);
            gb.V(context, adContentData);
        }
    }
}
