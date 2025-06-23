package androidx.room.migration;

import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteDatabase;

public interface AutoMigrationSpec {
    void onPostMigrate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);
}
