package androidx.work.impl.utils;

import Oox.oOoXoXO;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import com.facebook.appevents.UserDataStore;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class StatusRunnable$forUniqueWork$1 extends Lambda implements oOoXoXO<WorkDatabase, List<? extends WorkInfo>> {
    final /* synthetic */ String $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StatusRunnable$forUniqueWork$1(String str) {
        super(1);
        this.$name = str;
    }

    public final List<WorkInfo> invoke(WorkDatabase workDatabase) {
        IIX0o.x0xO0oo(workDatabase, UserDataStore.DATE_OF_BIRTH);
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForName(this.$name));
        IIX0o.oO(apply, "WORK_INFO_MAPPER.apply(d…kStatusPojoForName(name))");
        return apply;
    }
}
