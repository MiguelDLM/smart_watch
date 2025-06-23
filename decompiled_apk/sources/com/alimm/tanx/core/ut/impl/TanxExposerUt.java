package com.alimm.tanx.core.ut.impl;

import XOxoX.I0Io;
import XOxoX.oIX0oI;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.facebook.internal.NativeProtocol;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TanxExposerUt extends TanxBaseUt {
    public static void sendMonitorFail(AdMonitorType adMonitorType, String str, int i, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6;
        if (jSONObject != null) {
            String optString = jSONObject.optString("pid");
            str4 = jSONObject.optString(ExposeManager.UtArgsNames.reqId);
            str6 = jSONObject.optString("session_id");
            str5 = jSONObject.optString(ExposeManager.UtArgsNames.interactType);
            str3 = optString;
        } else {
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        Map XO2 = I0Io.XO(jSONObject);
        if (XO2 == null) {
            XO2 = new HashMap();
        }
        XO2.put(NativeProtocol.WEB_DIALOG_PARAMS, str);
        XO2.put("code", String.valueOf(i));
        XO2.put("msg", str2);
        if (adMonitorType == AdMonitorType.CLICK) {
            AdUtConstants adUtConstants = AdUtConstants.CLICK_REQUEST;
            String str7 = adUtConstants.arg1;
            TanxBaseUt.send(str7, adUtConstants.eventId, str3, str4, i, str7, str5, "", new HashMap(XO2), str6);
        } else if (adMonitorType == AdMonitorType.EXPOSE) {
            AdUtConstants adUtConstants2 = AdUtConstants.IMP_REQUEST;
            String str8 = adUtConstants2.arg1;
            TanxBaseUt.send(str8, adUtConstants2.eventId, str3, str4, i, str8, str5, "", new HashMap(XO2), str6);
        }
    }

    public static void sendMonitorSuc(AdMonitorType adMonitorType, String str, JSONObject jSONObject) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (jSONObject != null) {
            String optString = jSONObject.optString("pid");
            str3 = jSONObject.optString(ExposeManager.UtArgsNames.reqId);
            str5 = jSONObject.optString("session_id");
            str4 = jSONObject.optString(ExposeManager.UtArgsNames.interactType);
            str2 = optString;
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
        }
        Map XO2 = I0Io.XO(jSONObject);
        if (XO2 == null) {
            XO2 = new HashMap();
        }
        if (adMonitorType == AdMonitorType.CLICK) {
            AdUtConstants adUtConstants = AdUtConstants.CLICK_REQUEST;
            String str6 = adUtConstants.arg1;
            TanxBaseUt.send(str6, adUtConstants.eventId, str2, str3, 0, str6, str4, "", new HashMap(XO2), str5);
        } else if (adMonitorType == AdMonitorType.EXPOSE) {
            AdUtConstants adUtConstants2 = AdUtConstants.IMP_REQUEST;
            String str7 = adUtConstants2.arg1;
            TanxBaseUt.send(str7, adUtConstants2.eventId, str2, str3, 0, str7, str4, "", new HashMap(XO2), str5);
        } else if (adMonitorType == AdMonitorType.INTERACT_DEDUPLICATION) {
            oIX0oI.oxoX("ut imp_video_3s_request", new String[0]);
            AdUtConstants adUtConstants3 = AdUtConstants.IMP_VIDEO_3S_REQUEST;
            String str8 = adUtConstants3.arg1;
            TanxBaseUt.send(str8, adUtConstants3.eventId, str2, str3, 0, str8, str4, "", new HashMap(XO2), str5);
        }
    }
}
