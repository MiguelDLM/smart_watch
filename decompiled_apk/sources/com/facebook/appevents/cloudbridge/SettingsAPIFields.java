package com.facebook.appevents.cloudbridge;

import OXOo.OOXIXo;
import java.util.Arrays;

/* loaded from: classes8.dex */
public enum SettingsAPIFields {
    URL("endpoint"),
    ENABLED("is_enabled"),
    DATASETID("dataset_id"),
    ACCESSKEY("access_key");


    @OOXIXo
    private final String rawValue;

    SettingsAPIFields(String str) {
        this.rawValue = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static SettingsAPIFields[] valuesCustom() {
        SettingsAPIFields[] valuesCustom = values();
        return (SettingsAPIFields[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @OOXIXo
    public final String getRawValue() {
        return this.rawValue;
    }
}
