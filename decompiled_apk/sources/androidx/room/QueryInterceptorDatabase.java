package androidx.room;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nQueryInterceptorDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QueryInterceptorDatabase.kt\nandroidx/room/QueryInterceptorDatabase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,146:1\n1#2:147\n37#3,2:148\n*S KotlinDebug\n*F\n+ 1 QueryInterceptorDatabase.kt\nandroidx/room/QueryInterceptorDatabase\n*L\n143#1:148,2\n*E\n"})
/* loaded from: classes.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {

    @OXOo.OOXIXo
    private final SupportSQLiteDatabase delegate;

    @OXOo.OOXIXo
    private final RoomDatabase.QueryCallback queryCallback;

    @OXOo.OOXIXo
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(@OXOo.OOXIXo SupportSQLiteDatabase delegate, @OXOo.OOXIXo Executor queryCallbackExecutor, @OXOo.OOXIXo RoomDatabase.QueryCallback queryCallback) {
        IIX0o.x0xO0oo(delegate, "delegate");
        IIX0o.x0xO0oo(queryCallbackExecutor, "queryCallbackExecutor");
        IIX0o.x0xO0oo(queryCallback, "queryCallback");
        this.delegate = delegate;
        this.queryCallbackExecutor = queryCallbackExecutor;
        this.queryCallback = queryCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransaction$lambda$0(QueryInterceptorDatabase this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endTransaction$lambda$4(QueryInterceptorDatabase this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.queryCallback.onQuery("END TRANSACTION", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execSQL$lambda$10(QueryInterceptorDatabase this$0, String sql) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(sql, "$sql");
        this$0.queryCallback.onQuery(sql, CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execSQL$lambda$12(QueryInterceptorDatabase this$0, String sql, List inputArguments) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(sql, "$sql");
        IIX0o.x0xO0oo(inputArguments, "$inputArguments");
        this$0.queryCallback.onQuery(sql, inputArguments);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$6(QueryInterceptorDatabase this$0, String query) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(query, "$query");
        this$0.queryCallback.onQuery(query, CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$7(QueryInterceptorDatabase this$0, String query, Object[] bindArgs) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(query, "$query");
        IIX0o.x0xO0oo(bindArgs, "$bindArgs");
        this$0.queryCallback.onQuery(query, ArraysKt___ArraysKt.IoXOX(bindArgs));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$8(QueryInterceptorDatabase this$0, SupportSQLiteQuery query, QueryInterceptorProgram queryInterceptorProgram) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(query, "$query");
        IIX0o.x0xO0oo(queryInterceptorProgram, "$queryInterceptorProgram");
        this$0.queryCallback.onQuery(query.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$9(QueryInterceptorDatabase this$0, SupportSQLiteQuery query, QueryInterceptorProgram queryInterceptorProgram) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(query, "$query");
        IIX0o.x0xO0oo(queryInterceptorProgram, "$queryInterceptorProgram");
        this$0.queryCallback.onQuery(query.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.queryCallback.onQuery("TRANSACTION SUCCESSFUL", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.oOoXoXO
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.beginTransaction$lambda$0(QueryInterceptorDatabase.this);
            }
        });
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.x0XOIxOo
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase.this);
            }
        });
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(@OXOo.OOXIXo SQLiteTransactionListener transactionListener) {
        IIX0o.x0xO0oo(transactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.IXxxXO
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(QueryInterceptorDatabase.this);
            }
        });
        this.delegate.beginTransactionWithListener(transactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(@OXOo.OOXIXo SQLiteTransactionListener transactionListener) {
        IIX0o.x0xO0oo(transactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.II0XooXoX
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase.this);
            }
        });
        this.delegate.beginTransactionWithListenerNonExclusive(transactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @OXOo.OOXIXo
    public SupportSQLiteStatement compileStatement(@OXOo.OOXIXo String sql) {
        IIX0o.x0xO0oo(sql, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(sql), sql, this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(@OXOo.OOXIXo String table, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Object[] objArr) {
        IIX0o.x0xO0oo(table, "table");
        return this.delegate.delete(table, str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.Oxx0IOOO
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.endTransaction$lambda$4(QueryInterceptorDatabase.this);
            }
        });
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(@OXOo.OOXIXo String sql, @OXOo.oOoXoXO @SuppressLint({"ArrayReturn"}) Object[] objArr) {
        IIX0o.x0xO0oo(sql, "sql");
        this.delegate.execPerConnectionSQL(sql, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@OXOo.OOXIXo final String sql) {
        IIX0o.x0xO0oo(sql, "sql");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.OOXIXo
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.execSQL$lambda$10(QueryInterceptorDatabase.this, sql);
            }
        });
        this.delegate.execSQL(sql);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @OXOo.oOoXoXO
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @OXOo.oOoXoXO
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(@OXOo.OOXIXo String table, int i, @OXOo.OOXIXo ContentValues values) {
        IIX0o.x0xO0oo(table, "table");
        IIX0o.x0xO0oo(values, "values");
        return this.delegate.insert(table, i, values);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i) {
        return this.delegate.needUpgrade(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @OXOo.OOXIXo
    public Cursor query(@OXOo.OOXIXo final String query) {
        IIX0o.x0xO0oo(query, "query");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.xxIXOIIO
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.query$lambda$6(QueryInterceptorDatabase.this, query);
            }
        });
        return this.delegate.query(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z) {
        this.delegate.setForeignKeyConstraintsEnabled(z);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(@OXOo.OOXIXo Locale locale) {
        IIX0o.x0xO0oo(locale, "locale");
        this.delegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i) {
        this.delegate.setMaxSqlCacheSize(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j) {
        return this.delegate.setMaximumSize(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j) {
        this.delegate.setPageSize(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.ooOOo0oXI
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(QueryInterceptorDatabase.this);
            }
        });
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i) {
        this.delegate.setVersion(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(@OXOo.OOXIXo String table, int i, @OXOo.OOXIXo ContentValues values, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Object[] objArr) {
        IIX0o.x0xO0oo(table, "table");
        IIX0o.x0xO0oo(values, "values");
        return this.delegate.update(table, i, values, str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j) {
        return this.delegate.yieldIfContendedSafely(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@OXOo.OOXIXo final String sql, @OXOo.OOXIXo Object[] bindArgs) {
        IIX0o.x0xO0oo(sql, "sql");
        IIX0o.x0xO0oo(bindArgs, "bindArgs");
        List xxIXOIIO2 = kotlin.collections.oI0IIXIo.xxIXOIIO();
        kotlin.collections.OxI.xxIO(xxIXOIIO2, bindArgs);
        final List oIX0oI2 = kotlin.collections.oI0IIXIo.oIX0oI(xxIXOIIO2);
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.oO
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.execSQL$lambda$12(QueryInterceptorDatabase.this, sql, oIX0oI2);
            }
        });
        this.delegate.execSQL(sql, oIX0oI2.toArray(new Object[0]));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @OXOo.OOXIXo
    public Cursor query(@OXOo.OOXIXo final String query, @OXOo.OOXIXo final Object[] bindArgs) {
        IIX0o.x0xO0oo(query, "query");
        IIX0o.x0xO0oo(bindArgs, "bindArgs");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.xoIox
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.query$lambda$7(QueryInterceptorDatabase.this, query, bindArgs);
            }
        });
        return this.delegate.query(query, bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @OXOo.OOXIXo
    public Cursor query(@OXOo.OOXIXo final SupportSQLiteQuery query) {
        IIX0o.x0xO0oo(query, "query");
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.x0xO0oo
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.query$lambda$8(QueryInterceptorDatabase.this, query, queryInterceptorProgram);
            }
        });
        return this.delegate.query(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @OXOo.OOXIXo
    public Cursor query(@OXOo.OOXIXo final SupportSQLiteQuery query, @OXOo.oOoXoXO CancellationSignal cancellationSignal) {
        IIX0o.x0xO0oo(query, "query");
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.Oxx0xo
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.query$lambda$9(QueryInterceptorDatabase.this, query, queryInterceptorProgram);
            }
        });
        return this.delegate.query(query);
    }
}
