package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import kotlinx.coroutines.flow.X0o0xo;

@Dao
public interface RawWorkInfoDao {
    @RawQuery(observedEntities = {WorkSpec.class})
    @OOXIXo
    List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(@OOXIXo SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery(observedEntities = {WorkSpec.class})
    @OOXIXo
    X0o0xo<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(@OOXIXo SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery(observedEntities = {WorkSpec.class})
    @OOXIXo
    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(@OOXIXo SupportSQLiteQuery supportSQLiteQuery);
}
