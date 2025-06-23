package com.tenmeter.smlibrary.utils.videocache;

/* loaded from: classes13.dex */
public interface Cache {
    void append(byte[] bArr, int i) throws ProxyCacheException;

    long available() throws ProxyCacheException;

    void close() throws ProxyCacheException;

    void complete() throws ProxyCacheException;

    boolean isCompleted();

    int read(byte[] bArr, long j, int i) throws ProxyCacheException;
}
