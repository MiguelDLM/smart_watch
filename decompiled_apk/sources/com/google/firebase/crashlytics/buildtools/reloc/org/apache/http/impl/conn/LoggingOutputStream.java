package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes10.dex */
class LoggingOutputStream extends OutputStream {
    private final OutputStream out;
    private final Wire wire;

    public LoggingOutputStream(OutputStream outputStream, Wire wire) {
        this.out = outputStream;
        this.wire = wire;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.out.close();
        } catch (IOException e) {
            this.wire.output("[close] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.out.flush();
        } catch (IOException e) {
            this.wire.output("[flush] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.wire.output(i);
        } catch (IOException e) {
            this.wire.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.wire.output(bArr);
            this.out.write(bArr);
        } catch (IOException e) {
            this.wire.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.wire.output(bArr, i, i2);
            this.out.write(bArr, i, i2);
        } catch (IOException e) {
            this.wire.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }
}
