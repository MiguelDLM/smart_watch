package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public class oxxXoxO<T> extends oIX0oI<T> implements I0oOoX<T> {
    public oxxXoxO(@OXOo.OOXIXo CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    public static /* synthetic */ <T> Object OooI(oxxXoxO<T> oxxxoxo, kotlin.coroutines.I0Io<? super T> i0Io) {
        Object oX2 = oxxxoxo.oX(i0Io);
        kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        return oX2;
    }

    @Override // kotlinx.coroutines.I0oOoX
    @OXOo.OOXIXo
    public kotlinx.coroutines.selects.X0o0xo<T> IoOoX() {
        kotlinx.coroutines.selects.X0o0xo<T> x0o0xo = (kotlinx.coroutines.selects.X0o0xo<T>) ooOx();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0o0xo, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return x0o0xo;
    }

    @Override // kotlinx.coroutines.I0oOoX
    @OXOo.oOoXoXO
    public Object XO(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return OooI(this, i0Io);
    }

    @Override // kotlinx.coroutines.I0oOoX
    public T oxoX() {
        return (T) O00XxXI();
    }
}
