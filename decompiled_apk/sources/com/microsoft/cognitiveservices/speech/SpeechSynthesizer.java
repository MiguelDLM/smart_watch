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
public class SpeechSynthesizer implements AutoCloseable {
    public final EventHandlerImpl<SpeechSynthesisBookmarkEventArgs> BookmarkReached;
    public final EventHandlerImpl<SpeechSynthesisEventArgs> SynthesisCanceled;
    public final EventHandlerImpl<SpeechSynthesisEventArgs> SynthesisCompleted;
    public final EventHandlerImpl<SpeechSynthesisEventArgs> SynthesisStarted;
    public final EventHandlerImpl<SpeechSynthesisEventArgs> Synthesizing;
    public final EventHandlerImpl<SpeechSynthesisVisemeEventArgs> VisemeReceived;
    public final EventHandlerImpl<SpeechSynthesisWordBoundaryEventArgs> WordBoundary;
    private int activeAsyncSynthesisCounter;
    private AudioConfig audioOutputKeepAlive;
    private boolean disposed;
    private AtomicInteger eventCounter;
    private PropertyCollection propertyHandle;
    private SafeHandle synthHandle;
    private final Object synthesizerLock;
    private static Set<SpeechSynthesizer> s_speechSynthesizerObjects = Collections.synchronizedSet(new HashSet());
    private static Integer disposeWaitingTime = 100;

    public SpeechSynthesizer(EmbeddedSpeechConfig embeddedSpeechConfig) {
        this(embeddedSpeechConfig.config);
    }

    private void bookmarkReachedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "synthesizer");
            if (this.disposed) {
                return;
            }
            SpeechSynthesisBookmarkEventArgs speechSynthesisBookmarkEventArgs = new SpeechSynthesisBookmarkEventArgs(j);
            EventHandlerImpl<SpeechSynthesisBookmarkEventArgs> eventHandlerImpl = this.BookmarkReached;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, speechSynthesisBookmarkEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long bookmarkReachedSetCallback(SafeHandle safeHandle);

    private final native long createSpeechSynthesizerFromAutoDetectSourceLangConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3, SafeHandle safeHandle4);

    private final native long createSpeechSynthesizerFromConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3);

    private void dispose(boolean z) {
        if (!this.disposed && z) {
            PropertyCollection propertyCollection = this.propertyHandle;
            if (propertyCollection != null) {
                propertyCollection.close();
                this.propertyHandle = null;
            }
            SafeHandle safeHandle = this.synthHandle;
            if (safeHandle != null) {
                safeHandle.close();
                this.synthHandle = null;
            }
            this.audioOutputKeepAlive = null;
            s_speechSynthesizerObjects.remove(this);
            AsyncThreadService.shutdown();
            this.disposed = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAsyncSynthesisAction(Runnable runnable) {
        synchronized (this.synthesizerLock) {
            this.activeAsyncSynthesisCounter++;
        }
        if (this.disposed) {
            throw new IllegalStateException(getClass().getName());
        }
        try {
            runnable.run();
            synchronized (this.synthesizerLock) {
                this.activeAsyncSynthesisCounter--;
                this.synthesizerLock.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.synthesizerLock) {
                this.activeAsyncSynthesisCounter--;
                this.synthesizerLock.notifyAll();
                throw th;
            }
        }
    }

    private final native long getPropertyBagFromSynthesizerHandle(SafeHandle safeHandle, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long getVoices(SafeHandle safeHandle, String str, IntRef intRef);

    private void initialize() {
        AsyncThreadService.initialize();
        this.SynthesisStarted.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.7
            @Override // java.lang.Runnable
            public void run() {
                SpeechSynthesizer.s_speechSynthesizerObjects.add(this);
                Contracts.throwIfFail(SpeechSynthesizer.this.synthesisStartedSetCallback(this.synthHandle));
            }
        });
        this.Synthesizing.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.8
            @Override // java.lang.Runnable
            public void run() {
                SpeechSynthesizer.s_speechSynthesizerObjects.add(this);
                Contracts.throwIfFail(SpeechSynthesizer.this.synthesizingSetCallback(this.synthHandle));
            }
        });
        this.SynthesisCompleted.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.9
            @Override // java.lang.Runnable
            public void run() {
                SpeechSynthesizer.s_speechSynthesizerObjects.add(this);
                Contracts.throwIfFail(SpeechSynthesizer.this.synthesisCompletedSetCallback(this.synthHandle));
            }
        });
        this.SynthesisCanceled.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.10
            @Override // java.lang.Runnable
            public void run() {
                SpeechSynthesizer.s_speechSynthesizerObjects.add(this);
                Contracts.throwIfFail(SpeechSynthesizer.this.synthesisCanceledSetCallback(this.synthHandle));
            }
        });
        this.WordBoundary.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.11
            @Override // java.lang.Runnable
            public void run() {
                SpeechSynthesizer.s_speechSynthesizerObjects.add(this);
                Contracts.throwIfFail(SpeechSynthesizer.this.wordBoundarySetCallback(this.synthHandle));
            }
        });
        this.VisemeReceived.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.12
            @Override // java.lang.Runnable
            public void run() {
                SpeechSynthesizer.s_speechSynthesizerObjects.add(this);
                Contracts.throwIfFail(SpeechSynthesizer.this.visemeReceivedSetCallback(this.synthHandle));
            }
        });
        this.BookmarkReached.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.13
            @Override // java.lang.Runnable
            public void run() {
                SpeechSynthesizer.s_speechSynthesizerObjects.add(this);
                Contracts.throwIfFail(SpeechSynthesizer.this.bookmarkReachedSetCallback(this.synthHandle));
            }
        });
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromSynthesizerHandle(this.synthHandle, intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long speakSsml(SafeHandle safeHandle, String str, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long speakText(SafeHandle safeHandle, String str, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long startSpeakingSsml(SafeHandle safeHandle, String str, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long startSpeakingText(SafeHandle safeHandle, String str, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long stopSpeaking(SafeHandle safeHandle);

    private void synthesisCanceledEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "synthesizer");
            if (this.disposed) {
                return;
            }
            SpeechSynthesisEventArgs speechSynthesisEventArgs = new SpeechSynthesisEventArgs(j);
            EventHandlerImpl<SpeechSynthesisEventArgs> eventHandlerImpl = this.SynthesisCanceled;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, speechSynthesisEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long synthesisCanceledSetCallback(SafeHandle safeHandle);

    private void synthesisCompletedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "synthesizer");
            if (this.disposed) {
                return;
            }
            SpeechSynthesisEventArgs speechSynthesisEventArgs = new SpeechSynthesisEventArgs(j);
            EventHandlerImpl<SpeechSynthesisEventArgs> eventHandlerImpl = this.SynthesisCompleted;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, speechSynthesisEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long synthesisCompletedSetCallback(SafeHandle safeHandle);

    private void synthesisStartedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "synthesizer");
            if (this.disposed) {
                return;
            }
            SpeechSynthesisEventArgs speechSynthesisEventArgs = new SpeechSynthesisEventArgs(j);
            EventHandlerImpl<SpeechSynthesisEventArgs> eventHandlerImpl = this.SynthesisStarted;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, speechSynthesisEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long synthesisStartedSetCallback(SafeHandle safeHandle);

    private void synthesizingEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "synthesizer");
            if (this.disposed) {
                return;
            }
            SpeechSynthesisEventArgs speechSynthesisEventArgs = new SpeechSynthesisEventArgs(j);
            EventHandlerImpl<SpeechSynthesisEventArgs> eventHandlerImpl = this.Synthesizing;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, speechSynthesisEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long synthesizingSetCallback(SafeHandle safeHandle);

    private void visemeReceivedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "synthesizer");
            if (this.disposed) {
                return;
            }
            SpeechSynthesisVisemeEventArgs speechSynthesisVisemeEventArgs = new SpeechSynthesisVisemeEventArgs(j);
            EventHandlerImpl<SpeechSynthesisVisemeEventArgs> eventHandlerImpl = this.VisemeReceived;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, speechSynthesisVisemeEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long visemeReceivedSetCallback(SafeHandle safeHandle);

    private void wordBoundaryEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "synthesizer");
            if (this.disposed) {
                return;
            }
            SpeechSynthesisWordBoundaryEventArgs speechSynthesisWordBoundaryEventArgs = new SpeechSynthesisWordBoundaryEventArgs(j);
            EventHandlerImpl<SpeechSynthesisWordBoundaryEventArgs> eventHandlerImpl = this.WordBoundary;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, speechSynthesisWordBoundaryEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long wordBoundarySetCallback(SafeHandle safeHandle);

    public SpeechSynthesisResult SpeakSsml(String str) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(speakSsml(this.synthHandle, str, intRef));
        return new SpeechSynthesisResult(intRef);
    }

    public Future<SpeechSynthesisResult> SpeakSsmlAsync(final String str) {
        return AsyncThreadService.submit(new Callable<SpeechSynthesisResult>() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public SpeechSynthesisResult call() {
                final SpeechSynthesisResult[] speechSynthesisResultArr = new SpeechSynthesisResult[1];
                this.doAsyncSynthesisAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IntRef intRef = new IntRef(0L);
                        SpeechSynthesizer speechSynthesizer = SpeechSynthesizer.this;
                        Contracts.throwIfFail(speechSynthesizer.speakSsml(speechSynthesizer.synthHandle, str, intRef));
                        speechSynthesisResultArr[0] = new SpeechSynthesisResult(intRef);
                    }
                });
                return speechSynthesisResultArr[0];
            }
        });
    }

    public SpeechSynthesisResult SpeakText(String str) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(speakText(this.synthHandle, str, intRef));
        return new SpeechSynthesisResult(intRef);
    }

    public Future<SpeechSynthesisResult> SpeakTextAsync(final String str) {
        return AsyncThreadService.submit(new Callable<SpeechSynthesisResult>() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public SpeechSynthesisResult call() {
                final SpeechSynthesisResult[] speechSynthesisResultArr = new SpeechSynthesisResult[1];
                this.doAsyncSynthesisAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IntRef intRef = new IntRef(0L);
                        SpeechSynthesizer speechSynthesizer = SpeechSynthesizer.this;
                        Contracts.throwIfFail(speechSynthesizer.speakText(speechSynthesizer.synthHandle, str, intRef));
                        speechSynthesisResultArr[0] = new SpeechSynthesisResult(intRef);
                    }
                });
                return speechSynthesisResultArr[0];
            }
        });
    }

    public SpeechSynthesisResult StartSpeakingSsml(String str) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(startSpeakingSsml(this.synthHandle, str, intRef));
        return new SpeechSynthesisResult(intRef);
    }

    public Future<SpeechSynthesisResult> StartSpeakingSsmlAsync(final String str) {
        return AsyncThreadService.submit(new Callable<SpeechSynthesisResult>() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public SpeechSynthesisResult call() {
                final SpeechSynthesisResult[] speechSynthesisResultArr = new SpeechSynthesisResult[1];
                this.doAsyncSynthesisAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IntRef intRef = new IntRef(0L);
                        SpeechSynthesizer speechSynthesizer = SpeechSynthesizer.this;
                        Contracts.throwIfFail(speechSynthesizer.startSpeakingSsml(speechSynthesizer.synthHandle, str, intRef));
                        speechSynthesisResultArr[0] = new SpeechSynthesisResult(intRef);
                    }
                });
                return speechSynthesisResultArr[0];
            }
        });
    }

    public SpeechSynthesisResult StartSpeakingText(String str) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(startSpeakingText(this.synthHandle, str, intRef));
        return new SpeechSynthesisResult(intRef);
    }

    public Future<SpeechSynthesisResult> StartSpeakingTextAsync(final String str) {
        return AsyncThreadService.submit(new Callable<SpeechSynthesisResult>() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public SpeechSynthesisResult call() {
                final SpeechSynthesisResult[] speechSynthesisResultArr = new SpeechSynthesisResult[1];
                this.doAsyncSynthesisAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IntRef intRef = new IntRef(0L);
                        SpeechSynthesizer speechSynthesizer = SpeechSynthesizer.this;
                        Contracts.throwIfFail(speechSynthesizer.startSpeakingText(speechSynthesizer.synthHandle, str, intRef));
                        speechSynthesisResultArr[0] = new SpeechSynthesisResult(intRef);
                    }
                });
                return speechSynthesisResultArr[0];
            }
        });
    }

    public Future<Void> StopSpeakingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.5
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncSynthesisAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpeechSynthesizer speechSynthesizer = SpeechSynthesizer.this;
                        speechSynthesizer.stopSpeaking(speechSynthesizer.synthHandle);
                    }
                });
                return null;
            }
        });
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.synthesizerLock) {
            if (this.activeAsyncSynthesisCounter != 0) {
                try {
                    this.synthesizerLock.wait(disposeWaitingTime.intValue());
                } catch (InterruptedException unused) {
                }
            }
            if (this.activeAsyncSynthesisCounter != 0) {
                throw new IllegalStateException("Cannot dispose a synthesizer while async synthesis is running. Await async synthesis to avoid unexpected disposals.");
            }
            dispose(true);
        }
    }

    public String getAuthorizationToken() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceAuthorization_Token);
    }

    public SafeHandle getImpl() {
        return this.synthHandle;
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public Future<SynthesisVoicesResult> getVoicesAsync() {
        return getVoicesAsync("");
    }

    public void setAuthorizationToken(String str) {
        Contracts.throwIfNullOrWhitespace(str, "token");
        this.propertyHandle.setProperty(PropertyId.SpeechServiceAuthorization_Token, str);
    }

    public SpeechSynthesizer(EmbeddedSpeechConfig embeddedSpeechConfig, AudioConfig audioConfig) {
        this(embeddedSpeechConfig.config, audioConfig);
    }

    public Future<SynthesisVoicesResult> getVoicesAsync(final String str) {
        return AsyncThreadService.submit(new Callable<SynthesisVoicesResult>() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public SynthesisVoicesResult call() {
                final SynthesisVoicesResult[] synthesisVoicesResultArr = new SynthesisVoicesResult[1];
                this.doAsyncSynthesisAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechSynthesizer.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IntRef intRef = new IntRef(0L);
                        SpeechSynthesizer speechSynthesizer = SpeechSynthesizer.this;
                        Contracts.throwIfFail(speechSynthesizer.getVoices(speechSynthesizer.synthHandle, str, intRef));
                        synthesisVoicesResultArr[0] = new SynthesisVoicesResult(intRef);
                    }
                });
                return synthesisVoicesResultArr[0];
            }
        });
    }

    public SpeechSynthesizer(HybridSpeechConfig hybridSpeechConfig) {
        this(hybridSpeechConfig.config);
    }

    public SpeechSynthesizer(HybridSpeechConfig hybridSpeechConfig, AudioConfig audioConfig) {
        this(hybridSpeechConfig.config, audioConfig);
    }

    public SpeechSynthesizer(SpeechConfig speechConfig) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventCounter = atomicInteger;
        this.SynthesisStarted = new EventHandlerImpl<>(atomicInteger);
        this.Synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.SynthesisCompleted = new EventHandlerImpl<>(this.eventCounter);
        this.SynthesisCanceled = new EventHandlerImpl<>(this.eventCounter);
        this.WordBoundary = new EventHandlerImpl<>(this.eventCounter);
        this.VisemeReceived = new EventHandlerImpl<>(this.eventCounter);
        this.BookmarkReached = new EventHandlerImpl<>(this.eventCounter);
        this.synthHandle = null;
        this.disposed = false;
        this.synthesizerLock = new Object();
        this.activeAsyncSynthesisCounter = 0;
        this.audioOutputKeepAlive = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        this.synthHandle = new SafeHandle(0L, SafeHandleType.Synthesizer);
        AudioConfig fromDefaultSpeakerOutput = AudioConfig.fromDefaultSpeakerOutput();
        Contracts.throwIfFail(createSpeechSynthesizerFromConfig(this.synthHandle, speechConfig.getImpl(), fromDefaultSpeakerOutput.getImpl()));
        Contracts.throwIfNull(this.synthHandle.getValue(), "synthHandle");
        fromDefaultSpeakerOutput.close();
        initialize();
    }

    public SpeechSynthesizer(SpeechConfig speechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig, AudioConfig audioConfig) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventCounter = atomicInteger;
        this.SynthesisStarted = new EventHandlerImpl<>(atomicInteger);
        this.Synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.SynthesisCompleted = new EventHandlerImpl<>(this.eventCounter);
        this.SynthesisCanceled = new EventHandlerImpl<>(this.eventCounter);
        this.WordBoundary = new EventHandlerImpl<>(this.eventCounter);
        this.VisemeReceived = new EventHandlerImpl<>(this.eventCounter);
        this.BookmarkReached = new EventHandlerImpl<>(this.eventCounter);
        this.synthHandle = null;
        this.disposed = false;
        this.synthesizerLock = new Object();
        this.activeAsyncSynthesisCounter = 0;
        this.audioOutputKeepAlive = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(autoDetectSourceLanguageConfig, "autoDetectSourceLangConfig");
        SafeHandle safeHandle = new SafeHandle(0L, SafeHandleType.Synthesizer);
        this.synthHandle = safeHandle;
        Contracts.throwIfFail(createSpeechSynthesizerFromAutoDetectSourceLangConfig(safeHandle, speechConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), audioConfig != null ? audioConfig.getImpl() : null));
        Contracts.throwIfNull(this.synthHandle.getValue(), "synthHandle");
        this.audioOutputKeepAlive = audioConfig;
        initialize();
    }

    public SpeechSynthesizer(SpeechConfig speechConfig, AudioConfig audioConfig) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventCounter = atomicInteger;
        this.SynthesisStarted = new EventHandlerImpl<>(atomicInteger);
        this.Synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.SynthesisCompleted = new EventHandlerImpl<>(this.eventCounter);
        this.SynthesisCanceled = new EventHandlerImpl<>(this.eventCounter);
        this.WordBoundary = new EventHandlerImpl<>(this.eventCounter);
        this.VisemeReceived = new EventHandlerImpl<>(this.eventCounter);
        this.BookmarkReached = new EventHandlerImpl<>(this.eventCounter);
        this.synthHandle = null;
        this.disposed = false;
        this.synthesizerLock = new Object();
        this.activeAsyncSynthesisCounter = 0;
        this.audioOutputKeepAlive = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        SafeHandle safeHandle = new SafeHandle(0L, SafeHandleType.Synthesizer);
        this.synthHandle = safeHandle;
        Contracts.throwIfFail(createSpeechSynthesizerFromConfig(safeHandle, speechConfig.getImpl(), audioConfig != null ? audioConfig.getImpl() : null));
        Contracts.throwIfNull(this.synthHandle.getValue(), "synthHandle");
        this.audioOutputKeepAlive = audioConfig;
        initialize();
    }
}
