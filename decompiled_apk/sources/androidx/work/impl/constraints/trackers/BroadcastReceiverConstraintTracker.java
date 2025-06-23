package androidx.work.impl.constraints.trackers;

import OXOo.OOXIXo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class BroadcastReceiverConstraintTracker<T> extends ConstraintTracker<T> {

    @OOXIXo
    private final BroadcastReceiver broadcastReceiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastReceiverConstraintTracker(@OOXIXo Context context, @OOXIXo TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
        this.broadcastReceiver = new BroadcastReceiver(this) { // from class: androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker$broadcastReceiver$1
            final /* synthetic */ BroadcastReceiverConstraintTracker<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                IIX0o.x0xO0oo(context2, "context");
                IIX0o.x0xO0oo(intent, "intent");
                this.this$0.onBroadcastReceive(intent);
            }
        };
    }

    @OOXIXo
    public abstract IntentFilter getIntentFilter();

    public abstract void onBroadcastReceive(@OOXIXo Intent intent);

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        String str;
        Logger logger = Logger.get();
        str = BroadcastReceiverConstraintTrackerKt.TAG;
        logger.debug(str, getClass().getSimpleName() + ": registering receiver");
        getAppContext().registerReceiver(this.broadcastReceiver, getIntentFilter());
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        String str;
        Logger logger = Logger.get();
        str = BroadcastReceiverConstraintTrackerKt.TAG;
        logger.debug(str, getClass().getSimpleName() + ": unregistering receiver");
        getAppContext().unregisterReceiver(this.broadcastReceiver);
    }
}
