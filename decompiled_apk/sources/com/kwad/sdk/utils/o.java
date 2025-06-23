package com.kwad.sdk.utils;

import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class o {
    private static boolean aPM;
    private static boolean aPN;

    public static boolean LQ() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(2L)) & aPM;
    }

    public static boolean LR() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(4L)) & aPM;
    }

    public static boolean LS() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(2048L)) & aPM;
    }

    public static boolean LT() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zh() && aPM) {
            return true;
        }
        return false;
    }

    public static boolean LU() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(16L)) & aPM;
    }

    public static boolean LV() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(4096L)) & aPM;
    }

    public static boolean LW() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(1L)) & aPM;
    }

    public static boolean LX() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(128L)) & aPM;
    }

    public static boolean LY() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(128L)) & aPM;
    }

    public static synchronized void bR(boolean z) {
        synchronized (o.class) {
            if (aPN) {
                return;
            }
            aPN = true;
            aPM = true;
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).yR();
        }
    }
}
