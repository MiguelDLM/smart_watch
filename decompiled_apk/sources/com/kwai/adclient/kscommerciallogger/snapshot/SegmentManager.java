package com.kwai.adclient.kscommerciallogger.snapshot;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.work.PeriodicWorkRequest;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;

/* loaded from: classes11.dex */
public enum SegmentManager {
    Instance;

    private static final int expiredThresholds = 900000;
    private long lastAutoClearTime;
    private LruCache<String, Set<c>> mSnapshots;
    private boolean isDebug = false;
    private boolean hasInit = false;

    SegmentManager() {
    }

    private void autoClear() {
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache != null && lruCache.size() != 0 && System.currentTimeMillis() - this.lastAutoClearTime >= PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            this.lastAutoClearTime = System.currentTimeMillis();
            for (Map.Entry<String, Set<c>> entry : this.mSnapshots.snapshot().entrySet()) {
                String key = entry.getKey();
                Set<c> value = entry.getValue();
                if (value != null) {
                    Iterator<c> it = value.iterator();
                    this.mSnapshots.remove(key);
                    while (it.hasNext()) {
                        if (this.lastAutoClearTime - it.next().Pd() >= PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
                            it.remove();
                        }
                    }
                    if (value.size() > 0) {
                        this.mSnapshots.put(key, value);
                    }
                }
            }
        }
    }

    public final int cacheLimit() {
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null) {
            return 0;
        }
        return lruCache.maxSize();
    }

    @Deprecated
    public final void clearBySegment(String str) {
        if (TextUtils.isEmpty(str) || this.mSnapshots == null) {
            return;
        }
        synchronized (this) {
            try {
                Iterator<Map.Entry<String, Set<c>>> it = this.mSnapshots.snapshot().entrySet().iterator();
                while (it.hasNext()) {
                    clearBySegment(it.next().getKey(), str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void clearBySessionId(String str) {
        if (!TextUtils.isEmpty(str) && this.mSnapshots != null) {
            synchronized (this) {
                this.mSnapshots.remove(str);
                autoClear();
            }
        }
    }

    public final synchronized void init(int i, boolean z) {
        try {
            if (!this.hasInit) {
                this.isDebug = z;
                if (i > 0) {
                    this.mSnapshots = new LruCache<String, Set<c>>(i) { // from class: com.kwai.adclient.kscommerciallogger.snapshot.SegmentManager.1
                        private static int f(Set<c> set) {
                            return set.size();
                        }

                        @Override // android.util.LruCache
                        public final /* synthetic */ int sizeOf(String str, Set<c> set) {
                            return f(set);
                        }
                    };
                }
                this.hasInit = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean isOverThreshold() {
        if (cacheLimit() > 0 && segmentSize() != 0) {
            if (BigDecimal.valueOf(segmentSize() / cacheLimit()).setScale(2, RoundingMode.HALF_UP).doubleValue() < 0.7d) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final JSONArray justLoadInfoBySessionId(String str) {
        JSONArray jSONArray = new JSONArray();
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache != null && lruCache.size() != 0) {
            synchronized (this) {
                try {
                    Set<c> set = this.mSnapshots.get(str);
                    if (set != null) {
                        Iterator<c> it = set.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next().hx(str));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return jSONArray;
        }
        return jSONArray;
    }

    public final JSONArray loadInfoBySessionId(String str) {
        JSONArray jSONArray = new JSONArray();
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache != null && lruCache.size() != 0) {
            synchronized (this) {
                try {
                    Set<c> set = this.mSnapshots.get(str);
                    if (set != null) {
                        Iterator<c> it = set.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next().hx(str));
                        }
                        this.mSnapshots.remove(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return jSONArray;
        }
        return jSONArray;
    }

    public final c loadSegment(@NonNull String str, @NonNull String str2, int i) {
        if (this.mSnapshots == null) {
            if (!this.hasInit && this.isDebug) {
                throw new IllegalStateException("you need init first");
            }
            return new a("empty");
        }
        synchronized (this) {
            try {
                Set<c> set = this.mSnapshots.get(str);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar.getName().equals(str2)) {
                            return cVar;
                        }
                    }
                }
                c cVar2 = new c(str2, i);
                if (set != null) {
                    this.mSnapshots.remove(str);
                    set.add(cVar2);
                    this.mSnapshots.put(str, set);
                } else {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    linkedHashSet.add(cVar2);
                    this.mSnapshots.put(str, linkedHashSet);
                }
                autoClear();
                return cVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String loadSessionId() {
        return UUID.randomUUID().toString();
    }

    public final d loadSpan(@NonNull String str, @NonNull String str2) {
        return loadSpan(str, str2, TtmlNode.TAG_SPAN);
    }

    public final synchronized Map.Entry<String, Integer> mostUsedSegmentInfo() {
        HashMap hashMap;
        try {
            hashMap = new HashMap();
            Iterator<Map.Entry<String, Set<c>>> it = this.mSnapshots.snapshot().entrySet().iterator();
            while (it.hasNext()) {
                for (c cVar : it.next().getValue()) {
                    Integer num = (Integer) hashMap.get(cVar.getName());
                    if (num == null) {
                        hashMap.put(cVar.getName(), 1);
                    } else {
                        hashMap.put(cVar.getName(), Integer.valueOf(num.intValue() + 1));
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Map.Entry) Collections.max(new ArrayList(hashMap.entrySet()), new Comparator<Map.Entry<String, Integer>>() { // from class: com.kwai.adclient.kscommerciallogger.snapshot.SegmentManager.2
            private static int a(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                return entry.getValue().compareTo(entry2.getValue());
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                return a(entry, entry2);
            }
        });
    }

    public final synchronized int segmentSize() {
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null) {
            return 0;
        }
        return lruCache.size();
    }

    public final synchronized int size() {
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null) {
            return 0;
        }
        return lruCache.snapshot().size();
    }

    public final d loadSpan(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return loadSegment(str, str2).hw(str3);
    }

    public final void clearBySegment(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mSnapshots == null) {
            return;
        }
        synchronized (this) {
            try {
                Set<c> set = this.mSnapshots.get(str);
                c cVar = new c(str2);
                if (set != null && set.contains(cVar)) {
                    this.mSnapshots.remove(str);
                    set.remove(cVar);
                    if (set.size() > 0) {
                        this.mSnapshots.put(str, set);
                    }
                }
                autoClear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final c loadSegment(@NonNull String str, @NonNull String str2) {
        return loadSegment(str, str2, 10);
    }
}
