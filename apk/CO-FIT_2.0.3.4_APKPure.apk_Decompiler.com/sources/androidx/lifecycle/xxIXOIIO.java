package androidx.lifecycle;

public final /* synthetic */ class xxIXOIIO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ProcessLifecycleOwner f412XO;

    public /* synthetic */ xxIXOIIO(ProcessLifecycleOwner processLifecycleOwner) {
        this.f412XO = processLifecycleOwner;
    }

    public final void run() {
        ProcessLifecycleOwner.delayedPauseRunnable$lambda$0(this.f412XO);
    }
}
