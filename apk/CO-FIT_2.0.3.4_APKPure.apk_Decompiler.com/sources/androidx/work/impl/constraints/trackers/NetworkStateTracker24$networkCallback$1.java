package androidx.work.impl.constraints.trackers;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import kotlin.jvm.internal.IIX0o;

public final class NetworkStateTracker24$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ NetworkStateTracker24 this$0;

    public NetworkStateTracker24$networkCallback$1(NetworkStateTracker24 networkStateTracker24) {
        this.this$0 = networkStateTracker24;
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        NetworkState networkState;
        IIX0o.x0xO0oo(network, "network");
        IIX0o.x0xO0oo(networkCapabilities, "capabilities");
        Logger logger = Logger.get();
        String access$getTAG$p = NetworkStateTrackerKt.TAG;
        logger.debug(access$getTAG$p, "Network capabilities changed: " + networkCapabilities);
        NetworkStateTracker24 networkStateTracker24 = this.this$0;
        if (Build.VERSION.SDK_INT >= 28) {
            networkState = NetworkStateTrackerKt.getActiveNetworkState(networkCapabilities);
        } else {
            networkState = NetworkStateTrackerKt.getActiveNetworkState(networkStateTracker24.connectivityManager);
        }
        networkStateTracker24.setState(networkState);
    }

    public void onLost(Network network) {
        IIX0o.x0xO0oo(network, "network");
        Logger.get().debug(NetworkStateTrackerKt.TAG, "Network connection lost");
        NetworkStateTracker24 networkStateTracker24 = this.this$0;
        networkStateTracker24.setState(NetworkStateTrackerKt.getActiveNetworkState(networkStateTracker24.connectivityManager));
    }
}
