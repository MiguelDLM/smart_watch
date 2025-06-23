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
import com.sma.smartv3.db.entity.AIRecords;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class AIRecordsDao_Impl implements AIRecordsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<AIRecords> __insertionAdapterOfAIRecords;
    private final EntityInsertionAdapter<AIRecords> __insertionAdapterOfAIRecords_1;
    private final EntityDeletionOrUpdateAdapter<AIRecords> __updateAdapterOfAIRecords;

    public AIRecordsDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfAIRecords = new EntityInsertionAdapter<AIRecords>(__db) { // from class: com.sma.smartv3.db.dao.AIRecordsDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `AIRecords` (`mId`,`mTime`,`mLocalTime`,`mAIFuncType`,`mType`,`mContent`,`mExtraInfo`,`mStatus`,`mIsSync`,`mIsDelete`,`mAITitle`,`mTranslateLanguage`,`mTranslateToLanguage`,`mLocation`,`mAudioPath`,`mAudioDuration`,`ttsVoiceName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final AIRecords entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMAIFuncType());
                statement.bindLong(5, entity.getMType());
                if (entity.getMContent() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getMContent());
                }
                if (entity.getMExtraInfo() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getMExtraInfo());
                }
                statement.bindLong(8, entity.getMStatus());
                statement.bindLong(9, entity.getMIsSync());
                statement.bindLong(10, entity.getMIsDelete());
                if (entity.getMAITitle() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getMAITitle());
                }
                if (entity.getMTranslateLanguage() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getMTranslateLanguage());
                }
                if (entity.getMTranslateToLanguage() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getMTranslateToLanguage());
                }
                if (entity.getMLocation() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getMLocation());
                }
                if (entity.getMAudioPath() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getMAudioPath());
                }
                statement.bindLong(16, entity.getMAudioDuration());
                if (entity.getTtsVoiceName() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getTtsVoiceName());
                }
            }
        };
        this.__insertionAdapterOfAIRecords_1 = new EntityInsertionAdapter<AIRecords>(__db) { // from class: com.sma.smartv3.db.dao.AIRecordsDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR ABORT INTO `AIRecords` (`mId`,`mTime`,`mLocalTime`,`mAIFuncType`,`mType`,`mContent`,`mExtraInfo`,`mStatus`,`mIsSync`,`mIsDelete`,`mAITitle`,`mTranslateLanguage`,`mTranslateToLanguage`,`mLocation`,`mAudioPath`,`mAudioDuration`,`ttsVoiceName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final AIRecords entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMAIFuncType());
                statement.bindLong(5, entity.getMType());
                if (entity.getMContent() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getMContent());
                }
                if (entity.getMExtraInfo() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getMExtraInfo());
                }
                statement.bindLong(8, entity.getMStatus());
                statement.bindLong(9, entity.getMIsSync());
                statement.bindLong(10, entity.getMIsDelete());
                if (entity.getMAITitle() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getMAITitle());
                }
                if (entity.getMTranslateLanguage() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getMTranslateLanguage());
                }
                if (entity.getMTranslateToLanguage() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getMTranslateToLanguage());
                }
                if (entity.getMLocation() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getMLocation());
                }
                if (entity.getMAudioPath() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getMAudioPath());
                }
                statement.bindLong(16, entity.getMAudioDuration());
                if (entity.getTtsVoiceName() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getTtsVoiceName());
                }
            }
        };
        this.__updateAdapterOfAIRecords = new EntityDeletionOrUpdateAdapter<AIRecords>(__db) { // from class: com.sma.smartv3.db.dao.AIRecordsDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `AIRecords` SET `mId` = ?,`mTime` = ?,`mLocalTime` = ?,`mAIFuncType` = ?,`mType` = ?,`mContent` = ?,`mExtraInfo` = ?,`mStatus` = ?,`mIsSync` = ?,`mIsDelete` = ?,`mAITitle` = ?,`mTranslateLanguage` = ?,`mTranslateToLanguage` = ?,`mLocation` = ?,`mAudioPath` = ?,`mAudioDuration` = ?,`ttsVoiceName` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final AIRecords entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMAIFuncType());
                statement.bindLong(5, entity.getMType());
                if (entity.getMContent() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getMContent());
                }
                if (entity.getMExtraInfo() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getMExtraInfo());
                }
                statement.bindLong(8, entity.getMStatus());
                statement.bindLong(9, entity.getMIsSync());
                statement.bindLong(10, entity.getMIsDelete());
                if (entity.getMAITitle() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getMAITitle());
                }
                if (entity.getMTranslateLanguage() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getMTranslateLanguage());
                }
                if (entity.getMTranslateToLanguage() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getMTranslateToLanguage());
                }
                if (entity.getMLocation() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getMLocation());
                }
                if (entity.getMAudioPath() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getMAudioPath());
                }
                statement.bindLong(16, entity.getMAudioDuration());
                if (entity.getTtsVoiceName() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getTtsVoiceName());
                }
                statement.bindLong(18, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.AIRecordsDao
    public AIRecords getAIRecord(final long id) {
        RoomSQLiteQuery roomSQLiteQuery;
        AIRecords aIRecords;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        int i;
        String string8;
        int i2;
        String string9;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM airecords WHERE  mId = ?", 1);
        acquire.bindLong(1, id);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mAIFuncType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mType");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mContent");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mExtraInfo");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mStatus");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mAITitle");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mTranslateLanguage");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mTranslateToLanguage");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mLocation");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAudioPath");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mAudioDuration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "ttsVoiceName");
                if (query.moveToFirst()) {
                    int i3 = query.getInt(columnIndexOrThrow);
                    long j = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow3);
                    }
                    int i4 = query.getInt(columnIndexOrThrow4);
                    int i5 = query.getInt(columnIndexOrThrow5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow7);
                    }
                    int i6 = query.getInt(columnIndexOrThrow8);
                    int i7 = query.getInt(columnIndexOrThrow9);
                    int i8 = query.getInt(columnIndexOrThrow10);
                    if (query.isNull(columnIndexOrThrow11)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(columnIndexOrThrow13)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow13);
                    }
                    if (query.isNull(columnIndexOrThrow14)) {
                        i = columnIndexOrThrow15;
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow14);
                        i = columnIndexOrThrow15;
                    }
                    if (query.isNull(i)) {
                        i2 = columnIndexOrThrow16;
                        string8 = null;
                    } else {
                        string8 = query.getString(i);
                        i2 = columnIndexOrThrow16;
                    }
                    int i9 = query.getInt(i2);
                    if (query.isNull(columnIndexOrThrow17)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow17);
                    }
                    aIRecords = new AIRecords(i3, j, string, i4, i5, string2, string3, i6, i7, i8, string4, string5, string6, string7, string8, i9, string9);
                } else {
                    aIRecords = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return aIRecords;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.AIRecordsDao
    public List<AIRecords> getListASC(final int type) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM airecords WHERE mAIFuncType = ? AND mIsDelete !=1  ORDER BY mTime ASC", 1);
        acquire.bindLong(1, type);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mAIFuncType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mType");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mContent");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mExtraInfo");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mStatus");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mAITitle");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mTranslateLanguage");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mTranslateToLanguage");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mLocation");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAudioPath");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mAudioDuration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "ttsVoiceName");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i3 = query.getInt(columnIndexOrThrow);
                    long j = query.getLong(columnIndexOrThrow2);
                    String string3 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    int i4 = query.getInt(columnIndexOrThrow4);
                    int i5 = query.getInt(columnIndexOrThrow5);
                    String string4 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                    String string5 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                    int i6 = query.getInt(columnIndexOrThrow8);
                    int i7 = query.getInt(columnIndexOrThrow9);
                    int i8 = query.getInt(columnIndexOrThrow10);
                    String string6 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                    String string7 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        i = i2;
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow13);
                        i = i2;
                    }
                    String string8 = query.isNull(i) ? null : query.getString(i);
                    int i9 = columnIndexOrThrow15;
                    int i10 = columnIndexOrThrow;
                    String string9 = query.isNull(i9) ? null : query.getString(i9);
                    int i11 = columnIndexOrThrow16;
                    int i12 = query.getInt(i11);
                    int i13 = columnIndexOrThrow17;
                    if (query.isNull(i13)) {
                        columnIndexOrThrow17 = i13;
                        string2 = null;
                    } else {
                        string2 = query.getString(i13);
                        columnIndexOrThrow17 = i13;
                    }
                    arrayList.add(new AIRecords(i3, j, string3, i4, i5, string4, string5, i6, i7, i8, string6, string7, string, string8, string9, i12, string2));
                    columnIndexOrThrow = i10;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow16 = i11;
                    i2 = i;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.AIRecordsDao
    public List<AIRecords> getListDESC(final int type) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        int i;
        String string7;
        String string8;
        String string9;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM airecords WHERE mAIFuncType = ? AND mIsDelete !=1 ORDER BY mTime DESC", 1);
        acquire.bindLong(1, type);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mAIFuncType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mType");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mContent");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mExtraInfo");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mStatus");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mAITitle");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mTranslateLanguage");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mTranslateToLanguage");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mLocation");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAudioPath");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mAudioDuration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "ttsVoiceName");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i3 = query.getInt(columnIndexOrThrow);
                    long j = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow3);
                    }
                    int i4 = query.getInt(columnIndexOrThrow4);
                    int i5 = query.getInt(columnIndexOrThrow5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow7);
                    }
                    int i6 = query.getInt(columnIndexOrThrow8);
                    int i7 = query.getInt(columnIndexOrThrow9);
                    int i8 = query.getInt(columnIndexOrThrow10);
                    if (query.isNull(columnIndexOrThrow11)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(columnIndexOrThrow13)) {
                        i = i2;
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow13);
                        i = i2;
                    }
                    if (query.isNull(i)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(i);
                    }
                    int i9 = columnIndexOrThrow15;
                    int i10 = columnIndexOrThrow;
                    if (query.isNull(i9)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(i9);
                    }
                    int i11 = columnIndexOrThrow16;
                    int i12 = query.getInt(i11);
                    int i13 = columnIndexOrThrow17;
                    if (query.isNull(i13)) {
                        columnIndexOrThrow17 = i13;
                        string9 = null;
                    } else {
                        string9 = query.getString(i13);
                        columnIndexOrThrow17 = i13;
                    }
                    arrayList.add(new AIRecords(i3, j, string, i4, i5, string2, string3, i6, i7, i8, string4, string5, string6, string7, string8, i12, string9));
                    columnIndexOrThrow = i10;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow16 = i11;
                    i2 = i;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.AIRecordsDao
    public long[] insert(final List<AIRecords> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfAIRecords.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.AIRecordsDao
    public int update(final List<AIRecords> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfAIRecords.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.AIRecordsDao
    public long insert(final AIRecords mAIRecords) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfAIRecords_1.insertAndReturnId(mAIRecords);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.AIRecordsDao
    public int update(final AIRecords aiRecords) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handle = this.__updateAdapterOfAIRecords.handle(aiRecords);
            this.__db.setTransactionSuccessful();
            return handle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.AIRecordsDao
    public List<AIRecords> getListASC() {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        String string;
        int i;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM airecords WHERE  mIsSync = 0  ORDER BY mTime ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mAIFuncType");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mType");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mContent");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mExtraInfo");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mStatus");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mAITitle");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mTranslateLanguage");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mTranslateToLanguage");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mLocation");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAudioPath");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mAudioDuration");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "ttsVoiceName");
            int i2 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i3 = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                String string3 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                int i4 = query.getInt(columnIndexOrThrow4);
                int i5 = query.getInt(columnIndexOrThrow5);
                String string4 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                String string5 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                int i6 = query.getInt(columnIndexOrThrow8);
                int i7 = query.getInt(columnIndexOrThrow9);
                int i8 = query.getInt(columnIndexOrThrow10);
                String string6 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                String string7 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                if (query.isNull(columnIndexOrThrow13)) {
                    i = i2;
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow13);
                    i = i2;
                }
                String string8 = query.isNull(i) ? null : query.getString(i);
                int i9 = columnIndexOrThrow15;
                int i10 = columnIndexOrThrow;
                String string9 = query.isNull(i9) ? null : query.getString(i9);
                int i11 = columnIndexOrThrow16;
                int i12 = query.getInt(i11);
                int i13 = columnIndexOrThrow17;
                if (query.isNull(i13)) {
                    columnIndexOrThrow17 = i13;
                    string2 = null;
                } else {
                    string2 = query.getString(i13);
                    columnIndexOrThrow17 = i13;
                }
                arrayList.add(new AIRecords(i3, j, string3, i4, i5, string4, string5, i6, i7, i8, string6, string7, string, string8, string9, i12, string2));
                columnIndexOrThrow = i10;
                columnIndexOrThrow15 = i9;
                columnIndexOrThrow16 = i11;
                i2 = i;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }
}
