package androidx.lifecycle;

import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class LifecycleDispatcher {

    @OXOo.OOXIXo
    public static final LifecycleDispatcher INSTANCE = new LifecycleDispatcher();

    @OXOo.OOXIXo
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@OXOo.OOXIXo Activity activity, @OXOo.oOoXoXO Bundle bundle) {
            IIX0o.x0xO0oo(activity, "activity");
            ReportFragment.Companion.injectIfNeededIn(activity);
        }
    }

    private LifecycleDispatcher() {
    }

    @x0XOIxOo
    public static final void init(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (initialized.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        IIX0o.x0XOIxOo(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
    }
}
