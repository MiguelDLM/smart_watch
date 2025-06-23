package androidx.sqlite.db.framework;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import com.facebook.appevents.UserDataStore;
import com.huawei.openalliance.ad.constant.bn;
import java.util.UUID;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private static final String TAG = "SupportSQLite";
    /* access modifiers changed from: private */
    public final boolean allowDataLossOnRecovery;
    /* access modifiers changed from: private */
    @OOXIXo
    public final SupportSQLiteOpenHelper.Callback callback;
    /* access modifiers changed from: private */
    @OOXIXo
    public final Context context;
    @OOXIXo
    private final X0IIOO<OpenHelper> lazyDelegate;
    /* access modifiers changed from: private */
    @oOoXoXO
    public final String name;
    /* access modifiers changed from: private */
    public final boolean useNoBackupDirectory;
    /* access modifiers changed from: private */
    public boolean writeAheadLoggingEnabled;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

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

    public static final class OpenHelper extends SQLiteOpenHelper {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
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

        public static final class CallbackException extends RuntimeException {
            @OOXIXo
            private final CallbackName callbackName;
            @OOXIXo
            private final Throwable cause;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CallbackException(@OOXIXo CallbackName callbackName2, @OOXIXo Throwable th) {
                super(th);
                IIX0o.x0xO0oo(callbackName2, "callbackName");
                IIX0o.x0xO0oo(th, "cause");
                this.callbackName = callbackName2;
                this.cause = th;
            }

            @OOXIXo
            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @OOXIXo
            public Throwable getCause() {
                return this.cause;
            }
        }

        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        @XX({"SMAP\nFrameworkSQLiteOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrameworkSQLiteOpenHelper.kt\nandroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,342:1\n1#2:343\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final FrameworkSQLiteDatabase getWrappedDb(@OOXIXo DBRefHolder dBRefHolder, @OOXIXo SQLiteDatabase sQLiteDatabase) {
                IIX0o.x0xO0oo(dBRefHolder, "refHolder");
                IIX0o.x0xO0oo(sQLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase db = dBRefHolder.getDb();
                if (db != null && db.isDelegate(sQLiteDatabase)) {
                    return db;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sQLiteDatabase);
                dBRefHolder.setDb(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }

            private Companion() {
            }
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName[] r0 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_CONFIGURE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_UPGRADE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_DOWNGRADE     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_OPEN     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.WhenMappings.<clinit>():void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenHelper(@OOXIXo Context context2, @oOoXoXO String str, @OOXIXo DBRefHolder dBRefHolder, @OOXIXo SupportSQLiteOpenHelper.Callback callback2, boolean z) {
            super(context2, str, (SQLiteDatabase.CursorFactory) null, callback2.version, new I0Io(callback2, dBRefHolder));
            IIX0o.x0xO0oo(context2, bn.f.o);
            IIX0o.x0xO0oo(dBRefHolder, "dbRef");
            IIX0o.x0xO0oo(callback2, bn.f.L);
            this.context = context2;
            this.dbRef = dBRefHolder;
            this.callback = callback2;
            this.allowDataLossOnRecovery = z;
            if (str == null) {
                str = UUID.randomUUID().toString();
                IIX0o.oO(str, "randomUUID().toString()");
            }
            this.lock = new ProcessLock(str, context2.getCacheDir(), false);
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback callback2, DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
            IIX0o.x0xO0oo(callback2, "$callback");
            IIX0o.x0xO0oo(dBRefHolder, "$dbRef");
            Companion companion = Companion;
            IIX0o.oO(sQLiteDatabase, "dbObj");
            callback2.onCorruption(companion.getWrappedDb(dBRefHolder, sQLiteDatabase));
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

        /* JADX WARNING: Can't wrap try/catch for region: R(7:12|11|13|14|15|16|17) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0042 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final android.database.sqlite.SQLiteDatabase innerGetDatabase(boolean r5) {
            /*
                r4 = this;
                java.lang.String r0 = r4.getDatabaseName()
                boolean r1 = r4.opened
                if (r0 == 0) goto L_0x0035
                if (r1 != 0) goto L_0x0035
                android.content.Context r1 = r4.context
                java.io.File r1 = r1.getDatabasePath(r0)
                java.io.File r1 = r1.getParentFile()
                if (r1 == 0) goto L_0x0035
                r1.mkdirs()
                boolean r2 = r1.isDirectory()
                if (r2 != 0) goto L_0x0035
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Invalid database parent file, not a directory: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "SupportSQLite"
                android.util.Log.w(r2, r1)
            L_0x0035:
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ all -> 0x003a }
                return r5
            L_0x003a:
                super.close()
                r1 = 500(0x1f4, double:2.47E-321)
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x0042 }
            L_0x0042:
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ all -> 0x0047 }
                return r5
            L_0x0047:
                r1 = move-exception
                super.close()
                boolean r2 = r1 instanceof androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackException
                if (r2 == 0) goto L_0x0074
                androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackException r1 = (androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackException) r1
                java.lang.Throwable r2 = r1.getCause()
                androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = r1.getCallbackName()
                int[] r3 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.WhenMappings.$EnumSwitchMapping$0
                int r1 = r1.ordinal()
                r1 = r3[r1]
                r3 = 1
                if (r1 == r3) goto L_0x0073
                r3 = 2
                if (r1 == r3) goto L_0x0073
                r3 = 3
                if (r1 == r3) goto L_0x0073
                r3 = 4
                if (r1 == r3) goto L_0x0073
                boolean r1 = r2 instanceof android.database.sqlite.SQLiteException
                if (r1 == 0) goto L_0x0072
                goto L_0x007e
            L_0x0072:
                throw r2
            L_0x0073:
                throw r2
            L_0x0074:
                boolean r2 = r1 instanceof android.database.sqlite.SQLiteException
                if (r2 == 0) goto L_0x008f
                if (r0 == 0) goto L_0x008e
                boolean r2 = r4.allowDataLossOnRecovery
                if (r2 == 0) goto L_0x008e
            L_0x007e:
                android.content.Context r1 = r4.context
                r1.deleteDatabase(r0)
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ CallbackException -> 0x0088 }
                return r5
            L_0x0088:
                r5 = move-exception
                java.lang.Throwable r5 = r5.getCause()
                throw r5
            L_0x008e:
                throw r1
            L_0x008f:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.innerGetDatabase(boolean):android.database.sqlite.SQLiteDatabase");
        }

        public void close() {
            try {
                ProcessLock.lock$default(this.lock, false, 1, (Object) null);
                super.close();
                this.dbRef.setDb((FrameworkSQLiteDatabase) null);
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
                if (this.opened || getDatabaseName() == null) {
                    z2 = false;
                } else {
                    z2 = true;
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
        public final FrameworkSQLiteDatabase getWrappedDb(@OOXIXo SQLiteDatabase sQLiteDatabase) {
            IIX0o.x0xO0oo(sQLiteDatabase, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, sQLiteDatabase);
        }

        public void onConfigure(@OOXIXo SQLiteDatabase sQLiteDatabase) {
            IIX0o.x0xO0oo(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            if (!this.migrated && this.callback.version != sQLiteDatabase.getVersion()) {
                sQLiteDatabase.setMaxSqlCacheSize(1);
            }
            try {
                this.callback.onConfigure(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        public void onCreate(@OOXIXo SQLiteDatabase sQLiteDatabase) {
            IIX0o.x0xO0oo(sQLiteDatabase, "sqLiteDatabase");
            try {
                this.callback.onCreate(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        public void onDowngrade(@OOXIXo SQLiteDatabase sQLiteDatabase, int i, int i2) {
            IIX0o.x0xO0oo(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        public void onOpen(@OOXIXo SQLiteDatabase sQLiteDatabase) {
            IIX0o.x0xO0oo(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        public void onUpgrade(@OOXIXo SQLiteDatabase sQLiteDatabase, int i, int i2) {
            IIX0o.x0xO0oo(sQLiteDatabase, "sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public FrameworkSQLiteOpenHelper(@OOXIXo Context context2, @oOoXoXO String str, @OOXIXo SupportSQLiteOpenHelper.Callback callback2) {
        this(context2, str, callback2, false, false, 24, (IIXOooo) null);
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(callback2, bn.f.L);
    }

    private final OpenHelper getDelegate() {
        return this.lazyDelegate.getValue();
    }

    private static Object getDelegate$delegate(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        return frameworkSQLiteOpenHelper.lazyDelegate;
    }

    public void close() {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().close();
        }
    }

    @oOoXoXO
    public String getDatabaseName() {
        return this.name;
    }

    @OOXIXo
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    @OOXIXo
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        if (this.lazyDelegate.isInitialized()) {
            SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(getDelegate(), z);
        }
        this.writeAheadLoggingEnabled = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public FrameworkSQLiteOpenHelper(@OOXIXo Context context2, @oOoXoXO String str, @OOXIXo SupportSQLiteOpenHelper.Callback callback2, boolean z) {
        this(context2, str, callback2, z, false, 16, (IIXOooo) null);
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(callback2, bn.f.L);
    }

    @xoIox
    public FrameworkSQLiteOpenHelper(@OOXIXo Context context2, @oOoXoXO String str, @OOXIXo SupportSQLiteOpenHelper.Callback callback2, boolean z, boolean z2) {
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(callback2, bn.f.L);
        this.context = context2;
        this.name = str;
        this.callback = callback2;
        this.useNoBackupDirectory = z;
        this.allowDataLossOnRecovery = z2;
        this.lazyDelegate = XIxXXX0x0.oIX0oI(new FrameworkSQLiteOpenHelper$lazyDelegate$1(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FrameworkSQLiteOpenHelper(Context context2, String str, SupportSQLiteOpenHelper.Callback callback2, boolean z, boolean z2, int i, IIXOooo iIXOooo) {
        this(context2, str, callback2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }
}
