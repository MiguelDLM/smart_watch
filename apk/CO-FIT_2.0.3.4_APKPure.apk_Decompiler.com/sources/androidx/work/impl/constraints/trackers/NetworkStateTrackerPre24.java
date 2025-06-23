package androidx.work.impl.constraints.trackers;

import OXOo.OOXIXo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;

public final class NetworkStateTrackerPre24 extends BroadcastReceiverConstraintTracker<NetworkState> {
    @OOXIXo
    private final ConnectivityManager connectivityManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkStateTrackerPre24(@OOXIXo Context context, @OOXIXo TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
        Object systemService = getAppContext().getSystemService("connectivity");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
    }

    public static /* synthetic */ void getIntentFilter$annotations() {
    }

    @OOXIXo
    public IntentFilter getIntentFilter() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public void onBroadcastReceive(@OOXIXo Intent intent) {
        IIX0o.x0xO0oo(intent, SDKConstants.PARAM_INTENT);
        if (IIX0o.Oxx0IOOO(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            Logger.get().debug(NetworkStateTrackerKt.TAG, "Network broadcast received");
            setState(NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager));
        }
    }

    @OOXIXo
    public NetworkState readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }
}
