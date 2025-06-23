package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public interface Cache {
    void append(byte[] bArr, int i) throws ProxyCacheException;

    long available() throws ProxyCacheException;

    void close() throws ProxyCacheException;

    void complete() throws ProxyCacheException;

    boolean isCompleted();

    int read(byte[] bArr, long j, int i) throws ProxyCacheException;
}
