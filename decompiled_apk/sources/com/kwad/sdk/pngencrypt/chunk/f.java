package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* loaded from: classes11.dex */
public final class f extends e {
    private final List<PngChunk> aNp;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + KV().size() + " queue: " + this.aNp.size();
    }
}
