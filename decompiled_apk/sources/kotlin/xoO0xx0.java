package kotlin;

@XO0OX.xxIXOIIO(name = "UNumbersKt")
/* loaded from: classes6.dex */
public final class xoO0xx0 {
    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int I0Io(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int II0XooXoX(short s) {
        return Integer.bitCount(xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int II0xO0(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final long IIXOooo(long j) {
        return XI0oooXX.oOoXoXO(Long.highestOneBit(j));
    }

    @IIX0(markerClass = {IXxxXO.class, oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final byte IXxxXO(byte b, int i) {
        return x0xO.oOoXoXO(IoOoX.oI(b, i));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final long O0xOxO(long j) {
        return XI0oooXX.oOoXoXO(Long.lowestOneBit(j));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int OOXIXo(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    @IIX0(markerClass = {IXxxXO.class, oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final long Oo(long j, int i) {
        return XI0oooXX.oOoXoXO(Long.rotateRight(j, i));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final byte OxI(byte b) {
        return x0xO.oOoXoXO((byte) Integer.lowestOneBit(b & 255));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int Oxx0IOOO(int i) {
        return Integer.bitCount(i);
    }

    @IIX0(markerClass = {IXxxXO.class, oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final int Oxx0xo(int i, int i2) {
        return xxIO.oOoXoXO(Integer.rotateRight(i, i2));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final byte OxxIIOOXO(byte b) {
        return x0xO.oOoXoXO((byte) Integer.highestOneBit(b & 255));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int X0IIOO(int i) {
        return xxIO.oOoXoXO(Integer.lowestOneBit(i));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int X0o0xo(byte b) {
        return Integer.bitCount(xxIO.oOoXoXO(b & 255));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final short XI0IXoo(short s) {
        return OX00O0xII.oOoXoXO((short) Integer.lowestOneBit(s & OX00O0xII.f29066Oxx0xo));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int XO(long j) {
        return Long.bitCount(j);
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final short o00(short s) {
        return OX00O0xII.oOoXoXO((short) Integer.highestOneBit(s & OX00O0xII.f29066Oxx0xo));
    }

    @IIX0(markerClass = {IXxxXO.class, oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final short oI0IIXIo(short s, int i) {
        return OX00O0xII.oOoXoXO(IoOoX.Ix00oIoI(s, i));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int oIX0oI(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    @IIX0(markerClass = {IXxxXO.class, oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final int oO(int i, int i2) {
        return xxIO.oOoXoXO(Integer.rotateLeft(i, i2));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int oOoXoXO(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @IIX0(markerClass = {IXxxXO.class, oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final long ooOOo0oXI(long j, int i) {
        return XI0oooXX.oOoXoXO(Long.rotateLeft(j, i));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int oxoX(short s) {
        return Integer.numberOfLeadingZeros(s & OX00O0xII.f29066Oxx0xo) - 16;
    }

    @IIX0(markerClass = {IXxxXO.class, oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final byte x0XOIxOo(byte b, int i) {
        return x0xO.oOoXoXO(IoOoX.oOoIIO0(b, i));
    }

    @IIX0(markerClass = {IXxxXO.class, oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final short x0xO0oo(short s, int i) {
        return OX00O0xII.oOoXoXO(IoOoX.IXO(s, i));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int xoIox(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int xoXoI(int i) {
        return xxIO.oOoXoXO(Integer.highestOneBit(i));
    }

    @IIX0(markerClass = {oI0IIXIo.class, IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int xxIXOIIO(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }
}
