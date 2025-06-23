package androidx.work.impl.utils;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(21)
@xxIXOIIO(name = "NetworkApi21")
public final class NetworkApi21 {
    @oOoXoXO
    public static final NetworkCapabilities getNetworkCapabilitiesCompat(@OOXIXo ConnectivityManager connectivityManager, @oOoXoXO Network network) {
        IIX0o.x0xO0oo(connectivityManager, "<this>");
        return connectivityManager.getNetworkCapabilities(network);
    }

    public static final boolean hasCapabilityCompat(@OOXIXo NetworkCapabilities networkCapabilities, int i) {
        IIX0o.x0xO0oo(networkCapabilities, "<this>");
        return networkCapabilities.hasCapability(i);
    }

    public static final void unregisterNetworkCallbackCompat(@OOXIXo ConnectivityManager connectivityManager, @OOXIXo ConnectivityManager.NetworkCallback networkCallback) {
        IIX0o.x0xO0oo(connectivityManager, "<this>");
        IIX0o.x0xO0oo(networkCallback, "networkCallback");
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
