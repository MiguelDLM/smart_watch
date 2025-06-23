package IXxxXO;

import android.graphics.Path;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class II0XooXoX implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final String f762I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Path.FillType f763II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @Nullable
    public final Oo.Oxx0IOOO f764X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final boolean f765XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final boolean f766oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @Nullable
    public final Oo.oxoX f767oxoX;

    public II0XooXoX(String str, boolean z, Path.FillType fillType, @Nullable Oo.oxoX oxox, @Nullable Oo.Oxx0IOOO oxx0IOOO, boolean z2) {
        this.f762I0Io = str;
        this.f766oIX0oI = z;
        this.f763II0xO0 = fillType;
        this.f767oxoX = oxox;
        this.f764X0o0xo = oxx0IOOO;
        this.f765XO = z2;
    }

    public Path.FillType I0Io() {
        return this.f763II0xO0;
    }

    @Nullable
    public Oo.oxoX II0xO0() {
        return this.f767oxoX;
    }

    @Nullable
    public Oo.Oxx0IOOO X0o0xo() {
        return this.f764X0o0xo;
    }

    public boolean XO() {
        return this.f765XO;
    }

    @Override // IXxxXO.II0xO0
    public ooOOo0oXI.I0Io oIX0oI(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new ooOOo0oXI.Oxx0IOOO(xoiox, oix0oi, this);
    }

    public String oxoX() {
        return this.f762I0Io;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f766oIX0oI + '}';
    }
}
