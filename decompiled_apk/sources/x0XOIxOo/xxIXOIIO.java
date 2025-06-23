package x0XOIxOo;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: classes.dex */
public class xxIXOIIO extends XO<PointF> {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final PathMeasure f34007OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public II0XooXoX f34008oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public final float[] f34009xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final PointF f34010xxIXOIIO;

    public xxIXOIIO(List<? extends xoXoI.oIX0oI<PointF>> list) {
        super(list);
        this.f34010xxIXOIIO = new PointF();
        this.f34009xoIox = new float[2];
        this.f34007OOXIXo = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x0XOIxOo.oIX0oI
    /* renamed from: x0xO0oo, reason: merged with bridge method [inline-methods] */
    public PointF xxIXOIIO(xoXoI.oIX0oI<PointF> oix0oi, float f) {
        PointF pointF;
        II0XooXoX iI0XooXoX = (II0XooXoX) oix0oi;
        Path xoIox2 = iI0XooXoX.xoIox();
        if (xoIox2 == null) {
            return oix0oi.f35166II0xO0;
        }
        xoXoI.xoIox<A> xoiox = this.f33971X0o0xo;
        if (xoiox != 0 && (pointF = (PointF) xoiox.II0xO0(iI0XooXoX.f35168Oxx0IOOO, iI0XooXoX.f35165II0XooXoX.floatValue(), iI0XooXoX.f35166II0xO0, iI0XooXoX.f35164I0Io, X0o0xo(), f, XO())) != null) {
            return pointF;
        }
        if (this.f34008oOoXoXO != iI0XooXoX) {
            this.f34007OOXIXo.setPath(xoIox2, false);
            this.f34008oOoXoXO = iI0XooXoX;
        }
        PathMeasure pathMeasure = this.f34007OOXIXo;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.f34009xoIox, null);
        PointF pointF2 = this.f34010xxIXOIIO;
        float[] fArr = this.f34009xoIox;
        pointF2.set(fArr[0], fArr[1]);
        return this.f34010xxIXOIIO;
    }
}
