package androidx.work;

import Oox.oOoXoXO;
import kotlin.jvm.internal.Lambda;

public final class Data$getLongArray$$inlined$getTypedArray$1 extends Lambda implements oOoXoXO<Integer, Long> {
    final /* synthetic */ Object $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Data$getLongArray$$inlined$getTypedArray$1(Object obj) {
        super(1);
        this.$value = obj;
    }

    public final Long invoke(int i) {
        Object obj = ((Object[]) this.$value)[i];
        if (obj != null) {
            return (Long) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
