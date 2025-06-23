package o0xxxXXxX;

import com.github.mikephil.charting.data.Entry;

/* loaded from: classes9.dex */
public class x0xO0oo extends OOXIXo<IIxOXoOo0.xxIXOIIO> {
    public x0xO0oo() {
    }

    public void Io(IIxOXoOo0.xxIXOIIO xxixoiio) {
        this.f31251xxIXOIIO.clear();
        this.f31251xxIXOIIO.add(xxixoiio);
        XxX0x0xxx();
    }

    public float OI0() {
        float f = 0.0f;
        for (int i = 0; i < xII().X0xxXX0(); i++) {
            f += xII().OOXIXo(i).I0Io();
        }
        return f;
    }

    @Override // o0xxxXXxX.OOXIXo
    public Entry Oxx0xo(XI0oooXX.oxoX oxox) {
        return xII().OOXIXo((int) oxox.II0XooXoX());
    }

    @Override // o0xxxXXxX.OOXIXo
    /* renamed from: XOxIOxOx, reason: merged with bridge method [inline-methods] */
    public IIxOXoOo0.xxIXOIIO oOoXoXO(String str, boolean z) {
        if (z) {
            if (!str.equalsIgnoreCase(((IIxOXoOo0.xxIXOIIO) this.f31251xxIXOIIO.get(0)).getLabel())) {
                return null;
            }
            return (IIxOXoOo0.xxIXOIIO) this.f31251xxIXOIIO.get(0);
        }
        if (!str.equals(((IIxOXoOo0.xxIXOIIO) this.f31251xxIXOIIO.get(0)).getLabel())) {
            return null;
        }
        return (IIxOXoOo0.xxIXOIIO) this.f31251xxIXOIIO.get(0);
    }

    @Override // o0xxxXXxX.OOXIXo
    /* renamed from: x0o, reason: merged with bridge method [inline-methods] */
    public IIxOXoOo0.xxIXOIIO OOXIXo(int i) {
        if (i == 0) {
            return xII();
        }
        return null;
    }

    public IIxOXoOo0.xxIXOIIO xII() {
        return (IIxOXoOo0.xxIXOIIO) this.f31251xxIXOIIO.get(0);
    }

    public x0xO0oo(IIxOXoOo0.xxIXOIIO xxixoiio) {
        super(xxixoiio);
    }
}
