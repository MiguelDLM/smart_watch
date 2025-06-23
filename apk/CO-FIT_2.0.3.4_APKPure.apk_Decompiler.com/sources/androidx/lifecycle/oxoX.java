package androidx.lifecycle;

public final /* synthetic */ class oxoX implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Runnable f410Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ DispatchQueue f411XO;

    public /* synthetic */ oxoX(DispatchQueue dispatchQueue, Runnable runnable) {
        this.f411XO = dispatchQueue;
        this.f410Oo = runnable;
    }

    public final void run() {
        DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1(this.f411XO, this.f410Oo);
    }
}
