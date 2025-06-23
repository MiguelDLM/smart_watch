package androidx.lifecycle;

import Oox.oOoXoXO;
import androidx.arch.core.util.Function;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class Transformations$map$2 extends Lambda implements oOoXoXO<Object, oXIO0o0XI> {
    final /* synthetic */ Function<Object, Object> $mapFunction;
    final /* synthetic */ MediatorLiveData<Object> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$map$2(MediatorLiveData<Object> mediatorLiveData, Function<Object, Object> function) {
        super(1);
        this.$result = mediatorLiveData;
        this.$mapFunction = function;
    }

    public final void invoke(Object obj) {
        this.$result.setValue(this.$mapFunction.apply(obj));
    }
}
