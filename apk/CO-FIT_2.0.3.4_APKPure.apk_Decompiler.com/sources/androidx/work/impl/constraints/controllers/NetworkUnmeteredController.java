package androidx.work.impl.constraints.controllers;

import OXOo.OOXIXo;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;

public final class NetworkUnmeteredController extends BaseConstraintController<NetworkState> {
    private final int reason = 7;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkUnmeteredController(@OOXIXo ConstraintTracker<NetworkState> constraintTracker) {
        super(constraintTracker);
        IIX0o.x0xO0oo(constraintTracker, "tracker");
    }

    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        NetworkType requiredNetworkType = workSpec.constraints.getRequiredNetworkType();
        if (requiredNetworkType == NetworkType.UNMETERED || (Build.VERSION.SDK_INT >= 30 && requiredNetworkType == NetworkType.TEMPORARILY_UNMETERED)) {
            return true;
        }
        return false;
    }

    public boolean isConstrained(@OOXIXo NetworkState networkState) {
        IIX0o.x0xO0oo(networkState, "value");
        return !networkState.isConnected() || networkState.isMetered();
    }
}
