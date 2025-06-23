package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class UnixLineEndingInputStream extends InputStream {
    private final boolean ensureLineFeedAtEndOfFile;
    private final InputStream target;
    private boolean slashNSeen = false;
    private boolean slashRSeen = false;
    private boolean eofSeen = false;

    public UnixLineEndingInputStream(InputStream inputStream, boolean z) {
        this.target = inputStream;
        this.ensureLineFeedAtEndOfFile = z;
    }

    private int eofGame(boolean z) {
        if (z || !this.ensureLineFeedAtEndOfFile || this.slashNSeen) {
            return -1;
        }
        this.slashNSeen = true;
        return 10;
    }

    private int readWithUpdate() throws IOException {
        boolean z;
        boolean z2;
        int read = this.target.read();
        boolean z3 = false;
        if (read == -1) {
            z = true;
        } else {
            z = false;
        }
        this.eofSeen = z;
        if (z) {
            return read;
        }
        if (read == 10) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.slashNSeen = z2;
        if (read == 13) {
            z3 = true;
        }
        this.slashRSeen = z3;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.target.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        throw new UnsupportedOperationException("Mark notsupported");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        boolean z = this.slashRSeen;
        if (this.eofSeen) {
            return eofGame(z);
        }
        int readWithUpdate = readWithUpdate();
        if (this.eofSeen) {
            return eofGame(z);
        }
        if (this.slashRSeen) {
            return 10;
        }
        if (z && this.slashNSeen) {
            return read();
        }
        return readWithUpdate;
    }
}
