package o0xIIX0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class oxoX<T> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<I0Io<T>> f31224oIX0oI = new ArrayList();

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f31223II0xO0 = 0;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f31222I0Io = 0;

    public void I0Io(XO<T> xo2) {
        this.f31224oIX0oI.add(xo2);
        this.f31223II0xO0++;
    }

    public void II0xO0(X0o0xo<T> x0o0xo) {
        this.f31224oIX0oI.add(x0o0xo);
        this.f31222I0Io++;
    }

    public int X0o0xo() {
        return this.f31222I0Io;
    }

    public void XO(oIX0oI<T> oix0oi) {
        Iterator<I0Io<T>> it = this.f31224oIX0oI.iterator();
        while (it.hasNext()) {
            it.next().oIX0oI(oix0oi);
        }
    }

    public void oIX0oI(II0xO0<T> iI0xO0) {
        this.f31224oIX0oI.add(iI0xO0);
        this.f31222I0Io++;
    }

    public int oxoX() {
        return this.f31223II0xO0;
    }
}
