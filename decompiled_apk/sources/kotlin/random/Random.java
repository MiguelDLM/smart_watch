package kotlin.random;

import OXOo.OOXIXo;
import X0.oOoXoXO;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;
import xx0o0O.ooOOo0oXI;

@XX({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/Random\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public abstract class Random {

    @OOXIXo
    public static final Default Default = new Default(null);

    @OOXIXo
    private static final Random defaultRandom = ooOOo0oXI.f35291oIX0oI.II0xO0();

    /* loaded from: classes6.dex */
    public static final class Default extends Random implements Serializable {

        /* loaded from: classes6.dex */
        public static final class Serialized implements Serializable {

            @OOXIXo
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        public /* synthetic */ Default(IIXOooo iIXOooo) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int i) {
            return Random.defaultRandom.nextBits(i);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        @OOXIXo
        public byte[] nextBytes(@OOXIXo byte[] array) {
            IIX0o.x0xO0oo(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        private Default() {
        }

        @Override // kotlin.random.Random
        @OOXIXo
        public byte[] nextBytes(int i) {
            return Random.defaultRandom.nextBytes(i);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d) {
            return Random.defaultRandom.nextDouble(d);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i) {
            return Random.defaultRandom.nextInt(i);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j) {
            return Random.defaultRandom.nextLong(j);
        }

        @Override // kotlin.random.Random
        @OOXIXo
        public byte[] nextBytes(@OOXIXo byte[] array, int i, int i2) {
            IIX0o.x0xO0oo(array, "array");
            return Random.defaultRandom.nextBytes(array, i, i2);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d, double d2) {
            return Random.defaultRandom.nextDouble(d, d2);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i, int i2) {
            return Random.defaultRandom.nextInt(i, i2);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j, long j2) {
            return Random.defaultRandom.nextLong(j, j2);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return random.nextBytes(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int i);

    public boolean nextBoolean() {
        if (nextBits(1) != 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public byte[] nextBytes(@OOXIXo byte[] array, int i, int i2) {
        IIX0o.x0xO0oo(array, "array");
        if (!new oOoXoXO(0, array.length).xxIXOIIO(i) || !new oOoXoXO(0, array.length).xxIXOIIO(i2)) {
            throw new IllegalArgumentException(("fromIndex (" + i + ") or toIndex (" + i2 + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (i <= i2) {
            int i3 = (i2 - i) / 4;
            for (int i4 = 0; i4 < i3; i4++) {
                int nextInt = nextInt();
                array[i] = (byte) nextInt;
                array[i + 1] = (byte) (nextInt >>> 8);
                array[i + 2] = (byte) (nextInt >>> 16);
                array[i + 3] = (byte) (nextInt >>> 24);
                i += 4;
            }
            int i5 = i2 - i;
            int nextBits = nextBits(i5 * 8);
            for (int i6 = 0; i6 < i5; i6++) {
                array[i + i6] = (byte) (nextBits >>> (i6 * 8));
            }
            return array;
        }
        throw new IllegalArgumentException(("fromIndex (" + i + ") must be not greater than toIndex (" + i2 + ").").toString());
    }

    public double nextDouble() {
        return I0Io.oxoX(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public double nextDouble(double d) {
        return nextDouble(XIXIX.OOXIXo.f3760XO, d);
    }

    public int nextInt(int i) {
        return nextInt(0, i);
    }

    public long nextLong(long j) {
        return nextLong(0L, j);
    }

    public double nextDouble(double d, double d2) {
        double nextDouble;
        oxoX.oxoX(d, d2);
        double d3 = d2 - d;
        if (Double.isInfinite(d3) && !Double.isInfinite(d) && !Double.isNaN(d) && !Double.isInfinite(d2) && !Double.isNaN(d2)) {
            double d4 = 2;
            double nextDouble2 = nextDouble() * ((d2 / d4) - (d / d4));
            nextDouble = d + nextDouble2 + nextDouble2;
        } else {
            nextDouble = d + (nextDouble() * d3);
        }
        return nextDouble >= d2 ? Math.nextAfter(d2, Double.NEGATIVE_INFINITY) : nextDouble;
    }

    public int nextInt(int i, int i2) {
        int nextInt;
        int i3;
        int i4;
        oxoX.X0o0xo(i, i2);
        int i5 = i2 - i;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                i4 = nextBits(oxoX.Oxx0IOOO(i5));
                return i + i4;
            }
            do {
                nextInt = nextInt() >>> 1;
                i3 = nextInt % i5;
            } while ((nextInt - i3) + (i5 - 1) < 0);
            i4 = i3;
            return i + i4;
        }
        while (true) {
            int nextInt2 = nextInt();
            if (i <= nextInt2 && nextInt2 < i2) {
                return nextInt2;
            }
        }
    }

    public long nextLong(long j, long j2) {
        long nextLong;
        long j3;
        long j4;
        int nextInt;
        oxoX.XO(j, j2);
        long j5 = j2 - j;
        if (j5 > 0) {
            if (((-j5) & j5) == j5) {
                int i = (int) j5;
                int i2 = (int) (j5 >>> 32);
                if (i != 0) {
                    nextInt = nextBits(oxoX.Oxx0IOOO(i));
                } else if (i2 == 1) {
                    nextInt = nextInt();
                } else {
                    j4 = (nextBits(oxoX.Oxx0IOOO(i2)) << 32) + (nextInt() & BleWatchFaceId.WATCHFACE_ID_INVALID);
                    return j + j4;
                }
                j4 = nextInt & BleWatchFaceId.WATCHFACE_ID_INVALID;
                return j + j4;
            }
            do {
                nextLong = nextLong() >>> 1;
                j3 = nextLong % j5;
            } while ((nextLong - j3) + (j5 - 1) < 0);
            j4 = j3;
            return j + j4;
        }
        while (true) {
            long nextLong2 = nextLong();
            if (j <= nextLong2 && nextLong2 < j2) {
                return nextLong2;
            }
        }
    }

    @OOXIXo
    public byte[] nextBytes(@OOXIXo byte[] array) {
        IIX0o.x0xO0oo(array, "array");
        return nextBytes(array, 0, array.length);
    }

    @OOXIXo
    public byte[] nextBytes(int i) {
        return nextBytes(new byte[i]);
    }
}
