package com.kwad.sdk;

import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.kwad.sdk.components.DevelopMangerComponents;

/* loaded from: classes11.dex */
public final class h {
    public static String bY(String str) {
        return str + "/rest/e/system/speed";
    }

    public static String yA() {
        String str = BNWebViewClient.URL_HTTPS_PREFIX + com.kwad.sdk.core.network.idc.a.EE().W("api", "open.e.kuaishou.com");
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return str;
    }

    public static String yB() {
        return yA() + "/rest/e/v3/open/univ";
    }

    public static String yC() {
        return yA() + "/rest/e/v4/open/univ";
    }

    public static String yD() {
        return yA() + "/rest/e/v4/open/univ/bidding";
    }

    public static String yE() {
        return yA() + "/rest/e/v4/open/univ/getMaterial";
    }

    public static String yF() {
        return yA() + "/rest/e/v3/open/logBatch";
    }

    public static String yG() {
        return yA() + "/rest/e/v3/open/config";
    }

    public static String yH() {
        return yA() + "/rest/e/v3/open/callback";
    }

    public static String yI() {
        return yA() + "/rest/e/v3/open/crashLog";
    }

    public static String yJ() {
        return yA() + "/rest/e/v3/open/appCheck";
    }

    public static String yK() {
        return yA() + "/rest/e/v3/open/collect";
    }

    public static String yL() {
        return yA() + "/rest/e/v3/open/checkReward";
    }

    public static String yM() {
        return yA() + "/rest/e/v3/open/kwaiGeoLocation";
    }

    public static String yN() {
        return yA() + "/rest/e/v3/open/getMiMarketUrl";
    }
}
