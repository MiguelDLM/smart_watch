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
/* loaded from: classes.dex */
public final class NetworkRequestConstraintController$track$1$job$1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ IXxxXO<ConstraintsState> $$this$callbackFlow;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NetworkRequestConstraintController$track$1$job$1(NetworkRequestConstraintController networkRequestConstraintController, IXxxXO<? super ConstraintsState> iXxxXO, I0Io<? super NetworkRequestConstraintController$track$1$job$1> i0Io) {
        super(2, i0Io);
        this.this$0 = networkRequestConstraintController;
        this.$$this$callbackFlow = iXxxXO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        return new NetworkRequestConstraintController$track$1$job$1(this.this$0, this.$$this$callbackFlow, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        String str;
        long j2;
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            j = this.this$0.timeoutMs;
            this.label = 1;
            if (DelayKt.II0xO0(j, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("NetworkRequestConstraintController didn't receive neither  onCapabilitiesChanged/onLost callback, sending `ConstraintsNotMet` after ");
        j2 = this.this$0.timeoutMs;
        sb.append(j2);
        sb.append(" ms");
        logger.debug(str, sb.toString());
        this.$$this$callbackFlow.x0xO0oo(new ConstraintsState.ConstraintsNotMet(7));
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    public final Object invoke(xII xii, I0Io<? super oXIO0o0XI> i0Io) {
        return ((NetworkRequestConstraintController$track$1$job$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
