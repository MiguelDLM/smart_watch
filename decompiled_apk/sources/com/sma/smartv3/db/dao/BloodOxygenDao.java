package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.BloodOxygen;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface BloodOxygenDao {
    @OOXIXo
    @Query("SELECT * FROM BloodOxygen WHERE mTime >= :start AND mTime < :end AND mValue >= 10 AND mValue<= 150")
    List<BloodOxygen> getBloodOxygen(long j, long j2);

    @Query("SELECT * FROM BloodOxygen WHERE mTime > 0 AND mValue >= 10 AND mValue<= 150 ORDER BY mTime DESC LIMIT 1")
    @oOoXoXO
    BloodOxygen getLastBloodOxygen();

    @OOXIXo
    @Query("SELECT * FROM BloodOxygen WHERE  mIsSync = 0  AND mTime > 0 AND mValue >= 10 AND mValue<= 150 ORDER BY mTime ASC LIMIT 150")
    List<BloodOxygen> getListASC();

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<BloodOxygen> list);

    @Update
    int update(@OOXIXo List<BloodOxygen> list);
}
