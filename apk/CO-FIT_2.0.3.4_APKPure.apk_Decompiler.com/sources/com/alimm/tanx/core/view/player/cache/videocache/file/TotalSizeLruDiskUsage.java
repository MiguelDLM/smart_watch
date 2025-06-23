package com.alimm.tanx.core.view.player.cache.videocache.file;

import java.io.File;

public class TotalSizeLruDiskUsage extends LruDiskUsage {
    private final long maxSize;

    public TotalSizeLruDiskUsage(long j) {
        if (j > 0) {
            this.maxSize = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    public boolean accept(File file, long j, int i) {
        if (j <= this.maxSize) {
            return true;
        }
        return false;
    }
}
