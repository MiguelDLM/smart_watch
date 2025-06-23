package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes10.dex */
public interface HttpEntity {
    @Deprecated
    void consumeContent() throws IOException;

    InputStream getContent() throws IOException, UnsupportedOperationException;

    Header getContentEncoding();

    long getContentLength();

    Header getContentType();

    boolean isChunked();

    boolean isRepeatable();

    boolean isStreaming();

    void writeTo(OutputStream outputStream) throws IOException;
}
