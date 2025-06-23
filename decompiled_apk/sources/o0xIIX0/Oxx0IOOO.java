package o0xIIX0;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class Oxx0IOOO<T> implements oIX0oI<T> {

    /* renamed from: oxoX, reason: collision with root package name */
    public final II0XooXoX<T> f31221oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<T> f31220oIX0oI = new ArrayList();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final List<T> f31219II0xO0 = new ArrayList();

    /* renamed from: I0Io, reason: collision with root package name */
    public int f31218I0Io = 0;

    public Oxx0IOOO(II0XooXoX<T> iI0XooXoX) {
        this.f31221oxoX = iI0XooXoX;
    }

    @Override // o0xIIX0.oIX0oI
    public void I0Io(T t) {
        if (this.f31219II0xO0.isEmpty() && this.f31220oIX0oI.isEmpty()) {
            this.f31218I0Io++;
            return;
        }
        this.f31221oxoX.oIX0oI(this.f31218I0Io, this.f31219II0xO0, this.f31220oIX0oI);
        this.f31219II0xO0.clear();
        this.f31220oIX0oI.clear();
        this.f31218I0Io = 1;
    }

    @Override // o0xIIX0.oIX0oI
    public void II0xO0(T t) {
        this.f31220oIX0oI.add(t);
    }

    @Override // o0xIIX0.oIX0oI
    public void oIX0oI(T t) {
        this.f31219II0xO0.add(t);
    }
}
