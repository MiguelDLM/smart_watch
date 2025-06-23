package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes.dex */
public final class RawWorkInfoDaoKt {
    @OOXIXo
    public static final kotlinx.coroutines.flow.X0o0xo<List<WorkInfo>> getWorkInfoPojosFlow(@OOXIXo RawWorkInfoDao rawWorkInfoDao, @OOXIXo CoroutineDispatcher dispatcher, @OOXIXo SupportSQLiteQuery query) {
        IIX0o.x0xO0oo(rawWorkInfoDao, "<this>");
        IIX0o.x0xO0oo(dispatcher, "dispatcher");
        IIX0o.x0xO0oo(query, "query");
        return WorkSpecDaoKt.dedup(rawWorkInfoDao.getWorkInfoPojosFlow(query), dispatcher);
    }
}
