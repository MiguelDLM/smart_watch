package androidx.room;

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
import kotlin.jvm.internal.XX;

@XX({"SMAP\nRoomDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabase\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1548:1\n215#2,2:1549\n*S KotlinDebug\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabase\n*L\n261#1:1549,2\n*E\n"})
/* loaded from: classes.dex */
public abstract class RoomDatabase {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;

    @OXOo.oOoXoXO
    private AutoCloser autoCloser;

    @OXOo.OOXIXo
    private final Map<String, Object> backingFieldMap;
    private SupportSQLiteOpenHelper internalOpenHelper;
    private Executor internalQueryExecutor;
    private Executor internalTransactionExecutor;

    @XO0OX.XO
    @OXOo.oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected List<? extends Callback> mCallbacks;

    @XO0OX.XO
    @OXOo.oOoXoXO
    protected volatile SupportSQLiteDatabase mDatabase;

    @OXOo.OOXIXo
    private final Map<Class<?>, Object> typeConverters;
    private boolean writeAheadLoggingEnabled;

    @OXOo.OOXIXo
    private final InvalidationTracker invalidationTracker = createInvalidationTracker();

    @OXOo.OOXIXo
    private Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs = new LinkedHashMap();

    @OXOo.OOXIXo
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @OXOo.OOXIXo
    private final ThreadLocal<Integer> suspendingTransactionId = new ThreadLocal<>();

    @XX({"SMAP\nRoomDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabase$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1548:1\n1#2:1549\n*E\n"})
    /* loaded from: classes.dex */
    public static class Builder<T extends RoomDatabase> {
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;

        @OXOo.oOoXoXO
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout;

        @OXOo.OOXIXo
        private List<AutoMigrationSpec> autoMigrationSpecs;

        @OXOo.OOXIXo
        private final List<Callback> callbacks;

        @OXOo.OOXIXo
        private final Context context;

        @OXOo.oOoXoXO
        private String copyFromAssetPath;

        @OXOo.oOoXoXO
        private File copyFromFile;

        @OXOo.oOoXoXO
        private Callable<InputStream> copyFromInputStream;

        @OXOo.oOoXoXO
        private SupportSQLiteOpenHelper.Factory factory;

        @OXOo.OOXIXo
        private JournalMode journalMode;

        @OXOo.OOXIXo
        private final Class<T> klass;

        @OXOo.OOXIXo
        private final MigrationContainer migrationContainer;

        @OXOo.oOoXoXO
        private Set<Integer> migrationStartAndEndVersions;

        @OXOo.OOXIXo
        private Set<Integer> migrationsNotRequiredFrom;

        @OXOo.oOoXoXO
        private Intent multiInstanceInvalidationIntent;

        @OXOo.oOoXoXO
        private final String name;

        @OXOo.oOoXoXO
        private PrepackagedDatabaseCallback prepackagedDatabaseCallback;

        @OXOo.oOoXoXO
        private QueryCallback queryCallback;

        @OXOo.oOoXoXO
        private Executor queryCallbackExecutor;

        @OXOo.oOoXoXO
        private Executor queryExecutor;
        private boolean requireMigration;

        @OXOo.oOoXoXO
        private Executor transactionExecutor;

        @OXOo.OOXIXo
        private final List<Object> typeConverters;

        public Builder(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Class<T> klass, @OXOo.oOoXoXO String str) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(klass, "klass");
            this.context = context;
            this.klass = klass;
            this.name = str;
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.autoMigrationSpecs = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.requireMigration = true;
            this.autoCloseTimeout = -1L;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
        }

        @OXOo.OOXIXo
        public Builder<T> addAutoMigrationSpec(@OXOo.OOXIXo AutoMigrationSpec autoMigrationSpec) {
            IIX0o.x0xO0oo(autoMigrationSpec, "autoMigrationSpec");
            this.autoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> addCallback(@OXOo.OOXIXo Callback callback) {
            IIX0o.x0xO0oo(callback, "callback");
            this.callbacks.add(callback);
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> addMigrations(@OXOo.OOXIXo Migration... migrations) {
            IIX0o.x0xO0oo(migrations, "migrations");
            if (this.migrationStartAndEndVersions == null) {
                this.migrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrations) {
                Set<Integer> set = this.migrationStartAndEndVersions;
                IIX0o.ooOOo0oXI(set);
                set.add(Integer.valueOf(migration.startVersion));
                Set<Integer> set2 = this.migrationStartAndEndVersions;
                IIX0o.ooOOo0oXI(set2);
                set2.add(Integer.valueOf(migration.endVersion));
            }
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrations, migrations.length));
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> addTypeConverter(@OXOo.OOXIXo Object typeConverter) {
            IIX0o.x0xO0oo(typeConverter, "typeConverter");
            this.typeConverters.add(typeConverter);
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        @OXOo.OOXIXo
        public T build() {
            SupportSQLiteOpenHelper.Factory factory;
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
                Iterator<Integer> it = set.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (this.migrationsNotRequiredFrom.contains(Integer.valueOf(intValue))) {
                        throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + intValue).toString());
                    }
                }
            }
            SupportSQLiteOpenHelper.Factory factory2 = this.factory;
            if (factory2 == null) {
                factory2 = new FrameworkSQLiteOpenHelperFactory();
            }
            if (factory2 != null) {
                if (this.autoCloseTimeout > 0) {
                    if (this.name != null) {
                        long j = this.autoCloseTimeout;
                        TimeUnit timeUnit = this.autoCloseTimeUnit;
                        if (timeUnit != null) {
                            Executor executor2 = this.queryExecutor;
                            if (executor2 != null) {
                                factory2 = new AutoClosingRoomOpenHelperFactory(factory2, new AutoCloser(j, timeUnit, executor2));
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
                if (str != null || this.copyFromFile != null || this.copyFromInputStream != null) {
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
                            factory2 = new SQLiteCopyOpenHelperFactory(str, file, callable, factory2);
                        } else {
                            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                }
            } else {
                factory2 = null;
            }
            if (factory2 != null) {
                QueryCallback queryCallback = this.queryCallback;
                if (queryCallback != null) {
                    Executor executor3 = this.queryCallbackExecutor;
                    if (executor3 != null) {
                        if (queryCallback != null) {
                            factory = new QueryInterceptorOpenHelperFactory(factory2, executor3, queryCallback);
                        } else {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                } else {
                    factory = factory2;
                }
                Context context = this.context;
                String str2 = this.name;
                MigrationContainer migrationContainer = this.migrationContainer;
                List<Callback> list = this.callbacks;
                boolean z = this.allowMainThreadQueries;
                JournalMode resolve$room_runtime_release = this.journalMode.resolve$room_runtime_release(context);
                Executor executor4 = this.queryExecutor;
                if (executor4 != null) {
                    Executor executor5 = this.transactionExecutor;
                    if (executor5 != null) {
                        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, str2, factory, migrationContainer, list, z, resolve$room_runtime_release, executor4, executor5, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, (List<? extends Object>) this.typeConverters, this.autoMigrationSpecs);
                        T t = (T) Room.getGeneratedImplementation(this.klass, "_Impl");
                        t.init(databaseConfiguration);
                        return t;
                    }
                    throw new IllegalArgumentException("Required value was null.");
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalArgumentException("Required value was null.");
        }

        @OXOo.OOXIXo
        public Builder<T> createFromAsset(@OXOo.OOXIXo String databaseFilePath) {
            IIX0o.x0xO0oo(databaseFilePath, "databaseFilePath");
            this.copyFromAssetPath = databaseFilePath;
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> createFromFile(@OXOo.OOXIXo File databaseFile) {
            IIX0o.x0xO0oo(databaseFile, "databaseFile");
            this.copyFromFile = databaseFile;
            return this;
        }

        @OXOo.OOXIXo
        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromInputStream(@OXOo.OOXIXo Callable<InputStream> inputStreamCallable) {
            IIX0o.x0xO0oo(inputStreamCallable, "inputStreamCallable");
            this.copyFromInputStream = inputStreamCallable;
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> enableMultiInstanceInvalidation() {
            Intent intent;
            if (this.name != null) {
                intent = new Intent(this.context, (Class<?>) MultiInstanceInvalidationService.class);
            } else {
                intent = null;
            }
            this.multiInstanceInvalidationIntent = intent;
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> fallbackToDestructiveMigrationFrom(@OXOo.OOXIXo int... startVersions) {
            IIX0o.x0xO0oo(startVersions, "startVersions");
            for (int i : startVersions) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(i));
            }
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> openHelperFactory(@OXOo.oOoXoXO SupportSQLiteOpenHelper.Factory factory) {
            this.factory = factory;
            return this;
        }

        @OXOo.OOXIXo
        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long j, @OXOo.OOXIXo TimeUnit autoCloseTimeUnit) {
            IIX0o.x0xO0oo(autoCloseTimeUnit, "autoCloseTimeUnit");
            if (j >= 0) {
                this.autoCloseTimeout = j;
                this.autoCloseTimeUnit = autoCloseTimeUnit;
                return this;
            }
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
        }

        @OXOo.OOXIXo
        public Builder<T> setJournalMode(@OXOo.OOXIXo JournalMode journalMode) {
            IIX0o.x0xO0oo(journalMode, "journalMode");
            this.journalMode = journalMode;
            return this;
        }

        @OXOo.OOXIXo
        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(@OXOo.OOXIXo Intent invalidationServiceIntent) {
            IIX0o.x0xO0oo(invalidationServiceIntent, "invalidationServiceIntent");
            if (this.name == null) {
                invalidationServiceIntent = null;
            }
            this.multiInstanceInvalidationIntent = invalidationServiceIntent;
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> setQueryCallback(@OXOo.OOXIXo QueryCallback queryCallback, @OXOo.OOXIXo Executor executor) {
            IIX0o.x0xO0oo(queryCallback, "queryCallback");
            IIX0o.x0xO0oo(executor, "executor");
            this.queryCallback = queryCallback;
            this.queryCallbackExecutor = executor;
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> setQueryExecutor(@OXOo.OOXIXo Executor executor) {
            IIX0o.x0xO0oo(executor, "executor");
            this.queryExecutor = executor;
            return this;
        }

        @OXOo.OOXIXo
        public Builder<T> setTransactionExecutor(@OXOo.OOXIXo Executor executor) {
            IIX0o.x0xO0oo(executor, "executor");
            this.transactionExecutor = executor;
            return this;
        }

        @OXOo.OOXIXo
        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromAsset(@OXOo.OOXIXo String databaseFilePath, @OXOo.OOXIXo PrepackagedDatabaseCallback callback) {
            IIX0o.x0xO0oo(databaseFilePath, "databaseFilePath");
            IIX0o.x0xO0oo(callback, "callback");
            this.prepackagedDatabaseCallback = callback;
            this.copyFromAssetPath = databaseFilePath;
            return this;
        }

        @OXOo.OOXIXo
        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        public Builder<T> createFromFile(@OXOo.OOXIXo File databaseFile, @OXOo.OOXIXo PrepackagedDatabaseCallback callback) {
            IIX0o.x0xO0oo(databaseFile, "databaseFile");
            IIX0o.x0xO0oo(callback, "callback");
            this.prepackagedDatabaseCallback = callback;
            this.copyFromFile = databaseFile;
            return this;
        }

        @OXOo.OOXIXo
        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        public Builder<T> createFromInputStream(@OXOo.OOXIXo Callable<InputStream> inputStreamCallable, @OXOo.OOXIXo PrepackagedDatabaseCallback callback) {
            IIX0o.x0xO0oo(inputStreamCallable, "inputStreamCallable");
            IIX0o.x0xO0oo(callback, "callback");
            this.prepackagedDatabaseCallback = callback;
            this.copyFromInputStream = inputStreamCallable;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public void onCreate(@OXOo.OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
        }

        public void onDestructiveMigration(@OXOo.OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
        }

        public void onOpen(@OXOo.OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private final boolean isLowRamDevice(ActivityManager activityManager) {
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(activityManager);
        }

        @OXOo.OOXIXo
        public final JournalMode resolve$room_runtime_release(@OXOo.OOXIXo Context context) {
            ActivityManager activityManager;
            IIX0o.x0xO0oo(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (systemService instanceof ActivityManager) {
                activityManager = (ActivityManager) systemService;
            } else {
                activityManager = null;
            }
            if (activityManager != null && !isLowRamDevice(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(@OXOo.OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
        }
    }

    /* loaded from: classes.dex */
    public interface QueryCallback {
        void onQuery(@OXOo.OOXIXo String str, @OXOo.OOXIXo List<? extends Object> list);
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T unwrapOpenHelper(Class<T> cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return (T) unwrapOpenHelper(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate());
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (this.allowMainThreadQueries || !isMainThread$room_runtime_release()) {
        } else {
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
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser == null) {
            internalBeginTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new Oox.oOoXoXO<SupportSQLiteDatabase, Object>() { // from class: androidx.room.RoomDatabase$beginTransaction$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.oOoXoXO
                public final Object invoke(@OXOo.OOXIXo SupportSQLiteDatabase it) {
                    IIX0o.x0xO0oo(it, "it");
                    RoomDatabase.this.internalBeginTransaction();
                    return null;
                }
            });
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

    @OXOo.OOXIXo
    public SupportSQLiteStatement compileStatement(@OXOo.OOXIXo String sql) {
        IIX0o.x0xO0oo(sql, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(sql);
    }

    @OXOo.OOXIXo
    public abstract InvalidationTracker createInvalidationTracker();

    @OXOo.OOXIXo
    public abstract SupportSQLiteOpenHelper createOpenHelper(@OXOo.OOXIXo DatabaseConfiguration databaseConfiguration);

    @kotlin.OOXIXo(message = "endTransaction() is deprecated", replaceWith = @kotlin.XX(expression = "runInTransaction(Runnable)", imports = {}))
    public void endTransaction() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser == null) {
            internalEndTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new Oox.oOoXoXO<SupportSQLiteDatabase, Object>() { // from class: androidx.room.RoomDatabase$endTransaction$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.oOoXoXO
                public final Object invoke(@OXOo.OOXIXo SupportSQLiteDatabase it) {
                    IIX0o.x0xO0oo(it, "it");
                    RoomDatabase.this.internalEndTransaction();
                    return null;
                }
            });
        }
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    @OXOo.OOXIXo
    @XO0OX.oO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Migration> getAutoMigrations(@OXOo.OOXIXo Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        IIX0o.x0xO0oo(autoMigrationSpecs, "autoMigrationSpecs");
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    @OXOo.OOXIXo
    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
        IIX0o.oO(readLock, "readWriteLock.readLock()");
        return readLock;
    }

    @OXOo.OOXIXo
    public InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    @OXOo.OOXIXo
    public SupportSQLiteOpenHelper getOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper == null) {
            IIX0o.XOxIOxOx("internalOpenHelper");
            return null;
        }
        return supportSQLiteOpenHelper;
    }

    @OXOo.OOXIXo
    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor == null) {
            IIX0o.XOxIOxOx("internalQueryExecutor");
            return null;
        }
        return executor;
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return Xo0.OOXIXo();
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return o0.O0xOxO();
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    @OXOo.OOXIXo
    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor == null) {
            IIX0o.XOxIOxOx("internalTransactionExecutor");
            return null;
        }
        return executor;
    }

    @OXOo.oOoXoXO
    public <T> T getTypeConverter(@OXOo.OOXIXo Class<T> klass) {
        IIX0o.x0xO0oo(klass, "klass");
        return (T) this.typeConverters.get(klass);
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(@OXOo.OOXIXo DatabaseConfiguration configuration) {
        boolean z = false;
        IIX0o.x0xO0oo(configuration, "configuration");
        this.internalOpenHelper = createOpenHelper(configuration);
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        BitSet bitSet = new BitSet();
        for (Class<? extends AutoMigrationSpec> cls : requiredAutoMigrationSpecs) {
            int size = configuration.autoMigrationSpecs.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    if (cls.isAssignableFrom(configuration.autoMigrationSpecs.get(size).getClass())) {
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
                this.autoMigrationSpecs.put(cls, configuration.autoMigrationSpecs.get(size));
            } else {
                throw new IllegalArgumentException(("A required auto migration spec (" + cls.getCanonicalName() + ") is missing in the database configuration.").toString());
            }
        }
        int size2 = configuration.autoMigrationSpecs.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i2 = size2 - 1;
                if (bitSet.get(size2)) {
                    if (i2 < 0) {
                        break;
                    } else {
                        size2 = i2;
                    }
                } else {
                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                }
            }
        }
        for (Migration migration : getAutoMigrations(this.autoMigrationSpecs)) {
            if (!configuration.migrationContainer.contains(migration.startVersion, migration.endVersion)) {
                configuration.migrationContainer.addMigrations(migration);
            }
        }
        SQLiteCopyOpenHelper sQLiteCopyOpenHelper = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, getOpenHelper());
        if (sQLiteCopyOpenHelper != null) {
            sQLiteCopyOpenHelper.setDatabaseConfiguration(configuration);
        }
        AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, getOpenHelper());
        if (autoClosingRoomOpenHelper != null) {
            this.autoCloser = autoClosingRoomOpenHelper.autoCloser;
            getInvalidationTracker().setAutoCloser$room_runtime_release(autoClosingRoomOpenHelper.autoCloser);
        }
        if (configuration.journalMode == JournalMode.WRITE_AHEAD_LOGGING) {
            z = true;
        }
        getOpenHelper().setWriteAheadLoggingEnabled(z);
        this.mCallbacks = configuration.callbacks;
        this.internalQueryExecutor = configuration.queryExecutor;
        this.internalTransactionExecutor = new TransactionExecutor(configuration.transactionExecutor);
        this.allowMainThreadQueries = configuration.allowMainThreadQueries;
        this.writeAheadLoggingEnabled = z;
        if (configuration.multiInstanceInvalidationServiceIntent != null) {
            if (configuration.name != null) {
                getInvalidationTracker().startMultiInstanceInvalidation$room_runtime_release(configuration.context, configuration.name, configuration.multiInstanceInvalidationServiceIntent);
            } else {
                throw new IllegalArgumentException("Required value was null.");
            }
        }
        Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
        BitSet bitSet2 = new BitSet();
        for (Map.Entry<Class<?>, List<Class<?>>> entry : requiredTypeConverters.entrySet()) {
            Class<?> key = entry.getKey();
            for (Class<?> cls2 : entry.getValue()) {
                int size3 = configuration.typeConverters.size() - 1;
                if (size3 >= 0) {
                    while (true) {
                        int i3 = size3 - 1;
                        if (cls2.isAssignableFrom(configuration.typeConverters.get(size3).getClass())) {
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
                    this.typeConverters.put(cls2, configuration.typeConverters.get(size3));
                } else {
                    throw new IllegalArgumentException(("A required type converter (" + cls2 + ") for " + key.getCanonicalName() + " is missing in the database configuration.").toString());
                }
            }
        }
        int size4 = configuration.typeConverters.size() - 1;
        if (size4 < 0) {
            return;
        }
        while (true) {
            int i4 = size4 - 1;
            if (bitSet2.get(size4)) {
                if (i4 >= 0) {
                    size4 = i4;
                } else {
                    return;
                }
            } else {
                throw new IllegalArgumentException("Unexpected type converter " + configuration.typeConverters.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            }
        }
    }

    public void internalInitInvalidationTracker(@OXOo.OOXIXo SupportSQLiteDatabase db) {
        IIX0o.x0xO0oo(db, "db");
        getInvalidationTracker().internalInit$room_runtime_release(db);
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
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            isOpen = autoCloser.isActive();
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

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public final Cursor query(@OXOo.OOXIXo SupportSQLiteQuery query) {
        IIX0o.x0xO0oo(query, "query");
        return query$default(this, query, null, 2, null);
    }

    public void runInTransaction(@OXOo.OOXIXo Runnable body) {
        IIX0o.x0xO0oo(body, "body");
        beginTransaction();
        try {
            body.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setAutoMigrationSpecs(@OXOo.OOXIXo Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        IIX0o.x0xO0oo(map, "<set-?>");
        this.autoMigrationSpecs = map;
    }

    @kotlin.OOXIXo(message = "setTransactionSuccessful() is deprecated", replaceWith = @kotlin.XX(expression = "runInTransaction(Runnable)", imports = {}))
    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    @OXOo.OOXIXo
    public Cursor query(@OXOo.OOXIXo String query, @OXOo.oOoXoXO Object[] objArr) {
        IIX0o.x0xO0oo(query, "query");
        return getOpenHelper().getWritableDatabase().query(new SimpleSQLiteQuery(query, objArr));
    }

    @XX({"SMAP\nRoomDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabase$MigrationContainer\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,1548:1\n13579#2,2:1549\n1855#3,2:1551\n361#4,7:1553\n*S KotlinDebug\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabase$MigrationContainer\n*L\n1371#1:1549,2\n1381#1:1551,2\n1387#1:1553,7\n*E\n"})
    /* loaded from: classes.dex */
    public static class MigrationContainer {

        @OXOo.OOXIXo
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
            TreeMap<Integer, Migration> treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i2))) {
                Log.w(Room.LOG_TAG, "Overriding migration " + treeMap2.get(Integer.valueOf(i2)) + " with " + migration);
            }
            treeMap2.put(Integer.valueOf(i2), migration);
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final java.util.List<androidx.room.migration.Migration> findUpMigrationPath(java.util.List<androidx.room.migration.Migration> r7, boolean r8, int r9, int r10) {
            /*
                r6 = this;
            L0:
                if (r8 == 0) goto L5
                if (r9 >= r10) goto L63
                goto L7
            L5:
                if (r9 <= r10) goto L63
            L7:
                java.util.Map<java.lang.Integer, java.util.TreeMap<java.lang.Integer, androidx.room.migration.Migration>> r0 = r6.migrations
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
                java.lang.Object r0 = r0.get(r1)
                java.util.TreeMap r0 = (java.util.TreeMap) r0
                r1 = 0
                if (r0 != 0) goto L17
                return r1
            L17:
                if (r8 == 0) goto L1e
                java.util.NavigableSet r2 = r0.descendingKeySet()
                goto L22
            L1e:
                java.util.Set r2 = r0.keySet()
            L22:
                java.util.Iterator r2 = r2.iterator()
            L26:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L5f
                java.lang.Object r3 = r2.next()
                java.lang.Integer r3 = (java.lang.Integer) r3
                java.lang.String r4 = "targetVersion"
                if (r8 == 0) goto L44
                int r5 = r9 + 1
                kotlin.jvm.internal.IIX0o.oO(r3, r4)
                int r4 = r3.intValue()
                if (r5 > r4) goto L26
                if (r4 > r10) goto L26
                goto L4f
            L44:
                kotlin.jvm.internal.IIX0o.oO(r3, r4)
                int r4 = r3.intValue()
                if (r10 > r4) goto L26
                if (r4 >= r9) goto L26
            L4f:
                java.lang.Object r9 = r0.get(r3)
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r9)
                r7.add(r9)
                int r9 = r3.intValue()
                r0 = 1
                goto L60
            L5f:
                r0 = 0
            L60:
                if (r0 != 0) goto L0
                return r1
            L63:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.MigrationContainer.findUpMigrationPath(java.util.List, boolean, int, int):java.util.List");
        }

        public void addMigrations(@OXOo.OOXIXo List<? extends Migration> migrations) {
            IIX0o.x0xO0oo(migrations, "migrations");
            Iterator<T> it = migrations.iterator();
            while (it.hasNext()) {
                addMigration((Migration) it.next());
            }
        }

        public final boolean contains(int i, int i2) {
            Map<Integer, Map<Integer, Migration>> migrations = getMigrations();
            if (migrations.containsKey(Integer.valueOf(i))) {
                Map<Integer, Migration> map = migrations.get(Integer.valueOf(i));
                if (map == null) {
                    map = o0.O0xOxO();
                }
                return map.containsKey(Integer.valueOf(i2));
            }
            return false;
        }

        @OXOo.oOoXoXO
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

        @OXOo.OOXIXo
        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }

        public void addMigrations(@OXOo.OOXIXo Migration... migrations) {
            IIX0o.x0xO0oo(migrations, "migrations");
            for (Migration migration : migrations) {
                addMigration(migration);
            }
        }
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public Cursor query(@OXOo.OOXIXo SupportSQLiteQuery query, @OXOo.oOoXoXO CancellationSignal cancellationSignal) {
        IIX0o.x0xO0oo(query, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return getOpenHelper().getWritableDatabase().query(query, cancellationSignal);
        }
        return getOpenHelper().getWritableDatabase().query(query);
    }

    public <V> V runInTransaction(@OXOo.OOXIXo Callable<V> body) {
        IIX0o.x0xO0oo(body, "body");
        beginTransaction();
        try {
            V call = body.call();
            setTransactionSuccessful();
            return call;
        } finally {
            endTransaction();
        }
    }
}
