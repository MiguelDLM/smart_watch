package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface OX00O0xII<T, R, E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final OX00O0xII f128oIX0oI = new OX00O0xII() { // from class: II0OOXOx.IIxOXoOo0
        @Override // II0OOXOx.OX00O0xII
        public /* synthetic */ OX00O0xII II0xO0(OX00O0xII oX00O0xII) {
            return xoO0xx0.II0xO0(this, oX00O0xII);
        }

        @Override // II0OOXOx.OX00O0xII
        public final Object apply(Object obj) {
            return xoO0xx0.Oxx0IOOO(obj);
        }

        @Override // II0OOXOx.OX00O0xII
        public /* synthetic */ OX00O0xII oIX0oI(OX00O0xII oX00O0xII) {
            return xoO0xx0.oIX0oI(this, oX00O0xII);
        }
    };

    <V> OX00O0xII<V, R, E> II0xO0(OX00O0xII<? super V, ? extends T, E> oX00O0xII);

    R apply(T t) throws Throwable;

    <V> OX00O0xII<T, V, E> oIX0oI(OX00O0xII<? super R, ? extends V, E> oX00O0xII);
}
