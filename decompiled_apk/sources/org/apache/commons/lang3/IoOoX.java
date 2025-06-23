package org.apache.commons.lang3;

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
import org.apache.commons.lang3.I0oOoX;
import org.apache.commons.lang3.IoOoX;

@Deprecated
/* loaded from: classes6.dex */
public class IoOoX {

    @FunctionalInterface
    @Deprecated
    /* loaded from: classes6.dex */
    public interface I0Io<O1, O2, T extends Throwable> {
        boolean test(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    /* loaded from: classes6.dex */
    public interface II0XooXoX<T extends Throwable> {
        void run() throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    /* loaded from: classes6.dex */
    public interface II0xO0<O1, O2, R, T extends Throwable> {
        R apply(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    /* loaded from: classes6.dex */
    public interface Oxx0IOOO<I, T extends Throwable> {
        boolean test(I i) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    /* loaded from: classes6.dex */
    public interface X0o0xo<O, T extends Throwable> {
        void accept(O o) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    /* loaded from: classes6.dex */
    public interface XO<I, R, T extends Throwable> {
        R apply(I i) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    /* loaded from: classes6.dex */
    public interface oIX0oI<O1, O2, T extends Throwable> {
        void accept(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    /* loaded from: classes6.dex */
    public interface oxoX<R, T extends Throwable> {
        R call() throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    /* loaded from: classes6.dex */
    public interface xxIXOIIO<R, T extends Throwable> {
        R get() throws Throwable;
    }

    public static <O> I0oOoX.II0xO0<O> I0oOoX(Stream<O> stream) {
        return new I0oOoX.II0xO0<>(stream);
    }

    public static <O1, O2> BiPredicate<O1, O2> IIXOooo(final I0Io<O1, O2, ?> i0Io) {
        return new BiPredicate() { // from class: org.apache.commons.lang3.OxxIIOOXO
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean oxxXoxO2;
                oxxXoxO2 = IoOoX.oxxXoxO(IoOoX.I0Io.this, obj, obj2);
                return oxxXoxO2;
            }
        };
    }

    public static <O1, O2, O, T extends Throwable> O IXxxXO(final II0xO0<O1, O2, O, T> iI0xO0, final O1 o1, final O2 o2) {
        return (O) xxX(new xxIXOIIO() { // from class: org.apache.commons.lang3.oo0xXOI0I
            @Override // org.apache.commons.lang3.IoOoX.xxIXOIIO
            public final Object get() {
                Object apply;
                apply = IoOoX.II0xO0.this.apply(o1, o2);
                return apply;
            }
        });
    }

    public static RuntimeException Io(Throwable th) {
        Objects.requireNonNull(th, "throwable");
        if (!(th instanceof RuntimeException)) {
            if (!(th instanceof Error)) {
                if (th instanceof IOException) {
                    Oxx0xo.oIX0oI();
                    throw com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.I0Io.oIX0oI((IOException) th);
                }
                throw new UndeclaredThrowableException(th);
            }
            throw ((Error) th);
        }
        throw ((RuntimeException) th);
    }

    public static <I> Predicate<I> O0xOxO(final Oxx0IOOO<I, ?> oxx0IOOO) {
        return new Predicate() { // from class: org.apache.commons.lang3.XI0IXoo
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean XoX2;
                XoX2 = IoOoX.XoX(IoOoX.Oxx0IOOO.this, obj);
                return XoX2;
            }
        };
    }

    public static <O, T extends Throwable> void Oo(final X0o0xo<O, T> x0o0xo, final O o) {
        o0(new II0XooXoX() { // from class: org.apache.commons.lang3.xXxxox0I
            @Override // org.apache.commons.lang3.IoOoX.II0XooXoX
            public final void run() {
                IoOoX.X0o0xo.this.accept(o);
            }
        });
    }

    public static <I, O> Function<I, O> OxI(final XO<I, O, ?> xo2) {
        return new Function() { // from class: org.apache.commons.lang3.oI0IIXIo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object Oxx0xo2;
                Oxx0xo2 = IoOoX.Oxx0xo(IoOoX.XO.this, obj);
                return Oxx0xo2;
            }
        };
    }

    public static <I, O, T extends Throwable> O Oxx0xo(final XO<I, O, T> xo2, final I i) {
        return (O) xxX(new xxIXOIIO() { // from class: org.apache.commons.lang3.XIxXXX0x0
            @Override // org.apache.commons.lang3.IoOoX.xxIXOIIO
            public final Object get() {
                Object apply;
                apply = IoOoX.XO.this.apply(i);
                return apply;
            }
        });
    }

    public static <O1, O2, O> BiFunction<O1, O2, O> OxxIIOOXO(final II0xO0<O1, O2, O, ?> iI0xO0) {
        return new BiFunction() { // from class: org.apache.commons.lang3.xxX
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object IXxxXO2;
                IXxxXO2 = IoOoX.IXxxXO(IoOoX.II0xO0.this, obj, obj2);
                return IXxxXO2;
            }
        };
    }

    public static Runnable X0IIOO(final II0XooXoX<?> iI0XooXoX) {
        return new Runnable() { // from class: org.apache.commons.lang3.IIX0o
            @Override // java.lang.Runnable
            public final void run() {
                IoOoX.o0(IoOoX.II0XooXoX.this);
            }
        };
    }

    public static <O> Supplier<O> XI0IXoo(final xxIXOIIO<O, ?> xxixoiio) {
        return new Supplier() { // from class: org.apache.commons.lang3.XxX0x0xxx
            @Override // java.util.function.Supplier
            public final Object get() {
                Object xxX2;
                xxX2 = IoOoX.xxX(IoOoX.xxIXOIIO.this);
                return xxX2;
            }
        };
    }

    public static <O, T extends Throwable> O XIxXXX0x0(final oxoX<O, T> oxox) {
        oxox.getClass();
        return (O) xxX(new xxIXOIIO() { // from class: org.apache.commons.lang3.O0xOxO
            @Override // org.apache.commons.lang3.IoOoX.xxIXOIIO
            public final Object get() {
                return IoOoX.oxoX.this.call();
            }
        });
    }

    public static <O> I0oOoX.II0xO0<O> XX(Collection<O> collection) {
        Stream stream;
        stream = collection.stream();
        return new I0oOoX.II0xO0<>(stream);
    }

    public static <O, T extends Throwable> boolean XoX(final Oxx0IOOO<O, T> oxx0IOOO, final O o) {
        return XxX0x0xxx(new II0OOXOx.Xx000oIo() { // from class: org.apache.commons.lang3.o00
            @Override // II0OOXOx.Xx000oIo
            public final boolean getAsBoolean() {
                boolean test;
                test = IoOoX.Oxx0IOOO.this.test(o);
                return test;
            }
        });
    }

    public static <T extends Throwable> boolean XxX0x0xxx(II0OOXOx.Xx000oIo<T> xx000oIo) {
        try {
            return xx000oIo.getAsBoolean();
        } catch (Throwable th) {
            throw Io(th);
        }
    }

    public static <T extends Throwable> void o0(II0XooXoX<T> iI0XooXoX) {
        try {
            iI0XooXoX.run();
        } catch (Throwable th) {
            throw Io(th);
        }
    }

    public static <I> Consumer<I> o00(final X0o0xo<I, ?> x0o0xo) {
        return new Consumer() { // from class: org.apache.commons.lang3.xoXoI
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                IoOoX.Oo(IoOoX.X0o0xo.this, obj);
            }
        };
    }

    public static <O1, O2> BiConsumer<O1, O2> oI0IIXIo(final oIX0oI<O1, O2, ?> oix0oi) {
        return new BiConsumer() { // from class: org.apache.commons.lang3.OxI
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                IoOoX.x0xO0oo(IoOoX.oIX0oI.this, obj, obj2);
            }
        };
    }

    @SafeVarargs
    public static void oxXx0IX(II0XooXoX<? extends Throwable> iI0XooXoX, X0o0xo<Throwable, ? extends Throwable> x0o0xo, II0XooXoX<? extends Throwable>... iI0XooXoXArr) {
        if (x0o0xo == null) {
            x0o0xo = new X0o0xo() { // from class: org.apache.commons.lang3.ooXIXxIX
                @Override // org.apache.commons.lang3.IoOoX.X0o0xo
                public final void accept(Object obj) {
                    IoOoX.Io((Throwable) obj);
                }
            };
        }
        if (iI0XooXoXArr != null) {
            for (II0XooXoX<? extends Throwable> iI0XooXoX2 : iI0XooXoXArr) {
                Objects.requireNonNull(iI0XooXoX2, "runnable");
            }
        }
        try {
            iI0XooXoX.run();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        if (iI0XooXoXArr != null) {
            for (II0XooXoX<? extends Throwable> iI0XooXoX3 : iI0XooXoXArr) {
                try {
                    iI0XooXoX3.run();
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
            }
        }
        if (th != null) {
            try {
                x0o0xo.accept(th);
            } catch (Throwable th3) {
                throw Io(th3);
            }
        }
    }

    public static <O1, O2, T extends Throwable> boolean oxxXoxO(final I0Io<O1, O2, T> i0Io, final O1 o1, final O2 o2) {
        return XxX0x0xxx(new II0OOXOx.Xx000oIo() { // from class: org.apache.commons.lang3.IIXOooo
            @Override // II0OOXOx.Xx000oIo
            public final boolean getAsBoolean() {
                boolean test;
                test = IoOoX.I0Io.this.test(o1, o2);
                return test;
            }
        });
    }

    public static <O1, O2, T extends Throwable> void x0xO0oo(final oIX0oI<O1, O2, T> oix0oi, final O1 o1, final O2 o2) {
        o0(new II0XooXoX() { // from class: org.apache.commons.lang3.xI
            @Override // org.apache.commons.lang3.IoOoX.II0XooXoX
            public final void run() {
                IoOoX.oIX0oI.this.accept(o1, o2);
            }
        });
    }

    @SafeVarargs
    public static void xo0x(II0XooXoX<? extends Throwable> iI0XooXoX, II0XooXoX<? extends Throwable>... iI0XooXoXArr) {
        oxXx0IX(iI0XooXoX, null, iI0XooXoXArr);
    }

    public static <O> Callable<O> xoXoI(final oxoX<O, ?> oxox) {
        return new Callable() { // from class: org.apache.commons.lang3.X0IIOO
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object XIxXXX0x02;
                XIxXXX0x02 = IoOoX.XIxXXX0x0(IoOoX.oxoX.this);
                return XIxXXX0x02;
            }
        };
    }

    public static <O, T extends Throwable> O xxX(xxIXOIIO<O, T> xxixoiio) {
        try {
            return xxixoiio.get();
        } catch (Throwable th) {
            throw Io(th);
        }
    }
}
