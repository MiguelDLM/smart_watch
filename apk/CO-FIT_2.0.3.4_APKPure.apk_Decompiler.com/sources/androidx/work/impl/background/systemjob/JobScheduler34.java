package androidx.work.impl.background.systemjob;

import OXOo.OOXIXo;
import android.app.job.JobScheduler;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(34)
final class JobScheduler34 {
    @OOXIXo
    public static final JobScheduler34 INSTANCE = new JobScheduler34();

    private JobScheduler34() {
    }

    @OOXIXo
    public final JobScheduler forNamespace(@OOXIXo JobScheduler jobScheduler) {
        IIX0o.x0xO0oo(jobScheduler, "jobScheduler");
        JobScheduler oIX0oI2 = jobScheduler.forNamespace(JobSchedulerExtKt.WORKMANAGER_NAMESPACE);
        IIX0o.oO(oIX0oI2, "jobScheduler.forNamespace(WORKMANAGER_NAMESPACE)");
        return oIX0oI2;
    }
}
