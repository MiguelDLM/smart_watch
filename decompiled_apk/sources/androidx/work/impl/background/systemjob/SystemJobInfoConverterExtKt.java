package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(28)
/* loaded from: classes.dex */
public final class SystemJobInfoConverterExtKt {
    public static final void setRequiredNetworkRequest(@OXOo.OOXIXo JobInfo.Builder builder, @OXOo.oOoXoXO NetworkRequest networkRequest) {
        IIX0o.x0xO0oo(builder, "builder");
        builder.setRequiredNetwork(networkRequest);
    }
}
