package kotlinx.coroutines.flow;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.XX;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class LintKt {
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @XX(expression = "this", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> I0Io(@OXOo.OOXIXo x0XOIxOo<? extends T> x0xoixoo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @XX(expression = "this", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0XooXoX(@OXOo.OOXIXo x0XOIxOo<? extends T> x0xoixoo, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void II0xO0(XO xo2, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        oIX0oI(xo2, cancellationException);
    }

    @xx0o0O.XO
    public static final <T> Object IXxxXO(x0XOIxOo<? extends T> x0xoixoo, Set<T> set, kotlin.coroutines.I0Io<?> i0Io) {
        IIX0o.x0XOIxOo(x0xoixoo, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        xxX.X0o0xo(0);
        Oxx0IOOO.XooIO0oo0(x0xoixoo, set, i0Io);
        xxX.X0o0xo(1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    public static final boolean OOXIXo(@OXOo.OOXIXo XO<?> xo2) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @xx0o0O.XO
    public static final <T> Object Oo(x0XOIxOo<? extends T> x0xoixoo, kotlin.coroutines.I0Io<? super List<? extends T>> i0Io) {
        Object I0Io2;
        IIX0o.x0XOIxOo(x0xoixoo, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        xxX.X0o0xo(0);
        I0Io2 = FlowKt__CollectionKt.I0Io(x0xoixoo, null, i0Io, 1, null);
        xxX.X0o0xo(1);
        return I0Io2;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @XX(expression = "this", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oxx0IOOO(@OXOo.OOXIXo IIXOooo<? extends T> iIXOooo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @xx0o0O.XO
    public static final <T> Object Oxx0xo(x0XOIxOo<? extends T> x0xoixoo, kotlin.coroutines.I0Io<? super Set<? extends T>> i0Io) {
        Object X0o0xo2;
        IIX0o.x0XOIxOo(x0xoixoo, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        xxX.X0o0xo(0);
        X0o0xo2 = FlowKt__CollectionKt.X0o0xo(x0xoixoo, null, i0Io, 1, null);
        xxX.X0o0xo(1);
        return X0o0xo2;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @XX(expression = "this", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0o0xo(@OXOo.OOXIXo IIXOooo<? extends T> iIXOooo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @xx0o0O.XO
    public static final <T> Object XO(x0XOIxOo<? extends T> x0xoixoo, kotlin.coroutines.I0Io<? super Integer> i0Io) {
        IIX0o.x0XOIxOo(x0xoixoo, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.count>");
        xxX.X0o0xo(0);
        Object XoX2 = Oxx0IOOO.XoX(x0xoixoo, i0Io);
        xxX.X0o0xo(1);
        return XoX2;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith = @XX(expression = "currentCoroutineContext().cancel(cause)", imports = {}))
    public static final void oIX0oI(@OXOo.OOXIXo XO<?> xo2, @OXOo.oOoXoXO CancellationException cancellationException) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @XX(expression = "this", imports = {}))
    @xx0o0O.XO
    public static final <T> X0o0xo<T> oO(x0XOIxOo<? extends T> x0xoixoo, Oox.Oxx0xo<? super XO<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> oxx0xo) {
        IIX0o.x0XOIxOo(x0xoixoo, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retryWhen>");
        return Oxx0IOOO.XoIxOXIXo(x0xoixoo, oxx0xo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "isActive is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith = @XX(expression = "currentCoroutineContext().isActive", imports = {}))
    public static /* synthetic */ void oOoXoXO(XO xo2) {
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @XX(expression = "this", imports = {}))
    @xx0o0O.XO
    public static final <T> X0o0xo<T> ooOOo0oXI(x0XOIxOo<? extends T> x0xoixoo, long j, Oox.x0xO0oo<? super Throwable, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        IIX0o.x0XOIxOo(x0xoixoo, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return Oxx0IOOO.oXIoO(x0xoixoo, j, x0xo0oo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator typically has not effect, it can only catch exceptions from 'onSubscribe' operator", replaceWith = @XX(expression = "this", imports = {}))
    @xx0o0O.XO
    public static final <T> X0o0xo<T> oxoX(x0XOIxOo<? extends T> x0xoixoo, Oox.IXxxXO<? super XO<? super T>, ? super Throwable, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        IIX0o.x0XOIxOo(x0xoixoo, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.catch>");
        return Oxx0IOOO.OxxIIOOXO(x0xoixoo, iXxxXO);
    }

    public static /* synthetic */ X0o0xo x0XOIxOo(x0XOIxOo x0xoixoo, long j, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            x0xo0oo = new LintKt$retry$1(null);
        }
        IIX0o.x0XOIxOo(x0xoixoo, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return Oxx0IOOO.oXIoO(x0xoixoo, j, x0xo0oo);
    }

    @xx0o0O.XO
    public static final <T> Object x0xO0oo(x0XOIxOo<? extends T> x0xoixoo, List<T> list, kotlin.coroutines.I0Io<?> i0Io) {
        IIX0o.x0XOIxOo(x0xoixoo, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        xxX.X0o0xo(0);
        Oxx0IOOO.XO00XOO(x0xoixoo, list, i0Io);
        xxX.X0o0xo(1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith = @XX(expression = "currentCoroutineContext()", imports = {}))
    public static /* synthetic */ void xoIox(XO xo2) {
    }

    @OXOo.OOXIXo
    public static final CoroutineContext xxIXOIIO(@OXOo.OOXIXo XO<?> xo2) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }
}
