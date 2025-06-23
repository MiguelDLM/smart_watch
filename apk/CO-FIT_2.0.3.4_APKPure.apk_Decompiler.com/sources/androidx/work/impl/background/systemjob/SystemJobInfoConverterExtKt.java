package androidx.work.impl.background.systemjob;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.job.JobInfo;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(28)
public final class SystemJobInfoConverterExtKt {
    public static final void setRequiredNetworkRequest(@OOXIXo JobInfo.Builder builder, @oOoXoXO NetworkRequest networkRequest) {
        IIX0o.x0xO0oo(builder, "builder");
        JobInfo.Builder unused = builder.setRequiredNetwork(networkRequest);
    }
}
