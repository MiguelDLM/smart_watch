package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.huawei.openalliance.ad.constant.bn;
import java.util.Map;

/* loaded from: classes.dex */
public class TanxInterfaceUt extends TanxBaseUt {
    public static final String CALLBACK_ERROR = "error";
    public static final String CALLBACK_SUCCESS = "success";
    public static final String CALLBACK_TIMEOUT = "time_out";
    public static final String REQUEST_FEED = "flow_request_invoke";
    public static final String REQUEST_REWARD_VIDEO = "reward_request_invoke";
    public static final String REQUEST_TABLE_SCREEN = "table_screen_request_invoke";
    public static final String REWARD_VIDEO_START_CACHE = "reward_video_start_cache";
    public static final String SPLASH_PRELOAD = "splash_preload";
    public static final String TEMPLATE_FEED = "flow_template_invoke";
    public static final String TEMPLATE_REWARD = "reward_video_template_invoke";
    public static final String TEMPLATE_SPLASH = "splash_template_invoke";
    public static final String TEMPLATE_TABLE_SCREEN = "table_screen_template_invoke";

    public static void sendMethodCallback(TanxAdSlot tanxAdSlot, String str, String str2) {
        sendMethodCallback(tanxAdSlot, str, str2, -1L);
    }

    public static void sendMethodInvoke(String str, String str2) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str);
        buildArgs.put("method", str2);
        AdUtConstants adUtConstants = AdUtConstants.METHOD_INVOKE;
        String str3 = adUtConstants.arg1;
        TanxBaseUt.send(str3, adUtConstants.eventId, str, null, str3, buildArgs, "");
    }

    public static void sendMethodCallback(TanxAdSlot tanxAdSlot, String str, String str2, long j) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(tanxAdSlot.getPid());
        buildArgs.put("method", str);
        buildArgs.put(bn.f.L, str2);
        if (j != -1) {
            buildArgs.put("timeConsuming", j + "");
        }
        AdUtConstants adUtConstants = AdUtConstants.METHOD_INVOKE_CALLBACK;
        TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, tanxAdSlot.getPid(), tanxAdSlot.getReqId(), adUtConstants.arg1, buildArgs, "");
    }
}
