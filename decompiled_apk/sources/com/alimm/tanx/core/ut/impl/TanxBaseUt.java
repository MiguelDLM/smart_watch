package com.alimm.tanx.core.ut.impl;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.interaction.AdClickInfo;
import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.BiddingBean;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.bean.UtAntiCheat;
import com.alimm.tanx.core.ut.bean.UtErrorBean;
import com.alimm.tanx.core.ut.bean.UtItemH5Bean;
import com.alimm.tanx.core.utils.AntiCheatUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.SysUtils;
import com.huawei.openalliance.ad.uriaction.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x0oxIIIX.oIX0oI;

/* loaded from: classes.dex */
public class TanxBaseUt implements NotConfused {
    public static void biddingResult(List<ITanxAd> list) {
        String str;
        if (list != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            sb.append(list.get(0).getScene());
            sb.append("");
            hashMap.put("scenes", sb.toString());
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            String str3 = str2;
            int i2 = 0;
            for (ITanxAd iTanxAd : list) {
                BiddingBean biddingBean = new BiddingBean();
                if (iTanxAd != null) {
                    if (iTanxAd.getAdSlot() == null) {
                        str2 = "";
                    } else {
                        str2 = iTanxAd.getAdSlot().getPid();
                    }
                    biddingBean.setPid(str2);
                    str3 = iTanxAd.getRequestId();
                    if (iTanxAd.getBidInfo() != null) {
                        biddingBean.setReqId(iTanxAd.getRequestId());
                        biddingBean.setCreative_id(iTanxAd.getBidInfo().getCreativeId());
                        biddingBean.setTemplate_id(iTanxAd.getBidInfo().getTemplateId());
                        biddingBean.setSessionId(iTanxAd.getBidInfo().getSessionId());
                    }
                    if (iTanxAd.getBiddingInfo() != null) {
                        if (iTanxAd.getBiddingInfo().isBidResult()) {
                            i++;
                        } else {
                            i2++;
                        }
                        if (iTanxAd.getBiddingInfo().isBidResult()) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        biddingBean.setIs_suc(str);
                        biddingBean.setPrice(iTanxAd.getBiddingInfo().getAdPrice() + "");
                    }
                }
                arrayList.add(biddingBean);
            }
            hashMap.put("createList", arrayList);
            AdUtConstants adUtConstants = AdUtConstants.BIDDING_CHECK;
            String str4 = adUtConstants.arg1;
            send(str4, adUtConstants.eventId, str2, str3, str4, i + "", i2 + "", hashMap, "");
        }
    }

    public static Map<String, Object> buildAntiCheatParam(Map<String, Object> map) {
        if (OrangeManager.getInstance().getCommonSwitch("antiCheatingSwitch")) {
            UtAntiCheat utAntiCheat = new UtAntiCheat();
            utAntiCheat.currentVolume = AntiCheatUtil.getInstance().getCurrentVolume(TanxCoreSdk.getApplication());
            utAntiCheat.battery = AntiCheatUtil.getInstance().getBatteryPercentage(TanxCoreSdk.getApplication());
            utAntiCheat.charge = AntiCheatUtil.getInstance().isCharging(TanxCoreSdk.getApplication());
            utAntiCheat.systemAlertPermissions = AntiCheatUtil.getInstance().isSystemAlertPermissions(TanxCoreSdk.getApplication());
            utAntiCheat.accessibilityEnabled = AntiCheatUtil.getInstance().accessibilityEnabled(TanxCoreSdk.getApplication());
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("af", JSON.toJSONString(utAntiCheat));
        }
        return map;
    }

    public static Map<String, Object> buildArgs(String str) {
        return buildArgs(str, null, null, null);
    }

    public static void h5Ut(UtItemH5Bean utItemH5Bean) {
        track(utItemH5Bean.page, utItemH5Bean.pid, utItemH5Bean.reqId, utItemH5Bean.eventId, utItemH5Bean.eventStatus, utItemH5Bean.arg1, utItemH5Bean.arg2, utItemH5Bean.arg3, utItemH5Bean.args, "");
    }

    public static void send(String str, int i, String str2, String str3, int i2, String str4, Map<String, Object> map, String str5) {
        track(str, str2, str3, i, i2, str4, null, null, map, str5);
    }

    public static void shake(String str, BidInfo bidInfo, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2;
        String str2;
        String str3;
        String str4 = "";
        if (bidInfo != null) {
            String str5 = bidInfo.getId() + "";
            String creativeId = bidInfo.getCreativeId();
            String str6 = bidInfo.getOpenType() + "";
            String templateId = bidInfo.getTemplateId();
            String sessionId = bidInfo.getSessionId();
            Map<String, Object> buildArgs = buildArgs("", str5, creativeId, templateId);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.putAll(buildArgs);
            if (TanxCoreSdk.getConfig() != null) {
                str4 = TanxCoreSdk.getConfig().getAppId();
            }
            hashMap.put(i.Code, str4);
            hashMap.put("reqId", str5);
            hashMap.put("openType", str6);
            hashMap.put("creativeId", creativeId);
            str3 = sessionId;
            hashMap2 = hashMap;
            str2 = str5;
        } else {
            hashMap2 = hashMap;
            str2 = "";
            str3 = str2;
        }
        AdUtConstants adUtConstants = AdUtConstants.SHAKE;
        String str7 = adUtConstants.arg1;
        send(str7, adUtConstants.eventId, "", str2, str7, null, str, hashMap2, str3);
    }

    public static void track(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        oIX0oI userTracker = TanxCoreManager.getInstance().getUserTracker();
        ITanxUserTracker tanxUserTracker = TanxCoreManager.getInstance().getTanxUserTracker();
        if (userTracker != null) {
            userTracker.oIX0oI(str, i, str4, str5, str6, map);
        } else if (tanxUserTracker != null) {
            tanxUserTracker.track(str, str2, str3, i, i2, str4, str5, str6, map, str7);
        }
    }

    public static void utClick(AdClickInfo adClickInfo, boolean z, String str, String str2, String str3) {
        if (adClickInfo != null) {
            String pid = adClickInfo.getPid();
            String str4 = adClickInfo.getAdType() + "";
            String reqId = adClickInfo.getReqId();
            String creativeId = adClickInfo.getCreativeId();
            String str5 = adClickInfo.getOpenType() + "";
            String templateId = adClickInfo.getTemplateId();
            String sessionId = adClickInfo.getSessionId();
            String pidStyleId = adClickInfo.getPidStyleId();
            Map<String, Object> buildArgs = buildArgs(pid, reqId, creativeId, templateId);
            buildArgs.putAll(adClickInfo.getUtArgs());
            buildArgs.put("adType", str4);
            buildArgs.put("dpUrlNull", Integer.valueOf(TextUtils.isEmpty(str2) ? 1 : 0));
            buildArgs.put("h5UrlNull", Integer.valueOf(TextUtils.isEmpty(str3) ? 1 : 0));
            buildArgs.put("openType", str5);
            buildArgs.put("pidStyleId", pidStyleId);
            String obj = SysUtils.getInstallStatus().toString();
            if (z) {
                AdUtConstants adUtConstants = AdUtConstants.DEEP_LINK_OPEN;
                String str6 = adUtConstants.arg1;
                send(str6, adUtConstants.eventId, pid, reqId, str6, obj, "", buildArgs, sessionId);
                return;
            }
            buildArgs.put("dpUrl", str2 + "");
            buildArgs.put("h5Url", str3 + "");
            AdUtConstants adUtConstants2 = AdUtConstants.LANDING_H5;
            String str7 = adUtConstants2.arg1;
            send(str7, adUtConstants2.eventId, pid, reqId, str7, obj, "", buildArgs, sessionId);
        }
    }

    public static void utError(int i, Exception exc) {
        utError(i, exc, "");
    }

    public static void utErrorCode(ITanxAd iTanxAd, UtErrorCode utErrorCode) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (utErrorCode == null) {
            return;
        }
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
        Map<String, Object> buildArgs = buildArgs(str2, str3, str7, str);
        AdUtConstants adUtConstants = AdUtConstants.SDK_ERROR_CODE;
        send(adUtConstants.arg1, adUtConstants.eventId, str2, str3, utErrorCode.getIntCode(), utErrorCode.getMsg(), buildArgs, str4);
    }

    public static void utNavigate(AdClickInfo adClickInfo, String str, String str2, String str3, String str4) {
        if (adClickInfo != null) {
            String pid = adClickInfo.getPid();
            String reqId = adClickInfo.getReqId();
            String creativeId = adClickInfo.getCreativeId();
            String str5 = adClickInfo.getOpenType() + "";
            String templateId = adClickInfo.getTemplateId();
            String sessionId = adClickInfo.getSessionId();
            String pidStyleId = adClickInfo.getPidStyleId();
            Map<String, Object> buildArgs = buildArgs(pid, reqId, creativeId, templateId);
            buildArgs.putAll(adClickInfo.getUtArgs());
            buildArgs.put("dpUrlNull", Integer.valueOf(TextUtils.isEmpty(str3) ? 1 : 0));
            buildArgs.put("h5UrlNull", Integer.valueOf(TextUtils.isEmpty(str4) ? 1 : 0));
            buildArgs.put("openType", str5);
            buildArgs.put("pidStyleId", pidStyleId);
            send(adClickInfo.getAdUtConstants().arg1, adClickInfo.getAdUtConstants().eventId, pid, reqId, adClickInfo.getAdUtConstants().arg1, SysUtils.getInstallStatus().toString(), str, buildArgs, sessionId);
        }
    }

    public static void utNetError(int i, String str, UtErrorBean utErrorBean, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str2)) {
            str2 = "main";
        }
        hashMap.put("taskName", str2);
        hashMap.put("msg", utErrorBean.toString());
        hashMap.put("tag", str);
        if (hashMap.get("msg") != null && hashMap.get("msg").toString().contains("Unable to resolve host")) {
            return;
        }
        AdUtConstants adUtConstants = AdUtConstants.EXCEPTION_MSG;
        String str3 = adUtConstants.arg1;
        send(str3, adUtConstants.eventId, "", "", i, str3, hashMap, "");
    }

    public static Map<String, Object> buildArgs(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(ExposeManager.UtArgsNames.templateId, str4);
        hashMap.put(ExposeManager.UtArgsNames.creativeId, str3);
        return hashMap;
    }

    public static void send(String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        track(str, str2, str3, i, i2, str4, str5, str6, map, str7);
    }

    public static void utError(int i, Exception exc, String str) {
        utError(i, "", exc, str);
    }

    public static void send(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        track(str, str2, str3, i, i2, str4, str5, str6, map, str7);
    }

    public static void utError(int i, String str, Exception exc, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str2)) {
            str2 = "main";
        }
        hashMap.put("taskName", str2);
        hashMap.put("msg", LogUtils.getStackTraceMessage(exc));
        hashMap.put("tag", str);
        if (hashMap.get("msg") == null || !hashMap.get("msg").toString().contains("Unable to resolve host")) {
            AdUtConstants adUtConstants = AdUtConstants.EXCEPTION_MSG;
            String str3 = adUtConstants.arg1;
            send(str3, adUtConstants.eventId, "", "", i, str3, hashMap, "");
        }
    }

    public static void send(String str, int i, String str2, String str3, String str4, Map<String, Object> map, String str5) {
        track(str, str2, str3, i, 0, str4, null, null, map, str5);
    }

    public static void send(String str, int i, String str2, String str3, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        track(str, str2, str3, i, 0, str4, str5, str6, map, str7);
    }

    public static void send(String str, int i, int i2, String str2, Map<String, Object> map, String str3) {
        track(str, "", "", i, i2, str2, null, null, map, str3);
    }

    public static void utError(int i, String str, String str2, String str3) {
        utError(i, str, str2, str3, "", "", "", "");
    }

    public static void utError(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap();
        hashMap.put("taskName", TextUtils.isEmpty(str3) ? "main" : str3);
        hashMap.put("msg", str2);
        hashMap.put("tag", str);
        if (hashMap.get("msg") == null || !hashMap.get("msg").toString().contains("Unable to resolve host")) {
            AdUtConstants adUtConstants = AdUtConstants.EXCEPTION_MSG;
            String str8 = adUtConstants.arg1;
            send(str8, adUtConstants.eventId, str4, str5, i, str8, str6, str7, hashMap, "");
        }
    }
}
