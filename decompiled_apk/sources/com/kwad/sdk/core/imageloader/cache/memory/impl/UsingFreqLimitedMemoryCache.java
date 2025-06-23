package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes11.dex */
public class UsingFreqLimitedMemoryCache extends LimitedMemoryCache {
    private final Map<DecodedResult, Integer> usingCounts;

    public UsingFreqLimitedMemoryCache(int i) {
        super(i);
        this.usingCounts = Collections.synchronizedMap(new HashMap());
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.usingCounts.clear();
        super.clear();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache
    public Reference<DecodedResult> createReference(DecodedResult decodedResult) {
        return new WeakReference(decodedResult);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult get(String str) {
        Integer num;
        DecodedResult decodedResult = super.get(str);
        if (decodedResult != null && (num = this.usingCounts.get(decodedResult)) != null) {
            this.usingCounts.put(decodedResult, Integer.valueOf(num.intValue() + 1));
        }
        return decodedResult;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache
    public int getSize(DecodedResult decodedResult) {
        return decodedResult.getByteSize();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        if (!super.put(str, decodedResult)) {
            return false;
        }
        this.usingCounts.put(decodedResult, 0);
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        DecodedResult decodedResult = super.get(str);
        if (decodedResult != null) {
            this.usingCounts.remove(decodedResult);
        }
        return super.remove(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache
    public DecodedResult removeNext() {
        DecodedResult decodedResult;
        Set<Map.Entry<DecodedResult, Integer>> entrySet = this.usingCounts.entrySet();
        synchronized (this.usingCounts) {
            try {
                decodedResult = null;
                Integer num = null;
                for (Map.Entry<DecodedResult, Integer> entry : entrySet) {
                    if (decodedResult == null) {
                        decodedResult = entry.getKey();
                        num = entry.getValue();
                    } else {
                        Integer value = entry.getValue();
                        if (value.intValue() < num.intValue()) {
                            decodedResult = entry.getKey();
                            num = value;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.usingCounts.remove(decodedResult);
        return decodedResult;
    }
}
