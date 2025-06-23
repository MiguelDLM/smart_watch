package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class xxIXOIIO implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f404oIX0oI;

    public /* synthetic */ xxIXOIIO(FragmentManager fragmentManager) {
        this.f404oIX0oI = fragmentManager;
    }

    public final Bundle saveState() {
        return this.f404oIX0oI.lambda$attachController$4();
    }
}
