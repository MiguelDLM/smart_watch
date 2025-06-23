package com.sma.smartv3.db.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sma.smartv3.db.entity.HanBaoVibration;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class HanBaoVibrationDao_Impl implements HanBaoVibrationDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<HanBaoVibration> __insertionAdapterOfHanBaoVibration;
    private final EntityDeletionOrUpdateAdapter<HanBaoVibration> __updateAdapterOfHanBaoVibration;

    public HanBaoVibrationDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfHanBaoVibration = new EntityInsertionAdapter<HanBaoVibration>(__db) { // from class: com.sma.smartv3.db.dao.HanBaoVibrationDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `HanBaoVibration` (`mId`,`mTime`,`mLocalTime`,`mVibration`,`mBOValue`,`mIsSnore`,`mIsSync`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final HanBaoVibration entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMVibration());
                statement.bindLong(5, entity.getMBOValue());
                statement.bindLong(6, entity.getMIsSnore());
                statement.bindLong(7, entity.getMIsSync());
            }
        };
        this.__updateAdapterOfHanBaoVibration = new EntityDeletionOrUpdateAdapter<HanBaoVibration>(__db) { // from class: com.sma.smartv3.db.dao.HanBaoVibrationDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `HanBaoVibration` SET `mId` = ?,`mTime` = ?,`mLocalTime` = ?,`mVibration` = ?,`mBOValue` = ?,`mIsSnore` = ?,`mIsSync` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final HanBaoVibration entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMVibration());
                statement.bindLong(5, entity.getMBOValue());
                statement.bindLong(6, entity.getMIsSnore());
                statement.bindLong(7, entity.getMIsSync());
                statement.bindLong(8, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.HanBaoVibrationDao
    public long[] insert(final List<HanBaoVibration> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfHanBaoVibration.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.HanBaoVibrationDao
    public int update(final List<HanBaoVibration> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfHanBaoVibration.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
