package androidx.sqlite.db.framework;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.util.UUID;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

/* loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String TAG = "SupportSQLite";
    private final boolean allowDataLossOnRecovery;

    @OOXIXo
    private final SupportSQLiteOpenHelper.Callback callback;

    @OOXIXo
    private final Context context;

    @OOXIXo
    private final X0IIOO<OpenHelper> lazyDelegate;

    @oOoXoXO
    private final String name;
    private final boolean useNoBackupDirectory;
    private boolean writeAheadLoggingEnabled;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class DBRefHolder {

        @oOoXoXO
        private FrameworkSQLiteDatabase db;

        public DBRefHolder(@oOoXoXO FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }

        @oOoXoXO
        public final FrameworkSQLiteDatabase getDb() {
            return this.db;
        }

        public final void setDb(@oOoXoXO FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }
    }

    /* loaded from: classes.dex */
    public static final class OpenHelper extends SQLiteOpenHelper {

        @OOXIXo
        public static final Companion Companion = new Companion(null);
        private final boolean allowDataLossOnRecovery;

        @OOXIXo
        private final SupportSQLiteOpenHelper.Callback callback;

        @OOXIXo
        private final Context context;

        @OOXIXo
        private final DBRefHolder dbRef;

        @OOXIXo
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        /* loaded from: classes.dex */
        public static final class CallbackException extends RuntimeException {

            @OOXIXo
            private final CallbackName callbackName;

            @OOXIXo
            private final Throwable cause;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(@OOXIXo CallbackName callbackName, @OOXIXo Throwable cause) {
                super(cause);
                IIX0o.x0xO0oo(callbackName, "callbackName");
                IIX0o.x0xO0oo(cause, "cause");
                this.callbackName = callbackName;
                this.cause = cause;
            }

            @OOXIXo
            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            @OOXIXo
            public Throwable getCause() {
                return this.cause;
            }
        }

        /* loaded from: classes.dex */
        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        @XX({"SMAP\nFrameworkSQLiteOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrameworkSQLiteOpenHelper.kt\nandroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,342:1\n1#2:343\n*E\n"})
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final FrameworkSQLiteDatabase getWrappedDb(@OOXIXo DBRefHolder refHolder, @OOXIXo SQLiteDatabase sqLiteDatabase) {
                IIX0o.x0xO0oo(refHolder, "refHolder");
                IIX0o.x0xO0oo(sqLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase db = refHolder.getDb();
                if (db == null || !db.isDelegate(sqLiteDatabase)) {
                    FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sqLiteDatabase);
                    refHolder.setDb(frameworkSQLiteDatabase);
                    return frameworkSQLiteDatabase;
                }
                return db;
            }

            private Companion() {
            }
        }

        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CallbackName.values().length];
                try {
                    iArr[CallbackName.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CallbackName.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CallbackName.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CallbackName.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CallbackName.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(@OOXIXo Context context, @oOoXoXO String str, @OOXIXo final DBRefHolder dbRef, @OOXIXo final SupportSQLiteOpenHelper.Callback callback, boolean z) {
            super(context, str, null, callback.version, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.I0Io
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteOpenHelper.OpenHelper._init_$lambda$0(SupportSQLiteOpenHelper.Callback.this, dbRef, sQLiteDatabase);
                }
            });
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(dbRef, "dbRef");
            IIX0o.x0xO0oo(callback, "callback");
            this.context = context;
            this.dbRef = dbRef;
            this.callback = callback;
            this.allowDataLossOnRecovery = z;
            if (str == null) {
                str = UUID.randomUUID().toString();
                IIX0o.oO(str, "randomUUID().toString()");
            }
            this.lock = new ProcessLock(str, context.getCacheDir(), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback callback, DBRefHolder dbRef, SQLiteDatabase dbObj) {
            IIX0o.x0xO0oo(callback, "$callback");
            IIX0o.x0xO0oo(dbRef, "$dbRef");
            Companion companion = Companion;
            IIX0o.oO(dbObj, "dbObj");
            callback.onCorruption(companion.getWrappedDb(dbRef, dbObj));
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean z) {
            if (z) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                IIX0o.oO(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            IIX0o.oO(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        private final SQLiteDatabase innerGetDatabase(boolean z) {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z2 = this.opened;
            if (databaseName != null && !z2 && (parentFile = this.context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w(FrameworkSQLiteOpenHelper.TAG, "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return getWritableOrReadableDatabase(z);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return getWritableOrReadableDatabase(z);
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = th;
                        Throwable cause = callbackException.getCause();
                        int i = WhenMappings.$EnumSwitchMapping$0[callbackException.getCallbackName().ordinal()];
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (i != 4) {
                                        if (!(cause instanceof SQLiteException)) {
                                            throw cause;
                                        }
                                    } else {
                                        throw cause;
                                    }
                                } else {
                                    throw cause;
                                }
                            } else {
                                throw cause;
                            }
                        } else {
                            throw cause;
                        }
                    } else if (th instanceof SQLiteException) {
                        if (databaseName == null || !this.allowDataLossOnRecovery) {
                            throw th;
                        }
                    } else {
                        throw th;
                    }
                    this.context.deleteDatabase(databaseName);
                    try {
                        return getWritableOrReadableDatabase(z);
                    } catch (CallbackException e) {
                        throw e.getCause();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                ProcessLock.lock$default(this.lock, false, 1, null);
                super.close();
                this.dbRef.setDb(null);
                this.opened = false;
            } finally {
                this.lock.unlock();
            }
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        @OOXIXo
        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        @OOXIXo
        public final Context getContext() {
            return this.context;
        }

        @OOXIXo
        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        @OOXIXo
        public final SupportSQLiteDatabase getSupportDatabase(boolean z) {
            boolean z2;
            try {
                ProcessLock processLock = this.lock;
                if (!this.opened && getDatabaseName() != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                processLock.lock(z2);
                this.migrated = false;
                SQLiteDatabase innerGetDatabase = innerGetDatabase(z);
                if (this.migrated) {
                    close();
                    SupportSQLiteDatabase supportDatabase = getSupportDatabase(z);
                    this.lock.unlock();
                    return supportDatabase;
                }
                FrameworkSQLiteDatabase wrappedDb = getWrappedDb(innerGetDatabase);
                this.lock.unlock();
                return wrappedDb;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        @OOXIXo
        public final FrameworkSQLiteDatabase getWrappedDb(@OOXIXo SQLiteDatabase sqLiteDatabase) {
            IIX0o.x0xO0oo(sqLiteDatabase, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, sqLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(@OOXIXo SQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
            if (!this.migrated && this.callback.version != db.getVersion()) {
                db.setMaxSqlCacheSize(1);
            }
            try {
                this.callback.onConfigure(getWrappedDb(db));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(@OOXIXo SQLiteDatabase sqLiteDatabase) {
            IIX0o.x0xO0oo(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.callback.onCreate(getWrappedDb(sqLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(@OOXIXo SQLiteDatabase db, int i, int i2) {
            IIX0o.x0xO0oo(db, "db");
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(db), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(@OOXIXo SQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(db));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(@OOXIXo SQLiteDatabase sqLiteDatabase, int i, int i2) {
            IIX0o.x0xO0oo(sqLiteDatabase, "sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sqLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public FrameworkSQLiteOpenHelper(@OOXIXo Context context, @oOoXoXO String str, @OOXIXo SupportSQLiteOpenHelper.Callback callback) {
        this(context, str, callback, false, false, 24, null);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
    }

    private final OpenHelper getDelegate() {
        return this.lazyDelegate.getValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @oOoXoXO
    public String getDatabaseName() {
        return this.name;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @OOXIXo
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @OOXIXo
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        if (this.lazyDelegate.isInitialized()) {
            SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(getDelegate(), z);
        }
        this.writeAheadLoggingEnabled = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public FrameworkSQLiteOpenHelper(@OOXIXo Context context, @oOoXoXO String str, @OOXIXo SupportSQLiteOpenHelper.Callback callback, boolean z) {
        this(context, str, callback, z, false, 16, null);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
    }

    @xoIox
    public FrameworkSQLiteOpenHelper(@OOXIXo Context context, @oOoXoXO String str, @OOXIXo SupportSQLiteOpenHelper.Callback callback, boolean z, boolean z2) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
        this.context = context;
        this.name = str;
        this.callback = callback;
        this.useNoBackupDirectory = z;
        this.allowDataLossOnRecovery = z2;
        this.lazyDelegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<OpenHelper>() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$lazyDelegate$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
                FrameworkSQLiteOpenHelper.OpenHelper openHelper;
                Context context2;
                String str2;
                SupportSQLiteOpenHelper.Callback callback2;
                boolean z3;
                boolean z4;
                String str3;
                boolean z5;
                Context context3;
                String str4;
                Context context4;
                SupportSQLiteOpenHelper.Callback callback3;
                boolean z6;
                if (Build.VERSION.SDK_INT >= 23) {
                    str3 = FrameworkSQLiteOpenHelper.this.name;
                    if (str3 != null) {
                        z5 = FrameworkSQLiteOpenHelper.this.useNoBackupDirectory;
                        if (z5) {
                            context3 = FrameworkSQLiteOpenHelper.this.context;
                            File noBackupFilesDir = SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(context3);
                            str4 = FrameworkSQLiteOpenHelper.this.name;
                            File file = new File(noBackupFilesDir, str4);
                            context4 = FrameworkSQLiteOpenHelper.this.context;
                            String absolutePath = file.getAbsolutePath();
                            FrameworkSQLiteOpenHelper.DBRefHolder dBRefHolder = new FrameworkSQLiteOpenHelper.DBRefHolder(null);
                            callback3 = FrameworkSQLiteOpenHelper.this.callback;
                            z6 = FrameworkSQLiteOpenHelper.this.allowDataLossOnRecovery;
                            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(context4, absolutePath, dBRefHolder, callback3, z6);
                            z4 = FrameworkSQLiteOpenHelper.this.writeAheadLoggingEnabled;
                            SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(openHelper, z4);
                            return openHelper;
                        }
                    }
                }
                context2 = FrameworkSQLiteOpenHelper.this.context;
                str2 = FrameworkSQLiteOpenHelper.this.name;
                FrameworkSQLiteOpenHelper.DBRefHolder dBRefHolder2 = new FrameworkSQLiteOpenHelper.DBRefHolder(null);
                callback2 = FrameworkSQLiteOpenHelper.this.callback;
                z3 = FrameworkSQLiteOpenHelper.this.allowDataLossOnRecovery;
                openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(context2, str2, dBRefHolder2, callback2, z3);
                z4 = FrameworkSQLiteOpenHelper.this.writeAheadLoggingEnabled;
                SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(openHelper, z4);
                return openHelper;
            }
        });
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z, boolean z2, int i, IIXOooo iIXOooo) {
        this(context, str, callback, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }
}
