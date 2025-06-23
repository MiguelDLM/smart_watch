package androidx.lifecycle;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;

/* JADX INFO: Add missing generic type declarations: [R] */
@XX({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt$withStateAtLeastUnchecked$2\n*L\n1#1,206:1\n*E\n"})
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$withStateAtLeastUnchecked$2<R> extends Lambda implements Oox.oIX0oI<R> {
    final /* synthetic */ Oox.oIX0oI<R> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WithLifecycleStateKt$withStateAtLeastUnchecked$2(Oox.oIX0oI<? extends R> oix0oi) {
        super(0);
        this.$block = oix0oi;
    }

    @Override // Oox.oIX0oI
    public final R invoke() {
        return this.$block.invoke();
    }
}
