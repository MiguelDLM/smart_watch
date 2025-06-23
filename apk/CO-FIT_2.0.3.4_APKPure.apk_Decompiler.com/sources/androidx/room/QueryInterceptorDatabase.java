package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
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
import kotlin.collections.OxI;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import o0oIxXOx.oO;

@XX({"SMAP\nQueryInterceptorDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QueryInterceptorDatabase.kt\nandroidx/room/QueryInterceptorDatabase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,146:1\n1#2:147\n37#3,2:148\n*S KotlinDebug\n*F\n+ 1 QueryInterceptorDatabase.kt\nandroidx/room/QueryInterceptorDatabase\n*L\n143#1:148,2\n*E\n"})
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    @OOXIXo
    private final SupportSQLiteDatabase delegate;
    @OOXIXo
    private final RoomDatabase.QueryCallback queryCallback;
    @OOXIXo
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, @OOXIXo Executor executor, @OOXIXo RoomDatabase.QueryCallback queryCallback2) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, "delegate");
        IIX0o.x0xO0oo(executor, "queryCallbackExecutor");
        IIX0o.x0xO0oo(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteDatabase;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback2;
    }

    /* access modifiers changed from: private */
    public static final void beginTransaction$lambda$0(QueryInterceptorDatabase queryInterceptorDatabase) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* access modifiers changed from: private */
    public static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase queryInterceptorDatabase) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* access modifiers changed from: private */
    public static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase queryInterceptorDatabase) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* access modifiers changed from: private */
    public static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase queryInterceptorDatabase) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* access modifiers changed from: private */
    public static final void endTransaction$lambda$4(QueryInterceptorDatabase queryInterceptorDatabase) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("END TRANSACTION", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* access modifiers changed from: private */
    public static final void execSQL$lambda$10(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        IIX0o.x0xO0oo(str, "$sql");
        queryInterceptorDatabase.queryCallback.onQuery(str, CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* access modifiers changed from: private */
    public static final void execSQL$lambda$12(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        IIX0o.x0xO0oo(str, "$sql");
        IIX0o.x0xO0oo(list, "$inputArguments");
        queryInterceptorDatabase.queryCallback.onQuery(str, list);
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$6(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        IIX0o.x0xO0oo(str, "$query");
        queryInterceptorDatabase.queryCallback.onQuery(str, CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$7(QueryInterceptorDatabase queryInterceptorDatabase, String str, Object[] objArr) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        IIX0o.x0xO0oo(str, "$query");
        IIX0o.x0xO0oo(objArr, "$bindArgs");
        queryInterceptorDatabase.queryCallback.onQuery(str, ArraysKt___ArraysKt.IoXOX(objArr));
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$8(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        IIX0o.x0xO0oo(supportSQLiteQuery, "$query");
        IIX0o.x0xO0oo(queryInterceptorProgram, "$queryInterceptorProgram");
        queryInterceptorDatabase.queryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$9(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        IIX0o.x0xO0oo(supportSQLiteQuery, "$query");
        IIX0o.x0xO0oo(queryInterceptorProgram, "$queryInterceptorProgram");
        queryInterceptorDatabase.queryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* access modifiers changed from: private */
    public static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase queryInterceptorDatabase) {
        IIX0o.x0xO0oo(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("TRANSACTION SUCCESSFUL", CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new oOoXoXO(this));
        this.delegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new x0XOIxOo(this));
        this.delegate.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(@OOXIXo SQLiteTransactionListener sQLiteTransactionListener) {
        IIX0o.x0xO0oo(sQLiteTransactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new IXxxXO(this));
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(@OOXIXo SQLiteTransactionListener sQLiteTransactionListener) {
        IIX0o.x0xO0oo(sQLiteTransactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new II0XooXoX(this));
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() {
        this.delegate.close();
    }

    @OOXIXo
    public SupportSQLiteStatement compileStatement(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(str), str, this.queryCallbackExecutor, this.queryCallback);
    }

    public int delete(@OOXIXo String str, @oOoXoXO String str2, @oOoXoXO Object[] objArr) {
        IIX0o.x0xO0oo(str, "table");
        return this.delegate.delete(str, str2, objArr);
    }

    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.queryCallbackExecutor.execute(new Oxx0IOOO(this));
        this.delegate.endTransaction();
    }

    public void execPerConnectionSQL(@OOXIXo String str, @SuppressLint({"ArrayReturn"}) @oOoXoXO Object[] objArr) {
        IIX0o.x0xO0oo(str, "sql");
        this.delegate.execPerConnectionSQL(str, objArr);
    }

    public void execSQL(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "sql");
        this.queryCallbackExecutor.execute(new OOXIXo(this, str));
        this.delegate.execSQL(str);
    }

    @oOoXoXO
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @oOoXoXO
    public String getPath() {
        return this.delegate.getPath();
    }

    public int getVersion() {
        return this.delegate.getVersion();
    }

    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    public long insert(@OOXIXo String str, int i, @OOXIXo ContentValues contentValues) {
        IIX0o.x0xO0oo(str, "table");
        IIX0o.x0xO0oo(contentValues, "values");
        return this.delegate.insert(str, i, contentValues);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    public boolean needUpgrade(int i) {
        return this.delegate.needUpgrade(i);
    }

    @OOXIXo
    public Cursor query(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "query");
        this.queryCallbackExecutor.execute(new xxIXOIIO(this, str));
        return this.delegate.query(str);
    }

    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z) {
        this.delegate.setForeignKeyConstraintsEnabled(z);
    }

    public void setLocale(@OOXIXo Locale locale) {
        IIX0o.x0xO0oo(locale, oO.f20818X0o0xo);
        this.delegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i) {
        this.delegate.setMaxSqlCacheSize(i);
    }

    public long setMaximumSize(long j) {
        return this.delegate.setMaximumSize(j);
    }

    public void setPageSize(long j) {
        this.delegate.setPageSize(j);
    }

    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new ooOOo0oXI(this));
        this.delegate.setTransactionSuccessful();
    }

    public void setVersion(int i) {
        this.delegate.setVersion(i);
    }

    public int update(@OOXIXo String str, int i, @OOXIXo ContentValues contentValues, @oOoXoXO String str2, @oOoXoXO Object[] objArr) {
        IIX0o.x0xO0oo(str, "table");
        IIX0o.x0xO0oo(contentValues, "values");
        return this.delegate.update(str, i, contentValues, str2, objArr);
    }

    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    public boolean yieldIfContendedSafely(long j) {
        return this.delegate.yieldIfContendedSafely(j);
    }

    public void execSQL(@OOXIXo String str, @OOXIXo Object[] objArr) {
        IIX0o.x0xO0oo(str, "sql");
        IIX0o.x0xO0oo(objArr, "bindArgs");
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        OxI.xxIO(xxIXOIIO2, objArr);
        List oIX0oI2 = oI0IIXIo.oIX0oI(xxIXOIIO2);
        this.queryCallbackExecutor.execute(new oO(this, str, oIX0oI2));
        this.delegate.execSQL(str, oIX0oI2.toArray(new Object[0]));
    }

    @OOXIXo
    public Cursor query(@OOXIXo String str, @OOXIXo Object[] objArr) {
        IIX0o.x0xO0oo(str, "query");
        IIX0o.x0xO0oo(objArr, "bindArgs");
        this.queryCallbackExecutor.execute(new xoIox(this, str, objArr));
        return this.delegate.query(str, objArr);
    }

    @OOXIXo
    public Cursor query(@OOXIXo SupportSQLiteQuery supportSQLiteQuery) {
        IIX0o.x0xO0oo(supportSQLiteQuery, "query");
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new x0xO0oo(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.delegate.query(supportSQLiteQuery);
    }

    @OOXIXo
    public Cursor query(@OOXIXo SupportSQLiteQuery supportSQLiteQuery, @oOoXoXO CancellationSignal cancellationSignal) {
        IIX0o.x0xO0oo(supportSQLiteQuery, "query");
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new Oxx0xo(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.delegate.query(supportSQLiteQuery);
    }
}
