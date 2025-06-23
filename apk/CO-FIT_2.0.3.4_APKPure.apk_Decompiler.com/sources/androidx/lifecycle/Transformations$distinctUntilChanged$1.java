package androidx.lifecycle;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

public final class Transformations$distinctUntilChanged$1 extends Lambda implements oOoXoXO<X, oXIO0o0XI> {
    final /* synthetic */ Ref.BooleanRef $firstTime;
    final /* synthetic */ MediatorLiveData<X> $outputLiveData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$distinctUntilChanged$1(MediatorLiveData<X> mediatorLiveData, Ref.BooleanRef booleanRef) {
        super(1);
        this.$outputLiveData = mediatorLiveData;
        this.$firstTime = booleanRef;
    }

    public final void invoke(X x) {
        X value = this.$outputLiveData.getValue();
        if (this.$firstTime.element || ((value == null && x != null) || (value != null && !IIX0o.Oxx0IOOO(value, x)))) {
            this.$firstTime.element = false;
            this.$outputLiveData.setValue(x);
        }
    }
}
