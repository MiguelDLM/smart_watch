package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final /* synthetic */ class O0xOxO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ View f372XO;

    public /* synthetic */ O0xOxO(View view) {
        this.f372XO = view;
    }

    public final void run() {
        ((InputMethodManager) this.f372XO.getContext().getSystemService("input_method")).showSoftInput(this.f372XO, 0);
    }
}
