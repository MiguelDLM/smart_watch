package androidx.work;

import Oox.oIX0oI;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;

public final /* synthetic */ class xxIXOIIO implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ oIX0oI f581IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f582Oo;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f583Oxx0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Tracer f584XO;

    /* renamed from: oI0IIXIo  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f585oI0IIXIo;

    public /* synthetic */ xxIXOIIO(Tracer tracer, String str, oIX0oI oix0oi, MutableLiveData mutableLiveData, CallbackToFutureAdapter.Completer completer) {
        this.f584XO = tracer;
        this.f582Oo = str;
        this.f581IXxxXO = oix0oi;
        this.f583Oxx0xo = mutableLiveData;
        this.f585oI0IIXIo = completer;
    }

    public final void run() {
        OperationKt.launchOperation$lambda$2$lambda$1(this.f584XO, this.f582Oo, this.f581IXxxXO, this.f583Oxx0xo, this.f585oI0IIXIo);
    }
}
