package androidx.activity;

public final /* synthetic */ class xoIox implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f274XO;

    public /* synthetic */ xoIox(ComponentActivity componentActivity) {
        this.f274XO = componentActivity;
    }

    public final void run() {
        ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$0(this.f274XO);
    }
}
