package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.AIRecords;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface AIRecordsDao {
    @OOXIXo
    @Query("SELECT * FROM airecords WHERE  mId = :id")
    AIRecords getAIRecord(long j);

    @OOXIXo
    @Query("SELECT * FROM airecords WHERE  mIsSync = 0  ORDER BY mTime ASC LIMIT 150")
    List<AIRecords> getListASC();

    @OOXIXo
    @Query("SELECT * FROM airecords WHERE mAIFuncType = :type AND mIsDelete !=1  ORDER BY mTime ASC")
    List<AIRecords> getListASC(int i);

    @OOXIXo
    @Query("SELECT * FROM airecords WHERE mAIFuncType = :type AND mIsDelete !=1 ORDER BY mTime DESC")
    List<AIRecords> getListDESC(int i);

    @Insert
    long insert(@OOXIXo AIRecords aIRecords);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<AIRecords> list);

    @Update
    int update(@OOXIXo AIRecords aIRecords);

    @Update
    int update(@OOXIXo List<AIRecords> list);
}
