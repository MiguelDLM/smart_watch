package com.microsoft.cognitiveservices.speech.speaker;

import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public final class VoiceProfileClient implements AutoCloseable {
    private SafeHandle voiceProfileClientHandle;
    private PropertyCollection propertyHandle = null;
    private boolean disposed = false;

    public VoiceProfileClient(SpeechConfig speechConfig) {
        this.voiceProfileClientHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createFromConfig(intRef, speechConfig.getImpl()));
        this.voiceProfileClientHandle = new SafeHandle(intRef.getValue(), SafeHandleType.VoiceProfileClient);
        initialize();
    }

    private final native long createFromConfig(IntRef intRef, SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long createVoiceProfile(SafeHandle safeHandle, int i, String str, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long deleteVoiceProfile(SafeHandle safeHandle, SafeHandle safeHandle2, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long enrollVoiceProfile(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long getActivationPhrases(SafeHandle safeHandle, int i, String str, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long getProfilesJson(SafeHandle safeHandle, int i, StringRef stringRef, IntRef intRef);

    private final native long getPropertyBagFromHandle(SafeHandle safeHandle, IntRef intRef);

    private void initialize() {
        AsyncThreadService.initialize();
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromHandle(this.voiceProfileClientHandle, intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long resetVoiceProfile(SafeHandle safeHandle, SafeHandle safeHandle2, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long retrieveEnrollmentResult(SafeHandle safeHandle, String str, int i, IntRef intRef);

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.disposed) {
            return;
        }
        PropertyCollection propertyCollection = this.propertyHandle;
        if (propertyCollection != null) {
            propertyCollection.close();
            this.propertyHandle = null;
        }
        SafeHandle safeHandle = this.voiceProfileClientHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.voiceProfileClientHandle = null;
        }
        AsyncThreadService.shutdown();
        this.disposed = true;
    }

    public Future<VoiceProfile> createProfileAsync(final VoiceProfileType voiceProfileType, final String str) {
        return AsyncThreadService.submit(new Callable<VoiceProfile>() { // from class: com.microsoft.cognitiveservices.speech.speaker.VoiceProfileClient.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public VoiceProfile call() {
                IntRef intRef = new IntRef(0L);
                VoiceProfileClient voiceProfileClient = VoiceProfileClient.this;
                Contracts.throwIfFail(voiceProfileClient.createVoiceProfile(voiceProfileClient.voiceProfileClientHandle, voiceProfileType.getValue(), str, intRef));
                return new VoiceProfile(intRef.getValue());
            }
        });
    }

    public Future<VoiceProfileResult> deleteProfileAsync(final VoiceProfile voiceProfile) {
        return AsyncThreadService.submit(new Callable<VoiceProfileResult>() { // from class: com.microsoft.cognitiveservices.speech.speaker.VoiceProfileClient.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public VoiceProfileResult call() {
                IntRef intRef = new IntRef(0L);
                VoiceProfileClient voiceProfileClient = VoiceProfileClient.this;
                Contracts.throwIfFail(voiceProfileClient.deleteVoiceProfile(voiceProfileClient.voiceProfileClientHandle, voiceProfile.getImpl(), intRef));
                return new VoiceProfileResult(intRef.getValue());
            }
        });
    }

    public Future<VoiceProfileEnrollmentResult> enrollProfileAsync(final VoiceProfile voiceProfile, final AudioConfig audioConfig) {
        return AsyncThreadService.submit(new Callable<VoiceProfileEnrollmentResult>() { // from class: com.microsoft.cognitiveservices.speech.speaker.VoiceProfileClient.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public VoiceProfileEnrollmentResult call() {
                IntRef intRef = new IntRef(0L);
                VoiceProfileClient voiceProfileClient = VoiceProfileClient.this;
                Contracts.throwIfFail(voiceProfileClient.enrollVoiceProfile(voiceProfileClient.voiceProfileClientHandle, voiceProfile.getImpl(), audioConfig.getImpl(), intRef));
                return new VoiceProfileEnrollmentResult(intRef.getValue());
            }
        });
    }

    public Future<VoiceProfilePhraseResult> getActivationPhrasesAsync(final VoiceProfileType voiceProfileType, final String str) {
        return AsyncThreadService.submit(new Callable<VoiceProfilePhraseResult>() { // from class: com.microsoft.cognitiveservices.speech.speaker.VoiceProfileClient.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public VoiceProfilePhraseResult call() {
                IntRef intRef = new IntRef(0L);
                VoiceProfileClient voiceProfileClient = VoiceProfileClient.this;
                Contracts.throwIfFail(voiceProfileClient.getActivationPhrases(voiceProfileClient.voiceProfileClientHandle, voiceProfileType.getValue(), str, intRef));
                return new VoiceProfilePhraseResult(intRef.getValue());
            }
        });
    }

    public Future<List<VoiceProfile>> getAllProfilesAsync(final VoiceProfileType voiceProfileType) {
        return AsyncThreadService.submit(new Callable<List<VoiceProfile>>() { // from class: com.microsoft.cognitiveservices.speech.speaker.VoiceProfileClient.7
            @Override // java.util.concurrent.Callable
            public List<VoiceProfile> call() {
                ArrayList arrayList = new ArrayList();
                StringRef stringRef = new StringRef("");
                IntRef intRef = new IntRef(0L);
                VoiceProfileClient voiceProfileClient = VoiceProfileClient.this;
                Contracts.throwIfFail(voiceProfileClient.getProfilesJson(voiceProfileClient.voiceProfileClientHandle, voiceProfileType.getValue(), stringRef, intRef));
                if (!stringRef.getValue().isEmpty()) {
                    Iterator it = Arrays.asList(stringRef.getValue().split("\\|")).iterator();
                    while (it.hasNext()) {
                        arrayList.add(new VoiceProfile((String) it.next(), voiceProfileType));
                    }
                }
                return arrayList;
            }
        });
    }

    public SafeHandle getImpl() {
        return this.voiceProfileClientHandle;
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public Future<VoiceProfileResult> resetProfileAsync(final VoiceProfile voiceProfile) {
        return AsyncThreadService.submit(new Callable<VoiceProfileResult>() { // from class: com.microsoft.cognitiveservices.speech.speaker.VoiceProfileClient.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public VoiceProfileResult call() {
                IntRef intRef = new IntRef(0L);
                VoiceProfileClient voiceProfileClient = VoiceProfileClient.this;
                Contracts.throwIfFail(voiceProfileClient.resetVoiceProfile(voiceProfileClient.voiceProfileClientHandle, voiceProfile.getImpl(), intRef));
                return new VoiceProfileResult(intRef.getValue());
            }
        });
    }

    public Future<VoiceProfileEnrollmentResult> retrieveEnrollmentResultAsync(final VoiceProfile voiceProfile) {
        return AsyncThreadService.submit(new Callable<VoiceProfileEnrollmentResult>() { // from class: com.microsoft.cognitiveservices.speech.speaker.VoiceProfileClient.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public VoiceProfileEnrollmentResult call() {
                IntRef intRef = new IntRef(0L);
                VoiceProfileClient voiceProfileClient = VoiceProfileClient.this;
                Contracts.throwIfFail(voiceProfileClient.retrieveEnrollmentResult(voiceProfileClient.voiceProfileClientHandle, voiceProfile.getId(), voiceProfile.getType().getValue(), intRef));
                return new VoiceProfileEnrollmentResult(intRef.getValue());
            }
        });
    }
}
