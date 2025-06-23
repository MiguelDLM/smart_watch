package androidx.activity;

import androidx.activity.result.contract.ActivityResultContract;

public final /* synthetic */ class II0XooXoX implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ ActivityResultContract.SynchronousResult f250IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ int f251Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity$activityResultRegistry$1 f252XO;

    public /* synthetic */ II0XooXoX(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i, ActivityResultContract.SynchronousResult synchronousResult) {
        this.f252XO = componentActivity$activityResultRegistry$1;
        this.f251Oo = i;
        this.f250IXxxXO = synchronousResult;
    }

    public final void run() {
        ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0(this.f252XO, this.f251Oo, this.f250IXxxXO);
    }
}
