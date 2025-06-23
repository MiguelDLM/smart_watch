package kotlinx.coroutines.flow;

import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;

/* JADX INFO: Add missing generic type declarations: [T] */
@XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$1\n*L\n1#1,332:1\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__ZipKt$combine$5$1<T> extends Lambda implements Oox.oIX0oI<T[]> {
    final /* synthetic */ X0o0xo<T>[] $flows;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$1(X0o0xo<? extends T>[] x0o0xoArr) {
        super(0);
        this.$flows = x0o0xoArr;
    }

    @Override // Oox.oIX0oI
    @OXOo.oOoXoXO
    public final T[] invoke() {
        int length = this.$flows.length;
        IIX0o.OxI(0, "T?");
        return (T[]) new Object[length];
    }
}
