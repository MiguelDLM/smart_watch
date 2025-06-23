package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;

/* loaded from: classes11.dex */
public final class dx {
    @InvokeBy(invokerClass = fr.class, methodId = "registerHolder")
    public static void Ej() {
        fr.Ek().put(com.kwad.sdk.crash.a.class, new cr());
        fr.Ek().put(BlockEvent.class, new bs());
        fr.Ek().put(BlockEvent.a.class, new kd());
        fr.Ek().put(com.kwad.sdk.crash.online.monitor.a.c.class, new gl());
        fr.Ek().put(com.kwad.sdk.crash.online.monitor.block.d.class, new bt());
        fr.Ek().put(com.kwad.sdk.crash.online.monitor.a.b.class, new dp());
        fr.Ek().put(AnrReason.class, new bb());
        fr.Ek().put(com.kwad.sdk.crash.online.monitor.a.a.class, new br());
        fr.Ek().put(com.kwad.sdk.crash.model.b.class, new dl());
    }
}
