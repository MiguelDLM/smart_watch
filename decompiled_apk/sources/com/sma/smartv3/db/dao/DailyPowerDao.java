package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.DailyPower;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface DailyPowerDao {
    @Query("SELECT * FROM DailyPower WHERE mTime >= :start AND mTime < :end AND mValue >= 0 AND mValue<= 100 ORDER BY mTime DESC LIMIT 1")
    @oOoXoXO
    DailyPower getDailyPower(long j, long j2);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<DailyPower> list);

    @Update
    int update(@OOXIXo List<DailyPower> list);
}
