package IXxxXO;

import Oo.x0xO0oo;
import android.graphics.PointF;
import com.airbnb.lottie.model.layer.oIX0oI;
import com.airbnb.lottie.xoIox;
import ooOOo0oXI.I0Io;

public class X0o0xo implements II0xO0 {

    /* renamed from: I0Io  reason: collision with root package name */
    public final x0xO0oo<PointF, PointF> f48I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final x0xO0oo<PointF, PointF> f49II0xO0;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final boolean f50X0o0xo;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final String f51oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final Oo.X0o0xo f52oxoX;

    public X0o0xo(String str, x0xO0oo<PointF, PointF> x0xo0oo, x0xO0oo<PointF, PointF> x0xo0oo2, Oo.X0o0xo x0o0xo, boolean z) {
        this.f51oIX0oI = str;
        this.f49II0xO0 = x0xo0oo;
        this.f48I0Io = x0xo0oo2;
        this.f52oxoX = x0o0xo;
        this.f50X0o0xo = z;
    }

    public String I0Io() {
        return this.f51oIX0oI;
    }

    public Oo.X0o0xo II0xO0() {
        return this.f52oxoX;
    }

    public x0xO0oo<PointF, PointF> X0o0xo() {
        return this.f48I0Io;
    }

    public boolean XO() {
        return this.f50X0o0xo;
    }

    public I0Io oIX0oI(xoIox xoiox, oIX0oI oix0oi) {
        return new ooOOo0oXI.x0xO0oo(xoiox, oix0oi, this);
    }

    public x0xO0oo<PointF, PointF> oxoX() {
        return this.f49II0xO0;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f49II0xO0 + ", size=" + this.f48I0Io + '}';
    }
}
