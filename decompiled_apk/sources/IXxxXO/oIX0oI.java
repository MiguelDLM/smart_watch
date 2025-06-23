package IXxxXO;

import Oo.x0xO0oo;
import android.graphics.PointF;

/* loaded from: classes.dex */
public class oIX0oI implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Oo.xxIXOIIO f781I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final x0xO0oo<PointF, PointF> f782II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final boolean f783X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f784oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final boolean f785oxoX;

    public oIX0oI(String str, x0xO0oo<PointF, PointF> x0xo0oo, Oo.xxIXOIIO xxixoiio, boolean z, boolean z2) {
        this.f784oIX0oI = str;
        this.f782II0xO0 = x0xo0oo;
        this.f781I0Io = xxixoiio;
        this.f785oxoX = z;
        this.f783X0o0xo = z2;
    }

    public x0xO0oo<PointF, PointF> I0Io() {
        return this.f782II0xO0;
    }

    public String II0xO0() {
        return this.f784oIX0oI;
    }

    public boolean X0o0xo() {
        return this.f783X0o0xo;
    }

    public boolean XO() {
        return this.f785oxoX;
    }

    @Override // IXxxXO.II0xO0
    public ooOOo0oXI.I0Io oIX0oI(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new ooOOo0oXI.XO(xoiox, oix0oi, this);
    }

    public Oo.xxIXOIIO oxoX() {
        return this.f781I0Io;
    }
}
