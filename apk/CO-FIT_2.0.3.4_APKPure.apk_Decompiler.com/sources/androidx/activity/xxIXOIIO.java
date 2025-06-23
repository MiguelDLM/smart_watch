package androidx.activity;

import android.content.IntentSender;

public final /* synthetic */ class xxIXOIIO implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ IntentSender.SendIntentException f275IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ int f276Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity$activityResultRegistry$1 f277XO;

    public /* synthetic */ xxIXOIIO(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i, IntentSender.SendIntentException sendIntentException) {
        this.f277XO = componentActivity$activityResultRegistry$1;
        this.f276Oo = i;
        this.f275IXxxXO = sendIntentException;
    }

    public final void run() {
        ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1(this.f277XO, this.f276Oo, this.f275IXxxXO);
    }
}
