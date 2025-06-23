package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface X0IIOO<T, U, E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final X0IIOO f143oIX0oI = new X0IIOO() { // from class: II0OOXOx.o00
        @Override // II0OOXOx.X0IIOO
        public final void accept(Object obj, Object obj2) {
            O0xOxO.I0Io(obj, obj2);
        }

        @Override // II0OOXOx.X0IIOO
        public /* synthetic */ X0IIOO oIX0oI(X0IIOO x0iioo) {
            return O0xOxO.oIX0oI(this, x0iioo);
        }
    };

    void accept(T t, U u) throws Throwable;

    X0IIOO<T, U, E> oIX0oI(X0IIOO<? super T, ? super U, E> x0iioo);
}
