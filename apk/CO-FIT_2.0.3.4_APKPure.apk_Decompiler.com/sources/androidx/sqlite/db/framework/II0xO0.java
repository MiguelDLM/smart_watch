package androidx.sqlite.db.framework;

import Oox.Oxx0xo;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

public final /* synthetic */ class II0xO0 implements SQLiteDatabase.CursorFactory {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Oxx0xo f487oIX0oI;

    public /* synthetic */ II0xO0(Oxx0xo oxx0xo) {
        this.f487oIX0oI = oxx0xo;
    }

    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return FrameworkSQLiteDatabase.query$lambda$0(this.f487oIX0oI, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }
}
