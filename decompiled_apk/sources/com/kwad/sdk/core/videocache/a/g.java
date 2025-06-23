package com.kwad.sdk.core.videocache.a;

/* loaded from: classes11.dex */
public final class g extends e {
    private final long maxSize;

    public g(long j) {
        if (j > 0) {
            this.maxSize = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.kwad.sdk.core.videocache.a.e
    public final boolean aB(long j) {
        if (j <= this.maxSize) {
            return true;
        }
        return false;
    }
}
