package androidx.activity;

import Oox.oIX0oI;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.Lambda;

public final class ActivityViewModelLazyKt$viewModels$4 extends Lambda implements oIX0oI<CreationExtras> {
    final /* synthetic */ oIX0oI<CreationExtras> $extrasProducer;
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$4(oIX0oI<? extends CreationExtras> oix0oi, ComponentActivity componentActivity) {
        super(0);
        this.$extrasProducer = oix0oi;
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.invoke();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
        /*
            r1 = this;
            Oox.oIX0oI<androidx.lifecycle.viewmodel.CreationExtras> r0 = r1.$extrasProducer
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
            if (r0 != 0) goto L_0x0012
        L_0x000c:
            androidx.activity.ComponentActivity r0 = r1.$this_viewModels
            androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ActivityViewModelLazyKt$viewModels$4.invoke():androidx.lifecycle.viewmodel.CreationExtras");
    }
}
