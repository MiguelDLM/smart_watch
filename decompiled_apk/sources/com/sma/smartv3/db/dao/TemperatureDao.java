package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.Temperature;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface TemperatureDao {
    @OOXIXo
    @Query("SELECT * FROM Temperature WHERE mTime > 0 ORDER BY mTime DESC LIMIT 1")
    List<Temperature> getLastData();

    @OOXIXo
    @Query("SELECT * FROM Temperature WHERE  mIsSync = 0 AND mTime > 0 ORDER BY mTime ASC LIMIT 150")
    List<Temperature> getListASC();

    @OOXIXo
    @Query("SELECT * FROM Temperature WHERE mTime >= :start AND mTime < :end ORDER BY mTime DESC")
    List<Temperature> getListDesc(long j, long j2);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<Temperature> list);

    @Update
    int update(@OOXIXo List<Temperature> list);
}
