package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class AutoCloseInputStream extends ProxyInputStream {
    public AutoCloseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input.ProxyInputStream
    public void afterRead(int i) throws IOException {
        if (i == -1) {
            close();
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterInputStream) this).in.close();
        ((FilterInputStream) this).in = new ClosedInputStream();
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
