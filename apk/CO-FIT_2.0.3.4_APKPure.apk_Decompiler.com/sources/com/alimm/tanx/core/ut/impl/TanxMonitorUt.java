package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.HashMap;
import java.util.Map;

public class TanxMonitorUt extends TanxBaseUt {
    private static final String TAG = "TanxMonitorUt";

    public static boolean isOpen(String str) {
        Boolean bool;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null) {
            return true;
        }
        OrangeUtBean orangeUtBean = orangeBean.ut;
        if (orangeUtBean != null && (bool = orangeUtBean.utSwitch) != null && !bool.booleanValue()) {
            return false;
        }
        HashMap<String, String> hashMap = orangeBean.commonSwitch;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return true;
        }
        return "true".equalsIgnoreCase(orangeBean.commonSwitch.get(str));
    }

    public static boolean isOpenFeedMonitor() {
        return isOpen(AdUtConstants.FLOW_VIEW_EXPOSURE_MONITOR.arg1);
    }

    public static boolean isOpenSplashMonitor() {
        return isOpen(AdUtConstants.SCREEN_VIEW_EXPOSURE_MONITOR.arg1);
    }

    public static void sendFeedMonitor(TanxAdSlot tanxAdSlot, String str, String str2, String str3, Map<String, Object> map, String str4) {
        if (map == null) {
            map = TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str, str3, str2);
        } else {
            map.putAll(TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str, str3, str2));
        }
        Map<String, Object> map2 = map;
        AdUtConstants adUtConstants = AdUtConstants.FLOW_VIEW_EXPOSURE_MONITOR;
        TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, tanxAdSlot.getPid(), str, adUtConstants.arg1, map2, str4);
    }

    public static void sendImageMonitor(int i, int i2, String str, boolean z) {
        AdUtConstants adUtConstants = AdUtConstants.IMAGE_MONITOR;
        HashMap hashMap = new HashMap();
        hashMap.put("imgType", str);
        if (z) {
            hashMap.put("loadPoint", "1");
        } else {
            hashMap.put("loadPoint", "-1");
        }
        String str2 = adUtConstants.arg1;
        TanxBaseUt.send(str2, adUtConstants.eventId, (String) null, (String) null, str2, i + "", i2 + "", hashMap, (String) null);
    }

    public static void sendSplashMonitor(TanxAdSlot tanxAdSlot, String str, String str2, String str3, int i, int i2, Map<String, Object> map, String str4) {
        if (map == null) {
            map = TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str, str3, str2);
        } else {
            map.putAll(TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str, str3, str2));
        }
        Map<String, Object> map2 = map;
        map2.put(TanxSplashUt.FROM_TYPE, String.valueOf(i));
        map2.put("close_type", String.valueOf(i2));
        AdUtConstants adUtConstants = AdUtConstants.SCREEN_VIEW_EXPOSURE_MONITOR;
        TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, tanxAdSlot.getPid(), str, adUtConstants.arg1, map2, str4);
    }
}
