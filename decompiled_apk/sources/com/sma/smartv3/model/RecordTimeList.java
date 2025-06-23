package com.sma.smartv3.model;

/* loaded from: classes12.dex */
public final class RecordTimeList {
    private final int mState;
    private final long mTime;

    public RecordTimeList(long j, int i) {
        this.mTime = j;
        this.mState = i;
    }

    public final int getMState() {
        return this.mState;
    }

    public final long getMTime() {
        return this.mTime;
    }
}
