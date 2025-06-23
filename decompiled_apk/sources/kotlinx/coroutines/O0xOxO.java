package kotlinx.coroutines;

/* loaded from: classes6.dex */
public final class O0xOxO<T> extends JobSupport implements OxI<T> {
    public O0xOxO(@OXOo.oOoXoXO oXIO0o0XI oxio0o0xi) {
        super(true);
        IIX0(oxio0o0xi);
    }

    @Override // kotlinx.coroutines.OxI
    public boolean I0Io(@OXOo.OOXIXo Throwable th) {
        return XIXIxO(new xxX(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.I0oOoX
    @OXOo.OOXIXo
    public kotlinx.coroutines.selects.X0o0xo<T> IoOoX() {
        kotlinx.coroutines.selects.X0o0xo<T> x0o0xo = (kotlinx.coroutines.selects.X0o0xo<T>) ooOx();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0o0xo, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return x0o0xo;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean OX00O0xII() {
        return true;
    }

    @Override // kotlinx.coroutines.I0oOoX
    @OXOo.oOoXoXO
    public Object XO(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        Object oX2 = oX(i0Io);
        kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        return oX2;
    }

    @Override // kotlinx.coroutines.OxI
    public boolean oO(T t) {
        return XIXIxO(t);
    }

    @Override // kotlinx.coroutines.I0oOoX
    public T oxoX() {
        return (T) O00XxXI();
    }
}
