package kotlin;

import com.goodix.ble.gr.libdfu.BuildConfig;

/* loaded from: classes6.dex */
public class IoOoX extends oo0xXOI0I {
    @IIX0(markerClass = {IXxxXO.class})
    @oxxXoxO(version = "1.6")
    public static final short IXO(short s, int i) {
        int i2 = i & 15;
        return (short) (((s & 65535) >>> (16 - i2)) | (s << i2));
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final short IoXIXo(short s) {
        return (short) Integer.highestOneBit(s & OX00O0xII.f29066Oxx0xo);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oxxXoxO(version = "1.6")
    public static final short Ix00oIoI(short s, int i) {
        int i2 = i & 15;
        return (short) (((s & 65535) >>> i2) | (s << (16 - i2)));
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int IxIX0I(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte O0IxXx(byte b) {
        return (byte) Integer.highestOneBit(b & 255);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int OIOoIIOIx(byte b) {
        return Integer.bitCount(b & 255);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int OoO(short s) {
        return Integer.numberOfLeadingZeros(s & OX00O0xII.f29066Oxx0xo) - 16;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int XIXIxO(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int XXoOx0(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oxxXoxO(version = "1.6")
    public static final byte oI(byte b, int i) {
        int i2 = i & 7;
        return (byte) (((b & 255) >>> i2) | (b << (8 - i2)));
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oxxXoxO(version = "1.6")
    public static final byte oOoIIO0(byte b, int i) {
        int i2 = i & 7;
        return (byte) (((b & 255) >>> (8 - i2)) | (b << i2));
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int x0OIX00oO(short s) {
        return Integer.bitCount(s & OX00O0xII.f29066Oxx0xo);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final short xXoOI00O(short s) {
        return (short) Integer.lowestOneBit(s);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte xxOXOOoIX(byte b) {
        return (byte) Integer.lowestOneBit(b);
    }
}
