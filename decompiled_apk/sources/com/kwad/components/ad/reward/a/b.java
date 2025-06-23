package com.kwad.components.ad.reward.a;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class b {
    public static int gA() {
        return a.qE.getValue().intValue();
    }

    public static int gB() {
        return a.qH.getValue().intValue();
    }

    public static boolean gC() {
        return a.qI.getValue().booleanValue();
    }

    public static boolean gD() {
        if (a.qJ.getValue().intValue() == 1 || a.qJ.getValue().intValue() == 3) {
            return true;
        }
        return false;
    }

    public static boolean gE() {
        return a.qK.getValue().booleanValue();
    }

    public static boolean gF() {
        return a.qL.getValue().booleanValue();
    }

    public static int gq() {
        return a.qu.getValue().intValue();
    }

    public static String gr() {
        return a.qy.getValue();
    }

    public static int gs() {
        return a.qv.getValue().intValue();
    }

    public static boolean gt() {
        return a.qx.getValue().booleanValue();
    }

    public static int gu() {
        return a.qw.getValue().intValue();
    }

    private static boolean gv() {
        if (a.qA.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static float gw() {
        return a.qF.getValue().floatValue();
    }

    public static boolean gx() {
        if (a.qF.getValue().floatValue() > 0.0f && a.qF.getValue().floatValue() < 1.0f) {
            return true;
        }
        return false;
    }

    public static boolean gy() {
        return a.qG.getValue().booleanValue();
    }

    public static long gz() {
        return a.qD.getValue().intValue();
    }

    public static boolean i(AdInfo adInfo) {
        if (j(adInfo) || !com.kwad.sdk.core.response.b.a.cK(adInfo) || !gv()) {
            return false;
        }
        return true;
    }

    public static boolean j(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.cK(adInfo) && a.qC.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean k(AdInfo adInfo) {
        return i(adInfo);
    }
}
