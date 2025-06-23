package androidx.lifecycle;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;

public final class Transformations$switchMap$1 implements Observer<X> {
    final /* synthetic */ MediatorLiveData<Y> $result;
    final /* synthetic */ oOoXoXO<X, LiveData<Y>> $transform;
    @OXOo.oOoXoXO
    private LiveData<Y> liveData;

    public Transformations$switchMap$1(oOoXoXO<X, LiveData<Y>> oooxoxo, MediatorLiveData<Y> mediatorLiveData) {
        this.$transform = oooxoxo;
        this.$result = mediatorLiveData;
    }

    @OXOo.oOoXoXO
    public final LiveData<Y> getLiveData() {
        return this.liveData;
    }

    public void onChanged(X x) {
        LiveData<Y> invoke = this.$transform.invoke(x);
        LiveData<Y> liveData2 = this.liveData;
        if (liveData2 != invoke) {
            if (liveData2 != null) {
                MediatorLiveData<Y> mediatorLiveData = this.$result;
                IIX0o.ooOOo0oXI(liveData2);
                mediatorLiveData.removeSource(liveData2);
            }
            this.liveData = invoke;
            if (invoke != null) {
                MediatorLiveData<Y> mediatorLiveData2 = this.$result;
                IIX0o.ooOOo0oXI(invoke);
                mediatorLiveData2.addSource(invoke, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$1$onChanged$1(this.$result)));
            }
        }
    }

    public final void setLiveData(@OXOo.oOoXoXO LiveData<Y> liveData2) {
        this.liveData = liveData2;
    }
}
