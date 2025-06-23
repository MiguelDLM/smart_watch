package androidx.activity;

import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class ActivityViewModelLazyKt$viewModels$3 extends Lambda implements Oox.oIX0oI<ViewModelStore> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$3(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // Oox.oIX0oI
    public final ViewModelStore invoke() {
        return this.$this_viewModels.getViewModelStore();
    }
}
