package x0XOIxOo;

import androidx.annotation.Nullable;
import java.util.Collections;

/* loaded from: classes.dex */
public class x0xO0oo<K, A> extends oIX0oI<K, A> {

    /* renamed from: xoIox, reason: collision with root package name */
    public final A f34004xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final xoXoI.II0xO0<A> f34005xxIXOIIO;

    public x0xO0oo(xoXoI.xoIox<A> xoiox) {
        this(xoiox, null);
    }

    @Override // x0XOIxOo.oIX0oI
    public float I0Io() {
        return 1.0f;
    }

    @Override // x0XOIxOo.oIX0oI
    public A II0XooXoX() {
        xoXoI.xoIox<A> xoiox = this.f33971X0o0xo;
        A a2 = this.f34004xoIox;
        return xoiox.II0xO0(0.0f, 0.0f, a2, a2, XO(), XO(), XO());
    }

    @Override // x0XOIxOo.oIX0oI
    public void OOXIXo() {
        if (this.f33971X0o0xo != null) {
            super.OOXIXo();
        }
    }

    @Override // x0XOIxOo.oIX0oI
    public void ooOOo0oXI(float f) {
        this.f33974oxoX = f;
    }

    @Override // x0XOIxOo.oIX0oI
    public A xxIXOIIO(xoXoI.oIX0oI<K> oix0oi, float f) {
        return II0XooXoX();
    }

    public x0xO0oo(xoXoI.xoIox<A> xoiox, @Nullable A a2) {
        super(Collections.emptyList());
        this.f34005xxIXOIIO = new xoXoI.II0xO0<>();
        x0XOIxOo(xoiox);
        this.f34004xoIox = a2;
    }
}
