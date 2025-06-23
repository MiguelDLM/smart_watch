package com.iflytek.sparkchain.core.chain.qa;

import com.iflytek.sparkchain.core.chain.base.ChainCallbacks;

/* loaded from: classes10.dex */
public interface KnowBotCallbacks extends ChainCallbacks<KnowBotResult, KnowBotEvent, KnowBotError> {
    @Override // com.iflytek.sparkchain.core.chain.base.ChainCallbacks
    /* bridge */ /* synthetic */ void onError(KnowBotError knowBotError, Object obj);

    /* renamed from: onError, reason: avoid collision after fix types in other method */
    void onError2(KnowBotError knowBotError, Object obj);

    @Override // com.iflytek.sparkchain.core.chain.base.ChainCallbacks
    /* bridge */ /* synthetic */ void onEvent(KnowBotEvent knowBotEvent, Object obj);

    /* renamed from: onEvent, reason: avoid collision after fix types in other method */
    void onEvent2(KnowBotEvent knowBotEvent, Object obj);

    @Override // com.iflytek.sparkchain.core.chain.base.ChainCallbacks
    /* bridge */ /* synthetic */ void onOutput(KnowBotResult knowBotResult, Object obj);

    /* renamed from: onOutput, reason: avoid collision after fix types in other method */
    void onOutput2(KnowBotResult knowBotResult, Object obj);
}
