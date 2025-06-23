package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn;

import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes10.dex */
public interface ClientConnectionRequest {
    void abortRequest();

    ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}
