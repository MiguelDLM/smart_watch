package com.kwad.components.ad.fullscreen.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.k;

/* loaded from: classes11.dex */
public final class a {
    public static k gI = new k("fullscreenSkipType", 0);
    public static k gJ = new k("fullscreenSkipShowTime", 5);
    public static k gK = new k("fullScreenShakeMaxCount", 0);

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void init() {
    }
}
