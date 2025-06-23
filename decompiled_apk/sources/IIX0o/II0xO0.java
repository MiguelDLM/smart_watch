package IIX0o;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f281I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public List<oxoX> f282II0xO0 = new ArrayList();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f283oIX0oI;

    public II0xO0(Context context) {
        this.f283oIX0oI = context;
    }

    public oxoX I0Io(int i) {
        return this.f282II0xO0.get(i);
    }

    public Context II0xO0() {
        return this.f283oIX0oI;
    }

    public void Oxx0IOOO(int i) {
        this.f281I0Io = i;
    }

    public int X0o0xo() {
        return this.f281I0Io;
    }

    public void XO(oxoX oxox) {
        this.f282II0xO0.remove(oxox);
    }

    public void oIX0oI(oxoX oxox) {
        this.f282II0xO0.add(oxox);
    }

    public List<oxoX> oxoX() {
        return this.f282II0xO0;
    }
}
