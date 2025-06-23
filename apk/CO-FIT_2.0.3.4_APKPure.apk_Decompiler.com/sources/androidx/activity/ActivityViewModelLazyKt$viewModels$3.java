package androidx.activity;

import Oox.oIX0oI;
import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.internal.Lambda;

public final class ActivityViewModelLazyKt$viewModels$3 extends Lambda implements oIX0oI<ViewModelStore> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$3(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    public final ViewModelStore invoke() {
        return this.$this_viewModels.getViewModelStore();
    }
}
