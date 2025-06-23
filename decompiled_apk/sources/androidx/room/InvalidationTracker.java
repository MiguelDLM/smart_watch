package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpDelete;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.collections.o0;
import kotlin.collections.oX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,840:1\n215#2,2:841\n11335#3:843\n11670#3,3:844\n13579#3,2:847\n13579#3,2:849\n13674#3,3:855\n37#4,2:851\n1855#5,2:853\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker\n*L\n102#1:841,2\n250#1:843\n250#1:844,3\n271#1:847,2\n287#1:849,2\n491#1:855,3\n294#1:851,2\n467#1:853,2\n*E\n"})
/* loaded from: classes.dex */
public class InvalidationTracker {

    @OXOo.OOXIXo
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";

    @OXOo.OOXIXo
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";

    @OXOo.OOXIXo
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";

    @OXOo.OOXIXo
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";

    @OXOo.OOXIXo
    private static final String TABLE_ID_COLUMN_NAME = "table_id";

    @OXOo.OOXIXo
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";

    @OXOo.oOoXoXO
    private AutoCloser autoCloser;

    @OXOo.oOoXoXO
    private volatile SupportSQLiteStatement cleanupStatement;

    @OXOo.OOXIXo
    private final RoomDatabase database;
    private volatile boolean initialized;

    @OXOo.OOXIXo
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;

    @OXOo.oOoXoXO
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;

    @OXOo.OOXIXo
    private final ObservedTableTracker observedTableTracker;

    @OXOo.OOXIXo
    @GuardedBy("observerMap")
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final AtomicBoolean pendingRefresh;

    @OXOo.OOXIXo
    @XO0OX.XO
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final Runnable refreshRunnable;

    @OXOo.OOXIXo
    private final Map<String, String> shadowTablesMap;

    @OXOo.OOXIXo
    private final Object syncTriggersLock;

    @OXOo.OOXIXo
    private final Map<String, Integer> tableIdLookup;

    @OXOo.OOXIXo
    private final String[] tablesNames;

    @OXOo.OOXIXo
    private final Object trackerLock;

    @OXOo.OOXIXo
    private final Map<String, Set<String>> viewTables;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String[] TRIGGERS = {"UPDATE", HttpDelete.METHOD_NAME, "INSERT"};

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public final void beginTransactionInternal$room_runtime_release(@OXOo.OOXIXo SupportSQLiteDatabase database) {
            IIX0o.x0xO0oo(database, "database");
            if (database.isWriteAheadLoggingEnabled()) {
                database.beginTransactionNonExclusive();
            } else {
                database.beginTransaction();
            }
        }

        @OXOo.OOXIXo
        public final String getTriggerName$room_runtime_release(@OXOo.OOXIXo String tableName, @OXOo.OOXIXo String triggerType) {
            IIX0o.x0xO0oo(tableName, "tableName");
            IIX0o.x0xO0oo(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }

        private Companion() {
        }
    }

    @XX({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$ObservedTableTracker\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,840:1\n13600#2,2:841\n13600#2,2:843\n13684#2,3:845\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$ObservedTableTracker\n*L\n711#1:841,2\n729#1:843,2\n765#1:845,3\n*E\n"})
    /* loaded from: classes.dex */
    public static final class ObservedTableTracker {
        public static final int ADD = 1;

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;

        @OXOo.OOXIXo
        private final long[] tableObservers;

        @OXOo.OOXIXo
        private final int[] triggerStateChanges;

        @OXOo.OOXIXo
        private final boolean[] triggerStates;

        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public ObservedTableTracker(int i) {
            this.tableObservers = new long[i];
            this.triggerStates = new boolean[i];
            this.triggerStateChanges = new int[i];
        }

        public final boolean getNeedsSync() {
            return this.needsSync;
        }

        @OXOo.OOXIXo
        public final long[] getTableObservers() {
            return this.tableObservers;
        }

        @XO0OX.xxIXOIIO(name = "getTablesToSync")
        @OXOo.oOoXoXO
        @VisibleForTesting
        public final int[] getTablesToSync() {
            boolean z;
            synchronized (this) {
                try {
                    if (!this.needsSync) {
                        return null;
                    }
                    long[] jArr = this.tableObservers;
                    int length = jArr.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        int i4 = 1;
                        if (jArr[i] > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean[] zArr = this.triggerStates;
                        if (z != zArr[i2]) {
                            int[] iArr = this.triggerStateChanges;
                            if (!z) {
                                i4 = 2;
                            }
                            iArr[i2] = i4;
                        } else {
                            this.triggerStateChanges[i2] = 0;
                        }
                        zArr[i2] = z;
                        i++;
                        i2 = i3;
                    }
                    this.needsSync = false;
                    return (int[]) this.triggerStateChanges.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean onAdded(@OXOo.OOXIXo int... tableIds) {
            boolean z;
            IIX0o.x0xO0oo(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : tableIds) {
                        long[] jArr = this.tableObservers;
                        long j = jArr[i];
                        jArr[i] = 1 + j;
                        if (j == 0) {
                            z = true;
                            this.needsSync = true;
                        }
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public final boolean onRemoved(@OXOo.OOXIXo int... tableIds) {
            boolean z;
            IIX0o.x0xO0oo(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : tableIds) {
                        long[] jArr = this.tableObservers;
                        long j = jArr[i];
                        jArr[i] = j - 1;
                        if (j == 1) {
                            z = true;
                            this.needsSync = true;
                        }
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
        }

        public final void setNeedsSync(boolean z) {
            this.needsSync = z;
        }
    }

    @XX({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$Observer\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,840:1\n37#2,2:841\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$Observer\n*L\n670#1:841,2\n*E\n"})
    /* loaded from: classes.dex */
    public static abstract class Observer {

        @OXOo.OOXIXo
        private final String[] tables;

        public Observer(@OXOo.OOXIXo String[] tables) {
            IIX0o.x0xO0oo(tables, "tables");
            this.tables = tables;
        }

        @OXOo.OOXIXo
        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(@OXOo.OOXIXo Set<String> set);

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public Observer(@OXOo.OOXIXo java.lang.String r3, @OXOo.OOXIXo java.lang.String... r4) {
            /*
                r2 = this;
                java.lang.String r0 = "firstTable"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
                java.lang.String r0 = "rest"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                java.util.List r0 = kotlin.collections.oI0IIXIo.xxIXOIIO()
                r1 = r0
                java.util.Collection r1 = (java.util.Collection) r1
                kotlin.collections.OxI.xxIO(r1, r4)
                r0.add(r3)
                java.util.List r3 = kotlin.collections.oI0IIXIo.oIX0oI(r0)
                java.util.Collection r3 = (java.util.Collection) r3
                r4 = 0
                java.lang.String[] r4 = new java.lang.String[r4]
                java.lang.Object[] r3 = r3.toArray(r4)
                java.lang.String[] r3 = (java.lang.String[]) r3
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.Observer.<init>(java.lang.String, java.lang.String[]):void");
        }
    }

    @XX({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$ObserverWrapper\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,840:1\n13674#2,3:841\n12744#2,2:844\n13579#2:846\n13579#2,2:847\n13580#2:849\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$ObserverWrapper\n*L\n612#1:841,3\n634#1:844,2\n640#1:846\n641#1:847,2\n640#1:849\n*E\n"})
    /* loaded from: classes.dex */
    public static final class ObserverWrapper {

        @OXOo.OOXIXo
        private final Observer observer;

        @OXOo.OOXIXo
        private final Set<String> singleTableSet;

        @OXOo.OOXIXo
        private final int[] tableIds;

        @OXOo.OOXIXo
        private final String[] tableNames;

        public ObserverWrapper(@OXOo.OOXIXo Observer observer, @OXOo.OOXIXo int[] tableIds, @OXOo.OOXIXo String[] tableNames) {
            boolean z;
            Set<String> OOXIXo2;
            IIX0o.x0xO0oo(observer, "observer");
            IIX0o.x0xO0oo(tableIds, "tableIds");
            IIX0o.x0xO0oo(tableNames, "tableNames");
            this.observer = observer;
            this.tableIds = tableIds;
            this.tableNames = tableNames;
            if (tableNames.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                OOXIXo2 = oX.XO(tableNames[0]);
            } else {
                OOXIXo2 = Xo0.OOXIXo();
            }
            this.singleTableSet = OOXIXo2;
            if (tableIds.length == tableNames.length) {
            } else {
                throw new IllegalStateException("Check failed.");
            }
        }

        @OXOo.OOXIXo
        public final Observer getObserver$room_runtime_release() {
            return this.observer;
        }

        @OXOo.OOXIXo
        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(@OXOo.OOXIXo Set<Integer> invalidatedTablesIds) {
            Set<String> OOXIXo2;
            IIX0o.x0xO0oo(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.tableIds;
            int length = iArr.length;
            if (length != 0) {
                int i = 0;
                if (length != 1) {
                    Set oxoX2 = oX.oxoX();
                    int[] iArr2 = this.tableIds;
                    int length2 = iArr2.length;
                    int i2 = 0;
                    while (i < length2) {
                        int i3 = i2 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i]))) {
                            oxoX2.add(this.tableNames[i2]);
                        }
                        i++;
                        i2 = i3;
                    }
                    OOXIXo2 = oX.oIX0oI(oxoX2);
                } else if (invalidatedTablesIds.contains(Integer.valueOf(iArr[0]))) {
                    OOXIXo2 = this.singleTableSet;
                } else {
                    OOXIXo2 = Xo0.OOXIXo();
                }
            } else {
                OOXIXo2 = Xo0.OOXIXo();
            }
            if (!OOXIXo2.isEmpty()) {
                this.observer.onInvalidated(OOXIXo2);
            }
        }

        public final void notifyByTableNames$room_runtime_release(@OXOo.OOXIXo String[] tables) {
            Set<String> OOXIXo2;
            IIX0o.x0xO0oo(tables, "tables");
            int length = this.tableNames.length;
            if (length != 0) {
                if (length != 1) {
                    Set oxoX2 = oX.oxoX();
                    for (String str : tables) {
                        for (String str2 : this.tableNames) {
                            if (kotlin.text.OxI.oX0I0O(str2, str, true)) {
                                oxoX2.add(str2);
                            }
                        }
                    }
                    OOXIXo2 = oX.oIX0oI(oxoX2);
                } else {
                    int length2 = tables.length;
                    int i = 0;
                    while (true) {
                        if (i < length2) {
                            if (kotlin.text.OxI.oX0I0O(tables[i], this.tableNames[0], true)) {
                                OOXIXo2 = this.singleTableSet;
                                break;
                            }
                            i++;
                        } else {
                            OOXIXo2 = Xo0.OOXIXo();
                            break;
                        }
                    }
                }
            } else {
                OOXIXo2 = Xo0.OOXIXo();
            }
            if (!OOXIXo2.isEmpty()) {
                this.observer.onInvalidated(OOXIXo2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class WeakObserver extends Observer {

        @OXOo.OOXIXo
        private final WeakReference<Observer> delegateRef;

        @OXOo.OOXIXo
        private final InvalidationTracker tracker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakObserver(@OXOo.OOXIXo InvalidationTracker tracker, @OXOo.OOXIXo Observer delegate) {
            super(delegate.getTables$room_runtime_release());
            IIX0o.x0xO0oo(tracker, "tracker");
            IIX0o.x0xO0oo(delegate, "delegate");
            this.tracker = tracker;
            this.delegateRef = new WeakReference<>(delegate);
        }

        @OXOo.OOXIXo
        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        @OXOo.OOXIXo
        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@OXOo.OOXIXo Set<String> tables) {
            IIX0o.x0xO0oo(tables, "tables");
            Observer observer = this.delegateRef.get();
            if (observer == null) {
                this.tracker.removeObserver(this);
            } else {
                observer.onInvalidated(tables);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(@OXOo.OOXIXo RoomDatabase database, @OXOo.OOXIXo Map<String, String> shadowTablesMap, @OXOo.OOXIXo Map<String, Set<String>> viewTables, @OXOo.OOXIXo String... tableNames) {
        String str;
        IIX0o.x0xO0oo(database, "database");
        IIX0o.x0xO0oo(shadowTablesMap, "shadowTablesMap");
        IIX0o.x0xO0oo(viewTables, "viewTables");
        IIX0o.x0xO0oo(tableNames, "tableNames");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(tableNames.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        this.observerMap = new SafeIterableMap<>();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            String str2 = tableNames[i];
            Locale US = Locale.US;
            IIX0o.oO(US, "US");
            String lowerCase = str2.toLowerCase(US);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str3 = this.shadowTablesMap.get(tableNames[i]);
            if (str3 != null) {
                IIX0o.oO(US, "US");
                str = str3.toLowerCase(US);
                IIX0o.oO(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr[i] = lowerCase;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale US2 = Locale.US;
            IIX0o.oO(US2, "US");
            String lowerCase2 = value.toLowerCase(US2);
            IIX0o.oO(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase2)) {
                String key = entry.getKey();
                IIX0o.oO(US2, "US");
                String lowerCase3 = key.toLowerCase(US2);
                IIX0o.oO(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase3, o0.oo(map, lowerCase2));
            }
        }
        this.refreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker$refreshRunnable$1
            private final Set<Integer> checkUpdatedTable() {
                InvalidationTracker invalidationTracker = InvalidationTracker.this;
                Set oxoX2 = oX.oxoX();
                Cursor query$default = RoomDatabase.query$default(invalidationTracker.getDatabase$room_runtime_release(), new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL), null, 2, null);
                try {
                    Cursor cursor = query$default;
                    while (cursor.moveToNext()) {
                        oxoX2.add(Integer.valueOf(cursor.getInt(0)));
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    kotlin.io.II0xO0.oIX0oI(query$default, null);
                    Set<Integer> oIX0oI2 = oX.oIX0oI(oxoX2);
                    if (!oIX0oI2.isEmpty()) {
                        if (InvalidationTracker.this.getCleanupStatement$room_runtime_release() != null) {
                            SupportSQLiteStatement cleanupStatement$room_runtime_release = InvalidationTracker.this.getCleanupStatement$room_runtime_release();
                            if (cleanupStatement$room_runtime_release != null) {
                                cleanupStatement$room_runtime_release.executeUpdateDelete();
                            } else {
                                throw new IllegalArgumentException("Required value was null.");
                            }
                        } else {
                            throw new IllegalStateException("Required value was null.");
                        }
                    }
                    return oIX0oI2;
                } finally {
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
            
                if (r0 != null) goto L26;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
            
                r0.decrementCountAndScheduleClose();
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00c4, code lost:
            
                if (r2.isEmpty() != false) goto L59;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00c6, code lost:
            
                r0 = r4.this$0.getObserverMap$room_runtime_release();
                r1 = r4.this$0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x00ce, code lost:
            
                monitor-enter(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00cf, code lost:
            
                r1 = r1.getObserverMap$room_runtime_release().iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00db, code lost:
            
                if (r1.hasNext() == false) goto L69;
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x00dd, code lost:
            
                ((androidx.room.InvalidationTracker.ObserverWrapper) ((java.util.Map.Entry) r1.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(r2);
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x00ef, code lost:
            
                r1 = kotlin.oXIO0o0XI.f29392oIX0oI;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00f1, code lost:
            
                monitor-exit(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00ed, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x00f4, code lost:
            
                throw r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x00f5, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:62:0x00a6, code lost:
            
                if (r0 == null) goto L44;
             */
            /* JADX WARN: Code restructure failed: missing block: B:66:0x00bd, code lost:
            
                if (r0 == null) goto L44;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 261
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker$refreshRunnable$1.run():void");
            }
        };
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
            SupportSQLiteStatement supportSQLiteStatement = this.cleanupStatement;
            if (supportSQLiteStatement != null) {
                supportSQLiteStatement.close();
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
        }
    }

    private final String[] resolveViews(String[] strArr) {
        Set oxoX2 = oX.oxoX();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.viewTables;
            Locale US = Locale.US;
            IIX0o.oO(US, "US");
            String lowerCase = str.toLowerCase(US);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.viewTables;
                IIX0o.oO(US, "US");
                String lowerCase2 = str.toLowerCase(US);
                IIX0o.oO(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                IIX0o.ooOOo0oXI(set);
                oxoX2.addAll(set);
            } else {
                oxoX2.add(str);
            }
        }
        return (String[]) oX.oIX0oI(oxoX2).toArray(new String[0]);
    }

    private final void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.tablesNames[i];
        for (String str2 : TRIGGERS) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE " + UPDATE_TABLE_NAME + " SET " + INVALIDATED_COLUMN_NAME + " = 1 WHERE " + TABLE_ID_COLUMN_NAME + " = " + i + " AND " + INVALIDATED_COLUMN_NAME + " = 0; END";
            IIX0o.oO(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(str3);
        }
    }

    private final void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        String str = this.tablesNames[i];
        for (String str2 : TRIGGERS) {
            String str3 = "DROP TRIGGER IF EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2);
            IIX0o.oO(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(str3);
        }
    }

    private final String[] validateAndResolveTableNames(String[] strArr) {
        String[] resolveViews = resolveViews(strArr);
        for (String str : resolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale US = Locale.US;
            IIX0o.oO(US, "US");
            String lowerCase = str.toLowerCase(US);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!map.containsKey(lowerCase)) {
                throw new IllegalArgumentException(("There is no table with name " + str).toString());
            }
        }
        return resolveViews;
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void addObserver(@OXOo.OOXIXo Observer observer) {
        ObserverWrapper putIfAbsent;
        IIX0o.x0xO0oo(observer, "observer");
        String[] resolveViews = resolveViews(observer.getTables$room_runtime_release());
        ArrayList arrayList = new ArrayList(resolveViews.length);
        for (String str : resolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale US = Locale.US;
            IIX0o.oO(US, "US");
            String lowerCase = str.toLowerCase(US);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num != null) {
                arrayList.add(num);
            } else {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        int[] o0Oox0xox = CollectionsKt___CollectionsKt.o0Oox0xox(arrayList);
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, o0Oox0xox, resolveViews);
        synchronized (this.observerMap) {
            putIfAbsent = this.observerMap.putIfAbsent(observer, observerWrapper);
        }
        if (putIfAbsent == null && this.observedTableTracker.onAdded(Arrays.copyOf(o0Oox0xox, o0Oox0xox.length))) {
            syncTriggers$room_runtime_release();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(@OXOo.OOXIXo Observer observer) {
        IIX0o.x0xO0oo(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    @kotlin.OOXIXo(message = "Use [createLiveData(String[], boolean, Callable)]")
    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(@OXOo.OOXIXo String[] tableNames, @OXOo.OOXIXo Callable<T> computeFunction) {
        IIX0o.x0xO0oo(tableNames, "tableNames");
        IIX0o.x0xO0oo(computeFunction, "computeFunction");
        return createLiveData(tableNames, false, computeFunction);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpenInternal()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (!this.initialized) {
            Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
            return false;
        }
        return true;
    }

    @OXOo.oOoXoXO
    public final SupportSQLiteStatement getCleanupStatement$room_runtime_release() {
        return this.cleanupStatement;
    }

    @OXOo.OOXIXo
    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    @OXOo.OOXIXo
    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    @OXOo.OOXIXo
    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    @OXOo.OOXIXo
    public final String[] getTablesNames$room_runtime_release() {
        return this.tablesNames;
    }

    public final void internalInit$room_runtime_release(@OXOo.OOXIXo SupportSQLiteDatabase database) {
        IIX0o.x0xO0oo(database, "database");
        synchronized (this.trackerLock) {
            if (this.initialized) {
                Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers$room_runtime_release(database);
            this.cleanupStatement = database.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.initialized = true;
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void notifyObserversByTableNames(@OXOo.OOXIXo String... tables) {
        IIX0o.x0xO0oo(tables, "tables");
        synchronized (this.observerMap) {
            try {
                Iterator<Map.Entry<K, V>> it = this.observerMap.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    IIX0o.oO(entry, "(observer, wrapper)");
                    Observer observer = (Observer) entry.getKey();
                    ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                    if (!observer.isRemote$room_runtime_release()) {
                        observerWrapper.notifyByTableNames$room_runtime_release(tables);
                    }
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.autoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void removeObserver(@OXOo.OOXIXo Observer observer) {
        ObserverWrapper remove;
        IIX0o.x0xO0oo(observer, "observer");
        synchronized (this.observerMap) {
            remove = this.observerMap.remove(observer);
        }
        if (remove != null) {
            ObservedTableTracker observedTableTracker = this.observedTableTracker;
            int[] tableIds$room_runtime_release = remove.getTableIds$room_runtime_release();
            if (observedTableTracker.onRemoved(Arrays.copyOf(tableIds$room_runtime_release, tableIds$room_runtime_release.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final void setAutoCloser$room_runtime_release(@OXOo.OOXIXo AutoCloser autoCloser) {
        IIX0o.x0xO0oo(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new Runnable() { // from class: androidx.room.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                InvalidationTracker.this.onAutoCloseCallback();
            }
        });
    }

    public final void setCleanupStatement$room_runtime_release(@OXOo.oOoXoXO SupportSQLiteStatement supportSQLiteStatement) {
        this.cleanupStatement = supportSQLiteStatement;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String name, @OXOo.OOXIXo Intent serviceIntent) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(serviceIntent, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, serviceIntent, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
        this.multiInstanceInvalidationClient = null;
    }

    public final void syncTriggers$room_runtime_release(@OXOo.OOXIXo SupportSQLiteDatabase database) {
        IIX0o.x0xO0oo(database, "database");
        if (database.inTransaction()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.database.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            try {
                synchronized (this.syncTriggersLock) {
                    int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    Companion.beginTransactionInternal$room_runtime_release(database);
                    try {
                        int length = tablesToSync.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            int i3 = tablesToSync[i];
                            int i4 = i2 + 1;
                            if (i3 == 1) {
                                startTrackingTable(database, i2);
                            } else if (i3 == 2) {
                                stopTrackingTable(database, i2);
                            }
                            i++;
                            i2 = i4;
                        }
                        database.setTransactionSuccessful();
                        database.endTransaction();
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    } catch (Throwable th) {
                        database.endTransaction();
                        throw th;
                    }
                }
            } finally {
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
        } catch (IllegalStateException e2) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e2);
        }
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(@OXOo.OOXIXo String[] tableNames, boolean z, @OXOo.OOXIXo Callable<T> computeFunction) {
        IIX0o.x0xO0oo(tableNames, "tableNames");
        IIX0o.x0xO0oo(computeFunction, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(tableNames), z, computeFunction);
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpenInternal()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(@OXOo.OOXIXo RoomDatabase database, @OXOo.OOXIXo String... tableNames) {
        this(database, o0.O0xOxO(), o0.O0xOxO(), (String[]) Arrays.copyOf(tableNames, tableNames.length));
        IIX0o.x0xO0oo(database, "database");
        IIX0o.x0xO0oo(tableNames, "tableNames");
    }
}
