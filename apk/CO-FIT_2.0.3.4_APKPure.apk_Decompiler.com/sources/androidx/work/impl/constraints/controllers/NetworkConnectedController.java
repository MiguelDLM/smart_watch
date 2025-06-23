package androidx.work.impl.constraints.controllers;

import OXOo.OOXIXo;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;

public final class NetworkConnectedController extends BaseConstraintController<NetworkState> {
    private final int reason = 7;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkConnectedController(@OOXIXo ConstraintTracker<NetworkState> constraintTracker) {
        super(constraintTracker);
        IIX0o.x0xO0oo(constraintTracker, "tracker");
    }

    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        if (workSpec.constraints.getRequiredNetworkType() == NetworkType.CONNECTED) {
            return true;
        }
        return false;
    }

    public boolean isConstrained(@OOXIXo NetworkState networkState) {
        IIX0o.x0xO0oo(networkState, "value");
        if (Build.VERSION.SDK_INT >= 26) {
            if (!networkState.isConnected() || !networkState.isValidated()) {
                return true;
            }
        } else if (!networkState.isConnected()) {
            return true;
        }
        return false;
    }
}
