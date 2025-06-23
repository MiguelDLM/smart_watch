package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import kotlin.coroutines.CoroutineContext;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class II0xO0<T> extends kotlinx.coroutines.oIX0oI<T> implements BiFunction<T, Throwable, oXIO0o0XI> {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CompletableFuture<T> f30214Oxx0xo;

    public II0xO0(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo CompletableFuture<T> completableFuture) {
        super(coroutineContext, true, true);
        this.f30214Oxx0xo = completableFuture;
    }

    public void OooI(@OXOo.oOoXoXO T t, @OXOo.oOoXoXO Throwable th) {
        oXIO0o0XI.oIX0oI.II0xO0(this, null, 1, null);
    }

    @Override // kotlinx.coroutines.oIX0oI
    public void XoIxOXIXo(T t) {
        this.f30214Oxx0xo.complete(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI apply(Object obj, Throwable th) {
        OooI(obj, th);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.oIX0oI
    public void o0IXXIx(@OXOo.OOXIXo Throwable th, boolean z) {
        this.f30214Oxx0xo.completeExceptionally(th);
    }
}
