package androidx.sqlite.db.framework;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.Oxx0xo;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class FrameworkSQLiteDatabase$query$cursorFactory$1 extends Lambda implements Oxx0xo<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor> {
    final /* synthetic */ SupportSQLiteQuery $query;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteDatabase$query$cursorFactory$1(SupportSQLiteQuery supportSQLiteQuery) {
        super(4);
        this.$query = supportSQLiteQuery;
    }

    @OOXIXo
    public final SQLiteCursor invoke(@oOoXoXO SQLiteDatabase sQLiteDatabase, @oOoXoXO SQLiteCursorDriver sQLiteCursorDriver, @oOoXoXO String str, @oOoXoXO SQLiteQuery sQLiteQuery) {
        SupportSQLiteQuery supportSQLiteQuery = this.$query;
        IIX0o.ooOOo0oXI(sQLiteQuery);
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }
}
