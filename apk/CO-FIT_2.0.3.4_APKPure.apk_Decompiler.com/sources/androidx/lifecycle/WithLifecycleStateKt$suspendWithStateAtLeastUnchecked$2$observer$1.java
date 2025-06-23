package androidx.lifecycle;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.oO;

public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ oIX0oI<R> $block;
    final /* synthetic */ oO<R> $co;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(Lifecycle.State state, Lifecycle lifecycle, oO<? super R> oOVar, oIX0oI<? extends R> oix0oi) {
        this.$state = state;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$co = oOVar;
        this.$block = oix0oi;
    }

    public void onStateChanged(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.Event event) {
        Object obj;
        IIX0o.x0xO0oo(lifecycleOwner, "source");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.Companion.upTo(this.$state)) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
            oO<R> oOVar = this.$co;
            oIX0oI<R> oix0oi = this.$block;
            try {
                Result.oIX0oI oix0oi2 = Result.Companion;
                obj = Result.m42constructorimpl(oix0oi.invoke());
            } catch (Throwable th) {
                Result.oIX0oI oix0oi3 = Result.Companion;
                obj = Result.m42constructorimpl(I0oOoX.oIX0oI(th));
            }
            oOVar.resumeWith(obj);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
            oO<R> oOVar2 = this.$co;
            Result.oIX0oI oix0oi4 = Result.Companion;
            oOVar2.resumeWith(Result.m42constructorimpl(I0oOoX.oIX0oI(new LifecycleDestroyedException())));
        }
    }
}
