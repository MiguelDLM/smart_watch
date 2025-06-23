package com.tenmeter.smlibrary.utils.videocache;

import com.tenmeter.smlibrary.utils.videocache.file.DiskUsage;
import com.tenmeter.smlibrary.utils.videocache.file.FileNameGenerator;
import com.tenmeter.smlibrary.utils.videocache.headers.HeaderInjector;
import com.tenmeter.smlibrary.utils.videocache.sourcestorage.SourceInfoStorage;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class Config {
    public final File cacheRoot;
    public final DiskUsage diskUsage;
    public final FileNameGenerator fileNameGenerator;
    public final HeaderInjector headerInjector;
    public final SourceInfoStorage sourceInfoStorage;

    public Config(File file, FileNameGenerator fileNameGenerator, DiskUsage diskUsage, SourceInfoStorage sourceInfoStorage, HeaderInjector headerInjector) {
        this.cacheRoot = file;
        this.fileNameGenerator = fileNameGenerator;
        this.diskUsage = diskUsage;
        this.sourceInfoStorage = sourceInfoStorage;
        this.headerInjector = headerInjector;
    }

    public File generateCacheFile(String str) {
        return new File(this.cacheRoot, this.fileNameGenerator.generate(str));
    }
}
