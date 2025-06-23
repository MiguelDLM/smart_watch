package com.baidu.navisdk.imageloader.config;

/* loaded from: classes7.dex */
public enum ImageDiskCacheStrategy {
    ALL(true, true),
    NONE(false, false),
    SOURCE(true, false),
    RESULT(false, true);

    private final boolean cacheResult;
    private final boolean cacheSource;

    ImageDiskCacheStrategy(boolean z, boolean z2) {
        this.cacheSource = z;
        this.cacheResult = z2;
    }

    public boolean cacheResult() {
        return this.cacheResult;
    }

    public boolean cacheSource() {
        return this.cacheSource;
    }
}
