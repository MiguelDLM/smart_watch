package androidx.work;

import Oox.oOoXoXO;
import kotlin.jvm.internal.Lambda;

public final class Data$getStringArray$$inlined$getTypedArray$1 extends Lambda implements oOoXoXO<Integer, String> {
    final /* synthetic */ Object $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Data$getStringArray$$inlined$getTypedArray$1(Object obj) {
        super(1);
        this.$value = obj;
    }

    public final String invoke(int i) {
        Object obj = ((Object[]) this.$value)[i];
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
