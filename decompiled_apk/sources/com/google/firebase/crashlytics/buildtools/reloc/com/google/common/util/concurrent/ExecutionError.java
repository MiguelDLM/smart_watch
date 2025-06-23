package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* loaded from: classes10.dex */
public class ExecutionError extends Error {
    private static final long serialVersionUID = 0;

    public ExecutionError() {
    }

    public ExecutionError(@NullableDecl String str) {
        super(str);
    }

    public ExecutionError(@NullableDecl String str, @NullableDecl Error error) {
        super(str, error);
    }

    public ExecutionError(@NullableDecl Error error) {
        super(error);
    }
}
