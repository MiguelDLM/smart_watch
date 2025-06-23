package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

public final /* synthetic */ class oIX0oI implements SQLiteDatabase.CursorFactory {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f488oIX0oI;

    public /* synthetic */ oIX0oI(SupportSQLiteQuery supportSQLiteQuery) {
        this.f488oIX0oI = supportSQLiteQuery;
    }

    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return FrameworkSQLiteDatabase.query$lambda$1(this.f488oIX0oI, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }
}
