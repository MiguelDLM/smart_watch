package androidx.work.impl.utils;

import android.net.NetworkRequest;
import android.net.NetworkSpecifier;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(30)
/* loaded from: classes.dex */
public final class NetworkRequest30 {

    @OXOo.OOXIXo
    public static final NetworkRequest30 INSTANCE = new NetworkRequest30();

    private NetworkRequest30() {
    }

    @OXOo.oOoXoXO
    public final NetworkSpecifier getNetworkSpecifier(@OXOo.OOXIXo NetworkRequest request) {
        NetworkSpecifier networkSpecifier;
        IIX0o.x0xO0oo(request, "request");
        networkSpecifier = request.getNetworkSpecifier();
        return networkSpecifier;
    }
}
