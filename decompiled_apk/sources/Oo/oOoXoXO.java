package Oo;

import android.graphics.PointF;
import java.util.List;
import xoXoI.oIX0oI;

/* loaded from: classes.dex */
public class oOoXoXO implements x0xO0oo<PointF, PointF> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final X0o0xo f2022II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final X0o0xo f2023oIX0oI;

    public oOoXoXO(X0o0xo x0o0xo, X0o0xo x0o0xo2) {
        this.f2023oIX0oI = x0o0xo;
        this.f2022II0xO0 = x0o0xo2;
    }

    @Override // Oo.x0xO0oo
    public boolean I0Io() {
        if (this.f2023oIX0oI.I0Io() && this.f2022II0xO0.I0Io()) {
            return true;
        }
        return false;
    }

    @Override // Oo.x0xO0oo
    public List<oIX0oI<PointF>> II0xO0() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // Oo.x0xO0oo
    public x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI() {
        return new x0XOIxOo.ooOOo0oXI(this.f2023oIX0oI.oIX0oI(), this.f2022II0xO0.oIX0oI());
    }
}
