package X0;

/* loaded from: classes6.dex */
public final class x0xO0oo implements Oxx0xo<Double> {

    /* renamed from: Oo, reason: collision with root package name */
    public final double f3219Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final double f3220XO;

    public x0xO0oo(double d, double d2) {
        this.f3220XO = d;
        this.f3219Oo = d2;
    }

    private final boolean X0o0xo(double d, double d2) {
        if (d <= d2) {
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public Double II0xO0() {
        return Double.valueOf(this.f3219Oo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // X0.Oxx0xo
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return oIX0oI(((Number) comparable).doubleValue());
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof x0xO0oo) {
            if (!isEmpty() || !((x0xO0oo) obj).isEmpty()) {
                x0xO0oo x0xo0oo = (x0xO0oo) obj;
                if (this.f3220XO != x0xo0oo.f3220XO || this.f3219Oo != x0xo0oo.f3219Oo) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (ooXIXxIX.oIX0oI.oIX0oI(this.f3220XO) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.f3219Oo);
    }

    @Override // X0.Oxx0xo
    public boolean isEmpty() {
        if (this.f3220XO >= this.f3219Oo) {
            return true;
        }
        return false;
    }

    public boolean oIX0oI(double d) {
        if (d >= this.f3220XO && d < this.f3219Oo) {
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public Double getStart() {
        return Double.valueOf(this.f3220XO);
    }

    @OXOo.OOXIXo
    public String toString() {
        return this.f3220XO + "..<" + this.f3219Oo;
    }
}
