package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.Hrv;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface HrvDao {
    @OOXIXo
    @Query("SELECT * FROM Hrv WHERE mTime >= :start AND mTime < :end AND mValue >= 50 AND mValue<= 150")
    List<Hrv> getHrv(long j, long j2);

    @OOXIXo
    @Query("SELECT * FROM Hrv WHERE mTime > 0 AND mValue >= 50 AND mValue<= 150 ORDER BY mTime DESC LIMIT 1")
    List<Hrv> getLastData();

    @OOXIXo
    @Query("SELECT * FROM Hrv WHERE  mIsSync = 0  AND mTime > 0 AND mValue >= 50 AND mValue<= 150 ORDER BY mTime ASC LIMIT 150")
    List<Hrv> getListASC();

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<Hrv> list);

    @Update
    int update(@OOXIXo List<Hrv> list);
}
