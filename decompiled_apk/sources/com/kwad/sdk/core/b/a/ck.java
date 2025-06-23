package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;

/* loaded from: classes11.dex */
public final class ck {
    @InvokeBy(invokerClass = fr.class, methodId = "registerHolder")
    public static void Ej() {
        fr.Ek().put(SplashMonitorInfo.class, new jd());
        fr.Ek().put(com.kwad.components.ad.splashscreen.local.a.class, new jc());
        fr.Ek().put(SplashPreloadManager.PreLoadItem.class, new hv());
        fr.Ek().put(SplashWebMonitorInfo.class, new jk());
        fr.Ek().put(SplashSkipViewModel.class, new jh());
    }
}
