package androidx.work.impl.utils;

import Oox.oOoXoXO;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import com.facebook.appevents.UserDataStore;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class StatusRunnable$forTag$1 extends Lambda implements oOoXoXO<WorkDatabase, List<? extends WorkInfo>> {
    final /* synthetic */ String $tag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StatusRunnable$forTag$1(String str) {
        super(1);
        this.$tag = str;
    }

    public final List<WorkInfo> invoke(WorkDatabase workDatabase) {
        IIX0o.x0xO0oo(workDatabase, UserDataStore.DATE_OF_BIRTH);
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForTag(this.$tag));
        IIX0o.oO(apply, "WORK_INFO_MAPPER.apply(d…orkStatusPojoForTag(tag))");
        return apply;
    }
}
