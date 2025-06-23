package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Ascii;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Equivalence;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.MoreObjects;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Supplier;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Suppliers;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Ticker;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.AbstractCache;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CheckReturnValue;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class CacheBuilder<K, V> {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final int UNSET_INT = -1;

    @MonotonicNonNullDecl
    Equivalence<Object> keyEquivalence;

    @MonotonicNonNullDecl
    LocalCache.Strength keyStrength;

    @MonotonicNonNullDecl
    RemovalListener<? super K, ? super V> removalListener;

    @MonotonicNonNullDecl
    Ticker ticker;

    @MonotonicNonNullDecl
    Equivalence<Object> valueEquivalence;

    @MonotonicNonNullDecl
    LocalCache.Strength valueStrength;

    @MonotonicNonNullDecl
    Weigher<? super K, ? super V> weigher;
    static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new AbstractCache.StatsCounter() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilder.1
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return CacheBuilder.EMPTY_STATS;
        }
    });
    static final CacheStats EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = new Supplier<AbstractCache.StatsCounter>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilder.2
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Supplier, java.util.function.Supplier
        public AbstractCache.StatsCounter get() {
            return new AbstractCache.SimpleStatsCounter();
        }
    };
    static final Ticker NULL_TICKER = new Ticker() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilder.3
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Ticker
        public long read() {
            return 0L;
        }
    };
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    boolean strictParsing = true;
    int initialCapacity = -1;
    int concurrencyLevel = -1;
    long maximumSize = -1;
    long maximumWeight = -1;
    long expireAfterWriteNanos = -1;
    long expireAfterAccessNanos = -1;
    long refreshNanos = -1;
    Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;

    /* loaded from: classes10.dex */
    public enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    /* loaded from: classes10.dex */
    public enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.Weigher
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    private void checkNonLoadingCache() {
        boolean z;
        if (this.refreshNanos == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        boolean z = false;
        if (this.weigher == null) {
            if (this.maximumWeight == -1) {
                z = true;
            }
            Preconditions.checkState(z, "maximumWeight requires weigher");
        } else if (this.strictParsing) {
            if (this.maximumWeight != -1) {
                z = true;
            }
            Preconditions.checkState(z, "weigher requires maximumWeight");
        } else if (this.maximumWeight == -1) {
            logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public CacheBuilder<K, V> concurrencyLevel(int i) {
        boolean z;
        int i2 = this.concurrencyLevel;
        boolean z2 = false;
        if (i2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "concurrency level was already set to %s", i2);
        if (i > 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        this.concurrencyLevel = i;
        return this;
    }

    public CacheBuilder<K, V> expireAfterAccess(long j, TimeUnit timeUnit) {
        boolean z;
        long j2 = this.expireAfterAccessNanos;
        boolean z2 = false;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "expireAfterAccess was already set to %s ns", j2);
        if (j >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "duration cannot be negative: %s %s", j, timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j);
        return this;
    }

    public CacheBuilder<K, V> expireAfterWrite(long j, TimeUnit timeUnit) {
        boolean z;
        long j2 = this.expireAfterWriteNanos;
        boolean z2 = false;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "expireAfterWrite was already set to %s ns", j2);
        if (j >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "duration cannot be negative: %s %s", j, timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j);
        return this;
    }

    public int getConcurrencyLevel() {
        int i = this.concurrencyLevel;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public long getExpireAfterAccessNanos() {
        long j = this.expireAfterAccessNanos;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public long getExpireAfterWriteNanos() {
        long j = this.expireAfterWriteNanos;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public int getInitialCapacity() {
        int i = this.initialCapacity;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    public LocalCache.Strength getKeyStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
    }

    public long getMaximumWeight() {
        if (this.expireAfterWriteNanos == 0 || this.expireAfterAccessNanos == 0) {
            return 0L;
        }
        if (this.weigher == null) {
            return this.maximumSize;
        }
        return this.maximumWeight;
    }

    public long getRefreshNanos() {
        long j = this.refreshNanos;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    public Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    public Ticker getTicker(boolean z) {
        Ticker ticker = this.ticker;
        if (ticker != null) {
            return ticker;
        }
        if (z) {
            return Ticker.systemTicker();
        }
        return NULL_TICKER;
    }

    public Equivalence<Object> getValueEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    public LocalCache.Strength getValueStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
    }

    public <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> initialCapacity(int i) {
        boolean z;
        int i2 = this.initialCapacity;
        boolean z2 = false;
        if (i2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "initial capacity was already set to %s", i2);
        if (i >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        this.initialCapacity = i;
        return this;
    }

    public boolean isRecordingStats() {
        if (this.statsCounterSupplier == CACHE_STATS_COUNTER) {
            return true;
        }
        return false;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> keyEquivalence(Equivalence<Object> equivalence) {
        boolean z;
        Equivalence<Object> equivalence2 = this.keyEquivalence;
        if (equivalence2 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "key equivalence was already set to %s", equivalence2);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    public CacheBuilder<K, V> maximumSize(long j) {
        boolean z;
        boolean z2;
        boolean z3;
        long j2 = this.maximumSize;
        boolean z4 = false;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "maximum size was already set to %s", j2);
        long j3 = this.maximumWeight;
        if (j3 == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "maximum weight was already set to %s", j3);
        if (this.weigher == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "maximum size can not be combined with weigher");
        if (j >= 0) {
            z4 = true;
        }
        Preconditions.checkArgument(z4, "maximum size must not be negative");
        this.maximumSize = j;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> maximumWeight(long j) {
        boolean z;
        boolean z2;
        long j2 = this.maximumWeight;
        boolean z3 = false;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "maximum weight was already set to %s", j2);
        long j3 = this.maximumSize;
        if (j3 == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "maximum size was already set to %s", j3);
        this.maximumWeight = j;
        if (j >= 0) {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "maximum weight must not be negative");
        return this;
    }

    public CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> refreshAfterWrite(long j, TimeUnit timeUnit) {
        boolean z;
        Preconditions.checkNotNull(timeUnit);
        long j2 = this.refreshNanos;
        boolean z2 = false;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "refresh was already set to %s ns", j2);
        if (j > 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "duration must be positive: %s %s", j, timeUnit);
        this.refreshNanos = timeUnit.toNanos(j);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener) {
        boolean z;
        if (this.removalListener == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(removalListener);
        return this;
    }

    public CacheBuilder<K, V> setKeyStrength(LocalCache.Strength strength) {
        boolean z;
        LocalCache.Strength strength2 = this.keyStrength;
        if (strength2 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Key strength was already set to %s", strength2);
        this.keyStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    public CacheBuilder<K, V> setValueStrength(LocalCache.Strength strength) {
        boolean z;
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Value strength was already set to %s", strength2);
        this.valueStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> softValues() {
        return setValueStrength(LocalCache.Strength.SOFT);
    }

    public CacheBuilder<K, V> ticker(Ticker ticker) {
        boolean z;
        if (this.ticker == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker);
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i = this.initialCapacity;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.concurrencyLevel;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        long j = this.maximumSize;
        if (j != -1) {
            stringHelper.add("maximumSize", j);
        }
        long j2 = this.maximumWeight;
        if (j2 != -1) {
            stringHelper.add("maximumWeight", j2);
        }
        if (this.expireAfterWriteNanos != -1) {
            stringHelper.add("expireAfterWrite", this.expireAfterWriteNanos + "ns");
        }
        if (this.expireAfterAccessNanos != -1) {
            stringHelper.add("expireAfterAccess", this.expireAfterAccessNanos + "ns");
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(strength.toString()));
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue("keyEquivalence");
        }
        if (this.valueEquivalence != null) {
            stringHelper.addValue("valueEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue("removalListener");
        }
        return stringHelper.toString();
    }

    @GwtIncompatible
    public CacheBuilder<K, V> valueEquivalence(Equivalence<Object> equivalence) {
        boolean z;
        Equivalence<Object> equivalence2 = this.valueEquivalence;
        if (equivalence2 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "value equivalence was already set to %s", equivalence2);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakValues() {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher) {
        boolean z;
        boolean z2 = false;
        if (this.weigher == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (this.strictParsing) {
            long j = this.maximumSize;
            if (j == -1) {
                z2 = true;
            }
            Preconditions.checkState(z2, "weigher can not be combined with maximum size", j);
        }
        this.weigher = (Weigher) Preconditions.checkNotNull(weigher);
        return this;
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }
}
