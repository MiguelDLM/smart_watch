package androidx.work;

import Oox.oIX0oI;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class oOoXoXO implements CallbackToFutureAdapter.Resolver {

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ oIX0oI f577II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Executor f578oIX0oI;

    public /* synthetic */ oOoXoXO(Executor executor, oIX0oI oix0oi) {
        this.f578oIX0oI = executor;
        this.f577II0xO0 = oix0oi;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return WorkerKt.future$lambda$2(this.f578oIX0oI, this.f577II0xO0, completer);
    }
}
