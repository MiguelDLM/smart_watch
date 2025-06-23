package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.Activity;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface ActivityDao {
    @Query("SELECT * FROM activity WHERE mTime >= :start AND mTime < :end AND mStep >= 0 AND mCalorie > 0 AND mStep < 1000000 ORDER BY mTime DESC LIMIT 1")
    @oOoXoXO
    Activity getActivity(long j, long j2);

    @Query("SELECT * FROM activity WHERE mTime >= :start AND mTime < :end AND mMode = :mode AND mState = 0 ORDER BY mTime DESC LIMIT 1")
    @oOoXoXO
    Activity getBeginItem(long j, long j2, int i);

    @Query("SELECT * FROM activity WHERE mTime = :end AND mMode = :mode AND mState = 4")
    @oOoXoXO
    Activity getEndItem(long j, int i);

    @OOXIXo
    @Query("SELECT * FROM Activity WHERE  mIsSync = 0 AND mTime > 0  ORDER BY mTime ASC LIMIT 150")
    List<Activity> getListASC();

    @OOXIXo
    @Query("SELECT * FROM activity WHERE mTime >= :start AND mTime < :end AND mCalorie >= 0 AND mStep <1000000 AND mDistance > 0 ORDER BY mTime ASC")
    List<Activity> getListASC(long j, long j2);

    @OOXIXo
    @Query("SELECT * FROM activity WHERE mTime >= :start AND mTime <= :end  AND mMode >= 7 AND mIsDelete !=1 ORDER BY mTime DESC")
    List<Activity> getListDESC(long j, long j2);

    @OOXIXo
    @Query("SELECT * FROM Activity WHERE mState = :state AND mMode >= 7 AND mIsDelete !=1 ORDER BY mTime DESC LIMIT :startIndex, :endIndex")
    List<Activity> getStateActivityList(int i, int i2, int i3);

    @OOXIXo
    @Query("SELECT * FROM activity WHERE mTime >= :start AND mTime <= :end AND mMode = :mode ORDER BY mTime DESC")
    List<Activity> getWorkoutListDESC(long j, long j2, int i);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<Activity> list);

    @Update
    int update(@OOXIXo List<Activity> list);
}
