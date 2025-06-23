package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.oO;
import XO0OX.xoIox;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.appevents.UserDataStore;
import com.huawei.openalliance.ad.constant.bn;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nRoomDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabase\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1548:1\n215#2,2:1549\n*S KotlinDebug\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabase\n*L\n261#1:1549,2\n*E\n"})
public abstract class RoomDatabase {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    @oOoXoXO
    private AutoCloser autoCloser;
    @OOXIXo
    private Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs = new LinkedHashMap();
    @OOXIXo
    private final Map<String, Object> backingFieldMap;
    private SupportSQLiteOpenHelper internalOpenHelper;
    private Executor internalQueryExecutor;
    private Executor internalTransactionExecutor;
    @OOXIXo
    private final InvalidationTracker invalidationTracker = createInvalidationTracker();
    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @XO
    protected List<? extends Callback> mCallbacks;
    @XO
    @oOoXoXO
    protected volatile SupportSQLiteDatabase mDatabase;
    @OOXIXo
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    @OOXIXo
    private final ThreadLocal<Integer> suspendingTransactionId = new ThreadLocal<>();
    @OOXIXo
    private final Map<Class<?>, Object> typeConverters;
    private boolean writeAheadLoggingEnabled;

    @XX({"SMAP\nRoomDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabase$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1548:1\n1#2:1549\n*E\n"})
    public static class Builder<T extends RoomDatabase> {
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;
        @oOoXoXO
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout = -1;
        @OOXIXo
        private List<AutoMigrationSpec> autoMigrationSpecs = new ArrayList();
        @OOXIXo
        private final List<Callback> callbacks = new ArrayList();
        @OOXIXo
        private final Context context;
        @oOoXoXO
        private String copyFromAssetPath;
        @oOoXoXO
        private File copyFromFile;
        @oOoXoXO
        private Callable<InputStream> copyFromInputStream;
        @oOoXoXO
        private SupportSQLiteOpenHelper.Factory factory;
        @OOXIXo
        private JournalMode journalMode = JournalMode.AUTOMATIC;
        @OOXIXo
        private final Class<T> klass;
        @OOXIXo
        private final MigrationContainer migrationContainer = new MigrationContainer();
        @oOoXoXO
        private Set<Integer> migrationStartAndEndVersions;
        @OOXIXo
        private Set<Integer> migrationsNotRequiredFrom = new LinkedHashSet();
        @oOoXoXO
        private Intent multiInstanceInvalidationIntent;
        @oOoXoXO
        private final String name;
        @oOoXoXO
        private PrepackagedDatabaseCallback prepackagedDatabaseCallback;
        @oOoXoXO
        private QueryCallback queryCallback;
        @oOoXoXO
        private Executor queryCallbackExecutor;
        @oOoXoXO
        private Executor queryExecutor;
        private boolean requireMigration = true;
        @oOoXoXO
        private Executor transactionExecutor;
        @OOXIXo
        private final List<Object> typeConverters = new ArrayList();

        public Builder(@OOXIXo Context context2, @OOXIXo Class<T> cls, @oOoXoXO String str) {
            IIX0o.x0xO0oo(context2, bn.f.o);
            IIX0o.x0xO0oo(cls, "klass");
            this.context = context2;
            this.klass = cls;
            this.name = str;
        }

        @OOXIXo
        public Builder<T> addAutoMigrationSpec(@OOXIXo AutoMigrationSpec autoMigrationSpec) {
            IIX0o.x0xO0oo(autoMigrationSpec, "autoMigrationSpec");
            this.autoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        @OOXIXo
        public Builder<T> addCallback(@OOXIXo Callback callback) {
            IIX0o.x0xO0oo(callback, bn.f.L);
            this.callbacks.add(callback);
            return this;
        }

        @OOXIXo
        public Builder<T> addMigrations(@OOXIXo Migration... migrationArr) {
            IIX0o.x0xO0oo(migrationArr, "migrations");
            if (this.migrationStartAndEndVersions == null) {
                this.migrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrationArr) {
                Set<Integer> set = this.migrationStartAndEndVersions;
                IIX0o.ooOOo0oXI(set);
                set.add(Integer.valueOf(migration.startVersion));
                Set<Integer> set2 = this.migrationStartAndEndVersions;
                IIX0o.ooOOo0oXI(set2);
                set2.add(Integer.valueOf(migration.endVersion));
            }
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrationArr, migrationArr.length));
            return this;
        }

        @OOXIXo
        public Builder<T> addTypeConverter(@OOXIXo Object obj) {
            IIX0o.x0xO0oo(obj, "typeConverter");
            this.typeConverters.add(obj);
            return this;
        }

        @OOXIXo
        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        @OOXIXo
        public T build() {
            SQLiteCopyOpenHelperFactory sQLiteCopyOpenHelperFactory;
            int i;
            int i2;
            Executor executor = this.queryExecutor;
            if (executor == null && this.transactionExecutor == null) {
                Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                this.transactionExecutor = iOThreadExecutor;
                this.queryExecutor = iOThreadExecutor;
            } else if (executor != null && this.transactionExecutor == null) {
                this.transactionExecutor = executor;
            } else if (executor == null) {
                this.queryExecutor = this.transactionExecutor;
            }
            Set<Integer> set = this.migrationStartAndEndVersions;
            if (set != null) {
                IIX0o.ooOOo0oXI(set);
                for (Integer intValue : set) {
                    int intValue2 = intValue.intValue();
                    if (this.migrationsNotRequiredFrom.contains(Integer.valueOf(intValue2))) {
                        throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + intValue2).toString());
                    }
                }
            }
            AutoClosingRoomOpenHelperFactory autoClosingRoomOpenHelperFactory = this.factory;
            if (autoClosingRoomOpenHelperFactory == null) {
                autoClosingRoomOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            }
            if (autoClosingRoomOpenHelperFactory != null) {
                if (this.autoCloseTimeout > 0) {
                    if (this.name != null) {
                        long j = this.autoCloseTimeout;
                        TimeUnit timeUnit = this.autoCloseTimeUnit;
                        if (timeUnit != null) {
                            Executor executor2 = this.queryExecutor;
                            if (executor2 != null) {
                                autoClosingRoomOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(autoClosingRoomOpenHelperFactory, new AutoCloser(j, timeUnit, executor2));
                            } else {
                                throw new IllegalArgumentException("Required value was null.");
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                }
                String str = this.copyFromAssetPath;
                if (!(str == null && this.copyFromFile == null && this.copyFromInputStream == null)) {
                    if (this.name != null) {
                        int i3 = 0;
                        if (str == null) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        File file = this.copyFromFile;
                        if (file == null) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        Callable<InputStream> callable = this.copyFromInputStream;
                        if (callable != null) {
                            i3 = 1;
                        }
                        if (i + i2 + i3 == 1) {
                            autoClosingRoomOpenHelperFactory = new SQLiteCopyOpenHelperFactory(str, file, callable, autoClosingRoomOpenHelperFactory);
                        } else {
                            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                }
            } else {
                autoClosingRoomOpenHelperFactory = null;
            }
            if (autoClosingRoomOpenHelperFactory != null) {
                QueryCallback queryCallback2 = this.queryCallback;
                if (queryCallback2 != null) {
                    Executor executor3 = this.queryCallbackExecutor;
                    if (executor3 == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    } else if (queryCallback2 != null) {
                        sQLiteCopyOpenHelperFactory = new QueryInterceptorOpenHelperFactory(autoClosingRoomOpenHelperFactory, executor3, queryCallback2);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                } else {
                    sQLiteCopyOpenHelperFactory = autoClosingRoomOpenHelperFactory;
                }
                Context context2 = this.context;
                String str2 = this.name;
                MigrationContainer migrationContainer2 = this.migrationContainer;
                List<Callback> list = this.callbacks;
                boolean z = this.allowMainThreadQueries;
                JournalMode resolve$room_runtime_release = this.journalMode.resolve$room_runtime_release(context2);
                Executor executor4 = this.queryExecutor;
                if (executor4 != null) {
                    Executor executor5 = this.transactionExecutor;
                    if (executor5 != null) {
                        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context2, str2, (SupportSQLiteOpenHelper.Factory) sQLiteCopyOpenHelperFactory, migrationContainer2, (List<? extends Callback>) list, z, resolve$room_runtime_release, executor4, executor5, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, (List<? extends Object>) this.typeConverters, (List<? extends AutoMigrationSpec>) this.autoMigrationSpecs);
                        T t = (RoomDatabase) Room.getGeneratedImplementation(this.klass, "_Impl");
                        t.init(databaseConfiguration);
                        return t;
                    }
                    throw new IllegalArgumentException("Required value was null.");
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalArgumentException("Required value was null.");
        }

        @OOXIXo
        public Builder<T> createFromAsset(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "databaseFilePath");
            this.copyFromAssetPath = str;
            return this;
        }

        @OOXIXo
        public Builder<T> createFromFile(@OOXIXo File file) {
            IIX0o.x0xO0oo(file, "databaseFile");
            this.copyFromFile = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @OOXIXo
        public Builder<T> createFromInputStream(@OOXIXo Callable<InputStream> callable) {
            IIX0o.x0xO0oo(callable, "inputStreamCallable");
            this.copyFromInputStream = callable;
            return this;
        }

        @OOXIXo
        public Builder<T> enableMultiInstanceInvalidation() {
            Intent intent;
            if (this.name != null) {
                intent = new Intent(this.context, MultiInstanceInvalidationService.class);
            } else {
                intent = null;
            }
            this.multiInstanceInvalidationIntent = intent;
            return this;
        }

        @OOXIXo
        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @OOXIXo
        public Builder<T> fallbackToDestructiveMigrationFrom(@OOXIXo int... iArr) {
            IIX0o.x0xO0oo(iArr, "startVersions");
            for (int valueOf : iArr) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(valueOf));
            }
            return this;
        }

        @OOXIXo
        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @OOXIXo
        public Builder<T> openHelperFactory(@oOoXoXO SupportSQLiteOpenHelper.Factory factory2) {
            this.factory = factory2;
            return this;
        }

        @ExperimentalRoomApi
        @OOXIXo
        public Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long j, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "autoCloseTimeUnit");
            if (j >= 0) {
                this.autoCloseTimeout = j;
                this.autoCloseTimeUnit = timeUnit;
                return this;
            }
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
        }

        @OOXIXo
        public Builder<T> setJournalMode(@OOXIXo JournalMode journalMode2) {
            IIX0o.x0xO0oo(journalMode2, "journalMode");
            this.journalMode = journalMode2;
            return this;
        }

        @ExperimentalRoomApi
        @OOXIXo
        public Builder<T> setMultiInstanceInvalidationServiceIntent(@OOXIXo Intent intent) {
            IIX0o.x0xO0oo(intent, "invalidationServiceIntent");
            if (this.name == null) {
                intent = null;
            }
            this.multiInstanceInvalidationIntent = intent;
            return this;
        }

        @OOXIXo
        public Builder<T> setQueryCallback(@OOXIXo QueryCallback queryCallback2, @OOXIXo Executor executor) {
            IIX0o.x0xO0oo(queryCallback2, "queryCallback");
            IIX0o.x0xO0oo(executor, "executor");
            this.queryCallback = queryCallback2;
            this.queryCallbackExecutor = executor;
            return this;
        }

        @OOXIXo
        public Builder<T> setQueryExecutor(@OOXIXo Executor executor) {
            IIX0o.x0xO0oo(executor, "executor");
            this.queryExecutor = executor;
            return this;
        }

        @OOXIXo
        public Builder<T> setTransactionExecutor(@OOXIXo Executor executor) {
            IIX0o.x0xO0oo(executor, "executor");
            this.transactionExecutor = executor;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @OOXIXo
        public Builder<T> createFromAsset(@OOXIXo String str, @OOXIXo PrepackagedDatabaseCallback prepackagedDatabaseCallback2) {
            IIX0o.x0xO0oo(str, "databaseFilePath");
            IIX0o.x0xO0oo(prepackagedDatabaseCallback2, bn.f.L);
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
            this.copyFromAssetPath = str;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        @OOXIXo
        public Builder<T> createFromFile(@OOXIXo File file, @OOXIXo PrepackagedDatabaseCallback prepackagedDatabaseCallback2) {
            IIX0o.x0xO0oo(file, "databaseFile");
            IIX0o.x0xO0oo(prepackagedDatabaseCallback2, bn.f.L);
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
            this.copyFromFile = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        @OOXIXo
        public Builder<T> createFromInputStream(@OOXIXo Callable<InputStream> callable, @OOXIXo PrepackagedDatabaseCallback prepackagedDatabaseCallback2) {
            IIX0o.x0xO0oo(callable, "inputStreamCallable");
            IIX0o.x0xO0oo(prepackagedDatabaseCallback2, bn.f.L);
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
            this.copyFromInputStream = callable;
            return this;
        }
    }

    public static abstract class Callback {
        public void onCreate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        }

        public void onDestructiveMigration(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        }

        public void onOpen(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private final boolean isLowRamDevice(ActivityManager activityManager) {
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(activityManager);
        }

        @OOXIXo
        public final JournalMode resolve$room_runtime_release(@OOXIXo Context context) {
            ActivityManager activityManager;
            IIX0o.x0xO0oo(context, bn.f.o);
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (systemService instanceof ActivityManager) {
                activityManager = (ActivityManager) systemService;
            } else {
                activityManager = null;
            }
            if (activityManager == null || isLowRamDevice(activityManager)) {
                return TRUNCATE;
            }
            return WRITE_AHEAD_LOGGING;
        }
    }

    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        }
    }

    public interface QueryCallback {
        void onQuery(@OOXIXo String str, @OOXIXo List<? extends Object> list);
    }

    public RoomDatabase() {
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        IIX0o.oO(synchronizedMap, "synchronizedMap(mutableMapOf())");
        this.backingFieldMap = synchronizedMap;
        this.typeConverters = new LinkedHashMap();
    }

    @kotlin.OOXIXo(message = "Will be hidden in a future release.")
    public static /* synthetic */ void getMCallbacks$annotations() {
    }

    @kotlin.OOXIXo(message = "Will be hidden in the next release.")
    public static /* synthetic */ void getMDatabase$annotations() {
    }

    /* access modifiers changed from: private */
    public final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        getInvalidationTracker().syncTriggers$room_runtime_release(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    /* access modifiers changed from: private */
    public final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (!inTransaction()) {
            getInvalidationTracker().refreshVersionsAsync();
        }
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isOpenInternal$annotations() {
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                cancellationSignal = null;
            }
            return roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    private final <T> T unwrapOpenHelper(Class<T> cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return unwrapOpenHelper(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate());
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (!this.allowMainThreadQueries && isMainThread$room_runtime_release()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.suspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @kotlin.OOXIXo(message = "beginTransaction() is deprecated", replaceWith = @kotlin.XX(expression = "runInTransaction(Runnable)", imports = {}))
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 == null) {
            internalBeginTransaction();
        } else {
            autoCloser2.executeRefCountingFunction(new RoomDatabase$beginTransaction$1(this));
        }
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            IIX0o.oO(writeLock, "readWriteLock.writeLock()");
            writeLock.lock();
            try {
                getInvalidationTracker().stopMultiInstanceInvalidation$room_runtime_release();
                getOpenHelper().close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    @OOXIXo
    public SupportSQLiteStatement compileStatement(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(str);
    }

    @OOXIXo
    public abstract InvalidationTracker createInvalidationTracker();

    @OOXIXo
    public abstract SupportSQLiteOpenHelper createOpenHelper(@OOXIXo DatabaseConfiguration databaseConfiguration);

    @kotlin.OOXIXo(message = "endTransaction() is deprecated", replaceWith = @kotlin.XX(expression = "runInTransaction(Runnable)", imports = {}))
    public void endTransaction() {
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 == null) {
            internalEndTransaction();
        } else {
            autoCloser2.executeRefCountingFunction(new RoomDatabase$endTransaction$1(this));
        }
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    @oO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @OOXIXo
    public List<Migration> getAutoMigrations(@OOXIXo Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        IIX0o.x0xO0oo(map, "autoMigrationSpecs");
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    @OOXIXo
    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
        IIX0o.oO(readLock, "readWriteLock.readLock()");
        return readLock;
    }

    @OOXIXo
    public InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    @OOXIXo
    public SupportSQLiteOpenHelper getOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        IIX0o.XOxIOxOx("internalOpenHelper");
        return null;
    }

    @OOXIXo
    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor != null) {
            return executor;
        }
        IIX0o.XOxIOxOx("internalQueryExecutor");
        return null;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return Xo0.OOXIXo();
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return o0.O0xOxO();
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    @OOXIXo
    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        IIX0o.XOxIOxOx("internalTransactionExecutor");
        return null;
    }

    @oOoXoXO
    public <T> T getTypeConverter(@OOXIXo Class<T> cls) {
        IIX0o.x0xO0oo(cls, "klass");
        return this.typeConverters.get(cls);
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(@OOXIXo DatabaseConfiguration databaseConfiguration) {
        boolean z = false;
        IIX0o.x0xO0oo(databaseConfiguration, O0IoXXOx.XO.f15419Oxx0IOOO);
        this.internalOpenHelper = createOpenHelper(databaseConfiguration);
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        BitSet bitSet = new BitSet();
        for (Class next : requiredAutoMigrationSpecs) {
            int size = databaseConfiguration.autoMigrationSpecs.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    if (next.isAssignableFrom(databaseConfiguration.autoMigrationSpecs.get(size).getClass())) {
                        bitSet.set(size);
                        break;
                    } else if (i < 0) {
                        break;
                    } else {
                        size = i;
                    }
                }
            }
            size = -1;
            if (size >= 0) {
                this.autoMigrationSpecs.put(next, databaseConfiguration.autoMigrationSpecs.get(size));
            } else {
                throw new IllegalArgumentException(("A required auto migration spec (" + next.getCanonicalName() + ") is missing in the database configuration.").toString());
            }
        }
        int size2 = databaseConfiguration.autoMigrationSpecs.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i2 = size2 - 1;
                if (!bitSet.get(size2)) {
                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                } else if (i2 < 0) {
                    break;
                } else {
                    size2 = i2;
                }
            }
        }
        for (Migration next2 : getAutoMigrations(this.autoMigrationSpecs)) {
            if (!databaseConfiguration.migrationContainer.contains(next2.startVersion, next2.endVersion)) {
                databaseConfiguration.migrationContainer.addMigrations(next2);
            }
        }
        SQLiteCopyOpenHelper sQLiteCopyOpenHelper = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, getOpenHelper());
        if (sQLiteCopyOpenHelper != null) {
            sQLiteCopyOpenHelper.setDatabaseConfiguration(databaseConfiguration);
        }
        AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, getOpenHelper());
        if (autoClosingRoomOpenHelper != null) {
            this.autoCloser = autoClosingRoomOpenHelper.autoCloser;
            getInvalidationTracker().setAutoCloser$room_runtime_release(autoClosingRoomOpenHelper.autoCloser);
        }
        if (databaseConfiguration.journalMode == JournalMode.WRITE_AHEAD_LOGGING) {
            z = true;
        }
        getOpenHelper().setWriteAheadLoggingEnabled(z);
        this.mCallbacks = databaseConfiguration.callbacks;
        this.internalQueryExecutor = databaseConfiguration.queryExecutor;
        this.internalTransactionExecutor = new TransactionExecutor(databaseConfiguration.transactionExecutor);
        this.allowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
        this.writeAheadLoggingEnabled = z;
        if (databaseConfiguration.multiInstanceInvalidationServiceIntent != null) {
            if (databaseConfiguration.name != null) {
                getInvalidationTracker().startMultiInstanceInvalidation$room_runtime_release(databaseConfiguration.context, databaseConfiguration.name, databaseConfiguration.multiInstanceInvalidationServiceIntent);
            } else {
                throw new IllegalArgumentException("Required value was null.");
            }
        }
        Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
        BitSet bitSet2 = new BitSet();
        for (Map.Entry next3 : requiredTypeConverters.entrySet()) {
            Class cls = (Class) next3.getKey();
            Iterator it = ((List) next3.getValue()).iterator();
            while (true) {
                if (it.hasNext()) {
                    Class cls2 = (Class) it.next();
                    int size3 = databaseConfiguration.typeConverters.size() - 1;
                    if (size3 >= 0) {
                        while (true) {
                            int i3 = size3 - 1;
                            if (cls2.isAssignableFrom(databaseConfiguration.typeConverters.get(size3).getClass())) {
                                bitSet2.set(size3);
                                break;
                            } else if (i3 < 0) {
                                break;
                            } else {
                                size3 = i3;
                            }
                        }
                    }
                    size3 = -1;
                    if (size3 >= 0) {
                        this.typeConverters.put(cls2, databaseConfiguration.typeConverters.get(size3));
                    } else {
                        throw new IllegalArgumentException(("A required type converter (" + cls2 + ") for " + cls.getCanonicalName() + " is missing in the database configuration.").toString());
                    }
                }
            }
        }
        int size4 = databaseConfiguration.typeConverters.size() - 1;
        if (size4 >= 0) {
            while (true) {
                int i4 = size4 - 1;
                if (!bitSet2.get(size4)) {
                    throw new IllegalArgumentException("Unexpected type converter " + databaseConfiguration.typeConverters.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                } else if (i4 >= 0) {
                    size4 = i4;
                } else {
                    return;
                }
            }
        }
    }

    public void internalInitInvalidationTracker(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        getInvalidationTracker().internalInit$room_runtime_release(supportSQLiteDatabase);
    }

    public final boolean isMainThread$room_runtime_release() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        Boolean bool;
        boolean isOpen;
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 != null) {
            isOpen = autoCloser2.isActive();
        } else {
            SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
            if (supportSQLiteDatabase != null) {
                isOpen = supportSQLiteDatabase.isOpen();
            } else {
                bool = null;
                return IIX0o.Oxx0IOOO(bool, Boolean.TRUE);
            }
        }
        bool = Boolean.valueOf(isOpen);
        return IIX0o.Oxx0IOOO(bool, Boolean.TRUE);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isOpenInternal() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
        if (supportSQLiteDatabase == null || !supportSQLiteDatabase.isOpen()) {
            return false;
        }
        return true;
    }

    @xoIox
    @OOXIXo
    public final Cursor query(@OOXIXo SupportSQLiteQuery supportSQLiteQuery) {
        IIX0o.x0xO0oo(supportSQLiteQuery, "query");
        return query$default(this, supportSQLiteQuery, (CancellationSignal) null, 2, (Object) null);
    }

    public void runInTransaction(@OOXIXo Runnable runnable) {
        IIX0o.x0xO0oo(runnable, "body");
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setAutoMigrationSpecs(@OOXIXo Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        IIX0o.x0xO0oo(map, "<set-?>");
        this.autoMigrationSpecs = map;
    }

    @kotlin.OOXIXo(message = "setTransactionSuccessful() is deprecated", replaceWith = @kotlin.XX(expression = "runInTransaction(Runnable)", imports = {}))
    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    @OOXIXo
    public Cursor query(@OOXIXo String str, @oOoXoXO Object[] objArr) {
        IIX0o.x0xO0oo(str, "query");
        return getOpenHelper().getWritableDatabase().query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    @XX({"SMAP\nRoomDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabase$MigrationContainer\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,1548:1\n13579#2,2:1549\n1855#3,2:1551\n361#4,7:1553\n*S KotlinDebug\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabase$MigrationContainer\n*L\n1371#1:1549,2\n1381#1:1551,2\n1387#1:1553,7\n*E\n"})
    public static class MigrationContainer {
        @OOXIXo
        private final Map<Integer, TreeMap<Integer, Migration>> migrations = new LinkedHashMap();

        private final void addMigration(Migration migration) {
            int i = migration.startVersion;
            int i2 = migration.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> map = this.migrations;
            Integer valueOf = Integer.valueOf(i);
            TreeMap<Integer, Migration> treeMap = map.get(valueOf);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                map.put(valueOf, treeMap);
            }
            TreeMap treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i2))) {
                Log.w(Room.LOG_TAG, "Overriding migration " + treeMap2.get(Integer.valueOf(i2)) + " with " + migration);
            }
            treeMap2.put(Integer.valueOf(i2), migration);
        }

        private final List<Migration> findUpMigrationPath(List<Migration> list, boolean z, int i, int i2) {
            Set set;
            boolean z2;
            Integer num;
            do {
                if (z) {
                    if (i >= i2) {
                        return list;
                    }
                } else if (i <= i2) {
                    return list;
                }
                TreeMap treeMap = this.migrations.get(Integer.valueOf(i));
                if (treeMap == null) {
                    return null;
                }
                if (z) {
                    set = treeMap.descendingKeySet();
                } else {
                    set = treeMap.keySet();
                }
                Iterator it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        continue;
                        break;
                    }
                    num = (Integer) it.next();
                    if (!z) {
                        IIX0o.oO(num, "targetVersion");
                        int intValue = num.intValue();
                        if (i2 <= intValue && intValue < i) {
                            break;
                        }
                    } else {
                        int i3 = i + 1;
                        IIX0o.oO(num, "targetVersion");
                        int intValue2 = num.intValue();
                        if (i3 <= intValue2 && intValue2 <= i2) {
                            break;
                        }
                    }
                }
                Object obj = treeMap.get(num);
                IIX0o.ooOOo0oXI(obj);
                list.add(obj);
                i = num.intValue();
                z2 = true;
                continue;
            } while (z2);
            return null;
        }

        public void addMigrations(@OOXIXo List<? extends Migration> list) {
            IIX0o.x0xO0oo(list, "migrations");
            for (Migration addMigration : list) {
                addMigration(addMigration);
            }
        }

        public final boolean contains(int i, int i2) {
            Map<Integer, Map<Integer, Migration>> migrations2 = getMigrations();
            if (!migrations2.containsKey(Integer.valueOf(i))) {
                return false;
            }
            Map map = migrations2.get(Integer.valueOf(i));
            if (map == null) {
                map = o0.O0xOxO();
            }
            return map.containsKey(Integer.valueOf(i2));
        }

        @oOoXoXO
        public List<Migration> findMigrationPath(int i, int i2) {
            boolean z;
            if (i == i2) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i2 > i) {
                z = true;
            } else {
                z = false;
            }
            return findUpMigrationPath(new ArrayList(), z, i, i2);
        }

        @OOXIXo
        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }

        public void addMigrations(@OOXIXo Migration... migrationArr) {
            IIX0o.x0xO0oo(migrationArr, "migrations");
            for (Migration addMigration : migrationArr) {
                addMigration(addMigration);
            }
        }
    }

    @xoIox
    @OOXIXo
    public Cursor query(@OOXIXo SupportSQLiteQuery supportSQLiteQuery, @oOoXoXO CancellationSignal cancellationSignal) {
        IIX0o.x0xO0oo(supportSQLiteQuery, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return getOpenHelper().getWritableDatabase().query(supportSQLiteQuery, cancellationSignal);
        }
        return getOpenHelper().getWritableDatabase().query(supportSQLiteQuery);
    }

    public <V> V runInTransaction(@OOXIXo Callable<V> callable) {
        IIX0o.x0xO0oo(callable, "body");
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            return call;
        } finally {
            endTransaction();
        }
    }
}
