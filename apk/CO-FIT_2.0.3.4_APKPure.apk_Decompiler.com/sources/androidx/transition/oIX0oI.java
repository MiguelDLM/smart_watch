package androidx.transition;

import androidx.core.os.CancellationSignal;

public final /* synthetic */ class oIX0oI implements CancellationSignal.OnCancelListener {

    /* renamed from: I0Io  reason: collision with root package name */
    public final /* synthetic */ Runnable f489I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ Transition f490II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Runnable f491oIX0oI;

    public /* synthetic */ oIX0oI(Runnable runnable, Transition transition, Runnable runnable2) {
        this.f491oIX0oI = runnable;
        this.f490II0xO0 = transition;
        this.f489I0Io = runnable2;
    }

    public final void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0(this.f491oIX0oI, this.f490II0xO0, this.f489I0Io);
    }
}
