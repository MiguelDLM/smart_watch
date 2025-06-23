package androidx.collection;

import OXOo.OOXIXo;
import XO0OX.Oxx0IOOO;
import XO0OX.XO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleWatchFaceId;
import kotlin.jvm.internal.XX;
import kotlin.o0;

@Oxx0IOOO
@XX({"SMAP\nIntIntPair.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntIntPair.kt\nandroidx/collection/IntIntPair\n+ 2 PackingUtils.kt\nandroidx/collection/PackingUtilsKt\n*L\n1#1,83:1\n33#2:84\n*S KotlinDebug\n*F\n+ 1 IntIntPair.kt\nandroidx/collection/IntIntPair\n*L\n41#1:84\n*E\n"})
public final class IntIntPair {
    @XO
    public final long packedValue;

    private /* synthetic */ IntIntPair(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IntIntPair m12boximpl(long j) {
        return new IntIntPair(j);
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m13component1impl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final int m14component2impl(long j) {
        return (int) (j & BleWatchFaceId.WATCHFACE_ID_INVALID);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m16constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m17equalsimpl(long j, Object obj) {
        return (obj instanceof IntIntPair) && j == ((IntIntPair) obj).m23unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m18equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getFirst-impl  reason: not valid java name */
    public static final int m19getFirstimpl(long j) {
        return (int) (j >> 32);
    }

    @o0
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getSecond-impl  reason: not valid java name */
    public static final int m20getSecondimpl(long j) {
        return (int) (j & BleWatchFaceId.WATCHFACE_ID_INVALID);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m21hashCodeimpl(long j) {
        return oIX0oI.oIX0oI(j);
    }

    @OOXIXo
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m22toStringimpl(long j) {
        return HexStringBuilder.COMMENT_BEGIN_CHAR + m19getFirstimpl(j) + ", " + m20getSecondimpl(j) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public boolean equals(Object obj) {
        return m17equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m21hashCodeimpl(this.packedValue);
    }

    @OOXIXo
    public String toString() {
        return m22toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m23unboximpl() {
        return this.packedValue;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m15constructorimpl(int i, int i2) {
        return m16constructorimpl((((long) i2) & BleWatchFaceId.WATCHFACE_ID_INVALID) | (((long) i) << 32));
    }
}
