package II0OOXOx;

import java.util.Objects;

/* loaded from: classes6.dex */
public final /* synthetic */ class oXIO0o0XI {
    static {
        oOo ooo = oOo.f181oIX0oI;
    }

    public static /* synthetic */ void II0xO0(oOo ooo, oOo ooo2, int i) throws Throwable {
        ooo.accept(i);
        ooo2.accept(i);
    }

    public static oOo oIX0oI(final oOo ooo, final oOo ooo2) {
        Objects.requireNonNull(ooo2);
        return new oOo() { // from class: II0OOXOx.xOOOX
            @Override // II0OOXOx.oOo
            public final void accept(int i) {
                oXIO0o0XI.II0xO0(oOo.this, ooo2, i);
            }

            @Override // II0OOXOx.oOo
            public /* synthetic */ oOo oIX0oI(oOo ooo3) {
                return oXIO0o0XI.oIX0oI(this, ooo3);
            }
        };
    }

    public static <E extends Throwable> oOo<E> oxoX() {
        return oOo.f181oIX0oI;
    }

    public static /* synthetic */ void I0Io(int i) throws Throwable {
    }
}
