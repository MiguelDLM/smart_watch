package androidx.work.impl.model;

import XXO0.oIX0oI;
import android.database.Cursor;
import android.os.CancellationSignal;
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
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.X0o0xo;

public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;

    public RawWorkInfoDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(@NonNull HashMap<String, ArrayList<Data>> hashMap) {
        Set<String> keySet = hashMap.keySet();
        if (!keySet.isEmpty()) {
            if (hashMap.size() > 999) {
                RelationUtil.recursiveFetchHashMap(hashMap, true, new II0xO0(this));
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            int size = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size);
            newStringBuilder.append(oIX0oI.I0Io.f17331I0Io);
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
            int i = 1;
            for (String bindString : keySet) {
                acquire.bindString(i, bindString);
                i++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        ArrayList arrayList = hashMap.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            arrayList.add(Data.fromByteArray(query.getBlob(0)));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(@NonNull HashMap<String, ArrayList<String>> hashMap) {
        Set<String> keySet = hashMap.keySet();
        if (!keySet.isEmpty()) {
            if (hashMap.size() > 999) {
                RelationUtil.recursiveFetchHashMap(hashMap, true, new oIX0oI(this));
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size);
            newStringBuilder.append(oIX0oI.I0Io.f17331I0Io);
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
            int i = 1;
            for (String bindString : keySet) {
                acquire.bindString(i, bindString);
                i++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        ArrayList arrayList = hashMap.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            arrayList.add(query.getString(0));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ oXIO0o0XI lambda$__fetchRelationshipWorkProgressAsandroidxWorkData$1(HashMap hashMap) {
        __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap);
        return oXIO0o0XI.f19155oIX0oI;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ oXIO0o0XI lambda$__fetchRelationshipWorkTagAsjavaLangString$0(HashMap hashMap) {
        __fetchRelationshipWorkTagAsjavaLangString(hashMap);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery supportSQLiteQuery) {
        String str;
        WorkInfo.State state;
        Data data;
        long j;
        long j2;
        long j3;
        int i;
        BackoffPolicy backoffPolicy;
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
        NetworkType networkType;
        int i9;
        NetworkRequestCompat networkRequestCompat;
        int i10;
        boolean z;
        int i11;
        boolean z2;
        int i12;
        boolean z3;
        int i13;
        boolean z4;
        int i14;
        long j7;
        int i15;
        Set<Constraints.ContentUriTrigger> set;
        boolean z5;
        boolean z6;
        boolean z7;
        int i16;
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, supportSQLiteQuery, true, (CancellationSignal) null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "id");
            int columnIndex2 = CursorUtil.getColumnIndex(query, "state");
            int columnIndex3 = CursorUtil.getColumnIndex(query, "output");
            int columnIndex4 = CursorUtil.getColumnIndex(query, "initial_delay");
            int columnIndex5 = CursorUtil.getColumnIndex(query, "interval_duration");
            int columnIndex6 = CursorUtil.getColumnIndex(query, "flex_duration");
            int columnIndex7 = CursorUtil.getColumnIndex(query, "run_attempt_count");
            int columnIndex8 = CursorUtil.getColumnIndex(query, "backoff_policy");
            int columnIndex9 = CursorUtil.getColumnIndex(query, "backoff_delay_duration");
            int columnIndex10 = CursorUtil.getColumnIndex(query, "last_enqueue_time");
            int columnIndex11 = CursorUtil.getColumnIndex(query, "period_count");
            int columnIndex12 = CursorUtil.getColumnIndex(query, "generation");
            int columnIndex13 = CursorUtil.getColumnIndex(query, "next_schedule_time_override");
            int columnIndex14 = CursorUtil.getColumnIndex(query, DownloadService.KEY_STOP_REASON);
            int columnIndex15 = CursorUtil.getColumnIndex(query, "required_network_type");
            int columnIndex16 = CursorUtil.getColumnIndex(query, "required_network_request");
            int columnIndex17 = CursorUtil.getColumnIndex(query, "requires_charging");
            int columnIndex18 = CursorUtil.getColumnIndex(query, "requires_device_idle");
            int columnIndex19 = CursorUtil.getColumnIndex(query, "requires_battery_not_low");
            int columnIndex20 = CursorUtil.getColumnIndex(query, "requires_storage_not_low");
            int columnIndex21 = CursorUtil.getColumnIndex(query, "trigger_content_update_delay");
            int columnIndex22 = CursorUtil.getColumnIndex(query, "trigger_max_content_delay");
            int columnIndex23 = CursorUtil.getColumnIndex(query, "content_uri_triggers");
            HashMap hashMap = new HashMap();
            int i17 = columnIndex13;
            HashMap hashMap2 = new HashMap();
            while (query.moveToNext()) {
                int i18 = columnIndex12;
                String string = query.getString(columnIndex);
                if (!hashMap.containsKey(string)) {
                    i16 = columnIndex11;
                    hashMap.put(string, new ArrayList());
                } else {
                    i16 = columnIndex11;
                }
                String string2 = query.getString(columnIndex);
                if (!hashMap2.containsKey(string2)) {
                    hashMap2.put(string2, new ArrayList());
                }
                columnIndex12 = i18;
                columnIndex11 = i16;
            }
            int i19 = columnIndex11;
            int i20 = columnIndex12;
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(hashMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (columnIndex == -1) {
                    str = null;
                } else {
                    str = query.getString(columnIndex);
                }
                if (columnIndex2 == -1) {
                    state = null;
                } else {
                    int i21 = query.getInt(columnIndex2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    state = WorkTypeConverters.intToState(i21);
                }
                if (columnIndex3 == -1) {
                    data = null;
                } else {
                    data = Data.fromByteArray(query.getBlob(columnIndex3));
                }
                long j8 = 0;
                if (columnIndex4 == -1) {
                    j = 0;
                } else {
                    j = query.getLong(columnIndex4);
                }
                if (columnIndex5 == -1) {
                    j2 = 0;
                } else {
                    j2 = query.getLong(columnIndex5);
                }
                if (columnIndex6 == -1) {
                    j3 = 0;
                } else {
                    j3 = query.getLong(columnIndex6);
                }
                boolean z8 = false;
                if (columnIndex7 == -1) {
                    i = 0;
                } else {
                    i = query.getInt(columnIndex7);
                }
                if (columnIndex8 == -1) {
                    backoffPolicy = null;
                } else {
                    int i22 = query.getInt(columnIndex8);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    backoffPolicy = WorkTypeConverters.intToBackoffPolicy(i22);
                }
                if (columnIndex9 == -1) {
                    j4 = 0;
                } else {
                    j4 = query.getLong(columnIndex9);
                }
                if (columnIndex10 == -1) {
                    i2 = i19;
                    j5 = 0;
                } else {
                    j5 = query.getLong(columnIndex10);
                    i2 = i19;
                }
                if (i2 == -1) {
                    i19 = i2;
                    i4 = i20;
                    i3 = 0;
                } else {
                    i3 = query.getInt(i2);
                    i19 = i2;
                    i4 = i20;
                }
                if (i4 == -1) {
                    i20 = i4;
                    i6 = i17;
                    i5 = 0;
                } else {
                    i5 = query.getInt(i4);
                    i20 = i4;
                    i6 = i17;
                }
                if (i6 == -1) {
                    i17 = i6;
                    j6 = 0;
                } else {
                    j6 = query.getLong(i6);
                    i17 = i6;
                }
                int i23 = columnIndex14;
                if (i23 == -1) {
                    columnIndex14 = i23;
                    i8 = columnIndex15;
                    i7 = 0;
                } else {
                    i7 = query.getInt(i23);
                    columnIndex14 = i23;
                    i8 = columnIndex15;
                }
                if (i8 == -1) {
                    columnIndex15 = i8;
                    i9 = columnIndex16;
                    networkType = null;
                } else {
                    int i24 = query.getInt(i8);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    networkType = WorkTypeConverters.intToNetworkType(i24);
                    columnIndex15 = i8;
                    i9 = columnIndex16;
                }
                if (i9 == -1) {
                    columnIndex16 = i9;
                    i10 = columnIndex17;
                    networkRequestCompat = null;
                } else {
                    byte[] blob = query.getBlob(i9);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    networkRequestCompat = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    columnIndex16 = i9;
                    i10 = columnIndex17;
                }
                if (i10 == -1) {
                    columnIndex17 = i10;
                    i11 = columnIndex18;
                    z = false;
                } else {
                    if (query.getInt(i10) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z = z7;
                    columnIndex17 = i10;
                    i11 = columnIndex18;
                }
                if (i11 == -1) {
                    columnIndex18 = i11;
                    i12 = columnIndex19;
                    z2 = false;
                } else {
                    if (query.getInt(i11) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z2 = z6;
                    columnIndex18 = i11;
                    i12 = columnIndex19;
                }
                if (i12 == -1) {
                    columnIndex19 = i12;
                    i13 = columnIndex20;
                    z3 = false;
                } else {
                    if (query.getInt(i12) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z3 = z5;
                    columnIndex19 = i12;
                    i13 = columnIndex20;
                }
                if (i13 == -1) {
                    columnIndex20 = i13;
                    i14 = columnIndex21;
                    z4 = false;
                } else {
                    if (query.getInt(i13) != 0) {
                        z8 = true;
                    }
                    columnIndex20 = i13;
                    i14 = columnIndex21;
                    z4 = z8;
                }
                if (i14 == -1) {
                    columnIndex21 = i14;
                    i15 = columnIndex22;
                    j7 = 0;
                } else {
                    j7 = query.getLong(i14);
                    columnIndex21 = i14;
                    i15 = columnIndex22;
                }
                if (i15 != -1) {
                    j8 = query.getLong(i15);
                }
                columnIndex22 = i15;
                int i25 = columnIndex23;
                long j9 = j8;
                if (i25 == -1) {
                    set = null;
                } else {
                    byte[] blob2 = query.getBlob(i25);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    set = WorkTypeConverters.byteArrayToSetOfTriggers(blob2);
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(str, state, data, j, j2, j3, new Constraints(networkRequestCompat, networkType, z, z2, z3, z4, j7, j9, set), i, backoffPolicy, j4, j5, i3, i5, j6, i7, (ArrayList) hashMap.get(query.getString(columnIndex)), (ArrayList) hashMap2.get(query.getString(columnIndex))));
                columnIndex23 = i25;
            }
            query.close();
            return arrayList;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    public X0o0xo<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(final SupportSQLiteQuery supportSQLiteQuery) {
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            @NonNull
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                String str;
                WorkInfo.State state;
                Data data;
                long j;
                long j2;
                long j3;
                int i;
                BackoffPolicy backoffPolicy;
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
                int i9;
                NetworkType networkType;
                int i10;
                NetworkRequestCompat networkRequestCompat;
                int i11;
                boolean z;
                int i12;
                boolean z2;
                int i13;
                boolean z3;
                int i14;
                boolean z4;
                int i15;
                long j7;
                int i16;
                Set<Constraints.ContentUriTrigger> set;
                int i17;
                Cursor query = DBUtil.query(RawWorkInfoDao_Impl.this.__db, supportSQLiteQuery, true, (CancellationSignal) null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(query, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(query, "state");
                    int columnIndex3 = CursorUtil.getColumnIndex(query, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(query, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(query, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(query, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(query, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(query, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(query, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(query, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(query, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(query, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(query, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(query, DownloadService.KEY_STOP_REASON);
                    int columnIndex15 = CursorUtil.getColumnIndex(query, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(query, "required_network_request");
                    int columnIndex17 = CursorUtil.getColumnIndex(query, "requires_charging");
                    int columnIndex18 = CursorUtil.getColumnIndex(query, "requires_device_idle");
                    int columnIndex19 = CursorUtil.getColumnIndex(query, "requires_battery_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(query, "requires_storage_not_low");
                    int columnIndex21 = CursorUtil.getColumnIndex(query, "trigger_content_update_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(query, "trigger_max_content_delay");
                    int columnIndex23 = CursorUtil.getColumnIndex(query, "content_uri_triggers");
                    HashMap hashMap = new HashMap();
                    int i18 = columnIndex13;
                    HashMap hashMap2 = new HashMap();
                    while (query.moveToNext()) {
                        int i19 = columnIndex12;
                        String string = query.getString(columnIndex);
                        if (!hashMap.containsKey(string)) {
                            i17 = columnIndex11;
                            hashMap.put(string, new ArrayList());
                        } else {
                            i17 = columnIndex11;
                        }
                        String string2 = query.getString(columnIndex);
                        if (!hashMap2.containsKey(string2)) {
                            hashMap2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i19;
                        columnIndex11 = i17;
                    }
                    int i20 = columnIndex11;
                    int i21 = columnIndex12;
                    query.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (columnIndex == -1) {
                            str = null;
                        } else {
                            str = query.getString(columnIndex);
                        }
                        if (columnIndex2 == -1) {
                            state = null;
                        } else {
                            int i22 = query.getInt(columnIndex2);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            state = WorkTypeConverters.intToState(i22);
                        }
                        if (columnIndex3 == -1) {
                            data = null;
                        } else {
                            data = Data.fromByteArray(query.getBlob(columnIndex3));
                        }
                        long j8 = 0;
                        if (columnIndex4 == -1) {
                            j = 0;
                        } else {
                            j = query.getLong(columnIndex4);
                        }
                        if (columnIndex5 == -1) {
                            j2 = 0;
                        } else {
                            j2 = query.getLong(columnIndex5);
                        }
                        if (columnIndex6 == -1) {
                            j3 = 0;
                        } else {
                            j3 = query.getLong(columnIndex6);
                        }
                        boolean z5 = false;
                        if (columnIndex7 == -1) {
                            i = 0;
                        } else {
                            i = query.getInt(columnIndex7);
                        }
                        if (columnIndex8 == -1) {
                            backoffPolicy = null;
                        } else {
                            int i23 = query.getInt(columnIndex8);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            backoffPolicy = WorkTypeConverters.intToBackoffPolicy(i23);
                        }
                        if (columnIndex9 == -1) {
                            j4 = 0;
                        } else {
                            j4 = query.getLong(columnIndex9);
                        }
                        if (columnIndex10 == -1) {
                            i2 = i20;
                            j5 = 0;
                        } else {
                            j5 = query.getLong(columnIndex10);
                            i2 = i20;
                        }
                        if (i2 == -1) {
                            i20 = i2;
                            i4 = i21;
                            i3 = 0;
                        } else {
                            i3 = query.getInt(i2);
                            i20 = i2;
                            i4 = i21;
                        }
                        if (i4 == -1) {
                            i21 = i4;
                            i6 = i18;
                            i5 = 0;
                        } else {
                            i5 = query.getInt(i4);
                            i21 = i4;
                            i6 = i18;
                        }
                        if (i6 == -1) {
                            i18 = i6;
                            i7 = columnIndex14;
                            j6 = 0;
                        } else {
                            j6 = query.getLong(i6);
                            i18 = i6;
                            i7 = columnIndex14;
                        }
                        if (i7 == -1) {
                            columnIndex14 = i7;
                            i9 = columnIndex15;
                            i8 = 0;
                        } else {
                            i8 = query.getInt(i7);
                            columnIndex14 = i7;
                            i9 = columnIndex15;
                        }
                        if (i9 == -1) {
                            columnIndex15 = i9;
                            i10 = columnIndex16;
                            networkType = null;
                        } else {
                            int i24 = query.getInt(i9);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            networkType = WorkTypeConverters.intToNetworkType(i24);
                            columnIndex15 = i9;
                            i10 = columnIndex16;
                        }
                        if (i10 == -1) {
                            columnIndex16 = i10;
                            i11 = columnIndex17;
                            networkRequestCompat = null;
                        } else {
                            byte[] blob = query.getBlob(i10);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            networkRequestCompat = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                            columnIndex16 = i10;
                            i11 = columnIndex17;
                        }
                        if (i11 == -1) {
                            columnIndex17 = i11;
                            i12 = columnIndex18;
                            z = false;
                        } else {
                            z = query.getInt(i11) != 0;
                            columnIndex17 = i11;
                            i12 = columnIndex18;
                        }
                        if (i12 == -1) {
                            columnIndex18 = i12;
                            i13 = columnIndex19;
                            z2 = false;
                        } else {
                            z2 = query.getInt(i12) != 0;
                            columnIndex18 = i12;
                            i13 = columnIndex19;
                        }
                        if (i13 == -1) {
                            columnIndex19 = i13;
                            i14 = columnIndex20;
                            z3 = false;
                        } else {
                            z3 = query.getInt(i13) != 0;
                            columnIndex19 = i13;
                            i14 = columnIndex20;
                        }
                        if (i14 == -1) {
                            columnIndex20 = i14;
                            i15 = columnIndex21;
                            z4 = false;
                        } else {
                            if (query.getInt(i14) != 0) {
                                z5 = true;
                            }
                            columnIndex20 = i14;
                            i15 = columnIndex21;
                            z4 = z5;
                        }
                        if (i15 == -1) {
                            columnIndex21 = i15;
                            i16 = columnIndex22;
                            j7 = 0;
                        } else {
                            j7 = query.getLong(i15);
                            columnIndex21 = i15;
                            i16 = columnIndex22;
                        }
                        if (i16 != -1) {
                            j8 = query.getLong(i16);
                        }
                        columnIndex22 = i16;
                        int i25 = columnIndex23;
                        long j9 = j8;
                        if (i25 == -1) {
                            set = null;
                        } else {
                            byte[] blob2 = query.getBlob(i25);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            set = WorkTypeConverters.byteArrayToSetOfTriggers(blob2);
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, state, data, j, j2, j3, new Constraints(networkRequestCompat, networkType, z, z2, z3, z4, j7, j9, set), i, backoffPolicy, j4, j5, i3, i5, j6, i8, (ArrayList) hashMap.get(query.getString(columnIndex)), (ArrayList) hashMap2.get(query.getString(columnIndex))));
                        columnIndex23 = i25;
                    }
                    query.close();
                    return arrayList;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        });
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            @Nullable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                String str;
                WorkInfo.State state;
                Data data;
                long j;
                long j2;
                long j3;
                int i;
                BackoffPolicy backoffPolicy;
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
                int i9;
                NetworkType networkType;
                int i10;
                NetworkRequestCompat networkRequestCompat;
                int i11;
                boolean z;
                int i12;
                boolean z2;
                int i13;
                boolean z3;
                int i14;
                boolean z4;
                int i15;
                long j7;
                int i16;
                Set<Constraints.ContentUriTrigger> set;
                int i17;
                Cursor query = DBUtil.query(RawWorkInfoDao_Impl.this.__db, supportSQLiteQuery, true, (CancellationSignal) null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(query, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(query, "state");
                    int columnIndex3 = CursorUtil.getColumnIndex(query, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(query, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(query, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(query, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(query, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(query, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(query, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(query, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(query, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(query, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(query, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(query, DownloadService.KEY_STOP_REASON);
                    int columnIndex15 = CursorUtil.getColumnIndex(query, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(query, "required_network_request");
                    int columnIndex17 = CursorUtil.getColumnIndex(query, "requires_charging");
                    int columnIndex18 = CursorUtil.getColumnIndex(query, "requires_device_idle");
                    int columnIndex19 = CursorUtil.getColumnIndex(query, "requires_battery_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(query, "requires_storage_not_low");
                    int columnIndex21 = CursorUtil.getColumnIndex(query, "trigger_content_update_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(query, "trigger_max_content_delay");
                    int columnIndex23 = CursorUtil.getColumnIndex(query, "content_uri_triggers");
                    HashMap hashMap = new HashMap();
                    int i18 = columnIndex13;
                    HashMap hashMap2 = new HashMap();
                    while (query.moveToNext()) {
                        int i19 = columnIndex12;
                        String string = query.getString(columnIndex);
                        if (!hashMap.containsKey(string)) {
                            i17 = columnIndex11;
                            hashMap.put(string, new ArrayList());
                        } else {
                            i17 = columnIndex11;
                        }
                        String string2 = query.getString(columnIndex);
                        if (!hashMap2.containsKey(string2)) {
                            hashMap2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i19;
                        columnIndex11 = i17;
                    }
                    int i20 = columnIndex11;
                    int i21 = columnIndex12;
                    query.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (columnIndex == -1) {
                            str = null;
                        } else {
                            str = query.getString(columnIndex);
                        }
                        if (columnIndex2 == -1) {
                            state = null;
                        } else {
                            int i22 = query.getInt(columnIndex2);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            state = WorkTypeConverters.intToState(i22);
                        }
                        if (columnIndex3 == -1) {
                            data = null;
                        } else {
                            data = Data.fromByteArray(query.getBlob(columnIndex3));
                        }
                        long j8 = 0;
                        if (columnIndex4 == -1) {
                            j = 0;
                        } else {
                            j = query.getLong(columnIndex4);
                        }
                        if (columnIndex5 == -1) {
                            j2 = 0;
                        } else {
                            j2 = query.getLong(columnIndex5);
                        }
                        if (columnIndex6 == -1) {
                            j3 = 0;
                        } else {
                            j3 = query.getLong(columnIndex6);
                        }
                        boolean z5 = false;
                        if (columnIndex7 == -1) {
                            i = 0;
                        } else {
                            i = query.getInt(columnIndex7);
                        }
                        if (columnIndex8 == -1) {
                            backoffPolicy = null;
                        } else {
                            int i23 = query.getInt(columnIndex8);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            backoffPolicy = WorkTypeConverters.intToBackoffPolicy(i23);
                        }
                        if (columnIndex9 == -1) {
                            j4 = 0;
                        } else {
                            j4 = query.getLong(columnIndex9);
                        }
                        if (columnIndex10 == -1) {
                            i2 = i20;
                            j5 = 0;
                        } else {
                            j5 = query.getLong(columnIndex10);
                            i2 = i20;
                        }
                        if (i2 == -1) {
                            i20 = i2;
                            i4 = i21;
                            i3 = 0;
                        } else {
                            i3 = query.getInt(i2);
                            i20 = i2;
                            i4 = i21;
                        }
                        if (i4 == -1) {
                            i21 = i4;
                            i6 = i18;
                            i5 = 0;
                        } else {
                            i5 = query.getInt(i4);
                            i21 = i4;
                            i6 = i18;
                        }
                        if (i6 == -1) {
                            i18 = i6;
                            i7 = columnIndex14;
                            j6 = 0;
                        } else {
                            j6 = query.getLong(i6);
                            i18 = i6;
                            i7 = columnIndex14;
                        }
                        if (i7 == -1) {
                            columnIndex14 = i7;
                            i9 = columnIndex15;
                            i8 = 0;
                        } else {
                            i8 = query.getInt(i7);
                            columnIndex14 = i7;
                            i9 = columnIndex15;
                        }
                        if (i9 == -1) {
                            columnIndex15 = i9;
                            i10 = columnIndex16;
                            networkType = null;
                        } else {
                            int i24 = query.getInt(i9);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            networkType = WorkTypeConverters.intToNetworkType(i24);
                            columnIndex15 = i9;
                            i10 = columnIndex16;
                        }
                        if (i10 == -1) {
                            columnIndex16 = i10;
                            i11 = columnIndex17;
                            networkRequestCompat = null;
                        } else {
                            byte[] blob = query.getBlob(i10);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            networkRequestCompat = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                            columnIndex16 = i10;
                            i11 = columnIndex17;
                        }
                        if (i11 == -1) {
                            columnIndex17 = i11;
                            i12 = columnIndex18;
                            z = false;
                        } else {
                            z = query.getInt(i11) != 0;
                            columnIndex17 = i11;
                            i12 = columnIndex18;
                        }
                        if (i12 == -1) {
                            columnIndex18 = i12;
                            i13 = columnIndex19;
                            z2 = false;
                        } else {
                            z2 = query.getInt(i12) != 0;
                            columnIndex18 = i12;
                            i13 = columnIndex19;
                        }
                        if (i13 == -1) {
                            columnIndex19 = i13;
                            i14 = columnIndex20;
                            z3 = false;
                        } else {
                            z3 = query.getInt(i13) != 0;
                            columnIndex19 = i13;
                            i14 = columnIndex20;
                        }
                        if (i14 == -1) {
                            columnIndex20 = i14;
                            i15 = columnIndex21;
                            z4 = false;
                        } else {
                            if (query.getInt(i14) != 0) {
                                z5 = true;
                            }
                            columnIndex20 = i14;
                            i15 = columnIndex21;
                            z4 = z5;
                        }
                        if (i15 == -1) {
                            columnIndex21 = i15;
                            i16 = columnIndex22;
                            j7 = 0;
                        } else {
                            j7 = query.getLong(i15);
                            columnIndex21 = i15;
                            i16 = columnIndex22;
                        }
                        if (i16 != -1) {
                            j8 = query.getLong(i16);
                        }
                        columnIndex22 = i16;
                        int i25 = columnIndex23;
                        long j9 = j8;
                        if (i25 == -1) {
                            set = null;
                        } else {
                            byte[] blob2 = query.getBlob(i25);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            set = WorkTypeConverters.byteArrayToSetOfTriggers(blob2);
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, state, data, j, j2, j3, new Constraints(networkRequestCompat, networkType, z, z2, z3, z4, j7, j9, set), i, backoffPolicy, j4, j5, i3, i5, j6, i8, (ArrayList) hashMap.get(query.getString(columnIndex)), (ArrayList) hashMap2.get(query.getString(columnIndex))));
                        columnIndex23 = i25;
                    }
                    query.close();
                    return arrayList;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        });
    }
}
