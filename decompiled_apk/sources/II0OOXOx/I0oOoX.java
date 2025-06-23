package II0OOXOx;

import java.util.Objects;

/* loaded from: classes6.dex */
public final /* synthetic */ class I0oOoX {
    static {
        oxxXoxO oxxxoxo = oxxXoxO.f199oIX0oI;
    }

    public static /* synthetic */ void II0xO0(oxxXoxO oxxxoxo, oxxXoxO oxxxoxo2, double d) throws Throwable {
        oxxxoxo.accept(d);
        oxxxoxo2.accept(d);
    }

    public static oxxXoxO oIX0oI(final oxxXoxO oxxxoxo, final oxxXoxO oxxxoxo2) {
        Objects.requireNonNull(oxxxoxo2);
        return new oxxXoxO() { // from class: II0OOXOx.XX
            @Override // II0OOXOx.oxxXoxO
            public final void accept(double d) {
                I0oOoX.II0xO0(oxxXoxO.this, oxxxoxo2, d);
            }

            @Override // II0OOXOx.oxxXoxO
            public /* synthetic */ oxxXoxO oIX0oI(oxxXoxO oxxxoxo3) {
                return I0oOoX.oIX0oI(this, oxxxoxo3);
            }
        };
    }

    public static <E extends Throwable> oxxXoxO<E> oxoX() {
        return oxxXoxO.f199oIX0oI;
    }

    public static /* synthetic */ void I0Io(double d) throws Throwable {
    }
}
