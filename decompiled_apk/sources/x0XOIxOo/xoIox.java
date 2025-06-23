package x0XOIxOo;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes.dex */
public class xoIox extends XO<PointF> {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final PointF f34006xxIXOIIO;

    public xoIox(List<xoXoI.oIX0oI<PointF>> list) {
        super(list);
        this.f34006xxIXOIIO = new PointF();
    }

    @Override // x0XOIxOo.oIX0oI
    /* renamed from: Oo, reason: merged with bridge method [inline-methods] */
    public PointF xoIox(xoXoI.oIX0oI<PointF> oix0oi, float f, float f2, float f3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = oix0oi.f35166II0xO0;
        if (pointF3 != null && (pointF = oix0oi.f35164I0Io) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            xoXoI.xoIox<A> xoiox = this.f33971X0o0xo;
            if (xoiox != 0 && (pointF2 = (PointF) xoiox.II0xO0(oix0oi.f35168Oxx0IOOO, oix0oi.f35165II0XooXoX.floatValue(), pointF4, pointF5, f, X0o0xo(), XO())) != null) {
                return pointF2;
            }
            PointF pointF6 = this.f34006xxIXOIIO;
            float f4 = pointF4.x;
            float f5 = f4 + (f2 * (pointF5.x - f4));
            float f6 = pointF4.y;
            pointF6.set(f5, f6 + (f3 * (pointF5.y - f6)));
            return this.f34006xxIXOIIO;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // x0XOIxOo.oIX0oI
    /* renamed from: x0xO0oo, reason: merged with bridge method [inline-methods] */
    public PointF xxIXOIIO(xoXoI.oIX0oI<PointF> oix0oi, float f) {
        return xoIox(oix0oi, f, f, f);
    }
}
