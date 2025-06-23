package com.kwad.sdk;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* loaded from: classes11.dex */
public final class g {
    private static AdHttpProxy aly;

    @NonNull
    public static AdHttpProxy yy() {
        AdHttpProxy adHttpProxy = aly;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.framework.a.a.md.booleanValue()) {
            return yz();
        }
        try {
            if (com.kwad.sdk.core.network.a.c.EC() != null) {
                aly = new com.kwad.sdk.core.network.c.b();
            } else {
                aly = new com.kwad.sdk.core.network.c.a();
            }
        } catch (Throwable unused) {
            aly = new com.kwad.sdk.core.network.c.a();
        }
        return aly;
    }

    private static AdHttpProxy yz() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (new Random().nextInt(5) != 0) {
            return new com.kwad.sdk.core.network.c.b();
        }
        return new com.kwad.sdk.core.network.c.a();
    }
}
