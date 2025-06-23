package com.alimm.tanx.core.view.player.cache.videocache.log;

import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class LoggerFactory {
    public static Logger getLogger(String str) {
        return new Logger(str);
    }

    public static void log(String... strArr) {
        LogUtils.d("VideoCache", strArr);
    }
}
