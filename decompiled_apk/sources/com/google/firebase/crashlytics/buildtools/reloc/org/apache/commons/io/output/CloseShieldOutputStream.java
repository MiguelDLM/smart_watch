package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* loaded from: classes10.dex */
public class CloseShieldOutputStream extends ProxyOutputStream {
    public CloseShieldOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out = new ClosedOutputStream();
    }
}
