package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class oxoX implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f267oIX0oI;

    public /* synthetic */ oxoX(ComponentActivity componentActivity) {
        this.f267oIX0oI = componentActivity;
    }

    public final Bundle saveState() {
        return ComponentActivity._init_$lambda$4(this.f267oIX0oI);
    }
}
