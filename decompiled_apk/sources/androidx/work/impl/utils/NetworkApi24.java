package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "NetworkApi24")
@RequiresApi(24)
/* loaded from: classes.dex */
public final class NetworkApi24 {
    public static final void registerDefaultNetworkCallbackCompat(@OXOo.OOXIXo ConnectivityManager connectivityManager, @OXOo.OOXIXo ConnectivityManager.NetworkCallback networkCallback) {
        IIX0o.x0xO0oo(connectivityManager, "<this>");
        IIX0o.x0xO0oo(networkCallback, "networkCallback");
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }
}
