package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.jn;
import com.huawei.openalliance.ad.constant.ai;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: classes10.dex */
public class h {
    private static final String Code = "AppLauncher";

    private static void Code(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            fb.V(Code, "appInfo is empty.");
        } else {
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.h.1
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                    if (Code2 != null) {
                        Code2.Code(AppInfo.this.Code());
                    }
                }
            });
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.h.2
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                    if (Code2 != null) {
                        Code2.Code(AppInfo.this);
                    }
                }
            });
        }
    }

    public boolean Code(Context context, AppInfo appInfo, AdContentData adContentData, Integer num, boolean z) {
        if (context == null || appInfo == null) {
            fb.V(Code, "parameters occur error");
            return false;
        }
        String Code2 = appInfo.Code();
        jn.a aVar = new jn.a();
        aVar.Code(appInfo).Code(adContentData);
        if (com.huawei.openalliance.ad.utils.g.Code(context, Code2, appInfo.D(), aVar.Code())) {
            Code(context, appInfo);
            jc.Code(context, adContentData, "intentSuccess", (Integer) 1, (Integer) null);
            if (z) {
                jc.Code(context, adContentData, 0, 0, "app", num.intValue(), com.huawei.openalliance.ad.utils.b.Code(context));
            }
            return true;
        }
        fb.V(Code, "handClick, openAppIntent fail");
        jc.Code(context, adContentData, ai.D, (Integer) 1, Integer.valueOf(com.huawei.openalliance.ad.utils.g.Code(context, Code2) ? 2 : 1));
        if (!com.huawei.openalliance.ad.utils.g.Code(context, Code2, aVar.Code())) {
            fb.V(Code, "handClick, openAppMainPage fail");
            return false;
        }
        jc.Code(context, adContentData, (Integer) 1);
        Code(context, appInfo);
        if (z) {
            jc.Code(context, adContentData, 0, 0, "app", num.intValue(), com.huawei.openalliance.ad.utils.b.Code(context));
        }
        return true;
    }
}
