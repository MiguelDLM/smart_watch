package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes11.dex */
public final class b implements com.kwad.sdk.core.videocache.a {
    private final a aCV;
    private RandomAccessFile aDM;
    public File file;

    public b(File file, a aVar) {
        File file2;
        String str;
        try {
            if (aVar != null) {
                this.aCV = aVar;
                d.u(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    file2 = new File(file.getParentFile(), file.getName() + ".download");
                }
                this.file = file2;
                File file3 = this.file;
                if (exists) {
                    str = "r";
                } else {
                    str = "rw";
                }
                this.aDM = new RandomAccessFile(file3, str);
                return;
            }
            throw new NullPointerException();
        } catch (IOException e) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e);
        }
    }

    private static boolean t(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized long GY() {
        try {
        } catch (IOException e) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e);
        }
        return (int) this.aDM.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.aDM.seek(j);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(GY()), Integer.valueOf(bArr.length)), e);
        }
        return this.aDM.read(bArr, 0, i);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void close() {
        try {
            this.aDM.close();
            this.aCV.s(this.file);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.file, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void complete() {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (this.file.renameTo(file)) {
            this.file = file;
            try {
                this.aDM = new RandomAccessFile(this.file, "r");
                this.aCV.s(this.file);
                return;
            } catch (IOException e) {
                throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e);
            }
        }
        throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void d(byte[] bArr, int i) {
        try {
            if (!isCompleted()) {
                this.aDM.seek(GY());
                this.aDM.write(bArr, 0, i);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.aDM, 1024), e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized boolean isCompleted() {
        if (!t(this.file)) {
            return true;
        }
        return false;
    }
}
