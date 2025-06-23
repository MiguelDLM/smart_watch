package androidx.room.migration;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.oXIO0o0XI;

final class MigrationImpl extends Migration {
    @OOXIXo
    private final oOoXoXO<SupportSQLiteDatabase, oXIO0o0XI> migrateCallback;

    public MigrationImpl(int i, int i2, @OOXIXo oOoXoXO<? super SupportSQLiteDatabase, oXIO0o0XI> oooxoxo) {
        super(i, i2);
        this.migrateCallback = oooxoxo;
    }

    @OOXIXo
    public final oOoXoXO<SupportSQLiteDatabase, oXIO0o0XI> getMigrateCallback() {
        return this.migrateCallback;
    }

    public void migrate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        this.migrateCallback.invoke(supportSQLiteDatabase);
    }
}
