package com.alimm.tanx.core.view.player.cache.videocache.file;

import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class LruDiskUsage implements DiskUsage {
    private static final Logger LOG = LoggerFactory.getLogger("LruDiskUsage");
    private final ExecutorService workerThread = Executors.newSingleThreadExecutor();

    public class TouchCallable implements Callable<Void> {
        private final File file;

        public TouchCallable(File file2) {
            this.file = file2;
        }

        public Void call() throws Exception {
            LruDiskUsage.this.touchInBackground(this.file);
            return null;
        }
    }

    private long countTotalSize(List<File> list) {
        long j = 0;
        for (File length : list) {
            j += length.length();
        }
        return j;
    }

    /* access modifiers changed from: private */
    public void touchInBackground(File file) throws IOException {
        Files.setLastModifiedNow(file);
        trim(Files.getLruListFiles(file.getParentFile()));
    }

    private void trim(List<File> list) {
        long countTotalSize = countTotalSize(list);
        int size = list.size();
        for (File next : list) {
            if (!accept(next, countTotalSize, size)) {
                long length = next.length();
                if (next.delete()) {
                    size--;
                    countTotalSize -= length;
                    LOG.info("Cache file " + next + " is deleted because it exceeds cache limit");
                } else {
                    LOG.error("Error deleting file " + next + " for trimming cache");
                }
            }
        }
    }

    public abstract boolean accept(File file, long j, int i);

    public void touch(File file) throws IOException {
        this.workerThread.submit(new TouchCallable(file));
    }
}
