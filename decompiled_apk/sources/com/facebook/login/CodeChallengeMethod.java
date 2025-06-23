package com.facebook.login;

import java.util.Arrays;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public enum CodeChallengeMethod {
    S256("S256"),
    PLAIN("plain");

    CodeChallengeMethod(String str) {
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static CodeChallengeMethod[] valuesCustom() {
        CodeChallengeMethod[] valuesCustom = values();
        return (CodeChallengeMethod[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    /* synthetic */ CodeChallengeMethod(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "S256" : str);
    }
}
