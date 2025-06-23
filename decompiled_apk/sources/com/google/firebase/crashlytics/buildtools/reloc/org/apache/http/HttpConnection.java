package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes10.dex */
public interface HttpConnection extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    HttpConnectionMetrics getMetrics();

    int getSocketTimeout();

    boolean isOpen();

    boolean isStale();

    void setSocketTimeout(int i);

    void shutdown() throws IOException;
}
