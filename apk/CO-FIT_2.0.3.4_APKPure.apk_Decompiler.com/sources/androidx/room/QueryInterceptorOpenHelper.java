package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;

public final class QueryInterceptorOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    @OOXIXo
    private final SupportSQLiteOpenHelper delegate;
    @OOXIXo
    private final RoomDatabase.QueryCallback queryCallback;
    @OOXIXo
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelper(@OOXIXo SupportSQLiteOpenHelper supportSQLiteOpenHelper, @OOXIXo Executor executor, @OOXIXo RoomDatabase.QueryCallback queryCallback2) {
        IIX0o.x0xO0oo(supportSQLiteOpenHelper, "delegate");
        IIX0o.x0xO0oo(executor, "queryCallbackExecutor");
        IIX0o.x0xO0oo(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteOpenHelper;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback2;
    }

    public void close() {
        this.delegate.close();
    }

    @oOoXoXO
    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    @OOXIXo
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @OOXIXo
    public SupportSQLiteDatabase getReadableDatabase() {
        return new QueryInterceptorDatabase(getDelegate().getReadableDatabase(), this.queryCallbackExecutor, this.queryCallback);
    }

    @OOXIXo
    public SupportSQLiteDatabase getWritableDatabase() {
        return new QueryInterceptorDatabase(getDelegate().getWritableDatabase(), this.queryCallbackExecutor, this.queryCallback);
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.delegate.setWriteAheadLoggingEnabled(z);
    }
}
