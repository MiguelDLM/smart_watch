package androidx.room.migration;

import OXOo.OOXIXo;
import XO0OX.XO;
import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class Migration {
    @XO
    public final int endVersion;
    @XO
    public final int startVersion;

    public Migration(int i, int i2) {
        this.startVersion = i;
        this.endVersion = i2;
    }

    public abstract void migrate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);
}
