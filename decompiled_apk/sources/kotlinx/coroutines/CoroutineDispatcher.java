package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.oxoX;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes6.dex */
public abstract class CoroutineDispatcher extends kotlin.coroutines.oIX0oI implements kotlin.coroutines.oxoX {

    @OXOo.OOXIXo
    public static final Key Key = new Key(null);

    @kotlin.IXxxXO
    /* loaded from: classes6.dex */
    public static final class Key extends kotlin.coroutines.II0xO0<kotlin.coroutines.oxoX, CoroutineDispatcher> {
        public /* synthetic */ Key(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public Key() {
            super(kotlin.coroutines.oxoX.f29196Oxx0IOOO, new Oox.oOoXoXO<CoroutineContext.oIX0oI, CoroutineDispatcher>() { // from class: kotlinx.coroutines.CoroutineDispatcher.Key.1
                @Override // Oox.oOoXoXO
                @OXOo.oOoXoXO
                public final CoroutineDispatcher invoke(@OXOo.OOXIXo CoroutineContext.oIX0oI oix0oi) {
                    if (oix0oi instanceof CoroutineDispatcher) {
                        return (CoroutineDispatcher) oix0oi;
                    }
                    return null;
                }
            });
        }
    }

    public CoroutineDispatcher() {
        super(kotlin.coroutines.oxoX.f29196Oxx0IOOO);
    }

    public abstract void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable);

    @OX00O0xII
    public void dispatchYield(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    @Override // kotlin.coroutines.oIX0oI, kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OXOo.oOoXoXO
    public <E extends CoroutineContext.oIX0oI> E get(@OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
        return (E) oxoX.oIX0oI.II0xO0(this, iI0xO0);
    }

    @Override // kotlin.coroutines.oxoX
    @OXOo.OOXIXo
    public final <T> kotlin.coroutines.I0Io<T> interceptContinuation(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return new kotlinx.coroutines.internal.oOoXoXO(this, i0Io);
    }

    public boolean isDispatchNeeded(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        return true;
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public CoroutineDispatcher limitedParallelism(int i) {
        kotlinx.coroutines.internal.oI0IIXIo.oIX0oI(i);
        return new kotlinx.coroutines.internal.Oxx0xo(this, i);
    }

    @Override // kotlin.coroutines.oIX0oI, kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext minusKey(@OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
        return oxoX.oIX0oI.I0Io(this, iI0xO0);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @OXOo.OOXIXo
    public final CoroutineDispatcher plus(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }

    @Override // kotlin.coroutines.oxoX
    public final void releaseInterceptedContinuation(@OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        kotlin.jvm.internal.IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((kotlinx.coroutines.internal.oOoXoXO) i0Io).Oxx0xo();
    }

    @OXOo.OOXIXo
    public String toString() {
        return OI0.oIX0oI(this) + ObjectUtils.f32506oIX0oI + OI0.II0xO0(this);
    }
}
