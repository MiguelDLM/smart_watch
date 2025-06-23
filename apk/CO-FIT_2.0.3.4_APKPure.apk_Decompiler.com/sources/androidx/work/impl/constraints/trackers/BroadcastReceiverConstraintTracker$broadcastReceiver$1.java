package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;

public final class BroadcastReceiverConstraintTracker$broadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ BroadcastReceiverConstraintTracker<T> this$0;

    public BroadcastReceiverConstraintTracker$broadcastReceiver$1(BroadcastReceiverConstraintTracker<T> broadcastReceiverConstraintTracker) {
        this.this$0 = broadcastReceiverConstraintTracker;
    }

    public void onReceive(Context context, Intent intent) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(intent, SDKConstants.PARAM_INTENT);
        this.this$0.onBroadcastReceive(intent);
    }
}
