package androidx.work.impl.background.systemjob;

import android.app.job.JobScheduler;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(34)
/* loaded from: classes.dex */
final class JobScheduler34 {

    @OXOo.OOXIXo
    public static final JobScheduler34 INSTANCE = new JobScheduler34();

    private JobScheduler34() {
    }

    @OXOo.OOXIXo
    public final JobScheduler forNamespace(@OXOo.OOXIXo JobScheduler jobScheduler) {
        JobScheduler forNamespace;
        IIX0o.x0xO0oo(jobScheduler, "jobScheduler");
        forNamespace = jobScheduler.forNamespace(JobSchedulerExtKt.WORKMANAGER_NAMESPACE);
        IIX0o.oO(forNamespace, "jobScheduler.forNamespace(WORKMANAGER_NAMESPACE)");
        return forNamespace;
    }
}
