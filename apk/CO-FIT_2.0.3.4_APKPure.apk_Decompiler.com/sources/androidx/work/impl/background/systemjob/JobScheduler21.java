package androidx.work.impl.background.systemjob;

import OXOo.OOXIXo;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import androidx.annotation.RequiresApi;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(21)
final class JobScheduler21 {
    @OOXIXo
    public static final JobScheduler21 INSTANCE = new JobScheduler21();

    private JobScheduler21() {
    }

    @OOXIXo
    public final List<JobInfo> getAllPendingJobs(@OOXIXo JobScheduler jobScheduler) {
        IIX0o.x0xO0oo(jobScheduler, "jobScheduler");
        List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
        IIX0o.oO(allPendingJobs, "jobScheduler.allPendingJobs");
        return allPendingJobs;
    }
}
