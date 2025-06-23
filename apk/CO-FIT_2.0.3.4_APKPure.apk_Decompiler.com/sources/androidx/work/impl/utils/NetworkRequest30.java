package androidx.work.impl.utils;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.net.NetworkRequest;
import android.net.NetworkSpecifier;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(30)
public final class NetworkRequest30 {
    @OOXIXo
    public static final NetworkRequest30 INSTANCE = new NetworkRequest30();

    private NetworkRequest30() {
    }

    @oOoXoXO
    public final NetworkSpecifier getNetworkSpecifier(@OOXIXo NetworkRequest networkRequest) {
        IIX0o.x0xO0oo(networkRequest, "request");
        return networkRequest.getNetworkSpecifier();
    }
}
