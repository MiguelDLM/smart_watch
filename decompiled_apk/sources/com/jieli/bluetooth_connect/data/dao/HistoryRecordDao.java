package com.jieli.bluetooth_connect.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import java.util.List;

@Dao
/* loaded from: classes10.dex */
public interface HistoryRecordDao {
    @Insert(entity = HistoryRecord.class)
    void addHistoryRecord(HistoryRecord historyRecord);

    @Query("SELECT * FROM HistoryRecord WHERE address LIKE :devAddress OR mapped_address LIKE :devAddress OR update_address LIKE :devAddress ORDER BY online_time DESC LIMIT 1")
    @Transaction
    HistoryRecord getHistoryRecord(String devAddress);

    @Query("SELECT * FROM HistoryRecord ORDER BY online_time DESC")
    @Transaction
    List<HistoryRecord> getHistoryRecordList();

    @Delete(entity = HistoryRecord.class)
    void removeHistoryRecord(HistoryRecord historyRecord);

    @Delete(entity = HistoryRecord.class)
    void removeHistoryRecords(List<HistoryRecord> list);

    @Update(entity = HistoryRecord.class)
    @Transaction
    void updateHistoryRecord(HistoryRecord record);

    @Update(entity = HistoryRecord.class)
    void updateHistoryRecords(List<HistoryRecord> records);
}
