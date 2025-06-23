package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public interface Source {
    void close() throws ProxyCacheException;

    long length() throws ProxyCacheException;

    void open(long j) throws ProxyCacheException;

    int read(byte[] bArr) throws ProxyCacheException;
}
