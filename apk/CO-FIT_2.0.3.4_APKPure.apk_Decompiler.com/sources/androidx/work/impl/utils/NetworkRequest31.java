package androidx.work.impl.utils;

import OXOo.OOXIXo;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(31)
final class NetworkRequest31 {
    @OOXIXo
    public static final NetworkRequest31 INSTANCE = new NetworkRequest31();

    private NetworkRequest31() {
    }

    @OOXIXo
    public final int[] capabilities(@OOXIXo NetworkRequest networkRequest) {
        IIX0o.x0xO0oo(networkRequest, "request");
        int[] oIX0oI2 = networkRequest.getCapabilities();
        IIX0o.oO(oIX0oI2, "request.capabilities");
        return oIX0oI2;
    }

    @OOXIXo
    public final int[] transportTypes(@OOXIXo NetworkRequest networkRequest) {
        IIX0o.x0xO0oo(networkRequest, "request");
        int[] oIX0oI2 = networkRequest.getTransportTypes();
        IIX0o.oO(oIX0oI2, "request.transportTypes");
        return oIX0oI2;
    }
}
