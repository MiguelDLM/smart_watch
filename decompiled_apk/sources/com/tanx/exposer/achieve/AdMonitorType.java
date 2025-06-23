package com.tanx.exposer.achieve;

/* loaded from: classes13.dex */
public enum AdMonitorType {
    CLICK("点击"),
    EXPOSE("曝光"),
    INTERACT("互动"),
    INTERACT_DEDUPLICATION("互动,带去重能力");

    String description;

    AdMonitorType(String str) {
        this.description = str;
    }

    public static boolean inSystemTypes(AdMonitorType adMonitorType) {
        if (adMonitorType == null) {
            return false;
        }
        if (adMonitorType != CLICK && adMonitorType != EXPOSE && adMonitorType != INTERACT && adMonitorType != INTERACT_DEDUPLICATION) {
            return false;
        }
        return true;
    }
}
