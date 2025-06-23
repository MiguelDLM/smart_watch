package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.execchain;

import java.io.InterruptedIOException;

/* loaded from: classes10.dex */
public class RequestAbortedException extends InterruptedIOException {
    private static final long serialVersionUID = 4973849966012490112L;

    public RequestAbortedException(String str) {
        super(str);
    }

    public RequestAbortedException(String str, Throwable th) {
        super(str);
        if (th != null) {
            initCause(th);
        }
    }
}
