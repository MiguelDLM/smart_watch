package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.o0oIxOo;
import kotlinx.coroutines.x0xO0oo;

@XX({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,206:1\n154#1,8:207\n154#1,8:215\n154#1,8:223\n154#1,8:231\n43#1,5:239\n154#1,8:244\n43#1,5:252\n154#1,8:257\n154#1,8:265\n154#1,8:273\n154#1,8:281\n314#2,11:289\n*S KotlinDebug\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n*L\n47#1:207,8\n58#1:215,8\n71#1:223,8\n84#1:231,8\n98#1:239,5\n98#1:244,8\n98#1:252,5\n98#1:257,8\n111#1:265,8\n124#1:273,8\n137#1:281,8\n177#1:289,11\n*E\n"})
/* loaded from: classes.dex */
public final class WithLifecycleStateKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1, androidx.lifecycle.LifecycleObserver] */
    @o0
    @OXOo.oOoXoXO
    public static final <R> Object suspendWithStateAtLeastUnchecked(@OXOo.OOXIXo final Lifecycle lifecycle, @OXOo.OOXIXo final Lifecycle.State state, boolean z, @OXOo.OOXIXo final CoroutineDispatcher coroutineDispatcher, @OXOo.OOXIXo final Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        final x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        final ?? r1 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@OXOo.OOXIXo LifecycleOwner source, @OXOo.OOXIXo Lifecycle.Event event) {
                Object m287constructorimpl;
                IIX0o.x0xO0oo(source, "source");
                IIX0o.x0xO0oo(event, "event");
                if (event == Lifecycle.Event.Companion.upTo(Lifecycle.State.this)) {
                    lifecycle.removeObserver(this);
                    kotlin.coroutines.I0Io i0Io2 = x0xo0oo;
                    Oox.oIX0oI<R> oix0oi2 = oix0oi;
                    try {
                        Result.oIX0oI oix0oi3 = Result.Companion;
                        m287constructorimpl = Result.m287constructorimpl(oix0oi2.invoke());
                    } catch (Throwable th) {
                        Result.oIX0oI oix0oi4 = Result.Companion;
                        m287constructorimpl = Result.m287constructorimpl(I0oOoX.oIX0oI(th));
                    }
                    i0Io2.resumeWith(m287constructorimpl);
                    return;
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.removeObserver(this);
                    kotlin.coroutines.I0Io i0Io3 = x0xo0oo;
                    Result.oIX0oI oix0oi5 = Result.Companion;
                    i0Io3.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(new LifecycleDestroyedException())));
                }
            }
        };
        if (z) {
            coroutineDispatcher.dispatch(EmptyCoroutineContext.INSTANCE, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    Lifecycle.this.addObserver(r1);
                }
            });
        } else {
            lifecycle.addObserver(r1);
        }
        x0xo0oo.ooXIXxIX(new Oox.oOoXoXO<Throwable, oXIO0o0XI>() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2
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
                CoroutineDispatcher coroutineDispatcher2 = CoroutineDispatcher.this;
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                if (coroutineDispatcher2.isDispatchNeeded(emptyCoroutineContext)) {
                    CoroutineDispatcher coroutineDispatcher3 = CoroutineDispatcher.this;
                    final Lifecycle lifecycle2 = lifecycle;
                    final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = r1;
                    coroutineDispatcher3.dispatch(emptyCoroutineContext, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Lifecycle.this.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                        }
                    });
                    return;
                }
                lifecycle.removeObserver(r1);
            }
        });
        Object o002 = x0xo0oo.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return o002;
    }

    @OXOo.oOoXoXO
    public static final <R> Object withCreated(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        o0oIxOo o002 = Xo0.X0o0xo().o00();
        boolean isDispatchNeeded = o002.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return oix0oi.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, o002, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, Oox.oIX0oI<? extends R> oix0oi, kotlin.coroutines.I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        Xo0.X0o0xo().o00();
        xxX.X0o0xo(3);
        throw null;
    }

    @OXOo.oOoXoXO
    public static final <R> Object withResumed(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        o0oIxOo o002 = Xo0.X0o0xo().o00();
        boolean isDispatchNeeded = o002.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return oix0oi.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, o002, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, Oox.oIX0oI<? extends R> oix0oi, kotlin.coroutines.I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        Xo0.X0o0xo().o00();
        xxX.X0o0xo(3);
        throw null;
    }

    @OXOo.oOoXoXO
    public static final <R> Object withStarted(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        o0oIxOo o002 = Xo0.X0o0xo().o00();
        boolean isDispatchNeeded = o002.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return oix0oi.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, o002, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, Oox.oIX0oI<? extends R> oix0oi, kotlin.coroutines.I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        Xo0.X0o0xo().o00();
        xxX.X0o0xo(3);
        throw null;
    }

    @OXOo.oOoXoXO
    public static final <R> Object withStateAtLeast(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo Lifecycle.State state, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            o0oIxOo o002 = Xo0.X0o0xo().o00();
            boolean isDispatchNeeded = o002.isDispatchNeeded(i0Io.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return oix0oi.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, o002, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, Oox.oIX0oI<? extends R> oix0oi, kotlin.coroutines.I0Io<? super R> i0Io) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            Xo0.X0o0xo().o00();
            xxX.X0o0xo(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @o0
    @OXOo.oOoXoXO
    public static final <R> Object withStateAtLeastUnchecked(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo Lifecycle.State state, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        o0oIxOo o002 = Xo0.X0o0xo().o00();
        boolean isDispatchNeeded = o002.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return oix0oi.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, o002, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    @o0
    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, Oox.oIX0oI<? extends R> oix0oi, kotlin.coroutines.I0Io<? super R> i0Io) {
        Xo0.X0o0xo().o00();
        xxX.X0o0xo(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, Oox.oIX0oI<? extends R> oix0oi, kotlin.coroutines.I0Io<? super R> i0Io) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        Xo0.X0o0xo().o00();
        xxX.X0o0xo(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, Oox.oIX0oI<? extends R> oix0oi, kotlin.coroutines.I0Io<? super R> i0Io) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        Xo0.X0o0xo().o00();
        xxX.X0o0xo(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, Oox.oIX0oI<? extends R> oix0oi, kotlin.coroutines.I0Io<? super R> i0Io) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        Xo0.X0o0xo().o00();
        xxX.X0o0xo(3);
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, Oox.oIX0oI<? extends R> oix0oi, kotlin.coroutines.I0Io<? super R> i0Io) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            Xo0.X0o0xo().o00();
            xxX.X0o0xo(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @OXOo.oOoXoXO
    public static final <R> Object withCreated(@OXOo.OOXIXo LifecycleOwner lifecycleOwner, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        o0oIxOo o002 = Xo0.X0o0xo().o00();
        boolean isDispatchNeeded = o002.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return oix0oi.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, o002, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    @OXOo.oOoXoXO
    public static final <R> Object withResumed(@OXOo.OOXIXo LifecycleOwner lifecycleOwner, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        o0oIxOo o002 = Xo0.X0o0xo().o00();
        boolean isDispatchNeeded = o002.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return oix0oi.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, o002, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    @OXOo.oOoXoXO
    public static final <R> Object withStarted(@OXOo.OOXIXo LifecycleOwner lifecycleOwner, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        o0oIxOo o002 = Xo0.X0o0xo().o00();
        boolean isDispatchNeeded = o002.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return oix0oi.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, o002, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    @OXOo.oOoXoXO
    public static final <R> Object withStateAtLeast(@OXOo.OOXIXo LifecycleOwner lifecycleOwner, @OXOo.OOXIXo Lifecycle.State state, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            o0oIxOo o002 = Xo0.X0o0xo().o00();
            boolean isDispatchNeeded = o002.isDispatchNeeded(i0Io.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return oix0oi.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, o002, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
