package com.baidu.ar.bean;

import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;

/* loaded from: classes7.dex */
public enum FunctionType {
    NONE("none"),
    VIDEO("video"),
    IMU(ARPScriptEnvironment.KEY_DATA_PIP_IMU);

    private final String mValue;

    FunctionType(String str) {
        this.mValue = str;
    }

    public static FunctionType getValueOf(String str) {
        if (str == null) {
            return NONE;
        }
        for (FunctionType functionType : values()) {
            if (functionType.getValue().equalsIgnoreCase(str)) {
                return functionType;
            }
        }
        return NONE;
    }

    public String getValue() {
        return this.mValue;
    }
}
