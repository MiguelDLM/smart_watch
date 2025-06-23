package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.constant.bn;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;

public final class LifecycleDispatcher {
    @OOXIXo
    public static final LifecycleDispatcher INSTANCE = new LifecycleDispatcher();
    @OOXIXo
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    @VisibleForTesting
    public static final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        public void onActivityCreated(@OOXIXo Activity activity, @oOoXoXO Bundle bundle) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            ReportFragment.Companion.injectIfNeededIn(activity);
        }
    }

    private LifecycleDispatcher() {
    }

    @x0XOIxOo
    public static final void init(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, bn.f.o);
        if (!initialized.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            IIX0o.x0XOIxOo(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
        }
    }
}
