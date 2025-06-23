package androidx.work.impl;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nStartStopToken.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartStopToken.kt\nandroidx/work/impl/StartStopTokensImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,104:1\n361#2,7:105\n467#2,7:112\n1855#3,2:119\n*S KotlinDebug\n*F\n+ 1 StartStopToken.kt\nandroidx/work/impl/StartStopTokensImpl\n*L\n65#1:105,7\n73#1:112,7\n74#1:119,2\n*E\n"})
final class StartStopTokensImpl implements StartStopTokens {
    @OOXIXo
    private final Map<WorkGenerationalId, StartStopToken> runs = new LinkedHashMap();

    public boolean contains(@OOXIXo WorkGenerationalId workGenerationalId) {
        IIX0o.x0xO0oo(workGenerationalId, "id");
        return this.runs.containsKey(workGenerationalId);
    }

    public /* synthetic */ StartStopToken remove(WorkSpec workSpec) {
        return XO.oIX0oI(this, workSpec);
    }

    public /* synthetic */ StartStopToken tokenFor(WorkSpec workSpec) {
        return XO.II0xO0(this, workSpec);
    }

    @oOoXoXO
    public StartStopToken remove(@OOXIXo WorkGenerationalId workGenerationalId) {
        IIX0o.x0xO0oo(workGenerationalId, "id");
        return this.runs.remove(workGenerationalId);
    }

    @OOXIXo
    public StartStopToken tokenFor(@OOXIXo WorkGenerationalId workGenerationalId) {
        IIX0o.x0xO0oo(workGenerationalId, "id");
        Map<WorkGenerationalId, StartStopToken> map = this.runs;
        StartStopToken startStopToken = map.get(workGenerationalId);
        if (startStopToken == null) {
            startStopToken = new StartStopToken(workGenerationalId);
            map.put(workGenerationalId, startStopToken);
        }
        return startStopToken;
    }

    @OOXIXo
    public List<StartStopToken> remove(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "workSpecId");
        Map<WorkGenerationalId, StartStopToken> map = this.runs;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (IIX0o.Oxx0IOOO(((WorkGenerationalId) next.getKey()).getWorkSpecId(), str)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (WorkGenerationalId remove : linkedHashMap.keySet()) {
            this.runs.remove(remove);
        }
        return CollectionsKt___CollectionsKt.oOo0o(linkedHashMap.values());
    }
}
