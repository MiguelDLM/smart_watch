package kotlin.time;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oxxXoxO;
import kotlin.time.I0Io;
import kotlin.time.IXxxXO;

@kotlin.OOXIXo(message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@xoIox
@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public abstract class oIX0oI implements IXxxXO.I0Io {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final DurationUnit f29641II0xO0;

    /* renamed from: kotlin.time.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1111oIX0oI implements I0Io {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final long f29642IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final oIX0oI f29643Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final double f29644XO;

        public /* synthetic */ C1111oIX0oI(double d, oIX0oI oix0oi, long j, IIXOooo iIXOooo) {
            this(d, oix0oi, j);
        }

        @Override // kotlin.time.x0xO0oo
        public long I0Io() {
            return oxoX.Xo0(XO.OO(this.f29643Oo.I0Io() - this.f29644XO, this.f29643Oo.II0xO0()), this.f29642IXxxXO);
        }

        @Override // kotlin.time.x0xO0oo
        @OXOo.OOXIXo
        public I0Io II0xO0(long j) {
            return I0Io.oIX0oI.oxoX(this, j);
        }

        @Override // kotlin.time.I0Io
        public long X0o0xo(@OXOo.OOXIXo I0Io other) {
            IIX0o.x0xO0oo(other, "other");
            if (other instanceof C1111oIX0oI) {
                C1111oIX0oI c1111oIX0oI = (C1111oIX0oI) other;
                if (IIX0o.Oxx0IOOO(this.f29643Oo, c1111oIX0oI.f29643Oo)) {
                    if (oxoX.IXxxXO(this.f29642IXxxXO, c1111oIX0oI.f29642IXxxXO) && oxoX.XX0(this.f29642IXxxXO)) {
                        return oxoX.f29647Oo.XX();
                    }
                    long Xo02 = oxoX.Xo0(this.f29642IXxxXO, c1111oIX0oI.f29642IXxxXO);
                    long OO2 = XO.OO(this.f29644XO - c1111oIX0oI.f29644XO, this.f29643Oo.II0xO0());
                    if (oxoX.IXxxXO(OO2, oxoX.OOXIxO0(Xo02))) {
                        return oxoX.f29647Oo.XX();
                    }
                    return oxoX.XoI0Ixx0(OO2, Xo02);
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
            if ((obj instanceof C1111oIX0oI) && IIX0o.Oxx0IOOO(this.f29643Oo, ((C1111oIX0oI) obj).f29643Oo) && oxoX.IXxxXO(X0o0xo((I0Io) obj), oxoX.f29647Oo.XX())) {
                return true;
            }
            return false;
        }

        @Override // kotlin.time.I0Io
        public int hashCode() {
            return oxoX.XoX(oxoX.XoI0Ixx0(XO.OO(this.f29644XO, this.f29643Oo.II0xO0()), this.f29642IXxxXO));
        }

        @Override // kotlin.time.x0xO0oo
        public boolean oxoX() {
            return I0Io.oIX0oI.II0xO0(this);
        }

        @OXOo.OOXIXo
        public String toString() {
            return "DoubleTimeMark(" + this.f29644XO + xxIXOIIO.II0XooXoX(this.f29643Oo.II0xO0()) + " + " + ((Object) oxoX.o0xxxXXxX(this.f29642IXxxXO)) + ", " + this.f29643Oo + HexStringBuilder.COMMENT_END_CHAR;
        }

        @Override // java.lang.Comparable
        /* renamed from: xxIXOIIO */
        public int compareTo(@OXOo.OOXIXo I0Io i0Io) {
            return I0Io.oIX0oI.oIX0oI(this, i0Io);
        }

        public C1111oIX0oI(double d, oIX0oI timeSource, long j) {
            IIX0o.x0xO0oo(timeSource, "timeSource");
            this.f29644XO = d;
            this.f29643Oo = timeSource;
            this.f29642IXxxXO = j;
        }

        @Override // kotlin.time.x0xO0oo
        @OXOo.OOXIXo
        public I0Io oIX0oI(long j) {
            return new C1111oIX0oI(this.f29644XO, this.f29643Oo, oxoX.XoI0Ixx0(this.f29642IXxxXO, j), null);
        }
    }

    public oIX0oI(@OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        this.f29641II0xO0 = unit;
    }

    public abstract double I0Io();

    @OXOo.OOXIXo
    public final DurationUnit II0xO0() {
        return this.f29641II0xO0;
    }

    @Override // kotlin.time.IXxxXO
    @OXOo.OOXIXo
    public I0Io oIX0oI() {
        return new C1111oIX0oI(I0Io(), this, oxoX.f29647Oo.XX(), null);
    }
}
