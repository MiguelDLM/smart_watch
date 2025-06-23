package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* loaded from: classes11.dex */
public final class dw {
    @InvokeBy(invokerClass = fr.class, methodId = "registerHolder")
    public static void Ej() {
        fr.Ek().put(SdkConfigData.CouponActiveConfig.class, new co());
        fr.Ek().put(com.kwad.sdk.core.response.model.a.class, new ht());
        fr.Ek().put(SdkConfigData.TemplateConfigMap.class, new jy());
        fr.Ek().put(j.a.class, new fa());
        fr.Ek().put(ActivityInfo.class, new f());
        fr.Ek().put(h.a.class, new ex());
        fr.Ek().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new fb());
    }
}
