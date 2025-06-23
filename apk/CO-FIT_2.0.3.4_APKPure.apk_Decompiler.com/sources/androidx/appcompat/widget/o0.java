package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class o0 implements OnBackInvokedCallback {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Runnable f287oIX0oI;

    public /* synthetic */ o0(Runnable runnable) {
        this.f287oIX0oI = runnable;
    }

    public final void onBackInvoked() {
        this.f287oIX0oI.run();
    }
}
