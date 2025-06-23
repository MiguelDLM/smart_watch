package androidx.room.migration;

import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes.dex */
public interface AutoMigrationSpec {
    void onPostMigrate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);
}
