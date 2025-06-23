package kotlinx.serialization.internal;

import kotlin.collections.ArraysKt___ArraysKt;

@O0xOxO
/* loaded from: classes6.dex */
public final class XxX0x0xxx {

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f30715X0o0xo = new oIX0oI(null);

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final long[] f30716XO = new long[0];

    /* renamed from: I0Io, reason: collision with root package name */
    public long f30717I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.x0xO0oo<kotlinx.serialization.descriptors.XO, Integer, Boolean> f30718II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30719oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final long[] f30720oxoX;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XxX0x0xxx(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, @OXOo.OOXIXo Oox.x0xO0oo<? super kotlinx.serialization.descriptors.XO, ? super Integer, Boolean> readIfAbsent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        kotlin.jvm.internal.IIX0o.x0xO0oo(readIfAbsent, "readIfAbsent");
        this.f30719oIX0oI = descriptor;
        this.f30718II0xO0 = readIfAbsent;
        int XO2 = descriptor.XO();
        if (XO2 <= 64) {
            this.f30717I0Io = XO2 != 64 ? (-1) << XO2 : 0L;
            this.f30720oxoX = f30716XO;
        } else {
            this.f30717I0Io = 0L;
            this.f30720oxoX = X0o0xo(XO2);
        }
    }

    public final int I0Io() {
        int length = this.f30720oxoX.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = i2 * 64;
            long j = this.f30720oxoX[i];
            while (j != -1) {
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(~j);
                j |= 1 << numberOfTrailingZeros;
                int i4 = numberOfTrailingZeros + i3;
                if (this.f30718II0xO0.invoke(this.f30719oIX0oI, Integer.valueOf(i4)).booleanValue()) {
                    this.f30720oxoX[i] = j;
                    return i4;
                }
            }
            this.f30720oxoX[i] = j;
            i = i2;
        }
        return -1;
    }

    public final void II0xO0(int i) {
        int i2 = (i >>> 6) - 1;
        long[] jArr = this.f30720oxoX;
        jArr[i2] = jArr[i2] | (1 << (i & 63));
    }

    public final long[] X0o0xo(int i) {
        long[] jArr = new long[(i - 1) >>> 6];
        if ((i & 63) != 0) {
            jArr[ArraysKt___ArraysKt.IOXI(jArr)] = (-1) << i;
        }
        return jArr;
    }

    public final void oIX0oI(int i) {
        if (i < 64) {
            this.f30717I0Io |= 1 << i;
        } else {
            II0xO0(i);
        }
    }

    public final int oxoX() {
        int numberOfTrailingZeros;
        int XO2 = this.f30719oIX0oI.XO();
        do {
            long j = this.f30717I0Io;
            if (j != -1) {
                numberOfTrailingZeros = Long.numberOfTrailingZeros(~j);
                this.f30717I0Io |= 1 << numberOfTrailingZeros;
            } else {
                if (XO2 > 64) {
                    return I0Io();
                }
                return -1;
            }
        } while (!this.f30718II0xO0.invoke(this.f30719oIX0oI, Integer.valueOf(numberOfTrailingZeros)).booleanValue());
        return numberOfTrailingZeros;
    }
}
