package androidx.activity;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class ActivityViewModelLazyKt$viewModels$4 extends Lambda implements Oox.oIX0oI<CreationExtras> {
    final /* synthetic */ Oox.oIX0oI<CreationExtras> $extrasProducer;
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ActivityViewModelLazyKt$viewModels$4(Oox.oIX0oI<? extends CreationExtras> oix0oi, ComponentActivity componentActivity) {
        super(0);
        this.$extrasProducer = oix0oi;
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // Oox.oIX0oI
    public final CreationExtras invoke() {
        CreationExtras invoke;
        Oox.oIX0oI<CreationExtras> oix0oi = this.$extrasProducer;
        return (oix0oi == null || (invoke = oix0oi.invoke()) == null) ? this.$this_viewModels.getDefaultViewModelCreationExtras() : invoke;
    }
}
