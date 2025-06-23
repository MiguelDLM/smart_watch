package com.facebook.appevents.cloudbridge;

import OXOo.OOXIXo;
import java.util.Arrays;

/* loaded from: classes8.dex */
public enum ConversionsAPISection {
    USER_DATA("user_data"),
    APP_DATA("app_data"),
    CUSTOM_DATA("custom_data"),
    CUSTOM_EVENTS("custom_events");


    @OOXIXo
    private final String rawValue;

    ConversionsAPISection(String str) {
        this.rawValue = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static ConversionsAPISection[] valuesCustom() {
        ConversionsAPISection[] valuesCustom = values();
        return (ConversionsAPISection[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @OOXIXo
    public final String getRawValue() {
        return this.rawValue;
    }
}
