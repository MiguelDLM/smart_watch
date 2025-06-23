package com.alimm.tanx.core.view.player.cache.videocache.log;

import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class Logger {
    private final String tag;

    public Logger(String str) {
        this.tag = str;
    }

    public void debug(String... strArr) {
        LogUtils.d(this.tag, strArr);
    }

    public void error(String str) {
        LogUtils.e(this.tag, str);
    }

    public void info(String... strArr) {
        LogUtils.i(this.tag, strArr);
    }

    public void warn(String... strArr) {
        LogUtils.w(this.tag, strArr);
    }

    public void error(String str, Throwable th) {
        LogUtils.e(this.tag, str, th);
    }

    public void warn(String str, Exception exc) {
        LogUtils.w(this.tag, str, exc.getMessage());
    }
}
