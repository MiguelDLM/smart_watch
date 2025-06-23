package com.alimm.tanx.core.view.player.cache.videocache.file;

import java.io.File;
import java.io.IOException;

public interface DiskUsage {
    void touch(File file) throws IOException;
}
