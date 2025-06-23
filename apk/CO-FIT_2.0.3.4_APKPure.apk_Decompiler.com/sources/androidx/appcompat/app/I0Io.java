package androidx.appcompat.app;

import androidx.appcompat.app.AppCompatDelegate;

public final /* synthetic */ class I0Io implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Runnable f278Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegate.SerialExecutor f279XO;

    public /* synthetic */ I0Io(AppCompatDelegate.SerialExecutor serialExecutor, Runnable runnable) {
        this.f279XO = serialExecutor;
        this.f278Oo = runnable;
    }

    public final void run() {
        this.f279XO.lambda$execute$0(this.f278Oo);
    }
}
