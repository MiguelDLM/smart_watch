package II0OOXOx;

import java.util.Objects;

/* loaded from: classes6.dex */
public final /* synthetic */ class O0xOxO {
    static {
        X0IIOO x0iioo = X0IIOO.f143oIX0oI;
    }

    public static /* synthetic */ void II0xO0(X0IIOO x0iioo, X0IIOO x0iioo2, Object obj, Object obj2) throws Throwable {
        x0iioo.accept(obj, obj2);
        x0iioo2.accept(obj, obj2);
    }

    public static X0IIOO oIX0oI(final X0IIOO x0iioo, final X0IIOO x0iioo2) {
        Objects.requireNonNull(x0iioo2);
        return new X0IIOO() { // from class: II0OOXOx.OxI
            @Override // II0OOXOx.X0IIOO
            public final void accept(Object obj, Object obj2) {
                O0xOxO.II0xO0(X0IIOO.this, x0iioo2, obj, obj2);
            }

            @Override // II0OOXOx.X0IIOO
            public /* synthetic */ X0IIOO oIX0oI(X0IIOO x0iioo3) {
                return O0xOxO.oIX0oI(this, x0iioo3);
            }
        };
    }

    public static <T, U, E extends Throwable> X0IIOO<T, U, E> oxoX() {
        return X0IIOO.f143oIX0oI;
    }

    public static /* synthetic */ void I0Io(Object obj, Object obj2) throws Throwable {
    }
}
