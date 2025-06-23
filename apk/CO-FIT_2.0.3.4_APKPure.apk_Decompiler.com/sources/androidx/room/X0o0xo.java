package androidx.room;

public final /* synthetic */ class X0o0xo implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f462XO;

    public /* synthetic */ X0o0xo(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.f462XO = multiInstanceInvalidationClient;
    }

    public final void run() {
        MultiInstanceInvalidationClient.removeObserverRunnable$lambda$2(this.f462XO);
    }
}
