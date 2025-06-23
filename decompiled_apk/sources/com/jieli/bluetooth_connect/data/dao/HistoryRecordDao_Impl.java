package com.jieli.bluetooth_connect.data.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes10.dex */
public final class HistoryRecordDao_Impl implements HistoryRecordDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<HistoryRecord> __deletionAdapterOfHistoryRecord;
    private final EntityInsertionAdapter<HistoryRecord> __insertionAdapterOfHistoryRecord;
    private final EntityDeletionOrUpdateAdapter<HistoryRecord> __updateAdapterOfHistoryRecord;

    public HistoryRecordDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfHistoryRecord = new EntityInsertionAdapter<HistoryRecord>(__db) { // from class: com.jieli.bluetooth_connect.data.dao.HistoryRecordDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `HistoryRecord` (`id`,`name`,`address`,`mapped_address`,`dev_type`,`connect_type`,`sdk_flag`,`vid`,`uid`,`pid`,`left_dev_lat`,`left_dev_lon`,`left_dev_update_time`,`right_dev_lat`,`right_dev_lon`,`right_dev_update_time`,`online_time`,`update_address`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, HistoryRecord value) {
                stmt.bindLong(1, value.getId());
                if (value.getName() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getName());
                }
                if (value.getAddress() == null) {
                    stmt.bindNull(3);
                } else {
                    stmt.bindString(3, value.getAddress());
                }
                if (value.getMappedAddress() == null) {
                    stmt.bindNull(4);
                } else {
                    stmt.bindString(4, value.getMappedAddress());
                }
                stmt.bindLong(5, value.getDevType());
                stmt.bindLong(6, value.getConnectType());
                stmt.bindLong(7, value.getSdkFlag());
                stmt.bindLong(8, value.getVid());
                stmt.bindLong(9, value.getUid());
                stmt.bindLong(10, value.getPid());
                stmt.bindDouble(11, value.getLeftDevLatitude());
                stmt.bindDouble(12, value.getLeftDevLongitude());
                stmt.bindLong(13, value.getLeftDevUpdateTime());
                stmt.bindDouble(14, value.getRightDevLatitude());
                stmt.bindDouble(15, value.getRightDevLongitude());
                stmt.bindLong(16, value.getRightDevUpdateTime());
                stmt.bindLong(17, value.getOnlineTime());
                if (value.getUpdateAddress() == null) {
                    stmt.bindNull(18);
                } else {
                    stmt.bindString(18, value.getUpdateAddress());
                }
            }
        };
        this.__deletionAdapterOfHistoryRecord = new EntityDeletionOrUpdateAdapter<HistoryRecord>(__db) { // from class: com.jieli.bluetooth_connect.data.dao.HistoryRecordDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `HistoryRecord` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement stmt, HistoryRecord value) {
                stmt.bindLong(1, value.getId());
            }
        };
        this.__updateAdapterOfHistoryRecord = new EntityDeletionOrUpdateAdapter<HistoryRecord>(__db) { // from class: com.jieli.bluetooth_connect.data.dao.HistoryRecordDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `HistoryRecord` SET `id` = ?,`name` = ?,`address` = ?,`mapped_address` = ?,`dev_type` = ?,`connect_type` = ?,`sdk_flag` = ?,`vid` = ?,`uid` = ?,`pid` = ?,`left_dev_lat` = ?,`left_dev_lon` = ?,`left_dev_update_time` = ?,`right_dev_lat` = ?,`right_dev_lon` = ?,`right_dev_update_time` = ?,`online_time` = ?,`update_address` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement stmt, HistoryRecord value) {
                stmt.bindLong(1, value.getId());
                if (value.getName() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getName());
                }
                if (value.getAddress() == null) {
                    stmt.bindNull(3);
                } else {
                    stmt.bindString(3, value.getAddress());
                }
                if (value.getMappedAddress() == null) {
                    stmt.bindNull(4);
                } else {
                    stmt.bindString(4, value.getMappedAddress());
                }
                stmt.bindLong(5, value.getDevType());
                stmt.bindLong(6, value.getConnectType());
                stmt.bindLong(7, value.getSdkFlag());
                stmt.bindLong(8, value.getVid());
                stmt.bindLong(9, value.getUid());
                stmt.bindLong(10, value.getPid());
                stmt.bindDouble(11, value.getLeftDevLatitude());
                stmt.bindDouble(12, value.getLeftDevLongitude());
                stmt.bindLong(13, value.getLeftDevUpdateTime());
                stmt.bindDouble(14, value.getRightDevLatitude());
                stmt.bindDouble(15, value.getRightDevLongitude());
                stmt.bindLong(16, value.getRightDevUpdateTime());
                stmt.bindLong(17, value.getOnlineTime());
                if (value.getUpdateAddress() == null) {
                    stmt.bindNull(18);
                } else {
                    stmt.bindString(18, value.getUpdateAddress());
                }
                stmt.bindLong(19, value.getId());
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public void addHistoryRecord(final HistoryRecord historyRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfHistoryRecord.insert((EntityInsertionAdapter<HistoryRecord>) historyRecord);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public HistoryRecord getHistoryRecord(final String devAddress) {
        RoomSQLiteQuery roomSQLiteQuery;
        HistoryRecord historyRecord;
        String string;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM HistoryRecord WHERE address LIKE ? OR mapped_address LIKE ? OR update_address LIKE ? ORDER BY online_time DESC LIMIT 1", 3);
        if (devAddress == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, devAddress);
        }
        if (devAddress == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, devAddress);
        }
        if (devAddress == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, devAddress);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.__db, acquire, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "address");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mapped_address");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "dev_type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "connect_type");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "sdk_flag");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "vid");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "uid");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "pid");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "left_dev_lat");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "left_dev_lon");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "left_dev_update_time");
                roomSQLiteQuery = acquire;
                try {
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "right_dev_lat");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "right_dev_lon");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "right_dev_update_time");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "online_time");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "update_address");
                        if (query.moveToFirst()) {
                            HistoryRecord historyRecord2 = new HistoryRecord();
                            historyRecord2.setId(query.getInt(columnIndexOrThrow));
                            if (query.isNull(columnIndexOrThrow2)) {
                                string = null;
                            } else {
                                string = query.getString(columnIndexOrThrow2);
                            }
                            historyRecord2.setName(string);
                            if (query.isNull(columnIndexOrThrow3)) {
                                string2 = null;
                            } else {
                                string2 = query.getString(columnIndexOrThrow3);
                            }
                            historyRecord2.setAddress(string2);
                            if (query.isNull(columnIndexOrThrow4)) {
                                string3 = null;
                            } else {
                                string3 = query.getString(columnIndexOrThrow4);
                            }
                            historyRecord2.setMappedAddress(string3);
                            historyRecord2.setDevType(query.getInt(columnIndexOrThrow5));
                            historyRecord2.setConnectType(query.getInt(columnIndexOrThrow6));
                            historyRecord2.setSdkFlag(query.getInt(columnIndexOrThrow7));
                            historyRecord2.setVid(query.getInt(columnIndexOrThrow8));
                            historyRecord2.setUid(query.getInt(columnIndexOrThrow9));
                            historyRecord2.setPid(query.getInt(columnIndexOrThrow10));
                            historyRecord2.setLeftDevLatitude(query.getDouble(columnIndexOrThrow11));
                            historyRecord2.setLeftDevLongitude(query.getDouble(columnIndexOrThrow12));
                            historyRecord2.setLeftDevUpdateTime(query.getLong(columnIndexOrThrow13));
                            historyRecord2.setRightDevLatitude(query.getDouble(columnIndexOrThrow14));
                            historyRecord2.setRightDevLongitude(query.getDouble(columnIndexOrThrow15));
                            historyRecord2.setRightDevUpdateTime(query.getLong(columnIndexOrThrow16));
                            historyRecord2.setOnlineTime(query.getLong(columnIndexOrThrow17));
                            if (query.isNull(columnIndexOrThrow18)) {
                                string4 = null;
                            } else {
                                string4 = query.getString(columnIndexOrThrow18);
                            }
                            historyRecord2.setUpdateAddress(string4);
                            historyRecord = historyRecord2;
                        } else {
                            historyRecord = null;
                        }
                        this.__db.setTransactionSuccessful();
                        query.close();
                        roomSQLiteQuery.release();
                        return historyRecord;
                    } catch (Throwable th) {
                        th = th;
                        query.close();
                        roomSQLiteQuery.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                roomSQLiteQuery = acquire;
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.room.RoomSQLiteQuery, androidx.sqlite.db.SupportSQLiteQuery] */
    /* JADX WARN: Type inference failed for: r3v2 */
    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public List<HistoryRecord> getHistoryRecordList() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        HistoryRecordDao_Impl acquire = RoomSQLiteQuery.acquire("SELECT * FROM HistoryRecord ORDER BY online_time DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            try {
                Cursor query = DBUtil.query(this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "address");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mapped_address");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "dev_type");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "connect_type");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "sdk_flag");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "vid");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "uid");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "pid");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "left_dev_lat");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "left_dev_lon");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "left_dev_update_time");
                    roomSQLiteQuery = acquire;
                    try {
                        int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "right_dev_lat");
                        try {
                            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "right_dev_lon");
                            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "right_dev_update_time");
                            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "online_time");
                            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "update_address");
                            int i = columnIndexOrThrow14;
                            ArrayList arrayList = new ArrayList(query.getCount());
                            while (query.moveToNext()) {
                                HistoryRecord historyRecord = new HistoryRecord();
                                ArrayList arrayList2 = arrayList;
                                historyRecord.setId(query.getInt(columnIndexOrThrow));
                                if (query.isNull(columnIndexOrThrow2)) {
                                    string = null;
                                } else {
                                    string = query.getString(columnIndexOrThrow2);
                                }
                                historyRecord.setName(string);
                                if (query.isNull(columnIndexOrThrow3)) {
                                    string2 = null;
                                } else {
                                    string2 = query.getString(columnIndexOrThrow3);
                                }
                                historyRecord.setAddress(string2);
                                if (query.isNull(columnIndexOrThrow4)) {
                                    string3 = null;
                                } else {
                                    string3 = query.getString(columnIndexOrThrow4);
                                }
                                historyRecord.setMappedAddress(string3);
                                historyRecord.setDevType(query.getInt(columnIndexOrThrow5));
                                historyRecord.setConnectType(query.getInt(columnIndexOrThrow6));
                                historyRecord.setSdkFlag(query.getInt(columnIndexOrThrow7));
                                historyRecord.setVid(query.getInt(columnIndexOrThrow8));
                                historyRecord.setUid(query.getInt(columnIndexOrThrow9));
                                historyRecord.setPid(query.getInt(columnIndexOrThrow10));
                                int i2 = columnIndexOrThrow;
                                historyRecord.setLeftDevLatitude(query.getDouble(columnIndexOrThrow11));
                                historyRecord.setLeftDevLongitude(query.getDouble(columnIndexOrThrow12));
                                historyRecord.setLeftDevUpdateTime(query.getLong(columnIndexOrThrow13));
                                int i3 = columnIndexOrThrow2;
                                int i4 = i;
                                int i5 = columnIndexOrThrow13;
                                historyRecord.setRightDevLatitude(query.getDouble(i4));
                                int i6 = columnIndexOrThrow15;
                                historyRecord.setRightDevLongitude(query.getDouble(i6));
                                int i7 = columnIndexOrThrow16;
                                historyRecord.setRightDevUpdateTime(query.getLong(i7));
                                int i8 = columnIndexOrThrow17;
                                historyRecord.setOnlineTime(query.getLong(i8));
                                int i9 = columnIndexOrThrow18;
                                if (query.isNull(i9)) {
                                    string4 = null;
                                } else {
                                    string4 = query.getString(i9);
                                }
                                historyRecord.setUpdateAddress(string4);
                                arrayList = arrayList2;
                                arrayList.add(historyRecord);
                                columnIndexOrThrow18 = i9;
                                columnIndexOrThrow = i2;
                                columnIndexOrThrow17 = i8;
                                columnIndexOrThrow13 = i5;
                                i = i4;
                                columnIndexOrThrow16 = i7;
                                columnIndexOrThrow2 = i3;
                                columnIndexOrThrow15 = i6;
                            }
                            try {
                                this.__db.setTransactionSuccessful();
                                query.close();
                                roomSQLiteQuery.release();
                                this.__db.endTransaction();
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                query.close();
                                roomSQLiteQuery.release();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        query.close();
                        roomSQLiteQuery.release();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    roomSQLiteQuery = acquire;
                }
            } catch (Throwable th5) {
                th = th5;
                acquire = this;
                acquire.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            acquire.__db.endTransaction();
            throw th;
        }
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public void removeHistoryRecord(final HistoryRecord historyRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfHistoryRecord.handle(historyRecord);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public void removeHistoryRecords(final List<HistoryRecord> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfHistoryRecord.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public void updateHistoryRecord(final HistoryRecord record) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfHistoryRecord.handle(record);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public void updateHistoryRecords(final List<HistoryRecord> records) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfHistoryRecord.handleMultiple(records);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
