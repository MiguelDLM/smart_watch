package II0OOXOx;

import java.util.Objects;

/* loaded from: classes6.dex */
public final /* synthetic */ class xOOxI {
    static {
        xIx xix = xIx.f211oIX0oI;
    }

    public static xIx I0Io(final xIx xix, final xIx xix2) {
        Objects.requireNonNull(xix2);
        return new xIx() { // from class: II0OOXOx.OXXoIoXI
            @Override // II0OOXOx.xIx
            public /* synthetic */ xIx II0xO0(xIx xix3) {
                return xOOxI.oIX0oI(this, xix3);
            }

            @Override // II0OOXOx.xIx
            public /* synthetic */ xIx negate() {
                return xOOxI.II0xO0(this);
            }

            @Override // II0OOXOx.xIx
            public /* synthetic */ xIx oIX0oI(xIx xix3) {
                return xOOxI.I0Io(this, xix3);
            }

            @Override // II0OOXOx.xIx
            public final boolean test(Object obj) {
                return xOOxI.XO(xIx.this, xix2, obj);
            }
        };
    }

    public static /* synthetic */ boolean II0XooXoX(Object obj) throws Throwable {
        return false;
    }

    public static xIx II0xO0(final xIx xix) {
        return new xIx() { // from class: II0OOXOx.oXxx000
            @Override // II0OOXOx.xIx
            public /* synthetic */ xIx II0xO0(xIx xix2) {
                return xOOxI.oIX0oI(this, xix2);
            }

            @Override // II0OOXOx.xIx
            public /* synthetic */ xIx negate() {
                return xOOxI.II0xO0(this);
            }

            @Override // II0OOXOx.xIx
            public /* synthetic */ xIx oIX0oI(xIx xix2) {
                return xOOxI.I0Io(this, xix2);
            }

            @Override // II0OOXOx.xIx
            public final boolean test(Object obj) {
                return xOOxI.X0o0xo(xIx.this, obj);
            }
        };
    }

    public static <T, E extends Throwable> xIx<T, E> Oxx0IOOO() {
        return xIx.f211oIX0oI;
    }

    public static /* synthetic */ boolean X0o0xo(xIx xix, Object obj) throws Throwable {
        return !xix.test(obj);
    }

    public static /* synthetic */ boolean XO(xIx xix, xIx xix2, Object obj) throws Throwable {
        if (!xix.test(obj) && !xix2.test(obj)) {
            return false;
        }
        return true;
    }

    public static xIx oIX0oI(final xIx xix, final xIx xix2) {
        Objects.requireNonNull(xix2);
        return new xIx() { // from class: II0OOXOx.XooIO0oo0
            @Override // II0OOXOx.xIx
            public /* synthetic */ xIx II0xO0(xIx xix3) {
                return xOOxI.oIX0oI(this, xix3);
            }

            @Override // II0OOXOx.xIx
            public /* synthetic */ xIx negate() {
                return xOOxI.II0xO0(this);
            }

            @Override // II0OOXOx.xIx
            public /* synthetic */ xIx oIX0oI(xIx xix3) {
                return xOOxI.I0Io(this, xix3);
            }

            @Override // II0OOXOx.xIx
            public final boolean test(Object obj) {
                return xOOxI.oxoX(xIx.this, xix2, obj);
            }
        };
    }

    public static /* synthetic */ boolean oxoX(xIx xix, xIx xix2, Object obj) throws Throwable {
        if (xix.test(obj) && xix2.test(obj)) {
            return true;
        }
        return false;
    }

    public static <T, E extends Throwable> xIx<T, E> xoIox() {
        return xIx.f210II0xO0;
    }

    public static /* synthetic */ boolean xxIXOIIO(Object obj) throws Throwable {
        return true;
    }
}
