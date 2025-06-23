package com.alimm.tanx.core.view.player.cache.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class ByteArrayCache implements Cache {
    private volatile boolean completed;
    private volatile byte[] data;

    public ByteArrayCache() {
        this(new byte[0]);
    }

    public void append(byte[] bArr, int i) throws ProxyCacheException {
        boolean z;
        Preconditions.checkNotNull(this.data);
        if (i < 0 || i > bArr.length) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        byte[] copyOf = Arrays.copyOf(this.data, this.data.length + i);
        System.arraycopy(bArr, 0, copyOf, this.data.length, i);
        this.data = copyOf;
    }

    public long available() throws ProxyCacheException {
        return (long) this.data.length;
    }

    public void close() throws ProxyCacheException {
    }

    public void complete() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public int read(byte[] bArr, long j, int i) throws ProxyCacheException {
        if (j >= ((long) this.data.length)) {
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
