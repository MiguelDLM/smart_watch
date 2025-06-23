package IXxxXO;

import ooOOo0oXI.Oxx0xo;

/* loaded from: classes.dex */
public class xoIox implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Oo.OOXIXo f796I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f797II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f798oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final boolean f799oxoX;

    public xoIox(String str, int i, Oo.OOXIXo oOXIXo, boolean z) {
        this.f798oIX0oI = str;
        this.f797II0xO0 = i;
        this.f796I0Io = oOXIXo;
        this.f799oxoX = z;
    }

    public Oo.OOXIXo I0Io() {
        return this.f796I0Io;
    }

    public String II0xO0() {
        return this.f798oIX0oI;
    }

    @Override // IXxxXO.II0xO0
    public ooOOo0oXI.I0Io oIX0oI(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new Oxx0xo(xoiox, oix0oi, this);
    }

    public boolean oxoX() {
        return this.f799oxoX;
    }

    public String toString() {
        return "ShapePath{name=" + this.f798oIX0oI + ", index=" + this.f797II0xO0 + '}';
    }
}
