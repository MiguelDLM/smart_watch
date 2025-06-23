package androidx.core.os;

import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postAtTime$runnable$1\n*L\n1#1,69:1\n*E\n"})
/* loaded from: classes.dex */
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ Oox.oIX0oI<oXIO0o0XI> $action;

    public HandlerKt$postAtTime$runnable$1(Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        this.$action = oix0oi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
