package androidx.room;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;

public final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    @OOXIXo
    private final SupportSQLiteOpenHelper.Factory delegate;
    @OOXIXo
    private final RoomDatabase.QueryCallback queryCallback;
    @OOXIXo
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelperFactory(@OOXIXo SupportSQLiteOpenHelper.Factory factory, @OOXIXo Executor executor, @OOXIXo RoomDatabase.QueryCallback queryCallback2) {
        IIX0o.x0xO0oo(factory, "delegate");
        IIX0o.x0xO0oo(executor, "queryCallbackExecutor");
        IIX0o.x0xO0oo(queryCallback2, "queryCallback");
        this.delegate = factory;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback2;
    }

    @OOXIXo
    public SupportSQLiteOpenHelper create(@OOXIXo SupportSQLiteOpenHelper.Configuration configuration) {
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        return new QueryInterceptorOpenHelper(this.delegate.create(configuration), this.queryCallbackExecutor, this.queryCallback);
    }
}
