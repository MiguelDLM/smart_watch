package com.alimm.tanx.core.view.player.cache.videocache.file;

import java.io.File;

/* loaded from: classes.dex */
public class TotalSizeLruDiskUsage extends LruDiskUsage {
    private final long maxSize;

    public TotalSizeLruDiskUsage(long j) {
        if (j > 0) {
            this.maxSize = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage
    public boolean accept(File file, long j, int i) {
        if (j <= this.maxSize) {
            return true;
        }
        return false;
    }
}
