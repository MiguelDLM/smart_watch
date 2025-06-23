package androidx.activity;

import Oox.oIX0oI;
import android.app.Application;
import androidx.lifecycle.SavedStateViewModelFactory;
import kotlin.jvm.internal.Lambda;

public final class ComponentActivity$defaultViewModelProviderFactory$2 extends Lambda implements oIX0oI<SavedStateViewModelFactory> {
    final /* synthetic */ ComponentActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentActivity$defaultViewModelProviderFactory$2(ComponentActivity componentActivity) {
        super(0);
        this.this$0 = componentActivity;
    }

    public final SavedStateViewModelFactory invoke() {
        Application application = this.this$0.getApplication();
        ComponentActivity componentActivity = this.this$0;
        return new SavedStateViewModelFactory(application, componentActivity, componentActivity.getIntent() != null ? this.this$0.getIntent().getExtras() : null);
    }
}
