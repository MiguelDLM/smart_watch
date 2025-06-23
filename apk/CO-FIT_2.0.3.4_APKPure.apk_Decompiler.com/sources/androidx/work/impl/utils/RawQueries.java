package androidx.work.impl.utils;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import XXO0.oIX0oI;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import org.apache.log4j.spi.LocationInfo;

@XX({"SMAP\nRawQueries.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RawQueries.kt\nandroidx/work/impl/utils/RawQueries\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n1549#2:74\n1620#2,3:75\n1549#2:78\n1620#2,3:79\n37#3,2:82\n1#4:84\n*S KotlinDebug\n*F\n+ 1 RawQueries.kt\nandroidx/work/impl/utils/RawQueries\n*L\n35#1:74\n35#1:75,3\n43#1:78\n43#1:79,3\n64#1:82,2\n*E\n"})
@xxIXOIIO(name = "RawQueries")
public final class RawQueries {
    private static final void bindings(StringBuilder sb, int i) {
        if (i > 0) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(LocationInfo.NA);
            }
            sb.append(CollectionsKt___CollectionsKt.OoIXo(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (oOoXoXO) null, 62, (Object) null));
        }
    }

    @OOXIXo
    public static final SupportSQLiteQuery toRawQuery(@OOXIXo WorkQuery workQuery) {
        IIX0o.x0xO0oo(workQuery, "<this>");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("SELECT * FROM workspec");
        String str = " AND";
        String str2 = " WHERE";
        if (!workQuery.getStates().isEmpty()) {
            Iterable<WorkInfo.State> states = workQuery.getStates();
            ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(states, 10));
            for (WorkInfo.State stateToInt : states) {
                arrayList2.add(Integer.valueOf(WorkTypeConverters.stateToInt(stateToInt)));
            }
            sb.append(str2 + " state IN (");
            bindings(sb, arrayList2.size());
            sb.append(oIX0oI.I0Io.f17331I0Io);
            arrayList.addAll(arrayList2);
            str2 = str;
        }
        if (!workQuery.getIds().isEmpty()) {
            Iterable<UUID> ids = workQuery.getIds();
            ArrayList arrayList3 = new ArrayList(OxxIIOOXO.xo0x(ids, 10));
            for (UUID uuid : ids) {
                arrayList3.add(uuid.toString());
            }
            sb.append(str2 + " id IN (");
            bindings(sb, workQuery.getIds().size());
            sb.append(oIX0oI.I0Io.f17331I0Io);
            arrayList.addAll(arrayList3);
            str2 = str;
        }
        if (!workQuery.getTags().isEmpty()) {
            sb.append(str2 + " id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
            bindings(sb, workQuery.getTags().size());
            sb.append("))");
            arrayList.addAll(workQuery.getTags());
        } else {
            str = str2;
        }
        if (!workQuery.getUniqueWorkNames().isEmpty()) {
            sb.append(str + " id IN (SELECT work_spec_id FROM workname WHERE name IN (");
            bindings(sb, workQuery.getUniqueWorkNames().size());
            sb.append("))");
            arrayList.addAll(workQuery.getUniqueWorkNames());
        }
        sb.append(x.aL);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "builder.toString()");
        return new SimpleSQLiteQuery(sb2, arrayList.toArray(new Object[0]));
    }
}
