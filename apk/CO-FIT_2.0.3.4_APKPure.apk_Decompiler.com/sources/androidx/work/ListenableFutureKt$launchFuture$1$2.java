package androidx.work;

import IXIxx0.oxoX;
import Oox.x0xO0oo;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.CancellationException;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.work.ListenableFutureKt$launchFuture$1$2", f = "ListenableFuture.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class ListenableFutureKt$launchFuture$1$2 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ x0xO0oo<xII, I0Io<? super T>, Object> $block;
    final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$launchFuture$1$2(x0xO0oo<? super xII, ? super I0Io<? super T>, ? extends Object> x0xo0oo, CallbackToFutureAdapter.Completer<T> completer, I0Io<? super ListenableFutureKt$launchFuture$1$2> i0Io) {
        super(2, i0Io);
        this.$block = x0xo0oo;
        this.$completer = completer;
    }

    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        ListenableFutureKt$launchFuture$1$2 listenableFutureKt$launchFuture$1$2 = new ListenableFutureKt$launchFuture$1$2(this.$block, this.$completer, i0Io);
        listenableFutureKt$launchFuture$1$2.L$0 = obj;
        return listenableFutureKt$launchFuture$1$2;
    }

    public final Object invokeSuspend(Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            xII xii = (xII) this.L$0;
            x0xO0oo<xII, I0Io<? super T>, Object> x0xo0oo = this.$block;
            this.label = 1;
            obj = x0xo0oo.invoke(xii, this);
            if (obj == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            try {
                I0oOoX.x0XOIxOo(obj);
            } catch (CancellationException unused) {
                this.$completer.setCancelled();
            } catch (Throwable th) {
                this.$completer.setException(th);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$completer.set(obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final Object invoke(xII xii, I0Io<? super oXIO0o0XI> i0Io) {
        return ((ListenableFutureKt$launchFuture$1$2) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
