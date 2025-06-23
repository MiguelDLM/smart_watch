package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.WorkoutIndex;

@Dao
/* loaded from: classes12.dex */
public interface WorkoutIndexDao {
    @Query("SELECT * FROM WorkoutIndex WHERE mSyncStatus != 1 LIMIT 1")
    @oOoXoXO
    WorkoutIndex getNotSynced();

    @Insert(onConflict = 5)
    long insert(@OOXIXo WorkoutIndex workoutIndex);

    @Update
    void update(@OOXIXo WorkoutIndex workoutIndex);
}
