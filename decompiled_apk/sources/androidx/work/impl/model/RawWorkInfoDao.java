package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

@Dao
/* loaded from: classes.dex */
public interface RawWorkInfoDao {
    @OOXIXo
    @RawQuery(observedEntities = {WorkSpec.class})
    List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(@OOXIXo SupportSQLiteQuery supportSQLiteQuery);

    @OOXIXo
    @RawQuery(observedEntities = {WorkSpec.class})
    kotlinx.coroutines.flow.X0o0xo<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(@OOXIXo SupportSQLiteQuery supportSQLiteQuery);

    @OOXIXo
    @RawQuery(observedEntities = {WorkSpec.class})
    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(@OOXIXo SupportSQLiteQuery supportSQLiteQuery);
}
