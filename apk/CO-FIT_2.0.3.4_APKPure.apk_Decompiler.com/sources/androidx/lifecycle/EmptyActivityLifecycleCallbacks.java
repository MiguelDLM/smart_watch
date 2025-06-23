package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.jvm.internal.IIX0o;

public class EmptyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(@OOXIXo Activity activity, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
    }

    public void onActivityDestroyed(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
    }

    public void onActivityPaused(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
    }

    public void onActivityResumed(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
    }

    public void onActivitySaveInstanceState(@OOXIXo Activity activity, @OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        IIX0o.x0xO0oo(bundle, "outState");
    }

    public void onActivityStarted(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
    }

    public void onActivityStopped(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
    }
}
