package com.microsoft.cognitiveservices.speech.intent;

import com.microsoft.cognitiveservices.speech.EmbeddedSpeechConfig;
import com.microsoft.cognitiveservices.speech.KeywordRecognitionModel;
import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.Recognizer;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.EventHandlerImpl;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public final class IntentRecognizer extends Recognizer {
    static Set<IntentRecognizer> intentRecognizerObjects = Collections.synchronizedSet(new HashSet());
    public final EventHandlerImpl<IntentRecognitionCanceledEventArgs> canceled;
    private PropertyCollection propertyHandle;
    public final EventHandlerImpl<IntentRecognitionEventArgs> recognized;
    public final EventHandlerImpl<IntentRecognitionEventArgs> recognizing;

    public IntentRecognizer(EmbeddedSpeechConfig embeddedSpeechConfig) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(embeddedSpeechConfig, "embeddedSpeechConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(createIntentRecognizerFromConfig(super.getImpl(), embeddedSpeechConfig.getImpl(), null));
        initialize();
    }

    private final native long addIntent(SafeHandle safeHandle, String str, SafeHandle safeHandle2);

    private final native long addIntentWithModelId(SafeHandle safeHandle, SafeHandle safeHandle2, String str);

    private void applyPatternMatchingModel(PatternMatchingModel patternMatchingModel) {
        SafeHandle safeHandle = new SafeHandle(0L, SafeHandleType.LanguageUnderstandingModel);
        try {
            Contracts.throwIfFail(createPatternMatchingModel(safeHandle, super.getImpl(), patternMatchingModel.getId()));
            for (PatternMatchingIntent patternMatchingIntent : patternMatchingModel.getIntents().values()) {
                Contracts.throwIfFail(patternMatchingModelAddIntent(safeHandle, patternMatchingIntent.getId(), 0, (String[]) patternMatchingIntent.Phrases.toArray(new String[0])));
            }
            for (PatternMatchingEntity patternMatchingEntity : patternMatchingModel.getEntities().values()) {
                Contracts.throwIfFail(patternMatchingModelAddEntity(safeHandle, patternMatchingEntity.getId(), patternMatchingEntity.getType().getValue(), patternMatchingEntity.getMatchMode().getValue(), (String[]) patternMatchingEntity.Phrases.toArray(new String[0])));
            }
            IntentTrigger fromModel = IntentTrigger.fromModel(safeHandle);
            try {
                Contracts.throwIfFail(addIntentWithModelId(super.getImpl(), fromModel.getImpl(), patternMatchingModel.getId()));
                fromModel.close();
                safeHandle.close();
            } finally {
            }
        } finally {
        }
    }

    private void canceledEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            IntentRecognitionCanceledEventArgs intentRecognitionCanceledEventArgs = new IntentRecognitionCanceledEventArgs(j, true);
            EventHandlerImpl<IntentRecognitionCanceledEventArgs> eventHandlerImpl = this.canceled;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, intentRecognitionCanceledEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    private final native long clearLanguageModels(SafeHandle safeHandle);

    private final native long createIntentRecognizerFromConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3);

    private final native long createPatternMatchingModel(SafeHandle safeHandle, SafeHandle safeHandle2, String str);

    private final native long importPatternMatchingModel(SafeHandle safeHandle, String str);

    private void initialize() {
        this.recognizing.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.7
            @Override // java.lang.Runnable
            public void run() {
                IntentRecognizer.intentRecognizerObjects.add(this);
                Contracts.throwIfFail(IntentRecognizer.this.recognizingSetCallback(this.getImpl().getValue()));
            }
        });
        this.recognized.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.8
            @Override // java.lang.Runnable
            public void run() {
                IntentRecognizer.intentRecognizerObjects.add(this);
                Contracts.throwIfFail(IntentRecognizer.this.recognizedSetCallback(this.getImpl().getValue()));
            }
        });
        this.canceled.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.9
            @Override // java.lang.Runnable
            public void run() {
                IntentRecognizer.intentRecognizerObjects.add(this);
                Contracts.throwIfFail(IntentRecognizer.this.canceledSetCallback(this.getImpl().getValue()));
            }
        });
        this.sessionStarted.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.10
            @Override // java.lang.Runnable
            public void run() {
                IntentRecognizer.intentRecognizerObjects.add(this);
                Contracts.throwIfFail(IntentRecognizer.this.sessionStartedSetCallback(this.getImpl().getValue()));
            }
        });
        this.sessionStopped.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.11
            @Override // java.lang.Runnable
            public void run() {
                IntentRecognizer.intentRecognizerObjects.add(this);
                Contracts.throwIfFail(IntentRecognizer.this.sessionStoppedSetCallback(this.getImpl().getValue()));
            }
        });
        this.speechStartDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.12
            @Override // java.lang.Runnable
            public void run() {
                IntentRecognizer.intentRecognizerObjects.add(this);
                Contracts.throwIfFail(IntentRecognizer.this.speechStartDetectedSetCallback(this.getImpl().getValue()));
            }
        });
        this.speechEndDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.13
            @Override // java.lang.Runnable
            public void run() {
                IntentRecognizer.intentRecognizerObjects.add(this);
                Contracts.throwIfFail(IntentRecognizer.this.speechEndDetectedSetCallback(this.getImpl().getValue()));
            }
        });
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromRecognizerHandle(getImpl(), intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    private final native long patternMatchingModelAddEntity(SafeHandle safeHandle, String str, int i, int i2, String[] strArr);

    private final native long patternMatchingModelAddIntent(SafeHandle safeHandle, String str, int i, String[] strArr);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long recognizeTextOnce(SafeHandle safeHandle, String str, IntRef intRef);

    private void recognizedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            IntentRecognitionEventArgs intentRecognitionEventArgs = new IntentRecognitionEventArgs(j, true);
            EventHandlerImpl<IntentRecognitionEventArgs> eventHandlerImpl = this.recognized;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, intentRecognitionEventArgs);
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
            IntentRecognitionEventArgs intentRecognitionEventArgs = new IntentRecognitionEventArgs(j, true);
            EventHandlerImpl<IntentRecognitionEventArgs> eventHandlerImpl = this.recognizing;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, intentRecognitionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    public void addAllIntents(LanguageUnderstandingModel languageUnderstandingModel) {
        Contracts.throwIfNull(languageUnderstandingModel, "model");
        Contracts.throwIfFail(addIntent(super.getImpl(), (String) null, IntentTrigger.fromModel(languageUnderstandingModel.getImpl()).getImpl()));
    }

    public void addIntent(LanguageUnderstandingModel languageUnderstandingModel, String str) {
        Contracts.throwIfNull(languageUnderstandingModel, "model");
        Contracts.throwIfNullOrWhitespace(str, "intentName");
        Contracts.throwIfFail(addIntent(super.getImpl(), str, IntentTrigger.fromModel(languageUnderstandingModel.getImpl(), str).getImpl()));
    }

    public boolean applyLanguageModels(Collection<LanguageUnderstandingModel> collection) throws NullPointerException {
        Contracts.throwIfNull(collection, "collection");
        Contracts.throwIfFail(clearLanguageModels(super.getImpl()));
        boolean z = true;
        for (LanguageUnderstandingModel languageUnderstandingModel : collection) {
            Contracts.throwIfNull(languageUnderstandingModel, "model");
            if (languageUnderstandingModel instanceof PatternMatchingModel) {
                applyPatternMatchingModel((PatternMatchingModel) languageUnderstandingModel);
            } else if (languageUnderstandingModel instanceof LanguageUnderstandingModel) {
                Contracts.throwIfFail(addIntent(super.getImpl(), (String) null, IntentTrigger.fromModel(languageUnderstandingModel.getImpl()).getImpl()));
                z = false;
            }
        }
        return z;
    }

    @Override // com.microsoft.cognitiveservices.speech.Recognizer
    public void dispose(boolean z) {
        if (!this.disposed && z) {
            PropertyCollection propertyCollection = this.propertyHandle;
            if (propertyCollection != null) {
                propertyCollection.close();
                this.propertyHandle = null;
            }
            intentRecognizerObjects.remove(this);
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

    public Future<IntentRecognitionResult> recognizeOnceAsync() {
        return AsyncThreadService.submit(new Callable<IntentRecognitionResult>() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public IntentRecognitionResult call() {
                final IntentRecognitionResult[] intentRecognitionResultArr = new IntentRecognitionResult[1];
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        intentRecognitionResultArr[0] = new IntentRecognitionResult(this.recognize());
                    }
                });
                return intentRecognitionResultArr[0];
            }
        });
    }

    public void setAuthorizationToken(String str) {
        Contracts.throwIfNullOrWhitespace(str, "token");
        this.propertyHandle.setProperty(PropertyId.SpeechServiceAuthorization_Token, str);
    }

    public Future<Void> startContinuousRecognitionAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.3
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        this.startContinuousRecognition(IntentRecognizer.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> startKeywordRecognitionAsync(final KeywordRecognitionModel keywordRecognitionModel) {
        Contracts.throwIfNull(keywordRecognitionModel, "model");
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.5
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        this.startKeywordRecognition(IntentRecognizer.this.getImpl(), keywordRecognitionModel.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> stopContinuousRecognitionAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.4
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        this.stopContinuousRecognition(IntentRecognizer.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> stopKeywordRecognitionAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.6
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        this.stopKeywordRecognition(IntentRecognizer.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public IntentRecognizer(EmbeddedSpeechConfig embeddedSpeechConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(embeddedSpeechConfig, "embeddedSpeechConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(audioConfig == null ? createIntentRecognizerFromConfig(super.getImpl(), embeddedSpeechConfig.getImpl(), null) : createIntentRecognizerFromConfig(super.getImpl(), embeddedSpeechConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public void addAllIntents(LanguageUnderstandingModel languageUnderstandingModel, String str) {
        Contracts.throwIfNull(languageUnderstandingModel, "model");
        Contracts.throwIfNullOrWhitespace(str, "intentId");
        Contracts.throwIfFail(addIntent(super.getImpl(), str, IntentTrigger.fromModel(languageUnderstandingModel.getImpl()).getImpl()));
    }

    public void addIntent(LanguageUnderstandingModel languageUnderstandingModel, String str, String str2) {
        Contracts.throwIfNull(languageUnderstandingModel, "model");
        Contracts.throwIfNullOrWhitespace(str, "intentName");
        Contracts.throwIfNullOrWhitespace(str2, "intentId");
        Contracts.throwIfFail(addIntent(super.getImpl(), str2, IntentTrigger.fromModel(languageUnderstandingModel.getImpl(), str).getImpl()));
    }

    public Future<IntentRecognitionResult> recognizeOnceAsync(final String str) {
        return AsyncThreadService.submit(new Callable<IntentRecognitionResult>() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public IntentRecognitionResult call() {
                final IntentRecognitionResult[] intentRecognitionResultArr = new IntentRecognitionResult[1];
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.intent.IntentRecognizer.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IntRef intRef = new IntRef(0L);
                        Contracts.throwIfNull(this, "Invalid recognizer handle");
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        Contracts.throwIfFail(IntentRecognizer.this.recognizeTextOnce(this.getImpl(), str, intRef));
                        intentRecognitionResultArr[0] = new IntentRecognitionResult(intRef.getValue());
                    }
                });
                return intentRecognitionResultArr[0];
            }
        });
    }

    public IntentRecognizer(SpeechConfig speechConfig) {
        super(null);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(createIntentRecognizerFromConfig(super.getImpl(), speechConfig.getImpl(), null));
        initialize();
    }

    public void addIntent(String str) {
        Contracts.throwIfNullOrWhitespace(str, "simplePhrase");
        Contracts.throwIfFail(addIntent(super.getImpl(), str, IntentTrigger.fromPhrase(str).getImpl()));
    }

    public IntentRecognizer(SpeechConfig speechConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.recognizing = new EventHandlerImpl<>(this.eventCounter);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfFail(audioConfig == null ? createIntentRecognizerFromConfig(super.getImpl(), speechConfig.getImpl(), null) : createIntentRecognizerFromConfig(super.getImpl(), speechConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public void addIntent(String str, String str2) {
        Contracts.throwIfNullOrWhitespace(str, "simplePhrase");
        Contracts.throwIfNullOrWhitespace(str2, "intentId");
        Contracts.throwIfFail(addIntent(super.getImpl(), str2, IntentTrigger.fromPhrase(str).getImpl()));
    }
}
