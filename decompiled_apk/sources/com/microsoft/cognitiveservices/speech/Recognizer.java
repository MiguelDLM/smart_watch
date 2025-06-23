package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.EventHandlerImpl;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public class Recognizer implements AutoCloseable {
    private int activeAsyncRecognitionCounter;
    private AudioConfig audioInputKeepAlive;
    protected boolean disposed;
    protected AtomicInteger eventCounter;
    private SafeHandle recoHandle;
    private final Object recognizerLock;
    public final EventHandlerImpl<SessionEventArgs> sessionStarted;
    public final EventHandlerImpl<SessionEventArgs> sessionStopped;
    public final EventHandlerImpl<RecognitionEventArgs> speechEndDetected;
    public final EventHandlerImpl<RecognitionEventArgs> speechStartDetected;

    public Recognizer(AudioConfig audioConfig) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventCounter = atomicInteger;
        this.sessionStarted = new EventHandlerImpl<>(atomicInteger);
        this.sessionStopped = new EventHandlerImpl<>(this.eventCounter);
        this.speechStartDetected = new EventHandlerImpl<>(this.eventCounter);
        this.speechEndDetected = new EventHandlerImpl<>(this.eventCounter);
        this.recoHandle = null;
        this.disposed = false;
        this.audioInputKeepAlive = null;
        this.recognizerLock = new Object();
        this.activeAsyncRecognitionCounter = 0;
        AsyncThreadService.initialize();
        this.recoHandle = new SafeHandle(0L, SafeHandleType.Recognizer);
        this.audioInputKeepAlive = audioConfig;
    }

    private final native long recognizeOnce(SafeHandle safeHandle, IntRef intRef);

    public final native long canceledSetCallback(long j);

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.recognizerLock) {
            try {
                if (this.activeAsyncRecognitionCounter != 0) {
                    throw new IllegalStateException("Cannot dispose a recognizer while async recognition is running. Await async recognitions to avoid unexpected disposals.");
                }
                dispose(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void dispose(boolean z) {
        if (this.disposed) {
            return;
        }
        SafeHandle safeHandle = this.recoHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.recoHandle = null;
        }
        AsyncThreadService.shutdown();
        this.audioInputKeepAlive = null;
        this.disposed = true;
    }

    public void doAsyncRecognitionAction(Runnable runnable) {
        synchronized (this.recognizerLock) {
            this.activeAsyncRecognitionCounter++;
        }
        if (this.disposed) {
            throw new IllegalStateException(getClass().getName());
        }
        try {
            runnable.run();
            synchronized (this.recognizerLock) {
                this.activeAsyncRecognitionCounter--;
            }
        } catch (Throwable th) {
            synchronized (this.recognizerLock) {
                this.activeAsyncRecognitionCounter--;
                throw th;
            }
        }
    }

    public SafeHandle getImpl() {
        return this.recoHandle;
    }

    public final native long getPropertyBagFromRecognizerHandle(SafeHandle safeHandle, IntRef intRef);

    public long recognize() {
        Contracts.throwIfNull(this.recoHandle, "Invalid recognizer handle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(recognizeOnce(this.recoHandle, intRef));
        return intRef.getValue();
    }

    public final native long recognizedSetCallback(long j);

    public final native long recognizingSetCallback(long j);

    public void sessionStartedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
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

    public final native long sessionStartedSetCallback(long j);

    public void sessionStoppedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
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

    public final native long sessionStoppedSetCallback(long j);

    public void speechEndDetectedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
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

    public final native long speechEndDetectedSetCallback(long j);

    public void speechStartDetectedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
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

    public final native long speechStartDetectedSetCallback(long j);

    public final native long startContinuousRecognition(SafeHandle safeHandle);

    public final native long startKeywordRecognition(SafeHandle safeHandle, SafeHandle safeHandle2);

    public final native long stopContinuousRecognition(SafeHandle safeHandle);

    public final native long stopKeywordRecognition(SafeHandle safeHandle);
}
