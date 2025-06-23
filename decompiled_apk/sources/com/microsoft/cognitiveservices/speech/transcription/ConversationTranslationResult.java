package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.translation.TranslationRecognitionResult;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public class ConversationTranslationResult extends TranslationRecognitionResult {
    private String originalLang;
    private String participantId;

    public ConversationTranslationResult(long j) {
        super(j);
        Contracts.throwIfNull(super.getImpl(), "resultHandle");
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getOriginalLang(super.getImpl(), stringRef));
        this.originalLang = stringRef.getValue();
        Contracts.throwIfFail(getParticipantId(super.getImpl(), stringRef));
        this.participantId = stringRef.getValue();
    }

    private final native long getOriginalLang(SafeHandle safeHandle, StringRef stringRef);

    private final native long getParticipantId(SafeHandle safeHandle, StringRef stringRef);

    public String getOriginalLang() {
        return this.originalLang;
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
