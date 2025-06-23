package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;

/* loaded from: classes9.dex */
public final class ChunkHolder {

    @Nullable
    public Chunk chunk;
    public boolean endOfStream;

    public void clear() {
        this.chunk = null;
        this.endOfStream = false;
    }
}
