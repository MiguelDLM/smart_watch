package androidx.work.impl.constraints;

import OXOo.OOXIXo;
import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Ox0O;
import kotlinx.coroutines.XI0IXoo;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xoIox;

/* loaded from: classes.dex */
public final class WorkConstraintsTrackerKt {
    private static final long DefaultNetworkRequestTimeoutMs;

    @OOXIXo
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkConstraintsTracker");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"WorkConstraintsTracker\")");
        TAG = tagWithPrefix;
        DefaultNetworkRequestTimeoutMs = 1000L;
    }

    @OOXIXo
    @RequiresApi(28)
    public static final NetworkRequestConstraintController NetworkRequestConstraintController(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        Object systemService = context.getSystemService("connectivity");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return new NetworkRequestConstraintController((ConnectivityManager) systemService, 0L, 2, null);
    }

    @OOXIXo
    public static final oXIO0o0XI listen(@OOXIXo WorkConstraintsTracker workConstraintsTracker, @OOXIXo WorkSpec spec, @OOXIXo CoroutineDispatcher dispatcher, @OOXIXo OnConstraintsStateChangedListener listener) {
        XI0IXoo I0Io2;
        IIX0o.x0xO0oo(workConstraintsTracker, "<this>");
        IIX0o.x0xO0oo(spec, "spec");
        IIX0o.x0xO0oo(dispatcher, "dispatcher");
        IIX0o.x0xO0oo(listener, "listener");
        I0Io2 = Ox0O.I0Io(null, 1, null);
        xoIox.XO(x0o.oIX0oI(dispatcher.plus(I0Io2)), null, null, new WorkConstraintsTrackerKt$listen$1(workConstraintsTracker, spec, listener, null), 3, null);
        return I0Io2;
    }
}
