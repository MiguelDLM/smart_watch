package com.realsil.sdk.bbpro.core;

import com.realsil.sdk.bbpro.core.transportlayer.Command;

/* loaded from: classes11.dex */
public abstract class AppReq {
    public abstract Command encode();

    public abstract Command encode(int i);

    public abstract short getCommandId();

    public short getEventId() {
        return (short) 0;
    }
}
