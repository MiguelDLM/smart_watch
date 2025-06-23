package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public class AIChatHandle {
    String abilityId;
    int handleId;
    Object usrContext;
    private int usrContextIndex = 0;

    public AIChatHandle(Object obj, String str, int i) {
        this.usrContext = obj;
        this.abilityId = str;
        this.handleId = i;
    }

    public String getAbilityId() {
        return this.abilityId;
    }

    public int getHandleId() {
        return this.handleId;
    }

    public Object getUsrContext() {
        return this.usrContext;
    }

    public int getUsrContextIndex() {
        return this.usrContextIndex;
    }

    public AIChatHandle setUsrContextIndex(int i) {
        this.usrContextIndex = i;
        return this;
    }
}
