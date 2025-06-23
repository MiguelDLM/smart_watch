package org.apache.commons.lang3.concurrent;

/* loaded from: classes6.dex */
public class ConcurrentRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -6582182735562919670L;

    public ConcurrentRuntimeException() {
    }

    public ConcurrentRuntimeException(Throwable th) {
        super(xxIXOIIO.oIX0oI(th));
    }

    public ConcurrentRuntimeException(String str, Throwable th) {
        super(str, xxIXOIIO.oIX0oI(th));
    }
}
