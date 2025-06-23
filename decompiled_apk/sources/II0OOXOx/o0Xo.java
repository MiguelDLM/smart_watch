package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface o0Xo<T, E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final o0Xo f170oIX0oI = new o0Xo() { // from class: II0OOXOx.OxO
        @Override // II0OOXOx.o0Xo
        public final void accept(Object obj, int i) {
            xxx00.oIX0oI(obj, i);
        }
    };

    void accept(T t, int i) throws Throwable;
}
