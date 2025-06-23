package com.alimm.tanx.ui.image.glide.load.engine.cache;

import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache;

/* loaded from: classes.dex */
public class MemoryCacheAdapter implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public void clearMemory() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public int getCurrentSize() {
        return 0;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public int getMaxSize() {
        return 0;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public Resource<?> put(Key key, Resource<?> resource) {
        this.listener.onResourceRemoved(resource);
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public Resource<?> remove(Key key) {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public void setSizeMultiplier(float f) {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public void trimMemory(int i) {
    }
}
