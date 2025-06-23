package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface oOXoIIIo<T, U, E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final oOXoIIIo f180oIX0oI = new oOXoIIIo() { // from class: II0OOXOx.xI
        @Override // II0OOXOx.oOXoIIIo
        public /* synthetic */ oOXoIIIo II0xO0(oOXoIIIo ooxoiiio) {
            return IoOoX.oIX0oI(this, ooxoiiio);
        }

        @Override // II0OOXOx.oOXoIIIo
        public /* synthetic */ oOXoIIIo negate() {
            return IoOoX.II0xO0(this);
        }

        @Override // II0OOXOx.oOXoIIIo
        public /* synthetic */ oOXoIIIo oIX0oI(oOXoIIIo ooxoiiio) {
            return IoOoX.I0Io(this, ooxoiiio);
        }

        @Override // II0OOXOx.oOXoIIIo
        public final boolean test(Object obj, Object obj2) {
            return IoOoX.II0XooXoX(obj, obj2);
        }
    };

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final oOXoIIIo f179II0xO0 = new oOXoIIIo() { // from class: II0OOXOx.oo0xXOI0I
        @Override // II0OOXOx.oOXoIIIo
        public /* synthetic */ oOXoIIIo II0xO0(oOXoIIIo ooxoiiio) {
            return IoOoX.oIX0oI(this, ooxoiiio);
        }

        @Override // II0OOXOx.oOXoIIIo
        public /* synthetic */ oOXoIIIo negate() {
            return IoOoX.II0xO0(this);
        }

        @Override // II0OOXOx.oOXoIIIo
        public /* synthetic */ oOXoIIIo oIX0oI(oOXoIIIo ooxoiiio) {
            return IoOoX.I0Io(this, ooxoiiio);
        }

        @Override // II0OOXOx.oOXoIIIo
        public final boolean test(Object obj, Object obj2) {
            return IoOoX.xxIXOIIO(obj, obj2);
        }
    };

    oOXoIIIo<T, U, E> II0xO0(oOXoIIIo<? super T, ? super U, E> ooxoiiio);

    oOXoIIIo<T, U, E> negate();

    oOXoIIIo<T, U, E> oIX0oI(oOXoIIIo<? super T, ? super U, E> ooxoiiio);

    boolean test(T t, U u) throws Throwable;
}
