package II0OOXOx;

import java.util.Objects;

/* loaded from: classes6.dex */
public final /* synthetic */ class IoOoX {
    static {
        oOXoIIIo ooxoiiio = oOXoIIIo.f180oIX0oI;
    }

    public static oOXoIIIo I0Io(final oOXoIIIo ooxoiiio, final oOXoIIIo ooxoiiio2) {
        Objects.requireNonNull(ooxoiiio2);
        return new oOXoIIIo() { // from class: II0OOXOx.ooXIXxIX
            @Override // II0OOXOx.oOXoIIIo
            public /* synthetic */ oOXoIIIo II0xO0(oOXoIIIo ooxoiiio3) {
                return IoOoX.oIX0oI(this, ooxoiiio3);
            }

            @Override // II0OOXOx.oOXoIIIo
            public /* synthetic */ oOXoIIIo negate() {
                return IoOoX.II0xO0(this);
            }

            @Override // II0OOXOx.oOXoIIIo
            public /* synthetic */ oOXoIIIo oIX0oI(oOXoIIIo ooxoiiio3) {
                return IoOoX.I0Io(this, ooxoiiio3);
            }

            @Override // II0OOXOx.oOXoIIIo
            public final boolean test(Object obj, Object obj2) {
                return IoOoX.XO(oOXoIIIo.this, ooxoiiio2, obj, obj2);
            }
        };
    }

    public static /* synthetic */ boolean II0XooXoX(Object obj, Object obj2) throws Throwable {
        return false;
    }

    public static oOXoIIIo II0xO0(final oOXoIIIo ooxoiiio) {
        return new oOXoIIIo() { // from class: II0OOXOx.xXxxox0I
            @Override // II0OOXOx.oOXoIIIo
            public /* synthetic */ oOXoIIIo II0xO0(oOXoIIIo ooxoiiio2) {
                return IoOoX.oIX0oI(this, ooxoiiio2);
            }

            @Override // II0OOXOx.oOXoIIIo
            public /* synthetic */ oOXoIIIo negate() {
                return IoOoX.II0xO0(this);
            }

            @Override // II0OOXOx.oOXoIIIo
            public /* synthetic */ oOXoIIIo oIX0oI(oOXoIIIo ooxoiiio2) {
                return IoOoX.I0Io(this, ooxoiiio2);
            }

            @Override // II0OOXOx.oOXoIIIo
            public final boolean test(Object obj, Object obj2) {
                return IoOoX.X0o0xo(oOXoIIIo.this, obj, obj2);
            }
        };
    }

    public static <T, U, E extends Throwable> oOXoIIIo<T, U, E> Oxx0IOOO() {
        return oOXoIIIo.f180oIX0oI;
    }

    public static /* synthetic */ boolean X0o0xo(oOXoIIIo ooxoiiio, Object obj, Object obj2) throws Throwable {
        return !ooxoiiio.test(obj, obj2);
    }

    public static /* synthetic */ boolean XO(oOXoIIIo ooxoiiio, oOXoIIIo ooxoiiio2, Object obj, Object obj2) throws Throwable {
        if (!ooxoiiio.test(obj, obj2) && !ooxoiiio2.test(obj, obj2)) {
            return false;
        }
        return true;
    }

    public static oOXoIIIo oIX0oI(final oOXoIIIo ooxoiiio, final oOXoIIIo ooxoiiio2) {
        Objects.requireNonNull(ooxoiiio2);
        return new oOXoIIIo() { // from class: II0OOXOx.IIX0o
            @Override // II0OOXOx.oOXoIIIo
            public /* synthetic */ oOXoIIIo II0xO0(oOXoIIIo ooxoiiio3) {
                return IoOoX.oIX0oI(this, ooxoiiio3);
            }

            @Override // II0OOXOx.oOXoIIIo
            public /* synthetic */ oOXoIIIo negate() {
                return IoOoX.II0xO0(this);
            }

            @Override // II0OOXOx.oOXoIIIo
            public /* synthetic */ oOXoIIIo oIX0oI(oOXoIIIo ooxoiiio3) {
                return IoOoX.I0Io(this, ooxoiiio3);
            }

            @Override // II0OOXOx.oOXoIIIo
            public final boolean test(Object obj, Object obj2) {
                return IoOoX.oxoX(oOXoIIIo.this, ooxoiiio2, obj, obj2);
            }
        };
    }

    public static /* synthetic */ boolean oxoX(oOXoIIIo ooxoiiio, oOXoIIIo ooxoiiio2, Object obj, Object obj2) throws Throwable {
        if (ooxoiiio.test(obj, obj2) && ooxoiiio2.test(obj, obj2)) {
            return true;
        }
        return false;
    }

    public static <T, U, E extends Throwable> oOXoIIIo<T, U, E> xoIox() {
        return oOXoIIIo.f179II0xO0;
    }

    public static /* synthetic */ boolean xxIXOIIO(Object obj, Object obj2) throws Throwable {
        return true;
    }
}
