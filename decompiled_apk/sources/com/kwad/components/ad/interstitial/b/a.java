package com.kwad.components.ad.interstitial.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;

/* loaded from: classes11.dex */
public final class a {
    public static k jr = new k("interstitialAdSkipCloseType", 0);
    public static k js = new k("interstitialAdSkipCloseArea", 0);
    public static k jt = new k("interstitialAdFullClick", 1);
    public static k ju = new k("interstitialAdBackPressSwitch", 0);
    public static k jv = new k("interstitialPlayableTime", 999);
    public static k jw = new k("interstitialAdClickShutDown", 0);
    public static d jx = new d("interstitialAutoStartSwitch", false);
    public static k jy = new k("ecInterstitialAdOrderSwitch", 0);
    public static k jz = new k("interstitialCycleAggregateMaxCount", 3);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
