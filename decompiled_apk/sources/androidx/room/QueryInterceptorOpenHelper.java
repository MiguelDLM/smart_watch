package androidx.room;

import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class QueryInterceptorOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    @OXOo.OOXIXo
    private final SupportSQLiteOpenHelper delegate;

    @OXOo.OOXIXo
    private final RoomDatabase.QueryCallback queryCallback;

    @OXOo.OOXIXo
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelper(@OXOo.OOXIXo SupportSQLiteOpenHelper delegate, @OXOo.OOXIXo Executor queryCallbackExecutor, @OXOo.OOXIXo RoomDatabase.QueryCallback queryCallback) {
        IIX0o.x0xO0oo(delegate, "delegate");
        IIX0o.x0xO0oo(queryCallbackExecutor, "queryCallbackExecutor");
        IIX0o.x0xO0oo(queryCallback, "queryCallback");
        this.delegate = delegate;
        this.queryCallbackExecutor = queryCallbackExecutor;
        this.queryCallback = queryCallback;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @OXOo.oOoXoXO
    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @OXOo.OOXIXo
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @OXOo.OOXIXo
    public SupportSQLiteDatabase getReadableDatabase() {
        return new QueryInterceptorDatabase(getDelegate().getReadableDatabase(), this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @OXOo.OOXIXo
    public SupportSQLiteDatabase getWritableDatabase() {
        return new QueryInterceptorDatabase(getDelegate().getWritableDatabase(), this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.delegate.setWriteAheadLoggingEnabled(z);
    }
}
