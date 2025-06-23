package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.Location;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface LocationDao {
    @OOXIXo
    @Query("SELECT * FROM Location WHERE  mIsSync = 0 AND mTime > 0 ORDER BY mTime ASC LIMIT 150")
    List<Location> getListASC();

    @OOXIXo
    @Query("SELECT * FROM Location WHERE mTime >= :start AND mTime <= :end ORDER BY mTime ASC")
    List<Location> getLocation(long j, long j2);

    @OOXIXo
    @Query("SELECT * FROM Location WHERE mTime >= :start AND mTime <= :end ORDER BY mTime DESC")
    List<Location> getLocationDESC(long j, long j2);

    @OOXIXo
    @Query("SELECT * FROM Location WHERE mIsBaiDuSync = 0")
    List<Location> getNoBaiDuSyncList();

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<Location> list);

    @Update
    int update(@OOXIXo List<Location> list);
}
