package com.alimm.tanx.core.view.player.cache.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ByteArrayCache implements Cache {
    private volatile boolean completed;
    private volatile byte[] data;

    public ByteArrayCache() {
        this(new byte[0]);
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public void append(byte[] bArr, int i) throws ProxyCacheException {
        boolean z;
        Preconditions.checkNotNull(this.data);
        if (i >= 0 && i <= bArr.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        byte[] copyOf = Arrays.copyOf(this.data, this.data.length + i);
        System.arraycopy(bArr, 0, copyOf, this.data.length, i);
        this.data = copyOf;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public long available() throws ProxyCacheException {
        return this.data.length;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public void close() throws ProxyCacheException {
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public void complete() {
        this.completed = true;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public boolean isCompleted() {
        return this.completed;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public int read(byte[] bArr, long j, int i) throws ProxyCacheException {
        if (j >= this.data.length) {
            return -1;
        }
        if (j <= 2147483647L) {
            return new ByteArrayInputStream(this.data).read(bArr, (int) j, i);
        }
        throw new IllegalArgumentException("Too long offset for memory cache " + j);
    }

    public ByteArrayCache(byte[] bArr) {
        this.data = (byte[]) Preconditions.checkNotNull(bArr);
    }
}
