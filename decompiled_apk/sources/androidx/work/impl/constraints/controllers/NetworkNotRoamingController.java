package androidx.work.impl.constraints.controllers;

import OXOo.OOXIXo;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public final class NetworkNotRoamingController extends BaseConstraintController<NetworkState> {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String TAG;
    private final int reason;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("NetworkNotRoamingCtrlr");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"NetworkNotRoamingCtrlr\")");
        TAG = tagWithPrefix;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkNotRoamingController(@OOXIXo ConstraintTracker<NetworkState> tracker) {
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
        if (workSpec.constraints.getRequiredNetworkType() == NetworkType.NOT_ROAMING) {
            return true;
        }
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public boolean isConstrained(@OOXIXo NetworkState value) {
        IIX0o.x0xO0oo(value, "value");
        if (Build.VERSION.SDK_INT < 24) {
            Logger.get().debug(TAG, "Not-roaming network constraint is not supported before API 24, only checking for connected state.");
            if (value.isConnected()) {
                return false;
            }
        } else if (value.isConnected() && value.isNotRoaming()) {
            return false;
        }
        return true;
    }
}
