package com.blankj.utilcode.util;

import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import com.blankj.utilcode.constant.CacheConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public final class CacheMemoryUtils implements CacheConstants {
    private static final Map<String, CacheMemoryUtils> CACHE_MAP = new HashMap();
    private static final int DEFAULT_MAX_COUNT = 256;
    private final String mCacheKey;
    private final LruCache<String, CacheValue> mMemoryCache;

    /* loaded from: classes8.dex */
    public static final class CacheValue {
        long dueTime;
        Object value;

        public CacheValue(long j, Object obj) {
            this.dueTime = j;
            this.value = obj;
        }
    }

    private CacheMemoryUtils(String str, LruCache<String, CacheValue> lruCache) {
        this.mCacheKey = str;
        this.mMemoryCache = lruCache;
    }

    public static CacheMemoryUtils getInstance() {
        return getInstance(256);
    }

    public void clear() {
        this.mMemoryCache.evictAll();
    }

    public <T> T get(@NonNull String str) {
        if (str != null) {
            return (T) get(str, null);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public int getCacheCount() {
        return this.mMemoryCache.size();
    }

    public void put(@NonNull String str, Object obj) {
        if (str != null) {
            put(str, obj, -1);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public Object remove(@NonNull String str) {
        if (str != null) {
            CacheValue remove = this.mMemoryCache.remove(str);
            if (remove == null) {
                return null;
            }
            return remove.value;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public String toString() {
        return this.mCacheKey + "@" + Integer.toHexString(hashCode());
    }

    public static CacheMemoryUtils getInstance(int i) {
        return getInstance(String.valueOf(i), i);
    }

    public static CacheMemoryUtils getInstance(String str, int i) {
        Map<String, CacheMemoryUtils> map = CACHE_MAP;
        CacheMemoryUtils cacheMemoryUtils = map.get(str);
        if (cacheMemoryUtils == null) {
            synchronized (CacheMemoryUtils.class) {
                try {
                    cacheMemoryUtils = map.get(str);
                    if (cacheMemoryUtils == null) {
                        cacheMemoryUtils = new CacheMemoryUtils(str, new LruCache(i));
                        map.put(str, cacheMemoryUtils);
                    }
                } finally {
                }
            }
        }
        return cacheMemoryUtils;
    }

    public <T> T get(@NonNull String str, T t) {
        if (str != null) {
            CacheValue cacheValue = this.mMemoryCache.get(str);
            if (cacheValue == null) {
                return t;
            }
            long j = cacheValue.dueTime;
            if (j != -1 && j < System.currentTimeMillis()) {
                this.mMemoryCache.remove(str);
                return t;
            }
            return (T) cacheValue.value;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void put(@NonNull String str, Object obj, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (obj == null) {
            return;
        }
        this.mMemoryCache.put(str, new CacheValue(i < 0 ? -1L : System.currentTimeMillis() + (i * 1000), obj));
    }
}
