package androidx.lifecycle;

import Oox.oOoXoXO;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class Transformations$switchMap$1$onChanged$1 extends Lambda implements oOoXoXO<Y, oXIO0o0XI> {
    final /* synthetic */ MediatorLiveData<Y> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$switchMap$1$onChanged$1(MediatorLiveData<Y> mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    public final void invoke(Y y) {
        this.$result.setValue(y);
    }
}
