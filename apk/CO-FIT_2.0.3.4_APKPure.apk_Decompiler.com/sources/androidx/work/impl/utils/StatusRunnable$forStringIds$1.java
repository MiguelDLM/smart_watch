package androidx.work.impl.utils;

import Oox.oOoXoXO;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import com.facebook.appevents.UserDataStore;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class StatusRunnable$forStringIds$1 extends Lambda implements oOoXoXO<WorkDatabase, List<? extends WorkInfo>> {
    final /* synthetic */ List<String> $ids;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StatusRunnable$forStringIds$1(List<String> list) {
        super(1);
        this.$ids = list;
    }

    public final List<WorkInfo> invoke(WorkDatabase workDatabase) {
        IIX0o.x0xO0oo(workDatabase, UserDataStore.DATE_OF_BIRTH);
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForIds(this.$ids));
        IIX0o.oO(apply, "WORK_INFO_MAPPER.apply(d…orkStatusPojoForIds(ids))");
        return apply;
    }
}
