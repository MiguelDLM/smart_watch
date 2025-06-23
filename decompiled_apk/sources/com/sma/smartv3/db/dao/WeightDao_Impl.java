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
import com.sma.smartv3.db.dao.WeightDao;
import com.sma.smartv3.db.entity.ListDoubleConverter;
import com.sma.smartv3.db.entity.Weight;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class WeightDao_Impl implements WeightDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Weight> __insertionAdapterOfWeight;
    private final ListDoubleConverter __listDoubleConverter = new ListDoubleConverter();
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final EntityDeletionOrUpdateAdapter<Weight> __updateAdapterOfWeight;

    public WeightDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWeight = new EntityInsertionAdapter<Weight>(__db) { // from class: com.sma.smartv3.db.dao.WeightDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Weight` (`mId`,`mTime`,`mLocalTime`,`mWeight`,`mIsSync`,`mIsMeasure`,`mBmi`,`mRatioOfFat`,`mWeightOfMuscle`,`mWeightOfFat`,`mRatioOfProtein`,`mRatioOfWater`,`mStateOfNutrition`,`mIdealWeight`,`mAgeOfBody`,`mAgeOfBodyRange`,`mBmiRange`,`mBmiWHORange`,`mBmr`,`mBmrRange`,`mBodyShape`,`mDesirableWeight`,`mFatFreeBodyWeight`,`mFatToControl`,`mLevelOfVisceralFat`,`mLevelOfVisceralFatRange`,`mMuscleToControl`,`mRatioOfFatRange`,`mRatioOfMuscle`,`mRatioOfMuscleRange`,`mRatioOfProteinRange`,`mRatioOfSkeletalMuscle`,`mRatioOfSkeletalMuscleRange`,`mRatioOfSubcutaneousFat`,`mRatioOfSubcutaneousFatRange`,`mRatioOfWaterRange`,`mScore`,`mWeightOfBone`,`mWeightOfBoneRange`,`mWeightOfFatRange`,`mWeightOfMuscleRange`,`mWeightOfProtein`,`mWeightOfProteinRange`,`mWeightOfSkeletalMuscle`,`mWeightOfSkeletalMuscleRange`,`mWeightOfWater`,`mWeightOfWaterRange`,`mWeightRange`,`mWeightToControl`,`mWeightWHORange`,`mIsDelete`,`mRatioOfProteinLevel`,`mRatioOfWaterLevel`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Weight entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindDouble(4, entity.getMWeight());
                statement.bindLong(5, entity.getMIsSync());
                statement.bindLong(6, entity.getMIsMeasure());
                statement.bindDouble(7, entity.getMBmi());
                statement.bindDouble(8, entity.getMRatioOfFat());
                statement.bindDouble(9, entity.getMWeightOfMuscle());
                statement.bindDouble(10, entity.getMWeightOfFat());
                statement.bindDouble(11, entity.getMRatioOfProtein());
                statement.bindDouble(12, entity.getMRatioOfWater());
                statement.bindDouble(13, entity.getMStateOfNutrition());
                statement.bindDouble(14, entity.getMIdealWeight());
                statement.bindDouble(15, entity.getMAgeOfBody());
                String objectToString = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMAgeOfBodyRange());
                if (objectToString == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, objectToString);
                }
                String objectToString2 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMBmiRange());
                if (objectToString2 == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, objectToString2);
                }
                String objectToString3 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMBmiWHORange());
                if (objectToString3 == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, objectToString3);
                }
                statement.bindDouble(19, entity.getMBmr());
                String objectToString4 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMBmrRange());
                if (objectToString4 == null) {
                    statement.bindNull(20);
                } else {
                    statement.bindString(20, objectToString4);
                }
                statement.bindDouble(21, entity.getMBodyShape());
                statement.bindDouble(22, entity.getMDesirableWeight());
                statement.bindDouble(23, entity.getMFatFreeBodyWeight());
                statement.bindDouble(24, entity.getMFatToControl());
                statement.bindDouble(25, entity.getMLevelOfVisceralFat());
                String objectToString5 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMLevelOfVisceralFatRange());
                if (objectToString5 == null) {
                    statement.bindNull(26);
                } else {
                    statement.bindString(26, objectToString5);
                }
                statement.bindDouble(27, entity.getMMuscleToControl());
                String objectToString6 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfFatRange());
                if (objectToString6 == null) {
                    statement.bindNull(28);
                } else {
                    statement.bindString(28, objectToString6);
                }
                statement.bindDouble(29, entity.getMRatioOfMuscle());
                String objectToString7 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfMuscleRange());
                if (objectToString7 == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, objectToString7);
                }
                String objectToString8 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfProteinRange());
                if (objectToString8 == null) {
                    statement.bindNull(31);
                } else {
                    statement.bindString(31, objectToString8);
                }
                statement.bindDouble(32, entity.getMRatioOfSkeletalMuscle());
                String objectToString9 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfSkeletalMuscleRange());
                if (objectToString9 == null) {
                    statement.bindNull(33);
                } else {
                    statement.bindString(33, objectToString9);
                }
                statement.bindDouble(34, entity.getMRatioOfSubcutaneousFat());
                String objectToString10 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfSubcutaneousFatRange());
                if (objectToString10 == null) {
                    statement.bindNull(35);
                } else {
                    statement.bindString(35, objectToString10);
                }
                String objectToString11 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfWaterRange());
                if (objectToString11 == null) {
                    statement.bindNull(36);
                } else {
                    statement.bindString(36, objectToString11);
                }
                statement.bindDouble(37, entity.getMScore());
                statement.bindDouble(38, entity.getMWeightOfBone());
                String objectToString12 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfBoneRange());
                if (objectToString12 == null) {
                    statement.bindNull(39);
                } else {
                    statement.bindString(39, objectToString12);
                }
                String objectToString13 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfFatRange());
                if (objectToString13 == null) {
                    statement.bindNull(40);
                } else {
                    statement.bindString(40, objectToString13);
                }
                String objectToString14 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfMuscleRange());
                if (objectToString14 == null) {
                    statement.bindNull(41);
                } else {
                    statement.bindString(41, objectToString14);
                }
                statement.bindDouble(42, entity.getMWeightOfProtein());
                String objectToString15 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfProteinRange());
                if (objectToString15 == null) {
                    statement.bindNull(43);
                } else {
                    statement.bindString(43, objectToString15);
                }
                statement.bindDouble(44, entity.getMWeightOfSkeletalMuscle());
                String objectToString16 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfSkeletalMuscleRange());
                if (objectToString16 == null) {
                    statement.bindNull(45);
                } else {
                    statement.bindString(45, objectToString16);
                }
                statement.bindDouble(46, entity.getMWeightOfWater());
                String objectToString17 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfWaterRange());
                if (objectToString17 == null) {
                    statement.bindNull(47);
                } else {
                    statement.bindString(47, objectToString17);
                }
                String objectToString18 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightRange());
                if (objectToString18 == null) {
                    statement.bindNull(48);
                } else {
                    statement.bindString(48, objectToString18);
                }
                statement.bindDouble(49, entity.getMWeightToControl());
                String objectToString19 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightWHORange());
                if (objectToString19 == null) {
                    statement.bindNull(50);
                } else {
                    statement.bindString(50, objectToString19);
                }
                statement.bindLong(51, entity.getMIsDelete());
                statement.bindLong(52, entity.getMRatioOfProteinLevel());
                statement.bindLong(53, entity.getMRatioOfWaterLevel());
            }
        };
        this.__updateAdapterOfWeight = new EntityDeletionOrUpdateAdapter<Weight>(__db) { // from class: com.sma.smartv3.db.dao.WeightDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `Weight` SET `mId` = ?,`mTime` = ?,`mLocalTime` = ?,`mWeight` = ?,`mIsSync` = ?,`mIsMeasure` = ?,`mBmi` = ?,`mRatioOfFat` = ?,`mWeightOfMuscle` = ?,`mWeightOfFat` = ?,`mRatioOfProtein` = ?,`mRatioOfWater` = ?,`mStateOfNutrition` = ?,`mIdealWeight` = ?,`mAgeOfBody` = ?,`mAgeOfBodyRange` = ?,`mBmiRange` = ?,`mBmiWHORange` = ?,`mBmr` = ?,`mBmrRange` = ?,`mBodyShape` = ?,`mDesirableWeight` = ?,`mFatFreeBodyWeight` = ?,`mFatToControl` = ?,`mLevelOfVisceralFat` = ?,`mLevelOfVisceralFatRange` = ?,`mMuscleToControl` = ?,`mRatioOfFatRange` = ?,`mRatioOfMuscle` = ?,`mRatioOfMuscleRange` = ?,`mRatioOfProteinRange` = ?,`mRatioOfSkeletalMuscle` = ?,`mRatioOfSkeletalMuscleRange` = ?,`mRatioOfSubcutaneousFat` = ?,`mRatioOfSubcutaneousFatRange` = ?,`mRatioOfWaterRange` = ?,`mScore` = ?,`mWeightOfBone` = ?,`mWeightOfBoneRange` = ?,`mWeightOfFatRange` = ?,`mWeightOfMuscleRange` = ?,`mWeightOfProtein` = ?,`mWeightOfProteinRange` = ?,`mWeightOfSkeletalMuscle` = ?,`mWeightOfSkeletalMuscleRange` = ?,`mWeightOfWater` = ?,`mWeightOfWaterRange` = ?,`mWeightRange` = ?,`mWeightToControl` = ?,`mWeightWHORange` = ?,`mIsDelete` = ?,`mRatioOfProteinLevel` = ?,`mRatioOfWaterLevel` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Weight entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindDouble(4, entity.getMWeight());
                statement.bindLong(5, entity.getMIsSync());
                statement.bindLong(6, entity.getMIsMeasure());
                statement.bindDouble(7, entity.getMBmi());
                statement.bindDouble(8, entity.getMRatioOfFat());
                statement.bindDouble(9, entity.getMWeightOfMuscle());
                statement.bindDouble(10, entity.getMWeightOfFat());
                statement.bindDouble(11, entity.getMRatioOfProtein());
                statement.bindDouble(12, entity.getMRatioOfWater());
                statement.bindDouble(13, entity.getMStateOfNutrition());
                statement.bindDouble(14, entity.getMIdealWeight());
                statement.bindDouble(15, entity.getMAgeOfBody());
                String objectToString = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMAgeOfBodyRange());
                if (objectToString == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, objectToString);
                }
                String objectToString2 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMBmiRange());
                if (objectToString2 == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, objectToString2);
                }
                String objectToString3 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMBmiWHORange());
                if (objectToString3 == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, objectToString3);
                }
                statement.bindDouble(19, entity.getMBmr());
                String objectToString4 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMBmrRange());
                if (objectToString4 == null) {
                    statement.bindNull(20);
                } else {
                    statement.bindString(20, objectToString4);
                }
                statement.bindDouble(21, entity.getMBodyShape());
                statement.bindDouble(22, entity.getMDesirableWeight());
                statement.bindDouble(23, entity.getMFatFreeBodyWeight());
                statement.bindDouble(24, entity.getMFatToControl());
                statement.bindDouble(25, entity.getMLevelOfVisceralFat());
                String objectToString5 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMLevelOfVisceralFatRange());
                if (objectToString5 == null) {
                    statement.bindNull(26);
                } else {
                    statement.bindString(26, objectToString5);
                }
                statement.bindDouble(27, entity.getMMuscleToControl());
                String objectToString6 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfFatRange());
                if (objectToString6 == null) {
                    statement.bindNull(28);
                } else {
                    statement.bindString(28, objectToString6);
                }
                statement.bindDouble(29, entity.getMRatioOfMuscle());
                String objectToString7 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfMuscleRange());
                if (objectToString7 == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, objectToString7);
                }
                String objectToString8 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfProteinRange());
                if (objectToString8 == null) {
                    statement.bindNull(31);
                } else {
                    statement.bindString(31, objectToString8);
                }
                statement.bindDouble(32, entity.getMRatioOfSkeletalMuscle());
                String objectToString9 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfSkeletalMuscleRange());
                if (objectToString9 == null) {
                    statement.bindNull(33);
                } else {
                    statement.bindString(33, objectToString9);
                }
                statement.bindDouble(34, entity.getMRatioOfSubcutaneousFat());
                String objectToString10 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfSubcutaneousFatRange());
                if (objectToString10 == null) {
                    statement.bindNull(35);
                } else {
                    statement.bindString(35, objectToString10);
                }
                String objectToString11 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMRatioOfWaterRange());
                if (objectToString11 == null) {
                    statement.bindNull(36);
                } else {
                    statement.bindString(36, objectToString11);
                }
                statement.bindDouble(37, entity.getMScore());
                statement.bindDouble(38, entity.getMWeightOfBone());
                String objectToString12 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfBoneRange());
                if (objectToString12 == null) {
                    statement.bindNull(39);
                } else {
                    statement.bindString(39, objectToString12);
                }
                String objectToString13 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfFatRange());
                if (objectToString13 == null) {
                    statement.bindNull(40);
                } else {
                    statement.bindString(40, objectToString13);
                }
                String objectToString14 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfMuscleRange());
                if (objectToString14 == null) {
                    statement.bindNull(41);
                } else {
                    statement.bindString(41, objectToString14);
                }
                statement.bindDouble(42, entity.getMWeightOfProtein());
                String objectToString15 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfProteinRange());
                if (objectToString15 == null) {
                    statement.bindNull(43);
                } else {
                    statement.bindString(43, objectToString15);
                }
                statement.bindDouble(44, entity.getMWeightOfSkeletalMuscle());
                String objectToString16 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfSkeletalMuscleRange());
                if (objectToString16 == null) {
                    statement.bindNull(45);
                } else {
                    statement.bindString(45, objectToString16);
                }
                statement.bindDouble(46, entity.getMWeightOfWater());
                String objectToString17 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightOfWaterRange());
                if (objectToString17 == null) {
                    statement.bindNull(47);
                } else {
                    statement.bindString(47, objectToString17);
                }
                String objectToString18 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightRange());
                if (objectToString18 == null) {
                    statement.bindNull(48);
                } else {
                    statement.bindString(48, objectToString18);
                }
                statement.bindDouble(49, entity.getMWeightToControl());
                String objectToString19 = WeightDao_Impl.this.__listDoubleConverter.objectToString(entity.getMWeightWHORange());
                if (objectToString19 == null) {
                    statement.bindNull(50);
                } else {
                    statement.bindString(50, objectToString19);
                }
                statement.bindLong(51, entity.getMIsDelete());
                statement.bindLong(52, entity.getMRatioOfProteinLevel());
                statement.bindLong(53, entity.getMRatioOfWaterLevel());
                statement.bindLong(54, entity.getMId());
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: com.sma.smartv3.db.dao.WeightDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "DELETE FROM Weight WHERE mTime = ?";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.WeightDao
    public void delete(final long mTime) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        acquire.bindLong(1, mTime);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    @Override // com.sma.smartv3.db.dao.WeightDao
    public List<Weight> getListASC() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        int i2;
        String string2;
        int i3;
        String string3;
        String string4;
        int i4;
        String string5;
        int i5;
        String string6;
        int i6;
        String string7;
        int i7;
        int i8;
        String string8;
        int i9;
        String string9;
        int i10;
        String string10;
        int i11;
        int i12;
        String string11;
        int i13;
        String string12;
        String string13;
        String string14;
        String string15;
        int i14;
        String string16;
        int i15;
        int i16;
        String string17;
        int i17;
        int i18;
        String string18;
        int i19;
        String string19;
        int i20;
        String string20;
        int i21;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Weight WHERE  mIsSync = 0 AND mTime > 0 ORDER BY mTime ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mWeight");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mIsMeasure");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mBmi");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfFat");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfMuscle");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfFat");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProtein");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWater");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mStateOfNutrition");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mIdealWeight");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAgeOfBody");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mAgeOfBodyRange");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mBmiRange");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mBmiWHORange");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mBmr");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mBmrRange");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mBodyShape");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mDesirableWeight");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mFatFreeBodyWeight");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mFatToControl");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mLevelOfVisceralFat");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mLevelOfVisceralFatRange");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mMuscleToControl");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfFatRange");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfMuscle");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfMuscleRange");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProteinRange");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSkeletalMuscle");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSkeletalMuscleRange");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSubcutaneousFat");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSubcutaneousFatRange");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWaterRange");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mScore");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfBone");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfBoneRange");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfFatRange");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfMuscleRange");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfProtein");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfProteinRange");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfSkeletalMuscle");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfSkeletalMuscleRange");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfWater");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfWaterRange");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mWeightRange");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mWeightToControl");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mWeightWHORange");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProteinLevel");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWaterLevel");
                    int i22 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i23 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        if (query.isNull(columnIndexOrThrow3)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow3);
                        }
                        float f = query.getFloat(columnIndexOrThrow4);
                        int i24 = query.getInt(columnIndexOrThrow5);
                        int i25 = query.getInt(columnIndexOrThrow6);
                        double d = query.getDouble(columnIndexOrThrow7);
                        double d2 = query.getDouble(columnIndexOrThrow8);
                        double d3 = query.getDouble(columnIndexOrThrow9);
                        double d4 = query.getDouble(columnIndexOrThrow10);
                        double d5 = query.getDouble(columnIndexOrThrow11);
                        double d6 = query.getDouble(columnIndexOrThrow12);
                        double d7 = query.getDouble(columnIndexOrThrow13);
                        int i26 = i22;
                        double d8 = query.getDouble(i26);
                        int i27 = columnIndexOrThrow;
                        int i28 = columnIndexOrThrow15;
                        double d9 = query.getDouble(i28);
                        columnIndexOrThrow15 = i28;
                        int i29 = columnIndexOrThrow16;
                        if (query.isNull(i29)) {
                            i = i29;
                            i3 = i26;
                            i2 = columnIndexOrThrow13;
                            string2 = null;
                        } else {
                            i = i29;
                            i2 = columnIndexOrThrow13;
                            string2 = query.getString(i29);
                            i3 = i26;
                        }
                        try {
                            List<Double> stringToObject = this.__listDoubleConverter.stringToObject(string2);
                            int i30 = columnIndexOrThrow17;
                            if (query.isNull(i30)) {
                                columnIndexOrThrow17 = i30;
                                string3 = null;
                            } else {
                                string3 = query.getString(i30);
                                columnIndexOrThrow17 = i30;
                            }
                            List<Double> stringToObject2 = this.__listDoubleConverter.stringToObject(string3);
                            int i31 = columnIndexOrThrow18;
                            if (query.isNull(i31)) {
                                columnIndexOrThrow18 = i31;
                                string4 = null;
                            } else {
                                string4 = query.getString(i31);
                                columnIndexOrThrow18 = i31;
                            }
                            List<Double> stringToObject3 = this.__listDoubleConverter.stringToObject(string4);
                            int i32 = columnIndexOrThrow19;
                            double d10 = query.getDouble(i32);
                            int i33 = columnIndexOrThrow20;
                            if (query.isNull(i33)) {
                                i4 = i32;
                                i5 = i33;
                                string5 = null;
                            } else {
                                i4 = i32;
                                string5 = query.getString(i33);
                                i5 = i33;
                            }
                            List<Double> stringToObject4 = this.__listDoubleConverter.stringToObject(string5);
                            int i34 = columnIndexOrThrow21;
                            double d11 = query.getDouble(i34);
                            int i35 = columnIndexOrThrow22;
                            double d12 = query.getDouble(i35);
                            columnIndexOrThrow21 = i34;
                            int i36 = columnIndexOrThrow23;
                            double d13 = query.getDouble(i36);
                            columnIndexOrThrow23 = i36;
                            int i37 = columnIndexOrThrow24;
                            double d14 = query.getDouble(i37);
                            columnIndexOrThrow24 = i37;
                            int i38 = columnIndexOrThrow25;
                            double d15 = query.getDouble(i38);
                            columnIndexOrThrow25 = i38;
                            int i39 = columnIndexOrThrow26;
                            if (query.isNull(i39)) {
                                columnIndexOrThrow26 = i39;
                                columnIndexOrThrow22 = i35;
                                string6 = null;
                            } else {
                                columnIndexOrThrow26 = i39;
                                string6 = query.getString(i39);
                                columnIndexOrThrow22 = i35;
                            }
                            List<Double> stringToObject5 = this.__listDoubleConverter.stringToObject(string6);
                            int i40 = columnIndexOrThrow27;
                            double d16 = query.getDouble(i40);
                            int i41 = columnIndexOrThrow28;
                            if (query.isNull(i41)) {
                                i6 = i40;
                                i7 = i41;
                                string7 = null;
                            } else {
                                i6 = i40;
                                string7 = query.getString(i41);
                                i7 = i41;
                            }
                            List<Double> stringToObject6 = this.__listDoubleConverter.stringToObject(string7);
                            int i42 = columnIndexOrThrow29;
                            double d17 = query.getDouble(i42);
                            int i43 = columnIndexOrThrow30;
                            if (query.isNull(i43)) {
                                i8 = i42;
                                i9 = i43;
                                string8 = null;
                            } else {
                                i8 = i42;
                                string8 = query.getString(i43);
                                i9 = i43;
                            }
                            List<Double> stringToObject7 = this.__listDoubleConverter.stringToObject(string8);
                            int i44 = columnIndexOrThrow31;
                            if (query.isNull(i44)) {
                                columnIndexOrThrow31 = i44;
                                string9 = null;
                            } else {
                                string9 = query.getString(i44);
                                columnIndexOrThrow31 = i44;
                            }
                            List<Double> stringToObject8 = this.__listDoubleConverter.stringToObject(string9);
                            int i45 = columnIndexOrThrow32;
                            double d18 = query.getDouble(i45);
                            int i46 = columnIndexOrThrow33;
                            if (query.isNull(i46)) {
                                i10 = i45;
                                i11 = i46;
                                string10 = null;
                            } else {
                                i10 = i45;
                                string10 = query.getString(i46);
                                i11 = i46;
                            }
                            List<Double> stringToObject9 = this.__listDoubleConverter.stringToObject(string10);
                            int i47 = columnIndexOrThrow34;
                            double d19 = query.getDouble(i47);
                            int i48 = columnIndexOrThrow35;
                            if (query.isNull(i48)) {
                                i12 = i47;
                                i13 = i48;
                                string11 = null;
                            } else {
                                i12 = i47;
                                string11 = query.getString(i48);
                                i13 = i48;
                            }
                            List<Double> stringToObject10 = this.__listDoubleConverter.stringToObject(string11);
                            int i49 = columnIndexOrThrow36;
                            if (query.isNull(i49)) {
                                columnIndexOrThrow36 = i49;
                                string12 = null;
                            } else {
                                string12 = query.getString(i49);
                                columnIndexOrThrow36 = i49;
                            }
                            List<Double> stringToObject11 = this.__listDoubleConverter.stringToObject(string12);
                            int i50 = columnIndexOrThrow37;
                            double d20 = query.getDouble(i50);
                            int i51 = columnIndexOrThrow38;
                            double d21 = query.getDouble(i51);
                            columnIndexOrThrow37 = i50;
                            int i52 = columnIndexOrThrow39;
                            if (query.isNull(i52)) {
                                columnIndexOrThrow39 = i52;
                                columnIndexOrThrow38 = i51;
                                string13 = null;
                            } else {
                                columnIndexOrThrow39 = i52;
                                string13 = query.getString(i52);
                                columnIndexOrThrow38 = i51;
                            }
                            List<Double> stringToObject12 = this.__listDoubleConverter.stringToObject(string13);
                            int i53 = columnIndexOrThrow40;
                            if (query.isNull(i53)) {
                                columnIndexOrThrow40 = i53;
                                string14 = null;
                            } else {
                                string14 = query.getString(i53);
                                columnIndexOrThrow40 = i53;
                            }
                            List<Double> stringToObject13 = this.__listDoubleConverter.stringToObject(string14);
                            int i54 = columnIndexOrThrow41;
                            if (query.isNull(i54)) {
                                columnIndexOrThrow41 = i54;
                                string15 = null;
                            } else {
                                string15 = query.getString(i54);
                                columnIndexOrThrow41 = i54;
                            }
                            List<Double> stringToObject14 = this.__listDoubleConverter.stringToObject(string15);
                            int i55 = columnIndexOrThrow42;
                            double d22 = query.getDouble(i55);
                            int i56 = columnIndexOrThrow43;
                            if (query.isNull(i56)) {
                                i14 = i55;
                                i15 = i56;
                                string16 = null;
                            } else {
                                i14 = i55;
                                string16 = query.getString(i56);
                                i15 = i56;
                            }
                            List<Double> stringToObject15 = this.__listDoubleConverter.stringToObject(string16);
                            int i57 = columnIndexOrThrow44;
                            double d23 = query.getDouble(i57);
                            int i58 = columnIndexOrThrow45;
                            if (query.isNull(i58)) {
                                i16 = i57;
                                i17 = i58;
                                string17 = null;
                            } else {
                                i16 = i57;
                                string17 = query.getString(i58);
                                i17 = i58;
                            }
                            List<Double> stringToObject16 = this.__listDoubleConverter.stringToObject(string17);
                            int i59 = columnIndexOrThrow46;
                            double d24 = query.getDouble(i59);
                            int i60 = columnIndexOrThrow47;
                            if (query.isNull(i60)) {
                                i18 = i59;
                                i19 = i60;
                                string18 = null;
                            } else {
                                i18 = i59;
                                string18 = query.getString(i60);
                                i19 = i60;
                            }
                            List<Double> stringToObject17 = this.__listDoubleConverter.stringToObject(string18);
                            int i61 = columnIndexOrThrow48;
                            if (query.isNull(i61)) {
                                columnIndexOrThrow48 = i61;
                                string19 = null;
                            } else {
                                string19 = query.getString(i61);
                                columnIndexOrThrow48 = i61;
                            }
                            List<Double> stringToObject18 = this.__listDoubleConverter.stringToObject(string19);
                            int i62 = columnIndexOrThrow49;
                            double d25 = query.getDouble(i62);
                            int i63 = columnIndexOrThrow50;
                            if (query.isNull(i63)) {
                                i20 = i62;
                                i21 = i63;
                                string20 = null;
                            } else {
                                i20 = i62;
                                string20 = query.getString(i63);
                                i21 = i63;
                            }
                            List<Double> stringToObject19 = this.__listDoubleConverter.stringToObject(string20);
                            int i64 = columnIndexOrThrow51;
                            int i65 = columnIndexOrThrow52;
                            columnIndexOrThrow51 = i64;
                            int i66 = columnIndexOrThrow53;
                            columnIndexOrThrow53 = i66;
                            arrayList.add(new Weight(i23, j, string, f, i24, i25, d, d2, d3, d4, d5, d6, d7, d8, d9, stringToObject, stringToObject2, stringToObject3, d10, stringToObject4, d11, d12, d13, d14, d15, stringToObject5, d16, stringToObject6, d17, stringToObject7, stringToObject8, d18, stringToObject9, d19, stringToObject10, stringToObject11, d20, d21, stringToObject12, stringToObject13, stringToObject14, d22, stringToObject15, d23, stringToObject16, d24, stringToObject17, stringToObject18, d25, stringToObject19, query.getInt(i64), query.getInt(i65), query.getInt(i66)));
                            columnIndexOrThrow52 = i65;
                            columnIndexOrThrow = i27;
                            columnIndexOrThrow13 = i2;
                            i22 = i3;
                            columnIndexOrThrow16 = i;
                            int i67 = i4;
                            columnIndexOrThrow20 = i5;
                            columnIndexOrThrow19 = i67;
                            int i68 = i6;
                            columnIndexOrThrow28 = i7;
                            columnIndexOrThrow27 = i68;
                            int i69 = i8;
                            columnIndexOrThrow30 = i9;
                            columnIndexOrThrow29 = i69;
                            int i70 = i10;
                            columnIndexOrThrow33 = i11;
                            columnIndexOrThrow32 = i70;
                            int i71 = i12;
                            columnIndexOrThrow35 = i13;
                            columnIndexOrThrow34 = i71;
                            int i72 = i14;
                            columnIndexOrThrow43 = i15;
                            columnIndexOrThrow42 = i72;
                            int i73 = i16;
                            columnIndexOrThrow45 = i17;
                            columnIndexOrThrow44 = i73;
                            int i74 = i18;
                            columnIndexOrThrow47 = i19;
                            columnIndexOrThrow46 = i74;
                            int i75 = i20;
                            columnIndexOrThrow50 = i21;
                            columnIndexOrThrow49 = i75;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
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
    }

    @Override // com.sma.smartv3.db.dao.WeightDao
    public List<Weight> getTestWeights(final long start, final long end) {
        return WeightDao.DefaultImpls.getTestWeights(this, start, end);
    }

    @Override // com.sma.smartv3.db.dao.WeightDao
    public List<Weight> getWeights() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        int i2;
        String string2;
        int i3;
        String string3;
        String string4;
        int i4;
        String string5;
        int i5;
        String string6;
        int i6;
        String string7;
        int i7;
        int i8;
        String string8;
        int i9;
        String string9;
        int i10;
        String string10;
        int i11;
        int i12;
        String string11;
        int i13;
        String string12;
        String string13;
        String string14;
        String string15;
        int i14;
        String string16;
        int i15;
        int i16;
        String string17;
        int i17;
        int i18;
        String string18;
        int i19;
        String string19;
        int i20;
        String string20;
        int i21;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Weight WHERE mIsDelete != 1 ORDER BY mTime ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mWeight");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mIsMeasure");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mBmi");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfFat");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfMuscle");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfFat");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProtein");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWater");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mStateOfNutrition");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mIdealWeight");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAgeOfBody");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mAgeOfBodyRange");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mBmiRange");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mBmiWHORange");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mBmr");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mBmrRange");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mBodyShape");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mDesirableWeight");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mFatFreeBodyWeight");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mFatToControl");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mLevelOfVisceralFat");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mLevelOfVisceralFatRange");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mMuscleToControl");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfFatRange");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfMuscle");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfMuscleRange");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProteinRange");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSkeletalMuscle");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSkeletalMuscleRange");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSubcutaneousFat");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSubcutaneousFatRange");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWaterRange");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mScore");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfBone");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfBoneRange");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfFatRange");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfMuscleRange");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfProtein");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfProteinRange");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfSkeletalMuscle");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfSkeletalMuscleRange");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfWater");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfWaterRange");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mWeightRange");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mWeightToControl");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mWeightWHORange");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProteinLevel");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWaterLevel");
                    int i22 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i23 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        if (query.isNull(columnIndexOrThrow3)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow3);
                        }
                        float f = query.getFloat(columnIndexOrThrow4);
                        int i24 = query.getInt(columnIndexOrThrow5);
                        int i25 = query.getInt(columnIndexOrThrow6);
                        double d = query.getDouble(columnIndexOrThrow7);
                        double d2 = query.getDouble(columnIndexOrThrow8);
                        double d3 = query.getDouble(columnIndexOrThrow9);
                        double d4 = query.getDouble(columnIndexOrThrow10);
                        double d5 = query.getDouble(columnIndexOrThrow11);
                        double d6 = query.getDouble(columnIndexOrThrow12);
                        double d7 = query.getDouble(columnIndexOrThrow13);
                        int i26 = i22;
                        double d8 = query.getDouble(i26);
                        int i27 = columnIndexOrThrow;
                        int i28 = columnIndexOrThrow15;
                        double d9 = query.getDouble(i28);
                        columnIndexOrThrow15 = i28;
                        int i29 = columnIndexOrThrow16;
                        if (query.isNull(i29)) {
                            i = i29;
                            i3 = i26;
                            i2 = columnIndexOrThrow13;
                            string2 = null;
                        } else {
                            i = i29;
                            i2 = columnIndexOrThrow13;
                            string2 = query.getString(i29);
                            i3 = i26;
                        }
                        try {
                            List<Double> stringToObject = this.__listDoubleConverter.stringToObject(string2);
                            int i30 = columnIndexOrThrow17;
                            if (query.isNull(i30)) {
                                columnIndexOrThrow17 = i30;
                                string3 = null;
                            } else {
                                string3 = query.getString(i30);
                                columnIndexOrThrow17 = i30;
                            }
                            List<Double> stringToObject2 = this.__listDoubleConverter.stringToObject(string3);
                            int i31 = columnIndexOrThrow18;
                            if (query.isNull(i31)) {
                                columnIndexOrThrow18 = i31;
                                string4 = null;
                            } else {
                                string4 = query.getString(i31);
                                columnIndexOrThrow18 = i31;
                            }
                            List<Double> stringToObject3 = this.__listDoubleConverter.stringToObject(string4);
                            int i32 = columnIndexOrThrow19;
                            double d10 = query.getDouble(i32);
                            int i33 = columnIndexOrThrow20;
                            if (query.isNull(i33)) {
                                i4 = i32;
                                i5 = i33;
                                string5 = null;
                            } else {
                                i4 = i32;
                                string5 = query.getString(i33);
                                i5 = i33;
                            }
                            List<Double> stringToObject4 = this.__listDoubleConverter.stringToObject(string5);
                            int i34 = columnIndexOrThrow21;
                            double d11 = query.getDouble(i34);
                            int i35 = columnIndexOrThrow22;
                            double d12 = query.getDouble(i35);
                            columnIndexOrThrow21 = i34;
                            int i36 = columnIndexOrThrow23;
                            double d13 = query.getDouble(i36);
                            columnIndexOrThrow23 = i36;
                            int i37 = columnIndexOrThrow24;
                            double d14 = query.getDouble(i37);
                            columnIndexOrThrow24 = i37;
                            int i38 = columnIndexOrThrow25;
                            double d15 = query.getDouble(i38);
                            columnIndexOrThrow25 = i38;
                            int i39 = columnIndexOrThrow26;
                            if (query.isNull(i39)) {
                                columnIndexOrThrow26 = i39;
                                columnIndexOrThrow22 = i35;
                                string6 = null;
                            } else {
                                columnIndexOrThrow26 = i39;
                                string6 = query.getString(i39);
                                columnIndexOrThrow22 = i35;
                            }
                            List<Double> stringToObject5 = this.__listDoubleConverter.stringToObject(string6);
                            int i40 = columnIndexOrThrow27;
                            double d16 = query.getDouble(i40);
                            int i41 = columnIndexOrThrow28;
                            if (query.isNull(i41)) {
                                i6 = i40;
                                i7 = i41;
                                string7 = null;
                            } else {
                                i6 = i40;
                                string7 = query.getString(i41);
                                i7 = i41;
                            }
                            List<Double> stringToObject6 = this.__listDoubleConverter.stringToObject(string7);
                            int i42 = columnIndexOrThrow29;
                            double d17 = query.getDouble(i42);
                            int i43 = columnIndexOrThrow30;
                            if (query.isNull(i43)) {
                                i8 = i42;
                                i9 = i43;
                                string8 = null;
                            } else {
                                i8 = i42;
                                string8 = query.getString(i43);
                                i9 = i43;
                            }
                            List<Double> stringToObject7 = this.__listDoubleConverter.stringToObject(string8);
                            int i44 = columnIndexOrThrow31;
                            if (query.isNull(i44)) {
                                columnIndexOrThrow31 = i44;
                                string9 = null;
                            } else {
                                string9 = query.getString(i44);
                                columnIndexOrThrow31 = i44;
                            }
                            List<Double> stringToObject8 = this.__listDoubleConverter.stringToObject(string9);
                            int i45 = columnIndexOrThrow32;
                            double d18 = query.getDouble(i45);
                            int i46 = columnIndexOrThrow33;
                            if (query.isNull(i46)) {
                                i10 = i45;
                                i11 = i46;
                                string10 = null;
                            } else {
                                i10 = i45;
                                string10 = query.getString(i46);
                                i11 = i46;
                            }
                            List<Double> stringToObject9 = this.__listDoubleConverter.stringToObject(string10);
                            int i47 = columnIndexOrThrow34;
                            double d19 = query.getDouble(i47);
                            int i48 = columnIndexOrThrow35;
                            if (query.isNull(i48)) {
                                i12 = i47;
                                i13 = i48;
                                string11 = null;
                            } else {
                                i12 = i47;
                                string11 = query.getString(i48);
                                i13 = i48;
                            }
                            List<Double> stringToObject10 = this.__listDoubleConverter.stringToObject(string11);
                            int i49 = columnIndexOrThrow36;
                            if (query.isNull(i49)) {
                                columnIndexOrThrow36 = i49;
                                string12 = null;
                            } else {
                                string12 = query.getString(i49);
                                columnIndexOrThrow36 = i49;
                            }
                            List<Double> stringToObject11 = this.__listDoubleConverter.stringToObject(string12);
                            int i50 = columnIndexOrThrow37;
                            double d20 = query.getDouble(i50);
                            int i51 = columnIndexOrThrow38;
                            double d21 = query.getDouble(i51);
                            columnIndexOrThrow37 = i50;
                            int i52 = columnIndexOrThrow39;
                            if (query.isNull(i52)) {
                                columnIndexOrThrow39 = i52;
                                columnIndexOrThrow38 = i51;
                                string13 = null;
                            } else {
                                columnIndexOrThrow39 = i52;
                                string13 = query.getString(i52);
                                columnIndexOrThrow38 = i51;
                            }
                            List<Double> stringToObject12 = this.__listDoubleConverter.stringToObject(string13);
                            int i53 = columnIndexOrThrow40;
                            if (query.isNull(i53)) {
                                columnIndexOrThrow40 = i53;
                                string14 = null;
                            } else {
                                string14 = query.getString(i53);
                                columnIndexOrThrow40 = i53;
                            }
                            List<Double> stringToObject13 = this.__listDoubleConverter.stringToObject(string14);
                            int i54 = columnIndexOrThrow41;
                            if (query.isNull(i54)) {
                                columnIndexOrThrow41 = i54;
                                string15 = null;
                            } else {
                                string15 = query.getString(i54);
                                columnIndexOrThrow41 = i54;
                            }
                            List<Double> stringToObject14 = this.__listDoubleConverter.stringToObject(string15);
                            int i55 = columnIndexOrThrow42;
                            double d22 = query.getDouble(i55);
                            int i56 = columnIndexOrThrow43;
                            if (query.isNull(i56)) {
                                i14 = i55;
                                i15 = i56;
                                string16 = null;
                            } else {
                                i14 = i55;
                                string16 = query.getString(i56);
                                i15 = i56;
                            }
                            List<Double> stringToObject15 = this.__listDoubleConverter.stringToObject(string16);
                            int i57 = columnIndexOrThrow44;
                            double d23 = query.getDouble(i57);
                            int i58 = columnIndexOrThrow45;
                            if (query.isNull(i58)) {
                                i16 = i57;
                                i17 = i58;
                                string17 = null;
                            } else {
                                i16 = i57;
                                string17 = query.getString(i58);
                                i17 = i58;
                            }
                            List<Double> stringToObject16 = this.__listDoubleConverter.stringToObject(string17);
                            int i59 = columnIndexOrThrow46;
                            double d24 = query.getDouble(i59);
                            int i60 = columnIndexOrThrow47;
                            if (query.isNull(i60)) {
                                i18 = i59;
                                i19 = i60;
                                string18 = null;
                            } else {
                                i18 = i59;
                                string18 = query.getString(i60);
                                i19 = i60;
                            }
                            List<Double> stringToObject17 = this.__listDoubleConverter.stringToObject(string18);
                            int i61 = columnIndexOrThrow48;
                            if (query.isNull(i61)) {
                                columnIndexOrThrow48 = i61;
                                string19 = null;
                            } else {
                                string19 = query.getString(i61);
                                columnIndexOrThrow48 = i61;
                            }
                            List<Double> stringToObject18 = this.__listDoubleConverter.stringToObject(string19);
                            int i62 = columnIndexOrThrow49;
                            double d25 = query.getDouble(i62);
                            int i63 = columnIndexOrThrow50;
                            if (query.isNull(i63)) {
                                i20 = i62;
                                i21 = i63;
                                string20 = null;
                            } else {
                                i20 = i62;
                                string20 = query.getString(i63);
                                i21 = i63;
                            }
                            List<Double> stringToObject19 = this.__listDoubleConverter.stringToObject(string20);
                            int i64 = columnIndexOrThrow51;
                            int i65 = columnIndexOrThrow52;
                            columnIndexOrThrow51 = i64;
                            int i66 = columnIndexOrThrow53;
                            columnIndexOrThrow53 = i66;
                            arrayList.add(new Weight(i23, j, string, f, i24, i25, d, d2, d3, d4, d5, d6, d7, d8, d9, stringToObject, stringToObject2, stringToObject3, d10, stringToObject4, d11, d12, d13, d14, d15, stringToObject5, d16, stringToObject6, d17, stringToObject7, stringToObject8, d18, stringToObject9, d19, stringToObject10, stringToObject11, d20, d21, stringToObject12, stringToObject13, stringToObject14, d22, stringToObject15, d23, stringToObject16, d24, stringToObject17, stringToObject18, d25, stringToObject19, query.getInt(i64), query.getInt(i65), query.getInt(i66)));
                            columnIndexOrThrow52 = i65;
                            columnIndexOrThrow = i27;
                            columnIndexOrThrow13 = i2;
                            i22 = i3;
                            columnIndexOrThrow16 = i;
                            int i67 = i4;
                            columnIndexOrThrow20 = i5;
                            columnIndexOrThrow19 = i67;
                            int i68 = i6;
                            columnIndexOrThrow28 = i7;
                            columnIndexOrThrow27 = i68;
                            int i69 = i8;
                            columnIndexOrThrow30 = i9;
                            columnIndexOrThrow29 = i69;
                            int i70 = i10;
                            columnIndexOrThrow33 = i11;
                            columnIndexOrThrow32 = i70;
                            int i71 = i12;
                            columnIndexOrThrow35 = i13;
                            columnIndexOrThrow34 = i71;
                            int i72 = i14;
                            columnIndexOrThrow43 = i15;
                            columnIndexOrThrow42 = i72;
                            int i73 = i16;
                            columnIndexOrThrow45 = i17;
                            columnIndexOrThrow44 = i73;
                            int i74 = i18;
                            columnIndexOrThrow47 = i19;
                            columnIndexOrThrow46 = i74;
                            int i75 = i20;
                            columnIndexOrThrow50 = i21;
                            columnIndexOrThrow49 = i75;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
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
    }

    @Override // com.sma.smartv3.db.dao.WeightDao
    public List<Weight> getWeightsASC(final long start, final long end) {
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
        String string3;
        String string4;
        int i3;
        String string5;
        int i4;
        String string6;
        int i5;
        String string7;
        int i6;
        int i7;
        String string8;
        int i8;
        String string9;
        int i9;
        String string10;
        int i10;
        int i11;
        String string11;
        int i12;
        String string12;
        String string13;
        String string14;
        String string15;
        int i13;
        String string16;
        int i14;
        int i15;
        String string17;
        int i16;
        int i17;
        String string18;
        int i18;
        String string19;
        int i19;
        String string20;
        int i20;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Weight WHERE mTime >= ? AND mTime < ? AND mIsDelete != 1 ORDER BY mTime ASC", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mWeight");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mIsMeasure");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mBmi");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfFat");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfMuscle");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfFat");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProtein");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWater");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mStateOfNutrition");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mIdealWeight");
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAgeOfBody");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mAgeOfBodyRange");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mBmiRange");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mBmiWHORange");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mBmr");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mBmrRange");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mBodyShape");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mDesirableWeight");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mFatFreeBodyWeight");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mFatToControl");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mLevelOfVisceralFat");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mLevelOfVisceralFatRange");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mMuscleToControl");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfFatRange");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfMuscle");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfMuscleRange");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProteinRange");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSkeletalMuscle");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSkeletalMuscleRange");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSubcutaneousFat");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSubcutaneousFatRange");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWaterRange");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mScore");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfBone");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfBoneRange");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfFatRange");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfMuscleRange");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfProtein");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfProteinRange");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfSkeletalMuscle");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfSkeletalMuscleRange");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfWater");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfWaterRange");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mWeightRange");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mWeightToControl");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mWeightWHORange");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProteinLevel");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWaterLevel");
                int i21 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i22 = query.getInt(columnIndexOrThrow);
                    long j = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow3);
                    }
                    float f = query.getFloat(columnIndexOrThrow4);
                    int i23 = query.getInt(columnIndexOrThrow5);
                    int i24 = query.getInt(columnIndexOrThrow6);
                    double d = query.getDouble(columnIndexOrThrow7);
                    double d2 = query.getDouble(columnIndexOrThrow8);
                    double d3 = query.getDouble(columnIndexOrThrow9);
                    double d4 = query.getDouble(columnIndexOrThrow10);
                    double d5 = query.getDouble(columnIndexOrThrow11);
                    double d6 = query.getDouble(columnIndexOrThrow12);
                    double d7 = query.getDouble(columnIndexOrThrow13);
                    int i25 = i21;
                    double d8 = query.getDouble(i25);
                    int i26 = columnIndexOrThrow;
                    int i27 = columnIndexOrThrow15;
                    double d9 = query.getDouble(i27);
                    columnIndexOrThrow15 = i27;
                    int i28 = columnIndexOrThrow16;
                    if (query.isNull(i28)) {
                        columnIndexOrThrow16 = i28;
                        i = i25;
                        i2 = columnIndexOrThrow13;
                        string2 = null;
                    } else {
                        columnIndexOrThrow16 = i28;
                        i = i25;
                        i2 = columnIndexOrThrow13;
                        string2 = query.getString(i28);
                    }
                    try {
                        List<Double> stringToObject = this.__listDoubleConverter.stringToObject(string2);
                        int i29 = columnIndexOrThrow17;
                        if (query.isNull(i29)) {
                            columnIndexOrThrow17 = i29;
                            string3 = null;
                        } else {
                            string3 = query.getString(i29);
                            columnIndexOrThrow17 = i29;
                        }
                        List<Double> stringToObject2 = this.__listDoubleConverter.stringToObject(string3);
                        int i30 = columnIndexOrThrow18;
                        if (query.isNull(i30)) {
                            columnIndexOrThrow18 = i30;
                            string4 = null;
                        } else {
                            string4 = query.getString(i30);
                            columnIndexOrThrow18 = i30;
                        }
                        List<Double> stringToObject3 = this.__listDoubleConverter.stringToObject(string4);
                        int i31 = columnIndexOrThrow19;
                        double d10 = query.getDouble(i31);
                        int i32 = columnIndexOrThrow20;
                        if (query.isNull(i32)) {
                            i3 = i31;
                            i4 = i32;
                            string5 = null;
                        } else {
                            i3 = i31;
                            string5 = query.getString(i32);
                            i4 = i32;
                        }
                        List<Double> stringToObject4 = this.__listDoubleConverter.stringToObject(string5);
                        int i33 = columnIndexOrThrow21;
                        double d11 = query.getDouble(i33);
                        int i34 = columnIndexOrThrow22;
                        double d12 = query.getDouble(i34);
                        columnIndexOrThrow21 = i33;
                        int i35 = columnIndexOrThrow23;
                        double d13 = query.getDouble(i35);
                        columnIndexOrThrow23 = i35;
                        int i36 = columnIndexOrThrow24;
                        double d14 = query.getDouble(i36);
                        columnIndexOrThrow24 = i36;
                        int i37 = columnIndexOrThrow25;
                        double d15 = query.getDouble(i37);
                        columnIndexOrThrow25 = i37;
                        int i38 = columnIndexOrThrow26;
                        if (query.isNull(i38)) {
                            columnIndexOrThrow26 = i38;
                            columnIndexOrThrow22 = i34;
                            string6 = null;
                        } else {
                            columnIndexOrThrow26 = i38;
                            string6 = query.getString(i38);
                            columnIndexOrThrow22 = i34;
                        }
                        List<Double> stringToObject5 = this.__listDoubleConverter.stringToObject(string6);
                        int i39 = columnIndexOrThrow27;
                        double d16 = query.getDouble(i39);
                        int i40 = columnIndexOrThrow28;
                        if (query.isNull(i40)) {
                            i5 = i39;
                            i6 = i40;
                            string7 = null;
                        } else {
                            i5 = i39;
                            string7 = query.getString(i40);
                            i6 = i40;
                        }
                        List<Double> stringToObject6 = this.__listDoubleConverter.stringToObject(string7);
                        int i41 = columnIndexOrThrow29;
                        double d17 = query.getDouble(i41);
                        int i42 = columnIndexOrThrow30;
                        if (query.isNull(i42)) {
                            i7 = i41;
                            i8 = i42;
                            string8 = null;
                        } else {
                            i7 = i41;
                            string8 = query.getString(i42);
                            i8 = i42;
                        }
                        List<Double> stringToObject7 = this.__listDoubleConverter.stringToObject(string8);
                        int i43 = columnIndexOrThrow31;
                        if (query.isNull(i43)) {
                            columnIndexOrThrow31 = i43;
                            string9 = null;
                        } else {
                            string9 = query.getString(i43);
                            columnIndexOrThrow31 = i43;
                        }
                        List<Double> stringToObject8 = this.__listDoubleConverter.stringToObject(string9);
                        int i44 = columnIndexOrThrow32;
                        double d18 = query.getDouble(i44);
                        int i45 = columnIndexOrThrow33;
                        if (query.isNull(i45)) {
                            i9 = i44;
                            i10 = i45;
                            string10 = null;
                        } else {
                            i9 = i44;
                            string10 = query.getString(i45);
                            i10 = i45;
                        }
                        List<Double> stringToObject9 = this.__listDoubleConverter.stringToObject(string10);
                        int i46 = columnIndexOrThrow34;
                        double d19 = query.getDouble(i46);
                        int i47 = columnIndexOrThrow35;
                        if (query.isNull(i47)) {
                            i11 = i46;
                            i12 = i47;
                            string11 = null;
                        } else {
                            i11 = i46;
                            string11 = query.getString(i47);
                            i12 = i47;
                        }
                        List<Double> stringToObject10 = this.__listDoubleConverter.stringToObject(string11);
                        int i48 = columnIndexOrThrow36;
                        if (query.isNull(i48)) {
                            columnIndexOrThrow36 = i48;
                            string12 = null;
                        } else {
                            string12 = query.getString(i48);
                            columnIndexOrThrow36 = i48;
                        }
                        List<Double> stringToObject11 = this.__listDoubleConverter.stringToObject(string12);
                        int i49 = columnIndexOrThrow37;
                        double d20 = query.getDouble(i49);
                        int i50 = columnIndexOrThrow38;
                        double d21 = query.getDouble(i50);
                        columnIndexOrThrow37 = i49;
                        int i51 = columnIndexOrThrow39;
                        if (query.isNull(i51)) {
                            columnIndexOrThrow39 = i51;
                            columnIndexOrThrow38 = i50;
                            string13 = null;
                        } else {
                            columnIndexOrThrow39 = i51;
                            string13 = query.getString(i51);
                            columnIndexOrThrow38 = i50;
                        }
                        List<Double> stringToObject12 = this.__listDoubleConverter.stringToObject(string13);
                        int i52 = columnIndexOrThrow40;
                        if (query.isNull(i52)) {
                            columnIndexOrThrow40 = i52;
                            string14 = null;
                        } else {
                            string14 = query.getString(i52);
                            columnIndexOrThrow40 = i52;
                        }
                        List<Double> stringToObject13 = this.__listDoubleConverter.stringToObject(string14);
                        int i53 = columnIndexOrThrow41;
                        if (query.isNull(i53)) {
                            columnIndexOrThrow41 = i53;
                            string15 = null;
                        } else {
                            string15 = query.getString(i53);
                            columnIndexOrThrow41 = i53;
                        }
                        List<Double> stringToObject14 = this.__listDoubleConverter.stringToObject(string15);
                        int i54 = columnIndexOrThrow42;
                        double d22 = query.getDouble(i54);
                        int i55 = columnIndexOrThrow43;
                        if (query.isNull(i55)) {
                            i13 = i54;
                            i14 = i55;
                            string16 = null;
                        } else {
                            i13 = i54;
                            string16 = query.getString(i55);
                            i14 = i55;
                        }
                        List<Double> stringToObject15 = this.__listDoubleConverter.stringToObject(string16);
                        int i56 = columnIndexOrThrow44;
                        double d23 = query.getDouble(i56);
                        int i57 = columnIndexOrThrow45;
                        if (query.isNull(i57)) {
                            i15 = i56;
                            i16 = i57;
                            string17 = null;
                        } else {
                            i15 = i56;
                            string17 = query.getString(i57);
                            i16 = i57;
                        }
                        List<Double> stringToObject16 = this.__listDoubleConverter.stringToObject(string17);
                        int i58 = columnIndexOrThrow46;
                        double d24 = query.getDouble(i58);
                        int i59 = columnIndexOrThrow47;
                        if (query.isNull(i59)) {
                            i17 = i58;
                            i18 = i59;
                            string18 = null;
                        } else {
                            i17 = i58;
                            string18 = query.getString(i59);
                            i18 = i59;
                        }
                        List<Double> stringToObject17 = this.__listDoubleConverter.stringToObject(string18);
                        int i60 = columnIndexOrThrow48;
                        if (query.isNull(i60)) {
                            columnIndexOrThrow48 = i60;
                            string19 = null;
                        } else {
                            string19 = query.getString(i60);
                            columnIndexOrThrow48 = i60;
                        }
                        List<Double> stringToObject18 = this.__listDoubleConverter.stringToObject(string19);
                        int i61 = columnIndexOrThrow49;
                        double d25 = query.getDouble(i61);
                        int i62 = columnIndexOrThrow50;
                        if (query.isNull(i62)) {
                            i19 = i61;
                            i20 = i62;
                            string20 = null;
                        } else {
                            i19 = i61;
                            string20 = query.getString(i62);
                            i20 = i62;
                        }
                        List<Double> stringToObject19 = this.__listDoubleConverter.stringToObject(string20);
                        int i63 = columnIndexOrThrow51;
                        int i64 = columnIndexOrThrow52;
                        columnIndexOrThrow51 = i63;
                        int i65 = columnIndexOrThrow53;
                        columnIndexOrThrow53 = i65;
                        arrayList.add(new Weight(i22, j, string, f, i23, i24, d, d2, d3, d4, d5, d6, d7, d8, d9, stringToObject, stringToObject2, stringToObject3, d10, stringToObject4, d11, d12, d13, d14, d15, stringToObject5, d16, stringToObject6, d17, stringToObject7, stringToObject8, d18, stringToObject9, d19, stringToObject10, stringToObject11, d20, d21, stringToObject12, stringToObject13, stringToObject14, d22, stringToObject15, d23, stringToObject16, d24, stringToObject17, stringToObject18, d25, stringToObject19, query.getInt(i63), query.getInt(i64), query.getInt(i65)));
                        columnIndexOrThrow52 = i64;
                        columnIndexOrThrow = i26;
                        i21 = i;
                        columnIndexOrThrow13 = i2;
                        int i66 = i3;
                        columnIndexOrThrow20 = i4;
                        columnIndexOrThrow19 = i66;
                        int i67 = i5;
                        columnIndexOrThrow28 = i6;
                        columnIndexOrThrow27 = i67;
                        int i68 = i7;
                        columnIndexOrThrow30 = i8;
                        columnIndexOrThrow29 = i68;
                        int i69 = i9;
                        columnIndexOrThrow33 = i10;
                        columnIndexOrThrow32 = i69;
                        int i70 = i11;
                        columnIndexOrThrow35 = i12;
                        columnIndexOrThrow34 = i70;
                        int i71 = i13;
                        columnIndexOrThrow43 = i14;
                        columnIndexOrThrow42 = i71;
                        int i72 = i15;
                        columnIndexOrThrow45 = i16;
                        columnIndexOrThrow44 = i72;
                        int i73 = i17;
                        columnIndexOrThrow47 = i18;
                        columnIndexOrThrow46 = i73;
                        int i74 = i19;
                        columnIndexOrThrow50 = i20;
                        columnIndexOrThrow49 = i74;
                    } catch (Throwable th2) {
                        th = th2;
                        query.close();
                        roomSQLiteQuery.release();
                        throw th;
                    }
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.sma.smartv3.db.dao.WeightDao
    public List<Weight> getWeightsDESC(final int startIndex, final int endIndex) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        int i2;
        String string2;
        int i3;
        String string3;
        String string4;
        int i4;
        String string5;
        int i5;
        String string6;
        int i6;
        String string7;
        int i7;
        int i8;
        String string8;
        int i9;
        String string9;
        int i10;
        String string10;
        int i11;
        int i12;
        String string11;
        int i13;
        String string12;
        String string13;
        String string14;
        String string15;
        int i14;
        String string16;
        int i15;
        int i16;
        String string17;
        int i17;
        int i18;
        String string18;
        int i19;
        String string19;
        int i20;
        String string20;
        int i21;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Weight WHERE  mIsDelete != 1 ORDER BY mTime DESC LIMIT ?, ?", 2);
        acquire.bindLong(1, startIndex);
        acquire.bindLong(2, endIndex);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mWeight");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mIsMeasure");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mBmi");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfFat");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfMuscle");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfFat");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProtein");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWater");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mStateOfNutrition");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mIdealWeight");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAgeOfBody");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mAgeOfBodyRange");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mBmiRange");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mBmiWHORange");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mBmr");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mBmrRange");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mBodyShape");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mDesirableWeight");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mFatFreeBodyWeight");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mFatToControl");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mLevelOfVisceralFat");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mLevelOfVisceralFatRange");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mMuscleToControl");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfFatRange");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfMuscle");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfMuscleRange");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProteinRange");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSkeletalMuscle");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSkeletalMuscleRange");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSubcutaneousFat");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfSubcutaneousFatRange");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWaterRange");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mScore");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfBone");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfBoneRange");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfFatRange");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfMuscleRange");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfProtein");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfProteinRange");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfSkeletalMuscle");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfSkeletalMuscleRange");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfWater");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mWeightOfWaterRange");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mWeightRange");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mWeightToControl");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mWeightWHORange");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfProteinLevel");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mRatioOfWaterLevel");
                    int i22 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i23 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        if (query.isNull(columnIndexOrThrow3)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow3);
                        }
                        float f = query.getFloat(columnIndexOrThrow4);
                        int i24 = query.getInt(columnIndexOrThrow5);
                        int i25 = query.getInt(columnIndexOrThrow6);
                        double d = query.getDouble(columnIndexOrThrow7);
                        double d2 = query.getDouble(columnIndexOrThrow8);
                        double d3 = query.getDouble(columnIndexOrThrow9);
                        double d4 = query.getDouble(columnIndexOrThrow10);
                        double d5 = query.getDouble(columnIndexOrThrow11);
                        double d6 = query.getDouble(columnIndexOrThrow12);
                        double d7 = query.getDouble(columnIndexOrThrow13);
                        int i26 = i22;
                        double d8 = query.getDouble(i26);
                        int i27 = columnIndexOrThrow;
                        int i28 = columnIndexOrThrow15;
                        double d9 = query.getDouble(i28);
                        columnIndexOrThrow15 = i28;
                        int i29 = columnIndexOrThrow16;
                        if (query.isNull(i29)) {
                            i = i29;
                            i3 = i26;
                            i2 = columnIndexOrThrow13;
                            string2 = null;
                        } else {
                            i = i29;
                            i2 = columnIndexOrThrow13;
                            string2 = query.getString(i29);
                            i3 = i26;
                        }
                        try {
                            List<Double> stringToObject = this.__listDoubleConverter.stringToObject(string2);
                            int i30 = columnIndexOrThrow17;
                            if (query.isNull(i30)) {
                                columnIndexOrThrow17 = i30;
                                string3 = null;
                            } else {
                                string3 = query.getString(i30);
                                columnIndexOrThrow17 = i30;
                            }
                            List<Double> stringToObject2 = this.__listDoubleConverter.stringToObject(string3);
                            int i31 = columnIndexOrThrow18;
                            if (query.isNull(i31)) {
                                columnIndexOrThrow18 = i31;
                                string4 = null;
                            } else {
                                string4 = query.getString(i31);
                                columnIndexOrThrow18 = i31;
                            }
                            List<Double> stringToObject3 = this.__listDoubleConverter.stringToObject(string4);
                            int i32 = columnIndexOrThrow19;
                            double d10 = query.getDouble(i32);
                            int i33 = columnIndexOrThrow20;
                            if (query.isNull(i33)) {
                                i4 = i32;
                                i5 = i33;
                                string5 = null;
                            } else {
                                i4 = i32;
                                string5 = query.getString(i33);
                                i5 = i33;
                            }
                            List<Double> stringToObject4 = this.__listDoubleConverter.stringToObject(string5);
                            int i34 = columnIndexOrThrow21;
                            double d11 = query.getDouble(i34);
                            int i35 = columnIndexOrThrow22;
                            double d12 = query.getDouble(i35);
                            columnIndexOrThrow21 = i34;
                            int i36 = columnIndexOrThrow23;
                            double d13 = query.getDouble(i36);
                            columnIndexOrThrow23 = i36;
                            int i37 = columnIndexOrThrow24;
                            double d14 = query.getDouble(i37);
                            columnIndexOrThrow24 = i37;
                            int i38 = columnIndexOrThrow25;
                            double d15 = query.getDouble(i38);
                            columnIndexOrThrow25 = i38;
                            int i39 = columnIndexOrThrow26;
                            if (query.isNull(i39)) {
                                columnIndexOrThrow26 = i39;
                                columnIndexOrThrow22 = i35;
                                string6 = null;
                            } else {
                                columnIndexOrThrow26 = i39;
                                string6 = query.getString(i39);
                                columnIndexOrThrow22 = i35;
                            }
                            List<Double> stringToObject5 = this.__listDoubleConverter.stringToObject(string6);
                            int i40 = columnIndexOrThrow27;
                            double d16 = query.getDouble(i40);
                            int i41 = columnIndexOrThrow28;
                            if (query.isNull(i41)) {
                                i6 = i40;
                                i7 = i41;
                                string7 = null;
                            } else {
                                i6 = i40;
                                string7 = query.getString(i41);
                                i7 = i41;
                            }
                            List<Double> stringToObject6 = this.__listDoubleConverter.stringToObject(string7);
                            int i42 = columnIndexOrThrow29;
                            double d17 = query.getDouble(i42);
                            int i43 = columnIndexOrThrow30;
                            if (query.isNull(i43)) {
                                i8 = i42;
                                i9 = i43;
                                string8 = null;
                            } else {
                                i8 = i42;
                                string8 = query.getString(i43);
                                i9 = i43;
                            }
                            List<Double> stringToObject7 = this.__listDoubleConverter.stringToObject(string8);
                            int i44 = columnIndexOrThrow31;
                            if (query.isNull(i44)) {
                                columnIndexOrThrow31 = i44;
                                string9 = null;
                            } else {
                                string9 = query.getString(i44);
                                columnIndexOrThrow31 = i44;
                            }
                            List<Double> stringToObject8 = this.__listDoubleConverter.stringToObject(string9);
                            int i45 = columnIndexOrThrow32;
                            double d18 = query.getDouble(i45);
                            int i46 = columnIndexOrThrow33;
                            if (query.isNull(i46)) {
                                i10 = i45;
                                i11 = i46;
                                string10 = null;
                            } else {
                                i10 = i45;
                                string10 = query.getString(i46);
                                i11 = i46;
                            }
                            List<Double> stringToObject9 = this.__listDoubleConverter.stringToObject(string10);
                            int i47 = columnIndexOrThrow34;
                            double d19 = query.getDouble(i47);
                            int i48 = columnIndexOrThrow35;
                            if (query.isNull(i48)) {
                                i12 = i47;
                                i13 = i48;
                                string11 = null;
                            } else {
                                i12 = i47;
                                string11 = query.getString(i48);
                                i13 = i48;
                            }
                            List<Double> stringToObject10 = this.__listDoubleConverter.stringToObject(string11);
                            int i49 = columnIndexOrThrow36;
                            if (query.isNull(i49)) {
                                columnIndexOrThrow36 = i49;
                                string12 = null;
                            } else {
                                string12 = query.getString(i49);
                                columnIndexOrThrow36 = i49;
                            }
                            List<Double> stringToObject11 = this.__listDoubleConverter.stringToObject(string12);
                            int i50 = columnIndexOrThrow37;
                            double d20 = query.getDouble(i50);
                            int i51 = columnIndexOrThrow38;
                            double d21 = query.getDouble(i51);
                            columnIndexOrThrow37 = i50;
                            int i52 = columnIndexOrThrow39;
                            if (query.isNull(i52)) {
                                columnIndexOrThrow39 = i52;
                                columnIndexOrThrow38 = i51;
                                string13 = null;
                            } else {
                                columnIndexOrThrow39 = i52;
                                string13 = query.getString(i52);
                                columnIndexOrThrow38 = i51;
                            }
                            List<Double> stringToObject12 = this.__listDoubleConverter.stringToObject(string13);
                            int i53 = columnIndexOrThrow40;
                            if (query.isNull(i53)) {
                                columnIndexOrThrow40 = i53;
                                string14 = null;
                            } else {
                                string14 = query.getString(i53);
                                columnIndexOrThrow40 = i53;
                            }
                            List<Double> stringToObject13 = this.__listDoubleConverter.stringToObject(string14);
                            int i54 = columnIndexOrThrow41;
                            if (query.isNull(i54)) {
                                columnIndexOrThrow41 = i54;
                                string15 = null;
                            } else {
                                string15 = query.getString(i54);
                                columnIndexOrThrow41 = i54;
                            }
                            List<Double> stringToObject14 = this.__listDoubleConverter.stringToObject(string15);
                            int i55 = columnIndexOrThrow42;
                            double d22 = query.getDouble(i55);
                            int i56 = columnIndexOrThrow43;
                            if (query.isNull(i56)) {
                                i14 = i55;
                                i15 = i56;
                                string16 = null;
                            } else {
                                i14 = i55;
                                string16 = query.getString(i56);
                                i15 = i56;
                            }
                            List<Double> stringToObject15 = this.__listDoubleConverter.stringToObject(string16);
                            int i57 = columnIndexOrThrow44;
                            double d23 = query.getDouble(i57);
                            int i58 = columnIndexOrThrow45;
                            if (query.isNull(i58)) {
                                i16 = i57;
                                i17 = i58;
                                string17 = null;
                            } else {
                                i16 = i57;
                                string17 = query.getString(i58);
                                i17 = i58;
                            }
                            List<Double> stringToObject16 = this.__listDoubleConverter.stringToObject(string17);
                            int i59 = columnIndexOrThrow46;
                            double d24 = query.getDouble(i59);
                            int i60 = columnIndexOrThrow47;
                            if (query.isNull(i60)) {
                                i18 = i59;
                                i19 = i60;
                                string18 = null;
                            } else {
                                i18 = i59;
                                string18 = query.getString(i60);
                                i19 = i60;
                            }
                            List<Double> stringToObject17 = this.__listDoubleConverter.stringToObject(string18);
                            int i61 = columnIndexOrThrow48;
                            if (query.isNull(i61)) {
                                columnIndexOrThrow48 = i61;
                                string19 = null;
                            } else {
                                string19 = query.getString(i61);
                                columnIndexOrThrow48 = i61;
                            }
                            List<Double> stringToObject18 = this.__listDoubleConverter.stringToObject(string19);
                            int i62 = columnIndexOrThrow49;
                            double d25 = query.getDouble(i62);
                            int i63 = columnIndexOrThrow50;
                            if (query.isNull(i63)) {
                                i20 = i62;
                                i21 = i63;
                                string20 = null;
                            } else {
                                i20 = i62;
                                string20 = query.getString(i63);
                                i21 = i63;
                            }
                            List<Double> stringToObject19 = this.__listDoubleConverter.stringToObject(string20);
                            int i64 = columnIndexOrThrow51;
                            int i65 = columnIndexOrThrow52;
                            columnIndexOrThrow51 = i64;
                            int i66 = columnIndexOrThrow53;
                            columnIndexOrThrow53 = i66;
                            arrayList.add(new Weight(i23, j, string, f, i24, i25, d, d2, d3, d4, d5, d6, d7, d8, d9, stringToObject, stringToObject2, stringToObject3, d10, stringToObject4, d11, d12, d13, d14, d15, stringToObject5, d16, stringToObject6, d17, stringToObject7, stringToObject8, d18, stringToObject9, d19, stringToObject10, stringToObject11, d20, d21, stringToObject12, stringToObject13, stringToObject14, d22, stringToObject15, d23, stringToObject16, d24, stringToObject17, stringToObject18, d25, stringToObject19, query.getInt(i64), query.getInt(i65), query.getInt(i66)));
                            columnIndexOrThrow52 = i65;
                            columnIndexOrThrow = i27;
                            columnIndexOrThrow13 = i2;
                            i22 = i3;
                            columnIndexOrThrow16 = i;
                            int i67 = i4;
                            columnIndexOrThrow20 = i5;
                            columnIndexOrThrow19 = i67;
                            int i68 = i6;
                            columnIndexOrThrow28 = i7;
                            columnIndexOrThrow27 = i68;
                            int i69 = i8;
                            columnIndexOrThrow30 = i9;
                            columnIndexOrThrow29 = i69;
                            int i70 = i10;
                            columnIndexOrThrow33 = i11;
                            columnIndexOrThrow32 = i70;
                            int i71 = i12;
                            columnIndexOrThrow35 = i13;
                            columnIndexOrThrow34 = i71;
                            int i72 = i14;
                            columnIndexOrThrow43 = i15;
                            columnIndexOrThrow42 = i72;
                            int i73 = i16;
                            columnIndexOrThrow45 = i17;
                            columnIndexOrThrow44 = i73;
                            int i74 = i18;
                            columnIndexOrThrow47 = i19;
                            columnIndexOrThrow46 = i74;
                            int i75 = i20;
                            columnIndexOrThrow50 = i21;
                            columnIndexOrThrow49 = i75;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
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
    }

    @Override // com.sma.smartv3.db.dao.WeightDao
    public long[] insert(final List<Weight> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfWeight.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.WeightDao
    public int update(final List<Weight> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfWeight.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
