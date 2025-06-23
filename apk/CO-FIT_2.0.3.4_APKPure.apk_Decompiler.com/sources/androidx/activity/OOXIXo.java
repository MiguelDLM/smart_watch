package androidx.activity;

public final /* synthetic */ class OOXIXo implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f255Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f256XO;

    public /* synthetic */ OOXIXo(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
        this.f256XO = componentActivity;
        this.f255Oo = onBackPressedDispatcher;
    }

    public final void run() {
        ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$2$lambda$1(this.f256XO, this.f255Oo);
    }
}
