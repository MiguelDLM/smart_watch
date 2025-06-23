package com.sma.smartv3.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sma.smartv3.db.entity.Schedule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class ScheduleDao_Impl implements ScheduleDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<Schedule> __deletionAdapterOfSchedule;
    private final EntityInsertionAdapter<Schedule> __insertionAdapterOfSchedule;
    private final EntityDeletionOrUpdateAdapter<Schedule> __updateAdapterOfSchedule;

    public ScheduleDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSchedule = new EntityInsertionAdapter<Schedule>(__db) { // from class: com.sma.smartv3.db.dao.ScheduleDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR ABORT INTO `Schedule` (`mId`,`mScheduleId`,`mYear`,`mMonth`,`mDay`,`mHour`,`mMinute`,`mAdvance`,`mTitle`,`mContent`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Schedule entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMScheduleId());
                statement.bindLong(3, entity.getMYear());
                statement.bindLong(4, entity.getMMonth());
                statement.bindLong(5, entity.getMDay());
                statement.bindLong(6, entity.getMHour());
                statement.bindLong(7, entity.getMMinute());
                statement.bindLong(8, entity.getMAdvance());
                if (entity.getMTitle() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getMTitle());
                }
                if (entity.getMContent() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getMContent());
                }
            }
        };
        this.__deletionAdapterOfSchedule = new EntityDeletionOrUpdateAdapter<Schedule>(__db) { // from class: com.sma.smartv3.db.dao.ScheduleDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "DELETE FROM `Schedule` WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Schedule entity) {
                statement.bindLong(1, entity.getMId());
            }
        };
        this.__updateAdapterOfSchedule = new EntityDeletionOrUpdateAdapter<Schedule>(__db) { // from class: com.sma.smartv3.db.dao.ScheduleDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `Schedule` SET `mId` = ?,`mScheduleId` = ?,`mYear` = ?,`mMonth` = ?,`mDay` = ?,`mHour` = ?,`mMinute` = ?,`mAdvance` = ?,`mTitle` = ?,`mContent` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Schedule entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMScheduleId());
                statement.bindLong(3, entity.getMYear());
                statement.bindLong(4, entity.getMMonth());
                statement.bindLong(5, entity.getMDay());
                statement.bindLong(6, entity.getMHour());
                statement.bindLong(7, entity.getMMinute());
                statement.bindLong(8, entity.getMAdvance());
                if (entity.getMTitle() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getMTitle());
                }
                if (entity.getMContent() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getMContent());
                }
                statement.bindLong(11, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.ScheduleDao
    public int delete(final Schedule schedule) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handle = this.__deletionAdapterOfSchedule.handle(schedule);
            this.__db.setTransactionSuccessful();
            return handle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.ScheduleDao
    public Schedule get(int i) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM schedule WHERE mId=?", 1);
        acquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Schedule schedule = null;
        String string2 = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mScheduleId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mYear");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMonth");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDay");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mHour");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mMinute");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mAdvance");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mTitle");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mContent");
            if (query.moveToFirst()) {
                int i2 = query.getInt(columnIndexOrThrow);
                int i3 = query.getInt(columnIndexOrThrow2);
                int i4 = query.getInt(columnIndexOrThrow3);
                int i5 = query.getInt(columnIndexOrThrow4);
                int i6 = query.getInt(columnIndexOrThrow5);
                int i7 = query.getInt(columnIndexOrThrow6);
                int i8 = query.getInt(columnIndexOrThrow7);
                int i9 = query.getInt(columnIndexOrThrow8);
                if (query.isNull(columnIndexOrThrow9)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow9);
                }
                if (!query.isNull(columnIndexOrThrow10)) {
                    string2 = query.getString(columnIndexOrThrow10);
                }
                schedule = new Schedule(i2, i3, i4, i5, i6, i7, i8, i9, string, string2);
            }
            return schedule;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ScheduleDao
    public List<Schedule> getAll() {
        String string;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM schedule", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mScheduleId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mYear");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMonth");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDay");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mHour");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mMinute");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mAdvance");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mTitle");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mContent");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                int i2 = query.getInt(columnIndexOrThrow2);
                int i3 = query.getInt(columnIndexOrThrow3);
                int i4 = query.getInt(columnIndexOrThrow4);
                int i5 = query.getInt(columnIndexOrThrow5);
                int i6 = query.getInt(columnIndexOrThrow6);
                int i7 = query.getInt(columnIndexOrThrow7);
                int i8 = query.getInt(columnIndexOrThrow8);
                if (query.isNull(columnIndexOrThrow9)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow9);
                }
                if (query.isNull(columnIndexOrThrow10)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow10);
                }
                arrayList.add(new Schedule(i, i2, i3, i4, i5, i6, i7, i8, string, string2));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ScheduleDao
    public long insert(final Schedule schedule) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfSchedule.insertAndReturnId(schedule);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.ScheduleDao
    public int update(final Schedule... schedule) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfSchedule.handleMultiple(schedule);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
