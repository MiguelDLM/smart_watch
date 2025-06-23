package com.iflytek.sparkchain.core.chain.qa;

import com.iflytek.sparkchain.core.chain.base.ChainEvent;

/* loaded from: classes10.dex */
public interface KnowBotEvent extends ChainEvent {
    int getEventID();

    String getEventMsg();

    Object getUserContext();
}
