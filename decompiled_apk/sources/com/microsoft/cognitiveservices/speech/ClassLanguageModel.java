package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;

/* loaded from: classes11.dex */
public final class ClassLanguageModel extends Grammar implements AutoCloseable {
    private ClassLanguageModel(long j) {
        super(j);
    }

    private final native long assignClass(SafeHandle safeHandle, String str, SafeHandle safeHandle2);

    private static final native long fromStorageId(IntRef intRef, String str);

    public static ClassLanguageModel fromStorageId(String str) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromStorageId(intRef, str));
        return new ClassLanguageModel(intRef.getValue());
    }

    public void assignClass(String str, Grammar grammar) {
        Contracts.throwIfFail(assignClass(getImpl(), str, grammar.getImpl()));
    }
}
