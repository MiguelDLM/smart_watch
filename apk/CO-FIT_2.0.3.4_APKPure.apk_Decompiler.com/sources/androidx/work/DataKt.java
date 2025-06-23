package androidx.work;

import OXOo.OOXIXo;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import kotlin.Pair;
import kotlin.jvm.internal.IIX0o;

public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String str) {
        IIX0o.x0xO0oo(data, "<this>");
        IIX0o.x0xO0oo(str, "key");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return data.hasKeyWithValueOfType(str, Object.class);
    }

    @OOXIXo
    public static final Data workDataOf(@OOXIXo Pair<String, ? extends Object>... pairArr) {
        IIX0o.x0xO0oo(pairArr, "pairs");
        Data.Builder builder = new Data.Builder();
        for (Pair<String, ? extends Object> pair : pairArr) {
            builder.put(pair.getFirst(), pair.getSecond());
        }
        return builder.build();
    }
}
