package androidx.work;

import Oox.oOoXoXO;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class Data$getTypedArray$1 extends Lambda implements oOoXoXO<Integer, T> {
    final /* synthetic */ Object $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Data$getTypedArray$1(Object obj) {
        super(1);
        this.$value = obj;
    }

    public final T invoke(int i) {
        T t = ((Object[]) this.$value)[i];
        IIX0o.OxI(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
