package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.Map;

public class TanxTableScreenUt extends TanxBaseUt {
    public static void utRewardExposureTime(ITanxAd iTanxAd, long j) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str5 = iTanxAd.getAdSlot().getPid();
            } else {
                str5 = str6;
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str6 = iTanxAd.getBidInfo().getCreativeId();
                str4 = iTanxAd.getBidInfo().getTemplateId();
                str = iTanxAd.getBidInfo().getSessionId();
            } else {
                str4 = str6;
                str = str4;
            }
            str3 = str5;
            str2 = requestId;
        } else {
            str4 = str6;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str2, str6, str4);
        buildArgs.put("exposure_time", Long.valueOf(j));
        AdUtConstants adUtConstants = AdUtConstants.TABLE_SCREEN_EXPOSURE_MONITOR;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str3, str2, 0, str7, buildArgs, str);
    }

    public static void utViewDraw(ITanxAd iTanxAd, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str6 = iTanxAd.getAdSlot().getPid();
            } else {
                str6 = "";
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                String templateId = iTanxAd.getBidInfo().getTemplateId();
                str = iTanxAd.getBidInfo().getSessionId();
                str3 = creativeId;
                str5 = str6;
                str4 = requestId;
                str2 = templateId;
            } else {
                str3 = "";
                str2 = str3;
                str = str2;
                str5 = str6;
                str4 = requestId;
            }
        } else {
            str5 = "";
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        utViewDraw(str5, str4, str3, str2, i, str);
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
