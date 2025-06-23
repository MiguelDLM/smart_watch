package androidx.work;

import Oox.oIX0oI;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class OOXIXo implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ oIX0oI f504IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f505Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f506XO;

    public /* synthetic */ OOXIXo(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, oIX0oI oix0oi) {
        this.f506XO = atomicBoolean;
        this.f505Oo = completer;
        this.f504IXxxXO = oix0oi;
    }

    public final void run() {
        WorkerKt.future$lambda$2$lambda$1(this.f506XO, this.f505Oo, this.f504IXxxXO);
    }
}
