package com.iflytek.sparkchain.plugins;

import com.iflytek.sparkchain.core.Const;

/* loaded from: classes10.dex */
public enum PluginType implements Const {
    PRESET(0),
    CUSTOM(1);

    private final int value;

    PluginType(int i) {
        this.value = i;
    }

    @Override // com.iflytek.sparkchain.core.Const
    public int getValue() {
        return this.value;
    }
}
