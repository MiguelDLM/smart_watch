package II0OOXOx;

import java.util.Objects;

/* loaded from: classes6.dex */
public final /* synthetic */ class x0o {
    static {
        XOxIOxOx xOxIOxOx = XOxIOxOx.f157oIX0oI;
    }

    public static /* synthetic */ void II0xO0(XOxIOxOx xOxIOxOx, XOxIOxOx xOxIOxOx2, Object obj) throws Throwable {
        xOxIOxOx.accept(obj);
        xOxIOxOx2.accept(obj);
    }

    public static XOxIOxOx oIX0oI(final XOxIOxOx xOxIOxOx, final XOxIOxOx xOxIOxOx2) {
        Objects.requireNonNull(xOxIOxOx2);
        return new XOxIOxOx() { // from class: II0OOXOx.xII
            @Override // II0OOXOx.XOxIOxOx
            public final void accept(Object obj) {
                x0o.II0xO0(XOxIOxOx.this, xOxIOxOx2, obj);
            }

            @Override // II0OOXOx.XOxIOxOx
            public /* synthetic */ XOxIOxOx oIX0oI(XOxIOxOx xOxIOxOx3) {
                return x0o.oIX0oI(this, xOxIOxOx3);
            }
        };
    }

    public static <T, E extends Throwable> XOxIOxOx<T, E> oxoX() {
        return XOxIOxOx.f157oIX0oI;
    }

    public static /* synthetic */ void I0Io(Object obj) throws Throwable {
    }
}
