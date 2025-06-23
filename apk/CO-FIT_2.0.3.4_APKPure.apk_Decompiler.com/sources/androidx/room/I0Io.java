package androidx.room;

public final /* synthetic */ class I0Io implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ InvalidationTracker f446XO;

    public /* synthetic */ I0Io(InvalidationTracker invalidationTracker) {
        this.f446XO = invalidationTracker;
    }

    public final void run() {
        this.f446XO.onAutoCloseCallback();
    }
}
