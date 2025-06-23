package androidx.lifecycle;

import OXOo.oOoXoXO;
import androidx.arch.core.util.Function;
import kotlin.jvm.internal.IIX0o;

public final class Transformations$switchMap$2 implements Observer<Object> {
    final /* synthetic */ MediatorLiveData<Object> $result;
    final /* synthetic */ Function<Object, LiveData<Object>> $switchMapFunction;
    @oOoXoXO
    private LiveData<Object> liveData;

    public Transformations$switchMap$2(Function<Object, LiveData<Object>> function, MediatorLiveData<Object> mediatorLiveData) {
        this.$switchMapFunction = function;
        this.$result = mediatorLiveData;
    }

    @oOoXoXO
    public final LiveData<Object> getLiveData() {
        return this.liveData;
    }

    public void onChanged(Object obj) {
        LiveData<Object> apply = this.$switchMapFunction.apply(obj);
        LiveData<Object> liveData2 = this.liveData;
        if (liveData2 != apply) {
            if (liveData2 != null) {
                MediatorLiveData<Object> mediatorLiveData = this.$result;
                IIX0o.ooOOo0oXI(liveData2);
                mediatorLiveData.removeSource(liveData2);
            }
            this.liveData = apply;
            if (apply != null) {
                MediatorLiveData<Object> mediatorLiveData2 = this.$result;
                IIX0o.ooOOo0oXI(apply);
                mediatorLiveData2.addSource(apply, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$2$onChanged$1(this.$result)));
            }
        }
    }

    public final void setLiveData(@oOoXoXO LiveData<Object> liveData2) {
        this.liveData = liveData2;
    }
}
