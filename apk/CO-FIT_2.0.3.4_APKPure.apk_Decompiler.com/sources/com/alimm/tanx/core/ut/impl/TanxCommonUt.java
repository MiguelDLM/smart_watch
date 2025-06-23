package com.alimm.tanx.core.ut.impl;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.utils.LogUtils;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TanxCommonUt extends TanxBaseUt {
    public static final String IS_SUC = "is_suc";

    public static void cacheCheck(ITanxAd iTanxAd, String str, int i, Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_url", str);
        if (exc != null) {
            hashMap.put("error", LogUtils.getStackTraceMessage(exc));
        }
        sendUt(iTanxAd, AdUtConstants.CACHE_CHECK, hashMap, i);
    }

    public static void fileSizeCheck(ITanxAd iTanxAd, long j, int i, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("file_size", j + "");
        hashMap.put("file_size_m", ((((double) j) / 1024.0d) / 1024.0d) + "");
        hashMap.put("time", j2 + "");
        sendUt(iTanxAd, AdUtConstants.FILE_SIZE_CHECK, hashMap, i);
    }

    public static void sendAdRqFail(String str, String str2, String str3, long j, int i, String str4, String str5) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str2, str3, (String) null, (String) null);
        String str6 = str;
        buildArgs.put("scenes", str);
        buildArgs.put("request_time", String.valueOf(j));
        buildArgs.put(NativeProtocol.WEB_DIALOG_PARAMS, str5);
        String str7 = str4;
        buildArgs.put("msg", str4);
        AdUtConstants adUtConstants = AdUtConstants.AD_REQUEST;
        String str8 = adUtConstants.arg1;
        String str9 = str8;
        TanxBaseUt.send(str9, adUtConstants.eventId, str2, str3, i, str8, buildArgs, "");
    }

    public static void sendAdRqSuc(String str, TanxAdSlot tanxAdSlot, String str2, long j, int i, AdInfo adInfo) {
        int i2;
        ArrayList arrayList = new ArrayList();
        if (!(adInfo == null || adInfo.getBidInfoList() == null || adInfo.getBidInfoList().size() <= 0)) {
            for (int i3 = 0; i3 < adInfo.getBidInfoList().size(); i3++) {
                arrayList.add(adInfo.getBidInfoList().get(i3).getTemplateId());
            }
        }
        String str3 = str2;
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str2, (String) null, (String) null);
        String str4 = str;
        buildArgs.put("scenes", str);
        buildArgs.put(ExposeManager.UtArgsNames.templateId, arrayList.toString());
        buildArgs.put("ad_count", String.valueOf(tanxAdSlot.getAdCount()));
        buildArgs.put("result_ad_count", String.valueOf(i));
        buildArgs.put("request_time", String.valueOf(j));
        AdUtConstants adUtConstants = AdUtConstants.AD_REQUEST;
        String str5 = adUtConstants.arg1;
        int i4 = adUtConstants.eventId;
        String pid = tanxAdSlot.getPid();
        if (adInfo == null) {
            i2 = -1;
        } else {
            i2 = adInfo.getStatus();
        }
        TanxBaseUt.send(str5, i4, pid, str2, i2, adUtConstants.arg1, buildArgs, "");
    }

    public static void sendClickExposureFail(String str, String str2, IBidInfo iBidInfo, String str3, int i, String str4) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        String str5 = str3;
        buildArgs.put(NativeProtocol.WEB_DIALOG_PARAMS, str3);
        buildArgs.put("msg", str4);
        AdUtConstants adUtConstants = AdUtConstants.CLICK_REQUEST;
        String str6 = adUtConstants.arg1;
        int i2 = adUtConstants.eventId;
        TanxBaseUt.send(str6, i2, str, str2, i, str6, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendClickExposureSuc(String str, String str2, IBidInfo iBidInfo, String str3) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        AdUtConstants adUtConstants = AdUtConstants.CLICK_REQUEST;
        String str4 = adUtConstants.arg1;
        int i = adUtConstants.eventId;
        TanxBaseUt.send(str4, i, str, str2, 0, str4, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendDownH5ZipFail(String str, int i, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_PARAMS, str);
        hashMap.put("code", i + "");
        hashMap.put("msg", str2);
        AdUtConstants adUtConstants = AdUtConstants.DOWN_H5_ZIP;
        String str3 = adUtConstants.arg1;
        TanxBaseUt.send(str3, adUtConstants.eventId, i, str3, hashMap, "");
    }

    public static void sendExposureFail(String str, String str2, IBidInfo iBidInfo, String str3, int i, String str4) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        String str5 = str3;
        buildArgs.put(NativeProtocol.WEB_DIALOG_PARAMS, str3);
        buildArgs.put("code", i + "");
        buildArgs.put("msg", str4);
        AdUtConstants adUtConstants = AdUtConstants.IMP_REQUEST;
        String str6 = adUtConstants.arg1;
        int i2 = adUtConstants.eventId;
        TanxBaseUt.send(str6, i2, str, str2, i, str6, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendExposureSuc(String str, String str2, IBidInfo iBidInfo, String str3) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        AdUtConstants adUtConstants = AdUtConstants.IMP_REQUEST;
        String str4 = adUtConstants.arg1;
        int i = adUtConstants.eventId;
        TanxBaseUt.send(str4, i, str, str2, 0, str4, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendIntoMethod(TanxAdSlot tanxAdSlot, String str, IBidInfo iBidInfo, String str2, AdUtConstants adUtConstants) {
        sendIntoMethod(tanxAdSlot, str, iBidInfo, str2, adUtConstants, new HashMap());
    }

    public static void sendNewConfigFail(String str, long j, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String str4 = str;
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_PARAMS, str3);
        hashMap.put("msg", str2);
        AdUtConstants adUtConstants = AdUtConstants.NEW_CONFIG_MONITOR;
        TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, "", str4, i, String.valueOf(j), hashMap, "");
    }

    public static void sendNewConfigSuc(String str, long j) {
        String str2;
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str;
        }
        AdUtConstants adUtConstants = AdUtConstants.NEW_CONFIG_MONITOR;
        String str3 = adUtConstants.arg1;
        int i = adUtConstants.eventId;
        TanxBaseUt.send(str3, i, "", str2, 0, j + "", hashMap, "");
    }

    public static void sendRewardRqFail(String str, long j, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String str4 = str;
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_PARAMS, str3);
        hashMap.put("msg", str2);
        AdUtConstants adUtConstants = AdUtConstants.REWARD_REQUEST;
        TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, "", str4, i, String.valueOf(j), hashMap, "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        if (r8 != null) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void sendRewardRqSuc(java.lang.String r8, long r9, com.alimm.tanx.core.ad.bean.RewardResponse r11) {
        /*
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x000f
            r3 = r1
            goto L_0x0010
        L_0x000f:
            r3 = r8
        L_0x0010:
            if (r11 == 0) goto L_0x003a
            java.util.List r8 = r11.getPidRewards()     // Catch:{ Exception -> 0x0034 }
            if (r8 == 0) goto L_0x003a
            java.util.List r8 = r11.getPidRewards()     // Catch:{ Exception -> 0x0034 }
            int r8 = r8.size()     // Catch:{ Exception -> 0x0034 }
            if (r8 <= 0) goto L_0x003a
            java.util.List r8 = r11.getPidRewards()     // Catch:{ Exception -> 0x0034 }
            r11 = 0
            java.lang.Object r8 = r8.get(r11)     // Catch:{ Exception -> 0x0034 }
            com.alimm.tanx.core.ad.bean.RewardResponse$PidRewards r8 = (com.alimm.tanx.core.ad.bean.RewardResponse.PidRewards) r8     // Catch:{ Exception -> 0x0034 }
            java.lang.String r8 = r8.getPid()     // Catch:{ Exception -> 0x0034 }
            if (r8 == 0) goto L_0x003a
            goto L_0x003b
        L_0x0034:
            r8 = move-exception
            com.alimm.tanx.core.utils.LogUtils.e(r8)
            r2 = r1
            goto L_0x003c
        L_0x003a:
            r8 = r1
        L_0x003b:
            r2 = r8
        L_0x003c:
            com.alimm.tanx.core.ut.AdUtConstants r8 = com.alimm.tanx.core.ut.AdUtConstants.REWARD_REQUEST
            java.lang.String r0 = r8.arg1
            int r8 = r8.eventId
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            r11.append(r1)
            java.lang.String r5 = r11.toString()
            java.lang.String r7 = ""
            r4 = 0
            r1 = r8
            com.alimm.tanx.core.ut.impl.TanxBaseUt.send(r0, r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ut.impl.TanxCommonUt.sendRewardRqSuc(java.lang.String, long, com.alimm.tanx.core.ad.bean.RewardResponse):void");
    }

    public static void sendStartImp(TanxAdSlot tanxAdSlot, String str, IBidInfo iBidInfo, int i) {
        String str2;
        if (tanxAdSlot != null) {
            str2 = tanxAdSlot.getPid();
        } else {
            str2 = "";
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str2, str, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put("scenes", TanxAdType.getAdTypeStr(i) + "");
        TanxBaseUt.buildAntiCheatParam(buildArgs);
        AdUtConstants adUtConstants = AdUtConstants.START_IMP;
        String str3 = adUtConstants.arg1;
        int i2 = adUtConstants.eventId;
        TanxBaseUt.send(str3, i2, str2, str, str3, iBidInfo.getInteractType2Int() + "", (String) null, buildArgs, iBidInfo.getSessionId());
    }

    public static void sendUt(ITanxAd iTanxAd, AdUtConstants adUtConstants, HashMap<String, String> hashMap, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        AdUtConstants adUtConstants2 = adUtConstants;
        String str7 = "";
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str5 = iTanxAd.getAdSlot().getPid();
            } else {
                str5 = str7;
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str6 = iTanxAd.getBidInfo().getCreativeId();
            } else {
                str6 = str7;
            }
            if (iTanxAd.getBidInfo() != null) {
                str4 = iTanxAd.getBidInfo().getTemplateId();
            } else {
                str4 = str7;
            }
            if (iTanxAd.getBidInfo() != null) {
                str7 = iTanxAd.getBidInfo().getSessionId();
            }
            str = str7;
            str3 = str5;
            str2 = requestId;
            str7 = str6;
        } else {
            str4 = str7;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str2, str7, str4);
        buildArgs.putAll(hashMap);
        String str8 = adUtConstants2.arg1;
        TanxBaseUt.send(str8, adUtConstants2.eventId, str3, str2, i, str8, "", "", buildArgs, str);
    }

    public static void utShakeDestroy(ITanxAd iTanxAd, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = "";
        if (iTanxAd != null) {
            try {
                if (iTanxAd.getAdSlot() != null) {
                    str7 = iTanxAd.getAdSlot().getPid();
                } else {
                    str7 = str8;
                }
                String requestId = iTanxAd.getRequestId();
                if (iTanxAd.getBidInfo() != null) {
                    String creativeId = iTanxAd.getBidInfo().getCreativeId();
                    str5 = iTanxAd.getBidInfo().getTemplateId();
                    String sessionId = iTanxAd.getBidInfo().getSessionId();
                    if (!(iTanxAd.getBidInfo().getTemplateConf() == null || iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() == null)) {
                        str8 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                    }
                    str4 = str8;
                    str2 = requestId;
                    str8 = creativeId;
                    str3 = sessionId;
                    str6 = str7;
                } else {
                    str5 = str8;
                    str4 = str5;
                    str3 = str4;
                    str6 = str7;
                    str2 = requestId;
                }
            } catch (Exception e) {
                LogUtils.e(e);
                return;
            }
        } else {
            str2 = str8;
            str6 = str2;
            str5 = str6;
            str4 = str5;
            str3 = str4;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str6, str2, str8, str5);
        if (OrangeManager.getInstance().getCommonSwitch("antiCheatingSwitch")) {
            buildArgs.put("sensor_list", str);
        }
        AdUtConstants adUtConstants = AdUtConstants.SHAKE_DESTROY;
        String str9 = adUtConstants.arg1;
        TanxBaseUt.send(str9, adUtConstants.eventId, 1, str6, str2, str9, "", str4, buildArgs, str3);
    }

    public static void utTimer(ITanxAd iTanxAd, boolean z, int i) {
        String str;
        HashMap hashMap = new HashMap();
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_suc", str);
        sendUt(iTanxAd, AdUtConstants.AD_TIMER, hashMap, i);
    }

    public static void utWebStartLoad(ITanxAd iTanxAd) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str6 = iTanxAd.getAdSlot().getPid();
            } else {
                str6 = str7;
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                str5 = iTanxAd.getBidInfo().getTemplateId();
                String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (!(iTanxAd.getBidInfo().getTemplateConf() == null || iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() == null)) {
                    str7 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str2 = str7;
                str4 = str6;
                str3 = requestId;
                str7 = creativeId;
                str = sessionId;
            } else {
                str5 = str7;
                str2 = str5;
                str = str2;
                str4 = str6;
                str3 = requestId;
            }
        } else {
            str5 = str7;
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str4, str3, str7, str5);
        AdUtConstants adUtConstants = AdUtConstants.WEB_START_LOAD;
        String str8 = adUtConstants.arg1;
        TanxBaseUt.send(str8, adUtConstants.eventId, 1, str4, str3, str8, "", str2, buildArgs, str);
    }

    public static void sendIntoMethod(TanxAdSlot tanxAdSlot, String str, IBidInfo iBidInfo, String str2, AdUtConstants adUtConstants, Map<String, String> map) {
        String pid = tanxAdSlot != null ? tanxAdSlot.getPid() : "";
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(pid, str, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        if (map != null) {
            buildArgs.putAll(map);
        }
        buildArgs.put("method_name", str2);
        String str3 = adUtConstants.arg1;
        TanxBaseUt.send(str3, adUtConstants.eventId, pid, str, str3, buildArgs, iBidInfo.getSessionId());
    }
}
