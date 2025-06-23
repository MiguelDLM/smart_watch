package com.microsoft.cognitiveservices.speech.dialog;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.microsoft.cognitiveservices.speech.KeywordRecognitionModel;
import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.RecognitionEventArgs;
import com.microsoft.cognitiveservices.speech.SessionEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionCanceledEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.EventHandlerImpl;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public class DialogServiceConnector implements AutoCloseable {
    static Class<?> dialogServiceConnector;
    static Set<DialogServiceConnector> dialogServiceConnectorObjects;
    public EventHandlerImpl<ActivityReceivedEventArgs> activityReceived;
    private AudioConfig audioInputKeepAlive;
    public EventHandlerImpl<SpeechRecognitionCanceledEventArgs> canceled;
    private SafeHandle dialogServiceConnectorHandle;
    private boolean disposed;
    private AtomicInteger eventCounter;
    private PropertyCollection propertyHandle;
    public EventHandlerImpl<SpeechRecognitionEventArgs> recognized;
    public EventHandlerImpl<SpeechRecognitionEventArgs> recognizing;
    public EventHandlerImpl<SessionEventArgs> sessionStarted;
    public EventHandlerImpl<SessionEventArgs> sessionStopped;
    public EventHandlerImpl<RecognitionEventArgs> speechEndDetected;
    public EventHandlerImpl<RecognitionEventArgs> speechStartDetected;
    public EventHandlerImpl<TurnStatusReceivedEventArgs> turnStatusReceived;

    /* loaded from: classes11.dex */
    public class DialogSpeechRecognitionResult extends SpeechRecognitionResult {
        public DialogSpeechRecognitionResult(long j) {
            super(j);
        }
    }

    static {
        try {
            Class.forName(DialogServiceConfig.class.getName());
            dialogServiceConnector = DialogServiceConnector.class;
            dialogServiceConnectorObjects = Collections.synchronizedSet(new HashSet());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public DialogServiceConnector(DialogServiceConfig dialogServiceConfig) {
        this(dialogServiceConfig, AudioConfig.fromDefaultMicrophoneInput());
    }

    private void activityReceivedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "connector");
            if (this.disposed) {
                return;
            }
            ActivityReceivedEventArgs activityReceivedEventArgs = new ActivityReceivedEventArgs(j);
            EventHandlerImpl<ActivityReceivedEventArgs> eventHandlerImpl = this.activityReceived;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, activityReceivedEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long activityReceivedSetCallback(long j);

    private void canceledEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "connector");
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

    /* JADX INFO: Access modifiers changed from: private */
    public final native long connect(SafeHandle safeHandle);

    private static final native long createDialogServiceConnectorFomConfig(SafeHandle safeHandle, SafeHandle safeHandle2, SafeHandle safeHandle3);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long disconnect(SafeHandle safeHandle);

    private void dispose(boolean z) {
        if (!this.disposed && z) {
            PropertyCollection propertyCollection = this.propertyHandle;
            if (propertyCollection != null) {
                propertyCollection.close();
                this.propertyHandle = null;
            }
            SafeHandle safeHandle = this.dialogServiceConnectorHandle;
            if (safeHandle != null) {
                safeHandle.close();
                this.dialogServiceConnectorHandle = null;
            }
            this.audioInputKeepAlive = null;
            dialogServiceConnectorObjects.remove(this);
            AsyncThreadService.shutdown();
            this.disposed = true;
        }
    }

    private final native long getPropertyBagFromDialogServiceConnectorHandle(SafeHandle safeHandle, IntRef intRef);

    private void initialize() {
        AsyncThreadService.initialize();
        this.recognizing.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.8
            @Override // java.lang.Runnable
            public void run() {
                DialogServiceConnector.dialogServiceConnectorObjects.add(this);
                Contracts.throwIfFail(DialogServiceConnector.this.recognizingSetCallback(this.dialogServiceConnectorHandle.getValue()));
            }
        });
        this.recognized.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.9
            @Override // java.lang.Runnable
            public void run() {
                DialogServiceConnector.dialogServiceConnectorObjects.add(this);
                Contracts.throwIfFail(DialogServiceConnector.this.recognizedSetCallback(this.dialogServiceConnectorHandle.getValue()));
            }
        });
        this.sessionStarted.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.10
            @Override // java.lang.Runnable
            public void run() {
                DialogServiceConnector.dialogServiceConnectorObjects.add(this);
                Contracts.throwIfFail(DialogServiceConnector.this.sessionStartedSetCallback(this.dialogServiceConnectorHandle.getValue()));
            }
        });
        this.sessionStopped.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.11
            @Override // java.lang.Runnable
            public void run() {
                DialogServiceConnector.dialogServiceConnectorObjects.add(this);
                Contracts.throwIfFail(DialogServiceConnector.this.sessionStoppedSetCallback(this.dialogServiceConnectorHandle.getValue()));
            }
        });
        this.speechStartDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.12
            @Override // java.lang.Runnable
            public void run() {
                DialogServiceConnector.dialogServiceConnectorObjects.add(this);
                Contracts.throwIfFail(DialogServiceConnector.this.speechStartDetectedSetCallback(this.dialogServiceConnectorHandle.getValue()));
            }
        });
        this.speechEndDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.13
            @Override // java.lang.Runnable
            public void run() {
                DialogServiceConnector.dialogServiceConnectorObjects.add(this);
                Contracts.throwIfFail(DialogServiceConnector.this.speechEndDetectedSetCallback(this.dialogServiceConnectorHandle.getValue()));
            }
        });
        this.canceled.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.14
            @Override // java.lang.Runnable
            public void run() {
                DialogServiceConnector.dialogServiceConnectorObjects.add(this);
                Contracts.throwIfFail(DialogServiceConnector.this.canceledSetCallback(this.dialogServiceConnectorHandle.getValue()));
            }
        });
        this.activityReceived.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.15
            @Override // java.lang.Runnable
            public void run() {
                DialogServiceConnector.dialogServiceConnectorObjects.add(this);
                Contracts.throwIfFail(DialogServiceConnector.this.activityReceivedSetCallback(this.dialogServiceConnectorHandle.getValue()));
            }
        });
        this.turnStatusReceived.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.16
            @Override // java.lang.Runnable
            public void run() {
                DialogServiceConnector.dialogServiceConnectorObjects.add(this);
                Contracts.throwIfFail(DialogServiceConnector.this.turnStatusReceivedSetCallback(this.dialogServiceConnectorHandle.getValue()));
            }
        });
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromDialogServiceConnectorHandle(this.dialogServiceConnectorHandle, intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long listenOnce(SafeHandle safeHandle, IntRef intRef);

    private void recognizedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "connector");
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

    /* JADX INFO: Access modifiers changed from: private */
    public final native long recognizedSetCallback(long j);

    private void recognizingEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "connector");
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

    /* JADX INFO: Access modifiers changed from: private */
    public final native long recognizingSetCallback(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long sendActivity(SafeHandle safeHandle, StringRef stringRef, String str);

    private void sessionStartedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "connector");
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
            Contracts.throwIfNull(this, "connector");
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

    private void speechEndDetectedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "connector");
            if (this.disposed) {
                return;
            }
            RecognitionEventArgs recognitionEventArgs = new RecognitionEventArgs(j, true);
            EventHandlerImpl<RecognitionEventArgs> eventHandlerImpl = this.speechEndDetected;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, recognitionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long speechEndDetectedSetCallback(long j);

    private void speechStartDetectedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "connector");
            if (this.disposed) {
                return;
            }
            RecognitionEventArgs recognitionEventArgs = new RecognitionEventArgs(j, true);
            EventHandlerImpl<RecognitionEventArgs> eventHandlerImpl = this.speechStartDetected;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, recognitionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long speechStartDetectedSetCallback(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long startKeywordRecognition(SafeHandle safeHandle, SafeHandle safeHandle2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long stopKeywordRecognition(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long stopListening(SafeHandle safeHandle);

    private void turnStatusReceivedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "connector");
            if (this.disposed) {
                return;
            }
            TurnStatusReceivedEventArgs turnStatusReceivedEventArgs = new TurnStatusReceivedEventArgs(j);
            EventHandlerImpl<TurnStatusReceivedEventArgs> eventHandlerImpl = this.turnStatusReceived;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, turnStatusReceivedEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long turnStatusReceivedSetCallback(long j);

    @Override // java.lang.AutoCloseable
    public void close() {
        dispose(true);
    }

    public Future<Void> connectAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.1
            @Override // java.util.concurrent.Callable
            public Void call() {
                DialogServiceConnector dialogServiceConnector2 = DialogServiceConnector.this;
                Contracts.throwIfFail(dialogServiceConnector2.connect(dialogServiceConnector2.dialogServiceConnectorHandle));
                return null;
            }
        });
    }

    public Future<Void> disconnectAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                DialogServiceConnector dialogServiceConnector2 = DialogServiceConnector.this;
                Contracts.throwIfFail(dialogServiceConnector2.disconnect(dialogServiceConnector2.dialogServiceConnectorHandle));
                return null;
            }
        });
    }

    public String getAuthorizationToken() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceAuthorization_Token);
    }

    public SafeHandle getImpl() {
        return this.dialogServiceConnectorHandle;
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public Future<SpeechRecognitionResult> listenOnceAsync() {
        return AsyncThreadService.submit(new Callable<SpeechRecognitionResult>() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public SpeechRecognitionResult call() {
                IntRef intRef = new IntRef(0L);
                DialogServiceConnector dialogServiceConnector2 = DialogServiceConnector.this;
                Contracts.throwIfFail(dialogServiceConnector2.listenOnce(dialogServiceConnector2.dialogServiceConnectorHandle, intRef));
                return new DialogSpeechRecognitionResult(intRef.getValue());
            }
        });
    }

    public Future<String> sendActivityAsync(final String str) {
        Contracts.throwIfNull(str, TTDownloadField.TT_ACTIVITY);
        return AsyncThreadService.submit(new Callable<String>() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.3
            @Override // java.util.concurrent.Callable
            public String call() {
                StringRef stringRef = new StringRef("");
                DialogServiceConnector dialogServiceConnector2 = DialogServiceConnector.this;
                Contracts.throwIfFail(dialogServiceConnector2.sendActivity(dialogServiceConnector2.dialogServiceConnectorHandle, stringRef, str));
                return stringRef.getValue();
            }
        });
    }

    public void setAuthorizationToken(String str) {
        Contracts.throwIfNullOrWhitespace(str, "token");
        this.propertyHandle.setProperty(PropertyId.SpeechServiceAuthorization_Token, str);
    }

    public void setSpeechActivityTemplate(String str) {
        Contracts.throwIfNullOrWhitespace(str, SDKConstants.PARAM_UPDATE_TEMPLATE);
        this.propertyHandle.setProperty(PropertyId.Conversation_Speech_Activity_Template, str);
    }

    public Future<Void> startKeywordRecognitionAsync(final KeywordRecognitionModel keywordRecognitionModel) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.6
            @Override // java.util.concurrent.Callable
            public Void call() {
                DialogServiceConnector dialogServiceConnector2 = DialogServiceConnector.this;
                Contracts.throwIfFail(dialogServiceConnector2.startKeywordRecognition(dialogServiceConnector2.dialogServiceConnectorHandle, keywordRecognitionModel.getImpl()));
                return null;
            }
        });
    }

    public Future<Void> stopKeywordRecognitionAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.7
            @Override // java.util.concurrent.Callable
            public Void call() {
                DialogServiceConnector dialogServiceConnector2 = DialogServiceConnector.this;
                Contracts.throwIfFail(dialogServiceConnector2.stopKeywordRecognition(dialogServiceConnector2.dialogServiceConnectorHandle));
                return null;
            }
        });
    }

    public Future<Void> stopListeningAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector.5
            @Override // java.util.concurrent.Callable
            public Void call() {
                DialogServiceConnector dialogServiceConnector2 = this;
                Contracts.throwIfFail(dialogServiceConnector2.stopListening(dialogServiceConnector2.dialogServiceConnectorHandle));
                return null;
            }
        });
    }

    public DialogServiceConnector(DialogServiceConfig dialogServiceConfig, AudioConfig audioConfig) {
        long createDialogServiceConnectorFomConfig;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventCounter = atomicInteger;
        this.audioInputKeepAlive = null;
        this.recognizing = new EventHandlerImpl<>(atomicInteger);
        this.recognized = new EventHandlerImpl<>(this.eventCounter);
        this.sessionStarted = new EventHandlerImpl<>(this.eventCounter);
        this.sessionStopped = new EventHandlerImpl<>(this.eventCounter);
        this.speechStartDetected = new EventHandlerImpl<>(this.eventCounter);
        this.speechEndDetected = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.activityReceived = new EventHandlerImpl<>(this.eventCounter);
        this.turnStatusReceived = new EventHandlerImpl<>(this.eventCounter);
        this.dialogServiceConnectorHandle = null;
        this.disposed = false;
        Contracts.throwIfNull(dialogServiceConfig, "config");
        if (audioConfig == null) {
            SafeHandle safeHandle = new SafeHandle(0L, SafeHandleType.DialogServiceConnector);
            this.dialogServiceConnectorHandle = safeHandle;
            createDialogServiceConnectorFomConfig = createDialogServiceConnectorFomConfig(safeHandle, dialogServiceConfig.getImpl(), null);
        } else {
            SafeHandle safeHandle2 = new SafeHandle(0L, SafeHandleType.DialogServiceConnector);
            this.dialogServiceConnectorHandle = safeHandle2;
            createDialogServiceConnectorFomConfig = createDialogServiceConnectorFomConfig(safeHandle2, dialogServiceConfig.getImpl(), audioConfig.getImpl());
        }
        Contracts.throwIfFail(createDialogServiceConnectorFomConfig);
        this.audioInputKeepAlive = audioConfig;
        initialize();
    }
}
