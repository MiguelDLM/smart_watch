package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class oIX0oI implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f402oIX0oI;

    public /* synthetic */ oIX0oI(FragmentActivity fragmentActivity) {
        this.f402oIX0oI = fragmentActivity;
    }

    public final Bundle saveState() {
        return this.f402oIX0oI.lambda$init$0();
    }
}
