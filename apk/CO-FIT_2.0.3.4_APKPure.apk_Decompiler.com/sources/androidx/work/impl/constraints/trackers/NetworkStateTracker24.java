package androidx.work.impl.constraints.trackers;

import OXOo.OOXIXo;
import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(24)
public final class NetworkStateTracker24 extends ConstraintTracker<NetworkState> {
    /* access modifiers changed from: private */
    @OOXIXo
    public final ConnectivityManager connectivityManager;
    @OOXIXo
    private final NetworkStateTracker24$networkCallback$1 networkCallback = new NetworkStateTracker24$networkCallback$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkStateTracker24(@OOXIXo Context context, @OOXIXo TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
        Object systemService = getAppContext().getSystemService("connectivity");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
    }

    public void startTracking() {
        try {
            Logger.get().debug(NetworkStateTrackerKt.TAG, "Registering network callback");
            NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while registering network callback", e);
        } catch (SecurityException e2) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while registering network callback", e2);
        }
    }

    public void stopTracking() {
        try {
            Logger.get().debug(NetworkStateTrackerKt.TAG, "Unregistering network callback");
            NetworkApi21.unregisterNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while unregistering network callback", e);
        } catch (SecurityException e2) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while unregistering network callback", e2);
        }
    }

    @OOXIXo
    public NetworkState readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }
}
