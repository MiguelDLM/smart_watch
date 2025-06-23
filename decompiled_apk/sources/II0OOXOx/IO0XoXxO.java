package II0OOXOx;

import java.util.Objects;

/* loaded from: classes6.dex */
public final /* synthetic */ class IO0XoXxO {
    static {
        oXxOI0oIx oxxoi0oix = oXxOI0oIx.f188oIX0oI;
    }

    public static /* synthetic */ void II0xO0(oXxOI0oIx oxxoi0oix, oXxOI0oIx oxxoi0oix2, long j) throws Throwable {
        oxxoi0oix.accept(j);
        oxxoi0oix2.accept(j);
    }

    public static oXxOI0oIx oIX0oI(final oXxOI0oIx oxxoi0oix, final oXxOI0oIx oxxoi0oix2) {
        Objects.requireNonNull(oxxoi0oix2);
        return new oXxOI0oIx() { // from class: II0OOXOx.X0xxXX0
            @Override // II0OOXOx.oXxOI0oIx
            public final void accept(long j) {
                IO0XoXxO.II0xO0(oXxOI0oIx.this, oxxoi0oix2, j);
            }

            @Override // II0OOXOx.oXxOI0oIx
            public /* synthetic */ oXxOI0oIx oIX0oI(oXxOI0oIx oxxoi0oix3) {
                return IO0XoXxO.oIX0oI(this, oxxoi0oix3);
            }
        };
    }

    public static <E extends Throwable> oXxOI0oIx<E> oxoX() {
        return oXxOI0oIx.f188oIX0oI;
    }

    public static /* synthetic */ void I0Io(long j) throws Throwable {
    }
}
