package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.jvm.internal.IIX0o;

public final class ProcessLifecycleOwner$attach$1 extends EmptyActivityLifecycleCallbacks {
    final /* synthetic */ ProcessLifecycleOwner this$0;

    public ProcessLifecycleOwner$attach$1(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    public void onActivityCreated(@OOXIXo Activity activity, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        if (Build.VERSION.SDK_INT < 29) {
            ReportFragment.Companion.get(activity).setProcessListener(this.this$0.initializationListener);
        }
    }

    public void onActivityPaused(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        this.this$0.activityPaused$lifecycle_process_release();
    }

    @RequiresApi(29)
    public void onActivityPreCreated(@OOXIXo Activity activity, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        ProcessLifecycleOwner.Api29Impl.registerActivityLifecycleCallbacks(activity, new ProcessLifecycleOwner$attach$1$onActivityPreCreated$1(this.this$0));
    }

    public void onActivityStopped(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        this.this$0.activityStopped$lifecycle_process_release();
    }
}
