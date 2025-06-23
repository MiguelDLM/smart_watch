package com.sma.smartv3.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sma.smartv3.db.dao.ElectrocardiogramDao;
import com.sma.smartv3.db.entity.Electrocardiogram;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class ElectrocardiogramDao_Impl implements ElectrocardiogramDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Electrocardiogram> __insertionAdapterOfElectrocardiogram;

    public ElectrocardiogramDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfElectrocardiogram = new EntityInsertionAdapter<Electrocardiogram>(__db) { // from class: com.sma.smartv3.db.dao.ElectrocardiogramDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Electrocardiogram` (`mId`,`mTime`,`mLocalTime`,`mValue`,`mIsSync`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Electrocardiogram entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMValue());
                statement.bindLong(5, entity.getMIsSync());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.ElectrocardiogramDao
    public List<Electrocardiogram> getElectrocardiograms(final long start, final long end) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Electrocardiogram WHERE mTime >= ? AND mTime < ? AND mValue >= 50 AND mValue <= 220", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mValue");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Electrocardiogram(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ElectrocardiogramDao
    public Electrocardiogram getLastElectrocardiogram() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Electrocardiogram ORDER BY mId DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Electrocardiogram electrocardiogram = null;
        String string = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mValue");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            if (query.moveToFirst()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (!query.isNull(columnIndexOrThrow3)) {
                    string = query.getString(columnIndexOrThrow3);
                }
                electrocardiogram = new Electrocardiogram(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5));
            }
            return electrocardiogram;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ElectrocardiogramDao
    public List<Electrocardiogram> getTestElectrocardiograms(final long start, final long end) {
        return ElectrocardiogramDao.DefaultImpls.getTestElectrocardiograms(this, start, end);
    }

    @Override // com.sma.smartv3.db.dao.ElectrocardiogramDao
    public long[] insert(final List<Electrocardiogram> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfElectrocardiogram.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }
}
