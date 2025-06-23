package Xx;

import java.util.function.Predicate;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* loaded from: classes6.dex */
    public static class II0xO0<A extends Comparable<A>> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final A f4173oIX0oI;

        public final boolean I0Io(A a2, A a3) {
            if (Oxx0IOOO(a2) && xxIXOIIO(a3)) {
                return true;
            }
            return false;
        }

        public boolean II0XooXoX(A a2) {
            if (this.f4173oIX0oI.compareTo(a2) < 0) {
                return true;
            }
            return false;
        }

        public boolean II0xO0(A a2, A a3) {
            if (!oxoX(a2, a3) && !oxoX(a3, a2)) {
                return false;
            }
            return true;
        }

        public boolean Oxx0IOOO(A a2) {
            if (this.f4173oIX0oI.compareTo(a2) >= 0) {
                return true;
            }
            return false;
        }

        public boolean X0o0xo(A a2) {
            if (this.f4173oIX0oI.compareTo(a2) == 0) {
                return true;
            }
            return false;
        }

        public boolean XO(A a2) {
            if (this.f4173oIX0oI.compareTo(a2) > 0) {
                return true;
            }
            return false;
        }

        public boolean oIX0oI(A a2, A a3) {
            if (!I0Io(a2, a3) && !I0Io(a3, a2)) {
                return false;
            }
            return true;
        }

        public final boolean oxoX(A a2, A a3) {
            if (XO(a2) && II0XooXoX(a3)) {
                return true;
            }
            return false;
        }

        public boolean xxIXOIIO(A a2) {
            if (this.f4173oIX0oI.compareTo(a2) <= 0) {
                return true;
            }
            return false;
        }

        public II0xO0(A a2) {
            this.f4173oIX0oI = a2;
        }
    }

    public static <A extends Comparable<A>> Predicate<A> II0XooXoX(final A a2, final A a3) {
        return new Predicate() { // from class: Xx.X0o0xo
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean ooOOo0oXI2;
                ooOOo0oXI2 = II0XooXoX.ooOOo0oXI(a2, a3, (Comparable) obj);
                return ooOOo0oXI2;
            }
        };
    }

    public static <A extends Comparable<A>> Predicate<A> IXxxXO(final A a2) {
        return new Predicate() { // from class: Xx.Oxx0IOOO
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean x0xO0oo2;
                x0xO0oo2 = II0XooXoX.x0xO0oo(a2, (Comparable) obj);
                return x0xO0oo2;
            }
        };
    }

    public static <A extends Comparable<A>> II0xO0<A> OOXIXo(A a2) {
        return new II0xO0<>(a2);
    }

    public static /* synthetic */ boolean Oo(Comparable comparable, Comparable comparable2) {
        return OOXIXo(comparable2).II0XooXoX(comparable);
    }

    public static <A extends Comparable<A>> Predicate<A> Oxx0IOOO(final A a2, final A a3) {
        return new Predicate() { // from class: Xx.oxoX
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean oOoXoXO2;
                oOoXoXO2 = II0XooXoX.oOoXoXO(a2, a3, (Comparable) obj);
                return oOoXoXO2;
            }
        };
    }

    public static <A extends Comparable<A>> Predicate<A> Oxx0xo(final A a2) {
        return new Predicate() { // from class: Xx.XO
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean Oo2;
                Oo2 = II0XooXoX.Oo(a2, (Comparable) obj);
                return Oo2;
            }
        };
    }

    public static /* synthetic */ boolean oO(Comparable comparable, Comparable comparable2) {
        return OOXIXo(comparable2).XO(comparable);
    }

    public static /* synthetic */ boolean oOoXoXO(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return OOXIXo(comparable3).oIX0oI(comparable, comparable2);
    }

    public static /* synthetic */ boolean ooOOo0oXI(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return OOXIXo(comparable3).II0xO0(comparable, comparable2);
    }

    public static /* synthetic */ boolean x0XOIxOo(Comparable comparable, Comparable comparable2) {
        return OOXIXo(comparable2).Oxx0IOOO(comparable);
    }

    public static /* synthetic */ boolean x0xO0oo(Comparable comparable, Comparable comparable2) {
        return OOXIXo(comparable2).xxIXOIIO(comparable);
    }

    public static <A extends Comparable<A>> Predicate<A> xoIox(final A a2) {
        return new Predicate() { // from class: Xx.I0Io
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean oO2;
                oO2 = II0XooXoX.oO(a2, (Comparable) obj);
                return oO2;
            }
        };
    }

    public static <A extends Comparable<A>> Predicate<A> xxIXOIIO(final A a2) {
        return new Predicate() { // from class: Xx.II0xO0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean x0XOIxOo2;
                x0XOIxOo2 = II0XooXoX.x0XOIxOo(a2, (Comparable) obj);
                return x0XOIxOo2;
            }
        };
    }
}
