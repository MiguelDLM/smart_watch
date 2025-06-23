package kotlin.time;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.IIX0;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;
import kotlin.time.I0Io;
import kotlin.time.IXxxXO;

@IIX0(markerClass = {xoIox.class})
@oxxXoxO(version = "1.9")
/* loaded from: classes6.dex */
public abstract class AbstractLongTimeSource implements IXxxXO.I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0IIOO f29621I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final DurationUnit f29622II0xO0;

    @XX({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,199:1\n80#2:200\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n*L\n67#1:200\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI implements I0Io {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final long f29623IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final AbstractLongTimeSource f29624Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final long f29625XO;

        public /* synthetic */ oIX0oI(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, IIXOooo iIXOooo) {
            this(j, abstractLongTimeSource, j2);
        }

        @Override // kotlin.time.x0xO0oo
        public long I0Io() {
            return oxoX.Xo0(OOXIXo.II0XooXoX(this.f29624Oo.I0Io(), this.f29625XO, this.f29624Oo.oxoX()), this.f29623IXxxXO);
        }

        @Override // kotlin.time.x0xO0oo
        @OXOo.OOXIXo
        public I0Io II0xO0(long j) {
            return I0Io.oIX0oI.oxoX(this, j);
        }

        @Override // kotlin.time.I0Io
        public long X0o0xo(@OXOo.OOXIXo I0Io other) {
            IIX0o.x0xO0oo(other, "other");
            if (other instanceof oIX0oI) {
                oIX0oI oix0oi = (oIX0oI) other;
                if (IIX0o.Oxx0IOOO(this.f29624Oo, oix0oi.f29624Oo)) {
                    return oxoX.XoI0Ixx0(OOXIXo.II0XooXoX(this.f29625XO, oix0oi.f29625XO, this.f29624Oo.oxoX()), oxoX.Xo0(this.f29623IXxxXO, oix0oi.f29623IXxxXO));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.x0xO0oo
        public boolean XO() {
            return I0Io.oIX0oI.I0Io(this);
        }

        @Override // kotlin.time.I0Io
        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if ((obj instanceof oIX0oI) && IIX0o.Oxx0IOOO(this.f29624Oo, ((oIX0oI) obj).f29624Oo) && oxoX.IXxxXO(X0o0xo((I0Io) obj), oxoX.f29647Oo.XX())) {
                return true;
            }
            return false;
        }

        @Override // kotlin.time.I0Io
        public int hashCode() {
            return (oxoX.XoX(this.f29623IXxxXO) * 37) + androidx.collection.oIX0oI.oIX0oI(this.f29625XO);
        }

        @Override // kotlin.time.x0xO0oo
        public boolean oxoX() {
            return I0Io.oIX0oI.II0xO0(this);
        }

        @OXOo.OOXIXo
        public String toString() {
            return "LongTimeMark(" + this.f29625XO + xxIXOIIO.II0XooXoX(this.f29624Oo.oxoX()) + " + " + ((Object) oxoX.o0xxxXXxX(this.f29623IXxxXO)) + ", " + this.f29624Oo + HexStringBuilder.COMMENT_END_CHAR;
        }

        @Override // java.lang.Comparable
        /* renamed from: xxIXOIIO */
        public int compareTo(@OXOo.OOXIXo I0Io i0Io) {
            return I0Io.oIX0oI.oIX0oI(this, i0Io);
        }

        public oIX0oI(long j, AbstractLongTimeSource timeSource, long j2) {
            IIX0o.x0xO0oo(timeSource, "timeSource");
            this.f29625XO = j;
            this.f29624Oo = timeSource;
            this.f29623IXxxXO = j2;
        }

        @Override // kotlin.time.x0xO0oo
        @OXOo.OOXIXo
        public I0Io oIX0oI(long j) {
            DurationUnit oxoX2 = this.f29624Oo.oxoX();
            if (oxoX.XX0(j)) {
                return new oIX0oI(OOXIXo.oxoX(this.f29625XO, oxoX2, j), this.f29624Oo, oxoX.f29647Oo.XX(), null);
            }
            long XI0oooXX2 = oxoX.XI0oooXX(j, oxoX2);
            long XoI0Ixx02 = oxoX.XoI0Ixx0(oxoX.Xo0(j, XI0oooXX2), this.f29623IXxxXO);
            long oxoX3 = OOXIXo.oxoX(this.f29625XO, oxoX2, XI0oooXX2);
            long XI0oooXX3 = oxoX.XI0oooXX(XoI0Ixx02, oxoX2);
            long oxoX4 = OOXIXo.oxoX(oxoX3, oxoX2, XI0oooXX3);
            long Xo02 = oxoX.Xo0(XoI0Ixx02, XI0oooXX3);
            long X00IoxXI2 = oxoX.X00IoxXI(Xo02);
            if (oxoX4 != 0 && X00IoxXI2 != 0 && (oxoX4 ^ X00IoxXI2) < 0) {
                long IoOoo2 = XO.IoOoo(oOIx.oxoX.o0(X00IoxXI2), oxoX2);
                oxoX4 = OOXIXo.oxoX(oxoX4, oxoX2, IoOoo2);
                Xo02 = oxoX.Xo0(Xo02, IoOoo2);
            }
            if ((1 | (oxoX4 - 1)) == Long.MAX_VALUE) {
                Xo02 = oxoX.f29647Oo.XX();
            }
            return new oIX0oI(oxoX4, this.f29624Oo, Xo02, null);
        }
    }

    public AbstractLongTimeSource(@OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        this.f29622II0xO0 = unit;
        this.f29621I0Io = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Long>() { // from class: kotlin.time.AbstractLongTimeSource$zero$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Long invoke() {
                return Long.valueOf(AbstractLongTimeSource.this.XO());
            }
        });
    }

    public final long I0Io() {
        return XO() - X0o0xo();
    }

    public final long X0o0xo() {
        return ((Number) this.f29621I0Io.getValue()).longValue();
    }

    public abstract long XO();

    @OXOo.OOXIXo
    public final DurationUnit oxoX() {
        return this.f29622II0xO0;
    }

    @Override // kotlin.time.IXxxXO
    @OXOo.OOXIXo
    public I0Io oIX0oI() {
        return new oIX0oI(I0Io(), this, oxoX.f29647Oo.XX(), null);
    }
}
