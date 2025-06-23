package com.microsoft.cognitiveservices.speech;

/* loaded from: classes11.dex */
public final class ConnectionEventArgs extends SessionEventArgs {
    public ConnectionEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    private void storeEventData(boolean z) {
        if (z) {
            super.close();
        }
    }

    public ConnectionEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }
}
