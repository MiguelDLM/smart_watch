package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.Map;

/* loaded from: classes.dex */
public class TanxTableScreenUt extends TanxBaseUt {
    public static void utRewardExposureTime(ITanxAd iTanxAd, long j) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
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
                str = "";
                str4 = str;
            } else {
                str6 = iTanxAd.getBidInfo().getCreativeId();
                str = iTanxAd.getBidInfo().getTemplateId();
                str4 = iTanxAd.getBidInfo().getSessionId();
            }
            str2 = str5;
            str3 = requestId;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str2, str3, str6, str);
        buildArgs.put("exposure_time", Long.valueOf(j));
        AdUtConstants adUtConstants = AdUtConstants.TABLE_SCREEN_EXPOSURE_MONITOR;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str2, str3, 0, str7, buildArgs, str4);
    }

    public static void utViewDraw(ITanxAd iTanxAd, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (iTanxAd == null) {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        } else {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() == null) {
                str3 = "";
                str4 = str3;
                str5 = str4;
                str = pid;
                str2 = requestId;
            } else {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                String templateId = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
                str3 = creativeId;
                str = pid;
                str2 = requestId;
                str4 = templateId;
            }
        }
        utViewDraw(str, str2, str3, str4, i, str5);
    }

    public static void utViewDraw(String str, String str2, String str3, String str4, int i, String str5) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, str3, str4);
        buildArgs.put("is_suc", i + "");
        int i2 = i == 1 ? 0 : 1;
        AdUtConstants adUtConstants = AdUtConstants.TABLE_SCREEN_VIEW_CREATE;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str, str2, i2, str6, buildArgs, str5);
    }
}
