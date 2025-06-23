package androidx.work.impl.model;

import Oox.oOoXoXO;
import XXO0.oIX0oI;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.NetworkRequestCompat;
import com.google.android.exoplayer2.offline.DownloadService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(@NonNull final HashMap<String, ArrayList<Data>> _map) {
        Set<String> keySet = _map.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchHashMap(_map, true, new oOoXoXO() { // from class: androidx.work.impl.model.II0xO0
                @Override // Oox.oOoXoXO
                public final Object invoke(Object obj) {
                    oXIO0o0XI lambda$__fetchRelationshipWorkProgressAsandroidxWorkData$1;
                    lambda$__fetchRelationshipWorkProgressAsandroidxWorkData$1 = RawWorkInfoDao_Impl.this.lambda$__fetchRelationshipWorkProgressAsandroidxWorkData$1((HashMap) obj);
                    return lambda$__fetchRelationshipWorkProgressAsandroidxWorkData$1;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(oIX0oI.I0Io.f4095I0Io);
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        Iterator<String> it = keySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            acquire.bindString(i, it.next());
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<Data> arrayList = _map.get(query.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(Data.fromByteArray(query.getBlob(0)));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(@NonNull final HashMap<String, ArrayList<String>> _map) {
        Set<String> keySet = _map.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchHashMap(_map, true, new oOoXoXO() { // from class: androidx.work.impl.model.oIX0oI
                @Override // Oox.oOoXoXO
                public final Object invoke(Object obj) {
                    oXIO0o0XI lambda$__fetchRelationshipWorkTagAsjavaLangString$0;
                    lambda$__fetchRelationshipWorkTagAsjavaLangString$0 = RawWorkInfoDao_Impl.this.lambda$__fetchRelationshipWorkTagAsjavaLangString$0((HashMap) obj);
                    return lambda$__fetchRelationshipWorkTagAsjavaLangString$0;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(oIX0oI.I0Io.f4095I0Io);
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        Iterator<String> it = keySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            acquire.bindString(i, it.next());
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<String> arrayList = _map.get(query.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(query.getString(0));
                }
            }
        } finally {
            query.close();
        }
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ oXIO0o0XI lambda$__fetchRelationshipWorkProgressAsandroidxWorkData$1(HashMap hashMap) {
        __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap);
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ oXIO0o0XI lambda$__fetchRelationshipWorkTagAsjavaLangString$0(HashMap hashMap) {
        __fetchRelationshipWorkTagAsjavaLangString(hashMap);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(final SupportSQLiteQuery query) {
        String string;
        WorkInfo.State intToState;
        Data fromByteArray;
        long j;
        long j2;
        long j3;
        int i;
        BackoffPolicy intToBackoffPolicy;
        long j4;
        long j5;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j6;
        int i7;
        int i8;
        NetworkType intToNetworkType;
        int i9;
        NetworkRequestCompat networkRequest$work_runtime_release;
        int i10;
        boolean z;
        boolean z2;
        int i11;
        boolean z3;
        boolean z4;
        int i12;
        boolean z5;
        boolean z6;
        int i13;
        int i14;
        boolean z7;
        long j7;
        int i15;
        Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers;
        int i16;
        this.__db.assertNotSuspendingTransaction();
        Cursor query2 = DBUtil.query(this.__db, query, true, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query2, "id");
            int columnIndex2 = CursorUtil.getColumnIndex(query2, "state");
            int columnIndex3 = CursorUtil.getColumnIndex(query2, "output");
            int columnIndex4 = CursorUtil.getColumnIndex(query2, "initial_delay");
            int columnIndex5 = CursorUtil.getColumnIndex(query2, "interval_duration");
            int columnIndex6 = CursorUtil.getColumnIndex(query2, "flex_duration");
            int columnIndex7 = CursorUtil.getColumnIndex(query2, "run_attempt_count");
            int columnIndex8 = CursorUtil.getColumnIndex(query2, "backoff_policy");
            int columnIndex9 = CursorUtil.getColumnIndex(query2, "backoff_delay_duration");
            int columnIndex10 = CursorUtil.getColumnIndex(query2, "last_enqueue_time");
            int columnIndex11 = CursorUtil.getColumnIndex(query2, "period_count");
            int columnIndex12 = CursorUtil.getColumnIndex(query2, "generation");
            int columnIndex13 = CursorUtil.getColumnIndex(query2, "next_schedule_time_override");
            int columnIndex14 = CursorUtil.getColumnIndex(query2, DownloadService.KEY_STOP_REASON);
            int columnIndex15 = CursorUtil.getColumnIndex(query2, "required_network_type");
            int columnIndex16 = CursorUtil.getColumnIndex(query2, "required_network_request");
            int columnIndex17 = CursorUtil.getColumnIndex(query2, "requires_charging");
            int columnIndex18 = CursorUtil.getColumnIndex(query2, "requires_device_idle");
            int columnIndex19 = CursorUtil.getColumnIndex(query2, "requires_battery_not_low");
            int columnIndex20 = CursorUtil.getColumnIndex(query2, "requires_storage_not_low");
            int columnIndex21 = CursorUtil.getColumnIndex(query2, "trigger_content_update_delay");
            int columnIndex22 = CursorUtil.getColumnIndex(query2, "trigger_max_content_delay");
            int columnIndex23 = CursorUtil.getColumnIndex(query2, "content_uri_triggers");
            HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
            int i17 = columnIndex13;
            HashMap<String, ArrayList<Data>> hashMap2 = new HashMap<>();
            while (query2.moveToNext()) {
                int i18 = columnIndex12;
                String string2 = query2.getString(columnIndex);
                if (!hashMap.containsKey(string2)) {
                    i16 = columnIndex11;
                    hashMap.put(string2, new ArrayList<>());
                } else {
                    i16 = columnIndex11;
                }
                String string3 = query2.getString(columnIndex);
                if (!hashMap2.containsKey(string3)) {
                    hashMap2.put(string3, new ArrayList<>());
                }
                columnIndex12 = i18;
                columnIndex11 = i16;
            }
            int i19 = columnIndex11;
            int i20 = columnIndex12;
            query2.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(hashMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
            ArrayList arrayList = new ArrayList(query2.getCount());
            while (query2.moveToNext()) {
                if (columnIndex == -1) {
                    string = null;
                } else {
                    string = query2.getString(columnIndex);
                }
                if (columnIndex2 == -1) {
                    intToState = null;
                } else {
                    int i21 = query2.getInt(columnIndex2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    intToState = WorkTypeConverters.intToState(i21);
                }
                if (columnIndex3 == -1) {
                    fromByteArray = null;
                } else {
                    fromByteArray = Data.fromByteArray(query2.getBlob(columnIndex3));
                }
                long j8 = 0;
                if (columnIndex4 == -1) {
                    j = 0;
                } else {
                    j = query2.getLong(columnIndex4);
                }
                if (columnIndex5 == -1) {
                    j2 = 0;
                } else {
                    j2 = query2.getLong(columnIndex5);
                }
                if (columnIndex6 == -1) {
                    j3 = 0;
                } else {
                    j3 = query2.getLong(columnIndex6);
                }
                boolean z8 = false;
                if (columnIndex7 == -1) {
                    i = 0;
                } else {
                    i = query2.getInt(columnIndex7);
                }
                if (columnIndex8 == -1) {
                    intToBackoffPolicy = null;
                } else {
                    int i22 = query2.getInt(columnIndex8);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i22);
                }
                if (columnIndex9 == -1) {
                    j4 = 0;
                } else {
                    j4 = query2.getLong(columnIndex9);
                }
                if (columnIndex10 == -1) {
                    i2 = i19;
                    j5 = 0;
                } else {
                    j5 = query2.getLong(columnIndex10);
                    i2 = i19;
                }
                if (i2 == -1) {
                    i19 = i2;
                    i4 = i20;
                    i3 = 0;
                } else {
                    i3 = query2.getInt(i2);
                    i19 = i2;
                    i4 = i20;
                }
                if (i4 == -1) {
                    i20 = i4;
                    i6 = i17;
                    i5 = 0;
                } else {
                    i5 = query2.getInt(i4);
                    i20 = i4;
                    i6 = i17;
                }
                if (i6 == -1) {
                    i17 = i6;
                    j6 = 0;
                } else {
                    j6 = query2.getLong(i6);
                    i17 = i6;
                }
                int i23 = columnIndex14;
                if (i23 == -1) {
                    columnIndex14 = i23;
                    i8 = columnIndex15;
                    i7 = 0;
                } else {
                    i7 = query2.getInt(i23);
                    columnIndex14 = i23;
                    i8 = columnIndex15;
                }
                if (i8 == -1) {
                    columnIndex15 = i8;
                    i9 = columnIndex16;
                    intToNetworkType = null;
                } else {
                    int i24 = query2.getInt(i8);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    intToNetworkType = WorkTypeConverters.intToNetworkType(i24);
                    columnIndex15 = i8;
                    i9 = columnIndex16;
                }
                if (i9 == -1) {
                    columnIndex16 = i9;
                    i10 = columnIndex17;
                    networkRequest$work_runtime_release = null;
                } else {
                    byte[] blob = query2.getBlob(i9);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    columnIndex16 = i9;
                    i10 = columnIndex17;
                }
                if (i10 == -1) {
                    columnIndex17 = i10;
                    i11 = columnIndex18;
                    z2 = false;
                } else {
                    if (query2.getInt(i10) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z;
                    columnIndex17 = i10;
                    i11 = columnIndex18;
                }
                if (i11 == -1) {
                    columnIndex18 = i11;
                    i12 = columnIndex19;
                    z4 = false;
                } else {
                    if (query2.getInt(i11) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 = z3;
                    columnIndex18 = i11;
                    i12 = columnIndex19;
                }
                if (i12 == -1) {
                    columnIndex19 = i12;
                    i13 = columnIndex20;
                    z6 = false;
                } else {
                    if (query2.getInt(i12) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z5;
                    columnIndex19 = i12;
                    i13 = columnIndex20;
                }
                if (i13 == -1) {
                    columnIndex20 = i13;
                    i14 = columnIndex21;
                    z7 = false;
                } else {
                    if (query2.getInt(i13) != 0) {
                        z8 = true;
                    }
                    columnIndex20 = i13;
                    i14 = columnIndex21;
                    z7 = z8;
                }
                if (i14 == -1) {
                    columnIndex21 = i14;
                    i15 = columnIndex22;
                    j7 = 0;
                } else {
                    j7 = query2.getLong(i14);
                    columnIndex21 = i14;
                    i15 = columnIndex22;
                }
                if (i15 != -1) {
                    j8 = query2.getLong(i15);
                }
                columnIndex22 = i15;
                int i25 = columnIndex23;
                long j9 = j8;
                if (i25 == -1) {
                    byteArrayToSetOfTriggers = null;
                } else {
                    byte[] blob2 = query2.getBlob(i25);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    byteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(blob2);
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(string, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z2, z4, z6, z7, j7, j9, byteArrayToSetOfTriggers), i, intToBackoffPolicy, j4, j5, i3, i5, j6, i7, hashMap.get(query2.getString(columnIndex)), hashMap2.get(query2.getString(columnIndex))));
                columnIndex23 = i25;
            }
            query2.close();
            return arrayList;
        } catch (Throwable th) {
            query2.close();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public kotlinx.coroutines.flow.X0o0xo<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(final SupportSQLiteQuery query) {
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.2
            @Override // java.util.concurrent.Callable
            @NonNull
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkInfo.State intToState;
                BackoffPolicy intToBackoffPolicy;
                long j;
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                long j2;
                int i6;
                int i7;
                int i8;
                NetworkType intToNetworkType;
                int i9;
                NetworkRequestCompat networkRequest$work_runtime_release;
                int i10;
                boolean z;
                int i11;
                boolean z2;
                int i12;
                boolean z3;
                int i13;
                int i14;
                boolean z4;
                long j3;
                int i15;
                Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers;
                int i16;
                Cursor query2 = DBUtil.query(RawWorkInfoDao_Impl.this.__db, query, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(query2, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(query2, "state");
                    int columnIndex3 = CursorUtil.getColumnIndex(query2, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(query2, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(query2, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(query2, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(query2, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(query2, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(query2, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(query2, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(query2, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(query2, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(query2, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(query2, DownloadService.KEY_STOP_REASON);
                    int columnIndex15 = CursorUtil.getColumnIndex(query2, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(query2, "required_network_request");
                    int columnIndex17 = CursorUtil.getColumnIndex(query2, "requires_charging");
                    int columnIndex18 = CursorUtil.getColumnIndex(query2, "requires_device_idle");
                    int columnIndex19 = CursorUtil.getColumnIndex(query2, "requires_battery_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(query2, "requires_storage_not_low");
                    int columnIndex21 = CursorUtil.getColumnIndex(query2, "trigger_content_update_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(query2, "trigger_max_content_delay");
                    int columnIndex23 = CursorUtil.getColumnIndex(query2, "content_uri_triggers");
                    HashMap hashMap = new HashMap();
                    int i17 = columnIndex13;
                    HashMap hashMap2 = new HashMap();
                    while (query2.moveToNext()) {
                        int i18 = columnIndex12;
                        String string = query2.getString(columnIndex);
                        if (hashMap.containsKey(string)) {
                            i16 = columnIndex11;
                        } else {
                            i16 = columnIndex11;
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = query2.getString(columnIndex);
                        if (!hashMap2.containsKey(string2)) {
                            hashMap2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i18;
                        columnIndex11 = i16;
                    }
                    int i19 = columnIndex11;
                    int i20 = columnIndex12;
                    query2.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query2.getCount());
                    while (query2.moveToNext()) {
                        String string3 = columnIndex == -1 ? null : query2.getString(columnIndex);
                        if (columnIndex2 == -1) {
                            intToState = null;
                        } else {
                            int i21 = query2.getInt(columnIndex2);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            intToState = WorkTypeConverters.intToState(i21);
                        }
                        Data fromByteArray = columnIndex3 == -1 ? null : Data.fromByteArray(query2.getBlob(columnIndex3));
                        long j4 = columnIndex4 == -1 ? 0L : query2.getLong(columnIndex4);
                        long j5 = columnIndex5 == -1 ? 0L : query2.getLong(columnIndex5);
                        long j6 = columnIndex6 == -1 ? 0L : query2.getLong(columnIndex6);
                        int i22 = columnIndex7 == -1 ? 0 : query2.getInt(columnIndex7);
                        if (columnIndex8 == -1) {
                            intToBackoffPolicy = null;
                        } else {
                            int i23 = query2.getInt(columnIndex8);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i23);
                        }
                        long j7 = columnIndex9 == -1 ? 0L : query2.getLong(columnIndex9);
                        if (columnIndex10 == -1) {
                            i = i19;
                            j = 0;
                        } else {
                            j = query2.getLong(columnIndex10);
                            i = i19;
                        }
                        if (i == -1) {
                            i19 = i;
                            i3 = i20;
                            i2 = 0;
                        } else {
                            i2 = query2.getInt(i);
                            i19 = i;
                            i3 = i20;
                        }
                        if (i3 == -1) {
                            i20 = i3;
                            i5 = i17;
                            i4 = 0;
                        } else {
                            i4 = query2.getInt(i3);
                            i20 = i3;
                            i5 = i17;
                        }
                        if (i5 == -1) {
                            i17 = i5;
                            i6 = columnIndex14;
                            j2 = 0;
                        } else {
                            j2 = query2.getLong(i5);
                            i17 = i5;
                            i6 = columnIndex14;
                        }
                        if (i6 == -1) {
                            columnIndex14 = i6;
                            i8 = columnIndex15;
                            i7 = 0;
                        } else {
                            i7 = query2.getInt(i6);
                            columnIndex14 = i6;
                            i8 = columnIndex15;
                        }
                        if (i8 == -1) {
                            columnIndex15 = i8;
                            i9 = columnIndex16;
                            intToNetworkType = null;
                        } else {
                            int i24 = query2.getInt(i8);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            intToNetworkType = WorkTypeConverters.intToNetworkType(i24);
                            columnIndex15 = i8;
                            i9 = columnIndex16;
                        }
                        if (i9 == -1) {
                            columnIndex16 = i9;
                            i10 = columnIndex17;
                            networkRequest$work_runtime_release = null;
                        } else {
                            byte[] blob = query2.getBlob(i9);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                            columnIndex16 = i9;
                            i10 = columnIndex17;
                        }
                        if (i10 == -1) {
                            columnIndex17 = i10;
                            i11 = columnIndex18;
                            z = false;
                        } else {
                            z = query2.getInt(i10) != 0;
                            columnIndex17 = i10;
                            i11 = columnIndex18;
                        }
                        if (i11 == -1) {
                            columnIndex18 = i11;
                            i12 = columnIndex19;
                            z2 = false;
                        } else {
                            z2 = query2.getInt(i11) != 0;
                            columnIndex18 = i11;
                            i12 = columnIndex19;
                        }
                        if (i12 == -1) {
                            columnIndex19 = i12;
                            i13 = columnIndex20;
                            z3 = false;
                        } else {
                            z3 = query2.getInt(i12) != 0;
                            columnIndex19 = i12;
                            i13 = columnIndex20;
                        }
                        if (i13 == -1) {
                            columnIndex20 = i13;
                            i14 = columnIndex21;
                            z4 = false;
                        } else {
                            boolean z5 = query2.getInt(i13) != 0;
                            columnIndex20 = i13;
                            i14 = columnIndex21;
                            z4 = z5;
                        }
                        if (i14 == -1) {
                            columnIndex21 = i14;
                            i15 = columnIndex22;
                            j3 = 0;
                        } else {
                            j3 = query2.getLong(i14);
                            columnIndex21 = i14;
                            i15 = columnIndex22;
                        }
                        long j8 = i15 != -1 ? query2.getLong(i15) : 0L;
                        columnIndex22 = i15;
                        int i25 = columnIndex23;
                        long j9 = j8;
                        if (i25 == -1) {
                            byteArrayToSetOfTriggers = null;
                        } else {
                            byte[] blob2 = query2.getBlob(i25);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            byteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(blob2);
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j4, j5, j6, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j3, j9, byteArrayToSetOfTriggers), i22, intToBackoffPolicy, j7, j, i2, i4, j2, i7, (ArrayList) hashMap.get(query2.getString(columnIndex)), (ArrayList) hashMap2.get(query2.getString(columnIndex))));
                        columnIndex23 = i25;
                    }
                    query2.close();
                    return arrayList;
                } catch (Throwable th) {
                    query2.close();
                    throw th;
                }
            }
        });
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery query) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.1
            @Override // java.util.concurrent.Callable
            @Nullable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkInfo.State intToState;
                BackoffPolicy intToBackoffPolicy;
                long j;
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                long j2;
                int i6;
                int i7;
                int i8;
                NetworkType intToNetworkType;
                int i9;
                NetworkRequestCompat networkRequest$work_runtime_release;
                int i10;
                boolean z;
                int i11;
                boolean z2;
                int i12;
                boolean z3;
                int i13;
                int i14;
                boolean z4;
                long j3;
                int i15;
                Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers;
                int i16;
                Cursor query2 = DBUtil.query(RawWorkInfoDao_Impl.this.__db, query, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(query2, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(query2, "state");
                    int columnIndex3 = CursorUtil.getColumnIndex(query2, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(query2, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(query2, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(query2, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(query2, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(query2, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(query2, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(query2, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(query2, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(query2, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(query2, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(query2, DownloadService.KEY_STOP_REASON);
                    int columnIndex15 = CursorUtil.getColumnIndex(query2, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(query2, "required_network_request");
                    int columnIndex17 = CursorUtil.getColumnIndex(query2, "requires_charging");
                    int columnIndex18 = CursorUtil.getColumnIndex(query2, "requires_device_idle");
                    int columnIndex19 = CursorUtil.getColumnIndex(query2, "requires_battery_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(query2, "requires_storage_not_low");
                    int columnIndex21 = CursorUtil.getColumnIndex(query2, "trigger_content_update_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(query2, "trigger_max_content_delay");
                    int columnIndex23 = CursorUtil.getColumnIndex(query2, "content_uri_triggers");
                    HashMap hashMap = new HashMap();
                    int i17 = columnIndex13;
                    HashMap hashMap2 = new HashMap();
                    while (query2.moveToNext()) {
                        int i18 = columnIndex12;
                        String string = query2.getString(columnIndex);
                        if (hashMap.containsKey(string)) {
                            i16 = columnIndex11;
                        } else {
                            i16 = columnIndex11;
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = query2.getString(columnIndex);
                        if (!hashMap2.containsKey(string2)) {
                            hashMap2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i18;
                        columnIndex11 = i16;
                    }
                    int i19 = columnIndex11;
                    int i20 = columnIndex12;
                    query2.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query2.getCount());
                    while (query2.moveToNext()) {
                        String string3 = columnIndex == -1 ? null : query2.getString(columnIndex);
                        if (columnIndex2 == -1) {
                            intToState = null;
                        } else {
                            int i21 = query2.getInt(columnIndex2);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            intToState = WorkTypeConverters.intToState(i21);
                        }
                        Data fromByteArray = columnIndex3 == -1 ? null : Data.fromByteArray(query2.getBlob(columnIndex3));
                        long j4 = columnIndex4 == -1 ? 0L : query2.getLong(columnIndex4);
                        long j5 = columnIndex5 == -1 ? 0L : query2.getLong(columnIndex5);
                        long j6 = columnIndex6 == -1 ? 0L : query2.getLong(columnIndex6);
                        int i22 = columnIndex7 == -1 ? 0 : query2.getInt(columnIndex7);
                        if (columnIndex8 == -1) {
                            intToBackoffPolicy = null;
                        } else {
                            int i23 = query2.getInt(columnIndex8);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i23);
                        }
                        long j7 = columnIndex9 == -1 ? 0L : query2.getLong(columnIndex9);
                        if (columnIndex10 == -1) {
                            i = i19;
                            j = 0;
                        } else {
                            j = query2.getLong(columnIndex10);
                            i = i19;
                        }
                        if (i == -1) {
                            i19 = i;
                            i3 = i20;
                            i2 = 0;
                        } else {
                            i2 = query2.getInt(i);
                            i19 = i;
                            i3 = i20;
                        }
                        if (i3 == -1) {
                            i20 = i3;
                            i5 = i17;
                            i4 = 0;
                        } else {
                            i4 = query2.getInt(i3);
                            i20 = i3;
                            i5 = i17;
                        }
                        if (i5 == -1) {
                            i17 = i5;
                            i6 = columnIndex14;
                            j2 = 0;
                        } else {
                            j2 = query2.getLong(i5);
                            i17 = i5;
                            i6 = columnIndex14;
                        }
                        if (i6 == -1) {
                            columnIndex14 = i6;
                            i8 = columnIndex15;
                            i7 = 0;
                        } else {
                            i7 = query2.getInt(i6);
                            columnIndex14 = i6;
                            i8 = columnIndex15;
                        }
                        if (i8 == -1) {
                            columnIndex15 = i8;
                            i9 = columnIndex16;
                            intToNetworkType = null;
                        } else {
                            int i24 = query2.getInt(i8);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            intToNetworkType = WorkTypeConverters.intToNetworkType(i24);
                            columnIndex15 = i8;
                            i9 = columnIndex16;
                        }
                        if (i9 == -1) {
                            columnIndex16 = i9;
                            i10 = columnIndex17;
                            networkRequest$work_runtime_release = null;
                        } else {
                            byte[] blob = query2.getBlob(i9);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                            columnIndex16 = i9;
                            i10 = columnIndex17;
                        }
                        if (i10 == -1) {
                            columnIndex17 = i10;
                            i11 = columnIndex18;
                            z = false;
                        } else {
                            z = query2.getInt(i10) != 0;
                            columnIndex17 = i10;
                            i11 = columnIndex18;
                        }
                        if (i11 == -1) {
                            columnIndex18 = i11;
                            i12 = columnIndex19;
                            z2 = false;
                        } else {
                            z2 = query2.getInt(i11) != 0;
                            columnIndex18 = i11;
                            i12 = columnIndex19;
                        }
                        if (i12 == -1) {
                            columnIndex19 = i12;
                            i13 = columnIndex20;
                            z3 = false;
                        } else {
                            z3 = query2.getInt(i12) != 0;
                            columnIndex19 = i12;
                            i13 = columnIndex20;
                        }
                        if (i13 == -1) {
                            columnIndex20 = i13;
                            i14 = columnIndex21;
                            z4 = false;
                        } else {
                            boolean z5 = query2.getInt(i13) != 0;
                            columnIndex20 = i13;
                            i14 = columnIndex21;
                            z4 = z5;
                        }
                        if (i14 == -1) {
                            columnIndex21 = i14;
                            i15 = columnIndex22;
                            j3 = 0;
                        } else {
                            j3 = query2.getLong(i14);
                            columnIndex21 = i14;
                            i15 = columnIndex22;
                        }
                        long j8 = i15 != -1 ? query2.getLong(i15) : 0L;
                        columnIndex22 = i15;
                        int i25 = columnIndex23;
                        long j9 = j8;
                        if (i25 == -1) {
                            byteArrayToSetOfTriggers = null;
                        } else {
                            byte[] blob2 = query2.getBlob(i25);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            byteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(blob2);
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j4, j5, j6, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j3, j9, byteArrayToSetOfTriggers), i22, intToBackoffPolicy, j7, j, i2, i4, j2, i7, (ArrayList) hashMap.get(query2.getString(columnIndex)), (ArrayList) hashMap2.get(query2.getString(columnIndex))));
                        columnIndex23 = i25;
                    }
                    query2.close();
                    return arrayList;
                } catch (Throwable th) {
                    query2.close();
                    throw th;
                }
            }
        });
    }
}
