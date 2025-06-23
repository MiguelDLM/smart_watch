package androidx.work.impl.constraints.controllers;

import OXOo.OOXIXo;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public final class NetworkNotRoamingController extends BaseConstraintController<NetworkState> {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private static final String TAG;
    private final int reason = 7;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkNotRoamingController(@OOXIXo ConstraintTracker<NetworkState> constraintTracker) {
        super(constraintTracker);
        IIX0o.x0xO0oo(constraintTracker, "tracker");
    }

    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        if (workSpec.constraints.getRequiredNetworkType() == NetworkType.NOT_ROAMING) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001e A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isConstrained(@OXOo.OOXIXo androidx.work.impl.constraints.NetworkState r6) {
        /*
            r5 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            r2 = 0
            r3 = 1
            if (r0 >= r1) goto L_0x0020
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.String r4 = "Not-roaming network constraint is not supported before API 24, only checking for connected state."
            r0.debug(r1, r4)
            boolean r6 = r6.isConnected()
            if (r6 != 0) goto L_0x002d
        L_0x001e:
            r2 = 1
            goto L_0x002d
        L_0x0020:
            boolean r0 = r6.isConnected()
            if (r0 == 0) goto L_0x001e
            boolean r6 = r6.isNotRoaming()
            if (r6 != 0) goto L_0x002d
            goto L_0x001e
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.controllers.NetworkNotRoamingController.isConstrained(androidx.work.impl.constraints.NetworkState):boolean");
    }
}
