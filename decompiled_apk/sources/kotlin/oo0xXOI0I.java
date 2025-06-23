package kotlin;

import com.goodix.ble.gr.libdfu.BuildConfig;

/* loaded from: classes6.dex */
public class oo0xXOI0I extends xI {
    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final float I0(kotlin.jvm.internal.O0xOxO o0xOxO, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(o0xOxO, "<this>");
        return Float.intBitsToFloat(i);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final long IIX0(long j, int i) {
        return Long.rotateRight(j, i);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final double IIxOXoOo0(kotlin.jvm.internal.xoXoI xoxoi, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxoi, "<this>");
        return Double.longBitsToDouble(j);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final long IoIOOxIIo(double d) {
        return Double.doubleToLongBits(d);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int O0(int i) {
        return Integer.lowestOneBit(i);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int O00XxXI(int i) {
        return Integer.bitCount(i);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final int O0X(int i, int i2) {
        return Integer.rotateRight(i, i2);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int OOXIxO0(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    @xx0o0O.XO
    public static final boolean OX00O0xII(double d) {
        return Double.isInfinite(d);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final long Ox0O(long j) {
        return Long.highestOneBit(j);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int XI0oooXX(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    @xx0o0O.XO
    public static final boolean XIXIX(float f) {
        return Float.isNaN(f);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int XX0xXo(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final long o0oIxOo(double d) {
        return Double.doubleToRawLongBits(d);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int o0xxxXXxX(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final long oOo(long j, int i) {
        return Long.rotateLeft(j, i);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final int oXIO0o0XI(int i, int i2) {
        return Integer.rotateLeft(i, i2);
    }

    @xx0o0O.XO
    public static final boolean ooOx(double d) {
        if (!Double.isInfinite(d) && !Double.isNaN(d)) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int ox(long j) {
        return Long.bitCount(j);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final int oxIIX0o(float f) {
        return Float.floatToRawIntBits(f);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final int xI0oxI00(float f) {
        return Float.floatToIntBits(f);
    }

    @xx0o0O.XO
    public static final boolean xOOOX(double d) {
        return Double.isNaN(d);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int xOoOIoI(int i) {
        return Integer.highestOneBit(i);
    }

    @xx0o0O.XO
    public static final boolean xX0IIXIx0(float f) {
        return Float.isInfinite(f);
    }

    @xx0o0O.XO
    public static final boolean xoO0xx0(float f) {
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final long xx0X0(long j) {
        return Long.lowestOneBit(j);
    }
}
