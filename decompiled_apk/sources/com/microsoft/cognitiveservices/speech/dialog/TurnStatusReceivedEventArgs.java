package com.microsoft.cognitiveservices.speech.dialog;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public class TurnStatusReceivedEventArgs {
    private SafeHandle TurnStatusReceivedEventHandle;
    private String conversationId;
    private String interactionId;
    private int statusCode;

    public TurnStatusReceivedEventArgs(long j) {
        this.TurnStatusReceivedEventHandle = null;
        this.interactionId = "";
        this.conversationId = "";
        this.statusCode = 404;
        Contracts.throwIfNull(j, "eventArgs");
        this.TurnStatusReceivedEventHandle = new SafeHandle(j, SafeHandleType.TurnStatusReceivedEvent);
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getInteractionId(this.TurnStatusReceivedEventHandle, stringRef));
        this.interactionId = stringRef.getValue();
        StringRef stringRef2 = new StringRef("");
        Contracts.throwIfFail(getConversationId(this.TurnStatusReceivedEventHandle, stringRef2));
        this.conversationId = stringRef2.getValue();
        IntRef intRef = new IntRef(0L);
        getStatusCode(this.TurnStatusReceivedEventHandle, intRef);
        this.statusCode = (int) intRef.getValue();
    }

    private final native long getConversationId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getInteractionId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getStatusCode(SafeHandle safeHandle, IntRef intRef);

    public String getConversationId() {
        return this.conversationId;
    }

    public String getInteractionId() {
        return this.interactionId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
