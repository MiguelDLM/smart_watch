package com.jieli.bluetooth_connect.data;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.bluetooth_connect.data.dao.HistoryRecordDao;

@Database(entities = {HistoryRecord.class}, version = 3)
/* loaded from: classes10.dex */
public abstract class BtConnectDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "bt_data.db";
    static final Migration MIGRATION_1_2;
    static final Migration MIGRATION_2_3;

    static {
        int i = 2;
        MIGRATION_1_2 = new Migration(1, i) { // from class: com.jieli.bluetooth_connect.data.BtConnectDatabase.1
            @Override // androidx.room.migration.Migration
            public void migrate(@NonNull SupportSQLiteDatabase database) {
                database.execSQL("ALTER TABLE HistoryRecord RENAME TO __HistoryRecord_old");
                database.execSQL("CREATE TABLE IF NOT EXISTS `HistoryRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `address` TEXT NOT NULL, `mapped_address` TEXT, `dev_type` INTEGER NOT NULL, `connect_type` INTEGER NOT NULL, `sdk_flag` INTEGER NOT NULL, `vid` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `pid` INTEGER NOT NULL, `left_dev_lat` REAL NOT NULL, `left_dev_lon` REAL NOT NULL, `left_dev_update_time` INTEGER NOT NULL, `right_dev_lat` REAL NOT NULL, `right_dev_lon` REAL NOT NULL, `right_dev_update_time` INTEGER NOT NULL, `online_time` INTEGER NOT NULL)");
                database.execSQL("INSERT INTO `HistoryRecord`(`name`, `address`, `mapped_address`, `dev_type`, `connect_type`, `sdk_flag`, `vid`, `uid`, `pid`, `left_dev_lat`, `left_dev_lon`, `left_dev_update_time`, `right_dev_lat`, `right_dev_lon`, `right_dev_update_time`, `online_time`) SELECT `name`, `address`, `mapped_address`, `dev_type`, `connect_type`, `sdk_flag`, `vid`, `uid`, `pid`, `left_dev_lat`, `left_dev_lon`, `left_dev_update_time`, `right_dev_lat`, `right_dev_lon`, `right_dev_update_time`, `online_time` FROM __HistoryRecord_old");
                database.execSQL("DROP TABLE __HistoryRecord_old;");
            }
        };
        MIGRATION_2_3 = new Migration(i, 3) { // from class: com.jieli.bluetooth_connect.data.BtConnectDatabase.2
            @Override // androidx.room.migration.Migration
            public void migrate(@NonNull SupportSQLiteDatabase database) {
                database.execSQL("ALTER TABLE HistoryRecord ADD COLUMN `update_address` TEXT DEFAULT \"\"");
            }
        };
    }

    public static BtConnectDatabase buildDatabase(Context context) {
        return (BtConnectDatabase) Room.databaseBuilder(context, BtConnectDatabase.class, DATABASE_NAME).allowMainThreadQueries().addMigrations(MIGRATION_1_2, MIGRATION_2_3).build();
    }

    public abstract HistoryRecordDao historyRecordDao();
}
