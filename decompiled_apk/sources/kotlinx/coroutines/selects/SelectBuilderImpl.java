package kotlinx.coroutines.selects;

import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.o0;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.x0xO0oo;

@o0
/* loaded from: classes6.dex */
public final class SelectBuilderImpl<R> extends SelectImplementation<R> {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final x0xO0oo<R> f30394IIXOooo;

    public SelectBuilderImpl(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        super(i0Io.getContext());
        this.f30394IIXOooo = new x0xO0oo<>(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
    }

    @o0
    public final void IO(@OXOo.OOXIXo Throwable th) {
        x0xO0oo<R> x0xo0oo = this.f30394IIXOooo;
        Result.oIX0oI oix0oi = Result.Companion;
        x0xo0oo.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(th)));
    }

    @o0
    @OXOo.oOoXoXO
    public final Object X00IoxXI() {
        if (!this.f30394IIXOooo.isCompleted()) {
            kotlinx.coroutines.xoIox.XO(x0o.oIX0oI(getContext()), null, CoroutineStart.UNDISPATCHED, new SelectBuilderImpl$getResult$1(this, null), 1, null);
            return this.f30394IIXOooo.o00();
        }
        return this.f30394IIXOooo.o00();
    }
}
