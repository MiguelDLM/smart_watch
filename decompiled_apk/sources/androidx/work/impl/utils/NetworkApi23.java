package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "NetworkApi23")
@RequiresApi(23)
/* loaded from: classes.dex */
public final class NetworkApi23 {
    @OXOo.oOoXoXO
    public static final Network getActiveNetworkCompat(@OXOo.OOXIXo ConnectivityManager connectivityManager) {
        Network activeNetwork;
        IIX0o.x0xO0oo(connectivityManager, "<this>");
        activeNetwork = connectivityManager.getActiveNetwork();
        return activeNetwork;
    }
}
