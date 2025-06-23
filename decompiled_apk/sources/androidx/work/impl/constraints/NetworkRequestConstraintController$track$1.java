package androidx.work.impl.constraints;

import IXIxx0.oxoX;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.oI0IIXIo;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.xoIox;

@oxoX(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1", f = "WorkConstraintsTracker.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class NetworkRequestConstraintController$track$1 extends SuspendLambda implements x0xO0oo<IXxxXO<? super ConstraintsState>, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Constraints $constraints;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkRequestConstraintController$track$1(Constraints constraints, NetworkRequestConstraintController networkRequestConstraintController, I0Io<? super NetworkRequestConstraintController$track$1> i0Io) {
        super(2, i0Io);
        this.$constraints = constraints;
        this.this$0 = networkRequestConstraintController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        NetworkRequestConstraintController$track$1 networkRequestConstraintController$track$1 = new NetworkRequestConstraintController$track$1(this.$constraints, this.this$0, i0Io);
        networkRequestConstraintController$track$1.L$0 = obj;
        return networkRequestConstraintController$track$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$networkCallback$1, android.net.ConnectivityManager$NetworkCallback] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final kotlinx.coroutines.oXIO0o0XI XO2;
        String str;
        ConnectivityManager connectivityManager;
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
            final IXxxXO iXxxXO = (IXxxXO) this.L$0;
            NetworkRequest requiredNetworkRequest = this.$constraints.getRequiredNetworkRequest();
            if (requiredNetworkRequest != null) {
                XO2 = xoIox.XO(iXxxXO, null, null, new NetworkRequestConstraintController$track$1$job$1(this.this$0, iXxxXO, null), 3, null);
                final ?? r4 = new ConnectivityManager.NetworkCallback() { // from class: androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$networkCallback$1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                        String str2;
                        IIX0o.x0xO0oo(network, "network");
                        IIX0o.x0xO0oo(networkCapabilities, "networkCapabilities");
                        oXIO0o0XI.oIX0oI.II0xO0(kotlinx.coroutines.oXIO0o0XI.this, null, 1, null);
                        Logger logger = Logger.get();
                        str2 = WorkConstraintsTrackerKt.TAG;
                        logger.debug(str2, "NetworkRequestConstraintController onCapabilitiesChanged callback");
                        iXxxXO.x0xO0oo(ConstraintsState.ConstraintsMet.INSTANCE);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network) {
                        String str2;
                        IIX0o.x0xO0oo(network, "network");
                        oXIO0o0XI.oIX0oI.II0xO0(kotlinx.coroutines.oXIO0o0XI.this, null, 1, null);
                        Logger logger = Logger.get();
                        str2 = WorkConstraintsTrackerKt.TAG;
                        logger.debug(str2, "NetworkRequestConstraintController onLost callback");
                        iXxxXO.x0xO0oo(new ConstraintsState.ConstraintsNotMet(7));
                    }
                };
                Logger logger = Logger.get();
                str = WorkConstraintsTrackerKt.TAG;
                logger.debug(str, "NetworkRequestConstraintController register callback");
                connectivityManager = this.this$0.connManager;
                connectivityManager.registerNetworkCallback(requiredNetworkRequest, (ConnectivityManager.NetworkCallback) r4);
                final NetworkRequestConstraintController networkRequestConstraintController = this.this$0;
                oIX0oI<kotlin.oXIO0o0XI> oix0oi = new oIX0oI<kotlin.oXIO0o0XI>() { // from class: androidx.work.impl.constraints.NetworkRequestConstraintController$track$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                        invoke2();
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        String str2;
                        ConnectivityManager connectivityManager2;
                        Logger logger2 = Logger.get();
                        str2 = WorkConstraintsTrackerKt.TAG;
                        logger2.debug(str2, "NetworkRequestConstraintController unregister callback");
                        connectivityManager2 = NetworkRequestConstraintController.this.connManager;
                        connectivityManager2.unregisterNetworkCallback(r4);
                    }
                };
                this.label = 1;
                if (ProduceKt.oIX0oI(iXxxXO, oix0oi, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            } else {
                oI0IIXIo.oIX0oI.oIX0oI(iXxxXO.getChannel(), null, 1, null);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }
        }
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    public final Object invoke(IXxxXO<? super ConstraintsState> iXxxXO, I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        return ((NetworkRequestConstraintController$track$1) create(iXxxXO, i0Io)).invokeSuspend(kotlin.oXIO0o0XI.f29392oIX0oI);
    }
}
