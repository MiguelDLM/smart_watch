package com.microsoft.cognitiveservices.speech.speaker;

import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public final class SpeakerRecognizer implements AutoCloseable {
    private AudioConfig audioInputKeepAlive;
    private SafeHandle recoHandle;
    private PropertyCollection propertyHandle = null;
    private boolean disposed = false;

    public SpeakerRecognizer(SpeechConfig speechConfig, AudioConfig audioConfig) {
        this.recoHandle = null;
        this.audioInputKeepAlive = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createFromConfig(intRef, speechConfig.getImpl(), audioConfig != null ? audioConfig.getImpl() : null));
        this.recoHandle = new SafeHandle(intRef.getValue(), SafeHandleType.SpeakerRecognizer);
        this.audioInputKeepAlive = audioConfig;
        initialize();
    }

    private final native long createFromConfig(IntRef intRef, SafeHandle safeHandle, SafeHandle safeHandle2);

    private final native long getPropertyBagFromRecognizerHandle(SafeHandle safeHandle, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long identifyOnce(SafeHandle safeHandle, SafeHandle safeHandle2, IntRef intRef);

    private void initialize() {
        AsyncThreadService.initialize();
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromRecognizerHandle(this.recoHandle, intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long verifyOnce(SafeHandle safeHandle, SafeHandle safeHandle2, IntRef intRef);

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
        SafeHandle safeHandle = this.recoHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.recoHandle = null;
        }
        this.audioInputKeepAlive = null;
        AsyncThreadService.shutdown();
        this.disposed = true;
    }

    public SafeHandle getImpl() {
        return this.recoHandle;
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public Future<SpeakerRecognitionResult> recognizeOnceAsync(final SpeakerIdentificationModel speakerIdentificationModel) {
        return AsyncThreadService.submit(new Callable<SpeakerRecognitionResult>() { // from class: com.microsoft.cognitiveservices.speech.speaker.SpeakerRecognizer.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public SpeakerRecognitionResult call() {
                IntRef intRef = new IntRef(0L);
                SpeakerRecognizer speakerRecognizer = SpeakerRecognizer.this;
                Contracts.throwIfFail(speakerRecognizer.identifyOnce(speakerRecognizer.recoHandle, speakerIdentificationModel.getImpl(), intRef));
                return new SpeakerRecognitionResult(intRef.getValue());
            }
        });
    }

    public Future<SpeakerRecognitionResult> recognizeOnceAsync(final SpeakerVerificationModel speakerVerificationModel) {
        return AsyncThreadService.submit(new Callable<SpeakerRecognitionResult>() { // from class: com.microsoft.cognitiveservices.speech.speaker.SpeakerRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public SpeakerRecognitionResult call() {
                IntRef intRef = new IntRef(0L);
                SpeakerRecognizer speakerRecognizer = SpeakerRecognizer.this;
                Contracts.throwIfFail(speakerRecognizer.verifyOnce(speakerRecognizer.recoHandle, speakerVerificationModel.getImpl(), intRef));
                return new SpeakerRecognitionResult(intRef.getValue());
            }
        });
    }
}
