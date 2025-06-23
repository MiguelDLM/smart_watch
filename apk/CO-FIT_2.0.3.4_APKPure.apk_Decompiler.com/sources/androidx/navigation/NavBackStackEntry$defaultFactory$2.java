package androidx.navigation;

import Oox.oIX0oI;
import android.app.Application;
import android.content.Context;
import androidx.lifecycle.SavedStateViewModelFactory;
import kotlin.jvm.internal.Lambda;

public final class NavBackStackEntry$defaultFactory$2 extends Lambda implements oIX0oI<SavedStateViewModelFactory> {
    final /* synthetic */ NavBackStackEntry this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry$defaultFactory$2(NavBackStackEntry navBackStackEntry) {
        super(0);
        this.this$0 = navBackStackEntry;
    }

    public final SavedStateViewModelFactory invoke() {
        Context access$getContext$p = this.this$0.context;
        Application application = null;
        Context applicationContext = access$getContext$p != null ? access$getContext$p.getApplicationContext() : null;
        if (applicationContext instanceof Application) {
            application = (Application) applicationContext;
        }
        NavBackStackEntry navBackStackEntry = this.this$0;
        return new SavedStateViewModelFactory(application, navBackStackEntry, navBackStackEntry.getArguments());
    }
}
