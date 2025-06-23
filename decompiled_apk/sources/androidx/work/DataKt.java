package androidx.work;

import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import kotlin.Pair;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String key) {
        IIX0o.x0xO0oo(data, "<this>");
        IIX0o.x0xO0oo(key, "key");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return data.hasKeyWithValueOfType(key, Object.class);
    }

    @OXOo.OOXIXo
    public static final Data workDataOf(@OXOo.OOXIXo Pair<String, ? extends Object>... pairs) {
        IIX0o.x0xO0oo(pairs, "pairs");
        Data.Builder builder = new Data.Builder();
        for (Pair<String, ? extends Object> pair : pairs) {
            builder.put(pair.getFirst(), pair.getSecond());
        }
        return builder.build();
    }
}
