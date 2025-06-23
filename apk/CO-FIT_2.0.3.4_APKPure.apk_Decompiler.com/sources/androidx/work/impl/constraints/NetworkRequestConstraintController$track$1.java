package androidx.work.impl.constraints;

import IXIxx0.oxoX;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import android.net.NetworkRequest;
import androidx.work.Constraints;
import androidx.work.Logger;
import kotlin.I0oOoX;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.oI0IIXIo;
import kotlinx.coroutines.xoIox;

@oxoX(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1", f = "WorkConstraintsTracker.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
public final class NetworkRequestConstraintController$track$1 extends SuspendLambda implements x0xO0oo<IXxxXO<? super ConstraintsState>, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Constraints $constraints;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkRequestConstraintController$track$1(Constraints constraints, NetworkRequestConstraintController networkRequestConstraintController, I0Io<? super NetworkRequestConstraintController$track$1> i0Io) {
        super(2, i0Io);
        this.$constraints = constraints;
        this.this$0 = networkRequestConstraintController;
    }

    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        NetworkRequestConstraintController$track$1 networkRequestConstraintController$track$1 = new NetworkRequestConstraintController$track$1(this.$constraints, this.this$0, i0Io);
        networkRequestConstraintController$track$1.L$0 = obj;
        return networkRequestConstraintController$track$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            IXxxXO iXxxXO = (IXxxXO) this.L$0;
            NetworkRequest requiredNetworkRequest = this.$constraints.getRequiredNetworkRequest();
            if (requiredNetworkRequest == null) {
                oI0IIXIo.oIX0oI.oIX0oI(iXxxXO.getChannel(), (Throwable) null, 1, (Object) null);
                return oXIO0o0XI.f19155oIX0oI;
            }
            final NetworkRequestConstraintController$track$1$networkCallback$1 networkRequestConstraintController$track$1$networkCallback$1 = new NetworkRequestConstraintController$track$1$networkCallback$1(xoIox.XO(iXxxXO, (CoroutineContext) null, (CoroutineStart) null, new NetworkRequestConstraintController$track$1$job$1(this.this$0, iXxxXO, (I0Io<? super NetworkRequestConstraintController$track$1$job$1>) null), 3, (Object) null), iXxxXO);
            Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController register callback");
            this.this$0.connManager.registerNetworkCallback(requiredNetworkRequest, networkRequestConstraintController$track$1$networkCallback$1);
            final NetworkRequestConstraintController networkRequestConstraintController = this.this$0;
            AnonymousClass1 r1 = new oIX0oI<oXIO0o0XI>() {
                public final void invoke() {
                    Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController unregister callback");
                    networkRequestConstraintController.connManager.unregisterNetworkCallback(networkRequestConstraintController$track$1$networkCallback$1);
                }
            };
            this.label = 1;
            if (ProduceKt.oIX0oI(iXxxXO, r1, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            I0oOoX.x0XOIxOo(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final Object invoke(IXxxXO<? super ConstraintsState> iXxxXO, I0Io<? super oXIO0o0XI> i0Io) {
        return ((NetworkRequestConstraintController$track$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
