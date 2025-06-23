package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

public final /* synthetic */ class Ix00oIoI implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.OnControllableInsetsChangedListener f370II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.Impl30 f371oIX0oI;

    public /* synthetic */ Ix00oIoI(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f371oIX0oI = impl30;
        this.f370II0xO0 = onControllableInsetsChangedListener;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
        this.f371oIX0oI.lambda$addOnControllableInsetsChangedListener$0(this.f370II0xO0, windowInsetsController, i);
    }
}
