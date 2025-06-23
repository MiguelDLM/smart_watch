package androidx.activity.contextaware;

import Oox.oOoXoXO;
import android.content.Context;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.oO;

@XX({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1#2:89\n*E\n"})
/* loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ oO<R> $co;
    final /* synthetic */ oOoXoXO<Context, R> $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(oO<R> oOVar, oOoXoXO<Context, R> oooxoxo) {
        this.$co = oOVar;
        this.$onContextAvailable = oooxoxo;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object m287constructorimpl;
        IIX0o.x0xO0oo(context, "context");
        I0Io i0Io = this.$co;
        oOoXoXO<Context, R> oooxoxo = this.$onContextAvailable;
        try {
            Result.oIX0oI oix0oi = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(oooxoxo.invoke(context));
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(I0oOoX.oIX0oI(th));
        }
        i0Io.resumeWith(m287constructorimpl);
    }
}
