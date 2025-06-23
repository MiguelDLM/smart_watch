package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.SessionEventArgs;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class ConversationParticipantsChangedEventArgs extends SessionEventArgs {
    private List<Participant> participants;
    private ParticipantChangedReason reason;

    public ConversationParticipantsChangedEventArgs(long j) {
        super(j);
        storeEventData(j, false);
    }

    private final native long getParticipantAt(SafeHandle safeHandle, int i, IntRef intRef);

    private final native long getReason(SafeHandle safeHandle, IntRef intRef);

    private void storeEventData(long j, boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getReason(this.eventHandle, intRef));
        this.reason = ParticipantChangedReason.values()[(int) intRef.getValue()];
        this.participants = new ArrayList();
        IntRef intRef2 = new IntRef(0L);
        SafeHandle safeHandle = this.eventHandle;
        int i = 0;
        while (true) {
            getParticipantAt(safeHandle, i, intRef2);
            if (intRef2.getValue() <= 0) {
                break;
            }
            this.participants.add(new Participant(intRef2.getValue()));
            intRef2 = new IntRef(0L);
            i++;
            safeHandle = this.eventHandle;
        }
        if (z) {
            super.close();
        }
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }

    public ParticipantChangedReason getReason() {
        return this.reason;
    }

    @Override // com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        return "SessionId:" + getSessionId() + " Reason:" + this.reason + " Participants:" + this.participants.size();
    }

    public ConversationParticipantsChangedEventArgs(long j, boolean z) {
        super(j);
        storeEventData(j, z);
    }
}
