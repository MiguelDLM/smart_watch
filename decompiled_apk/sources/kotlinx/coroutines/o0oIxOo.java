package kotlinx.coroutines;

import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes6.dex */
public abstract class o0oIxOo extends CoroutineDispatcher {
    @OXOo.OOXIXo
    public abstract o0oIxOo IIXOooo();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public CoroutineDispatcher limitedParallelism(int i) {
        kotlinx.coroutines.internal.oI0IIXIo.oIX0oI(i);
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public String toString() {
        String xoXoI2 = xoXoI();
        if (xoXoI2 == null) {
            return OI0.oIX0oI(this) + ObjectUtils.f32506oIX0oI + OI0.II0xO0(this);
        }
        return xoXoI2;
    }

    @OX00O0xII
    @OXOo.oOoXoXO
    public final String xoXoI() {
        o0oIxOo o0oixoo;
        o0oIxOo X0o0xo2 = Xo0.X0o0xo();
        if (this == X0o0xo2) {
            return "Dispatchers.Main";
        }
        try {
            o0oixoo = X0o0xo2.IIXOooo();
        } catch (UnsupportedOperationException unused) {
            o0oixoo = null;
        }
        if (this != o0oixoo) {
            return null;
        }
        return "Dispatchers.Main.immediate";
    }
}
