package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public enum AgentType implements Const {
    UNKNOWN_TYPE(-1),
    PLUGIN_AGENT(0),
    ZERO_SHOT_REACT(1);

    private final int value;

    AgentType(int i) {
        this.value = i;
    }

    public static AgentType valueOf(int i) {
        if (i == 0) {
            return PLUGIN_AGENT;
        }
        if (i == 1) {
            return ZERO_SHOT_REACT;
        }
        return null;
    }

    @Override // com.iflytek.sparkchain.core.Const
    public int getValue() {
        return this.value;
    }
}
