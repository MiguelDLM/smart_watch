package androidx.work.impl.constraints;

import OXOo.OOXIXo;
import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Ox0O;
import kotlinx.coroutines.XI0IXoo;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xoIox;

public final class WorkConstraintsTrackerKt {
    /* access modifiers changed from: private */
    public static final long DefaultNetworkRequestTimeoutMs = 1000;
    /* access modifiers changed from: private */
    @OOXIXo
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkConstraintsTracker");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"WorkConstraintsTracker\")");
        TAG = tagWithPrefix;
    }

    @RequiresApi(28)
    @OOXIXo
    public static final NetworkRequestConstraintController NetworkRequestConstraintController(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, bn.f.o);
        Object systemService = context.getSystemService("connectivity");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return new NetworkRequestConstraintController((ConnectivityManager) systemService, 0, 2, (IIXOooo) null);
    }

    @OOXIXo
    public static final oXIO0o0XI listen(@OOXIXo WorkConstraintsTracker workConstraintsTracker, @OOXIXo WorkSpec workSpec, @OOXIXo CoroutineDispatcher coroutineDispatcher, @OOXIXo OnConstraintsStateChangedListener onConstraintsStateChangedListener) {
        IIX0o.x0xO0oo(workConstraintsTracker, "<this>");
        IIX0o.x0xO0oo(workSpec, "spec");
        IIX0o.x0xO0oo(coroutineDispatcher, "dispatcher");
        IIX0o.x0xO0oo(onConstraintsStateChangedListener, "listener");
        XI0IXoo I0Io2 = Ox0O.I0Io((oXIO0o0XI) null, 1, (Object) null);
        oXIO0o0XI unused = xoIox.XO(x0o.oIX0oI(coroutineDispatcher.plus(I0Io2)), (CoroutineContext) null, (CoroutineStart) null, new WorkConstraintsTrackerKt$listen$1(workConstraintsTracker, workSpec, onConstraintsStateChangedListener, (I0Io<? super WorkConstraintsTrackerKt$listen$1>) null), 3, (Object) null);
        return I0Io2;
    }
}
