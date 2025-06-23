package xoXoI;

import android.graphics.PointF;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class xxIXOIIO extends xoIox<PointF> {

    /* renamed from: oxoX, reason: collision with root package name */
    public final PointF f35183oxoX;

    public xxIXOIIO() {
        this.f35183oxoX = new PointF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PointF X0o0xo(II0xO0<PointF> iI0xO0) {
        T t = this.f35180I0Io;
        if (t != 0) {
            return (PointF) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // xoXoI.xoIox
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public final PointF oIX0oI(II0xO0<PointF> iI0xO0) {
        this.f35183oxoX.set(IIXOooo.xxIXOIIO.OOXIXo(iI0xO0.Oxx0IOOO().x, iI0xO0.II0xO0().x, iI0xO0.I0Io()), IIXOooo.xxIXOIIO.OOXIXo(iI0xO0.Oxx0IOOO().y, iI0xO0.II0xO0().y, iI0xO0.I0Io()));
        PointF X0o0xo2 = X0o0xo(iI0xO0);
        this.f35183oxoX.offset(X0o0xo2.x, X0o0xo2.y);
        return this.f35183oxoX;
    }

    public xxIXOIIO(@NonNull PointF pointF) {
        super(pointF);
        this.f35183oxoX = new PointF();
    }
}
