package com.alimm.tanx.core.utils;

import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.interaction.AdClickInfo;
import java.util.Map;

public class AdClickUtAnalytics implements NotConfused {
    private static final String TAG = "ClickUtAnalytics";
    public static final String UT_LOSS_NO_INITED = "no_init";
    private static final String XAD_UT_CLICK = "xad_click";

    public static void recordActivityCreateFail(BidInfo bidInfo, String str, String str2) {
    }

    public static void recordClickUt(AdClickInfo adClickInfo, BidInfo bidInfo) {
        recordUt(XAD_UT_CLICK, adClickInfo, bidInfo);
    }

    public static void recordDeepLinkBackTime(BidInfo bidInfo, long j) {
    }

    public static void recordDeepLinkError(BidInfo bidInfo, int i) {
    }

    public static void recordDeepLinkResult(BidInfo bidInfo, boolean z) {
    }

    public static void recordNavResult(BidInfo bidInfo, String str, String str2, String str3, boolean z, Map<String, String> map) {
    }

    private static void recordUt(String str, AdClickInfo adClickInfo, BidInfo bidInfo) {
    }

    public static void recordWebSecondHop(BidInfo bidInfo, String str, String str2) {
    }

    public static void sendClickUt(String str, BidInfo bidInfo) {
    }

    public static void sendUt(String str, String str2, String str3, String str4, Map<String, String> map) {
    }

    public static void sendUt(String str, String str2, String str3, Map<String, String> map) {
        sendUt((String) null, str, str2, str3, map);
    }
}
