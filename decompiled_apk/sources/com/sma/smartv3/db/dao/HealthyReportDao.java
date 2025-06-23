package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.HealthyReport;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface HealthyReportDao {
    @OOXIXo
    @Query("SELECT * FROM healthyReport WHERE  mId = :id")
    HealthyReport getHealthyReport(long j);

    @OOXIXo
    @Query("SELECT * FROM healthyReport WHERE  mTime > 0  ORDER BY mTime ASC LIMIT 150")
    List<HealthyReport> getListASC();

    @Insert
    long insert(@OOXIXo HealthyReport healthyReport);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<HealthyReport> list);

    @Update
    int update(@OOXIXo List<HealthyReport> list);
}
