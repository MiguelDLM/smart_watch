package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.EventHandlerImpl;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public final class KeywordRecognizer implements AutoCloseable {
    static Set<KeywordRecognizer> keywordRecognizerObjects = Collections.synchronizedSet(new HashSet());
    private AudioConfig audioInputKeepAlive;
    public final EventHandlerImpl<SpeechRecognitionCanceledEventArgs> canceled;
    private boolean disposed;
    private AtomicInteger eventCounter;
    private PropertyCollection propertyHandle;
    private SafeHandle recoHandle;
    public final EventHandlerImpl<KeywordRecognitionEventArgs> recognized;

    public KeywordRecognizer(AudioConfig audioConfig) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventCounter = atomicInteger;
        this.recognized = new EventHandlerImpl<>(atomicInteger);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.recoHandle = null;
        this.audioInputKeepAlive = null;
        this.propertyHandle = null;
        this.disposed = false;
        this.recoHandle = new SafeHandle(0L, SafeHandleType.KeywordRecognizer);
        Contracts.throwIfFail(createKeywordRecognizerFromConfig(this.recoHandle, audioConfig != null ? audioConfig.getImpl() : null));
        this.audioInputKeepAlive = audioConfig;
        initialize();
    }

    private void canceledEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            SpeechRecognitionCanceledEventArgs speechRecognitionCanceledEventArgs = new SpeechRecognitionCanceledEventArgs(j, true);
            EventHandlerImpl<SpeechRecognitionCanceledEventArgs> eventHandlerImpl = this.canceled;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, speechRecognitionCanceledEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long canceledSetCallback(long j);

    private final native long createKeywordRecognizerFromConfig(SafeHandle safeHandle, SafeHandle safeHandle2);

    private void dispose(boolean z) {
        if (!this.disposed && z) {
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
            keywordRecognizerObjects.remove(this);
            AsyncThreadService.shutdown();
            this.disposed = true;
        }
    }

    private final native long getPropertyBagFromRecognizerHandle(SafeHandle safeHandle, IntRef intRef);

    private void initialize() {
        AsyncThreadService.initialize();
        this.recognized.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.KeywordRecognizer.3
            @Override // java.lang.Runnable
            public void run() {
                KeywordRecognizer.keywordRecognizerObjects.add(this);
                Contracts.throwIfFail(KeywordRecognizer.this.recognizedSetCallback(this.recoHandle.getValue()));
            }
        });
        this.canceled.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.KeywordRecognizer.4
            @Override // java.lang.Runnable
            public void run() {
                KeywordRecognizer.keywordRecognizerObjects.add(this);
                Contracts.throwIfFail(KeywordRecognizer.this.canceledSetCallback(this.recoHandle.getValue()));
            }
        });
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromRecognizerHandle(this.recoHandle, intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long recognizeOnce(SafeHandle safeHandle, SafeHandle safeHandle2, IntRef intRef);

    private void recognizedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            KeywordRecognitionEventArgs keywordRecognitionEventArgs = new KeywordRecognitionEventArgs(j, true);
            EventHandlerImpl<KeywordRecognitionEventArgs> eventHandlerImpl = this.recognized;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, keywordRecognitionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long recognizedSetCallback(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long stopRecognition(SafeHandle safeHandle);

    @Override // java.lang.AutoCloseable
    public void close() {
        dispose(true);
    }

    public SafeHandle getImpl() {
        return this.recoHandle;
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public Future<KeywordRecognitionResult> recognizeOnceAsync(final KeywordRecognitionModel keywordRecognitionModel) {
        return AsyncThreadService.submit(new Callable<KeywordRecognitionResult>() { // from class: com.microsoft.cognitiveservices.speech.KeywordRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public KeywordRecognitionResult call() {
                IntRef intRef = new IntRef(0L);
                KeywordRecognizer keywordRecognizer = KeywordRecognizer.this;
                Contracts.throwIfFail(keywordRecognizer.recognizeOnce(keywordRecognizer.recoHandle, keywordRecognitionModel.getImpl(), intRef));
                return new KeywordRecognitionResult(intRef.getValue());
            }
        });
    }

    public Future<Void> stopRecognitionAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.KeywordRecognizer.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                new Runnable() { // from class: com.microsoft.cognitiveservices.speech.KeywordRecognizer.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        this.stopRecognition(KeywordRecognizer.this.recoHandle);
                    }
                };
                return null;
            }
        });
    }
}
