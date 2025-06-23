package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class CloseShieldInputStream extends ProxyInputStream {
    public CloseShieldInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterInputStream) this).in = new ClosedInputStream();
    }
}
