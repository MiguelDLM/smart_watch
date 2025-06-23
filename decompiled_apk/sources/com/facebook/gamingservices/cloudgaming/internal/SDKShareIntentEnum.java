package com.facebook.gamingservices.cloudgaming.internal;

import androidx.annotation.Nullable;

/* loaded from: classes8.dex */
public enum SDKShareIntentEnum {
    INVITE("INVITE"),
    REQUEST("REQUEST"),
    CHALLENGE("CHALLENGE"),
    SHARE("SHARE");

    private final String mStringValue;

    SDKShareIntentEnum(String stringValue) {
        this.mStringValue = stringValue;
    }

    @Nullable
    public static SDKShareIntentEnum fromString(String intentType) {
        for (SDKShareIntentEnum sDKShareIntentEnum : values()) {
            if (sDKShareIntentEnum.toString().equals(intentType)) {
                return sDKShareIntentEnum;
            }
        }
        return null;
    }

    @Nullable
    public static String validate(String intentType) {
        for (SDKShareIntentEnum sDKShareIntentEnum : values()) {
            if (sDKShareIntentEnum.toString().equals(intentType)) {
                return intentType;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mStringValue;
    }
}
