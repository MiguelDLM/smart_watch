package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(31)
/* loaded from: classes.dex */
final class NetworkRequest31 {

    @OXOo.OOXIXo
    public static final NetworkRequest31 INSTANCE = new NetworkRequest31();

    private NetworkRequest31() {
    }

    @OXOo.OOXIXo
    public final int[] capabilities(@OXOo.OOXIXo NetworkRequest request) {
        int[] capabilities;
        IIX0o.x0xO0oo(request, "request");
        capabilities = request.getCapabilities();
        IIX0o.oO(capabilities, "request.capabilities");
        return capabilities;
    }

    @OXOo.OOXIXo
    public final int[] transportTypes(@OXOo.OOXIXo NetworkRequest request) {
        int[] transportTypes;
        IIX0o.x0xO0oo(request, "request");
        transportTypes = request.getTransportTypes();
        IIX0o.oO(transportTypes, "request.transportTypes");
        return transportTypes;
    }
}
