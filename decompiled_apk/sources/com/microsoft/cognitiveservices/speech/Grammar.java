package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public class Grammar implements AutoCloseable {
    private boolean disposed = false;
    private SafeHandle grammarHandle;

    public Grammar(long j) {
        this.grammarHandle = null;
        Contracts.throwIfNull(j, "grammarHandleValue");
        this.grammarHandle = new SafeHandle(j, SafeHandleType.Grammar);
    }

    private void dispose(boolean z) {
        SafeHandle safeHandle;
        if (this.disposed) {
            return;
        }
        if (z && (safeHandle = this.grammarHandle) != null) {
            safeHandle.close();
            this.grammarHandle = null;
        }
        this.disposed = true;
    }

    private static final native long fromStorageId(IntRef intRef, String str);

    public static Grammar fromStorageId(String str) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromStorageId(intRef, str));
        return new Grammar(intRef.getValue());
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        dispose(true);
    }

    public SafeHandle getImpl() {
        return this.grammarHandle;
    }
}
