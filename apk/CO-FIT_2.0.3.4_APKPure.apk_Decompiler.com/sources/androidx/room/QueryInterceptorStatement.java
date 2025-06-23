package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;

public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    @OOXIXo
    private final List<Object> bindArgsCache = new ArrayList();
    @OOXIXo
    private final SupportSQLiteStatement delegate;
    @OOXIXo
    private final RoomDatabase.QueryCallback queryCallback;
    @OOXIXo
    private final Executor queryCallbackExecutor;
    @OOXIXo
    private final String sqlStatement;

    public QueryInterceptorStatement(@OOXIXo SupportSQLiteStatement supportSQLiteStatement, @OOXIXo String str, @OOXIXo Executor executor, @OOXIXo RoomDatabase.QueryCallback queryCallback2) {
        IIX0o.x0xO0oo(supportSQLiteStatement, "delegate");
        IIX0o.x0xO0oo(str, "sqlStatement");
        IIX0o.x0xO0oo(executor, "queryCallbackExecutor");
        IIX0o.x0xO0oo(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteStatement;
        this.sqlStatement = str;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback2;
    }

    /* access modifiers changed from: private */
    public static final void execute$lambda$0(QueryInterceptorStatement queryInterceptorStatement) {
        IIX0o.x0xO0oo(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    /* access modifiers changed from: private */
    public static final void executeInsert$lambda$2(QueryInterceptorStatement queryInterceptorStatement) {
        IIX0o.x0xO0oo(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    /* access modifiers changed from: private */
    public static final void executeUpdateDelete$lambda$1(QueryInterceptorStatement queryInterceptorStatement) {
        IIX0o.x0xO0oo(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    private final void saveArgsToCache(int i, Object obj) {
        int i2 = i - 1;
        if (i2 >= this.bindArgsCache.size()) {
            int size = (i2 - this.bindArgsCache.size()) + 1;
            for (int i3 = 0; i3 < size; i3++) {
                this.bindArgsCache.add((Object) null);
            }
        }
        this.bindArgsCache.set(i2, obj);
    }

    /* access modifiers changed from: private */
    public static final void simpleQueryForLong$lambda$3(QueryInterceptorStatement queryInterceptorStatement) {
        IIX0o.x0xO0oo(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    /* access modifiers changed from: private */
    public static final void simpleQueryForString$lambda$4(QueryInterceptorStatement queryInterceptorStatement) {
        IIX0o.x0xO0oo(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    public void bindBlob(int i, @OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "value");
        saveArgsToCache(i, bArr);
        this.delegate.bindBlob(i, bArr);
    }

    public void bindDouble(int i, double d) {
        saveArgsToCache(i, Double.valueOf(d));
        this.delegate.bindDouble(i, d);
    }

    public void bindLong(int i, long j) {
        saveArgsToCache(i, Long.valueOf(j));
        this.delegate.bindLong(i, j);
    }

    public void bindNull(int i) {
        saveArgsToCache(i, (Object) null);
        this.delegate.bindNull(i);
    }

    public void bindString(int i, @OOXIXo String str) {
        IIX0o.x0xO0oo(str, "value");
        saveArgsToCache(i, str);
        this.delegate.bindString(i, str);
    }

    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    public void close() {
        this.delegate.close();
    }

    public void execute() {
        this.queryCallbackExecutor.execute(new xoXoI(this));
        this.delegate.execute();
    }

    public long executeInsert() {
        this.queryCallbackExecutor.execute(new OxxIIOOXO(this));
        return this.delegate.executeInsert();
    }

    public int executeUpdateDelete() {
        this.queryCallbackExecutor.execute(new o00(this));
        return this.delegate.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        this.queryCallbackExecutor.execute(new oI0IIXIo(this));
        return this.delegate.simpleQueryForLong();
    }

    @oOoXoXO
    public String simpleQueryForString() {
        this.queryCallbackExecutor.execute(new IIXOooo(this));
        return this.delegate.simpleQueryForString();
    }
}
