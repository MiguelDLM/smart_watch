package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public final class ConnectionMessageEventArgs {
    private ConnectionMessage message;

    public ConnectionMessageEventArgs(long j) {
        Contracts.throwIfNull(j, "eventArgs is null");
        SafeHandle safeHandle = new SafeHandle(j, SafeHandleType.ConnectionMessageEvent);
        Contracts.throwIfNull(safeHandle, "eventHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getConnectionMessage(safeHandle, intRef));
        this.message = new ConnectionMessage(intRef.getValue());
        safeHandle.close();
    }

    private final native long getConnectionMessage(SafeHandle safeHandle, IntRef intRef);

    public ConnectionMessage getMessage() {
        return this.message;
    }

    public String toString() {
        return "Message: " + getMessage().toString();
    }
}
