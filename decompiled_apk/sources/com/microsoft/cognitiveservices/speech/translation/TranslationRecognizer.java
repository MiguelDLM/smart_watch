package com.microsoft.cognitiveservices.speech.translation;

import com.microsoft.cognitiveservices.speech.AutoDetectSourceLanguageConfig;
import com.microsoft.cognitiveservices.speech.EmbeddedSpeechConfig;
import com.microsoft.cognitiveservices.speech.HybridSpeechConfig;
import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.Recognizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.EventHandlerImpl;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public final class TranslationRecognizer extends Recognizer {
    static Set<TranslationRecognizer> translationRecognizerObjects = Collections.synchronizedSet(new HashSet());
    public final EventHandlerImpl<TranslationRecognitionCanceledEventArgs> canceled;
    private PropertyCollection propertyHandle;
    public final EventHandlerImpl<TranslationRecognitionEventArgs> recognized;
    public final EventHandlerImpl<TranslationRecognitionEventArgs> recognizing;
    public final EventHandlerImpl<TranslationSynthesisEventArgs> synthesizing;
    SafeHandle translationSynthesisHandle;

    public TranslationRecognizer(EmbeddedSpeechConfig embeddedSpeechConfig) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        this.translationSynthesisHandle = null;
        Contracts.throwIfNull(embeddedSpeechConfig, "embeddedSpeechConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(createTranslationRecognizerFromConfig(super.getImpl(), embeddedSpeechConfig.getImpl(), null));
        initialize();
    }

    private final native long addTargetLanguage(SafeHandle safeHandle, String str);

    private void canceledEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            TranslationRecognitionCanceledEventArgs translationRecognitionCanceledEventArgs = new TranslationRecognitionCanceledEventArgs(j, true);
            EventHandlerImpl<TranslationRecognitionCanceledEventArgs> eventHandlerImpl = this.canceled;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, translationRecognitionCanceledEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    private final native long createTranslationRecognizerFromAutoDetectSourceLangConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3, SafeHandle safeHandle4);

    private final native long createTranslationRecognizerFromConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3);

    private void initialize() {
        this.translationSynthesisHandle = new SafeHandle(getImpl().getValue(), SafeHandleType.TranslationSynthesis);
        this.recognizing.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.4
            @Override // java.lang.Runnable
            public void run() {
                TranslationRecognizer.translationRecognizerObjects.add(this);
                Contracts.throwIfFail(TranslationRecognizer.this.recognizingSetCallback(this.getImpl().getValue()));
            }
        });
        this.recognized.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.5
            @Override // java.lang.Runnable
            public void run() {
                TranslationRecognizer.translationRecognizerObjects.add(this);
                Contracts.throwIfFail(TranslationRecognizer.this.recognizedSetCallback(this.getImpl().getValue()));
            }
        });
        this.synthesizing.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.6
            @Override // java.lang.Runnable
            public void run() {
                TranslationRecognizer.translationRecognizerObjects.add(this);
                Contracts.throwIfFail(TranslationRecognizer.this.synthesizingSetCallback(this.getImpl().getValue()));
            }
        });
        this.canceled.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.7
            @Override // java.lang.Runnable
            public void run() {
                TranslationRecognizer.translationRecognizerObjects.add(this);
                Contracts.throwIfFail(TranslationRecognizer.this.canceledSetCallback(this.getImpl().getValue()));
            }
        });
        this.sessionStarted.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.8
            @Override // java.lang.Runnable
            public void run() {
                TranslationRecognizer.translationRecognizerObjects.add(this);
                Contracts.throwIfFail(TranslationRecognizer.this.sessionStartedSetCallback(this.getImpl().getValue()));
            }
        });
        this.sessionStopped.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.9
            @Override // java.lang.Runnable
            public void run() {
                TranslationRecognizer.translationRecognizerObjects.add(this);
                Contracts.throwIfFail(TranslationRecognizer.this.sessionStoppedSetCallback(this.getImpl().getValue()));
            }
        });
        this.speechStartDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.10
            @Override // java.lang.Runnable
            public void run() {
                TranslationRecognizer.translationRecognizerObjects.add(this);
                Contracts.throwIfFail(TranslationRecognizer.this.speechStartDetectedSetCallback(this.getImpl().getValue()));
            }
        });
        this.speechEndDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.11
            @Override // java.lang.Runnable
            public void run() {
                TranslationRecognizer.translationRecognizerObjects.add(this);
                Contracts.throwIfFail(TranslationRecognizer.this.speechEndDetectedSetCallback(this.getImpl().getValue()));
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
            TranslationRecognitionEventArgs translationRecognitionEventArgs = new TranslationRecognitionEventArgs(j, true);
            EventHandlerImpl<TranslationRecognitionEventArgs> eventHandlerImpl = this.recognized;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, translationRecognitionEventArgs);
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
            TranslationRecognitionEventArgs translationRecognitionEventArgs = new TranslationRecognitionEventArgs(j, true);
            EventHandlerImpl<TranslationRecognitionEventArgs> eventHandlerImpl = this.recognizing;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, translationRecognitionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    private final native long removeTargetLanguage(SafeHandle safeHandle, String str);

    private void synthesizingEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            TranslationSynthesisEventArgs translationSynthesisEventArgs = new TranslationSynthesisEventArgs(j, true);
            EventHandlerImpl<TranslationSynthesisEventArgs> eventHandlerImpl = this.synthesizing;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, translationSynthesisEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long synthesizingSetCallback(long j);

    public void addTargetLanguage(String str) {
        Contracts.throwIfNullOrWhitespace(str, "value");
        Contracts.throwIfFail(addTargetLanguage(super.getImpl(), str));
    }

    @Override // com.microsoft.cognitiveservices.speech.Recognizer
    public void dispose(boolean z) {
        if (!this.disposed && z) {
            PropertyCollection propertyCollection = this.propertyHandle;
            if (propertyCollection != null) {
                propertyCollection.close();
                this.propertyHandle = null;
            }
            SafeHandle safeHandle = this.translationSynthesisHandle;
            if (safeHandle != null) {
                safeHandle.close();
                this.translationSynthesisHandle = null;
            }
            translationRecognizerObjects.remove(this);
            super.dispose(z);
        }
    }

    public String getAuthorizationToken() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceAuthorization_Token);
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public String getSpeechRecognitionLanguage() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceConnection_RecoLanguage);
    }

    public ArrayList<String> getTargetLanguages() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.propertyHandle.getProperty(PropertyId.SpeechServiceConnection_TranslationToLanguages).split(",")) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public String getVoiceName() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceConnection_TranslationVoice);
    }

    public Future<TranslationRecognitionResult> recognizeOnceAsync() {
        return AsyncThreadService.submit(new Callable<TranslationRecognitionResult>() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public TranslationRecognitionResult call() {
                final TranslationRecognitionResult[] translationRecognitionResultArr = new TranslationRecognitionResult[1];
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        translationRecognitionResultArr[0] = new TranslationRecognitionResult(this.recognize());
                    }
                });
                return translationRecognitionResultArr[0];
            }
        });
    }

    public void removeTargetLanguage(String str) {
        Contracts.throwIfNullOrWhitespace(str, "value");
        Contracts.throwIfFail(removeTargetLanguage(super.getImpl(), str));
    }

    public void setAuthorizationToken(String str) {
        Contracts.throwIfNullOrWhitespace(str, "token");
        this.propertyHandle.setProperty(PropertyId.SpeechServiceAuthorization_Token, str);
    }

    public Future<Void> startContinuousRecognitionAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        this.startContinuousRecognition(TranslationRecognizer.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> stopContinuousRecognitionAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.3
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.translation.TranslationRecognizer.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        this.stopContinuousRecognition(TranslationRecognizer.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public TranslationRecognizer(EmbeddedSpeechConfig embeddedSpeechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        this.translationSynthesisHandle = null;
        Contracts.throwIfNull(embeddedSpeechConfig, "embeddedSpeechConfig");
        Contracts.throwIfNull(autoDetectSourceLanguageConfig, "autoDetectSourceLangConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(createTranslationRecognizerFromAutoDetectSourceLangConfig(super.getImpl(), embeddedSpeechConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), null));
        initialize();
    }

    public TranslationRecognizer(EmbeddedSpeechConfig embeddedSpeechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        this.translationSynthesisHandle = null;
        Contracts.throwIfNull(embeddedSpeechConfig, "embeddedSpeechConfig");
        Contracts.throwIfNull(autoDetectSourceLanguageConfig, "autoDetectSourceLangConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(audioConfig == null ? createTranslationRecognizerFromAutoDetectSourceLangConfig(super.getImpl(), embeddedSpeechConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), null) : createTranslationRecognizerFromAutoDetectSourceLangConfig(super.getImpl(), embeddedSpeechConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public TranslationRecognizer(EmbeddedSpeechConfig embeddedSpeechConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        this.translationSynthesisHandle = null;
        Contracts.throwIfNull(embeddedSpeechConfig, "embeddedSpeechConfig");
        Contracts.throwIfFail(audioConfig == null ? createTranslationRecognizerFromConfig(super.getImpl(), embeddedSpeechConfig.getImpl(), null) : createTranslationRecognizerFromConfig(super.getImpl(), embeddedSpeechConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public TranslationRecognizer(HybridSpeechConfig hybridSpeechConfig) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        this.translationSynthesisHandle = null;
        Contracts.throwIfNull(hybridSpeechConfig, "hybridSpeechConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(createTranslationRecognizerFromConfig(super.getImpl(), hybridSpeechConfig.getImpl(), null));
        initialize();
    }

    public TranslationRecognizer(HybridSpeechConfig hybridSpeechConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        this.translationSynthesisHandle = null;
        Contracts.throwIfNull(hybridSpeechConfig, "hybridSpeechConfig");
        Contracts.throwIfFail(audioConfig == null ? createTranslationRecognizerFromConfig(super.getImpl(), hybridSpeechConfig.getImpl(), null) : createTranslationRecognizerFromConfig(super.getImpl(), hybridSpeechConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public TranslationRecognizer(SpeechTranslationConfig speechTranslationConfig) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        this.translationSynthesisHandle = null;
        Contracts.throwIfNull(speechTranslationConfig, "stc");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(createTranslationRecognizerFromConfig(super.getImpl(), speechTranslationConfig.getImpl(), null));
        initialize();
    }

    public TranslationRecognizer(SpeechTranslationConfig speechTranslationConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        this.translationSynthesisHandle = null;
        Contracts.throwIfNull(speechTranslationConfig, "stc");
        Contracts.throwIfNull(autoDetectSourceLanguageConfig, "autoDetectSourceLangConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(createTranslationRecognizerFromAutoDetectSourceLangConfig(super.getImpl(), speechTranslationConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), null));
        initialize();
    }

    public TranslationRecognizer(SpeechTranslationConfig speechTranslationConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        this.translationSynthesisHandle = null;
        Contracts.throwIfNull(speechTranslationConfig, "stc");
        Contracts.throwIfNull(autoDetectSourceLanguageConfig, "autoDetectSourceLangConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(audioConfig == null ? createTranslationRecognizerFromAutoDetectSourceLangConfig(super.getImpl(), speechTranslationConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), null) : createTranslationRecognizerFromAutoDetectSourceLangConfig(super.getImpl(), speechTranslationConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public TranslationRecognizer(SpeechTranslationConfig speechTranslationConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.synthesizing = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        this.translationSynthesisHandle = null;
        Contracts.throwIfNull(speechTranslationConfig, "stc");
        Contracts.throwIfFail(audioConfig == null ? createTranslationRecognizerFromConfig(super.getImpl(), speechTranslationConfig.getImpl(), null) : createTranslationRecognizerFromConfig(super.getImpl(), speechTranslationConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }
}
