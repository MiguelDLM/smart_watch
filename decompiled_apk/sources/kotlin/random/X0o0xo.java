package kotlin.random;

import OXOo.OOXIXo;
import X0.OxI;
import X0.XI0IXoo;
import com.szabh.smable3.entity.BleWatchFaceId;
import kotlin.IIX0;
import kotlin.OO0x0xX;
import kotlin.XI0oooXX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oI0IIXIo;
import kotlin.oxxXoxO;
import kotlin.xxIO;

@XX({"SMAP\nURandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URandom.kt\nkotlin/random/URandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
/* loaded from: classes6.dex */
public final class X0o0xo {
    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final byte[] I0Io(@OOXIXo Random random, int i) {
        IIX0o.x0xO0oo(random, "<this>");
        return OO0x0xX.X0o0xo(random.nextBytes(i));
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int II0XooXoX(@OOXIXo Random random, @OOXIXo OxI range) {
        int compare;
        int compare2;
        IIX0o.x0xO0oo(random, "<this>");
        IIX0o.x0xO0oo(range, "range");
        if (!range.isEmpty()) {
            compare = Integer.compare(range.X0o0xo() ^ Integer.MIN_VALUE, (-1) ^ Integer.MIN_VALUE);
            if (compare >= 0) {
                compare2 = Integer.compare(range.oxoX() ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                if (compare2 > 0) {
                    return xxIO.oOoXoXO(xxIXOIIO(random, xxIO.oOoXoXO(range.oxoX() - 1), range.X0o0xo()) + 1);
                }
                return Oxx0IOOO(random);
            }
            return xxIXOIIO(random, range.oxoX(), xxIO.oOoXoXO(range.X0o0xo() + 1));
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final void II0xO0(long j, long j2) {
        int compare;
        compare = Long.compare(j2 ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        if (compare > 0) {
        } else {
            throw new IllegalArgumentException(oxoX.I0Io(XI0oooXX.oxoX(j), XI0oooXX.oxoX(j2)).toString());
        }
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long OOXIXo(@OOXIXo Random random) {
        IIX0o.x0xO0oo(random, "<this>");
        return XI0oooXX.oOoXoXO(random.nextLong());
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int Oxx0IOOO(@OOXIXo Random random) {
        IIX0o.x0xO0oo(random, "<this>");
        return xxIO.oOoXoXO(random.nextInt());
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final byte[] X0o0xo(@OOXIXo Random nextUBytes, @OOXIXo byte[] array, int i, int i2) {
        IIX0o.x0xO0oo(nextUBytes, "$this$nextUBytes");
        IIX0o.x0xO0oo(array, "array");
        nextUBytes.nextBytes(array, i, i2);
        return array;
    }

    public static /* synthetic */ byte[] XO(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = OO0x0xX.ooOOo0oXI(bArr);
        }
        return X0o0xo(random, bArr, i, i2);
    }

    public static final void oIX0oI(int i, int i2) {
        int compare;
        compare = Integer.compare(i2 ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        if (compare > 0) {
        } else {
            throw new IllegalArgumentException(oxoX.I0Io(xxIO.oxoX(i), xxIO.oxoX(i2)).toString());
        }
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long oOoXoXO(@OOXIXo Random random, @OOXIXo XI0IXoo range) {
        int compare;
        int compare2;
        IIX0o.x0xO0oo(random, "<this>");
        IIX0o.x0xO0oo(range, "range");
        if (!range.isEmpty()) {
            compare = Long.compare(range.X0o0xo() ^ Long.MIN_VALUE, (-1) ^ Long.MIN_VALUE);
            if (compare >= 0) {
                compare2 = Long.compare(range.oxoX() ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE);
                if (compare2 > 0) {
                    long oxoX2 = range.oxoX();
                    long j = 1 & BleWatchFaceId.WATCHFACE_ID_INVALID;
                    return XI0oooXX.oOoXoXO(x0XOIxOo(random, XI0oooXX.oOoXoXO(oxoX2 - XI0oooXX.oOoXoXO(j)), range.X0o0xo()) + XI0oooXX.oOoXoXO(j));
                }
                return OOXIXo(random);
            }
            return x0XOIxOo(random, range.oxoX(), XI0oooXX.oOoXoXO(range.X0o0xo() + XI0oooXX.oOoXoXO(1 & BleWatchFaceId.WATCHFACE_ID_INVALID)));
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long ooOOo0oXI(@OOXIXo Random nextULong, long j) {
        IIX0o.x0xO0oo(nextULong, "$this$nextULong");
        return x0XOIxOo(nextULong, 0L, j);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final byte[] oxoX(@OOXIXo Random nextUBytes, @OOXIXo byte[] array) {
        IIX0o.x0xO0oo(nextUBytes, "$this$nextUBytes");
        IIX0o.x0xO0oo(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long x0XOIxOo(@OOXIXo Random nextULong, long j, long j2) {
        IIX0o.x0xO0oo(nextULong, "$this$nextULong");
        II0xO0(j, j2);
        return XI0oooXX.oOoXoXO(nextULong.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int xoIox(@OOXIXo Random nextUInt, int i) {
        IIX0o.x0xO0oo(nextUInt, "$this$nextUInt");
        return xxIXOIIO(nextUInt, 0, i);
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int xxIXOIIO(@OOXIXo Random nextUInt, int i, int i2) {
        IIX0o.x0xO0oo(nextUInt, "$this$nextUInt");
        oIX0oI(i, i2);
        return xxIO.oOoXoXO(nextUInt.nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }
}
