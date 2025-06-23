package androidx.work;

import Oox.oIX0oI;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;

public final /* synthetic */ class II0XooXoX implements CallbackToFutureAdapter.Resolver {

    /* renamed from: I0Io  reason: collision with root package name */
    public final /* synthetic */ String f496I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ Tracer f497II0xO0;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f498X0o0xo;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Executor f499oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final /* synthetic */ oIX0oI f500oxoX;

    public /* synthetic */ II0XooXoX(Executor executor, Tracer tracer, String str, oIX0oI oix0oi, MutableLiveData mutableLiveData) {
        this.f499oIX0oI = executor;
        this.f497II0xO0 = tracer;
        this.f496I0Io = str;
        this.f500oxoX = oix0oi;
        this.f498X0o0xo = mutableLiveData;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return OperationKt.launchOperation$lambda$2(this.f499oIX0oI, this.f497II0xO0, this.f496I0Io, this.f500oxoX, this.f498X0o0xo, completer);
    }
}
