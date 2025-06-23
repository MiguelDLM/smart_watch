package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.Schedule;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface ScheduleDao {
    @Delete
    int delete(@OOXIXo Schedule schedule);

    @Query("SELECT * FROM schedule WHERE mId=:id")
    @oOoXoXO
    Schedule get(int i);

    @OOXIXo
    @Query("SELECT * FROM schedule")
    List<Schedule> getAll();

    @Insert
    long insert(@OOXIXo Schedule schedule);

    @Update
    int update(@OOXIXo Schedule... scheduleArr);
}
