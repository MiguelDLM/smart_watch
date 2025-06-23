package androidx.lifecycle;

import OXOo.OOXIXo;
import android.app.Activity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.jvm.internal.IIX0o;

public final class ProcessLifecycleOwner$attach$1$onActivityPreCreated$1 extends EmptyActivityLifecycleCallbacks {
    final /* synthetic */ ProcessLifecycleOwner this$0;

    public ProcessLifecycleOwner$attach$1$onActivityPreCreated$1(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    public void onActivityPostResumed(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        this.this$0.activityResumed$lifecycle_process_release();
    }

    public void onActivityPostStarted(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        this.this$0.activityStarted$lifecycle_process_release();
    }
}
