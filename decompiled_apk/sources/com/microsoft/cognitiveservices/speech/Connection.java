package com.microsoft.cognitiveservices.speech;

import IoxX.I0Io;
import com.microsoft.cognitiveservices.speech.dialog.DialogServiceConnector;
import com.microsoft.cognitiveservices.speech.transcription.ConversationTranslator;
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
public final class Connection implements AutoCloseable {
    static Set<Connection> _connectionObjects = Collections.synchronizedSet(new HashSet());
    private int activeAsyncConnectionCounter;
    public final EventHandlerImpl<ConnectionEventArgs> connected;
    private SafeHandle connectionHandle;
    private final Object connectionLock;
    public final EventHandlerImpl<ConnectionEventArgs> disconnected;
    private boolean disposed;
    private AtomicInteger eventCounter;
    public final EventHandlerImpl<ConnectionMessageEventArgs> messageReceived;

    private Connection(IntRef intRef) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventCounter = atomicInteger;
        this.connected = new EventHandlerImpl<>(atomicInteger);
        this.disconnected = new EventHandlerImpl<>(this.eventCounter);
        this.messageReceived = new EventHandlerImpl<>(this.eventCounter);
        this.disposed = false;
        this.connectionLock = new Object();
        this.activeAsyncConnectionCounter = 0;
        Contracts.throwIfNull(intRef, "Connection");
        this.connectionHandle = new SafeHandle(intRef.getValue(), SafeHandleType.Connection);
        initialize();
    }

    private final native long closeConnection(SafeHandle safeHandle);

    private void connectedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, I0Io.f853ooOOo0oXI);
            if (this.disposed) {
                return;
            }
            ConnectionEventArgs connectionEventArgs = new ConnectionEventArgs(j, true);
            EventHandlerImpl<ConnectionEventArgs> eventHandlerImpl = this.connected;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, connectionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long connectionConnectedSetCallback(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long connectionDisconnectedSetCallback(long j);

    private static final native long connectionFromConversationTranslator(SafeHandle safeHandle, IntRef intRef);

    private static final native long connectionFromDialogServiceConnector(SafeHandle safeHandle, IntRef intRef);

    private static final native long connectionFromRecognizer(SafeHandle safeHandle, IntRef intRef);

    private static final native long connectionFromSpeechSynthesizer(SafeHandle safeHandle, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long connectionMessageReceivedSetCallback(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long connectionSendMessage(SafeHandle safeHandle, String str, String str2);

    private final native long connectionSetMessageProperty(SafeHandle safeHandle, String str, String str2, String str3);

    private void disconnectedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, I0Io.f853ooOOo0oXI);
            if (this.disposed) {
                return;
            }
            ConnectionEventArgs connectionEventArgs = new ConnectionEventArgs(j, true);
            EventHandlerImpl<ConnectionEventArgs> eventHandlerImpl = this.disconnected;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, connectionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    private void dispose(boolean z) {
        if (!this.disposed && z) {
            SafeHandle safeHandle = this.connectionHandle;
            if (safeHandle != null) {
                safeHandle.close();
                this.connectionHandle = null;
            }
            _connectionObjects.remove(this);
            AsyncThreadService.shutdown();
            this.disposed = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAsyncConnectionAction(Runnable runnable) {
        synchronized (this.connectionLock) {
            this.activeAsyncConnectionCounter++;
        }
        if (this.disposed) {
            throw new IllegalStateException(Connection.class.getName());
        }
        try {
            runnable.run();
            synchronized (this.connectionLock) {
                this.activeAsyncConnectionCounter--;
            }
        } catch (Throwable th) {
            synchronized (this.connectionLock) {
                this.activeAsyncConnectionCounter--;
                throw th;
            }
        }
    }

    public static Connection fromConversationTranslator(ConversationTranslator conversationTranslator) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(connectionFromConversationTranslator(conversationTranslator.getImpl(), intRef));
        return new Connection(intRef);
    }

    public static Connection fromDialogServiceConnector(DialogServiceConnector dialogServiceConnector) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(connectionFromDialogServiceConnector(dialogServiceConnector.getImpl(), intRef));
        return new Connection(intRef);
    }

    public static Connection fromRecognizer(Recognizer recognizer) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(connectionFromRecognizer(recognizer.getImpl(), intRef));
        return new Connection(intRef);
    }

    public static Connection fromSpeechSynthesizer(SpeechSynthesizer speechSynthesizer) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(connectionFromSpeechSynthesizer(speechSynthesizer.getImpl(), intRef));
        return new Connection(intRef);
    }

    private void initialize() {
        AsyncThreadService.initialize();
        this.connected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.Connection.2
            @Override // java.lang.Runnable
            public void run() {
                Connection._connectionObjects.add(this);
                Connection connection = Connection.this;
                connection.connectionConnectedSetCallback(connection.connectionHandle.getValue());
            }
        });
        this.disconnected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.Connection.3
            @Override // java.lang.Runnable
            public void run() {
                Connection._connectionObjects.add(this);
                Connection connection = Connection.this;
                connection.connectionDisconnectedSetCallback(connection.connectionHandle.getValue());
            }
        });
        this.messageReceived.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.Connection.4
            @Override // java.lang.Runnable
            public void run() {
                Connection._connectionObjects.add(this);
                Connection connection = Connection.this;
                connection.connectionMessageReceivedSetCallback(connection.connectionHandle.getValue());
            }
        });
    }

    private void messageReceivedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, I0Io.f853ooOOo0oXI);
            if (this.disposed) {
                return;
            }
            ConnectionMessageEventArgs connectionMessageEventArgs = new ConnectionMessageEventArgs(j);
            EventHandlerImpl<ConnectionMessageEventArgs> eventHandlerImpl = this.messageReceived;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, connectionMessageEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    private final native long openConnection(SafeHandle safeHandle, boolean z);

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.connectionLock) {
            try {
                if (this.activeAsyncConnectionCounter != 0) {
                    throw new IllegalStateException("Cannot dispose a connection while async method is running. Await async method to avoid unexpected disposals.");
                }
                dispose(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void closeConnection() {
        Contracts.throwIfFail(closeConnection(this.connectionHandle));
    }

    public void openConnection(boolean z) {
        Contracts.throwIfFail(openConnection(this.connectionHandle, z));
    }

    public Future<Void> sendMessageAsync(final String str, final String str2) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.Connection.1
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncConnectionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.Connection.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Connection connection = Connection.this;
                        SafeHandle safeHandle = connection.connectionHandle;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        Contracts.throwIfFail(connection.connectionSendMessage(safeHandle, str, str2));
                    }
                });
                return null;
            }
        });
    }

    public void setMessageProperty(String str, String str2, String str3) {
        Contracts.throwIfFail(connectionSetMessageProperty(this.connectionHandle, str, str2, str3));
    }
}
