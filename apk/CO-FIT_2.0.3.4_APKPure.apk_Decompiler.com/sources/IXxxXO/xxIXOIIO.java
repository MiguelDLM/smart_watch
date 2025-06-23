package IXxxXO;

import com.airbnb.lottie.model.layer.oIX0oI;
import com.airbnb.lottie.xoIox;
import java.util.Arrays;
import java.util.List;
import ooOOo0oXI.I0Io;
import ooOOo0oXI.oxoX;

public class xxIXOIIO implements II0xO0 {

    /* renamed from: I0Io  reason: collision with root package name */
    public final boolean f77I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final List<II0xO0> f78II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final String f79oIX0oI;

    public xxIXOIIO(String str, List<II0xO0> list, boolean z) {
        this.f79oIX0oI = str;
        this.f78II0xO0 = list;
        this.f77I0Io = z;
    }

    public String I0Io() {
        return this.f79oIX0oI;
    }

    public List<II0xO0> II0xO0() {
        return this.f78II0xO0;
    }

    public I0Io oIX0oI(xoIox xoiox, oIX0oI oix0oi) {
        return new oxoX(xoiox, oix0oi, this);
    }

    public boolean oxoX() {
        return this.f77I0Io;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f79oIX0oI + "' Shapes: " + Arrays.toString(this.f78II0xO0.toArray()) + '}';
    }
}
