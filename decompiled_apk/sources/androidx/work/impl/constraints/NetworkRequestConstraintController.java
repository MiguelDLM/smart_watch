package androidx.work.impl.constraints;

import OXOo.OOXIXo;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Constraints;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;

@RequiresApi(28)
/* loaded from: classes.dex */
public final class NetworkRequestConstraintController implements ConstraintController {

    @OOXIXo
    private final ConnectivityManager connManager;
    private final long timeoutMs;

    public NetworkRequestConstraintController(@OOXIXo ConnectivityManager connManager, long j) {
        IIX0o.x0xO0oo(connManager, "connManager");
        this.connManager = connManager;
        this.timeoutMs = j;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        if (workSpec.constraints.getRequiredNetworkRequest() != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean isCurrentlyConstrained(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        if (!hasConstraint(workSpec)) {
            return false;
        }
        throw new IllegalStateException("isCurrentlyConstrained() must never be called onNetworkRequestConstraintController. isCurrentlyConstrained() is called only on older platforms where NetworkRequest isn't supported");
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    @OOXIXo
    public X0o0xo<ConstraintsState> track(@OOXIXo Constraints constraints) {
        IIX0o.x0xO0oo(constraints, "constraints");
        return Oxx0IOOO.Oxx0xo(new NetworkRequestConstraintController$track$1(constraints, this, null));
    }

    public /* synthetic */ NetworkRequestConstraintController(ConnectivityManager connectivityManager, long j, int i, IIXOooo iIXOooo) {
        this(connectivityManager, (i & 2) != 0 ? WorkConstraintsTrackerKt.DefaultNetworkRequestTimeoutMs : j);
    }
}
