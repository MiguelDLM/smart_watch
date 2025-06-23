package IXxxXO;

import Oo.x0xO0oo;
import Oo.xxIXOIIO;
import android.graphics.PointF;
import com.airbnb.lottie.xoIox;
import ooOOo0oXI.I0Io;
import ooOOo0oXI.XO;

public class oIX0oI implements II0xO0 {

    /* renamed from: I0Io  reason: collision with root package name */
    public final xxIXOIIO f58I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final x0xO0oo<PointF, PointF> f59II0xO0;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final boolean f60X0o0xo;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final String f61oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final boolean f62oxoX;

    public oIX0oI(String str, x0xO0oo<PointF, PointF> x0xo0oo, xxIXOIIO xxixoiio, boolean z, boolean z2) {
        this.f61oIX0oI = str;
        this.f59II0xO0 = x0xo0oo;
        this.f58I0Io = xxixoiio;
        this.f62oxoX = z;
        this.f60X0o0xo = z2;
    }

    public x0xO0oo<PointF, PointF> I0Io() {
        return this.f59II0xO0;
    }

    public String II0xO0() {
        return this.f61oIX0oI;
    }

    public boolean X0o0xo() {
        return this.f60X0o0xo;
    }

    public boolean XO() {
        return this.f62oxoX;
    }

    public I0Io oIX0oI(xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new XO(xoiox, oix0oi, this);
    }

    public xxIXOIIO oxoX() {
        return this.f58I0Io;
    }
}
