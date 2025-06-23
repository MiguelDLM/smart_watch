package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.X0o0xo;

public final class RawWorkInfoDaoKt {
    @OOXIXo
    public static final X0o0xo<List<WorkInfo>> getWorkInfoPojosFlow(@OOXIXo RawWorkInfoDao rawWorkInfoDao, @OOXIXo CoroutineDispatcher coroutineDispatcher, @OOXIXo SupportSQLiteQuery supportSQLiteQuery) {
        IIX0o.x0xO0oo(rawWorkInfoDao, "<this>");
        IIX0o.x0xO0oo(coroutineDispatcher, "dispatcher");
        IIX0o.x0xO0oo(supportSQLiteQuery, "query");
        return WorkSpecDaoKt.dedup(rawWorkInfoDao.getWorkInfoPojosFlow(supportSQLiteQuery), coroutineDispatcher);
    }
}
