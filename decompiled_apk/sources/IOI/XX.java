package IOI;

import IOI.IIX0o;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.time.I0Io;

@kotlin.time.xoIox
/* loaded from: classes6.dex */
public final class XX implements kotlin.time.I0Io {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oIX0oI f482Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final IIX0o f483XO;

    public XX(@OXOo.OOXIXo IIX0o instant, @OXOo.OOXIXo oIX0oI clock) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(instant, "instant");
        kotlin.jvm.internal.IIX0o.x0xO0oo(clock, "clock");
        this.f483XO = instant;
        this.f482Oo = clock;
    }

    @Override // kotlin.time.x0xO0oo
    public long I0Io() {
        return OOXIXo(this.f482Oo.oIX0oI(), this.f483XO);
    }

    @Override // kotlin.time.I0Io
    /* renamed from: II0XooXoX, reason: merged with bridge method [inline-methods] */
    public long X0o0xo(@OXOo.OOXIXo kotlin.time.I0Io other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        if (other instanceof XX) {
            XX xx2 = (XX) other;
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(xx2.f482Oo, this.f482Oo)) {
                return OOXIXo(this.f483XO, xx2.f483XO);
            }
        }
        throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
    }

    public final long OOXIXo(IIX0o iIX0o, IIX0o iIX0o2) {
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(iIX0o, iIX0o2)) {
            return kotlin.time.oxoX.f29647Oo.XX();
        }
        if (!Oxx0IOOO(iIX0o) && !Oxx0IOOO(iIX0o2)) {
            return iIX0o.ooOOo0oXI(iIX0o2);
        }
        return kotlin.time.oxoX.O0Xx(iIX0o.ooOOo0oXI(iIX0o2), Double.POSITIVE_INFINITY);
    }

    public final boolean Oxx0IOOO(IIX0o iIX0o) {
        IIX0o.oIX0oI oix0oi = IIX0o.Companion;
        if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(iIX0o, oix0oi.II0XooXoX()) && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(iIX0o, oix0oi.xxIXOIIO())) {
            return false;
        }
        return true;
    }

    @Override // kotlin.time.x0xO0oo
    public boolean XO() {
        return I0Io.oIX0oI.I0Io(this);
    }

    @Override // kotlin.time.I0Io
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof XX) {
            XX xx2 = (XX) obj;
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f482Oo, xx2.f482Oo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f483XO, xx2.f483XO)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.time.I0Io
    public int hashCode() {
        return this.f483XO.hashCode();
    }

    @Override // kotlin.time.x0xO0oo
    public boolean oxoX() {
        return I0Io.oIX0oI.II0xO0(this);
    }

    @OXOo.OOXIXo
    public String toString() {
        return "InstantTimeMark(" + this.f483XO + ", " + this.f482Oo + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final IIX0o xoIox(IIX0o iIX0o, long j) {
        if (Oxx0IOOO(iIX0o)) {
            if (kotlin.time.oxoX.XX0(j) && kotlin.time.oxoX.oX(j) != o0.II0xO0(iIX0o)) {
                throw new IllegalArgumentException("Summing infinities of different signs");
            }
            return iIX0o;
        }
        return iIX0o.oO(j);
    }

    @Override // java.lang.Comparable
    /* renamed from: xxIXOIIO */
    public int compareTo(@OXOo.OOXIXo kotlin.time.I0Io i0Io) {
        return I0Io.oIX0oI.oIX0oI(this, i0Io);
    }

    @Override // kotlin.time.x0xO0oo
    @OXOo.OOXIXo
    public kotlin.time.I0Io II0xO0(long j) {
        return new XX(xoIox(this.f483XO, kotlin.time.oxoX.OOXIxO0(j)), this.f482Oo);
    }

    @Override // kotlin.time.x0xO0oo
    @OXOo.OOXIXo
    public kotlin.time.I0Io oIX0oI(long j) {
        return new XX(xoIox(this.f483XO, j), this.f482Oo);
    }
}
