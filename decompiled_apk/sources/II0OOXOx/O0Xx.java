package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface O0Xx<E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final O0Xx f123oIX0oI = new O0Xx() { // from class: II0OOXOx.oX
        @Override // II0OOXOx.O0Xx
        public /* synthetic */ O0Xx I0Io(O0Xx o0Xx) {
            return XoI0Ixx0.I0Io(this, o0Xx);
        }

        @Override // II0OOXOx.O0Xx
        public final boolean II0xO0(double d) {
            return XoI0Ixx0.II0XooXoX(d);
        }

        @Override // II0OOXOx.O0Xx
        public /* synthetic */ O0Xx negate() {
            return XoI0Ixx0.II0xO0(this);
        }

        @Override // II0OOXOx.O0Xx
        public /* synthetic */ O0Xx oIX0oI(O0Xx o0Xx) {
            return XoI0Ixx0.oIX0oI(this, o0Xx);
        }
    };

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final O0Xx f122II0xO0 = new O0Xx() { // from class: II0OOXOx.Xo0
        @Override // II0OOXOx.O0Xx
        public /* synthetic */ O0Xx I0Io(O0Xx o0Xx) {
            return XoI0Ixx0.I0Io(this, o0Xx);
        }

        @Override // II0OOXOx.O0Xx
        public final boolean II0xO0(double d) {
            return XoI0Ixx0.xxIXOIIO(d);
        }

        @Override // II0OOXOx.O0Xx
        public /* synthetic */ O0Xx negate() {
            return XoI0Ixx0.II0xO0(this);
        }

        @Override // II0OOXOx.O0Xx
        public /* synthetic */ O0Xx oIX0oI(O0Xx o0Xx) {
            return XoI0Ixx0.oIX0oI(this, o0Xx);
        }
    };

    O0Xx<E> I0Io(O0Xx<E> o0Xx);

    boolean II0xO0(double d) throws Throwable;

    O0Xx<E> negate();

    O0Xx<E> oIX0oI(O0Xx<E> o0Xx);
}
