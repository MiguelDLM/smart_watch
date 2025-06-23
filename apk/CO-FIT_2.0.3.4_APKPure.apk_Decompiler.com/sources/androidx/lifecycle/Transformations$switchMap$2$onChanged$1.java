package androidx.lifecycle;

import Oox.oOoXoXO;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class Transformations$switchMap$2$onChanged$1 extends Lambda implements oOoXoXO<Object, oXIO0o0XI> {
    final /* synthetic */ MediatorLiveData<Object> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$switchMap$2$onChanged$1(MediatorLiveData<Object> mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    public final void invoke(Object obj) {
        this.$result.setValue(obj);
    }
}
