package com.iflytek.sparkchain.core.chain.qa;

import com.iflytek.sparkchain.core.chain.base.ChainResult;

/* loaded from: classes10.dex */
public interface KnowBotResult extends ChainResult {
    String getMsg();

    String getResult();

    int getStatus();

    Object getUserContext();
}
