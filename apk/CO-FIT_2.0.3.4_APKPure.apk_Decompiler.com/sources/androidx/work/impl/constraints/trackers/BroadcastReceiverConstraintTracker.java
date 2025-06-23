package androidx.work.impl.constraints.trackers;

import OXOo.OOXIXo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class BroadcastReceiverConstraintTracker<T> extends ConstraintTracker<T> {
    @OOXIXo
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiverConstraintTracker$broadcastReceiver$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastReceiverConstraintTracker(@OOXIXo Context context, @OOXIXo TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
    }

    @OOXIXo
    public abstract IntentFilter getIntentFilter();

    public abstract void onBroadcastReceive(@OOXIXo Intent intent);

    public void startTracking() {
        Logger logger = Logger.get();
        String access$getTAG$p = BroadcastReceiverConstraintTrackerKt.TAG;
        logger.debug(access$getTAG$p, getClass().getSimpleName() + ": registering receiver");
        getAppContext().registerReceiver(this.broadcastReceiver, getIntentFilter());
    }

    public void stopTracking() {
        Logger logger = Logger.get();
        String access$getTAG$p = BroadcastReceiverConstraintTrackerKt.TAG;
        logger.debug(access$getTAG$p, getClass().getSimpleName() + ": unregistering receiver");
        getAppContext().unregisterReceiver(this.broadcastReceiver);
    }
}
