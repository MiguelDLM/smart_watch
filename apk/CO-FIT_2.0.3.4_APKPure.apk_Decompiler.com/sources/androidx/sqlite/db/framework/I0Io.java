package androidx.sqlite.db.framework;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;

public final /* synthetic */ class I0Io implements DatabaseErrorHandler {

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ FrameworkSQLiteOpenHelper.DBRefHolder f485II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteOpenHelper.Callback f486oIX0oI;

    public /* synthetic */ I0Io(SupportSQLiteOpenHelper.Callback callback, FrameworkSQLiteOpenHelper.DBRefHolder dBRefHolder) {
        this.f486oIX0oI = callback;
        this.f485II0xO0 = dBRefHolder;
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        FrameworkSQLiteOpenHelper.OpenHelper._init_$lambda$0(this.f486oIX0oI, this.f485II0xO0, sQLiteDatabase);
    }
}
