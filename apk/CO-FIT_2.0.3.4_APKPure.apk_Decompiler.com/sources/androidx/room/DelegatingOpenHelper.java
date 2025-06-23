package androidx.room;

import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

public interface DelegatingOpenHelper {
    @OOXIXo
    SupportSQLiteOpenHelper getDelegate();
}
