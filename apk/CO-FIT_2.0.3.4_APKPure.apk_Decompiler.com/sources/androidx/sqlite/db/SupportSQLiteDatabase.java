package androidx.sqlite.db;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;

public interface SupportSQLiteDatabase extends Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    void beginTransactionWithListener(@OOXIXo SQLiteTransactionListener sQLiteTransactionListener);

    void beginTransactionWithListenerNonExclusive(@OOXIXo SQLiteTransactionListener sQLiteTransactionListener);

    @OOXIXo
    SupportSQLiteStatement compileStatement(@OOXIXo String str);

    int delete(@OOXIXo String str, @oOoXoXO String str2, @oOoXoXO Object[] objArr);

    @RequiresApi(api = 16)
    void disableWriteAheadLogging();

    boolean enableWriteAheadLogging();

    void endTransaction();

    void execPerConnectionSQL(@OOXIXo String str, @SuppressLint({"ArrayReturn"}) @oOoXoXO Object[] objArr);

    void execSQL(@OOXIXo String str) throws SQLException;

    void execSQL(@OOXIXo String str, @OOXIXo Object[] objArr) throws SQLException;

    @oOoXoXO
    List<Pair<String, String>> getAttachedDbs();

    long getMaximumSize();

    long getPageSize();

    @oOoXoXO
    String getPath();

    int getVersion();

    boolean inTransaction();

    long insert(@OOXIXo String str, int i, @OOXIXo ContentValues contentValues) throws SQLException;

    boolean isDatabaseIntegrityOk();

    boolean isDbLockedByCurrentThread();

    boolean isExecPerConnectionSQLSupported();

    boolean isOpen();

    boolean isReadOnly();

    @RequiresApi(api = 16)
    boolean isWriteAheadLoggingEnabled();

    boolean needUpgrade(int i);

    @OOXIXo
    Cursor query(@OOXIXo SupportSQLiteQuery supportSQLiteQuery);

    @RequiresApi(api = 16)
    @OOXIXo
    Cursor query(@OOXIXo SupportSQLiteQuery supportSQLiteQuery, @oOoXoXO CancellationSignal cancellationSignal);

    @OOXIXo
    Cursor query(@OOXIXo String str);

    @OOXIXo
    Cursor query(@OOXIXo String str, @OOXIXo Object[] objArr);

    @RequiresApi(api = 16)
    void setForeignKeyConstraintsEnabled(boolean z);

    void setLocale(@OOXIXo Locale locale);

    void setMaxSqlCacheSize(int i);

    long setMaximumSize(long j);

    void setPageSize(long j);

    void setTransactionSuccessful();

    void setVersion(int i);

    int update(@OOXIXo String str, int i, @OOXIXo ContentValues contentValues, @oOoXoXO String str2, @oOoXoXO Object[] objArr);

    boolean yieldIfContendedSafely();

    boolean yieldIfContendedSafely(long j);
}
