package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class IXxxXO implements OnBackInvokedCallback {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f281oIX0oI;

    public /* synthetic */ IXxxXO(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f281oIX0oI = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.f281oIX0oI.onBackPressed();
    }
}
