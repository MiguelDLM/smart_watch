package com.alimm.tanx.core.constant;

import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class TanxAdType implements NotConfused {
    public static final int FEED = 2;
    public static final String FEED_STRING = "flow";
    public static final int REWARD = 4;
    public static final String REWARD_STRING = "reward";
    public static final int REWARD_VIDEO = 3;
    public static final String REWARD_VIDEO_STRING = "rewardVideo";
    public static final int SPLASH = 1;
    public static final String SPLASH_STRING = "screen";
    public static final int TABLE_SCREEN = 5;
    public static final String TABLE_SCREEN_STRING = "tableScreen";

    public static String getAdTypeStr(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return TABLE_SCREEN_STRING;
                    }
                    return REWARD_STRING;
                }
                return "rewardVideo";
            }
            return FEED_STRING;
        }
        return SPLASH_STRING;
    }
}
