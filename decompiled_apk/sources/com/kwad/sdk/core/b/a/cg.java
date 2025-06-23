package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;

/* loaded from: classes11.dex */
public final class cg {
    @InvokeBy(invokerClass = fr.class, methodId = "registerHolder")
    public static void Ej() {
        fr.Ek().put(FeedWebViewInfo.class, new dv());
        fr.Ek().put(FeedErrorInfo.class, new dr());
        fr.Ek().put(FeedPageInfo.class, new dt());
        fr.Ek().put(FeedPageInfo.a.class, new gf());
    }
}
