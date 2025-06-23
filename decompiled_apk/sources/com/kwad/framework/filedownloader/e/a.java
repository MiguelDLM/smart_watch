package com.kwad.framework.filedownloader.e;

import java.io.Closeable;

/* loaded from: classes11.dex */
public interface a extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void seek(long j);

    void setLength(long j);

    void write(byte[] bArr, int i, int i2);

    void xm();
}
