package androidx.work.impl.constraints;

import IXIxx0.oxoX;
import Oox.x0xO0oo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$job$1", f = "WorkConstraintsTracker.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
public final class NetworkRequestConstraintController$track$1$job$1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ IXxxXO<ConstraintsState> $$this$callbackFlow;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkRequestConstraintController$track$1$job$1(NetworkRequestConstraintController networkRequestConstraintController, IXxxXO<? super ConstraintsState> iXxxXO, I0Io<? super NetworkRequestConstraintController$track$1$job$1> i0Io) {
        super(2, i0Io);
        this.this$0 = networkRequestConstraintController;
        this.$$this$callbackFlow = iXxxXO;
    }

    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        return new NetworkRequestConstraintController$track$1$job$1(this.this$0, this.$$this$callbackFlow, i0Io);
    }

    public final Object invokeSuspend(Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            long access$getTimeoutMs$p = this.this$0.timeoutMs;
            this.label = 1;
            if (DelayKt.II0xO0(access$getTimeoutMs$p, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            I0oOoX.x0XOIxOo(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Logger logger = Logger.get();
        String access$getTAG$p = WorkConstraintsTrackerKt.TAG;
        logger.debug(access$getTAG$p, "NetworkRequestConstraintController didn't receive neither  onCapabilitiesChanged/onLost callback, sending `ConstraintsNotMet` after " + this.this$0.timeoutMs + " ms");
        this.$$this$callbackFlow.x0xO0oo(new ConstraintsState.ConstraintsNotMet(7));
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final Object invoke(xII xii, I0Io<? super oXIO0o0XI> i0Io) {
        return ((NetworkRequestConstraintController$track$1$job$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
