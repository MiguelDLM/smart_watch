package androidx.collection;

import OXOo.OOXIXo;
import XO0OX.Oxx0IOOO;
import XO0OX.XO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleWatchFaceId;
import kotlin.jvm.internal.XX;
import kotlin.o0;

@XX({"SMAP\nFloatFloatPair.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatFloatPair.kt\nandroidx/collection/FloatFloatPair\n+ 2 PackingUtils.kt\nandroidx/collection/PackingUtilsKt\n+ 3 PackingHelpers.jvm.kt\nandroidx/collection/internal/PackingHelpers_jvmKt\n*L\n1#1,85:1\n48#1:93\n54#1:95\n24#2,3:86\n22#3:89\n22#3:90\n22#3:91\n22#3:92\n22#3:94\n*S KotlinDebug\n*F\n+ 1 FloatFloatPair.kt\nandroidx/collection/FloatFloatPair\n*L\n83#1:93\n83#1:95\n42#1:86,3\n48#1:89\n54#1:90\n67#1:91\n81#1:92\n83#1:94\n*E\n"})
@Oxx0IOOO
/* loaded from: classes.dex */
public final class FloatFloatPair {

    @XO
    public final long packedValue;

    private /* synthetic */ FloatFloatPair(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FloatFloatPair m0boximpl(long j) {
        return new FloatFloatPair(j);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m1component1impl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m2component2impl(long j) {
        return Float.intBitsToFloat((int) (j & BleWatchFaceId.WATCHFACE_ID_INVALID));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m4constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5equalsimpl(long j, Object obj) {
        return (obj instanceof FloatFloatPair) && j == ((FloatFloatPair) obj).m11unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final float m7getFirstimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    @o0
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final float m8getSecondimpl(long j) {
        return Float.intBitsToFloat((int) (j & BleWatchFaceId.WATCHFACE_ID_INVALID));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m9hashCodeimpl(long j) {
        return oIX0oI.oIX0oI(j);
    }

    @OOXIXo
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m10toStringimpl(long j) {
        return HexStringBuilder.COMMENT_BEGIN_CHAR + Float.intBitsToFloat((int) (j >> 32)) + ", " + Float.intBitsToFloat((int) (j & BleWatchFaceId.WATCHFACE_ID_INVALID)) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public boolean equals(Object obj) {
        return m5equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m9hashCodeimpl(this.packedValue);
    }

    @OOXIXo
    public String toString() {
        return m10toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m11unboximpl() {
        return this.packedValue;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m3constructorimpl(float f, float f2) {
        return m4constructorimpl((Float.floatToRawIntBits(f2) & BleWatchFaceId.WATCHFACE_ID_INVALID) | (Float.floatToRawIntBits(f) << 32));
    }
}
