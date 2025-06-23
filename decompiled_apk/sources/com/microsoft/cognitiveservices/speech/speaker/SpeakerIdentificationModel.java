package com.microsoft.cognitiveservices.speech.speaker;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public class SpeakerIdentificationModel implements AutoCloseable {
    private boolean disposed = false;
    private SafeHandle speakerIdentificationModelHandle;

    static {
        Class<?> cls = SpeechConfig.speechConfigClass;
    }

    public SpeakerIdentificationModel(IntRef intRef) {
        this.speakerIdentificationModelHandle = null;
        Contracts.throwIfNull(intRef, "modelHandle");
        this.speakerIdentificationModelHandle = new SafeHandle(intRef.getValue(), SafeHandleType.SpeakerIdentificationModel);
    }

    private static final native long createSpeakerIdentificationModel(IntRef intRef);

    public static SpeakerIdentificationModel fromProfiles(List<VoiceProfile> list) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfNull(list, "profiles cannot be null");
        Contracts.throwIfFail(createSpeakerIdentificationModel(intRef));
        Iterator<VoiceProfile> it = list.iterator();
        while (it.hasNext()) {
            Contracts.throwIfFail(speakerIdentificationModelAddProfile(intRef, it.next().getImpl()));
        }
        return new SpeakerIdentificationModel(intRef);
    }

    private static final native long speakerIdentificationModelAddProfile(IntRef intRef, SafeHandle safeHandle);

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.disposed) {
            return;
        }
        SafeHandle safeHandle = this.speakerIdentificationModelHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.speakerIdentificationModelHandle = null;
        }
        this.disposed = true;
    }

    public SafeHandle getImpl() {
        return this.speakerIdentificationModelHandle;
    }
}
