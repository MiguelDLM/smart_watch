package IXxxXO;

import Oo.oO;
import androidx.annotation.Nullable;
import ooOOo0oXI.IXxxXO;

/* loaded from: classes.dex */
public class XO implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Oo.X0o0xo f776I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Oo.X0o0xo f777II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final boolean f778X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f779oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final oO f780oxoX;

    public XO(String str, Oo.X0o0xo x0o0xo, Oo.X0o0xo x0o0xo2, oO oOVar, boolean z) {
        this.f779oIX0oI = str;
        this.f777II0xO0 = x0o0xo;
        this.f776I0Io = x0o0xo2;
        this.f780oxoX = oOVar;
        this.f778X0o0xo = z;
    }

    public String I0Io() {
        return this.f779oIX0oI;
    }

    public Oo.X0o0xo II0xO0() {
        return this.f777II0xO0;
    }

    public oO X0o0xo() {
        return this.f780oxoX;
    }

    public boolean XO() {
        return this.f778X0o0xo;
    }

    @Override // IXxxXO.II0xO0
    @Nullable
    public ooOOo0oXI.I0Io oIX0oI(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new IXxxXO(xoiox, oix0oi, this);
    }

    public Oo.X0o0xo oxoX() {
        return this.f776I0Io;
    }
}
