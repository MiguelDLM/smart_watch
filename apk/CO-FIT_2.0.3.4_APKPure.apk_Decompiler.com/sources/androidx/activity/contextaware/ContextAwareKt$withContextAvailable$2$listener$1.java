package androidx.activity.contextaware;

import Oox.oOoXoXO;
import android.content.Context;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.oO;

@XX({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1#2:89\n*E\n"})
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ oO<R> $co;
    final /* synthetic */ oOoXoXO<Context, R> $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(oO<R> oOVar, oOoXoXO<Context, R> oooxoxo) {
        this.$co = oOVar;
        this.$onContextAvailable = oooxoxo;
    }

    public void onContextAvailable(Context context) {
        Object obj;
        IIX0o.x0xO0oo(context, bn.f.o);
        oO<R> oOVar = this.$co;
        oOoXoXO<Context, R> oooxoxo = this.$onContextAvailable;
        try {
            Result.oIX0oI oix0oi = Result.Companion;
            obj = Result.m42constructorimpl(oooxoxo.invoke(context));
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            obj = Result.m42constructorimpl(I0oOoX.oIX0oI(th));
        }
        oOVar.resumeWith(obj);
    }
}
