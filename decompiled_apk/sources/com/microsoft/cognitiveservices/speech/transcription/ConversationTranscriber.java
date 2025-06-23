package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.AutoDetectSourceLanguageConfig;
import com.microsoft.cognitiveservices.speech.OutputFormat;
import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.Recognizer;
import com.microsoft.cognitiveservices.speech.SourceLanguageConfig;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
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
public final class ConversationTranscriber extends Recognizer {
    static Set<ConversationTranscriber> conversationTranscriberObjects = Collections.synchronizedSet(new HashSet());
    public final EventHandlerImpl<ConversationTranscriptionCanceledEventArgs> canceled;
    private PropertyCollection propertyHandle;
    public final EventHandlerImpl<ConversationTranscriptionEventArgs> transcribed;
    public final EventHandlerImpl<ConversationTranscriptionEventArgs> transcribing;

    public ConversationTranscriber(SpeechConfig speechConfig) {
        super(null);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(createConversationTranscriberFromConfig(super.getImpl(), speechConfig.getImpl(), null));
        initialize();
    }

    private void canceledEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            ConversationTranscriptionCanceledEventArgs conversationTranscriptionCanceledEventArgs = new ConversationTranscriptionCanceledEventArgs(j, true);
            EventHandlerImpl<ConversationTranscriptionCanceledEventArgs> eventHandlerImpl = this.canceled;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, conversationTranscriptionCanceledEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    private final native long createConversationTranscriberFromAutoDetectSourceLangConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3, SafeHandle safeHandle4);

    private final native long createConversationTranscriberFromConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3);

    private final native long createConversationTranscriberFromSourceLangConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3, SafeHandle safeHandle4);

    private void initialize() {
        this.transcribing.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.3
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranscriber.conversationTranscriberObjects.add(this);
                Contracts.throwIfFail(ConversationTranscriber.this.recognizingSetCallback(this.getImpl().getValue()));
            }
        });
        this.transcribed.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.4
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranscriber.conversationTranscriberObjects.add(this);
                Contracts.throwIfFail(ConversationTranscriber.this.recognizedSetCallback(this.getImpl().getValue()));
            }
        });
        this.canceled.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.5
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranscriber.conversationTranscriberObjects.add(this);
                Contracts.throwIfFail(ConversationTranscriber.this.canceledSetCallback(this.getImpl().getValue()));
            }
        });
        this.sessionStarted.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.6
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranscriber.conversationTranscriberObjects.add(this);
                Contracts.throwIfFail(ConversationTranscriber.this.sessionStartedSetCallback(this.getImpl().getValue()));
            }
        });
        this.sessionStopped.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.7
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranscriber.conversationTranscriberObjects.add(this);
                Contracts.throwIfFail(ConversationTranscriber.this.sessionStoppedSetCallback(this.getImpl().getValue()));
            }
        });
        this.speechStartDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.8
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranscriber.conversationTranscriberObjects.add(this);
                Contracts.throwIfFail(ConversationTranscriber.this.speechStartDetectedSetCallback(this.getImpl().getValue()));
            }
        });
        this.speechEndDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.9
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranscriber.conversationTranscriberObjects.add(this);
                Contracts.throwIfFail(ConversationTranscriber.this.speechEndDetectedSetCallback(this.getImpl().getValue()));
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
            ConversationTranscriptionEventArgs conversationTranscriptionEventArgs = new ConversationTranscriptionEventArgs(j, true);
            EventHandlerImpl<ConversationTranscriptionEventArgs> eventHandlerImpl = this.transcribed;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, conversationTranscriptionEventArgs);
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
            ConversationTranscriptionEventArgs conversationTranscriptionEventArgs = new ConversationTranscriptionEventArgs(j, true);
            EventHandlerImpl<ConversationTranscriptionEventArgs> eventHandlerImpl = this.transcribing;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, conversationTranscriptionEventArgs);
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
            conversationTranscriberObjects.remove(this);
            super.dispose(z);
        }
    }

    public String getAuthorizationToken() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceAuthorization_Token);
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

    public void setAuthorizationToken(String str) {
        Contracts.throwIfNullOrWhitespace(str, "token");
        this.propertyHandle.setProperty(PropertyId.SpeechServiceAuthorization_Token, str);
    }

    public Future<Void> startTranscribingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.1
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        this.startContinuousRecognition(ConversationTranscriber.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> stopTranscribingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        this.stopContinuousRecognition(ConversationTranscriber.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public ConversationTranscriber(SpeechConfig speechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig) {
        super(null);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(autoDetectSourceLanguageConfig, "autoDetectSourceLangConfig");
        Contracts.throwIfFail(createConversationTranscriberFromAutoDetectSourceLangConfig(super.getImpl(), speechConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), null));
        initialize();
    }

    public ConversationTranscriber(SpeechConfig speechConfig, AutoDetectSourceLanguageConfig autoDetectSourceLanguageConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(autoDetectSourceLanguageConfig, "autoDetectSourceLangConfig");
        Contracts.throwIfFail(audioConfig == null ? createConversationTranscriberFromAutoDetectSourceLangConfig(super.getImpl(), speechConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), null) : createConversationTranscriberFromAutoDetectSourceLangConfig(super.getImpl(), speechConfig.getImpl(), autoDetectSourceLanguageConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public ConversationTranscriber(SpeechConfig speechConfig, SourceLanguageConfig sourceLanguageConfig) {
        super(null);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(sourceLanguageConfig, "sourceLanguageConfig");
        Contracts.throwIfFail(createConversationTranscriberFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), sourceLanguageConfig.getImpl(), null));
        initialize();
    }

    public ConversationTranscriber(SpeechConfig speechConfig, SourceLanguageConfig sourceLanguageConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(sourceLanguageConfig, "sourceLanguageConfig");
        Contracts.throwIfFail(audioConfig == null ? createConversationTranscriberFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), sourceLanguageConfig.getImpl(), null) : createConversationTranscriberFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), sourceLanguageConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public ConversationTranscriber(SpeechConfig speechConfig, AudioConfig audioConfig) {
        super(audioConfig);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfFail(audioConfig == null ? createConversationTranscriberFromConfig(super.getImpl(), speechConfig.getImpl(), null) : createConversationTranscriberFromConfig(super.getImpl(), speechConfig.getImpl(), audioConfig.getImpl()));
        initialize();
    }

    public ConversationTranscriber(SpeechConfig speechConfig, String str) {
        super(null);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfIllegalLanguage(str, "invalid language value");
        Contracts.throwIfFail(createConversationTranscriberFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), SourceLanguageConfig.fromLanguage(str).getImpl(), null));
        initialize();
    }

    public ConversationTranscriber(SpeechConfig speechConfig, String str, AudioConfig audioConfig) {
        super(audioConfig);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfIllegalLanguage(str, "invalid language value");
        Contracts.throwIfFail(audioConfig == null ? createConversationTranscriberFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), SourceLanguageConfig.fromLanguage(str).getImpl(), null) : createConversationTranscriberFromSourceLangConfig(super.getImpl(), speechConfig.getImpl(), SourceLanguageConfig.fromLanguage(str).getImpl(), audioConfig.getImpl()));
        initialize();
    }
}
