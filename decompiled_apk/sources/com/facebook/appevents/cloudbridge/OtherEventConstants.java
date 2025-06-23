package com.facebook.appevents.cloudbridge;

import OXOo.OOXIXo;
import androidx.core.app.NotificationCompat;
import java.util.Arrays;

/* loaded from: classes8.dex */
public enum OtherEventConstants {
    EVENT(NotificationCompat.CATEGORY_EVENT),
    ACTION_SOURCE("action_source"),
    APP("app"),
    MOBILE_APP_INSTALL("MobileAppInstall"),
    INSTALL_EVENT_TIME("install_timestamp");


    @OOXIXo
    private final String rawValue;

    OtherEventConstants(String str) {
        this.rawValue = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static OtherEventConstants[] valuesCustom() {
        OtherEventConstants[] valuesCustom = values();
        return (OtherEventConstants[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @OOXIXo
    public final String getRawValue() {
        return this.rawValue;
    }
}
