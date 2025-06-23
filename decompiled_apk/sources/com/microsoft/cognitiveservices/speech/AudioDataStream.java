package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.sma.smartv3.network.AICreateJobV2;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public final class AudioDataStream implements AutoCloseable {
    private PropertyCollection propertyHandle;
    private SafeHandle streamHandle;
    private boolean disposed = false;
    private final Object streamLock = new Object();
    private int activeAsyncActionCounter = 0;

    private AudioDataStream(IntRef intRef) {
        this.streamHandle = null;
        Contracts.throwIfNull(intRef, AICreateJobV2.AI_Stream);
        AsyncThreadService.initialize();
        this.streamHandle = new SafeHandle(intRef.getValue(), SafeHandleType.AudioDataStream);
        IntRef intRef2 = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromStreamHandle(this.streamHandle, intRef2));
        this.propertyHandle = new PropertyCollection(intRef2);
    }

    private final native boolean canReadData(SafeHandle safeHandle, long j);

    private final native boolean canReadData(SafeHandle safeHandle, long j, long j2);

    private static final native long createFromKeywordResult(IntRef intRef, SafeHandle safeHandle);

    private static final native long createFromResult(IntRef intRef, SafeHandle safeHandle);

    private final native long detachInput(SafeHandle safeHandle);

    private void dispose(boolean z) {
        if (!this.disposed && z) {
            SafeHandle safeHandle = this.streamHandle;
            if (safeHandle != null) {
                safeHandle.close();
                this.streamHandle = null;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void doAsyncAction(Runnable runnable) {
        synchronized (this.streamLock) {
            this.activeAsyncActionCounter++;
        }
        if (this.disposed) {
            throw new IllegalStateException(AudioDataStream.class.getName());
        }
        try {
            runnable.run();
            synchronized (this.streamLock) {
                this.activeAsyncActionCounter--;
            }
        } catch (Throwable th) {
            synchronized (this.streamLock) {
                this.activeAsyncActionCounter--;
                throw th;
            }
        }
    }

    public static AudioDataStream fromResult(KeywordRecognitionResult keywordRecognitionResult) {
        Contracts.throwIfNull(keywordRecognitionResult, "result");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createFromKeywordResult(intRef, keywordRecognitionResult.getImpl()));
        return new AudioDataStream(intRef);
    }

    private final native long getPosition(SafeHandle safeHandle, IntRef intRef);

    private final native long getPropertyBagFromStreamHandle(SafeHandle safeHandle, IntRef intRef);

    private final native long getStatus(SafeHandle safeHandle, IntRef intRef);

    private final native long readData(SafeHandle safeHandle, byte[] bArr, long j, IntRef intRef);

    private final native long readData(SafeHandle safeHandle, byte[] bArr, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long saveToWaveFile(SafeHandle safeHandle, String str);

    private final native long setPosition(SafeHandle safeHandle, long j);

    public boolean canReadData(long j) {
        return canReadData(this.streamHandle, j);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.streamLock) {
            try {
                if (this.activeAsyncActionCounter != 0) {
                    throw new IllegalStateException("Cannot dispose an audio data stream while async saving to wave file is running. Await async operation to avoid unexpected disposals.");
                }
                dispose(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void detachInput() {
        Contracts.throwIfFail(detachInput(this.streamHandle));
    }

    public SafeHandle getImpl() {
        return this.streamHandle;
    }

    public long getPosition() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPosition(this.streamHandle, intRef));
        return intRef.getValue();
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public StreamStatus getStatus() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getStatus(this.streamHandle, intRef));
        return StreamStatus.values()[(int) intRef.getValue()];
    }

    public long readData(long j, byte[] bArr) {
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(readData(this.streamHandle, bArr, j, intRef));
        return intRef.getValue();
    }

    public void saveToWavFile(String str) {
        Contracts.throwIfFail(saveToWaveFile(this.streamHandle, str));
    }

    public Future<Void> saveToWavFileAsync(final String str) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.AudioDataStream.1
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.AudioDataStream.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        Contracts.throwIfFail(AudioDataStream.this.saveToWaveFile(this.streamHandle, str));
                    }
                });
                return null;
            }
        });
    }

    public void setPosition(long j) {
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        Contracts.throwIfFail(setPosition(this.streamHandle, j));
    }

    public static AudioDataStream fromResult(SpeechSynthesisResult speechSynthesisResult) {
        Contracts.throwIfNull(speechSynthesisResult, "result");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createFromResult(intRef, speechSynthesisResult.getImpl()));
        return new AudioDataStream(intRef);
    }

    public boolean canReadData(long j, long j2) {
        if (j >= 0) {
            return canReadData(this.streamHandle, j, j2);
        }
        throw new IndexOutOfBoundsException();
    }

    public long readData(byte[] bArr) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(readData(this.streamHandle, bArr, intRef));
        return intRef.getValue();
    }
}
