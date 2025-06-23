package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.xxIXOIIO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpDelete;
import com.huawei.openalliance.ad.constant.bn;
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
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;

@XX({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,840:1\n215#2,2:841\n11335#3:843\n11670#3,3:844\n13579#3,2:847\n13579#3,2:849\n13674#3,3:855\n37#4,2:851\n1855#5,2:853\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker\n*L\n102#1:841,2\n250#1:843\n250#1:844,3\n271#1:847,2\n287#1:849,2\n491#1:855,3\n294#1:851,2\n467#1:853,2\n*E\n"})
public class InvalidationTracker {
    @OOXIXo
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    @OOXIXo
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    @OOXIXo
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    @OOXIXo
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    @OOXIXo
    private static final String[] TRIGGERS = {"UPDATE", HttpDelete.METHOD_NAME, "INSERT"};
    @OOXIXo
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    /* access modifiers changed from: private */
    @oOoXoXO
    public AutoCloser autoCloser;
    @oOoXoXO
    private volatile SupportSQLiteStatement cleanupStatement;
    @OOXIXo
    private final RoomDatabase database;
    private volatile boolean initialized;
    @OOXIXo
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    @oOoXoXO
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    @OOXIXo
    private final ObservedTableTracker observedTableTracker;
    @GuardedBy("observerMap")
    @OOXIXo
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final AtomicBoolean pendingRefresh;
    @XO
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final Runnable refreshRunnable;
    @OOXIXo
    private final Map<String, String> shadowTablesMap;
    @OOXIXo
    private final Object syncTriggersLock;
    @OOXIXo
    private final Map<String, Integer> tableIdLookup;
    @OOXIXo
    private final String[] tablesNames;
    @OOXIXo
    private final Object trackerLock;
    @OOXIXo
    private final Map<String, Set<String>> viewTables;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public final void beginTransactionInternal$room_runtime_release(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, "database");
            if (supportSQLiteDatabase.isWriteAheadLoggingEnabled()) {
                supportSQLiteDatabase.beginTransactionNonExclusive();
            } else {
                supportSQLiteDatabase.beginTransaction();
            }
        }

        @OOXIXo
        public final String getTriggerName$room_runtime_release(@OOXIXo String str, @OOXIXo String str2) {
            IIX0o.x0xO0oo(str, "tableName");
            IIX0o.x0xO0oo(str2, "triggerType");
            return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
        }

        private Companion() {
        }
    }

    @XX({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$ObservedTableTracker\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,840:1\n13600#2,2:841\n13600#2,2:843\n13684#2,3:845\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$ObservedTableTracker\n*L\n711#1:841,2\n729#1:843,2\n765#1:845,3\n*E\n"})
    public static final class ObservedTableTracker {
        public static final int ADD = 1;
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;
        @OOXIXo
        private final long[] tableObservers;
        @OOXIXo
        private final int[] triggerStateChanges;
        @OOXIXo
        private final boolean[] triggerStates;

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
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

        @OOXIXo
        public final long[] getTableObservers() {
            return this.tableObservers;
        }

        @VisibleForTesting
        @oOoXoXO
        @xxIXOIIO(name = "getTablesToSync")
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
                    int[] iArr2 = (int[]) this.triggerStateChanges.clone();
                    return iArr2;
                } finally {
                }
            }
        }

        public final boolean onAdded(@OOXIXo int... iArr) {
            boolean z;
            IIX0o.x0xO0oo(iArr, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : iArr) {
                        long[] jArr = this.tableObservers;
                        long j = jArr[i];
                        jArr[i] = 1 + j;
                        if (j == 0) {
                            z = true;
                            this.needsSync = true;
                        }
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
                } finally {
                }
            }
            return z;
        }

        public final boolean onRemoved(@OOXIXo int... iArr) {
            boolean z;
            IIX0o.x0xO0oo(iArr, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : iArr) {
                        long[] jArr = this.tableObservers;
                        long j = jArr[i];
                        jArr[i] = j - 1;
                        if (j == 1) {
                            z = true;
                            this.needsSync = true;
                        }
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
                } finally {
                }
            }
            return z;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            }
        }

        public final void setNeedsSync(boolean z) {
            this.needsSync = z;
        }
    }

    @XX({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$Observer\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,840:1\n37#2,2:841\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$Observer\n*L\n670#1:841,2\n*E\n"})
    public static abstract class Observer {
        @OOXIXo
        private final String[] tables;

        public Observer(@OOXIXo String[] strArr) {
            IIX0o.x0xO0oo(strArr, "tables");
            this.tables = strArr;
        }

        @OOXIXo
        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(@OOXIXo Set<String> set);

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
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
    public static final class ObserverWrapper {
        @OOXIXo
        private final Observer observer;
        @OOXIXo
        private final Set<String> singleTableSet;
        @OOXIXo
        private final int[] tableIds;
        @OOXIXo
        private final String[] tableNames;

        public ObserverWrapper(@OOXIXo Observer observer2, @OOXIXo int[] iArr, @OOXIXo String[] strArr) {
            boolean z;
            Set<String> set;
            IIX0o.x0xO0oo(observer2, "observer");
            IIX0o.x0xO0oo(iArr, "tableIds");
            IIX0o.x0xO0oo(strArr, "tableNames");
            this.observer = observer2;
            this.tableIds = iArr;
            this.tableNames = strArr;
            if (strArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                set = oX.XO(strArr[0]);
            } else {
                set = Xo0.OOXIXo();
            }
            this.singleTableSet = set;
            if (iArr.length != strArr.length) {
                throw new IllegalStateException("Check failed.");
            }
        }

        @OOXIXo
        public final Observer getObserver$room_runtime_release() {
            return this.observer;
        }

        @OOXIXo
        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(@OOXIXo Set<Integer> set) {
            Set<String> set2;
            IIX0o.x0xO0oo(set, "invalidatedTablesIds");
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
                        if (set.contains(Integer.valueOf(iArr2[i]))) {
                            oxoX2.add(this.tableNames[i2]);
                        }
                        i++;
                        i2 = i3;
                    }
                    set2 = oX.oIX0oI(oxoX2);
                } else if (set.contains(Integer.valueOf(iArr[0]))) {
                    set2 = this.singleTableSet;
                } else {
                    set2 = Xo0.OOXIXo();
                }
            } else {
                set2 = Xo0.OOXIXo();
            }
            if (!set2.isEmpty()) {
                this.observer.onInvalidated(set2);
            }
        }

        public final void notifyByTableNames$room_runtime_release(@OOXIXo String[] strArr) {
            Set<String> set;
            IIX0o.x0xO0oo(strArr, "tables");
            int length = this.tableNames.length;
            if (length != 0) {
                if (length == 1) {
                    int length2 = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length2) {
                            set = Xo0.OOXIXo();
                            break;
                        } else if (OxI.oX0I0O(strArr[i], this.tableNames[0], true)) {
                            set = this.singleTableSet;
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    Set oxoX2 = oX.oxoX();
                    for (String str : strArr) {
                        for (String str2 : this.tableNames) {
                            if (OxI.oX0I0O(str2, str, true)) {
                                oxoX2.add(str2);
                            }
                        }
                    }
                    set = oX.oIX0oI(oxoX2);
                }
            } else {
                set = Xo0.OOXIXo();
            }
            if (!set.isEmpty()) {
                this.observer.onInvalidated(set);
            }
        }
    }

    public static final class WeakObserver extends Observer {
        @OOXIXo
        private final WeakReference<Observer> delegateRef;
        @OOXIXo
        private final InvalidationTracker tracker;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WeakObserver(@OOXIXo InvalidationTracker invalidationTracker, @OOXIXo Observer observer) {
            super(observer.getTables$room_runtime_release());
            IIX0o.x0xO0oo(invalidationTracker, "tracker");
            IIX0o.x0xO0oo(observer, "delegate");
            this.tracker = invalidationTracker;
            this.delegateRef = new WeakReference<>(observer);
        }

        @OOXIXo
        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        @OOXIXo
        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        public void onInvalidated(@OOXIXo Set<String> set) {
            IIX0o.x0xO0oo(set, "tables");
            Observer observer = this.delegateRef.get();
            if (observer == null) {
                this.tracker.removeObserver(this);
            } else {
                observer.onInvalidated(set);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(@OOXIXo RoomDatabase roomDatabase, @OOXIXo Map<String, String> map, @OOXIXo Map<String, Set<String>> map2, @OOXIXo String... strArr) {
        String str;
        IIX0o.x0xO0oo(roomDatabase, "database");
        IIX0o.x0xO0oo(map, "shadowTablesMap");
        IIX0o.x0xO0oo(map2, "viewTables");
        IIX0o.x0xO0oo(strArr, "tableNames");
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.viewTables = map2;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(strArr.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(roomDatabase);
        this.observerMap = new SafeIterableMap<>();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArr[i];
            Locale locale = Locale.US;
            IIX0o.oO(locale, "US");
            String lowerCase = str2.toLowerCase(locale);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str3 = this.shadowTablesMap.get(strArr[i]);
            if (str3 != null) {
                IIX0o.oO(locale, "US");
                str = str3.toLowerCase(locale);
                IIX0o.oO(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr2[i] = lowerCase;
        }
        this.tablesNames = strArr2;
        for (Map.Entry next : this.shadowTablesMap.entrySet()) {
            Locale locale2 = Locale.US;
            IIX0o.oO(locale2, "US");
            String lowerCase2 = ((String) next.getValue()).toLowerCase(locale2);
            IIX0o.oO(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase2)) {
                IIX0o.oO(locale2, "US");
                String lowerCase3 = ((String) next.getKey()).toLowerCase(locale2);
                IIX0o.oO(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                Map map3 = this.tableIdLookup;
                map3.put(lowerCase3, o0.oo(map3, lowerCase2));
            }
        }
        this.refreshRunnable = new InvalidationTracker$refreshRunnable$1(this);
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    /* access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
            SupportSQLiteStatement supportSQLiteStatement = this.cleanupStatement;
            if (supportSQLiteStatement != null) {
                supportSQLiteStatement.close();
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            }
        }
    }

    private final String[] resolveViews(String[] strArr) {
        Set oxoX2 = oX.oxoX();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.viewTables;
            Locale locale = Locale.US;
            IIX0o.oO(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.viewTables;
                IIX0o.oO(locale, "US");
                String lowerCase2 = str.toLowerCase(locale);
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
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE " + UPDATE_TABLE_NAME + " SET " + INVALIDATED_COLUMN_NAME + " = 1" + " WHERE " + TABLE_ID_COLUMN_NAME + " = " + i + " AND " + INVALIDATED_COLUMN_NAME + " = 0" + "; END";
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
        int length = resolveViews.length;
        int i = 0;
        while (i < length) {
            String str = resolveViews[i];
            Map<String, Integer> map = this.tableIdLookup;
            Locale locale = Locale.US;
            IIX0o.oO(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                i++;
            } else {
                throw new IllegalArgumentException(("There is no table with name " + str).toString());
            }
        }
        return resolveViews;
    }

    @WorkerThread
    @SuppressLint({"RestrictedApi"})
    public void addObserver(@OOXIXo Observer observer) {
        ObserverWrapper putIfAbsent;
        IIX0o.x0xO0oo(observer, "observer");
        String[] resolveViews = resolveViews(observer.getTables$room_runtime_release());
        ArrayList arrayList = new ArrayList(resolveViews.length);
        int length = resolveViews.length;
        int i = 0;
        while (i < length) {
            String str = resolveViews[i];
            Map<String, Integer> map = this.tableIdLookup;
            Locale locale = Locale.US;
            IIX0o.oO(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num != null) {
                arrayList.add(num);
                i++;
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
    public void addWeakObserver(@OOXIXo Observer observer) {
        IIX0o.x0xO0oo(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @kotlin.OOXIXo(message = "Use [createLiveData(String[], boolean, Callable)]")
    @OOXIXo
    public <T> LiveData<T> createLiveData(@OOXIXo String[] strArr, @OOXIXo Callable<T> callable) {
        IIX0o.x0xO0oo(strArr, "tableNames");
        IIX0o.x0xO0oo(callable, "computeFunction");
        return createLiveData(strArr, false, callable);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpenInternal()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (this.initialized) {
            return true;
        }
        Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
        return false;
    }

    @oOoXoXO
    public final SupportSQLiteStatement getCleanupStatement$room_runtime_release() {
        return this.cleanupStatement;
    }

    @OOXIXo
    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    @OOXIXo
    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    @OOXIXo
    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    @OOXIXo
    public final String[] getTablesNames$room_runtime_release() {
        return this.tablesNames;
    }

    public final void internalInit$room_runtime_release(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, "database");
        synchronized (this.trackerLock) {
            if (this.initialized) {
                Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers$room_runtime_release(supportSQLiteDatabase);
            this.cleanupStatement = supportSQLiteDatabase.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.initialized = true;
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void notifyObserversByTableNames(@OOXIXo String... strArr) {
        IIX0o.x0xO0oo(strArr, "tables");
        synchronized (this.observerMap) {
            try {
                Iterator<T> it = this.observerMap.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    IIX0o.oO(entry, "(observer, wrapper)");
                    ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                    if (!((Observer) entry.getKey()).isRemote$room_runtime_release()) {
                        observerWrapper.notifyByTableNames$room_runtime_release(strArr);
                    }
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } finally {
            }
        }
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser2 = this.autoCloser;
            if (autoCloser2 != null) {
                autoCloser2.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void refreshVersionsSync() {
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 != null) {
            autoCloser2.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    @WorkerThread
    @SuppressLint({"RestrictedApi"})
    public void removeObserver(@OOXIXo Observer observer) {
        ObserverWrapper remove;
        IIX0o.x0xO0oo(observer, "observer");
        synchronized (this.observerMap) {
            remove = this.observerMap.remove(observer);
        }
        if (remove != null) {
            ObservedTableTracker observedTableTracker2 = this.observedTableTracker;
            int[] tableIds$room_runtime_release = remove.getTableIds$room_runtime_release();
            if (observedTableTracker2.onRemoved(Arrays.copyOf(tableIds$room_runtime_release, tableIds$room_runtime_release.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final void setAutoCloser$room_runtime_release(@OOXIXo AutoCloser autoCloser2) {
        IIX0o.x0xO0oo(autoCloser2, "autoCloser");
        this.autoCloser = autoCloser2;
        autoCloser2.setAutoCloseCallback(new I0Io(this));
    }

    public final void setCleanupStatement$room_runtime_release(@oOoXoXO SupportSQLiteStatement supportSQLiteStatement) {
        this.cleanupStatement = supportSQLiteStatement;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(@OOXIXo Context context, @OOXIXo String str, @OOXIXo Intent intent) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(intent, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, str, intent, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient2 != null) {
            multiInstanceInvalidationClient2.stop();
        }
        this.multiInstanceInvalidationClient = null;
    }

    public final void syncTriggers$room_runtime_release(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        Lock closeLock$room_runtime_release;
        IIX0o.x0xO0oo(supportSQLiteDatabase, "database");
        if (!supportSQLiteDatabase.inTransaction()) {
            try {
                closeLock$room_runtime_release = this.database.getCloseLock$room_runtime_release();
                closeLock$room_runtime_release.lock();
                synchronized (this.syncTriggersLock) {
                    int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        closeLock$room_runtime_release.unlock();
                        return;
                    }
                    Companion.beginTransactionInternal$room_runtime_release(supportSQLiteDatabase);
                    try {
                        int length = tablesToSync.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            int i3 = tablesToSync[i];
                            int i4 = i2 + 1;
                            if (i3 == 1) {
                                startTrackingTable(supportSQLiteDatabase, i2);
                            } else if (i3 == 2) {
                                stopTrackingTable(supportSQLiteDatabase, i2);
                            }
                            i++;
                            i2 = i4;
                        }
                        supportSQLiteDatabase.setTransactionSuccessful();
                        supportSQLiteDatabase.endTransaction();
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
                        closeLock$room_runtime_release.unlock();
                    } finally {
                        supportSQLiteDatabase.endTransaction();
                    }
                }
            } catch (IllegalStateException e) {
                Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
            } catch (SQLiteException e2) {
                Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e2);
            } catch (Throwable th) {
                closeLock$room_runtime_release.unlock();
                throw th;
            }
        }
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(@OOXIXo String[] strArr, boolean z, @OOXIXo Callable<T> callable) {
        IIX0o.x0xO0oo(strArr, "tableNames");
        IIX0o.x0xO0oo(callable, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(strArr), z, callable);
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpenInternal()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(@OOXIXo RoomDatabase roomDatabase, @OOXIXo String... strArr) {
        this(roomDatabase, o0.O0xOxO(), o0.O0xOxO(), (String[]) Arrays.copyOf(strArr, strArr.length));
        IIX0o.x0xO0oo(roomDatabase, "database");
        IIX0o.x0xO0oo(strArr, "tableNames");
    }
}
