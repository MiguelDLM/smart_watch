package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.SessionEventArgs;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes11.dex */
public class ConversationExpirationEventArgs extends SessionEventArgs {
    private long minutesLeft;

    public ConversationExpirationEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    private final native long getExpiration(SafeHandle safeHandle, IntRef intRef);

    private void storeEventData(boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        IntRef intRef = new IntRef(0L);
        this.minutesLeft = getExpiration(this.eventHandle, intRef);
        Contracts.throwIfFail(intRef.getValue());
        if (z) {
            super.close();
        }
    }

    public long getExpirationTime() {
        return this.minutesLeft;
    }

    @Override // com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        return "SessionId: " + getSessionId() + " Expiration: " + this.minutesLeft + FileUtils.FILE_EXTENSION_SEPARATOR;
    }

    public ConversationExpirationEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }
}
