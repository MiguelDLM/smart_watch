package androidx.work.impl.constraints.trackers;

import OXOo.OOXIXo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class NetworkStateTrackerPre24 extends BroadcastReceiverConstraintTracker<NetworkState> {

    @OOXIXo
    private final ConnectivityManager connectivityManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkStateTrackerPre24(@OOXIXo Context context, @OOXIXo TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
        Object systemService = getAppContext().getSystemService("connectivity");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
    }

    public static /* synthetic */ void getIntentFilter$annotations() {
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    @OOXIXo
    public IntentFilter getIntentFilter() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(@OOXIXo Intent intent) {
        String str;
        IIX0o.x0xO0oo(intent, "intent");
        if (IIX0o.Oxx0IOOO(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            Logger logger = Logger.get();
            str = NetworkStateTrackerKt.TAG;
            logger.debug(str, "Network broadcast received");
            setState(NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager));
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    @OOXIXo
    public NetworkState readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }
}
