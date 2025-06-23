package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

/* JADX INFO: Access modifiers changed from: package-private */
@XX({"SMAP\nStartStopToken.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartStopToken.kt\nandroidx/work/impl/StartStopTokensImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,104:1\n361#2,7:105\n467#2,7:112\n1855#3,2:119\n*S KotlinDebug\n*F\n+ 1 StartStopToken.kt\nandroidx/work/impl/StartStopTokensImpl\n*L\n65#1:105,7\n73#1:112,7\n74#1:119,2\n*E\n"})
/* loaded from: classes.dex */
public final class StartStopTokensImpl implements StartStopTokens {

    @OXOo.OOXIXo
    private final Map<WorkGenerationalId, StartStopToken> runs = new LinkedHashMap();

    @Override // androidx.work.impl.StartStopTokens
    public boolean contains(@OXOo.OOXIXo WorkGenerationalId id) {
        IIX0o.x0xO0oo(id, "id");
        return this.runs.containsKey(id);
    }

    @Override // androidx.work.impl.StartStopTokens
    public /* synthetic */ StartStopToken remove(WorkSpec workSpec) {
        return XO.oIX0oI(this, workSpec);
    }

    @Override // androidx.work.impl.StartStopTokens
    public /* synthetic */ StartStopToken tokenFor(WorkSpec workSpec) {
        return XO.II0xO0(this, workSpec);
    }

    @Override // androidx.work.impl.StartStopTokens
    @OXOo.oOoXoXO
    public StartStopToken remove(@OXOo.OOXIXo WorkGenerationalId id) {
        IIX0o.x0xO0oo(id, "id");
        return this.runs.remove(id);
    }

    @Override // androidx.work.impl.StartStopTokens
    @OXOo.OOXIXo
    public StartStopToken tokenFor(@OXOo.OOXIXo WorkGenerationalId id) {
        IIX0o.x0xO0oo(id, "id");
        Map<WorkGenerationalId, StartStopToken> map = this.runs;
        StartStopToken startStopToken = map.get(id);
        if (startStopToken == null) {
            startStopToken = new StartStopToken(id);
            map.put(id, startStopToken);
        }
        return startStopToken;
    }

    @Override // androidx.work.impl.StartStopTokens
    @OXOo.OOXIXo
    public List<StartStopToken> remove(@OXOo.OOXIXo String workSpecId) {
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        Map<WorkGenerationalId, StartStopToken> map = this.runs;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<WorkGenerationalId, StartStopToken> entry : map.entrySet()) {
            if (IIX0o.Oxx0IOOO(entry.getKey().getWorkSpecId(), workSpecId)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            this.runs.remove((WorkGenerationalId) it.next());
        }
        return CollectionsKt___CollectionsKt.oOo0o(linkedHashMap.values());
    }
}
