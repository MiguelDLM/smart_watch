package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "NetworkApi21")
@RequiresApi(21)
/* loaded from: classes.dex */
public final class NetworkApi21 {
    @OXOo.oOoXoXO
    public static final NetworkCapabilities getNetworkCapabilitiesCompat(@OXOo.OOXIXo ConnectivityManager connectivityManager, @OXOo.oOoXoXO Network network) {
        IIX0o.x0xO0oo(connectivityManager, "<this>");
        return connectivityManager.getNetworkCapabilities(network);
    }

    public static final boolean hasCapabilityCompat(@OXOo.OOXIXo NetworkCapabilities networkCapabilities, int i) {
        IIX0o.x0xO0oo(networkCapabilities, "<this>");
        return networkCapabilities.hasCapability(i);
    }

    public static final void unregisterNetworkCallbackCompat(@OXOo.OOXIXo ConnectivityManager connectivityManager, @OXOo.OOXIXo ConnectivityManager.NetworkCallback networkCallback) {
        IIX0o.x0xO0oo(connectivityManager, "<this>");
        IIX0o.x0xO0oo(networkCallback, "networkCallback");
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
