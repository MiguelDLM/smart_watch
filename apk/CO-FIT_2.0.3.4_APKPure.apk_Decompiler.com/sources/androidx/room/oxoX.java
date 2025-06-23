package androidx.room;

public final /* synthetic */ class oxoX implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f473XO;

    public /* synthetic */ oxoX(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.f473XO = multiInstanceInvalidationClient;
    }

    public final void run() {
        MultiInstanceInvalidationClient.setUpRunnable$lambda$1(this.f473XO);
    }
}
