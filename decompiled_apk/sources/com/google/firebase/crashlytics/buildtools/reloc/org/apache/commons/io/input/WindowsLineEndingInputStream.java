package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class WindowsLineEndingInputStream extends InputStream {
    private final boolean ensureLineFeedAtEndOfFile;
    private final InputStream target;
    private boolean slashRSeen = false;
    private boolean slashNSeen = false;
    private boolean injectSlashN = false;
    private boolean eofSeen = false;

    public WindowsLineEndingInputStream(InputStream inputStream, boolean z) {
        this.target = inputStream;
        this.ensureLineFeedAtEndOfFile = z;
    }

    private int eofGame() {
        if (!this.ensureLineFeedAtEndOfFile) {
            return -1;
        }
        boolean z = this.slashNSeen;
        if (!z && !this.slashRSeen) {
            this.slashRSeen = true;
            return 13;
        }
        if (z) {
            return -1;
        }
        this.slashRSeen = false;
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
        if (read == 13) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.slashRSeen = z2;
        if (read == 10) {
            z3 = true;
        }
        this.slashNSeen = z3;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.target.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        throw new UnsupportedOperationException("Mark not supported");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.eofSeen) {
            return eofGame();
        }
        if (this.injectSlashN) {
            this.injectSlashN = false;
            return 10;
        }
        boolean z = this.slashRSeen;
        int readWithUpdate = readWithUpdate();
        if (this.eofSeen) {
            return eofGame();
        }
        if (readWithUpdate == 10 && !z) {
            this.injectSlashN = true;
            return 13;
        }
        return readWithUpdate;
    }
}
