package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.AlipayBindInfo;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface AlipayBindInfoDao {
    @OOXIXo
    @Query("SELECT * FROM AlipayBindInfo WHERE  mIsSync = 0  AND mTime > 0 ORDER BY mTime ASC LIMIT 150")
    List<AlipayBindInfo> getListASC();

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<AlipayBindInfo> list);

    @Update
    int update(@OOXIXo List<AlipayBindInfo> list);
}
