package androidx.lifecycle;

import IXIxx0.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.o0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.o0oIxOo;
import kotlinx.coroutines.x0xO0oo;

@XX({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,206:1\n154#1,8:207\n154#1,8:215\n154#1,8:223\n154#1,8:231\n43#1,5:239\n154#1,8:244\n43#1,5:252\n154#1,8:257\n154#1,8:265\n154#1,8:273\n154#1,8:281\n314#2,11:289\n*S KotlinDebug\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n*L\n47#1:207,8\n58#1:215,8\n71#1:223,8\n84#1:231,8\n98#1:239,5\n98#1:244,8\n98#1:252,5\n98#1:257,8\n111#1:265,8\n124#1:273,8\n137#1:281,8\n177#1:289,11\n*E\n"})
public final class WithLifecycleStateKt {
    @oOoXoXO
    @o0
    public static final <R> Object suspendWithStateAtLeastUnchecked(@OOXIXo Lifecycle lifecycle, @OOXIXo Lifecycle.State state, boolean z, @OOXIXo CoroutineDispatcher coroutineDispatcher, @OOXIXo oIX0oI<? extends R> oix0oi, @OOXIXo I0Io<? super R> i0Io) {
        x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(state, lifecycle, x0xo0oo, oix0oi);
        if (z) {
            coroutineDispatcher.dispatch(EmptyCoroutineContext.INSTANCE, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(lifecycle, withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1));
        } else {
            lifecycle.addObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
        }
        x0xo0oo.ooXIXxIX(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(coroutineDispatcher, lifecycle, withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1));
        Object o002 = x0xo0oo.o00();
        if (o002 == II0xO0.oOoXoXO()) {
            XO.I0Io(i0Io);
        }
        return o002;
    }

    @oOoXoXO
    public static final <R> Object withCreated(@OOXIXo Lifecycle lifecycle, @OOXIXo oIX0oI<? extends R> oix0oi, @OOXIXo I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
        boolean isDispatchNeeded = IIXOooo2.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return oix0oi.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, IIXOooo2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, oIX0oI<? extends R> oix0oi, I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        Xo0.X0o0xo().IIXOooo();
        xxX.X0o0xo(3);
        throw null;
    }

    @oOoXoXO
    public static final <R> Object withResumed(@OOXIXo Lifecycle lifecycle, @OOXIXo oIX0oI<? extends R> oix0oi, @OOXIXo I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
        boolean isDispatchNeeded = IIXOooo2.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return oix0oi.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, IIXOooo2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, oIX0oI<? extends R> oix0oi, I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        Xo0.X0o0xo().IIXOooo();
        xxX.X0o0xo(3);
        throw null;
    }

    @oOoXoXO
    public static final <R> Object withStarted(@OOXIXo Lifecycle lifecycle, @OOXIXo oIX0oI<? extends R> oix0oi, @OOXIXo I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
        boolean isDispatchNeeded = IIXOooo2.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return oix0oi.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, IIXOooo2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, oIX0oI<? extends R> oix0oi, I0Io<? super R> i0Io) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        Xo0.X0o0xo().IIXOooo();
        xxX.X0o0xo(3);
        throw null;
    }

    @oOoXoXO
    public static final <R> Object withStateAtLeast(@OOXIXo Lifecycle lifecycle, @OOXIXo Lifecycle.State state, @OOXIXo oIX0oI<? extends R> oix0oi, @OOXIXo I0Io<? super R> i0Io) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
            boolean isDispatchNeeded = IIXOooo2.isDispatchNeeded(i0Io.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return oix0oi.invoke();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, IIXOooo2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, oIX0oI<? extends R> oix0oi, I0Io<? super R> i0Io) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            Xo0.X0o0xo().IIXOooo();
            xxX.X0o0xo(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @oOoXoXO
    @o0
    public static final <R> Object withStateAtLeastUnchecked(@OOXIXo Lifecycle lifecycle, @OOXIXo Lifecycle.State state, @OOXIXo oIX0oI<? extends R> oix0oi, @OOXIXo I0Io<? super R> i0Io) {
        o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
        boolean isDispatchNeeded = IIXOooo2.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return oix0oi.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, IIXOooo2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    @o0
    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, oIX0oI<? extends R> oix0oi, I0Io<? super R> i0Io) {
        Xo0.X0o0xo().IIXOooo();
        xxX.X0o0xo(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, oIX0oI<? extends R> oix0oi, I0Io<? super R> i0Io) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        Xo0.X0o0xo().IIXOooo();
        xxX.X0o0xo(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, oIX0oI<? extends R> oix0oi, I0Io<? super R> i0Io) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        Xo0.X0o0xo().IIXOooo();
        xxX.X0o0xo(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, oIX0oI<? extends R> oix0oi, I0Io<? super R> i0Io) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        Xo0.X0o0xo().IIXOooo();
        xxX.X0o0xo(3);
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, oIX0oI<? extends R> oix0oi, I0Io<? super R> i0Io) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            Xo0.X0o0xo().IIXOooo();
            xxX.X0o0xo(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @oOoXoXO
    public static final <R> Object withCreated(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo oIX0oI<? extends R> oix0oi, @OOXIXo I0Io<? super R> i0Io) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
        boolean isDispatchNeeded = IIXOooo2.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return oix0oi.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, IIXOooo2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    @oOoXoXO
    public static final <R> Object withResumed(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo oIX0oI<? extends R> oix0oi, @OOXIXo I0Io<? super R> i0Io) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
        boolean isDispatchNeeded = IIXOooo2.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return oix0oi.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, IIXOooo2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    @oOoXoXO
    public static final <R> Object withStarted(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo oIX0oI<? extends R> oix0oi, @OOXIXo I0Io<? super R> i0Io) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
        boolean isDispatchNeeded = IIXOooo2.isDispatchNeeded(i0Io.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return oix0oi.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, IIXOooo2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
    }

    @oOoXoXO
    public static final <R> Object withStateAtLeast(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.State state, @OOXIXo oIX0oI<? extends R> oix0oi, @OOXIXo I0Io<? super R> i0Io) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
            boolean isDispatchNeeded = IIXOooo2.isDispatchNeeded(i0Io.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return oix0oi.invoke();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, IIXOooo2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(oix0oi), i0Io);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
