package androidx.room;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1 extends Lambda implements oOoXoXO<SupportSQLiteStatement, Object> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1() {
        super(1);
    }

    @OXOo.oOoXoXO
    public final Object invoke(@OOXIXo SupportSQLiteStatement supportSQLiteStatement) {
        IIX0o.x0xO0oo(supportSQLiteStatement, "statement");
        supportSQLiteStatement.execute();
        return null;
    }
}
