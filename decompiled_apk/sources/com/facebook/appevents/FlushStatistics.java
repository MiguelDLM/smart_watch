package com.facebook.appevents;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class FlushStatistics {
    private int numEvents;

    @OXOo.OOXIXo
    private FlushResult result = FlushResult.SUCCESS;

    public final int getNumEvents() {
        return this.numEvents;
    }

    @OXOo.OOXIXo
    public final FlushResult getResult() {
        return this.result;
    }

    public final void setNumEvents(int i) {
        this.numEvents = i;
    }

    public final void setResult(@OXOo.OOXIXo FlushResult flushResult) {
        IIX0o.x0xO0oo(flushResult, "<set-?>");
        this.result = flushResult;
    }
}
