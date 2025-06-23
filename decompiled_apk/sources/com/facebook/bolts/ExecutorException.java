package com.facebook.bolts;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class ExecutorException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutorException(@OXOo.OOXIXo Exception e) {
        super("An exception was thrown by an Executor", e);
        IIX0o.x0xO0oo(e, "e");
    }
}
