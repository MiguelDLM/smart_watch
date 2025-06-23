package com.iflytek.sparkchain.core.chain.base;

import com.iflytek.sparkchain.core.chain.base.ChainCallbacks;

/* loaded from: classes10.dex */
public interface Chain<T extends ChainCallbacks> {
    void registerCallback(T t);
}
