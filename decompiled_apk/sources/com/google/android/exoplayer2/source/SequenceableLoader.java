package com.google.android.exoplayer2.source;

/* loaded from: classes9.dex */
public interface SequenceableLoader {

    /* loaded from: classes9.dex */
    public interface Callback<T extends SequenceableLoader> {
        void onContinueLoadingRequested(T t);
    }

    boolean continueLoading(long j);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    boolean isLoading();

    void reevaluateBuffer(long j);
}
