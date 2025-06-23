package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface XOxIOxOx<T, E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final XOxIOxOx f157oIX0oI = new XOxIOxOx() { // from class: II0OOXOx.IO
        @Override // II0OOXOx.XOxIOxOx
        public final void accept(Object obj) {
            x0o.I0Io(obj);
        }

        @Override // II0OOXOx.XOxIOxOx
        public /* synthetic */ XOxIOxOx oIX0oI(XOxIOxOx xOxIOxOx) {
            return x0o.oIX0oI(this, xOxIOxOx);
        }
    };

    void accept(T t) throws Throwable;

    XOxIOxOx<T, E> oIX0oI(XOxIOxOx<? super T, E> xOxIOxOx);
}
