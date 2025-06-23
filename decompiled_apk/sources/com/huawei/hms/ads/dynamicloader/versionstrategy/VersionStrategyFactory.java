package com.huawei.hms.ads.dynamicloader.versionstrategy;

import com.huawei.hms.ads.uiengineloader.ak;
import com.huawei.hms.ads.uiengineloader.al;
import com.huawei.hms.ads.uiengineloader.am;

/* loaded from: classes10.dex */
public class VersionStrategyFactory {
    public static final int PREFER_DECOMPRESS = 1;
    public static final int PREFER_HIGHEST_OR_DECOMPRESS = 2;

    public static am getVersionPolicy(int i) {
        if (i == 1) {
            return new ak();
        }
        if (i != 2) {
            return null;
        }
        return new al();
    }
}
