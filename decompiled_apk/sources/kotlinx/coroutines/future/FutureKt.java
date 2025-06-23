package kotlinx.coroutines.future;

import Oox.x0xO0oo;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.I0oOoX;
import kotlinx.coroutines.IIX0;
import kotlinx.coroutines.OxI;
import kotlinx.coroutines.X0IIOO;
import kotlinx.coroutines.XX0xXo;
import kotlinx.coroutines.xII;

@XX({"SMAP\nFuture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,197:1\n1#2:198\n314#3,11:199\n*S KotlinDebug\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n*L\n172#1:199,11\n*E\n"})
/* loaded from: classes6.dex */
public final class FutureKt {
    @OXOo.OOXIXo
    public static final <T> CompletableFuture<T> I0Io(@OXOo.OOXIXo final I0oOoX<? extends T> i0oOoX) {
        final CompletableFuture<T> oIX0oI2 = com.facebook.gamingservices.cloudgaming.Oxx0IOOO.oIX0oI();
        xoIox(i0oOoX, oIX0oI2);
        i0oOoX.Oo(new Oox.oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.future.FutureKt$asCompletableFuture$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Throwable th) {
                invoke2(th);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO Throwable th) {
                try {
                    oIX0oI2.complete(i0oOoX.oxoX());
                } catch (Throwable th2) {
                    oIX0oI2.completeExceptionally(th2);
                }
            }
        });
        return oIX0oI2;
    }

    @OXOo.OOXIXo
    public static final <T> CompletableFuture<T> II0XooXoX(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo CoroutineStart coroutineStart, @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo) {
        if (!coroutineStart.isLazy()) {
            CoroutineContext X0o0xo2 = CoroutineContextKt.X0o0xo(xii, coroutineContext);
            CompletableFuture<T> oIX0oI2 = com.facebook.gamingservices.cloudgaming.Oxx0IOOO.oIX0oI();
            II0xO0 iI0xO0 = new II0xO0(X0o0xo2, oIX0oI2);
            oIX0oI2.handle(xxIXOIIO.oIX0oI(iI0xO0));
            iI0xO0.OO0(coroutineStart, iI0xO0, x0xo0oo);
            return oIX0oI2;
        }
        throw new IllegalArgumentException((coroutineStart + " start is not supported").toString());
    }

    public static final oXIO0o0XI OOXIXo(kotlinx.coroutines.oXIO0o0XI oxio0o0xi, Object obj, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = XX0xXo.oIX0oI("CompletableFuture was completed exceptionally", th);
            }
        }
        oxio0o0xi.II0xO0(cancellationException);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public static final <T> Object Oxx0IOOO(@OXOo.OOXIXo CompletionStage<T> completionStage, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        final CompletableFuture completableFuture;
        boolean isDone;
        Object obj;
        completableFuture = completionStage.toCompletableFuture();
        isDone = completableFuture.isDone();
        if (isDone) {
            try {
                obj = completableFuture.get();
                return obj;
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        }
        kotlinx.coroutines.x0xO0oo x0xo0oo = new kotlinx.coroutines.x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        final XO xo2 = new XO(x0xo0oo);
        completionStage.handle(xxIXOIIO.oIX0oI(xo2));
        x0xo0oo.ooXIXxIX(new Oox.oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.future.FutureKt$await$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Throwable th) {
                invoke2(th);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO Throwable th) {
                completableFuture.cancel(false);
                xo2.cont = null;
            }
        });
        Object o002 = x0xo0oo.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return o002;
    }

    @OXOo.OOXIXo
    public static final <T> I0oOoX<T> X0o0xo(@OXOo.OOXIXo CompletionStage<T> completionStage) {
        CompletableFuture completableFuture;
        boolean isDone;
        ExecutionException executionException;
        Throwable cause;
        Object obj;
        completableFuture = completionStage.toCompletableFuture();
        isDone = completableFuture.isDone();
        if (isDone) {
            try {
                obj = completableFuture.get();
                return X0IIOO.oIX0oI(obj);
            } catch (Throwable th) {
                th = th;
                if (th instanceof ExecutionException) {
                    executionException = (ExecutionException) th;
                } else {
                    executionException = null;
                }
                if (executionException != null && (cause = executionException.getCause()) != null) {
                    th = cause;
                }
                OxI I0Io2 = X0IIOO.I0Io(null, 1, null);
                I0Io2.I0Io(th);
                return I0Io2;
            }
        }
        final OxI I0Io3 = X0IIOO.I0Io(null, 1, null);
        final x0xO0oo<T, Throwable, Object> x0xo0oo = new x0xO0oo<T, Throwable, Object>() { // from class: kotlinx.coroutines.future.FutureKt$asDeferred$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Throwable th2) {
                return invoke2((FutureKt$asDeferred$2<T>) obj2, th2);
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
            
                r0 = r0.getCause();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invoke2(T r2, java.lang.Throwable r3) {
                /*
                    r1 = this;
                    if (r3 != 0) goto Lb
                    kotlinx.coroutines.OxI<T> r3 = r1     // Catch: java.lang.Throwable -> L9
                    boolean r2 = r3.oO(r2)     // Catch: java.lang.Throwable -> L9
                    goto L27
                L9:
                    r2 = move-exception
                    goto L2c
                Lb:
                    kotlinx.coroutines.OxI<T> r2 = r1     // Catch: java.lang.Throwable -> L9
                    boolean r0 = kotlinx.coroutines.future.I0Io.oIX0oI(r3)     // Catch: java.lang.Throwable -> L9
                    if (r0 == 0) goto L18
                    java.util.concurrent.CompletionException r0 = kotlinx.coroutines.future.oxoX.oIX0oI(r3)     // Catch: java.lang.Throwable -> L9
                    goto L19
                L18:
                    r0 = 0
                L19:
                    if (r0 == 0) goto L23
                    java.lang.Throwable r0 = kotlinx.coroutines.future.X0o0xo.oIX0oI(r0)     // Catch: java.lang.Throwable -> L9
                    if (r0 != 0) goto L22
                    goto L23
                L22:
                    r3 = r0
                L23:
                    boolean r2 = r2.I0Io(r3)     // Catch: java.lang.Throwable -> L9
                L27:
                    java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L9
                    goto L33
                L2c:
                    kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
                    kotlinx.coroutines.Xx000oIo.II0xO0(r3, r2)
                    kotlin.oXIO0o0XI r2 = kotlin.oXIO0o0XI.f29392oIX0oI
                L33:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.future.FutureKt$asDeferred$2.invoke2(java.lang.Object, java.lang.Throwable):java.lang.Object");
            }
        };
        completionStage.handle(new BiFunction() { // from class: kotlinx.coroutines.future.oOoXoXO
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj2, Object obj3) {
                Object XO2;
                XO2 = FutureKt.XO(x0xO0oo.this, obj2, (Throwable) obj3);
                return XO2;
            }
        });
        IIX0.o00(I0Io3, completableFuture);
        return I0Io3;
    }

    public static final Object XO(x0xO0oo x0xo0oo, Object obj, Throwable th) {
        return x0xo0oo.invoke(obj, th);
    }

    @OXOo.OOXIXo
    public static final CompletableFuture<oXIO0o0XI> oxoX(@OXOo.OOXIXo kotlinx.coroutines.oXIO0o0XI oxio0o0xi) {
        final CompletableFuture<oXIO0o0XI> oIX0oI2 = com.facebook.gamingservices.cloudgaming.Oxx0IOOO.oIX0oI();
        xoIox(oxio0o0xi, oIX0oI2);
        oxio0o0xi.Oo(new Oox.oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.future.FutureKt$asCompletableFuture$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Throwable th) {
                invoke2(th);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO Throwable th) {
                if (th == null) {
                    oIX0oI2.complete(oXIO0o0XI.f29392oIX0oI);
                } else {
                    oIX0oI2.completeExceptionally(th);
                }
            }
        });
        return oIX0oI2;
    }

    public static final void xoIox(final kotlinx.coroutines.oXIO0o0XI oxio0o0xi, CompletableFuture<?> completableFuture) {
        completableFuture.handle((BiFunction<? super Object, Throwable, ? extends U>) new BiFunction() { // from class: kotlinx.coroutines.future.ooOOo0oXI
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                oXIO0o0XI OOXIXo2;
                OOXIXo2 = FutureKt.OOXIXo(kotlinx.coroutines.oXIO0o0XI.this, obj, (Throwable) obj2);
                return OOXIXo2;
            }
        });
    }

    public static /* synthetic */ CompletableFuture xxIXOIIO(xII xii, CoroutineContext coroutineContext, CoroutineStart coroutineStart, x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return II0XooXoX(xii, coroutineContext, coroutineStart, x0xo0oo);
    }
}
