package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TanxSplashUt extends TanxBaseUt {
    public static final String FROM_TYPE = "from_type";
    public static final String IS_SUC = "is_suc";
    public static final int TYPE_FROM_CACHE = 0;
    public static final int TYPE_FROM_REQUEST = 1;

    public static void sendUt(ITanxAd iTanxAd, AdUtConstants adUtConstants, HashMap<String, String> hashMap, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (iTanxAd == null) {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
        } else {
            if (iTanxAd.getAdSlot() == null) {
                str5 = "";
            } else {
                str5 = iTanxAd.getAdSlot().getPid();
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() == null) {
                str6 = "";
            } else {
                str6 = iTanxAd.getBidInfo().getCreativeId();
            }
            if (iTanxAd.getBidInfo() == null) {
                str = "";
            } else {
                str = iTanxAd.getBidInfo().getTemplateId();
            }
            if (iTanxAd.getBidInfo() != null) {
                str7 = iTanxAd.getBidInfo().getSessionId();
            }
            str4 = str7;
            str2 = str5;
            str3 = requestId;
            str7 = str6;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str2, str3, str7, str);
        buildArgs.putAll(hashMap);
        String str8 = adUtConstants.arg1;
        TanxBaseUt.send(str8, adUtConstants.eventId, str2, str3, i, str8, buildArgs, str4);
    }

    public static void utSplashCacheExist(ITanxAd iTanxAd, int i, boolean z, int i2) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(FROM_TYPE, String.valueOf(i));
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_suc", str);
        sendUt(iTanxAd, AdUtConstants.SPLASH_CACHE_EXIT, hashMap, i2);
    }

    public static void utSplashJsonCheck(ITanxAd iTanxAd, int i, boolean z, int i2) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(FROM_TYPE, String.valueOf(i));
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_suc", str);
        sendUt(iTanxAd, AdUtConstants.SCREEN_JSON_CHECK, hashMap, i2);
    }

    public static void utSplashTimer(ITanxAd iTanxAd, int i, boolean z, int i2) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(FROM_TYPE, String.valueOf(i));
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_suc", str);
        sendUt(iTanxAd, AdUtConstants.AD_TIMER, hashMap, i2);
    }

    public static void utSplashViewClose(ITanxAd iTanxAd, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(FROM_TYPE, String.valueOf(i));
        sendUt(iTanxAd, AdUtConstants.SCREEN_VIEW_CANCEL, hashMap, 0);
    }

    public static void utSplashViewCreate(ITanxAd iTanxAd, int i, boolean z, int i2) {
        utSplashViewCreate(iTanxAd, i, z, i2, "");
    }

    public static void utSplashWebCreate(ITanxAd iTanxAd, int i) {
        sendUt(iTanxAd, AdUtConstants.WEB_DID_MOUNT, new HashMap(), i);
    }

    public static void utSplashViewCreate(ITanxAd iTanxAd, int i, boolean z, int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(FROM_TYPE, String.valueOf(i));
        hashMap.put("is_suc", z ? "1" : "0");
        sendUt(iTanxAd, AdUtConstants.SCREEN_VIEW_CREATE, hashMap, i2);
    }
}
