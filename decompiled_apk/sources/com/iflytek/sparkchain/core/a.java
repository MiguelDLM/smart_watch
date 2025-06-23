package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public abstract class a implements AiData {
    protected AiDataHolder<?, ?> holder;

    public void ref(AiDataHolder<?, ?> aiDataHolder) {
        this.holder = aiDataHolder;
    }

    @Override // com.iflytek.sparkchain.core.AiData
    public void syncCtrl(int i) {
        this.holder.syncCtrl(i);
    }

    @Override // com.iflytek.sparkchain.core.AiData
    public void syncDesc(int i) {
        this.holder.syncDesc(i);
    }
}
