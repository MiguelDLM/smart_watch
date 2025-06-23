package com.facebook.appevents;

import java.util.Arrays;

/* loaded from: classes8.dex */
public enum FlushReason {
    EXPLICIT,
    TIMER,
    SESSION_CHANGE,
    PERSISTED_EVENTS,
    EVENT_THRESHOLD,
    EAGER_FLUSHING_EVENT;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static FlushReason[] valuesCustom() {
        FlushReason[] valuesCustom = values();
        return (FlushReason[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
