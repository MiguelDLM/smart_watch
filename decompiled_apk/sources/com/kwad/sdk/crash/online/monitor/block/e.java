package com.kwad.sdk.crash.online.monitor.block;

import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* loaded from: classes11.dex */
public final class e {
    private static com.kwad.sdk.crash.online.monitor.a.a aHY;

    public static com.kwad.sdk.crash.online.monitor.a.a IB() {
        return aHY;
    }

    public static boolean IC() {
        com.kwad.sdk.crash.online.monitor.a.a aVar = aHY;
        if (aVar != null && aVar.IF()) {
            return true;
        }
        return false;
    }

    public static void d(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.II()) {
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "allFuncDisable");
                return;
            }
            if (!a.Iz()) {
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "!hasBlockMonitor");
                return;
            }
            a.a(aVar);
            aHY = aVar;
            boolean bA = a.bA(true);
            com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "hasTenBlockHook:" + bA);
            if (aVar.apu < new Random().nextFloat()) {
                return;
            }
            b.a(aVar);
            if (aVar.IG() && bA) {
                c.b(aVar);
            }
            if (aVar.IH()) {
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + a.bB(false));
            }
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Exception unused) {
            }
        }
    }
}
