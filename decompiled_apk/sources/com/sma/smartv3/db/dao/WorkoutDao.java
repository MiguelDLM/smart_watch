package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.Workout;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface WorkoutDao {

    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ List getListDESC$default(WorkoutDao workoutDao, int i, int i2, int i3, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getListDESC");
            }
            if ((i4 & 4) != 0) {
                i3 = 0;
            }
            return workoutDao.getListDESC(i, i2, i3);
        }

        public static /* synthetic */ List getListModeDESC$default(WorkoutDao workoutDao, long j, long j2, int i, int i2, Object obj) {
            int i3;
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    i3 = 0;
                } else {
                    i3 = i;
                }
                return workoutDao.getListModeDESC(j, j2, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getListModeDESC");
        }

        public static /* synthetic */ List getListDESC$default(WorkoutDao workoutDao, long j, long j2, int i, int i2, Object obj) {
            if (obj == null) {
                return workoutDao.getListDESC(j, j2, (i2 & 4) != 0 ? 0 : i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getListDESC");
        }
    }

    @Query("SELECT * FROM Workout WHERE mEnd = :endTime AND mMode = :mode LIMIT 1")
    @oOoXoXO
    Workout getFitnessWorkout(long j, int i);

    @OOXIXo
    @Query("SELECT * FROM Workout WHERE  mStart > 0 ORDER BY mStart ASC LIMIT 150")
    List<Workout> getList();

    @OOXIXo
    @Query("SELECT * FROM Workout WHERE  mIsSync = 0 AND mStart > 0 ORDER BY mStart ASC LIMIT 150")
    List<Workout> getListASC();

    @OOXIXo
    @Query("SELECT * FROM Workout WHERE mMode = :mode AND mIsDelete != 1 AND mSource = :source")
    List<Workout> getListByMode(int i, int i2);

    @OOXIXo
    @Query("SELECT * FROM Workout WHERE mStart > 0 AND mMode != 0 AND mMode != :filterMode AND mIsDelete != 1 ORDER BY mStart DESC LIMIT :startIndex, :endIndex")
    List<Workout> getListDESC(int i, int i2, int i3);

    @OOXIXo
    @Query("SELECT * FROM Workout WHERE mStart >= :startTime AND mEnd <= :endTime  AND mMode != :filterMode AND mIsDelete !=1 ORDER BY mStart DESC")
    List<Workout> getListDESC(long j, long j2, int i);

    @OOXIXo
    @Query("SELECT * FROM Workout WHERE mStart > 0 AND mMode = :mode AND mIsDelete != 1 ORDER BY mStart DESC LIMIT :startIndex, :endIndex")
    List<Workout> getListDESCByMode(int i, int i2, int i3);

    @OOXIXo
    @Query("SELECT * FROM Workout WHERE mStart >= :startTime AND mEnd <= :endTime  AND mMode == :filterMode AND mIsDelete !=1 ORDER BY mStart DESC")
    List<Workout> getListModeDESC(long j, long j2, int i);

    @OOXIXo
    @Query("SELECT * FROM Workout WHERE mStart = :startTime AND mEnd = :endTime")
    Workout getWorkout(long j, long j2);

    @OOXIXo
    @Query("SELECT * FROM Workout WHERE mId = :id")
    Workout getWorkoutById(int i);

    @Insert
    @OOXIXo
    long[] insert(@OOXIXo List<Workout> list);

    @Update
    int update(@OOXIXo Workout workout);

    @Update
    int update(@OOXIXo List<Workout> list);
}
