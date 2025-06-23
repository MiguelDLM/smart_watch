package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class IIX0o implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f367oIX0oI;

    public /* synthetic */ IIX0o(AtomicBoolean atomicBoolean) {
        this.f367oIX0oI = atomicBoolean;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
        SoftwareKeyboardControllerCompat.Impl30.lambda$hide$0(this.f367oIX0oI, windowInsetsController, i);
    }
}
