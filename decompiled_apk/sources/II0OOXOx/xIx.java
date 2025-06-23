package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface xIx<T, E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final xIx f211oIX0oI = new xIx() { // from class: II0OOXOx.OOIXx0x
        @Override // II0OOXOx.xIx
        public /* synthetic */ xIx II0xO0(xIx xix) {
            return xOOxI.oIX0oI(this, xix);
        }

        @Override // II0OOXOx.xIx
        public /* synthetic */ xIx negate() {
            return xOOxI.II0xO0(this);
        }

        @Override // II0OOXOx.xIx
        public /* synthetic */ xIx oIX0oI(xIx xix) {
            return xOOxI.I0Io(this, xix);
        }

        @Override // II0OOXOx.xIx
        public final boolean test(Object obj) {
            return xOOxI.II0XooXoX(obj);
        }
    };

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final xIx f210II0xO0 = new xIx() { // from class: II0OOXOx.xIx0XO
        @Override // II0OOXOx.xIx
        public /* synthetic */ xIx II0xO0(xIx xix) {
            return xOOxI.oIX0oI(this, xix);
        }

        @Override // II0OOXOx.xIx
        public /* synthetic */ xIx negate() {
            return xOOxI.II0xO0(this);
        }

        @Override // II0OOXOx.xIx
        public /* synthetic */ xIx oIX0oI(xIx xix) {
            return xOOxI.I0Io(this, xix);
        }

        @Override // II0OOXOx.xIx
        public final boolean test(Object obj) {
            return xOOxI.xxIXOIIO(obj);
        }
    };

    xIx<T, E> II0xO0(xIx<? super T, E> xix);

    xIx<T, E> negate();

    xIx<T, E> oIX0oI(xIx<? super T, E> xix);

    boolean test(T t) throws Throwable;
}
