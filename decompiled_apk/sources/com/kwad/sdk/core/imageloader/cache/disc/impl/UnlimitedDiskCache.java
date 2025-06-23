package com.kwad.sdk.core.imageloader.cache.disc.impl;

import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;

/* loaded from: classes11.dex */
public class UnlimitedDiskCache extends BaseDiskCache {
    public UnlimitedDiskCache(File file) {
        super(file);
    }

    public UnlimitedDiskCache(File file, File file2) {
        super(file, file2);
    }

    public UnlimitedDiskCache(File file, File file2, FileNameGenerator fileNameGenerator) {
        super(file, file2, fileNameGenerator);
    }
}
