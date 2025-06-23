package androidx.work;

import Oox.oIX0oI;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class II0xO0 implements CallbackToFutureAdapter.Resolver {

    /* renamed from: I0Io  reason: collision with root package name */
    public final /* synthetic */ oIX0oI f501I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ String f502II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Executor f503oIX0oI;

    public /* synthetic */ II0xO0(Executor executor, String str, oIX0oI oix0oi) {
        this.f503oIX0oI = executor;
        this.f502II0xO0 = str;
        this.f501I0Io = oix0oi;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ListenableFutureKt.executeAsync$lambda$4(this.f503oIX0oI, this.f502II0xO0, this.f501I0Io, completer);
    }
}
