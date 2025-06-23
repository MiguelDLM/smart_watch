package IXxxXO;

import Oo.x0xO0oo;
import android.graphics.PointF;

/* loaded from: classes.dex */
public class X0o0xo implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final x0xO0oo<PointF, PointF> f771I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final x0xO0oo<PointF, PointF> f772II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final boolean f773X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f774oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Oo.X0o0xo f775oxoX;

    public X0o0xo(String str, x0xO0oo<PointF, PointF> x0xo0oo, x0xO0oo<PointF, PointF> x0xo0oo2, Oo.X0o0xo x0o0xo, boolean z) {
        this.f774oIX0oI = str;
        this.f772II0xO0 = x0xo0oo;
        this.f771I0Io = x0xo0oo2;
        this.f775oxoX = x0o0xo;
        this.f773X0o0xo = z;
    }

    public String I0Io() {
        return this.f774oIX0oI;
    }

    public Oo.X0o0xo II0xO0() {
        return this.f775oxoX;
    }

    public x0xO0oo<PointF, PointF> X0o0xo() {
        return this.f771I0Io;
    }

    public boolean XO() {
        return this.f773X0o0xo;
    }

    @Override // IXxxXO.II0xO0
    public ooOOo0oXI.I0Io oIX0oI(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new ooOOo0oXI.x0xO0oo(xoiox, oix0oi, this);
    }

    public x0xO0oo<PointF, PointF> oxoX() {
        return this.f772II0xO0;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f772II0xO0 + ", size=" + this.f771I0Io + '}';
    }
}
