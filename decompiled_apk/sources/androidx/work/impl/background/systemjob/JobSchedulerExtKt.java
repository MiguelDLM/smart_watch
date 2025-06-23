package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nJobSchedulerExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSchedulerExt.kt\nandroidx/work/impl/background/systemjob/JobSchedulerExtKt\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n*L\n1#1,127:1\n32#2:128\n*S KotlinDebug\n*F\n+ 1 JobSchedulerExt.kt\nandroidx/work/impl/background/systemjob/JobSchedulerExtKt\n*L\n70#1:128\n*E\n"})
/* loaded from: classes.dex */
public final class JobSchedulerExtKt {

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.OOXIXo
    public static final String WORKMANAGER_NAMESPACE = "androidx.work.systemjobscheduler";

    static {
        String tagWithPrefix = Logger.tagWithPrefix("SystemJobScheduler");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"SystemJobScheduler\")");
        TAG = tagWithPrefix;
    }

    @OXOo.OOXIXo
    @RequiresApi(23)
    public static final String createErrorMessage(@OXOo.OOXIXo Context context, @OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo Configuration configuration) {
        int i;
        int i2;
        String str;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        IIX0o.x0xO0oo(configuration, "configuration");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            i = 150;
        } else {
            i = 100;
        }
        int size = workDatabase.workSpecDao().getScheduledWork().size();
        String str2 = "<faulty JobScheduler failed to getPendingJobs>";
        if (i3 >= 34) {
            JobScheduler wmJobScheduler = getWmJobScheduler(context);
            List<JobInfo> safePendingJobs = getSafePendingJobs(wmJobScheduler);
            if (safePendingJobs != null) {
                List<JobInfo> pendingJobs = SystemJobScheduler.getPendingJobs(context, wmJobScheduler);
                int i4 = 0;
                if (pendingJobs != null) {
                    i2 = safePendingJobs.size() - pendingJobs.size();
                } else {
                    i2 = 0;
                }
                String str3 = null;
                if (i2 == 0) {
                    str = null;
                } else {
                    str = i2 + " of which are not owned by WorkManager";
                }
                Object systemService = context.getSystemService("jobscheduler");
                IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
                List<JobInfo> pendingJobs2 = SystemJobScheduler.getPendingJobs(context, (JobScheduler) systemService);
                if (pendingJobs2 != null) {
                    i4 = pendingJobs2.size();
                }
                if (i4 != 0) {
                    str3 = i4 + " from WorkManager in the default namespace";
                }
                str2 = CollectionsKt___CollectionsKt.OoIXo(CollectionsKt__CollectionsKt.xII(safePendingJobs.size() + " jobs in \"androidx.work.systemjobscheduler\" namespace", str, str3), ",\n", null, null, 0, null, null, 62, null);
            }
        } else {
            List<JobInfo> pendingJobs3 = SystemJobScheduler.getPendingJobs(context, getWmJobScheduler(context));
            if (pendingJobs3 != null) {
                str2 = pendingJobs3.size() + " jobs from WorkManager";
            }
        }
        return "JobScheduler " + i + " job limit exceeded.\nIn JobScheduler there are " + str2 + ".\nThere are " + size + " jobs tracked by WorkManager's database;\nthe Configuration limit is " + configuration.getMaxSchedulerLimit() + '.';
    }

    @RequiresApi(21)
    @OXOo.oOoXoXO
    public static final List<JobInfo> getSafePendingJobs(@OXOo.OOXIXo JobScheduler jobScheduler) {
        IIX0o.x0xO0oo(jobScheduler, "<this>");
        try {
            return JobScheduler21.INSTANCE.getAllPendingJobs(jobScheduler);
        } catch (Throwable th) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
            return null;
        }
    }

    @OXOo.OOXIXo
    @RequiresApi(21)
    public static final JobScheduler getWmJobScheduler(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<this>");
        Object systemService = context.getSystemService("jobscheduler");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
        JobScheduler jobScheduler = (JobScheduler) systemService;
        if (Build.VERSION.SDK_INT >= 34) {
            return JobScheduler34.INSTANCE.forNamespace(jobScheduler);
        }
        return jobScheduler;
    }
}
