package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class OOXIXo implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandle f406oIX0oI;

    public /* synthetic */ OOXIXo(SavedStateHandle savedStateHandle) {
        this.f406oIX0oI = savedStateHandle;
    }

    public final Bundle saveState() {
        return SavedStateHandle.savedStateProvider$lambda$0(this.f406oIX0oI);
    }
}
