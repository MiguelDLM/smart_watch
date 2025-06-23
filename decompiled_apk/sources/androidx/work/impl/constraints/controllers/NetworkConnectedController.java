package androidx.work.impl.constraints.controllers;

import OXOo.OOXIXo;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class NetworkConnectedController extends BaseConstraintController<NetworkState> {
    private final int reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkConnectedController(@OOXIXo ConstraintTracker<NetworkState> tracker) {
        super(tracker);
        IIX0o.x0xO0oo(tracker, "tracker");
        this.reason = 7;
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public int getReason() {
        return this.reason;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        if (workSpec.constraints.getRequiredNetworkType() == NetworkType.CONNECTED) {
            return true;
        }
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public boolean isConstrained(@OOXIXo NetworkState value) {
        IIX0o.x0xO0oo(value, "value");
        if (Build.VERSION.SDK_INT >= 26) {
            if (!value.isConnected() || !value.isValidated()) {
                return true;
            }
        } else if (!value.isConnected()) {
            return true;
        }
        return false;
    }
}
