package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.sma.smartv3.db.entity.SportData;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface SportDataDao {
    @OOXIXo
    @Query("SELECT * FROM SportData WHERE mTime >= :startTime AND mTime <= :endTime ORDER BY mTime ASC")
    List<SportData> getSportDataASC(long j, long j2);

    @Insert
    @OOXIXo
    long[] insert(@OOXIXo List<SportData> list);
}
