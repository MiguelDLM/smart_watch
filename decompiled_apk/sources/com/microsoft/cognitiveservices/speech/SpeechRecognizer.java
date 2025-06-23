package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.EventHandlerImpl;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public final class SpeechRecognizer extends Recognizer {
    static Set<SpeechRecognizer> speechRecognizerObjects = Collections.synchronizedSet(new HashSet());
    public final EventHandlerImpl<SpeechRecognitionCanceledEventArgs> canceled;
    private PropertyCollection propertyHandle;
    public final EventHandlerImpl<SpeechRecognitionEventArgs> recognized;
    public final EventHandlerImpl<SpeechRecognitionEventArgs> recognizing;

    public SpeechRecognizer(EmbeddedSpeechConfig embeddedSpeechConfig) {
        this(embeddedSpeechConfig.config);
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

    private final native long createSpeechRecognizerFromAutoDetectSourceLangConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3, SafeHandle safeHandle4);

    private final native long createSpeechRecognizerFromConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3);

    private final native long createSpeechRecognizerFromSourceLangConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3, SafeHandle safeHandle4);

    private void initialize() {
        this.recognizing.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.6
            @Override // java.lang.Runnable
            public void run() {
                SpeechRecognizer.speechRecognizerObjects.add(this);
                Contracts.throwIfFail(SpeechRecognizer.this.recognizingSetCallback(this.getImpl().getValue()));
            }
        });
        this.recognized.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.7
            @Override // java.lang.Runnable
            public void run() {
                SpeechRecognizer.speechRecognizerObjects.add(this);
                Contracts.throwIfFail(SpeechRecognizer.this.recognizedSetCallback(this.getImpl().getValue()));
            }
        });
        this.canceled.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.8
            @Override // java.lang.Runnable
            public void run() {
                SpeechRecognizer.speechRecognizerObjects.add(this);
                Contracts.throwIfFail(SpeechRecognizer.this.canceledSetCallback(this.getImpl().getValue()));
            }
        });
        this.sessionStarted.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.9
            @Override // java.lang.Runnable
            public void run() {
                SpeechRecognizer.speechRecognizerObjects.add(this);
                Contracts.throwIfFail(SpeechRecognizer.this.sessionStartedSetCallback(this.getImpl().getValue()));
            }
        });
        this.sessionStopped.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.10
            @Override // java.lang.Runnable
            public void run() {
                SpeechRecognizer.speechRecognizerObjects.add(this);
                Contracts.throwIfFail(SpeechRecognizer.this.sessionStoppedSetCallback(this.getImpl().getValue()));
            }
        });
        this.speechStartDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.11
            @Override // java.lang.Runnable
            public void run() {
                SpeechRecognizer.speechRecognizerObjects.add(this);
                Contracts.throwIfFail(SpeechRecognizer.this.speechStartDetectedSetCallback(this.getImpl().getValue()));
            }
        });
        this.speechEndDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.12
            @Override // java.lang.Runnable
            public void run() {
                SpeechRecognizer.speechRecognizerObjects.add(this);
                Contracts.throwIfFail(SpeechRecognizer.this.speechEndDetectedSetCallback(this.getImpl().getValue()));
            }
        });
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromRecognizerHandle(getImpl(), intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    private void recognizedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            SpeechRecognitionEventArgs speechRecognitionEventArgs = new SpeechRecognitionEventArgs(j, true);
            EventHandlerImpl<SpeechRecognitionEventArgs> eventHandlerImpl = this.recognized;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, speechRecognitionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    private void recognizingEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            SpeechRecognitionEventArgs speechRecognitionEventArgs = new SpeechRecognitionEventArgs(j, true);
            EventHandlerImpl<SpeechRecognitionEventArgs> eventHandlerImpl = this.recognizing;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, speechRecognitionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.microsoft.cognitiveservices.speech.Recognizer
    public void dispose(boolean z) {
        if (!this.disposed && z) {
            PropertyCollection propertyCollection = this.propertyHandle;
            if (propertyCollection != null) {
                propertyCollection.close();
                this.propertyHandle = null;
            }
            speechRecognizerObjects.remove(this);
            super.dispose(z);
        }
    }

    public String getAuthorizationToken() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceAuthorization_Token);
    }

    public String getEndpointId() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceConnection_EndpointId);
    }

    public OutputFormat getOutputFormat() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceResponse_RequestDetailedResultTrueFalse).equals("true") ? OutputFormat.Detailed : OutputFormat.Simple;
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public String getSpeechRecognitionLanguage() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceConnection_RecoLanguage);
    }

    public Future<SpeechRecognitionResult> recognizeOnceAsync() {
        return AsyncThreadService.submit(new Callable<SpeechRecognitionResult>() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public SpeechRecognitionResult call() {
                final SpeechRecognitionResult[] speechRecognitionResultArr = new SpeechRecognitionResult[1];
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        speechRecognitionResultArr[0] = new SpeechRecognitionResult(this.recognize());
                    }
                });
                return speechRecognitionResultArr[0];
            }
        });
    }

    public void setAuthorizationToken(String str) {
        Contracts.throwIfNullOrWhitespace(str, "token");
        this.propertyHandle.setProperty(PropertyId.SpeechServiceAuthorization_Token, str);
    }

    public Future<Void> startContinuousRecognitionAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        this.startContinuousRecognition(SpeechRecognizer.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> startKeywordRecognitionAsync(final KeywordRecognitionModel keywordRecognitionModel) {
        Contracts.throwIfNull(keywordRecognitionModel, "model");
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.4
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        this.startKeywordRecognition(SpeechRecognizer.this.getImpl(), keywordRecognitionModel.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> stopContinuousRecognitionAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.3
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        this.stopContinuousRecognition(SpeechRecognizer.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> stopKeywordRecognitionAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.5
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.SpeechRecognizer.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        this.stopKeywordRecognition(SpeechRecognizer.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public SpeechRecognizer(EmbeddedSpeechConfig embeddedSpeechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig) {
        this(embeddedSpeechConfig.config, autoDetectSourceLanguageConfig);
    }

    public SpeechRecognizer(EmbeddedSpeechConfig embeddedSpeechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig, AudioConfig audioConfig) {
        this(embeddedSpeechConfig.config, autoDetectSourceLanguageConfig, audioConfig);
    }

    public SpeechRecognizer(EmbeddedSpeechConfig embeddedSpeechConfig, AudioConfig audioConfig) {
        this(embeddedSpeechConfig.config, audioConfig);
    }

    public SpeechRecognizer(HybridSpeechConfig hybridSpeechConfig) {
        this(hybridSpeechConfig.config);
    }

    public SpeechRecognizer(HybridSpeechConfig hybridSpeechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig) {
        this(hybridSpeechConfig.config, autoDetectSourceLanguageConfig);
    }

    public SpeechRecognizer(HybridSpeechConfig hybridSpeechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig, AudioConfig audioConfig) {
        this(hybridSpeechConfig.config, autoDetectSourceLanguageConfig, audioConfig);
    }

    public SpeechRecognizer(HybridSpeechConfig hybridSpeechConfig, AudioConfig audioConfig) {
        this(hybridSpeechConfig.config, audioConfig);
    }

    public SpeechRecognizer(SpeechConfig speechConfig) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(createSpeechRecognizerFromConfig(super.getImpl(), speechConfig.getImpl(), null));
        initialize();
    }

    public SpeechRecognizer(SpeechConfig speechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(autoDetectSourceLanguageConfig, "autoDetectSourceLangConfig");
        Contracts.throwIfFail(createSpeechRecognizerFromAutoDetectSourceLangConfig(super.getImpl(), speechConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), null));
        initialize();
    }

    public SpeechRecognizer(SpeechConfig speechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(autoDetectSourceLanguageConfig, "autoDetectSourceLangConfig");
        Contracts.throwIfFail(audioConfig == null ? createSpeechRecognizerFromAutoDetectSourceLangConfig(super.getImpl(), speechConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), null) : createSpeechRecognizerFromAutoDetectSourceLangConfig(super.getImpl(), speechConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public SpeechRecognizer(SpeechConfig speechConfig, SourceLanguageConfig sourceLanguageConfig) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(sourceLanguageConfig, "sourceLanguageConfig");
        Contracts.throwIfFail(createSpeechRecognizerFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), sourceLanguageConfig.getImpl(), null));
        initialize();
    }

    public SpeechRecognizer(SpeechConfig speechConfig, SourceLanguageConfig sourceLanguageConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(sourceLanguageConfig, "sourceLanguageConfig");
        Contracts.throwIfFail(audioConfig == null ? createSpeechRecognizerFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), sourceLanguageConfig.getImpl(), null) : createSpeechRecognizerFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), sourceLanguageConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public SpeechRecognizer(SpeechConfig speechConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfFail(audioConfig == null ? createSpeechRecognizerFromConfig(super.getImpl(), speechConfig.getImpl(), null) : createSpeechRecognizerFromConfig(super.getImpl(), speechConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public SpeechRecognizer(SpeechConfig speechConfig, String str) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfIllegalLanguage(str, "invalid language value");
        Contracts.throwIfFail(createSpeechRecognizerFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), SourceLanguageConfig.fromLanguage(str).getImpl(), null));
        initialize();
    }

    public SpeechRecognizer(SpeechConfig speechConfig, String str, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfIllegalLanguage(str, "invalid language value");
        Contracts.throwIfFail(audioConfig == null ? createSpeechRecognizerFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), SourceLanguageConfig.fromLanguage(str).getImpl(), null) : createSpeechRecognizerFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), SourceLanguageConfig.fromLanguage(str).getImpl(), audioConfig.getImpl()));
        initialize();
    }
}
