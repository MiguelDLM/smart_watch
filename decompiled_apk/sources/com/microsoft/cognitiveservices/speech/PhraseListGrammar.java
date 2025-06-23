package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;

/* loaded from: classes11.dex */
public final class PhraseListGrammar extends Grammar implements AutoCloseable {
    private boolean disposed;

    private PhraseListGrammar(long j) {
        super(j);
        this.disposed = false;
    }

    private final native long addPhrase(SafeHandle safeHandle, String str);

    private final native long clear(SafeHandle safeHandle);

    private void dispose(boolean z) {
        if (this.disposed) {
            return;
        }
        super.close();
        this.disposed = true;
    }

    private static final native long fromRecognizer(IntRef intRef, SafeHandle safeHandle);

    public static PhraseListGrammar fromRecognizer(Recognizer recognizer) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromRecognizer(intRef, recognizer.getImpl()));
        return new PhraseListGrammar(intRef.getValue());
    }

    public void addPhrase(String str) {
        Contracts.throwIfFail(addPhrase(getImpl(), str));
    }

    public void clear() {
        Contracts.throwIfFail(clear(getImpl()));
    }

    @Override // com.microsoft.cognitiveservices.speech.Grammar, java.lang.AutoCloseable
    public void close() {
        dispose(true);
    }
}
