package androidx.collection;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import kotlin.Pair;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;

@XX({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1850:1\n1661#1:1851\n1661#1:1852\n1661#1:1853\n1715#1:1854\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1680#1:1851\n1682#1:1852\n1685#1:1853\n1721#1:1854\n*E\n"})
public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;
    @XO
    @OOXIXo
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};
    @OOXIXo
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    @OOXIXo
    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap mutableScatterMap = EmptyScatterMap;
        IIX0o.x0XOIxOo(mutableScatterMap, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return mutableScatterMap;
    }

    public static final int get(long j) {
        return Long.numberOfTrailingZeros(j) >> 3;
    }

    @o0
    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    @o0
    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    @o0
    public static /* synthetic */ void getSentinel$annotations() {
    }

    public static final long group(@OOXIXo long[] jArr, int i) {
        IIX0o.x0xO0oo(jArr, TtmlNode.TAG_METADATA);
        int i2 = i >> 3;
        int i3 = (i & 7) << 3;
        return (((-((long) i3)) >> 63) & (jArr[i2 + 1] << (64 - i3))) | (jArr[i2] >>> i3);
    }

    public static final int h1(int i) {
        return i >>> 7;
    }

    public static final int h2(int i) {
        return i & 127;
    }

    public static final boolean hasNext(long j) {
        return j != 0;
    }

    public static final int hash(@oOoXoXO Object obj) {
        int i;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        int i2 = i * MurmurHashC1;
        return i2 ^ (i2 << 16);
    }

    public static final boolean isDeleted(@OOXIXo long[] jArr, int i) {
        IIX0o.x0xO0oo(jArr, TtmlNode.TAG_METADATA);
        if (((jArr[i >> 3] >> ((i & 7) << 3)) & 255) == 254) {
            return true;
        }
        return false;
    }

    public static final boolean isEmpty(@OOXIXo long[] jArr, int i) {
        IIX0o.x0xO0oo(jArr, TtmlNode.TAG_METADATA);
        if (((jArr[i >> 3] >> ((i & 7) << 3)) & 255) == 128) {
            return true;
        }
        return false;
    }

    @o0
    public static final boolean isFull(long j) {
        return j < 128;
    }

    public static final int loadedCapacity(int i) {
        if (i == 7) {
            return 6;
        }
        return i - (i / 8);
    }

    @o0
    public static final int lowestBitSet(long j) {
        return Long.numberOfTrailingZeros(j) >> 3;
    }

    public static final long maskEmpty(long j) {
        return j & ((~j) << 6) & -9187201950435737472L;
    }

    @o0
    public static final long maskEmptyOrDeleted(long j) {
        return j & ((~j) << 7) & -9187201950435737472L;
    }

    @o0
    public static final long match(long j, int i) {
        long j2 = j ^ (((long) i) * BitmaskLsb);
        return (~j2) & (j2 - BitmaskLsb) & -9187201950435737472L;
    }

    @OOXIXo
    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, (IIXOooo) null);
    }

    public static final long next(long j) {
        return j & (j - 1);
    }

    public static final int nextCapacity(int i) {
        if (i == 0) {
            return 6;
        }
        return (i * 2) + 1;
    }

    public static final int normalizeCapacity(int i) {
        if (i > 0) {
            return -1 >>> Integer.numberOfLeadingZeros(i);
        }
        return 0;
    }

    @o0
    public static final long readRawMetadata(@OOXIXo long[] jArr, int i) {
        IIX0o.x0xO0oo(jArr, "data");
        return (jArr[i >> 3] >> ((i & 7) << 3)) & 255;
    }

    public static final int unloadedCapacity(int i) {
        if (i == 7) {
            return 8;
        }
        return i + ((i - 1) / 7);
    }

    public static final void writeRawMetadata(@OOXIXo long[] jArr, int i, long j) {
        IIX0o.x0xO0oo(jArr, "data");
        int i2 = i >> 3;
        int i3 = (i & 7) << 3;
        jArr[i2] = (j << i3) | (jArr[i2] & (~(255 << i3)));
    }

    public static final boolean isFull(@OOXIXo long[] jArr, int i) {
        IIX0o.x0xO0oo(jArr, TtmlNode.TAG_METADATA);
        return ((jArr[i >> 3] >> ((i & 7) << 3)) & 255) < 128;
    }

    @OOXIXo
    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(@OOXIXo Pair<? extends K, ? extends V>... pairArr) {
        IIX0o.x0xO0oo(pairArr, "pairs");
        MutableScatterMap<K, V> mutableScatterMap = new MutableScatterMap<>(pairArr.length);
        mutableScatterMap.putAll(pairArr);
        return mutableScatterMap;
    }
}
