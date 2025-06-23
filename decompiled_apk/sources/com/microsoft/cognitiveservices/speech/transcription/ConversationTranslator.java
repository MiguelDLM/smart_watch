package com.microsoft.cognitiveservices.speech.transcription;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.SessionEventArgs;
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
public class ConversationTranslator implements AutoCloseable {
    static Set<ConversationTranslator> conversationTranslatorObjects = Collections.synchronizedSet(new HashSet());
    private int activeAsyncRecognitionCounter;
    private AudioConfig audioInputKeepAlive;
    public final EventHandlerImpl<ConversationTranslationCanceledEventArgs> canceled;
    public final EventHandlerImpl<ConversationExpirationEventArgs> conversationExpiration;
    private boolean disposed;
    private AtomicInteger eventCounter;
    public final EventHandlerImpl<ConversationParticipantsChangedEventArgs> participantsChanged;
    private PropertyCollection propertyHandle;
    public final EventHandlerImpl<SessionEventArgs> sessionStarted;
    public final EventHandlerImpl<SessionEventArgs> sessionStopped;
    public final EventHandlerImpl<ConversationTranslationEventArgs> textMessageReceived;
    public final EventHandlerImpl<ConversationTranslationEventArgs> transcribed;
    public final EventHandlerImpl<ConversationTranslationEventArgs> transcribing;
    private SafeHandle translatorHandle;
    private final Object translatorLock;

    public ConversationTranslator() {
        this(null);
    }

    private void canceledEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "conversationTranslator");
            if (this.disposed) {
                return;
            }
            ConversationTranslationCanceledEventArgs conversationTranslationCanceledEventArgs = new ConversationTranslationCanceledEventArgs(j, true);
            EventHandlerImpl<ConversationTranslationCanceledEventArgs> eventHandlerImpl = this.canceled;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, conversationTranslationCanceledEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long canceledSetCallback(long j);

    private void conversationExpireEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "conversationTranslator");
            if (this.disposed) {
                return;
            }
            ConversationExpirationEventArgs conversationExpirationEventArgs = new ConversationExpirationEventArgs(j, true);
            EventHandlerImpl<ConversationExpirationEventArgs> eventHandlerImpl = this.conversationExpiration;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, conversationExpirationEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long conversationExpireSetCallback(long j);

    private final native long createConversationTranslatorFromConfig(SafeHandle safeHandle, SafeHandle safeHandle2);

    private void dispose(boolean z) {
        if (!this.disposed && z) {
            PropertyCollection propertyCollection = this.propertyHandle;
            if (propertyCollection != null) {
                propertyCollection.close();
                this.propertyHandle = null;
            }
            SafeHandle safeHandle = this.translatorHandle;
            if (safeHandle != null) {
                safeHandle.close();
                this.translatorHandle = null;
            }
            conversationTranslatorObjects.remove(this);
            this.audioInputKeepAlive = null;
            AsyncThreadService.shutdown();
            this.disposed = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAsyncRecognitionAction(Runnable runnable) {
        synchronized (this.translatorLock) {
            this.activeAsyncRecognitionCounter++;
        }
        if (this.disposed) {
            throw new IllegalStateException(getClass().getName());
        }
        try {
            runnable.run();
            synchronized (this.translatorLock) {
                this.activeAsyncRecognitionCounter--;
            }
        } catch (Throwable th) {
            synchronized (this.translatorLock) {
                this.activeAsyncRecognitionCounter--;
                throw th;
            }
        }
    }

    private final native long getPropertyBagFromHandle(SafeHandle safeHandle, IntRef intRef);

    private void initialize() {
        AsyncThreadService.initialize();
        this.sessionStarted.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.7
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranslator.conversationTranslatorObjects.add(this);
                Contracts.throwIfFail(ConversationTranslator.this.sessionStartedSetCallback(this.translatorHandle.getValue()));
            }
        });
        this.sessionStopped.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.8
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranslator.conversationTranslatorObjects.add(this);
                Contracts.throwIfFail(ConversationTranslator.this.sessionStoppedSetCallback(this.translatorHandle.getValue()));
            }
        });
        this.canceled.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.9
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranslator.conversationTranslatorObjects.add(this);
                Contracts.throwIfFail(ConversationTranslator.this.canceledSetCallback(this.translatorHandle.getValue()));
            }
        });
        this.conversationExpiration.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.10
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranslator.conversationTranslatorObjects.add(this);
                Contracts.throwIfFail(ConversationTranslator.this.conversationExpireSetCallback(this.translatorHandle.getValue()));
            }
        });
        this.participantsChanged.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.11
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranslator.conversationTranslatorObjects.add(this);
                Contracts.throwIfFail(ConversationTranslator.this.participantsChangedSetCallback(this.translatorHandle.getValue()));
            }
        });
        this.transcribing.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.12
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranslator.conversationTranslatorObjects.add(this);
                Contracts.throwIfFail(ConversationTranslator.this.transcribingSetCallback(this.translatorHandle.getValue()));
            }
        });
        this.transcribed.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.13
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranslator.conversationTranslatorObjects.add(this);
                Contracts.throwIfFail(ConversationTranslator.this.transcribedSetCallback(this.translatorHandle.getValue()));
            }
        });
        this.textMessageReceived.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.14
            @Override // java.lang.Runnable
            public void run() {
                ConversationTranslator.conversationTranslatorObjects.add(this);
                Contracts.throwIfFail(ConversationTranslator.this.textMessageSetCallback(this.translatorHandle.getValue()));
            }
        });
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromHandle(this.translatorHandle, intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long joinConversation(SafeHandle safeHandle, SafeHandle safeHandle2, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long joinConversationId(SafeHandle safeHandle, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long leaveConversation(SafeHandle safeHandle);

    private void participantsChangedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "conversationTranslator");
            if (this.disposed) {
                return;
            }
            ConversationParticipantsChangedEventArgs conversationParticipantsChangedEventArgs = new ConversationParticipantsChangedEventArgs(j, true);
            EventHandlerImpl<ConversationParticipantsChangedEventArgs> eventHandlerImpl = this.participantsChanged;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, conversationParticipantsChangedEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long participantsChangedSetCallback(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long sendText(SafeHandle safeHandle, String str);

    private void sessionStartedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "conversationTranslator");
            if (this.disposed) {
                return;
            }
            SessionEventArgs sessionEventArgs = new SessionEventArgs(j, true);
            EventHandlerImpl<SessionEventArgs> eventHandlerImpl = this.sessionStarted;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, sessionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long sessionStartedSetCallback(long j);

    private void sessionStoppedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "conversationTranslator");
            if (this.disposed) {
                return;
            }
            SessionEventArgs sessionEventArgs = new SessionEventArgs(j, true);
            EventHandlerImpl<SessionEventArgs> eventHandlerImpl = this.sessionStopped;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, sessionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long sessionStoppedSetCallback(long j);

    private final native long setAuthToken(SafeHandle safeHandle, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long startTranscribing(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long stopTranscribing(SafeHandle safeHandle);

    private void textMessageEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "conversationTranslator");
            if (this.disposed) {
                return;
            }
            ConversationTranslationEventArgs conversationTranslationEventArgs = new ConversationTranslationEventArgs(j, true);
            EventHandlerImpl<ConversationTranslationEventArgs> eventHandlerImpl = this.textMessageReceived;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, conversationTranslationEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long textMessageSetCallback(long j);

    private void transcribedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "conversationTranslator");
            if (this.disposed) {
                return;
            }
            ConversationTranslationEventArgs conversationTranslationEventArgs = new ConversationTranslationEventArgs(j, true);
            EventHandlerImpl<ConversationTranslationEventArgs> eventHandlerImpl = this.transcribed;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, conversationTranslationEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long transcribedSetCallback(long j);

    private void transcribingEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "conversationTranslator");
            if (this.disposed) {
                return;
            }
            ConversationTranslationEventArgs conversationTranslationEventArgs = new ConversationTranslationEventArgs(j, true);
            EventHandlerImpl<ConversationTranslationEventArgs> eventHandlerImpl = this.transcribing;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, conversationTranslationEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long transcribingSetCallback(long j);

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.translatorLock) {
            try {
                if (this.activeAsyncRecognitionCounter != 0) {
                    throw new IllegalStateException("Cannot dispose a conversationTranslator while async transcription is running. Await async recognitions to avoid unexpected disposals.");
                }
                dispose(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getAuthorizationToken() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceAuthorization_Token);
    }

    public SafeHandle getImpl() {
        return this.translatorHandle;
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public String getSpeechRecognitionLanguage() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceConnection_RecoLanguage);
    }

    public Future<Void> joinConversationAsync(final Conversation conversation, final String str) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.1
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        Contracts.throwIfFail(this.joinConversation(ConversationTranslator.this.translatorHandle, conversation.getImpl(), str));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> leaveConversationAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.3
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        Contracts.throwIfFail(this.leaveConversation(ConversationTranslator.this.translatorHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> sendTextMessageAsync(final String str) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.4
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        Contracts.throwIfFail(this.sendText(ConversationTranslator.this.translatorHandle, str));
                    }
                });
                return null;
            }
        });
    }

    public void setAuthorizationToken(String str, String str2) {
        Contracts.throwIfNullOrWhitespace(str, "authToken");
        Contracts.throwIfNullOrWhitespace(str2, TtmlNode.TAG_REGION);
        Contracts.throwIfFail(setAuthToken(this.translatorHandle, str, str2));
    }

    public Future<Void> startTranscribingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.5
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        Contracts.throwIfFail(this.startTranscribing(ConversationTranslator.this.translatorHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> stopTranscribingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.6
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        Contracts.throwIfFail(this.stopTranscribing(ConversationTranslator.this.translatorHandle));
                    }
                });
                return null;
            }
        });
    }

    public ConversationTranslator(AudioConfig audioConfig) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventCounter = atomicInteger;
        this.canceled = new EventHandlerImpl<>(atomicInteger);
        this.conversationExpiration = new EventHandlerImpl<>(this.eventCounter);
        this.participantsChanged = new EventHandlerImpl<>(this.eventCounter);
        this.sessionStarted = new EventHandlerImpl<>(this.eventCounter);
        this.sessionStopped = new EventHandlerImpl<>(this.eventCounter);
        this.textMessageReceived = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.translatorHandle = null;
        this.translatorLock = new Object();
        this.propertyHandle = null;
        this.disposed = false;
        this.activeAsyncRecognitionCounter = 0;
        this.audioInputKeepAlive = null;
        SafeHandle safeHandle = new SafeHandle(0L, SafeHandleType.ConversationTranslator);
        this.translatorHandle = safeHandle;
        this.audioInputKeepAlive = audioConfig;
        Contracts.throwIfFail(audioConfig == null ? createConversationTranslatorFromConfig(safeHandle, null) : createConversationTranslatorFromConfig(safeHandle, audioConfig.getImpl()));
        initialize();
    }

    public Future<Void> joinConversationAsync(final String str, final String str2, final String str3) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        ConversationTranslator conversationTranslator = this;
                        SafeHandle safeHandle = ConversationTranslator.this.translatorHandle;
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        Contracts.throwIfFail(conversationTranslator.joinConversationId(safeHandle, str, str2, str3));
                    }
                });
                return null;
            }
        });
    }
}
