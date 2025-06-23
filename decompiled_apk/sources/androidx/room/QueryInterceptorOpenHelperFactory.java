package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    @OXOo.OOXIXo
    private final SupportSQLiteOpenHelper.Factory delegate;

    @OXOo.OOXIXo
    private final RoomDatabase.QueryCallback queryCallback;

    @OXOo.OOXIXo
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelperFactory(@OXOo.OOXIXo SupportSQLiteOpenHelper.Factory delegate, @OXOo.OOXIXo Executor queryCallbackExecutor, @OXOo.OOXIXo RoomDatabase.QueryCallback queryCallback) {
        IIX0o.x0xO0oo(delegate, "delegate");
        IIX0o.x0xO0oo(queryCallbackExecutor, "queryCallbackExecutor");
        IIX0o.x0xO0oo(queryCallback, "queryCallback");
        this.delegate = delegate;
        this.queryCallbackExecutor = queryCallbackExecutor;
        this.queryCallback = queryCallback;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @OXOo.OOXIXo
    public SupportSQLiteOpenHelper create(@OXOo.OOXIXo SupportSQLiteOpenHelper.Configuration configuration) {
        IIX0o.x0xO0oo(configuration, "configuration");
        return new QueryInterceptorOpenHelper(this.delegate.create(configuration), this.queryCallbackExecutor, this.queryCallback);
    }
}
