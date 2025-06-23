package xoXoI;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public class X0o0xo extends XO<PointF> {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final PointF f35158Oxx0IOOO;

    public X0o0xo(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.f35158Oxx0IOOO = new PointF();
    }

    @Override // xoXoI.XO
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public PointF X0o0xo(PointF pointF, PointF pointF2, float f) {
        this.f35158Oxx0IOOO.set(IIXOooo.xxIXOIIO.OOXIXo(pointF.x, pointF2.x, f), IIXOooo.xxIXOIIO.OOXIXo(pointF.y, pointF2.y, f));
        return this.f35158Oxx0IOOO;
    }

    @Override // xoXoI.XO, xoXoI.xoIox
    public /* bridge */ /* synthetic */ Object oIX0oI(II0xO0 iI0xO0) {
        return super.oIX0oI(iI0xO0);
    }

    public X0o0xo(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.f35158Oxx0IOOO = new PointF();
    }
}
