package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.BloodGlucose;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface BloodGlucoseDao {
    @OOXIXo
    @Query("SELECT * FROM BloodGlucose WHERE mTime > 0 ORDER BY mTime DESC LIMIT 1")
    List<BloodGlucose> getLastData();

    @OOXIXo
    @Query("SELECT * FROM BloodGlucose WHERE  mIsSync = 0 AND mTime > 0 ORDER BY mTime ASC LIMIT 150")
    List<BloodGlucose> getListASC();

    @OOXIXo
    @Query("SELECT * FROM BloodGlucose WHERE mTime >= :start AND mTime < :end ORDER BY mTime DESC")
    List<BloodGlucose> getListDesc(long j, long j2);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<BloodGlucose> list);

    @Update
    int update(@OOXIXo List<BloodGlucose> list);
}
