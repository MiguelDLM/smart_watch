package androidx.appcompat.app;

import android.content.Context;

public final /* synthetic */ class II0xO0 implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Context f280XO;

    public /* synthetic */ II0xO0(Context context) {
        this.f280XO = context;
    }

    public final void run() {
        AppCompatDelegate.syncRequestedAndStoredLocales(this.f280XO);
    }
}
