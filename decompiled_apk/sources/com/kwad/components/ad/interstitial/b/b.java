package com.kwad.components.ad.interstitial.b;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class b {
    public static int b(AdInfo adInfo) {
        int intValue = a.jv.getValue().intValue();
        if (com.kwad.sdk.core.response.b.a.bb(adInfo)) {
            int L = com.kwad.sdk.core.response.b.a.L(adInfo);
            if (intValue == 0) {
                return L;
            }
            return Math.min(intValue, L);
        }
        if (intValue > 60 || intValue <= 0) {
            return 60;
        }
        return intValue;
    }

    public static boolean cE() {
        return a.jx.getValue().booleanValue();
    }

    public static boolean cF() {
        if (a.jr.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int cG() {
        return a.js.getValue().intValue();
    }

    public static boolean cH() {
        if (a.jt.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean cI() {
        if (a.ju.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int cJ() {
        return a.jz.getValue().intValue();
    }

    public static boolean cK() {
        if (a.jw.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean cL() {
        if (a.jy.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }
}
