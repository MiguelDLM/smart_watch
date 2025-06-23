package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface XxX0x0xxx<T, U, R, E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final XxX0x0xxx f169oIX0oI = new XxX0x0xxx() { // from class: II0OOXOx.XI0IXoo
        @Override // II0OOXOx.XxX0x0xxx
        public final Object apply(Object obj, Object obj2) {
            return xxX.I0Io(obj, obj2);
        }

        @Override // II0OOXOx.XxX0x0xxx
        public /* synthetic */ XxX0x0xxx oIX0oI(OX00O0xII oX00O0xII) {
            return xxX.oIX0oI(this, oX00O0xII);
        }
    };

    R apply(T t, U u) throws Throwable;

    <V> XxX0x0xxx<T, U, V, E> oIX0oI(OX00O0xII<? super R, ? extends V, E> oX00O0xII);
}
