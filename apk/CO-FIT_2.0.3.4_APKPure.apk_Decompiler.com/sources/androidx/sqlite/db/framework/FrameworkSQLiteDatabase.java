package androidx.sqlite.db.framework;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.Oxx0xo;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import o0oIxXOx.oO;

@XX({"SMAP\nFrameworkSQLiteDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrameworkSQLiteDatabase.kt\nandroidx/sqlite/db/framework/FrameworkSQLiteDatabase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,336:1\n1#2:337\n*E\n"})
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    @OOXIXo
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    @OOXIXo
    private final SQLiteDatabase delegate;

    @RequiresApi(30)
    public static final class Api30Impl {
        @OOXIXo
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        @DoNotInline
        public final void execPerConnectionSQL(@OOXIXo SQLiteDatabase sQLiteDatabase, @OOXIXo String str, @oOoXoXO Object[] objArr) {
            IIX0o.x0xO0oo(sQLiteDatabase, "sQLiteDatabase");
            IIX0o.x0xO0oo(str, "sql");
            sQLiteDatabase.execPerConnectionSQL(str, objArr);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public FrameworkSQLiteDatabase(@OOXIXo SQLiteDatabase sQLiteDatabase) {
        IIX0o.x0xO0oo(sQLiteDatabase, "delegate");
        this.delegate = sQLiteDatabase;
    }

    /* access modifiers changed from: private */
    public static final Cursor query$lambda$0(Oxx0xo oxx0xo, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        IIX0o.x0xO0oo(oxx0xo, "$tmp0");
        return (Cursor) oxx0xo.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* access modifiers changed from: private */
    public static final Cursor query$lambda$1(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        IIX0o.x0xO0oo(supportSQLiteQuery, "$query");
        IIX0o.ooOOo0oXI(sQLiteQuery);
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(@OOXIXo SQLiteTransactionListener sQLiteTransactionListener) {
        IIX0o.x0xO0oo(sQLiteTransactionListener, "transactionListener");
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(@OOXIXo SQLiteTransactionListener sQLiteTransactionListener) {
        IIX0o.x0xO0oo(sQLiteTransactionListener, "transactionListener");
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    @OOXIXo
    public SupportSQLiteStatement compileStatement(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "sql");
        SQLiteStatement compileStatement = this.delegate.compileStatement(str);
        IIX0o.oO(compileStatement, "delegate.compileStatement(sql)");
        return new FrameworkSQLiteStatement(compileStatement);
    }

    public int delete(@OOXIXo String str, @oOoXoXO String str2, @oOoXoXO Object[] objArr) {
        IIX0o.x0xO0oo(str, "table");
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(str);
        if (!(str2 == null || str2.length() == 0)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement compileStatement = compileStatement(sb2);
        SimpleSQLiteQuery.Companion.bind(compileStatement, objArr);
        return compileStatement.executeUpdateDelete();
    }

    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.delegate);
    }

    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.delegate.endTransaction();
    }

    public void execPerConnectionSQL(@OOXIXo String str, @oOoXoXO Object[] objArr) {
        IIX0o.x0xO0oo(str, "sql");
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, str, objArr);
            return;
        }
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + i);
    }

    public void execSQL(@OOXIXo String str) throws SQLException {
        IIX0o.x0xO0oo(str, "sql");
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

    public long insert(@OOXIXo String str, int i, @OOXIXo ContentValues contentValues) throws SQLException {
        IIX0o.x0xO0oo(str, "table");
        IIX0o.x0xO0oo(contentValues, "values");
        return this.delegate.insertWithOnConflict(str, (String) null, contentValues, i);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public final boolean isDelegate(@OOXIXo SQLiteDatabase sQLiteDatabase) {
        IIX0o.x0xO0oo(sQLiteDatabase, "sqLiteDatabase");
        return IIX0o.Oxx0IOOO(this.delegate, sQLiteDatabase);
    }

    public boolean isExecPerConnectionSQLSupported() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.delegate);
    }

    public boolean needUpgrade(int i) {
        return this.delegate.needUpgrade(i);
    }

    @OOXIXo
    public Cursor query(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "query");
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str));
    }

    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.delegate, z);
    }

    public void setLocale(@OOXIXo Locale locale) {
        IIX0o.x0xO0oo(locale, oO.f20818X0o0xo);
        this.delegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i) {
        this.delegate.setMaxSqlCacheSize(i);
    }

    /* renamed from: setMaximumSize  reason: collision with other method in class */
    public void m27setMaximumSize(long j) {
        this.delegate.setMaximumSize(j);
    }

    public void setPageSize(long j) {
        this.delegate.setPageSize(j);
    }

    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    public void setVersion(int i) {
        this.delegate.setVersion(i);
    }

    public int update(@OOXIXo String str, int i, @OOXIXo ContentValues contentValues, @oOoXoXO String str2, @oOoXoXO Object[] objArr) {
        int i2;
        String str3;
        IIX0o.x0xO0oo(str, "table");
        IIX0o.x0xO0oo(contentValues, "values");
        if (contentValues.size() != 0) {
            int size = contentValues.size();
            if (objArr == null) {
                i2 = size;
            } else {
                i2 = objArr.length + size;
            }
            Object[] objArr2 = new Object[i2];
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ");
            sb.append(CONFLICT_VALUES[i]);
            sb.append(str);
            sb.append(" SET ");
            int i3 = 0;
            for (String next : contentValues.keySet()) {
                if (i3 > 0) {
                    str3 = ",";
                } else {
                    str3 = "";
                }
                sb.append(str3);
                sb.append(next);
                objArr2[i3] = contentValues.get(next);
                sb.append("=?");
                i3++;
            }
            if (objArr != null) {
                for (int i4 = size; i4 < i2; i4++) {
                    objArr2[i4] = objArr[i4 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
            SupportSQLiteStatement compileStatement = compileStatement(sb2);
            SimpleSQLiteQuery.Companion.bind(compileStatement, objArr2);
            return compileStatement.executeUpdateDelete();
        }
        throw new IllegalArgumentException("Empty values");
    }

    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    public void execSQL(@OOXIXo String str, @OOXIXo Object[] objArr) throws SQLException {
        IIX0o.x0xO0oo(str, "sql");
        IIX0o.x0xO0oo(objArr, "bindArgs");
        this.delegate.execSQL(str, objArr);
    }

    @OOXIXo
    public Cursor query(@OOXIXo String str, @OOXIXo Object[] objArr) {
        IIX0o.x0xO0oo(str, "query");
        IIX0o.x0xO0oo(objArr, "bindArgs");
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public long setMaximumSize(long j) {
        this.delegate.setMaximumSize(j);
        return this.delegate.getMaximumSize();
    }

    public boolean yieldIfContendedSafely(long j) {
        return this.delegate.yieldIfContendedSafely(j);
    }

    @OOXIXo
    public Cursor query(@OOXIXo SupportSQLiteQuery supportSQLiteQuery) {
        IIX0o.x0xO0oo(supportSQLiteQuery, "query");
        Cursor rawQueryWithFactory = this.delegate.rawQueryWithFactory(new II0xO0(new FrameworkSQLiteDatabase$query$cursorFactory$1(supportSQLiteQuery)), supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, (String) null);
        IIX0o.oO(rawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return rawQueryWithFactory;
    }

    @RequiresApi(16)
    @OOXIXo
    public Cursor query(@OOXIXo SupportSQLiteQuery supportSQLiteQuery, @oOoXoXO CancellationSignal cancellationSignal) {
        IIX0o.x0xO0oo(supportSQLiteQuery, "query");
        SQLiteDatabase sQLiteDatabase = this.delegate;
        String sql = supportSQLiteQuery.getSql();
        String[] strArr = EMPTY_STRING_ARRAY;
        IIX0o.ooOOo0oXI(cancellationSignal);
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(sQLiteDatabase, sql, strArr, (String) null, cancellationSignal, new oIX0oI(supportSQLiteQuery));
    }
}
