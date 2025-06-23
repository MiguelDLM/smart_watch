package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* loaded from: classes10.dex */
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(@NullableDecl String str) {
        super(str);
    }

    public VerifyException(@NullableDecl Throwable th) {
        super(th);
    }

    public VerifyException(@NullableDecl String str, @NullableDecl Throwable th) {
        super(str, th);
    }
}
