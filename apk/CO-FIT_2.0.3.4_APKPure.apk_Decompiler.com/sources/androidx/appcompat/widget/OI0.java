package androidx.appcompat.widget;

public final /* synthetic */ class OI0 implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Toolbar f284XO;

    public /* synthetic */ OI0(Toolbar toolbar) {
        this.f284XO = toolbar;
    }

    public final void run() {
        this.f284XO.invalidateMenu();
    }
}
