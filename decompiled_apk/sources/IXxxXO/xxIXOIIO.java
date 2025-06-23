package IXxxXO;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class xxIXOIIO implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final boolean f800I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final List<II0xO0> f801II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f802oIX0oI;

    public xxIXOIIO(String str, List<II0xO0> list, boolean z) {
        this.f802oIX0oI = str;
        this.f801II0xO0 = list;
        this.f800I0Io = z;
    }

    public String I0Io() {
        return this.f802oIX0oI;
    }

    public List<II0xO0> II0xO0() {
        return this.f801II0xO0;
    }

    @Override // IXxxXO.II0xO0
    public ooOOo0oXI.I0Io oIX0oI(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new ooOOo0oXI.oxoX(xoiox, oix0oi, this);
    }

    public boolean oxoX() {
        return this.f800I0Io;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f802oIX0oI + "' Shapes: " + Arrays.toString(this.f801II0xO0.toArray()) + '}';
    }
}
