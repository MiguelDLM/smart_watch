package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO.oIX0oI;
import XO0OX.XO;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import o0oIxXOx.oO;

public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    @XO
    @OOXIXo
    public final AutoCloser autoCloser;
    @OOXIXo
    private final AutoClosingSupportSQLiteDatabase autoClosingDb;
    @OOXIXo
    private final SupportSQLiteOpenHelper delegate;

    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        @OOXIXo
        private final AutoCloser autoCloser;

        public AutoClosingSupportSQLiteDatabase(@OOXIXo AutoCloser autoCloser2) {
            IIX0o.x0xO0oo(autoCloser2, "autoCloser");
            this.autoCloser = autoCloser2;
        }

        public void beginTransaction() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        public void beginTransactionNonExclusive() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        public void beginTransactionWithListener(@OOXIXo SQLiteTransactionListener sQLiteTransactionListener) {
            IIX0o.x0xO0oo(sQLiteTransactionListener, "transactionListener");
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(sQLiteTransactionListener);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        public void beginTransactionWithListenerNonExclusive(@OOXIXo SQLiteTransactionListener sQLiteTransactionListener) {
            IIX0o.x0xO0oo(sQLiteTransactionListener, "transactionListener");
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        public void close() throws IOException {
            this.autoCloser.closeDatabaseIfOpen();
        }

        @OOXIXo
        public SupportSQLiteStatement compileStatement(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "sql");
            return new AutoClosingSupportSqliteStatement(str, this.autoCloser);
        }

        public int delete(@OOXIXo String str, @oOoXoXO String str2, @oOoXoXO Object[] objArr) {
            IIX0o.x0xO0oo(str, "table");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$delete$1(str, str2, objArr))).intValue();
        }

        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        public void endTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() != null) {
                try {
                    SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
                    IIX0o.ooOOo0oXI(delegateDatabase$room_runtime_release);
                    delegateDatabase$room_runtime_release.endTransaction();
                } finally {
                    this.autoCloser.decrementCountAndScheduleClose();
                }
            } else {
                throw new IllegalStateException("End transaction called but delegateDb is null");
            }
        }

        public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
            oIX0oI.oIX0oI(this, str, objArr);
        }

        public void execSQL(@OOXIXo String str) throws SQLException {
            IIX0o.x0xO0oo(str, "sql");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(str));
        }

        @oOoXoXO
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1.INSTANCE);
        }

        public long getMaximumSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1.INSTANCE)).longValue();
        }

        public long getPageSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1.INSTANCE)).longValue();
        }

        @oOoXoXO
        public String getPath() {
            return (String) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1.INSTANCE);
        }

        public int getVersion() {
            return ((Number) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1.INSTANCE)).intValue();
        }

        public boolean inTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        public long insert(@OOXIXo String str, int i, @OOXIXo ContentValues contentValues) throws SQLException {
            IIX0o.x0xO0oo(str, "table");
            IIX0o.x0xO0oo(contentValues, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1(str, i, contentValues))).longValue();
        }

        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDatabaseIntegrityOk$1.INSTANCE)).booleanValue();
        }

        public boolean isDbLockedByCurrentThread() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDbLockedByCurrentThread$1.INSTANCE)).booleanValue();
        }

        public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
            return oIX0oI.II0xO0(this);
        }

        public boolean isOpen() {
            SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (delegateDatabase$room_runtime_release == null) {
                return false;
            }
            return delegateDatabase$room_runtime_release.isOpen();
        }

        public boolean isReadOnly() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1.INSTANCE)).booleanValue();
        }

        @RequiresApi(api = 16)
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1.INSTANCE)).booleanValue();
        }

        public boolean needUpgrade(int i) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(i))).booleanValue();
        }

        public final void pokeOpen() {
            this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1.INSTANCE);
        }

        @OOXIXo
        public Cursor query(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(str), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @RequiresApi(api = 16)
        public void setForeignKeyConstraintsEnabled(boolean z) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setForeignKeyConstraintsEnabled$1(z));
        }

        public void setLocale(@OOXIXo Locale locale) {
            IIX0o.x0xO0oo(locale, oO.f20818X0o0xo);
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(locale));
        }

        public void setMaxSqlCacheSize(int i) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaxSqlCacheSize$1(i));
        }

        public long setMaximumSize(long j) {
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(j))).longValue();
        }

        public void setPageSize(long j) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2(j));
        }

        public void setTransactionSuccessful() {
            oXIO0o0XI oxio0o0xi;
            SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (delegateDatabase$room_runtime_release != null) {
                delegateDatabase$room_runtime_release.setTransactionSuccessful();
                oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } else {
                oxio0o0xi = null;
            }
            if (oxio0o0xi == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
            }
        }

        public void setVersion(int i) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2(i));
        }

        public int update(@OOXIXo String str, int i, @OOXIXo ContentValues contentValues, @oOoXoXO String str2, @oOoXoXO Object[] objArr) {
            IIX0o.x0xO0oo(str, "table");
            IIX0o.x0xO0oo(contentValues, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$update$1(str, i, contentValues, str2, objArr))).intValue();
        }

        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.INSTANCE)).booleanValue();
        }

        public void execSQL(@OOXIXo String str, @OOXIXo Object[] objArr) throws SQLException {
            IIX0o.x0xO0oo(str, "sql");
            IIX0o.x0xO0oo(objArr, "bindArgs");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2(str, objArr));
        }

        public boolean yieldIfContendedSafely(long j) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2.INSTANCE)).booleanValue();
        }

        @OOXIXo
        public Cursor query(@OOXIXo String str, @OOXIXo Object[] objArr) {
            IIX0o.x0xO0oo(str, "query");
            IIX0o.x0xO0oo(objArr, "bindArgs");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(str, objArr), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @OOXIXo
        public Cursor query(@OOXIXo SupportSQLiteQuery supportSQLiteQuery) {
            IIX0o.x0xO0oo(supportSQLiteQuery, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @RequiresApi(api = 24)
        @OOXIXo
        public Cursor query(@OOXIXo SupportSQLiteQuery supportSQLiteQuery, @oOoXoXO CancellationSignal cancellationSignal) {
            IIX0o.x0xO0oo(supportSQLiteQuery, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery, cancellationSignal), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }
    }

    @XX({"SMAP\nAutoClosingRoomOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoClosingRoomOpenHelper.kt\nandroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,571:1\n1864#2,3:572\n*S KotlinDebug\n*F\n+ 1 AutoClosingRoomOpenHelper.kt\nandroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement\n*L\n478#1:572,3\n*E\n"})
    public static final class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        @OOXIXo
        private final AutoCloser autoCloser;
        @OOXIXo
        private final ArrayList<Object> binds = new ArrayList<>();
        /* access modifiers changed from: private */
        @OOXIXo
        public final String sql;

        public AutoClosingSupportSqliteStatement(@OOXIXo String str, @OOXIXo AutoCloser autoCloser2) {
            IIX0o.x0xO0oo(str, "sql");
            IIX0o.x0xO0oo(autoCloser2, "autoCloser");
            this.sql = str;
            this.autoCloser = autoCloser2;
        }

        /* access modifiers changed from: private */
        public final void doBinds(SupportSQLiteStatement supportSQLiteStatement) {
            Iterator<T> it = this.binds.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                Object obj = this.binds.get(i);
                if (obj == null) {
                    supportSQLiteStatement.bindNull(i2);
                } else if (obj instanceof Long) {
                    supportSQLiteStatement.bindLong(i2, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    supportSQLiteStatement.bindDouble(i2, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    supportSQLiteStatement.bindString(i2, (String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.bindBlob(i2, (byte[]) obj);
                }
                i = i2;
            }
        }

        private final <T> T executeSqliteStatementWithRefCount(Oox.oOoXoXO<? super SupportSQLiteStatement, ? extends T> oooxoxo) {
            return this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(this, oooxoxo));
        }

        private final void saveBinds(int i, Object obj) {
            int size;
            int i2 = i - 1;
            if (i2 >= this.binds.size() && (size = this.binds.size()) <= i2) {
                while (true) {
                    this.binds.add((Object) null);
                    if (size == i2) {
                        break;
                    }
                    size++;
                }
            }
            this.binds.set(i2, obj);
        }

        public void bindBlob(int i, @OOXIXo byte[] bArr) {
            IIX0o.x0xO0oo(bArr, "value");
            saveBinds(i, bArr);
        }

        public void bindDouble(int i, double d) {
            saveBinds(i, Double.valueOf(d));
        }

        public void bindLong(int i, long j) {
            saveBinds(i, Long.valueOf(j));
        }

        public void bindNull(int i) {
            saveBinds(i, (Object) null);
        }

        public void bindString(int i, @OOXIXo String str) {
            IIX0o.x0xO0oo(str, "value");
            saveBinds(i, str);
        }

        public void clearBindings() {
            this.binds.clear();
        }

        public void close() throws IOException {
        }

        public void execute() {
            executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1.INSTANCE);
        }

        public long executeInsert() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1.INSTANCE)).longValue();
        }

        public int executeUpdateDelete() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1.INSTANCE)).intValue();
        }

        public long simpleQueryForLong() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1.INSTANCE)).longValue();
        }

        @oOoXoXO
        public String simpleQueryForString() {
            return (String) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1.INSTANCE);
        }
    }

    public static final class KeepAliveCursor implements Cursor {
        @OOXIXo
        private final AutoCloser autoCloser;
        @OOXIXo
        private final Cursor delegate;

        public KeepAliveCursor(@OOXIXo Cursor cursor, @OOXIXo AutoCloser autoCloser2) {
            IIX0o.x0xO0oo(cursor, "delegate");
            IIX0o.x0xO0oo(autoCloser2, "autoCloser");
            this.delegate = cursor;
            this.autoCloser = autoCloser2;
        }

        public void close() {
            this.delegate.close();
            this.autoCloser.decrementCountAndScheduleClose();
        }

        public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
            this.delegate.copyStringToBuffer(i, charArrayBuffer);
        }

        @kotlin.OOXIXo(message = "Deprecated in Java")
        public void deactivate() {
            this.delegate.deactivate();
        }

        public byte[] getBlob(int i) {
            return this.delegate.getBlob(i);
        }

        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        public int getColumnIndex(String str) {
            return this.delegate.getColumnIndex(str);
        }

        public int getColumnIndexOrThrow(String str) {
            return this.delegate.getColumnIndexOrThrow(str);
        }

        public String getColumnName(int i) {
            return this.delegate.getColumnName(i);
        }

        public String[] getColumnNames() {
            return this.delegate.getColumnNames();
        }

        public int getCount() {
            return this.delegate.getCount();
        }

        public double getDouble(int i) {
            return this.delegate.getDouble(i);
        }

        public Bundle getExtras() {
            return this.delegate.getExtras();
        }

        public float getFloat(int i) {
            return this.delegate.getFloat(i);
        }

        public int getInt(int i) {
            return this.delegate.getInt(i);
        }

        public long getLong(int i) {
            return this.delegate.getLong(i);
        }

        @RequiresApi(api = 19)
        @OOXIXo
        public Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.getNotificationUri(this.delegate);
        }

        @RequiresApi(api = 29)
        @OOXIXo
        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.getNotificationUris(this.delegate);
        }

        public int getPosition() {
            return this.delegate.getPosition();
        }

        public short getShort(int i) {
            return this.delegate.getShort(i);
        }

        public String getString(int i) {
            return this.delegate.getString(i);
        }

        public int getType(int i) {
            return this.delegate.getType(i);
        }

        public boolean getWantsAllOnMoveCalls() {
            return this.delegate.getWantsAllOnMoveCalls();
        }

        public boolean isAfterLast() {
            return this.delegate.isAfterLast();
        }

        public boolean isBeforeFirst() {
            return this.delegate.isBeforeFirst();
        }

        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        public boolean isFirst() {
            return this.delegate.isFirst();
        }

        public boolean isLast() {
            return this.delegate.isLast();
        }

        public boolean isNull(int i) {
            return this.delegate.isNull(i);
        }

        public boolean move(int i) {
            return this.delegate.move(i);
        }

        public boolean moveToFirst() {
            return this.delegate.moveToFirst();
        }

        public boolean moveToLast() {
            return this.delegate.moveToLast();
        }

        public boolean moveToNext() {
            return this.delegate.moveToNext();
        }

        public boolean moveToPosition(int i) {
            return this.delegate.moveToPosition(i);
        }

        public boolean moveToPrevious() {
            return this.delegate.moveToPrevious();
        }

        public void registerContentObserver(ContentObserver contentObserver) {
            this.delegate.registerContentObserver(contentObserver);
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.registerDataSetObserver(dataSetObserver);
        }

        @kotlin.OOXIXo(message = "Deprecated in Java")
        public boolean requery() {
            return this.delegate.requery();
        }

        public Bundle respond(Bundle bundle) {
            return this.delegate.respond(bundle);
        }

        @RequiresApi(api = 23)
        public void setExtras(@OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "extras");
            SupportSQLiteCompat.Api23Impl.setExtras(this.delegate, bundle);
        }

        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.delegate.setNotificationUri(contentResolver, uri);
        }

        @RequiresApi(api = 29)
        public void setNotificationUris(@OOXIXo ContentResolver contentResolver, @OOXIXo List<? extends Uri> list) {
            IIX0o.x0xO0oo(contentResolver, "cr");
            IIX0o.x0xO0oo(list, "uris");
            SupportSQLiteCompat.Api29Impl.setNotificationUris(this.delegate, contentResolver, list);
        }

        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.delegate.unregisterContentObserver(contentObserver);
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(@OOXIXo SupportSQLiteOpenHelper supportSQLiteOpenHelper, @OOXIXo AutoCloser autoCloser2) {
        IIX0o.x0xO0oo(supportSQLiteOpenHelper, "delegate");
        IIX0o.x0xO0oo(autoCloser2, "autoCloser");
        this.delegate = supportSQLiteOpenHelper;
        this.autoCloser = autoCloser2;
        autoCloser2.init(getDelegate());
        this.autoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser2);
    }

    public void close() {
        this.autoClosingDb.close();
    }

    @oOoXoXO
    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    @OOXIXo
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @RequiresApi(api = 24)
    @OOXIXo
    public SupportSQLiteDatabase getReadableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @RequiresApi(api = 24)
    @OOXIXo
    public SupportSQLiteDatabase getWritableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.delegate.setWriteAheadLoggingEnabled(z);
    }
}
