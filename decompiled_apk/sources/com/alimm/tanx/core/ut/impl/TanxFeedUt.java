package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.Map;

/* loaded from: classes.dex */
public class TanxFeedUt extends TanxBaseUt {
    public static void utClose(ITanxAd iTanxAd, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (iTanxAd == null) {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        } else {
            if (iTanxAd.getAdSlot() == null) {
                str6 = "";
            } else {
                str6 = iTanxAd.getAdSlot().getPid();
            }
            if (iTanxAd.getBidInfo() == null) {
                str = "";
                str2 = str;
                str4 = str2;
                str5 = str4;
                str3 = str6;
            } else {
                String requestId = iTanxAd.getRequestId();
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
                str3 = str6;
                str4 = requestId;
            }
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put("option", i + "");
        AdUtConstants adUtConstants = AdUtConstants.FLOW_VIEW_CANCEL;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str3, str4, str7, buildArgs, str5);
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
        if (iTanxAd == null) {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
        } else {
            if (iTanxAd.getAdSlot() == null) {
                str7 = "";
            } else {
                str7 = iTanxAd.getAdSlot().getPid();
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() == null) {
                str = "";
                str2 = str;
                str5 = str2;
                str6 = str5;
                str3 = str7;
                str4 = requestId;
            } else {
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() == null) {
                    str5 = "";
                    str3 = str7;
                    str4 = requestId;
                    str6 = sessionId;
                } else {
                    if (iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() == null) {
                        str8 = "";
                    } else {
                        str8 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                    }
                    str3 = str7;
                    str4 = requestId;
                    str6 = sessionId;
                    str5 = str8;
                }
            }
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put("is_suc", i + "");
        if (i == 1) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        AdUtConstants adUtConstants = AdUtConstants.FLOW_VIEW_CREATE;
        String str9 = adUtConstants.arg1;
        TanxBaseUt.send(str9, adUtConstants.eventId, i2, str3, str4, str9, "", str5, buildArgs, str6);
    }
}
