package androidx.lifecycle;

import Oox.oOoXoXO;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class Transformations$map$1 extends Lambda implements oOoXoXO<X, oXIO0o0XI> {
    final /* synthetic */ MediatorLiveData<Y> $result;
    final /* synthetic */ oOoXoXO<X, Y> $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$map$1(MediatorLiveData<Y> mediatorLiveData, oOoXoXO<X, Y> oooxoxo) {
        super(1);
        this.$result = mediatorLiveData;
        this.$transform = oooxoxo;
    }

    public final void invoke(X x) {
        this.$result.setValue(this.$transform.invoke(x));
    }
}
