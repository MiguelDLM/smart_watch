package Oo;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
import x0XOIxOo.xoIox;
import x0XOIxOo.xxIXOIIO;
import xoXoI.oIX0oI;

public class II0XooXoX implements x0xO0oo<PointF, PointF> {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final List<oIX0oI<PointF>> f99oIX0oI;

    public II0XooXoX() {
        this.f99oIX0oI = Collections.singletonList(new oIX0oI(new PointF(0.0f, 0.0f)));
    }

    public boolean I0Io() {
        if (this.f99oIX0oI.size() != 1 || !this.f99oIX0oI.get(0).II0XooXoX()) {
            return false;
        }
        return true;
    }

    public List<oIX0oI<PointF>> II0xO0() {
        return this.f99oIX0oI;
    }

    public x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI() {
        if (this.f99oIX0oI.get(0).II0XooXoX()) {
            return new xoIox(this.f99oIX0oI);
        }
        return new xxIXOIIO(this.f99oIX0oI);
    }

    public II0XooXoX(List<oIX0oI<PointF>> list) {
        this.f99oIX0oI = list;
    }
}
