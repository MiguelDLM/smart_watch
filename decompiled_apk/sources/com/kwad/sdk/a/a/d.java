package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class d {
    public static String AA() {
        String Dk = com.kwad.sdk.core.config.d.Dk();
        if (TextUtils.isEmpty(Dk)) {
            return "安装";
        }
        return Dk;
    }

    public static String AB() {
        String Dl = com.kwad.sdk.core.config.d.Dl();
        if (TextUtils.isEmpty(Dl)) {
            return "取消";
        }
        return Dl;
    }

    public static String F(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.Dj().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.s.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }
}
