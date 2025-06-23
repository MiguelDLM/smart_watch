package androidx.work.impl.utils;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@RequiresApi(28)
@XX({"SMAP\nNetworkRequestCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkRequestCompat.kt\nandroidx/work/impl/utils/NetworkRequest28\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,145:1\n13600#2,2:146\n13600#2,2:148\n*S KotlinDebug\n*F\n+ 1 NetworkRequestCompat.kt\nandroidx/work/impl/utils/NetworkRequest28\n*L\n109#1:146,2\n122#1:148,2\n*E\n"})
public final class NetworkRequest28 {
    @OOXIXo
    public static final NetworkRequest28 INSTANCE = new NetworkRequest28();

    private NetworkRequest28() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final NetworkRequest createNetworkRequest(@OOXIXo int[] iArr, @OOXIXo int[] iArr2) {
        IIX0o.x0xO0oo(iArr, "capabilities");
        IIX0o.x0xO0oo(iArr2, "transports");
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i : iArr) {
            try {
                builder.addCapability(i);
            } catch (IllegalArgumentException e) {
                Logger.get().warning(NetworkRequestCompat.Companion.getTAG(), "Ignoring adding capability '" + i + '\'', e);
            }
        }
        for (int addTransportType : iArr2) {
            builder.addTransportType(addTransportType);
        }
        NetworkRequest build = builder.build();
        IIX0o.oO(build, "networkRequest.build()");
        return build;
    }

    @OOXIXo
    public final NetworkRequestCompat createNetworkRequestCompat$work_runtime_release(@OOXIXo int[] iArr, @OOXIXo int[] iArr2) {
        IIX0o.x0xO0oo(iArr, "capabilities");
        IIX0o.x0xO0oo(iArr2, "transports");
        return new NetworkRequestCompat(createNetworkRequest(iArr, iArr2));
    }

    public final boolean hasCapability$work_runtime_release(@OOXIXo NetworkRequest networkRequest, int i) {
        IIX0o.x0xO0oo(networkRequest, "request");
        return networkRequest.hasCapability(i);
    }

    public final boolean hasTransport$work_runtime_release(@OOXIXo NetworkRequest networkRequest, int i) {
        IIX0o.x0xO0oo(networkRequest, "request");
        return networkRequest.hasTransport(i);
    }
}
