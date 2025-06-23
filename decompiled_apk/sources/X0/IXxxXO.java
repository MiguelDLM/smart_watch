package X0;

/* loaded from: classes6.dex */
public final class IXxxXO implements Oxx0xo<Float> {

    /* renamed from: Oo, reason: collision with root package name */
    public final float f3177Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final float f3178XO;

    public IXxxXO(float f, float f2) {
        this.f3178XO = f;
        this.f3177Oo = f2;
    }

    private final boolean X0o0xo(float f, float f2) {
        if (f <= f2) {
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public Float II0xO0() {
        return Float.valueOf(this.f3177Oo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // X0.Oxx0xo
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return oIX0oI(((Number) comparable).floatValue());
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof IXxxXO) {
            if (!isEmpty() || !((IXxxXO) obj).isEmpty()) {
                IXxxXO iXxxXO = (IXxxXO) obj;
                if (this.f3178XO != iXxxXO.f3178XO || this.f3177Oo != iXxxXO.f3177Oo) {
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
        return (Float.floatToIntBits(this.f3178XO) * 31) + Float.floatToIntBits(this.f3177Oo);
    }

    @Override // X0.Oxx0xo
    public boolean isEmpty() {
        if (this.f3178XO >= this.f3177Oo) {
            return true;
        }
        return false;
    }

    public boolean oIX0oI(float f) {
        if (f >= this.f3178XO && f < this.f3177Oo) {
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public Float getStart() {
        return Float.valueOf(this.f3178XO);
    }

    @OXOo.OOXIXo
    public String toString() {
        return this.f3178XO + "..<" + this.f3177Oo;
    }
}
