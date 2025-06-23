package androidx.work;

import Oox.x0xO0oo;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;

public final /* synthetic */ class I0Io implements CallbackToFutureAdapter.Resolver {

    /* renamed from: I0Io  reason: collision with root package name */
    public final /* synthetic */ x0xO0oo f493I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ CoroutineStart f494II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f495oIX0oI;

    public /* synthetic */ I0Io(CoroutineContext coroutineContext, CoroutineStart coroutineStart, x0xO0oo x0xo0oo) {
        this.f495oIX0oI = coroutineContext;
        this.f494II0xO0 = coroutineStart;
        this.f493I0Io = x0xo0oo;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ListenableFutureKt.launchFuture$lambda$1(this.f495oIX0oI, this.f494II0xO0, this.f493I0Io, completer);
    }
}
