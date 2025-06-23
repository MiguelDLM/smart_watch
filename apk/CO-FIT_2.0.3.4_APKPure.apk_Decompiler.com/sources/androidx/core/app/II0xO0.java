package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;

public final /* synthetic */ class II0xO0 implements SharedElementCallback.OnSharedElementsReadyListener {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener f293oIX0oI;

    public /* synthetic */ II0xO0(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f293oIX0oI = onSharedElementsReadyListener;
    }

    public final void onSharedElementsReady() {
        ActivityCompat.Api23Impl.onSharedElementsReady(this.f293oIX0oI);
    }
}
