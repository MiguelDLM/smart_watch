package X0;

/* loaded from: classes6.dex */
public final class X0o0xo implements XO<Float> {

    /* renamed from: Oo, reason: collision with root package name */
    public final float f3193Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final float f3194XO;

    public X0o0xo(float f, float f2) {
        this.f3194XO = f;
        this.f3193Oo = f2;
    }

    @Override // X0.Oxx0IOOO
    @OXOo.OOXIXo
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public Float getEndInclusive() {
        return Float.valueOf(this.f3193Oo);
    }

    public boolean II0xO0(float f) {
        if (f >= this.f3194XO && f <= this.f3193Oo) {
            return true;
        }
        return false;
    }

    public boolean X0o0xo(float f, float f2) {
        if (f <= f2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // X0.XO, X0.Oxx0IOOO, X0.Oxx0xo
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return II0xO0(((Number) comparable).floatValue());
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof X0o0xo) {
            if (!isEmpty() || !((X0o0xo) obj).isEmpty()) {
                X0o0xo x0o0xo = (X0o0xo) obj;
                if (this.f3194XO != x0o0xo.f3194XO || this.f3193Oo != x0o0xo.f3193Oo) {
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
        return (Float.floatToIntBits(this.f3194XO) * 31) + Float.floatToIntBits(this.f3193Oo);
    }

    @Override // X0.XO, X0.Oxx0IOOO, X0.Oxx0xo
    public boolean isEmpty() {
        if (this.f3194XO > this.f3193Oo) {
            return true;
        }
        return false;
    }

    @Override // X0.XO
    public /* bridge */ /* synthetic */ boolean oIX0oI(Float f, Float f2) {
        return X0o0xo(f.floatValue(), f2.floatValue());
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public Float getStart() {
        return Float.valueOf(this.f3194XO);
    }

    @OXOo.OOXIXo
    public String toString() {
        return this.f3194XO + ".." + this.f3193Oo;
    }
}
