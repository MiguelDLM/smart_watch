package androidx.work;

import Oox.oIX0oI;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class X0o0xo implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ oIX0oI f507IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f508Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f509XO;

    public /* synthetic */ X0o0xo(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, oIX0oI oix0oi) {
        this.f509XO = atomicBoolean;
        this.f508Oo = completer;
        this.f507IXxxXO = oix0oi;
    }

    public final void run() {
        ListenableFutureKt.executeAsync$lambda$4$lambda$3(this.f509XO, this.f508Oo, this.f507IXxxXO);
    }
}
