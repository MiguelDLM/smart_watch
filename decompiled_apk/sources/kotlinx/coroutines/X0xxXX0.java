package kotlinx.coroutines;

@kotlin.jvm.internal.XX({"SMAP\nThreadContextElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadContextElement.kt\nkotlinx/coroutines/ThreadContextElementKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,288:1\n266#1:289\n1#2:290\n*S KotlinDebug\n*F\n+ 1 ThreadContextElement.kt\nkotlinx/coroutines/ThreadContextElementKt\n*L\n287#1:289\n*E\n"})
/* loaded from: classes6.dex */
public final class X0xxXX0 {
    @OXOo.oOoXoXO
    public static final Object I0Io(@OXOo.OOXIXo ThreadLocal<?> threadLocal, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        if (i0Io.getContext().get(new kotlinx.coroutines.internal.XoX(threadLocal)) != null) {
            return kotlin.oXIO0o0XI.f29392oIX0oI;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + i0Io.getContext()).toString());
    }

    public static /* synthetic */ X0xII0I II0xO0(ThreadLocal threadLocal, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = threadLocal.get();
        }
        return oIX0oI(threadLocal, obj);
    }

    @OXOo.oOoXoXO
    public static final Object X0o0xo(@OXOo.OOXIXo ThreadLocal<?> threadLocal, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        boolean z;
        if (i0Io.getContext().get(new kotlinx.coroutines.internal.XoX(threadLocal)) != null) {
            z = true;
        } else {
            z = false;
        }
        return IXIxx0.oIX0oI.oIX0oI(z);
    }

    public static final Object XO(ThreadLocal<?> threadLocal, kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        kotlin.jvm.internal.xxX.X0o0xo(3);
        throw null;
    }

    @OXOo.OOXIXo
    public static final <T> X0xII0I<T> oIX0oI(@OXOo.OOXIXo ThreadLocal<T> threadLocal, T t) {
        return new kotlinx.coroutines.internal.oxxXoxO(t, threadLocal);
    }

    public static final Object oxoX(ThreadLocal<?> threadLocal, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        kotlin.jvm.internal.xxX.X0o0xo(3);
        throw null;
    }
}
