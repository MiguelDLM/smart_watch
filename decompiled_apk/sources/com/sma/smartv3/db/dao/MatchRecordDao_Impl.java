package com.sma.smartv3.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sma.smartv3.db.dao.MatchRecordDao;
import com.sma.smartv3.db.entity.MatchLog;
import com.sma.smartv3.db.entity.MatchPeriod;
import com.sma.smartv3.db.entity.MatchRecord;
import com.sma.smartv3.db.entity.MatchRecordConverter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class MatchRecordDao_Impl implements MatchRecordDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<MatchLog> __insertionAdapterOfMatchLog;
    private final EntityInsertionAdapter<MatchPeriod> __insertionAdapterOfMatchPeriod;
    private final EntityInsertionAdapter<MatchRecord> __insertionAdapterOfMatchRecord;
    private final MatchRecordConverter __matchRecordConverter = new MatchRecordConverter();
    private final SharedSQLiteStatement __preparedStmtOf_deleteMatchLogById;
    private final SharedSQLiteStatement __preparedStmtOf_deleteMatchPeriodById;
    private final SharedSQLiteStatement __preparedStmtOf_deleteMatchRecordById;
    private final EntityDeletionOrUpdateAdapter<MatchRecord> __updateAdapterOfMatchRecord;

    public MatchRecordDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfMatchRecord = new EntityInsertionAdapter<MatchRecord>(__db) { // from class: com.sma.smartv3.db.dao.MatchRecordDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `MatchRecord` (`mId`,`mStart`,`mLocalTime`,`mType`,`mPeriodListSize`,`mLogListSize`,`mIsSync`,`mIsDelete`,`mSource`,`mIsStopWatchData`,`mStopWatchList`,`mTeamInfo`,`mWeather`,`mHomeTeamScore`,`mGuestTeamScore`,`mMode`,`mMinBpm`,`mAirPressure`,`mPace`,`mMaxPace`,`mMinPace`,`mSpm`,`mMaxSpm`,`mMinSpm`,`mAltitude`,`mMaxAltitude`,`mMinAltitude`,`p_mId`,`p_mMatchRecordId`,`p_mDuration`,`p_mDistance`,`p_mStep`,`p_mCalorie`,`p_mSpeed`,`p_mAvgBpm`,`p_mMaxBpm`,`p_mMaxSpeed`,`p_mIsSync`,`p_mIsDelete`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final MatchRecord entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMStart());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMType());
                statement.bindLong(5, entity.getMPeriodListSize());
                statement.bindLong(6, entity.getMLogListSize());
                statement.bindLong(7, entity.getMIsSync());
                statement.bindLong(8, entity.getMIsDelete());
                statement.bindLong(9, entity.getMSource());
                statement.bindLong(10, entity.getMIsStopWatchData());
                String stopWatchListToString = MatchRecordDao_Impl.this.__matchRecordConverter.stopWatchListToString(entity.getMStopWatchList());
                if (stopWatchListToString == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, stopWatchListToString);
                }
                String teamInfoToString = MatchRecordDao_Impl.this.__matchRecordConverter.teamInfoToString(entity.getMTeamInfo());
                if (teamInfoToString == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, teamInfoToString);
                }
                String weatherToString = MatchRecordDao_Impl.this.__matchRecordConverter.weatherToString(entity.getMWeather());
                if (weatherToString == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, weatherToString);
                }
                statement.bindLong(14, entity.getMHomeTeamScore());
                statement.bindLong(15, entity.getMGuestTeamScore());
                statement.bindLong(16, entity.getMMode());
                statement.bindLong(17, entity.getMMinBpm());
                statement.bindLong(18, entity.getMAirPressure());
                statement.bindLong(19, entity.getMPace());
                statement.bindLong(20, entity.getMMaxPace());
                statement.bindLong(21, entity.getMMinPace());
                statement.bindLong(22, entity.getMSpm());
                statement.bindLong(23, entity.getMMaxSpm());
                statement.bindLong(24, entity.getMMinSpm());
                statement.bindLong(25, entity.getMAltitude());
                statement.bindLong(26, entity.getMMaxAltitude());
                statement.bindLong(27, entity.getMMinAltitude());
                MatchPeriod mPeriod = entity.getMPeriod();
                statement.bindLong(28, mPeriod.getMId());
                statement.bindLong(29, mPeriod.getMMatchRecordId());
                statement.bindLong(30, mPeriod.getMDuration());
                statement.bindLong(31, mPeriod.getMDistance());
                statement.bindLong(32, mPeriod.getMStep());
                statement.bindLong(33, mPeriod.getMCalorie());
                statement.bindLong(34, mPeriod.getMSpeed());
                statement.bindLong(35, mPeriod.getMAvgBpm());
                statement.bindLong(36, mPeriod.getMMaxBpm());
                statement.bindLong(37, mPeriod.getMMaxSpeed());
                statement.bindLong(38, mPeriod.getMIsSync());
                statement.bindLong(39, mPeriod.getMIsDelete());
            }
        };
        this.__insertionAdapterOfMatchPeriod = new EntityInsertionAdapter<MatchPeriod>(__db) { // from class: com.sma.smartv3.db.dao.MatchRecordDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `MatchPeriod` (`mId`,`mMatchRecordId`,`mDuration`,`mDistance`,`mStep`,`mCalorie`,`mSpeed`,`mAvgBpm`,`mMaxBpm`,`mMaxSpeed`,`mIsSync`,`mIsDelete`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final MatchPeriod entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMMatchRecordId());
                statement.bindLong(3, entity.getMDuration());
                statement.bindLong(4, entity.getMDistance());
                statement.bindLong(5, entity.getMStep());
                statement.bindLong(6, entity.getMCalorie());
                statement.bindLong(7, entity.getMSpeed());
                statement.bindLong(8, entity.getMAvgBpm());
                statement.bindLong(9, entity.getMMaxBpm());
                statement.bindLong(10, entity.getMMaxSpeed());
                statement.bindLong(11, entity.getMIsSync());
                statement.bindLong(12, entity.getMIsDelete());
            }
        };
        this.__insertionAdapterOfMatchLog = new EntityInsertionAdapter<MatchLog>(__db) { // from class: com.sma.smartv3.db.dao.MatchRecordDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `MatchLog` (`mId`,`mMatchRecordId`,`mTime`,`mPeriodTime`,`mPeriodNumber`,`mType`,`mCount`,`mCancelType`,`mTeam`,`mPlayer`,`mOtherType`,`mStopWatchTotal`,`mIsSync`,`mIsDelete`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final MatchLog entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMMatchRecordId());
                statement.bindLong(3, entity.getMTime());
                statement.bindLong(4, entity.getMPeriodTime());
                statement.bindLong(5, entity.getMPeriodNumber());
                statement.bindLong(6, entity.getMType());
                statement.bindLong(7, entity.getMCount());
                statement.bindLong(8, entity.getMCancelType());
                statement.bindLong(9, entity.getMTeam());
                statement.bindLong(10, entity.getMPlayer());
                statement.bindLong(11, entity.getMOtherType());
                statement.bindLong(12, entity.getMStopWatchTotal());
                statement.bindLong(13, entity.getMIsSync());
                statement.bindLong(14, entity.getMIsDelete());
            }
        };
        this.__updateAdapterOfMatchRecord = new EntityDeletionOrUpdateAdapter<MatchRecord>(__db) { // from class: com.sma.smartv3.db.dao.MatchRecordDao_Impl.4
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `MatchRecord` SET `mId` = ?,`mStart` = ?,`mLocalTime` = ?,`mType` = ?,`mPeriodListSize` = ?,`mLogListSize` = ?,`mIsSync` = ?,`mIsDelete` = ?,`mSource` = ?,`mIsStopWatchData` = ?,`mStopWatchList` = ?,`mTeamInfo` = ?,`mWeather` = ?,`mHomeTeamScore` = ?,`mGuestTeamScore` = ?,`mMode` = ?,`mMinBpm` = ?,`mAirPressure` = ?,`mPace` = ?,`mMaxPace` = ?,`mMinPace` = ?,`mSpm` = ?,`mMaxSpm` = ?,`mMinSpm` = ?,`mAltitude` = ?,`mMaxAltitude` = ?,`mMinAltitude` = ?,`p_mId` = ?,`p_mMatchRecordId` = ?,`p_mDuration` = ?,`p_mDistance` = ?,`p_mStep` = ?,`p_mCalorie` = ?,`p_mSpeed` = ?,`p_mAvgBpm` = ?,`p_mMaxBpm` = ?,`p_mMaxSpeed` = ?,`p_mIsSync` = ?,`p_mIsDelete` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final MatchRecord entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMStart());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMType());
                statement.bindLong(5, entity.getMPeriodListSize());
                statement.bindLong(6, entity.getMLogListSize());
                statement.bindLong(7, entity.getMIsSync());
                statement.bindLong(8, entity.getMIsDelete());
                statement.bindLong(9, entity.getMSource());
                statement.bindLong(10, entity.getMIsStopWatchData());
                String stopWatchListToString = MatchRecordDao_Impl.this.__matchRecordConverter.stopWatchListToString(entity.getMStopWatchList());
                if (stopWatchListToString == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, stopWatchListToString);
                }
                String teamInfoToString = MatchRecordDao_Impl.this.__matchRecordConverter.teamInfoToString(entity.getMTeamInfo());
                if (teamInfoToString == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, teamInfoToString);
                }
                String weatherToString = MatchRecordDao_Impl.this.__matchRecordConverter.weatherToString(entity.getMWeather());
                if (weatherToString == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, weatherToString);
                }
                statement.bindLong(14, entity.getMHomeTeamScore());
                statement.bindLong(15, entity.getMGuestTeamScore());
                statement.bindLong(16, entity.getMMode());
                statement.bindLong(17, entity.getMMinBpm());
                statement.bindLong(18, entity.getMAirPressure());
                statement.bindLong(19, entity.getMPace());
                statement.bindLong(20, entity.getMMaxPace());
                statement.bindLong(21, entity.getMMinPace());
                statement.bindLong(22, entity.getMSpm());
                statement.bindLong(23, entity.getMMaxSpm());
                statement.bindLong(24, entity.getMMinSpm());
                statement.bindLong(25, entity.getMAltitude());
                statement.bindLong(26, entity.getMMaxAltitude());
                statement.bindLong(27, entity.getMMinAltitude());
                MatchPeriod mPeriod = entity.getMPeriod();
                statement.bindLong(28, mPeriod.getMId());
                statement.bindLong(29, mPeriod.getMMatchRecordId());
                statement.bindLong(30, mPeriod.getMDuration());
                statement.bindLong(31, mPeriod.getMDistance());
                statement.bindLong(32, mPeriod.getMStep());
                statement.bindLong(33, mPeriod.getMCalorie());
                statement.bindLong(34, mPeriod.getMSpeed());
                statement.bindLong(35, mPeriod.getMAvgBpm());
                statement.bindLong(36, mPeriod.getMMaxBpm());
                statement.bindLong(37, mPeriod.getMMaxSpeed());
                statement.bindLong(38, mPeriod.getMIsSync());
                statement.bindLong(39, mPeriod.getMIsDelete());
                statement.bindLong(40, entity.getMId());
            }
        };
        this.__preparedStmtOf_deleteMatchRecordById = new SharedSQLiteStatement(__db) { // from class: com.sma.smartv3.db.dao.MatchRecordDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "DELETE FROM MatchRecord WHERE mId = ?";
            }
        };
        this.__preparedStmtOf_deleteMatchPeriodById = new SharedSQLiteStatement(__db) { // from class: com.sma.smartv3.db.dao.MatchRecordDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "DELETE FROM MatchPeriod WHERE mMatchRecordId = ?";
            }
        };
        this.__preparedStmtOf_deleteMatchLogById = new SharedSQLiteStatement(__db) { // from class: com.sma.smartv3.db.dao.MatchRecordDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "DELETE FROM MatchLog WHERE mMatchRecordId = ?";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public void _deleteMatchLogById(final int matchRecordId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOf_deleteMatchLogById.acquire();
        acquire.bindLong(1, matchRecordId);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOf_deleteMatchLogById.release(acquire);
        }
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public void _deleteMatchPeriodById(final int matchRecordId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOf_deleteMatchPeriodById.acquire();
        acquire.bindLong(1, matchRecordId);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOf_deleteMatchPeriodById.release(acquire);
        }
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public void _deleteMatchRecordById(final int id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOf_deleteMatchRecordById.acquire();
        acquire.bindLong(1, id);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOf_deleteMatchRecordById.release(acquire);
        }
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public List<MatchLog> _getMatchLogById(final int matchRecordId) {
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
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM MatchLog WHERE mMatchRecordId = ?", 1);
        acquire.bindLong(1, matchRecordId);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mMatchRecordId");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mPeriodTime");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mPeriodNumber");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mType");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mCount");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mCancelType");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mTeam");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mPlayer");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mOtherType");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mStopWatchTotal");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = columnIndexOrThrow14;
                int i2 = columnIndexOrThrow;
                arrayList.add(new MatchLog(query.getInt(columnIndexOrThrow), query.getInt(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10), query.getInt(columnIndexOrThrow11), query.getInt(columnIndexOrThrow12), query.getInt(columnIndexOrThrow13), query.getInt(i)));
                columnIndexOrThrow = i2;
                columnIndexOrThrow14 = i;
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

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public List<MatchPeriod> _getMatchPeriodsById(final int matchRecordId) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM MatchPeriod WHERE mMatchRecordId = ?", 1);
        acquire.bindLong(1, matchRecordId);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mMatchRecordId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new MatchPeriod(query.getInt(columnIndexOrThrow), query.getInt(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10), query.getInt(columnIndexOrThrow11), query.getInt(columnIndexOrThrow12)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public List<MatchRecord> _getMatchRecords(final int startIndex, final int endIndex) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        int i2;
        String string2;
        int i3;
        String string3;
        String string4;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM MatchRecord WHERE  mIsDelete != 1 ORDER BY mStart DESC LIMIT ?, ?", 2);
        acquire.bindLong(1, startIndex);
        acquire.bindLong(2, endIndex);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mPeriodListSize");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mLogListSize");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsStopWatchData");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mStopWatchList");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mTeamInfo");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mWeather");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mHomeTeamScore");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mGuestTeamScore");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "p_mId");
                int i4 = columnIndexOrThrow13;
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "p_mMatchRecordId");
                int i5 = columnIndexOrThrow12;
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "p_mDuration");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "p_mDistance");
                int i6 = columnIndexOrThrow11;
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "p_mStep");
                int i7 = columnIndexOrThrow10;
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "p_mCalorie");
                int i8 = columnIndexOrThrow9;
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "p_mSpeed");
                int i9 = columnIndexOrThrow8;
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "p_mAvgBpm");
                int i10 = columnIndexOrThrow7;
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "p_mMaxBpm");
                int i11 = columnIndexOrThrow6;
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "p_mMaxSpeed");
                int i12 = columnIndexOrThrow5;
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "p_mIsSync");
                int i13 = columnIndexOrThrow4;
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "p_mIsDelete");
                int i14 = columnIndexOrThrow3;
                int i15 = columnIndexOrThrow2;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    MatchPeriod matchPeriod = new MatchPeriod(query.getInt(columnIndexOrThrow28), query.getInt(columnIndexOrThrow29), query.getInt(columnIndexOrThrow30), query.getInt(columnIndexOrThrow31), query.getInt(columnIndexOrThrow32), query.getInt(columnIndexOrThrow33), query.getInt(columnIndexOrThrow34), query.getInt(columnIndexOrThrow35), query.getInt(columnIndexOrThrow36), query.getInt(columnIndexOrThrow37), query.getInt(columnIndexOrThrow38), query.getInt(columnIndexOrThrow39));
                    int i16 = columnIndexOrThrow31;
                    MatchRecord matchRecord = new MatchRecord();
                    int i17 = columnIndexOrThrow28;
                    matchRecord.setMId(query.getInt(columnIndexOrThrow));
                    int i18 = columnIndexOrThrow39;
                    int i19 = i15;
                    int i20 = columnIndexOrThrow38;
                    matchRecord.setMStart(query.getLong(i19));
                    int i21 = i14;
                    if (query.isNull(i21)) {
                        string = null;
                    } else {
                        string = query.getString(i21);
                    }
                    matchRecord.setMLocalTime(string);
                    int i22 = i13;
                    int i23 = columnIndexOrThrow;
                    matchRecord.setMType(query.getInt(i22));
                    int i24 = i12;
                    matchRecord.setMPeriodListSize(query.getInt(i24));
                    int i25 = i11;
                    matchRecord.setMLogListSize(query.getInt(i25));
                    int i26 = i10;
                    matchRecord.setMIsSync(query.getInt(i26));
                    int i27 = i9;
                    matchRecord.setMIsDelete(query.getInt(i27));
                    int i28 = i8;
                    matchRecord.setMSource(query.getInt(i28));
                    int i29 = i7;
                    matchRecord.setMIsStopWatchData(query.getInt(i29));
                    int i30 = i6;
                    if (query.isNull(i30)) {
                        i = i30;
                        i3 = i29;
                        i2 = columnIndexOrThrow29;
                        string2 = null;
                    } else {
                        i = i30;
                        i2 = columnIndexOrThrow29;
                        string2 = query.getString(i30);
                        i3 = i29;
                    }
                    matchRecord.setMStopWatchList(this.__matchRecordConverter.stringToStopWatchList(string2));
                    int i31 = i5;
                    if (query.isNull(i31)) {
                        i5 = i31;
                        string3 = null;
                    } else {
                        string3 = query.getString(i31);
                        i5 = i31;
                    }
                    matchRecord.setMTeamInfo(this.__matchRecordConverter.stringToTeamInfo(string3));
                    int i32 = i4;
                    if (query.isNull(i32)) {
                        i4 = i32;
                        string4 = null;
                    } else {
                        string4 = query.getString(i32);
                        i4 = i32;
                    }
                    matchRecord.setMWeather(this.__matchRecordConverter.stringToWeather(string4));
                    int i33 = columnIndexOrThrow14;
                    matchRecord.setMHomeTeamScore(query.getInt(i33));
                    columnIndexOrThrow14 = i33;
                    int i34 = columnIndexOrThrow15;
                    matchRecord.setMGuestTeamScore(query.getInt(i34));
                    int i35 = columnIndexOrThrow16;
                    matchRecord.setMMode(query.getInt(i35));
                    columnIndexOrThrow16 = i35;
                    int i36 = columnIndexOrThrow17;
                    matchRecord.setMMinBpm(query.getInt(i36));
                    columnIndexOrThrow17 = i36;
                    int i37 = columnIndexOrThrow18;
                    matchRecord.setMAirPressure(query.getInt(i37));
                    columnIndexOrThrow18 = i37;
                    int i38 = columnIndexOrThrow19;
                    matchRecord.setMPace(query.getInt(i38));
                    columnIndexOrThrow19 = i38;
                    int i39 = columnIndexOrThrow20;
                    matchRecord.setMMaxPace(query.getInt(i39));
                    columnIndexOrThrow20 = i39;
                    int i40 = columnIndexOrThrow21;
                    matchRecord.setMMinPace(query.getInt(i40));
                    columnIndexOrThrow21 = i40;
                    int i41 = columnIndexOrThrow22;
                    matchRecord.setMSpm(query.getInt(i41));
                    columnIndexOrThrow22 = i41;
                    int i42 = columnIndexOrThrow23;
                    matchRecord.setMMaxSpm(query.getInt(i42));
                    columnIndexOrThrow23 = i42;
                    int i43 = columnIndexOrThrow24;
                    matchRecord.setMMinSpm(query.getInt(i43));
                    columnIndexOrThrow24 = i43;
                    int i44 = columnIndexOrThrow25;
                    matchRecord.setMAltitude(query.getInt(i44));
                    columnIndexOrThrow25 = i44;
                    int i45 = columnIndexOrThrow26;
                    matchRecord.setMMaxAltitude(query.getInt(i45));
                    columnIndexOrThrow26 = i45;
                    int i46 = columnIndexOrThrow27;
                    matchRecord.setMMinAltitude(query.getInt(i46));
                    matchRecord.setMPeriod(matchPeriod);
                    arrayList.add(matchRecord);
                    columnIndexOrThrow27 = i46;
                    columnIndexOrThrow15 = i34;
                    columnIndexOrThrow = i23;
                    columnIndexOrThrow31 = i16;
                    columnIndexOrThrow28 = i17;
                    columnIndexOrThrow29 = i2;
                    i13 = i22;
                    columnIndexOrThrow38 = i20;
                    i15 = i19;
                    i12 = i24;
                    i11 = i25;
                    i10 = i26;
                    i9 = i27;
                    i8 = i28;
                    i7 = i3;
                    i6 = i;
                    i14 = i21;
                    columnIndexOrThrow39 = i18;
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

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public long[] _insertMatchLog(final List<MatchLog> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfMatchLog.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public long[] _insertMatchPeriod(final List<MatchPeriod> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfMatchPeriod.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public long _insertMatchRecord(final MatchRecord matchRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfMatchRecord.insertAndReturnId(matchRecord);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public void delete(final int id) {
        MatchRecordDao.DefaultImpls.delete(this, id);
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public List<MatchRecord> getList() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        int i2;
        String string2;
        int i3;
        String string3;
        String string4;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM MatchRecord WHERE mIsDelete != 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mPeriodListSize");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mLogListSize");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsStopWatchData");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mStopWatchList");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mTeamInfo");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mWeather");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mHomeTeamScore");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mGuestTeamScore");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "p_mId");
                int i4 = columnIndexOrThrow13;
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "p_mMatchRecordId");
                int i5 = columnIndexOrThrow12;
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "p_mDuration");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "p_mDistance");
                int i6 = columnIndexOrThrow11;
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "p_mStep");
                int i7 = columnIndexOrThrow10;
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "p_mCalorie");
                int i8 = columnIndexOrThrow9;
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "p_mSpeed");
                int i9 = columnIndexOrThrow8;
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "p_mAvgBpm");
                int i10 = columnIndexOrThrow7;
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "p_mMaxBpm");
                int i11 = columnIndexOrThrow6;
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "p_mMaxSpeed");
                int i12 = columnIndexOrThrow5;
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "p_mIsSync");
                int i13 = columnIndexOrThrow4;
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "p_mIsDelete");
                int i14 = columnIndexOrThrow3;
                int i15 = columnIndexOrThrow2;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    MatchPeriod matchPeriod = new MatchPeriod(query.getInt(columnIndexOrThrow28), query.getInt(columnIndexOrThrow29), query.getInt(columnIndexOrThrow30), query.getInt(columnIndexOrThrow31), query.getInt(columnIndexOrThrow32), query.getInt(columnIndexOrThrow33), query.getInt(columnIndexOrThrow34), query.getInt(columnIndexOrThrow35), query.getInt(columnIndexOrThrow36), query.getInt(columnIndexOrThrow37), query.getInt(columnIndexOrThrow38), query.getInt(columnIndexOrThrow39));
                    int i16 = columnIndexOrThrow31;
                    MatchRecord matchRecord = new MatchRecord();
                    int i17 = columnIndexOrThrow28;
                    matchRecord.setMId(query.getInt(columnIndexOrThrow));
                    int i18 = columnIndexOrThrow39;
                    int i19 = i15;
                    int i20 = columnIndexOrThrow38;
                    matchRecord.setMStart(query.getLong(i19));
                    int i21 = i14;
                    if (query.isNull(i21)) {
                        string = null;
                    } else {
                        string = query.getString(i21);
                    }
                    matchRecord.setMLocalTime(string);
                    int i22 = i13;
                    int i23 = columnIndexOrThrow;
                    matchRecord.setMType(query.getInt(i22));
                    int i24 = i12;
                    matchRecord.setMPeriodListSize(query.getInt(i24));
                    int i25 = i11;
                    matchRecord.setMLogListSize(query.getInt(i25));
                    int i26 = i10;
                    matchRecord.setMIsSync(query.getInt(i26));
                    int i27 = i9;
                    matchRecord.setMIsDelete(query.getInt(i27));
                    int i28 = i8;
                    matchRecord.setMSource(query.getInt(i28));
                    int i29 = i7;
                    matchRecord.setMIsStopWatchData(query.getInt(i29));
                    int i30 = i6;
                    if (query.isNull(i30)) {
                        i = i30;
                        i3 = i29;
                        i2 = columnIndexOrThrow29;
                        string2 = null;
                    } else {
                        i = i30;
                        i2 = columnIndexOrThrow29;
                        string2 = query.getString(i30);
                        i3 = i29;
                    }
                    matchRecord.setMStopWatchList(this.__matchRecordConverter.stringToStopWatchList(string2));
                    int i31 = i5;
                    if (query.isNull(i31)) {
                        i5 = i31;
                        string3 = null;
                    } else {
                        string3 = query.getString(i31);
                        i5 = i31;
                    }
                    matchRecord.setMTeamInfo(this.__matchRecordConverter.stringToTeamInfo(string3));
                    int i32 = i4;
                    if (query.isNull(i32)) {
                        i4 = i32;
                        string4 = null;
                    } else {
                        string4 = query.getString(i32);
                        i4 = i32;
                    }
                    matchRecord.setMWeather(this.__matchRecordConverter.stringToWeather(string4));
                    int i33 = columnIndexOrThrow14;
                    matchRecord.setMHomeTeamScore(query.getInt(i33));
                    columnIndexOrThrow14 = i33;
                    int i34 = columnIndexOrThrow15;
                    matchRecord.setMGuestTeamScore(query.getInt(i34));
                    int i35 = columnIndexOrThrow16;
                    matchRecord.setMMode(query.getInt(i35));
                    columnIndexOrThrow16 = i35;
                    int i36 = columnIndexOrThrow17;
                    matchRecord.setMMinBpm(query.getInt(i36));
                    columnIndexOrThrow17 = i36;
                    int i37 = columnIndexOrThrow18;
                    matchRecord.setMAirPressure(query.getInt(i37));
                    columnIndexOrThrow18 = i37;
                    int i38 = columnIndexOrThrow19;
                    matchRecord.setMPace(query.getInt(i38));
                    columnIndexOrThrow19 = i38;
                    int i39 = columnIndexOrThrow20;
                    matchRecord.setMMaxPace(query.getInt(i39));
                    columnIndexOrThrow20 = i39;
                    int i40 = columnIndexOrThrow21;
                    matchRecord.setMMinPace(query.getInt(i40));
                    columnIndexOrThrow21 = i40;
                    int i41 = columnIndexOrThrow22;
                    matchRecord.setMSpm(query.getInt(i41));
                    columnIndexOrThrow22 = i41;
                    int i42 = columnIndexOrThrow23;
                    matchRecord.setMMaxSpm(query.getInt(i42));
                    columnIndexOrThrow23 = i42;
                    int i43 = columnIndexOrThrow24;
                    matchRecord.setMMinSpm(query.getInt(i43));
                    columnIndexOrThrow24 = i43;
                    int i44 = columnIndexOrThrow25;
                    matchRecord.setMAltitude(query.getInt(i44));
                    columnIndexOrThrow25 = i44;
                    int i45 = columnIndexOrThrow26;
                    matchRecord.setMMaxAltitude(query.getInt(i45));
                    columnIndexOrThrow26 = i45;
                    int i46 = columnIndexOrThrow27;
                    matchRecord.setMMinAltitude(query.getInt(i46));
                    matchRecord.setMPeriod(matchPeriod);
                    arrayList.add(matchRecord);
                    columnIndexOrThrow27 = i46;
                    columnIndexOrThrow15 = i34;
                    columnIndexOrThrow = i23;
                    columnIndexOrThrow31 = i16;
                    columnIndexOrThrow28 = i17;
                    columnIndexOrThrow29 = i2;
                    i13 = i22;
                    columnIndexOrThrow38 = i20;
                    i15 = i19;
                    i12 = i24;
                    i11 = i25;
                    i10 = i26;
                    i9 = i27;
                    i8 = i28;
                    i7 = i3;
                    i6 = i;
                    i14 = i21;
                    columnIndexOrThrow39 = i18;
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

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public List<MatchRecord> getListBySource(final int source) {
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
        String string;
        int i;
        int i2;
        String string2;
        int i3;
        String string3;
        String string4;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM MatchRecord WHERE mIsDelete != 1 AND mSource = ?", 1);
        acquire.bindLong(1, source);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mType");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mPeriodListSize");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mLogListSize");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsStopWatchData");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mStopWatchList");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mTeamInfo");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mWeather");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mHomeTeamScore");
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mGuestTeamScore");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "p_mId");
            int i4 = columnIndexOrThrow13;
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "p_mMatchRecordId");
            int i5 = columnIndexOrThrow12;
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "p_mDuration");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "p_mDistance");
            int i6 = columnIndexOrThrow11;
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "p_mStep");
            int i7 = columnIndexOrThrow10;
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "p_mCalorie");
            int i8 = columnIndexOrThrow9;
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "p_mSpeed");
            int i9 = columnIndexOrThrow8;
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "p_mAvgBpm");
            int i10 = columnIndexOrThrow7;
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "p_mMaxBpm");
            int i11 = columnIndexOrThrow6;
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "p_mMaxSpeed");
            int i12 = columnIndexOrThrow5;
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "p_mIsSync");
            int i13 = columnIndexOrThrow4;
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "p_mIsDelete");
            int i14 = columnIndexOrThrow3;
            int i15 = columnIndexOrThrow2;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                MatchPeriod matchPeriod = new MatchPeriod(query.getInt(columnIndexOrThrow28), query.getInt(columnIndexOrThrow29), query.getInt(columnIndexOrThrow30), query.getInt(columnIndexOrThrow31), query.getInt(columnIndexOrThrow32), query.getInt(columnIndexOrThrow33), query.getInt(columnIndexOrThrow34), query.getInt(columnIndexOrThrow35), query.getInt(columnIndexOrThrow36), query.getInt(columnIndexOrThrow37), query.getInt(columnIndexOrThrow38), query.getInt(columnIndexOrThrow39));
                int i16 = columnIndexOrThrow31;
                MatchRecord matchRecord = new MatchRecord();
                int i17 = columnIndexOrThrow28;
                matchRecord.setMId(query.getInt(columnIndexOrThrow));
                int i18 = columnIndexOrThrow39;
                int i19 = i15;
                int i20 = columnIndexOrThrow38;
                matchRecord.setMStart(query.getLong(i19));
                int i21 = i14;
                if (query.isNull(i21)) {
                    string = null;
                } else {
                    string = query.getString(i21);
                }
                matchRecord.setMLocalTime(string);
                int i22 = i13;
                int i23 = columnIndexOrThrow;
                matchRecord.setMType(query.getInt(i22));
                int i24 = i12;
                matchRecord.setMPeriodListSize(query.getInt(i24));
                int i25 = i11;
                matchRecord.setMLogListSize(query.getInt(i25));
                int i26 = i10;
                matchRecord.setMIsSync(query.getInt(i26));
                int i27 = i9;
                matchRecord.setMIsDelete(query.getInt(i27));
                int i28 = i8;
                matchRecord.setMSource(query.getInt(i28));
                int i29 = i7;
                matchRecord.setMIsStopWatchData(query.getInt(i29));
                int i30 = i6;
                if (query.isNull(i30)) {
                    i = i30;
                    i3 = i29;
                    i2 = columnIndexOrThrow29;
                    string2 = null;
                } else {
                    i = i30;
                    i2 = columnIndexOrThrow29;
                    string2 = query.getString(i30);
                    i3 = i29;
                }
                matchRecord.setMStopWatchList(this.__matchRecordConverter.stringToStopWatchList(string2));
                int i31 = i5;
                if (query.isNull(i31)) {
                    i5 = i31;
                    string3 = null;
                } else {
                    string3 = query.getString(i31);
                    i5 = i31;
                }
                matchRecord.setMTeamInfo(this.__matchRecordConverter.stringToTeamInfo(string3));
                int i32 = i4;
                if (query.isNull(i32)) {
                    i4 = i32;
                    string4 = null;
                } else {
                    string4 = query.getString(i32);
                    i4 = i32;
                }
                matchRecord.setMWeather(this.__matchRecordConverter.stringToWeather(string4));
                int i33 = columnIndexOrThrow14;
                matchRecord.setMHomeTeamScore(query.getInt(i33));
                columnIndexOrThrow14 = i33;
                int i34 = columnIndexOrThrow15;
                matchRecord.setMGuestTeamScore(query.getInt(i34));
                int i35 = columnIndexOrThrow16;
                matchRecord.setMMode(query.getInt(i35));
                columnIndexOrThrow16 = i35;
                int i36 = columnIndexOrThrow17;
                matchRecord.setMMinBpm(query.getInt(i36));
                columnIndexOrThrow17 = i36;
                int i37 = columnIndexOrThrow18;
                matchRecord.setMAirPressure(query.getInt(i37));
                columnIndexOrThrow18 = i37;
                int i38 = columnIndexOrThrow19;
                matchRecord.setMPace(query.getInt(i38));
                columnIndexOrThrow19 = i38;
                int i39 = columnIndexOrThrow20;
                matchRecord.setMMaxPace(query.getInt(i39));
                columnIndexOrThrow20 = i39;
                int i40 = columnIndexOrThrow21;
                matchRecord.setMMinPace(query.getInt(i40));
                columnIndexOrThrow21 = i40;
                int i41 = columnIndexOrThrow22;
                matchRecord.setMSpm(query.getInt(i41));
                columnIndexOrThrow22 = i41;
                int i42 = columnIndexOrThrow23;
                matchRecord.setMMaxSpm(query.getInt(i42));
                columnIndexOrThrow23 = i42;
                int i43 = columnIndexOrThrow24;
                matchRecord.setMMinSpm(query.getInt(i43));
                columnIndexOrThrow24 = i43;
                int i44 = columnIndexOrThrow25;
                matchRecord.setMAltitude(query.getInt(i44));
                columnIndexOrThrow25 = i44;
                int i45 = columnIndexOrThrow26;
                matchRecord.setMMaxAltitude(query.getInt(i45));
                columnIndexOrThrow26 = i45;
                int i46 = columnIndexOrThrow27;
                matchRecord.setMMinAltitude(query.getInt(i46));
                matchRecord.setMPeriod(matchPeriod);
                arrayList.add(matchRecord);
                columnIndexOrThrow27 = i46;
                columnIndexOrThrow15 = i34;
                columnIndexOrThrow = i23;
                columnIndexOrThrow31 = i16;
                columnIndexOrThrow28 = i17;
                columnIndexOrThrow29 = i2;
                i13 = i22;
                columnIndexOrThrow38 = i20;
                i15 = i19;
                i12 = i24;
                i11 = i25;
                i10 = i26;
                i9 = i27;
                i8 = i28;
                i7 = i3;
                i6 = i;
                i14 = i21;
                columnIndexOrThrow39 = i18;
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

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public List<MatchRecord> getMatchRecords(final int startIndex, final int endIndex) {
        return MatchRecordDao.DefaultImpls.getMatchRecords(this, startIndex, endIndex);
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public void insert(final List<MatchRecord> list) {
        MatchRecordDao.DefaultImpls.insert(this, list);
    }

    @Override // com.sma.smartv3.db.dao.MatchRecordDao
    public int update(final List<MatchRecord> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfMatchRecord.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
