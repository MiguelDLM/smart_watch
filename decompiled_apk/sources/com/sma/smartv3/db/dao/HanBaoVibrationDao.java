package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import com.sma.smartv3.db.entity.HanBaoVibration;
import java.util.List;

@Dao
/* loaded from: classes12.dex */
public interface HanBaoVibrationDao {
    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<HanBaoVibration> list);

    @Update
    int update(@OOXIXo List<HanBaoVibration> list);
}
