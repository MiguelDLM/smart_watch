package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.oXIO0o0XI;

public final class NetworkRequestConstraintController$track$1$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ IXxxXO<ConstraintsState> $$this$callbackFlow;
    final /* synthetic */ oXIO0o0XI $job;

    public NetworkRequestConstraintController$track$1$networkCallback$1(oXIO0o0XI oxio0o0xi, IXxxXO<? super ConstraintsState> iXxxXO) {
        this.$job = oxio0o0xi;
        this.$$this$callbackFlow = iXxxXO;
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        IIX0o.x0xO0oo(network, "network");
        IIX0o.x0xO0oo(networkCapabilities, "networkCapabilities");
        oXIO0o0XI.oIX0oI.II0xO0(this.$job, (CancellationException) null, 1, (Object) null);
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        this.$$this$callbackFlow.x0xO0oo(ConstraintsState.ConstraintsMet.INSTANCE);
    }

    public void onLost(Network network) {
        IIX0o.x0xO0oo(network, "network");
        oXIO0o0XI.oIX0oI.II0xO0(this.$job, (CancellationException) null, 1, (Object) null);
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onLost callback");
        this.$$this$callbackFlow.x0xO0oo(new ConstraintsState.ConstraintsNotMet(7));
    }
}
