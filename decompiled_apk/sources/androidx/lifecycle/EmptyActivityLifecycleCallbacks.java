package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public class EmptyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@OXOo.OOXIXo Activity activity, @OXOo.oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@OXOo.OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@OXOo.OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@OXOo.OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo Bundle outState) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@OXOo.OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@OXOo.OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
    }
}
