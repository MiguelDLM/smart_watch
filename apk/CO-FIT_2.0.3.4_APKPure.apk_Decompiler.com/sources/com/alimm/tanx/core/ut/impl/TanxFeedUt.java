package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.Map;

public class TanxFeedUt extends TanxBaseUt {
    public static void utClose(ITanxAd iTanxAd, int i) {
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
            if (iTanxAd.getBidInfo() != null) {
                String requestId = iTanxAd.getRequestId();
                str5 = iTanxAd.getBidInfo().getCreativeId();
                str4 = iTanxAd.getBidInfo().getTemplateId();
                str = iTanxAd.getBidInfo().getSessionId();
                str3 = str6;
                str2 = requestId;
            } else {
                str5 = "";
                str4 = str5;
                str2 = str4;
                str = str2;
                str3 = str6;
            }
        } else {
            str5 = "";
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str2, str5, str4);
        buildArgs.put("option", i + "");
        AdUtConstants adUtConstants = AdUtConstants.FLOW_VIEW_CANCEL;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str3, str2, str7, buildArgs, str);
    }

    public static void utViewDraw(ITanxAd iTanxAd, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i2;
        String str7;
        String str8;
        int i3 = i;
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str7 = iTanxAd.getAdSlot().getPid();
            } else {
                str7 = "";
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str6 = iTanxAd.getBidInfo().getCreativeId();
                str5 = iTanxAd.getBidInfo().getTemplateId();
                String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null) {
                    if (iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() != null) {
                        str8 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                    } else {
                        str8 = "";
                    }
                    str4 = str7;
                    str3 = requestId;
                    str = sessionId;
                    str2 = str8;
                } else {
                    str2 = "";
                    str4 = str7;
                    str3 = requestId;
                    str = sessionId;
                }
            } else {
                str6 = "";
                str5 = str6;
                str2 = str5;
                str = str2;
                str4 = str7;
                str3 = requestId;
            }
        } else {
            str6 = "";
            str5 = str6;
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str4, str3, str6, str5);
        buildArgs.put("is_suc", i3 + "");
        if (i3 == 1) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        AdUtConstants adUtConstants = AdUtConstants.FLOW_VIEW_CREATE;
        String str9 = adUtConstants.arg1;
        TanxBaseUt.send(str9, adUtConstants.eventId, i2, str4, str3, str9, "", str2, buildArgs, str);
    }
}
