package X0;

/* loaded from: classes6.dex */
public final class oxoX implements XO<Double> {

    /* renamed from: Oo, reason: collision with root package name */
    public final double f3213Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final double f3214XO;

    public oxoX(double d, double d2) {
        this.f3214XO = d;
        this.f3213Oo = d2;
    }

    @Override // X0.Oxx0IOOO
    @OXOo.OOXIXo
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public Double getEndInclusive() {
        return Double.valueOf(this.f3213Oo);
    }

    public boolean II0xO0(double d) {
        if (d >= this.f3214XO && d <= this.f3213Oo) {
            return true;
        }
        return false;
    }

    public boolean X0o0xo(double d, double d2) {
        if (d <= d2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // X0.XO, X0.Oxx0IOOO, X0.Oxx0xo
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return II0xO0(((Number) comparable).doubleValue());
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof oxoX) {
            if (!isEmpty() || !((oxoX) obj).isEmpty()) {
                oxoX oxox = (oxoX) obj;
                if (this.f3214XO != oxox.f3214XO || this.f3213Oo != oxox.f3213Oo) {
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
        return (ooXIXxIX.oIX0oI.oIX0oI(this.f3214XO) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.f3213Oo);
    }

    @Override // X0.XO, X0.Oxx0IOOO, X0.Oxx0xo
    public boolean isEmpty() {
        if (this.f3214XO > this.f3213Oo) {
            return true;
        }
        return false;
    }

    @Override // X0.XO
    public /* bridge */ /* synthetic */ boolean oIX0oI(Double d, Double d2) {
        return X0o0xo(d.doubleValue(), d2.doubleValue());
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public Double getStart() {
        return Double.valueOf(this.f3214XO);
    }

    @OXOo.OOXIXo
    public String toString() {
        return this.f3214XO + ".." + this.f3213Oo;
    }
}
