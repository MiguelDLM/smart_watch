package androidx.work.impl.utils;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.net.ConnectivityManager;
import android.net.Network;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(23)
@xxIXOIIO(name = "NetworkApi23")
public final class NetworkApi23 {
    @oOoXoXO
    public static final Network getActiveNetworkCompat(@OOXIXo ConnectivityManager connectivityManager) {
        IIX0o.x0xO0oo(connectivityManager, "<this>");
        return connectivityManager.getActiveNetwork();
    }
}
