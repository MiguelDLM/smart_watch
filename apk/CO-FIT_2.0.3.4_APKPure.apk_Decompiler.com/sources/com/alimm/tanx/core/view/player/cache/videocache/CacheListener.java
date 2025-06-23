package com.alimm.tanx.core.view.player.cache.videocache;

import java.io.File;

public interface CacheListener {
    void onCacheAvailable(File file, String str, int i);
}
