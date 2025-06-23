package II0OOXOx;

import XOOO0O.I0Io;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/* loaded from: classes6.dex */
public class xoXoI {
    public static RuntimeException I0oOIX(Throwable th) {
        Objects.requireNonNull(th, "throwable");
        if (!(th instanceof RuntimeException)) {
            if (!(th instanceof Error)) {
                if (th instanceof IOException) {
                    org.apache.commons.lang3.Oxx0xo.oIX0oI();
                    throw com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.I0Io.oIX0oI((IOException) th);
                }
                throw new UndeclaredThrowableException(th);
            }
            throw ((Error) th);
        }
        throw ((RuntimeException) th);
    }

    public static <T, R> Function<T, R> IIX0o(final OX00O0xII<T, R, ?> oX00O0xII) {
        return new Function() { // from class: II0OOXOx.x0XOIxOo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object O0xOxO2;
                O0xOxO2 = xoXoI.O0xOxO(OX00O0xII.this, obj);
                return O0xOxO2;
            }
        };
    }

    public static <E extends Throwable> void IIXOooo(final oxxXoxO<E> oxxxoxo, final double d) {
        xoxXI(new oXO0oOx0() { // from class: II0OOXOx.I0Io
            @Override // II0OOXOx.oXO0oOx0
            public final void run() {
                oxxXoxO.this.accept(d);
            }
        });
    }

    public static <E extends Throwable> long IO(OO0<E> oo0) {
        try {
            return oo0.oIX0oI();
        } catch (Throwable th) {
            throw I0oOIX(th);
        }
    }

    public static <T, E extends Throwable> T IoOoX(IIOIX<T, E> iioix) {
        try {
            return iioix.get();
        } catch (Throwable th) {
            throw I0oOIX(th);
        }
    }

    public static <T> I0Io.II0xO0<T> IoOoo(Stream<T> stream) {
        return new I0Io.II0xO0<>(stream);
    }

    public static <T, R, E extends Throwable> R O0xOxO(final OX00O0xII<T, R, E> oX00O0xII, final T t) {
        return (R) IoOoX(new IIOIX() { // from class: II0OOXOx.oI0IIXIo
            @Override // II0OOXOx.IIOIX
            public final Object get() {
                Object apply;
                apply = OX00O0xII.this.apply(t);
                return apply;
            }
        });
    }

    public static <E> I0Io.II0xO0<E> OO(Collection<E> collection) {
        Stream stream;
        stream = collection.stream();
        return new I0Io.II0xO0<>(stream);
    }

    @SafeVarargs
    public static void OO0x0xX(oXO0oOx0<? extends Throwable> oxo0oox0, XOxIOxOx<Throwable, ? extends Throwable> xOxIOxOx, oXO0oOx0<? extends Throwable>... oxo0oox0Arr) {
        if (xOxIOxOx == null) {
            xOxIOxOx = new XOxIOxOx() { // from class: II0OOXOx.X0o0xo
                @Override // II0OOXOx.XOxIOxOx
                public final void accept(Object obj) {
                    xoXoI.I0oOIX((Throwable) obj);
                }

                @Override // II0OOXOx.XOxIOxOx
                public /* synthetic */ XOxIOxOx oIX0oI(XOxIOxOx xOxIOxOx2) {
                    return x0o.oIX0oI(this, xOxIOxOx2);
                }
            };
        }
        if (oxo0oox0Arr != null) {
            for (oXO0oOx0<? extends Throwable> oxo0oox02 : oxo0oox0Arr) {
                Objects.requireNonNull(oxo0oox02, "runnable");
            }
        }
        try {
            oxo0oox0.run();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        if (oxo0oox0Arr != null) {
            for (oXO0oOx0<? extends Throwable> oxo0oox03 : oxo0oox0Arr) {
                try {
                    oxo0oox03.run();
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
            }
        }
        if (th != null) {
            try {
                xOxIOxOx.accept(th);
            } catch (Throwable th3) {
                throw I0oOIX(th3);
            }
        }
    }

    public static <T, U, R, E extends Throwable> R OxI(final XxX0x0xxx<T, U, R, E> xxX0x0xxx, final T t, final U u) {
        return (R) IoOoX(new IIOIX() { // from class: II0OOXOx.IIXOooo
            @Override // II0OOXOx.IIOIX
            public final Object get() {
                Object apply;
                apply = XxX0x0xxx.this.apply(t, u);
                return apply;
            }
        });
    }

    public static <T, E extends Throwable> void OxxIIOOXO(final XOxIOxOx<T, E> xOxIOxOx, final T t) {
        xoxXI(new oXO0oOx0() { // from class: II0OOXOx.OOXIXo
            @Override // II0OOXOx.oXO0oOx0
            public final void run() {
                XOxIOxOx.this.accept(t);
            }
        });
    }

    public static <E extends Throwable> int X00IoxXI(OIOoIIOIx<E> oIOoIIOIx) {
        try {
            return oIOoIIOIx.oIX0oI();
        } catch (Throwable th) {
            throw I0oOIX(th);
        }
    }

    public static <E extends Throwable> double X0IIOO(final OI0<E> oi0, final double d, final double d2) {
        return Xx000oIo(new I0oOIX() { // from class: II0OOXOx.oOoXoXO
            @Override // II0OOXOx.I0oOIX
            public final double oIX0oI() {
                double oIX0oI2;
                oIX0oI2 = OI0.this.oIX0oI(d, d2);
                return oIX0oI2;
            }
        });
    }

    public static <T, U> BiConsumer<T, U> XI0IXoo(final X0IIOO<T, U, ?> x0iioo) {
        return new BiConsumer() { // from class: II0OOXOx.oO
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                xoXoI.oI0IIXIo(X0IIOO.this, obj, obj2);
            }
        };
    }

    @SafeVarargs
    public static void XIo0oOXIx(oXO0oOx0<? extends Throwable> oxo0oox0, oXO0oOx0<? extends Throwable>... oxo0oox0Arr) {
        OO0x0xX(oxo0oox0, null, oxo0oox0Arr);
    }

    public static <T, U, R> BiFunction<T, U, R> XIxXXX0x0(final XxX0x0xxx<T, U, R, ?> xxX0x0xxx) {
        return new BiFunction() { // from class: II0OOXOx.II0XooXoX
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object OxI2;
                OxI2 = xoXoI.OxI(XxX0x0xxx.this, obj, obj2);
                return OxI2;
            }
        };
    }

    public static <E extends Throwable> double Xx000oIo(I0oOIX<E> i0oOIX) {
        try {
            return i0oOIX.oIX0oI();
        } catch (Throwable th) {
            throw I0oOIX(th);
        }
    }

    public static <V> Callable<V> XxX0x0xxx(final X00IoxXI<V, ?> x00IoxXI) {
        return new Callable() { // from class: II0OOXOx.xoIox
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object oo2;
                oo2 = xoXoI.oo(X00IoxXI.this);
                return oo2;
            }
        };
    }

    public static <E extends Throwable> void o00(final oXxOI0oIx<E> oxxoi0oix, final long j) {
        xoxXI(new oXO0oOx0() { // from class: II0OOXOx.II0xO0
            @Override // II0OOXOx.oXO0oOx0
            public final void run() {
                oXxOI0oIx.this.accept(j);
            }
        });
    }

    public static <T, U, E extends Throwable> void oI0IIXIo(final X0IIOO<T, U, E> x0iioo, final T t, final U u) {
        xoxXI(new oXO0oOx0() { // from class: II0OOXOx.OxxIIOOXO
            @Override // II0OOXOx.oXO0oOx0
            public final void run() {
                X0IIOO.this.accept(t, u);
            }
        });
    }

    public static <E extends Throwable> boolean oOXoIIIo(Xx000oIo<E> xx000oIo) {
        try {
            return xx000oIo.getAsBoolean();
        } catch (Throwable th) {
            throw I0oOIX(th);
        }
    }

    public static <V, E extends Throwable> V oo(final X00IoxXI<V, E> x00IoxXI) {
        x00IoxXI.getClass();
        return (V) IoOoX(new IIOIX() { // from class: II0OOXOx.ooOOo0oXI
            @Override // II0OOXOx.IIOIX
            public final Object get() {
                return X00IoxXI.this.call();
            }
        });
    }

    public static <T> Supplier<T> oo0xXOI0I(final IIOIX<T, ?> iioix) {
        return new Supplier() { // from class: II0OOXOx.XO
            @Override // java.util.function.Supplier
            public final Object get() {
                Object IoOoX2;
                IoOoX2 = xoXoI.IoOoX(IIOIX.this);
                return IoOoX2;
            }
        };
    }

    public static <T> Predicate<T> ooXIXxIX(final xIx<T, ?> xix) {
        return new Predicate() { // from class: II0OOXOx.IXxxXO
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean x0xO2;
                x0xO2 = xoXoI.x0xO(xIx.this, obj);
                return x0xO2;
            }
        };
    }

    public static <T, E extends Throwable> boolean x0xO(final xIx<T, E> xix, final T t) {
        return oOXoIIIo(new Xx000oIo() { // from class: II0OOXOx.oxoX
            @Override // II0OOXOx.Xx000oIo
            public final boolean getAsBoolean() {
                boolean test;
                test = xIx.this.test(t);
                return test;
            }
        });
    }

    public static Runnable xI(final oXO0oOx0<?> oxo0oox0) {
        return new Runnable() { // from class: II0OOXOx.xxIXOIIO
            @Override // java.lang.Runnable
            public final void run() {
                xoXoI.xoxXI(oXO0oOx0.this);
            }
        };
    }

    public static <T> Consumer<T> xXxxox0I(final XOxIOxOx<T, ?> xOxIOxOx) {
        return new Consumer() { // from class: II0OOXOx.Oxx0xo
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                xoXoI.OxxIIOOXO(XOxIOxOx.this, obj);
            }
        };
    }

    public static <T, U, E extends Throwable> boolean xoIxX(final oOXoIIIo<T, U, E> ooxoiiio, final T t, final U u) {
        return oOXoIIIo(new Xx000oIo() { // from class: II0OOXOx.Oxx0IOOO
            @Override // II0OOXOx.Xx000oIo
            public final boolean getAsBoolean() {
                boolean test;
                test = oOXoIIIo.this.test(t, u);
                return test;
            }
        });
    }

    public static <E extends Throwable> void xoXoI(final oOo<E> ooo, final int i) {
        xoxXI(new oXO0oOx0() { // from class: II0OOXOx.x0xO0oo
            @Override // II0OOXOx.oXO0oOx0
            public final void run() {
                oOo.this.accept(i);
            }
        });
    }

    public static <E extends Throwable> void xoxXI(oXO0oOx0<E> oxo0oox0) {
        try {
            oxo0oox0.run();
        } catch (Throwable th) {
            throw I0oOIX(th);
        }
    }

    public static <T, U> BiPredicate<T, U> xxX(final oOXoIIIo<T, U, ?> ooxoiiio) {
        return new BiPredicate() { // from class: II0OOXOx.oIX0oI
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean xoIxX2;
                xoIxX2 = xoXoI.xoIxX(oOXoIIIo.this, obj, obj2);
                return xoIxX2;
            }
        };
    }
}
