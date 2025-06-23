package com.baidu.platform.comapi.logstatistics;

import java.util.Map;

/* loaded from: classes8.dex */
public class LogUsrActStatistics extends com.baidu.platform.comapi.logstatistics.a {

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final LogUsrActStatistics f9593a = new LogUsrActStatistics();
    }

    public static LogUsrActStatistics getInstance() {
        return a.f9593a;
    }

    public void addLogWithLowLevel(String str, String str2, String str3, Map<String, Object> map) {
        d.a().a(1200, 1, appendLogTag(str, str2, str3), map);
    }

    private LogUsrActStatistics() {
    }
}
