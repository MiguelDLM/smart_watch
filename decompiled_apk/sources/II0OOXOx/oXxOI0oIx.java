package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface oXxOI0oIx<E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final oXxOI0oIx f188oIX0oI = new oXxOI0oIx() { // from class: II0OOXOx.X0xII0I
        @Override // II0OOXOx.oXxOI0oIx
        public final void accept(long j) {
            IO0XoXxO.I0Io(j);
        }

        @Override // II0OOXOx.oXxOI0oIx
        public /* synthetic */ oXxOI0oIx oIX0oI(oXxOI0oIx oxxoi0oix) {
            return IO0XoXxO.oIX0oI(this, oxxoi0oix);
        }
    };

    void accept(long j) throws Throwable;

    oXxOI0oIx<E> oIX0oI(oXxOI0oIx<E> oxxoi0oix);
}
