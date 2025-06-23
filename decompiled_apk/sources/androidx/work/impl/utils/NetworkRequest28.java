package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNetworkRequestCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkRequestCompat.kt\nandroidx/work/impl/utils/NetworkRequest28\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,145:1\n13600#2,2:146\n13600#2,2:148\n*S KotlinDebug\n*F\n+ 1 NetworkRequestCompat.kt\nandroidx/work/impl/utils/NetworkRequest28\n*L\n109#1:146,2\n122#1:148,2\n*E\n"})
@RequiresApi(28)
/* loaded from: classes.dex */
public final class NetworkRequest28 {

    @OXOo.OOXIXo
    public static final NetworkRequest28 INSTANCE = new NetworkRequest28();

    private NetworkRequest28() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final NetworkRequest createNetworkRequest(@OXOo.OOXIXo int[] capabilities, @OXOo.OOXIXo int[] transports) {
        IIX0o.x0xO0oo(capabilities, "capabilities");
        IIX0o.x0xO0oo(transports, "transports");
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i : capabilities) {
            try {
                builder.addCapability(i);
            } catch (IllegalArgumentException e) {
                Logger.get().warning(NetworkRequestCompat.Companion.getTAG(), "Ignoring adding capability '" + i + '\'', e);
            }
        }
        for (int i2 : transports) {
            builder.addTransportType(i2);
        }
        NetworkRequest build = builder.build();
        IIX0o.oO(build, "networkRequest.build()");
        return build;
    }

    @OXOo.OOXIXo
    public final NetworkRequestCompat createNetworkRequestCompat$work_runtime_release(@OXOo.OOXIXo int[] capabilities, @OXOo.OOXIXo int[] transports) {
        IIX0o.x0xO0oo(capabilities, "capabilities");
        IIX0o.x0xO0oo(transports, "transports");
        return new NetworkRequestCompat(createNetworkRequest(capabilities, transports));
    }

    public final boolean hasCapability$work_runtime_release(@OXOo.OOXIXo NetworkRequest request, int i) {
        boolean hasCapability;
        IIX0o.x0xO0oo(request, "request");
        hasCapability = request.hasCapability(i);
        return hasCapability;
    }

    public final boolean hasTransport$work_runtime_release(@OXOo.OOXIXo NetworkRequest request, int i) {
        boolean hasTransport;
        IIX0o.x0xO0oo(request, "request");
        hasTransport = request.hasTransport(i);
        return hasTransport;
    }
}
