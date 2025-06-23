package androidx.work;

import OXOo.OOXIXo;
import androidx.work.Data;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

public final class OverwritingInputMerger extends InputMerger {
    @OOXIXo
    public Data merge(@OOXIXo List<Data> list) {
        IIX0o.x0xO0oo(list, "inputs");
        Data.Builder builder = new Data.Builder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Data keyValueMap : list) {
            linkedHashMap.putAll(keyValueMap.getKeyValueMap());
        }
        builder.putAll((Map<String, ? extends Object>) linkedHashMap);
        return builder.build();
    }
}
