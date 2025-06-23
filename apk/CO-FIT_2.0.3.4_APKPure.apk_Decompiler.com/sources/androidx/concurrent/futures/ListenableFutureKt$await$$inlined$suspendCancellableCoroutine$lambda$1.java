package androidx.concurrent.futures;

import Oox.oOoXoXO;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1 extends Lambda implements oOoXoXO<Throwable, oXIO0o0XI> {
    final /* synthetic */ ListenableFuture $this_await$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(ListenableFuture listenableFuture) {
        super(1);
        this.$this_await$inlined = listenableFuture;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(@OXOo.oOoXoXO Throwable th) {
        this.$this_await$inlined.cancel(false);
    }
}
