package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

public final /* synthetic */ class oo0xXOI0I implements View.OnUnhandledKeyEventListener {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ ViewCompat.OnUnhandledKeyEventListenerCompat f381oIX0oI;

    public /* synthetic */ oo0xXOI0I(ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        this.f381oIX0oI = onUnhandledKeyEventListenerCompat;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.f381oIX0oI.onUnhandledKeyEvent(view, keyEvent);
    }
}
