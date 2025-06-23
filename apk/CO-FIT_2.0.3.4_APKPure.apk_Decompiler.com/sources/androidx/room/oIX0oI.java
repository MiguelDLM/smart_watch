package androidx.room;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ AutoCloser f467XO;

    public /* synthetic */ oIX0oI(AutoCloser autoCloser) {
        this.f467XO = autoCloser;
    }

    public final void run() {
        AutoCloser.executeAutoCloser$lambda$0(this.f467XO);
    }
}
