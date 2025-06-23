package androidx.collection;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.IntRange;
import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/collection/LruCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 LockExt.kt\nandroidx/collection/internal/LockExtKt\n+ 4 Lock.jvm.kt\nandroidx/collection/internal/Lock\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,355:1\n1#2:356\n23#3,3:357\n23#3,3:361\n23#3,3:365\n23#3,3:369\n23#3,3:373\n23#3,3:377\n23#3,3:381\n23#3,3:385\n23#3,3:389\n23#3,3:393\n23#3,3:397\n23#3,3:401\n23#3,3:405\n23#3,3:409\n23#3,3:415\n26#4:360\n26#4:364\n26#4:368\n26#4:372\n26#4:376\n26#4:380\n26#4:384\n26#4:388\n26#4:392\n26#4:396\n26#4:400\n26#4:404\n26#4:408\n26#4:412\n26#4:418\n1855#5,2:413\n*S KotlinDebug\n*F\n+ 1 LruCache.kt\nandroidx/collection/LruCache\n*L\n65#1:357,3\n78#1:361,3\n95#1:365,3\n122#1:369,3\n151#1:373,3\n180#1:377,3\n255#1:381,3\n262#1:385,3\n268#1:389,3\n274#1:393,3\n279#1:397,3\n284#1:401,3\n289#1:405,3\n299#1:409,3\n308#1:415,3\n65#1:360\n78#1:364\n95#1:368\n122#1:372\n151#1:376\n180#1:380\n255#1:384\n262#1:388\n268#1:392\n274#1:396\n279#1:400\n284#1:404\n289#1:408\n299#1:412\n308#1:418\n300#1:413,2\n*E\n"})
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    @OOXIXo
    private final Lock lock;
    @OOXIXo
    private final LruHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(@IntRange(from = 1, to = Long.MAX_VALUE) int i) {
        this.maxSize = i;
        if (i > 0) {
            this.map = new LruHashMap<>(0, 0.75f);
            this.lock = new Lock();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private final int safeSizeOf(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException(("Negative size: " + k + '=' + v).toString());
    }

    @oOoXoXO
    public V create(@OOXIXo K k) {
        IIX0o.x0xO0oo(k, "key");
        return null;
    }

    public final int createCount() {
        int i;
        synchronized (this.lock) {
            i = this.createCount;
        }
        return i;
    }

    public void entryRemoved(boolean z, @OOXIXo K k, @OOXIXo V v, @oOoXoXO V v2) {
        IIX0o.x0xO0oo(k, "key");
        IIX0o.x0xO0oo(v, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i;
        synchronized (this.lock) {
            i = this.evictionCount;
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        r0 = create(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r0 != null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        r1 = r5.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r5.createCount++;
        r2 = r5.map.put(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r2 == null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        r5.map.put(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        r5.size += safeSizeOf(r6, r0);
        r3 = kotlin.oXIO0o0XI.f19155oIX0oI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (r2 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
        entryRemoved(false, r6, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        trimToSize(r5.maxSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return r2;
     */
    @OXOo.oOoXoXO
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(@OXOo.OOXIXo K r6) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r0)
            androidx.collection.internal.Lock r0 = r5.lock
            monitor-enter(r0)
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x001a
            int r6 = r5.hitCount     // Catch:{ all -> 0x0018 }
            int r6 = r6 + 1
            r5.hitCount = r6     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)
            return r1
        L_0x0018:
            r6 = move-exception
            goto L_0x005e
        L_0x001a:
            int r1 = r5.missCount     // Catch:{ all -> 0x0018 }
            int r1 = r1 + 1
            r5.missCount = r1     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)
            java.lang.Object r0 = r5.create(r6)
            if (r0 != 0) goto L_0x0029
            r6 = 0
            return r6
        L_0x0029:
            androidx.collection.internal.Lock r1 = r5.lock
            monitor-enter(r1)
            int r2 = r5.createCount     // Catch:{ all -> 0x0040 }
            int r2 = r2 + 1
            r5.createCount = r2     // Catch:{ all -> 0x0040 }
            androidx.collection.internal.LruHashMap<K, V> r2 = r5.map     // Catch:{ all -> 0x0040 }
            java.lang.Object r2 = r2.put(r6, r0)     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x0042
            androidx.collection.internal.LruHashMap<K, V> r3 = r5.map     // Catch:{ all -> 0x0040 }
            r3.put(r6, r2)     // Catch:{ all -> 0x0040 }
            goto L_0x004d
        L_0x0040:
            r6 = move-exception
            goto L_0x005c
        L_0x0042:
            int r3 = r5.size     // Catch:{ all -> 0x0040 }
            int r4 = r5.safeSizeOf(r6, r0)     // Catch:{ all -> 0x0040 }
            int r3 = r3 + r4
            r5.size = r3     // Catch:{ all -> 0x0040 }
            kotlin.oXIO0o0XI r3 = kotlin.oXIO0o0XI.f19155oIX0oI     // Catch:{ all -> 0x0040 }
        L_0x004d:
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0056
            r1 = 0
            r5.entryRemoved(r1, r6, r0, r2)
            r0 = r2
            goto L_0x005b
        L_0x0056:
            int r6 = r5.maxSize
            r5.trimToSize(r6)
        L_0x005b:
            return r0
        L_0x005c:
            monitor-exit(r1)
            throw r6
        L_0x005e:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.get(java.lang.Object):java.lang.Object");
    }

    public final int hitCount() {
        int i;
        synchronized (this.lock) {
            i = this.hitCount;
        }
        return i;
    }

    public final int maxSize() {
        int i;
        synchronized (this.lock) {
            i = this.maxSize;
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this.lock) {
            i = this.missCount;
        }
        return i;
    }

    @oOoXoXO
    public final V put(@OOXIXo K k, @OOXIXo V v) {
        V put;
        IIX0o.x0xO0oo(k, "key");
        IIX0o.x0xO0oo(v, "value");
        synchronized (this.lock) {
            try {
                this.putCount++;
                this.size += safeSizeOf(k, v);
                put = this.map.put(k, v);
                if (put != null) {
                    this.size -= safeSizeOf(k, put);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    public final int putCount() {
        int i;
        synchronized (this.lock) {
            i = this.putCount;
        }
        return i;
    }

    @oOoXoXO
    public final V remove(@OOXIXo K k) {
        V remove;
        IIX0o.x0xO0oo(k, "key");
        synchronized (this.lock) {
            try {
                remove = this.map.remove(k);
                if (remove != null) {
                    this.size -= safeSizeOf(k, remove);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (remove != null) {
            entryRemoved(false, k, remove, (V) null);
        }
        return remove;
    }

    public void resize(@IntRange(from = 1, to = Long.MAX_VALUE) int i) {
        if (i > 0) {
            synchronized (this.lock) {
                this.maxSize = i;
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            }
            trimToSize(i);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final int size() {
        int i;
        synchronized (this.lock) {
            i = this.size;
        }
        return i;
    }

    public int sizeOf(@OOXIXo K k, @OOXIXo V v) {
        IIX0o.x0xO0oo(k, "key");
        IIX0o.x0xO0oo(v, "value");
        return 1;
    }

    @OOXIXo
    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.lock) {
            try {
                for (Map.Entry entry : this.map.getEntries()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        return linkedHashMap;
    }

    @OOXIXo
    public String toString() {
        int i;
        String str;
        synchronized (this.lock) {
            try {
                int i2 = this.hitCount;
                int i3 = this.missCount + i2;
                if (i3 != 0) {
                    i = (i2 * 100) / i3;
                } else {
                    i = 0;
                }
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + i + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005e, code lost:
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r6) {
        /*
            r5 = this;
        L_0x0000:
            androidx.collection.internal.Lock r0 = r5.lock
            monitor-enter(r0)
            int r1 = r5.size     // Catch:{ all -> 0x0014 }
            if (r1 < 0) goto L_0x0057
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0014 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x0016
            int r1 = r5.size     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0057
            goto L_0x0016
        L_0x0014:
            r6 = move-exception
            goto L_0x005f
        L_0x0016:
            int r1 = r5.size     // Catch:{ all -> 0x0014 }
            if (r1 <= r6) goto L_0x0055
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0014 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x0023
            goto L_0x0055
        L_0x0023:
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0014 }
            java.util.Set r1 = r1.getEntries()     // Catch:{ all -> 0x0014 }
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.xx0(r1)     // Catch:{ all -> 0x0014 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0033
            monitor-exit(r0)
            return
        L_0x0033:
            java.lang.Object r2 = r1.getKey()     // Catch:{ all -> 0x0014 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0014 }
            androidx.collection.internal.LruHashMap<K, V> r3 = r5.map     // Catch:{ all -> 0x0014 }
            r3.remove(r2)     // Catch:{ all -> 0x0014 }
            int r3 = r5.size     // Catch:{ all -> 0x0014 }
            int r4 = r5.safeSizeOf(r2, r1)     // Catch:{ all -> 0x0014 }
            int r3 = r3 - r4
            r5.size = r3     // Catch:{ all -> 0x0014 }
            int r3 = r5.evictionCount     // Catch:{ all -> 0x0014 }
            r4 = 1
            int r3 = r3 + r4
            r5.evictionCount = r3     // Catch:{ all -> 0x0014 }
            monitor-exit(r0)
            r0 = 0
            r5.entryRemoved(r4, r2, r1, r0)
            goto L_0x0000
        L_0x0055:
            monitor-exit(r0)
            return
        L_0x0057:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0014 }
            r1.<init>(r6)     // Catch:{ all -> 0x0014 }
            throw r1     // Catch:{ all -> 0x0014 }
        L_0x005f:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }
}
