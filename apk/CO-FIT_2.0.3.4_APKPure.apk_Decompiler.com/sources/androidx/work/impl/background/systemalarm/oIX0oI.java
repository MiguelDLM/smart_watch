package androidx.work.impl.background.systemalarm;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f529XO;

    public /* synthetic */ oIX0oI(DelayMetCommandHandler delayMetCommandHandler) {
        this.f529XO = delayMetCommandHandler;
    }

    public final void run() {
        this.f529XO.stopWork();
    }
}
