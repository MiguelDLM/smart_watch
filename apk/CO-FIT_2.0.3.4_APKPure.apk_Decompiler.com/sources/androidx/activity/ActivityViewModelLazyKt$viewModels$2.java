package androidx.activity;

import Oox.oIX0oI;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.Lambda;

public final class ActivityViewModelLazyKt$viewModels$2 extends Lambda implements oIX0oI<CreationExtras> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$2(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    public final CreationExtras invoke() {
        return this.$this_viewModels.getDefaultViewModelCreationExtras();
    }
}
