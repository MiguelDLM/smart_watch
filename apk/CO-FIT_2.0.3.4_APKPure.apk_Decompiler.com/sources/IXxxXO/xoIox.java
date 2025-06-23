package IXxxXO;

import Oo.OOXIXo;
import com.airbnb.lottie.model.layer.oIX0oI;
import ooOOo0oXI.I0Io;
import ooOOo0oXI.Oxx0xo;

public class xoIox implements II0xO0 {

    /* renamed from: I0Io  reason: collision with root package name */
    public final OOXIXo f73I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final int f74II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final String f75oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final boolean f76oxoX;

    public xoIox(String str, int i, OOXIXo oOXIXo, boolean z) {
        this.f75oIX0oI = str;
        this.f74II0xO0 = i;
        this.f73I0Io = oOXIXo;
        this.f76oxoX = z;
    }

    public OOXIXo I0Io() {
        return this.f73I0Io;
    }

    public String II0xO0() {
        return this.f75oIX0oI;
    }

    public I0Io oIX0oI(com.airbnb.lottie.xoIox xoiox, oIX0oI oix0oi) {
        return new Oxx0xo(xoiox, oix0oi, this);
    }

    public boolean oxoX() {
        return this.f76oxoX;
    }

    public String toString() {
        return "ShapePath{name=" + this.f75oIX0oI + ", index=" + this.f74II0xO0 + '}';
    }
}
