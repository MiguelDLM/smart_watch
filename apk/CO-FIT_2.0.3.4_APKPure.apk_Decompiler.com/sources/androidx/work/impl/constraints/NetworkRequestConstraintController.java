package androidx.work.impl.constraints;

import OXOo.OOXIXo;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Constraints;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.WorkSpec;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;

@RequiresApi(28)
public final class NetworkRequestConstraintController implements ConstraintController {
    /* access modifiers changed from: private */
    @OOXIXo
    public final ConnectivityManager connManager;
    /* access modifiers changed from: private */
    public final long timeoutMs;

    public NetworkRequestConstraintController(@OOXIXo ConnectivityManager connectivityManager, long j) {
        IIX0o.x0xO0oo(connectivityManager, "connManager");
        this.connManager = connectivityManager;
        this.timeoutMs = j;
    }

    public boolean hasConstraint(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        if (workSpec.constraints.getRequiredNetworkRequest() != null) {
            return true;
        }
        return false;
    }

    public boolean isCurrentlyConstrained(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        if (!hasConstraint(workSpec)) {
            return false;
        }
        throw new IllegalStateException("isCurrentlyConstrained() must never be called onNetworkRequestConstraintController. isCurrentlyConstrained() is called only on older platforms where NetworkRequest isn't supported");
    }

    @OOXIXo
    public X0o0xo<ConstraintsState> track(@OOXIXo Constraints constraints) {
        IIX0o.x0xO0oo(constraints, "constraints");
        return Oxx0IOOO.Oxx0xo(new NetworkRequestConstraintController$track$1(constraints, this, (I0Io<? super NetworkRequestConstraintController$track$1>) null));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkRequestConstraintController(ConnectivityManager connectivityManager, long j, int i, IIXOooo iIXOooo) {
        this(connectivityManager, (i & 2) != 0 ? WorkConstraintsTrackerKt.DefaultNetworkRequestTimeoutMs : j);
    }
}
