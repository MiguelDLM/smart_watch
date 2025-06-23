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
import com.sma.smartv3.db.entity.WorkoutIndex;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class WorkoutIndexDao_Impl implements WorkoutIndexDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkoutIndex> __insertionAdapterOfWorkoutIndex;
    private final EntityDeletionOrUpdateAdapter<WorkoutIndex> __updateAdapterOfWorkoutIndex;

    public WorkoutIndexDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkoutIndex = new EntityInsertionAdapter<WorkoutIndex>(__db) { // from class: com.sma.smartv3.db.dao.WorkoutIndexDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkoutIndex` (`mId`,`mFrom`,`mEndTime`,`mMode`,`mSyncStatus`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final WorkoutIndex entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMFrom());
                statement.bindLong(3, entity.getMEndTime());
                statement.bindLong(4, entity.getMMode());
                statement.bindLong(5, entity.getMSyncStatus());
            }
        };
        this.__updateAdapterOfWorkoutIndex = new EntityDeletionOrUpdateAdapter<WorkoutIndex>(__db) { // from class: com.sma.smartv3.db.dao.WorkoutIndexDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `WorkoutIndex` SET `mId` = ?,`mFrom` = ?,`mEndTime` = ?,`mMode` = ?,`mSyncStatus` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final WorkoutIndex entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMFrom());
                statement.bindLong(3, entity.getMEndTime());
                statement.bindLong(4, entity.getMMode());
                statement.bindLong(5, entity.getMSyncStatus());
                statement.bindLong(6, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.WorkoutIndexDao
    public WorkoutIndex getNotSynced() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM WorkoutIndex WHERE mSyncStatus != 1 LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        WorkoutIndex workoutIndex = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mFrom");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEndTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mSyncStatus");
            if (query.moveToFirst()) {
                workoutIndex = new WorkoutIndex(query.getInt(columnIndexOrThrow), query.getInt(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5));
            }
            return workoutIndex;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutIndexDao
    public long insert(final WorkoutIndex workoutIndex) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfWorkoutIndex.insertAndReturnId(workoutIndex);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutIndexDao
    public void update(final WorkoutIndex workoutIndex) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfWorkoutIndex.handle(workoutIndex);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
