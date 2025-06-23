package IXxxXO;

import Oo.Oxx0IOOO;
import Oo.oxoX;
import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.oIX0oI;
import com.airbnb.lottie.xoIox;
import ooOOo0oXI.I0Io;

public class II0XooXoX implements II0xO0 {

    /* renamed from: I0Io  reason: collision with root package name */
    public final String f39I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final Path.FillType f40II0xO0;
    @Nullable

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final Oxx0IOOO f41X0o0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final boolean f42XO;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final boolean f43oIX0oI;
    @Nullable

    /* renamed from: oxoX  reason: collision with root package name */
    public final oxoX f44oxoX;

    public II0XooXoX(String str, boolean z, Path.FillType fillType, @Nullable oxoX oxox, @Nullable Oxx0IOOO oxx0IOOO, boolean z2) {
        this.f39I0Io = str;
        this.f43oIX0oI = z;
        this.f40II0xO0 = fillType;
        this.f44oxoX = oxox;
        this.f41X0o0xo = oxx0IOOO;
        this.f42XO = z2;
    }

    public Path.FillType I0Io() {
        return this.f40II0xO0;
    }

    @Nullable
    public oxoX II0xO0() {
        return this.f44oxoX;
    }

    @Nullable
    public Oxx0IOOO X0o0xo() {
        return this.f41X0o0xo;
    }

    public boolean XO() {
        return this.f42XO;
    }

    public I0Io oIX0oI(xoIox xoiox, oIX0oI oix0oi) {
        return new ooOOo0oXI.Oxx0IOOO(xoiox, oix0oi, this);
    }

    public String oxoX() {
        return this.f39I0Io;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f43oIX0oI + '}';
    }
}
