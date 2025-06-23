package com.kwad.components.ad.d;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.q;

/* loaded from: classes11.dex */
public final class a {
    public static q bJ = new q("kwaiLogoUrl", null);
    public static q bK = new q("attentionTips", "去关注TA");
    public static q bL = new q("viewHomeTips", "查看TA的主页");
    public static q bM = new q("buyNowTips", "立即抢购");

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void init() {
    }
}
