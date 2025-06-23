package kotlin.random;

import OXOo.OOXIXo;
import X0.oO;
import X0.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XX({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/RandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
/* loaded from: classes6.dex */
public final class oxoX {
    @OOXIXo
    public static final String I0Io(@OOXIXo Object from, @OOXIXo Object until) {
        IIX0o.x0xO0oo(from, "from");
        IIX0o.x0xO0oo(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    @oxxXoxO(version = "1.3")
    public static final int II0XooXoX(@OOXIXo Random random, @OOXIXo oOoXoXO range) {
        IIX0o.x0xO0oo(random, "<this>");
        IIX0o.x0xO0oo(range, "range");
        if (!range.isEmpty()) {
            if (range.X0o0xo() < Integer.MAX_VALUE) {
                return random.nextInt(range.oxoX(), range.X0o0xo() + 1);
            }
            if (range.oxoX() > Integer.MIN_VALUE) {
                return random.nextInt(range.oxoX() - 1, range.X0o0xo()) + 1;
            }
            return random.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @OOXIXo
    @oxxXoxO(version = "1.3")
    public static final Random II0xO0(long j) {
        return new XorWowRandom((int) j, (int) (j >> 32));
    }

    public static final int Oxx0IOOO(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final void X0o0xo(int i, int i2) {
        if (i2 > i) {
        } else {
            throw new IllegalArgumentException(I0Io(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final void XO(long j, long j2) {
        if (j2 > j) {
        } else {
            throw new IllegalArgumentException(I0Io(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    @OOXIXo
    @oxxXoxO(version = "1.3")
    public static final Random oIX0oI(int i) {
        return new XorWowRandom(i, i >> 31);
    }

    public static final void oxoX(double d, double d2) {
        if (d2 > d) {
        } else {
            throw new IllegalArgumentException(I0Io(Double.valueOf(d), Double.valueOf(d2)).toString());
        }
    }

    public static final int xoIox(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    @oxxXoxO(version = "1.3")
    public static final long xxIXOIIO(@OOXIXo Random random, @OOXIXo oO range) {
        IIX0o.x0xO0oo(random, "<this>");
        IIX0o.x0xO0oo(range, "range");
        if (!range.isEmpty()) {
            if (range.X0o0xo() < Long.MAX_VALUE) {
                return random.nextLong(range.oxoX(), range.X0o0xo() + 1);
            }
            if (range.oxoX() > Long.MIN_VALUE) {
                return random.nextLong(range.oxoX() - 1, range.X0o0xo()) + 1;
            }
            return random.nextLong();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }
}
