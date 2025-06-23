package Oo;

import android.graphics.PointF;
import java.util.List;
import x0XOIxOo.ooOOo0oXI;
import xoXoI.oIX0oI;

public class oOoXoXO implements x0xO0oo<PointF, PointF> {

    /* renamed from: II0xO0  reason: collision with root package name */
    public final X0o0xo f110II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final X0o0xo f111oIX0oI;

    public oOoXoXO(X0o0xo x0o0xo, X0o0xo x0o0xo2) {
        this.f111oIX0oI = x0o0xo;
        this.f110II0xO0 = x0o0xo2;
    }

    public boolean I0Io() {
        if (!this.f111oIX0oI.I0Io() || !this.f110II0xO0.I0Io()) {
            return false;
        }
        return true;
    }

    public List<oIX0oI<PointF>> II0xO0() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    public x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI() {
        return new ooOOo0oXI(this.f111oIX0oI.oIX0oI(), this.f110II0xO0.oIX0oI());
    }
}
