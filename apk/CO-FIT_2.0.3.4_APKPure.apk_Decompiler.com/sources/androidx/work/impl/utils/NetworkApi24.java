package androidx.work.impl.utils;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(24)
@xxIXOIIO(name = "NetworkApi24")
public final class NetworkApi24 {
    public static final void registerDefaultNetworkCallbackCompat(@OOXIXo ConnectivityManager connectivityManager, @OOXIXo ConnectivityManager.NetworkCallback networkCallback) {
        IIX0o.x0xO0oo(connectivityManager, "<this>");
        IIX0o.x0xO0oo(networkCallback, "networkCallback");
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }
}
