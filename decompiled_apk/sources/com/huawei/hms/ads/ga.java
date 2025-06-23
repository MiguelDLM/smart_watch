package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public class ga extends fz {
    private static final String Z = "AppNotificationDelete";

    @Override // com.huawei.hms.ads.fz
    public void Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, int i) {
        if (adContentData == null) {
            fb.V(Z, "contentRecord is empty");
        } else {
            gb.Code(context, adContentData);
        }
    }
}
