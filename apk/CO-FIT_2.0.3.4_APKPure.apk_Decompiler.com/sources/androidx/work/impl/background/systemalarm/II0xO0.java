package androidx.work.impl.background.systemalarm;

public final /* synthetic */ class II0xO0 implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f528XO;

    public /* synthetic */ II0xO0(DelayMetCommandHandler delayMetCommandHandler) {
        this.f528XO = delayMetCommandHandler;
    }

    public final void run() {
        this.f528XO.startWork();
    }
}
