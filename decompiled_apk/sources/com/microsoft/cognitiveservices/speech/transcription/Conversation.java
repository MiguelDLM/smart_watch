package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public final class Conversation implements AutoCloseable {
    private SafeHandle conversationHandle;
    private PropertyCollection propertyHandle;
    private boolean disposed = false;
    private final Object conversationLock = new Object();
    private int activeAsyncConversationCounter = 0;

    public Conversation(long j) {
        this.conversationHandle = new SafeHandle(j, SafeHandleType.Conversation);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBag(this.conversationHandle, intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long addParticipant(SafeHandle safeHandle, SafeHandle safeHandle2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long addParticipantByUser(SafeHandle safeHandle, SafeHandle safeHandle2);

    public static Future<Conversation> createConversationAsync(final SpeechConfig speechConfig) {
        Contracts.throwIfNull(speechConfig, "speechConfig");
        AsyncThreadService.initialize();
        return AsyncThreadService.submit(new Callable<Conversation>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Conversation call() {
                IntRef intRef = new IntRef(0L);
                Contracts.throwIfFail(Conversation.createConversationFromConfig(intRef, SpeechConfig.this.getImpl(), ""));
                return new Conversation(intRef.getValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final native long createConversationFromConfig(IntRef intRef, SafeHandle safeHandle, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long deleteConversation(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public void doAsyncConversationAction(Runnable runnable) {
        synchronized (this.conversationLock) {
            this.activeAsyncConversationCounter++;
        }
        if (this.disposed) {
            throw new IllegalStateException(Conversation.class.getName());
        }
        try {
            runnable.run();
            synchronized (this.conversationLock) {
                this.activeAsyncConversationCounter--;
            }
        } catch (Throwable th) {
            synchronized (this.conversationLock) {
                this.activeAsyncConversationCounter--;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long endConversation(SafeHandle safeHandle);

    private final native long getConversationId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getPropertyBag(SafeHandle safeHandle, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long lockConversation(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long muteAll(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long muteParticipant(SafeHandle safeHandle, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long removeParticipant(SafeHandle safeHandle, SafeHandle safeHandle2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long removeParticipantByUser(SafeHandle safeHandle, SafeHandle safeHandle2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long removeParticipantByUserId(SafeHandle safeHandle, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long startConversation(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long unlockConversation(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long unmuteAll(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long unmuteParticipant(SafeHandle safeHandle, String str);

    public Future<Participant> addParticipantAsync(final Participant participant) {
        return AsyncThreadService.submit(new Callable<Participant>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Participant call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.addParticipant(conversation.conversationHandle, participant.getImpl()));
                    }
                });
                return participant;
            }
        });
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.conversationLock) {
            try {
                if (this.activeAsyncConversationCounter != 0) {
                    throw new IllegalStateException("Cannot dispose a recognizer while async recognition is running. Await async recognitions to avoid unexpected disposals.");
                }
                dispose(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Future<Void> deleteConversationAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.11
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.deleteConversation(conversation.conversationHandle));
                    }
                });
                return null;
            }
        });
    }

    public void dispose(boolean z) {
        if (!this.disposed && z) {
            SafeHandle safeHandle = this.conversationHandle;
            if (safeHandle != null) {
                safeHandle.close();
                this.conversationHandle = null;
            }
            PropertyCollection propertyCollection = this.propertyHandle;
            if (propertyCollection != null) {
                propertyCollection.close();
                this.propertyHandle = null;
            }
            AsyncThreadService.shutdown();
            this.disposed = true;
        }
    }

    public Future<Void> endConversationAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.9
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.endConversation(conversation.conversationHandle));
                    }
                });
                return null;
            }
        });
    }

    public String getAuthorizationToken() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceAuthorization_Token);
    }

    public String getConversationId() {
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getConversationId(this.conversationHandle, stringRef));
        return stringRef.getValue();
    }

    public SafeHandle getImpl() {
        return this.conversationHandle;
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public Future<Void> lockConversationAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.12
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.lockConversation(conversation.conversationHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> muteAllParticipantsAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.14
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.muteAll(conversation.conversationHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> muteParticipantAsync(final String str) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.16
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.muteParticipant(conversation.conversationHandle, str));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> removeParticipantAsync(final Participant participant) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.7
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.removeParticipant(conversation.conversationHandle, participant.getImpl()));
                    }
                });
                return null;
            }
        });
    }

    public void setAuthorizationToken(String str) {
        Contracts.throwIfNullOrWhitespace(str, "token");
        this.propertyHandle.setProperty(PropertyId.SpeechServiceAuthorization_Token, str);
    }

    public Future<Void> startConversationAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.10
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.startConversation(conversation.conversationHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> unlockConversationAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.13
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.unlockConversation(conversation.conversationHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> unmuteAllParticipantsAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.15
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.unmuteAll(conversation.conversationHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> unmuteParticipantAsync(final String str) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.17
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.unmuteParticipant(conversation.conversationHandle, str));
                    }
                });
                return null;
            }
        });
    }

    public static Future<Conversation> createConversationAsync(final SpeechConfig speechConfig, final String str) {
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(str, "conversationId");
        AsyncThreadService.initialize();
        return AsyncThreadService.submit(new Callable<Conversation>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Conversation call() {
                IntRef intRef = new IntRef(0L);
                Contracts.throwIfFail(Conversation.createConversationFromConfig(intRef, SpeechConfig.this.getImpl(), str));
                return new Conversation(intRef.getValue());
            }
        });
    }

    public Future<User> addParticipantAsync(final User user) {
        return AsyncThreadService.submit(new Callable<User>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public User call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.addParticipantByUser(conversation.conversationHandle, user.getImpl()));
                    }
                });
                return user;
            }
        });
    }

    public Future<Void> removeParticipantAsync(final User user) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.6
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.removeParticipantByUser(conversation.conversationHandle, user.getImpl()));
                    }
                });
                return null;
            }
        });
    }

    public Future<Participant> addParticipantAsync(final String str) {
        return AsyncThreadService.submit(new Callable<Participant>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Participant call() {
                final Participant[] participantArr = new Participant[1];
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Participant from = Participant.from(str);
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.addParticipant(conversation.conversationHandle, from.getImpl()));
                        participantArr[0] = from;
                    }
                });
                return participantArr[0];
            }
        });
    }

    public Future<Void> removeParticipantAsync(final String str) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.8
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConversationAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Conversation.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Conversation conversation = Conversation.this;
                        Contracts.throwIfFail(conversation.removeParticipantByUserId(conversation.conversationHandle, str));
                    }
                });
                return null;
            }
        });
    }
}
