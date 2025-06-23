package com.facebook;

import java.util.Arrays;

/* loaded from: classes8.dex */
public enum LoggingBehavior {
    REQUESTS,
    INCLUDE_ACCESS_TOKENS,
    INCLUDE_RAW_RESPONSES,
    CACHE,
    APP_EVENTS,
    DEVELOPER_ERRORS,
    GRAPH_API_DEBUG_WARNING,
    GRAPH_API_DEBUG_INFO;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static LoggingBehavior[] valuesCustom() {
        LoggingBehavior[] valuesCustom = values();
        return (LoggingBehavior[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
