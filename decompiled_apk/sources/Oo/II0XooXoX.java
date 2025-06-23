package Oo;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
import xoXoI.oIX0oI;

/* loaded from: classes.dex */
public class II0XooXoX implements x0xO0oo<PointF, PointF> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<oIX0oI<PointF>> f2011oIX0oI;

    public II0XooXoX() {
        this.f2011oIX0oI = Collections.singletonList(new oIX0oI(new PointF(0.0f, 0.0f)));
    }

    @Override // Oo.x0xO0oo
    public boolean I0Io() {
        if (this.f2011oIX0oI.size() != 1 || !this.f2011oIX0oI.get(0).II0XooXoX()) {
            return false;
        }
        return true;
    }

    @Override // Oo.x0xO0oo
    public List<oIX0oI<PointF>> II0xO0() {
        return this.f2011oIX0oI;
    }

    @Override // Oo.x0xO0oo
    public x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI() {
        if (this.f2011oIX0oI.get(0).II0XooXoX()) {
            return new x0XOIxOo.xoIox(this.f2011oIX0oI);
        }
        return new x0XOIxOo.xxIXOIIO(this.f2011oIX0oI);
    }

    public II0XooXoX(List<oIX0oI<PointF>> list) {
        this.f2011oIX0oI = list;
    }
}
