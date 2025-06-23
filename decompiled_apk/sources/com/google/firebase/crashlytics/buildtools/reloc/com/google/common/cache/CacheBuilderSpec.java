package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.VisibleForTesting;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.MoreObjects;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Objects;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Splitter;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
/* loaded from: classes10.dex */
public final class CacheBuilderSpec {
    private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
    private static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
    private static final ImmutableMap<String, ValueParser> VALUE_PARSERS;

    @VisibleForTesting
    long accessExpirationDuration;

    @VisibleForTesting
    @MonotonicNonNullDecl
    TimeUnit accessExpirationTimeUnit;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Integer concurrencyLevel;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Integer initialCapacity;

    @VisibleForTesting
    @MonotonicNonNullDecl
    LocalCache.Strength keyStrength;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Long maximumSize;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Long maximumWeight;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Boolean recordStats;

    @VisibleForTesting
    long refreshDuration;

    @VisibleForTesting
    @MonotonicNonNullDecl
    TimeUnit refreshTimeUnit;
    private final String specification;

    @VisibleForTesting
    @MonotonicNonNullDecl
    LocalCache.Strength valueStrength;

    @VisibleForTesting
    long writeExpirationDuration;

    @VisibleForTesting
    @MonotonicNonNullDecl
    TimeUnit writeExpirationTimeUnit;

    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$cache$LocalCache$Strength;

        static {
            int[] iArr = new int[LocalCache.Strength.values().length];
            $SwitchMap$com$google$common$cache$LocalCache$Strength = iArr;
            try {
                iArr[LocalCache.Strength.WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$cache$LocalCache$Strength[LocalCache.Strength.SOFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class AccessDurationParser extends DurationParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.DurationParser
        public void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            boolean z;
            if (cacheBuilderSpec.accessExpirationTimeUnit == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "expireAfterAccess already set");
            cacheBuilderSpec.accessExpirationDuration = j;
            cacheBuilderSpec.accessExpirationTimeUnit = timeUnit;
        }
    }

    /* loaded from: classes10.dex */
    public static class ConcurrencyLevelParser extends IntegerParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.IntegerParser
        public void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i) {
            boolean z;
            Integer num = cacheBuilderSpec.concurrencyLevel;
            if (num == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "concurrency level was already set to ", num);
            cacheBuilderSpec.concurrencyLevel = Integer.valueOf(i);
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class DurationParser implements ValueParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            boolean z;
            TimeUnit timeUnit;
            if (str2 != null && !str2.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "value of key %s omitted", str);
            try {
                char charAt = str2.charAt(str2.length() - 1);
                if (charAt != 'd') {
                    if (charAt != 'h') {
                        if (charAt != 'm') {
                            if (charAt == 's') {
                                timeUnit = TimeUnit.SECONDS;
                            } else {
                                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", str, str2));
                            }
                        } else {
                            timeUnit = TimeUnit.MINUTES;
                        }
                    } else {
                        timeUnit = TimeUnit.HOURS;
                    }
                } else {
                    timeUnit = TimeUnit.DAYS;
                }
                parseDuration(cacheBuilderSpec, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2));
            }
        }

        public abstract void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit);
    }

    /* loaded from: classes10.dex */
    public static class InitialCapacityParser extends IntegerParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.IntegerParser
        public void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i) {
            boolean z;
            Integer num = cacheBuilderSpec.initialCapacity;
            if (num == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "initial capacity was already set to ", num);
            cacheBuilderSpec.initialCapacity = Integer.valueOf(i);
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class IntegerParser implements ValueParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            boolean z;
            if (str2 != null && !str2.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "value of key %s omitted", str);
            try {
                parseInteger(cacheBuilderSpec, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2), e);
            }
        }

        public abstract void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i);
    }

    /* loaded from: classes10.dex */
    public static class KeyStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public KeyStrengthParser(LocalCache.Strength strength) {
            this.strength = strength;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2) {
            boolean z;
            boolean z2 = false;
            if (str2 == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "key %s does not take values", str);
            LocalCache.Strength strength = cacheBuilderSpec.keyStrength;
            if (strength == null) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "%s was already set to %s", str, strength);
            cacheBuilderSpec.keyStrength = this.strength;
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class LongParser implements ValueParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            boolean z;
            if (str2 != null && !str2.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "value of key %s omitted", str);
            try {
                parseLong(cacheBuilderSpec, Long.parseLong(str2));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2), e);
            }
        }

        public abstract void parseLong(CacheBuilderSpec cacheBuilderSpec, long j);
    }

    /* loaded from: classes10.dex */
    public static class MaximumSizeParser extends LongParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.LongParser
        public void parseLong(CacheBuilderSpec cacheBuilderSpec, long j) {
            boolean z;
            Long l = cacheBuilderSpec.maximumSize;
            boolean z2 = false;
            if (l == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "maximum size was already set to ", l);
            Long l2 = cacheBuilderSpec.maximumWeight;
            if (l2 == null) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "maximum weight was already set to ", l2);
            cacheBuilderSpec.maximumSize = Long.valueOf(j);
        }
    }

    /* loaded from: classes10.dex */
    public static class MaximumWeightParser extends LongParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.LongParser
        public void parseLong(CacheBuilderSpec cacheBuilderSpec, long j) {
            boolean z;
            Long l = cacheBuilderSpec.maximumWeight;
            boolean z2 = false;
            if (l == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "maximum weight was already set to ", l);
            Long l2 = cacheBuilderSpec.maximumSize;
            if (l2 == null) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "maximum size was already set to ", l2);
            cacheBuilderSpec.maximumWeight = Long.valueOf(j);
        }
    }

    /* loaded from: classes10.dex */
    public static class RecordStatsParser implements ValueParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2) {
            boolean z;
            boolean z2 = false;
            if (str2 == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "recordStats does not take values");
            if (cacheBuilderSpec.recordStats == null) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "recordStats already set");
            cacheBuilderSpec.recordStats = Boolean.TRUE;
        }
    }

    /* loaded from: classes10.dex */
    public static class RefreshDurationParser extends DurationParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.DurationParser
        public void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            boolean z;
            if (cacheBuilderSpec.refreshTimeUnit == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "refreshAfterWrite already set");
            cacheBuilderSpec.refreshDuration = j;
            cacheBuilderSpec.refreshTimeUnit = timeUnit;
        }
    }

    /* loaded from: classes10.dex */
    public interface ValueParser {
        void parse(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2);
    }

    /* loaded from: classes10.dex */
    public static class ValueStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public ValueStrengthParser(LocalCache.Strength strength) {
            this.strength = strength;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2) {
            boolean z;
            boolean z2 = false;
            if (str2 == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "key %s does not take values", str);
            LocalCache.Strength strength = cacheBuilderSpec.valueStrength;
            if (strength == null) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "%s was already set to %s", str, strength);
            cacheBuilderSpec.valueStrength = this.strength;
        }
    }

    /* loaded from: classes10.dex */
    public static class WriteDurationParser extends DurationParser {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.CacheBuilderSpec.DurationParser
        public void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            boolean z;
            if (cacheBuilderSpec.writeExpirationTimeUnit == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "expireAfterWrite already set");
            cacheBuilderSpec.writeExpirationDuration = j;
            cacheBuilderSpec.writeExpirationTimeUnit = timeUnit;
        }
    }

    static {
        ImmutableMap.Builder put = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser());
        LocalCache.Strength strength = LocalCache.Strength.WEAK;
        VALUE_PARSERS = put.put("weakKeys", new KeyStrengthParser(strength)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(strength)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).build();
    }

    private CacheBuilderSpec(String str) {
        this.specification = str;
    }

    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    @NullableDecl
    private static Long durationInNanos(long j, @NullableDecl TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String format(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CacheBuilderSpec parse(String str) {
        boolean z;
        String str2;
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(str);
        if (!str.isEmpty()) {
            for (String str3 : KEYS_SPLITTER.split(str)) {
                ImmutableList copyOf = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(str3));
                Preconditions.checkArgument(!copyOf.isEmpty(), "blank key-value pair");
                boolean z2 = false;
                if (copyOf.size() <= 2) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "key-value pair %s with more than one equals sign", str3);
                String str4 = (String) copyOf.get(0);
                ValueParser valueParser = VALUE_PARSERS.get(str4);
                if (valueParser != null) {
                    z2 = true;
                }
                Preconditions.checkArgument(z2, "unknown key %s", str4);
                if (copyOf.size() == 1) {
                    str2 = null;
                } else {
                    str2 = (String) copyOf.get(1);
                }
                valueParser.parse(cacheBuilderSpec, str4, str2);
            }
        }
        return cacheBuilderSpec;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        if (Objects.equal(this.initialCapacity, cacheBuilderSpec.initialCapacity) && Objects.equal(this.maximumSize, cacheBuilderSpec.maximumSize) && Objects.equal(this.maximumWeight, cacheBuilderSpec.maximumWeight) && Objects.equal(this.concurrencyLevel, cacheBuilderSpec.concurrencyLevel) && Objects.equal(this.keyStrength, cacheBuilderSpec.keyStrength) && Objects.equal(this.valueStrength, cacheBuilderSpec.valueStrength) && Objects.equal(this.recordStats, cacheBuilderSpec.recordStats) && Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(cacheBuilderSpec.writeExpirationDuration, cacheBuilderSpec.writeExpirationTimeUnit)) && Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(cacheBuilderSpec.accessExpirationDuration, cacheBuilderSpec.accessExpirationTimeUnit)) && Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(cacheBuilderSpec.refreshDuration, cacheBuilderSpec.refreshTimeUnit))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit));
    }

    public CacheBuilder<Object, Object> toCacheBuilder() {
        CacheBuilder<Object, Object> newBuilder = CacheBuilder.newBuilder();
        Integer num = this.initialCapacity;
        if (num != null) {
            newBuilder.initialCapacity(num.intValue());
        }
        Long l = this.maximumSize;
        if (l != null) {
            newBuilder.maximumSize(l.longValue());
        }
        Long l2 = this.maximumWeight;
        if (l2 != null) {
            newBuilder.maximumWeight(l2.longValue());
        }
        Integer num2 = this.concurrencyLevel;
        if (num2 != null) {
            newBuilder.concurrencyLevel(num2.intValue());
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            if (AnonymousClass1.$SwitchMap$com$google$common$cache$LocalCache$Strength[strength.ordinal()] == 1) {
                newBuilder.weakKeys();
            } else {
                throw new AssertionError();
            }
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            int i = AnonymousClass1.$SwitchMap$com$google$common$cache$LocalCache$Strength[strength2.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    newBuilder.softValues();
                } else {
                    throw new AssertionError();
                }
            } else {
                newBuilder.weakValues();
            }
        }
        Boolean bool = this.recordStats;
        if (bool != null && bool.booleanValue()) {
            newBuilder.recordStats();
        }
        TimeUnit timeUnit = this.writeExpirationTimeUnit;
        if (timeUnit != null) {
            newBuilder.expireAfterWrite(this.writeExpirationDuration, timeUnit);
        }
        TimeUnit timeUnit2 = this.accessExpirationTimeUnit;
        if (timeUnit2 != null) {
            newBuilder.expireAfterAccess(this.accessExpirationDuration, timeUnit2);
        }
        TimeUnit timeUnit3 = this.refreshTimeUnit;
        if (timeUnit3 != null) {
            newBuilder.refreshAfterWrite(this.refreshDuration, timeUnit3);
        }
        return newBuilder;
    }

    public String toParsableString() {
        return this.specification;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
    }
}
