package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmScheduler;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class Schedulers {
    public static final String GCM_SCHEDULER = "androidx.work.impl.background.gcm.GcmScheduler";
    private static final String TAG = Logger.tagWithPrefix("Schedulers");

    private Schedulers() {
    }

    @NonNull
    public static Scheduler createBestAvailableBackgroundScheduler(@NonNull Context context, @NonNull WorkDatabase workDatabase, Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workDatabase, configuration);
            PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
            Logger.get().debug(TAG, "Created SystemJobScheduler and enabled SystemJobService");
            return systemJobScheduler;
        }
        Scheduler tryCreateGcmBasedScheduler = tryCreateGcmBasedScheduler(context, configuration.getClock());
        if (tryCreateGcmBasedScheduler == null) {
            SystemAlarmScheduler systemAlarmScheduler = new SystemAlarmScheduler(context);
            PackageManagerHelper.setComponentEnabled(context, SystemAlarmService.class, true);
            Logger.get().debug(TAG, "Created SystemAlarmScheduler");
            return systemAlarmScheduler;
        }
        return tryCreateGcmBasedScheduler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerRescheduling$0(List list, WorkGenerationalId workGenerationalId, Configuration configuration, WorkDatabase workDatabase) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).cancel(workGenerationalId.getWorkSpecId());
        }
        schedule(configuration, workDatabase, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerRescheduling$1(Executor executor, final List list, final Configuration configuration, final WorkDatabase workDatabase, final WorkGenerationalId workGenerationalId, boolean z) {
        executor.execute(new Runnable() { // from class: androidx.work.impl.X0o0xo
            @Override // java.lang.Runnable
            public final void run() {
                Schedulers.lambda$registerRescheduling$0(list, workGenerationalId, configuration, workDatabase);
            }
        });
    }

    private static void markScheduled(WorkSpecDao dao, Clock clock, List<WorkSpec> workSpecs) {
        if (workSpecs.size() > 0) {
            long currentTimeMillis = clock.currentTimeMillis();
            Iterator<WorkSpec> it = workSpecs.iterator();
            while (it.hasNext()) {
                dao.markWorkSpecScheduled(it.next().id, currentTimeMillis);
            }
        }
    }

    public static void registerRescheduling(@NonNull final List<Scheduler> schedulers, @NonNull Processor processor, @NonNull final Executor executor, @NonNull final WorkDatabase workDatabase, @NonNull final Configuration configuration) {
        processor.addExecutionListener(new ExecutionListener() { // from class: androidx.work.impl.oxoX
            @Override // androidx.work.impl.ExecutionListener
            public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
                Schedulers.lambda$registerRescheduling$1(executor, schedulers, configuration, workDatabase, workGenerationalId, z);
            }
        });
    }

    public static void schedule(@NonNull Configuration configuration, @NonNull WorkDatabase workDatabase, @Nullable List<Scheduler> schedulers) {
        List<WorkSpec> list;
        if (schedulers != null && schedulers.size() != 0) {
            WorkSpecDao workSpecDao = workDatabase.workSpecDao();
            workDatabase.beginTransaction();
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    list = workSpecDao.getEligibleWorkForSchedulingWithContentUris();
                    markScheduled(workSpecDao, configuration.getClock(), list);
                } else {
                    list = null;
                }
                List<WorkSpec> eligibleWorkForScheduling = workSpecDao.getEligibleWorkForScheduling(configuration.getMaxSchedulerLimit());
                markScheduled(workSpecDao, configuration.getClock(), eligibleWorkForScheduling);
                if (list != null) {
                    eligibleWorkForScheduling.addAll(list);
                }
                List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (eligibleWorkForScheduling.size() > 0) {
                    WorkSpec[] workSpecArr = (WorkSpec[]) eligibleWorkForScheduling.toArray(new WorkSpec[eligibleWorkForScheduling.size()]);
                    for (Scheduler scheduler : schedulers) {
                        if (scheduler.hasLimitedSchedulingSlots()) {
                            scheduler.schedule(workSpecArr);
                        }
                    }
                }
                if (allEligibleWorkSpecsForScheduling.size() > 0) {
                    WorkSpec[] workSpecArr2 = (WorkSpec[]) allEligibleWorkSpecsForScheduling.toArray(new WorkSpec[allEligibleWorkSpecsForScheduling.size()]);
                    for (Scheduler scheduler2 : schedulers) {
                        if (!scheduler2.hasLimitedSchedulingSlots()) {
                            scheduler2.schedule(workSpecArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    @Nullable
    private static Scheduler tryCreateGcmBasedScheduler(@NonNull Context context, Clock clock) {
        try {
            Scheduler scheduler = (Scheduler) Class.forName(GCM_SCHEDULER).getConstructor(Context.class, Clock.class).newInstance(context, clock);
            Logger.get().debug(TAG, "Created androidx.work.impl.background.gcm.GcmScheduler");
            return scheduler;
        } catch (Throwable th) {
            Logger.get().debug(TAG, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
