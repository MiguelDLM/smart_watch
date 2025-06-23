package com.iflytek.sparkchain.core.chain.qa;

import com.iflytek.sparkchain.core.chain.base.ChainError;

/* loaded from: classes10.dex */
public interface KnowBotError extends ChainError {
    int getErrCode();

    String getErrMsg();

    Object getUserContext();
}
