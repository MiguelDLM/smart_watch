package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;

/* loaded from: classes11.dex */
public final class GrammarList extends Grammar implements AutoCloseable {
    private boolean disposed;

    private GrammarList(long j) {
        super(j);
        this.disposed = false;
    }

    private final native long add(SafeHandle safeHandle, SafeHandle safeHandle2);

    private void dispose(boolean z) {
        if (this.disposed) {
            return;
        }
        super.close();
        this.disposed = true;
    }

    private static final native long fromRecognizer(IntRef intRef, SafeHandle safeHandle);

    public static GrammarList fromRecognizer(Recognizer recognizer) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromRecognizer(intRef, recognizer.getImpl()));
        return new GrammarList(intRef.getValue());
    }

    public void add(Grammar grammar) {
        Contracts.throwIfFail(add(getImpl(), grammar.getImpl()));
    }

    @Override // com.microsoft.cognitiveservices.speech.Grammar, java.lang.AutoCloseable
    public void close() {
        dispose(true);
    }
}
