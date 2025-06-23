package androidx.work.impl.utils;

import Oox.oOoXoXO;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import com.facebook.appevents.UserDataStore;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class StatusRunnable$forUUID$1 extends Lambda implements oOoXoXO<WorkDatabase, WorkInfo> {
    final /* synthetic */ UUID $id;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StatusRunnable$forUUID$1(UUID uuid) {
        super(1);
        this.$id = uuid;
    }

    public final WorkInfo invoke(WorkDatabase workDatabase) {
        IIX0o.x0xO0oo(workDatabase, UserDataStore.DATE_OF_BIRTH);
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        String uuid = this.$id.toString();
        IIX0o.oO(uuid, "id.toString()");
        WorkSpec.WorkInfoPojo workStatusPojoForId = workSpecDao.getWorkStatusPojoForId(uuid);
        if (workStatusPojoForId != null) {
            return workStatusPojoForId.toWorkInfo();
        }
        return null;
    }
}
