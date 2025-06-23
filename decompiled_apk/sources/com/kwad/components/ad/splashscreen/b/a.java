package com.kwad.components.ad.splashscreen.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.q;

/* loaded from: classes11.dex */
public final class a {
    public static k CO = new k("splashTimeOutMilliSecond", 5000);
    public static q CP = new q("splashTimerTips", "");
    public static q CQ = new q("splashBtnText", "点击跳转详情页或第三方应用");
    public static d CR = new d("splashCropNewSwitch", true);
    public static d CS = new d("splashAdLoadProcessChange", false);
    public static k CU = new k("splashMaterialDownloadTimeMs", 500);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
