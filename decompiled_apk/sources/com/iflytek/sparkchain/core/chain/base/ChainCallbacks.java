package com.iflytek.sparkchain.core.chain.base;

import com.iflytek.sparkchain.core.chain.base.ChainError;
import com.iflytek.sparkchain.core.chain.base.ChainEvent;
import com.iflytek.sparkchain.core.chain.base.ChainResult;

/* loaded from: classes10.dex */
public interface ChainCallbacks<R extends ChainResult, E extends ChainEvent, T extends ChainError> {
    void onError(T t, Object obj);

    void onEvent(E e, Object obj);

    void onOutput(R r, Object obj);
}
