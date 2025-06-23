package androidx.lifecycle;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;

@xxIXOIIO(name = "Transformations")
public final class Transformations {
    @MainThread
    @xxIXOIIO(name = "distinctUntilChanged")
    @CheckResult
    @OOXIXo
    public static final <X> LiveData<X> distinctUntilChanged(@OOXIXo LiveData<X> liveData) {
        IIX0o.x0xO0oo(liveData, "<this>");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (liveData.isInitialized()) {
            mediatorLiveData.setValue(liveData.getValue());
            booleanRef.element = false;
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$distinctUntilChanged$1(mediatorLiveData, booleanRef)));
        return mediatorLiveData;
    }

    @MainThread
    @xxIXOIIO(name = "map")
    @CheckResult
    @OOXIXo
    public static final <X, Y> LiveData<Y> map(@OOXIXo LiveData<X> liveData, @OOXIXo oOoXoXO<X, Y> oooxoxo) {
        IIX0o.x0xO0oo(liveData, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$map$1(mediatorLiveData, oooxoxo)));
        return mediatorLiveData;
    }

    @MainThread
    @xxIXOIIO(name = "switchMap")
    @CheckResult
    @OOXIXo
    public static final <X, Y> LiveData<Y> switchMap(@OOXIXo LiveData<X> liveData, @OOXIXo oOoXoXO<X, LiveData<Y>> oooxoxo) {
        IIX0o.x0xO0oo(liveData, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$switchMap$1(oooxoxo, mediatorLiveData));
        return mediatorLiveData;
    }

    @MainThread
    @xxIXOIIO(name = "map")
    @CheckResult
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData map(LiveData liveData, Function function) {
        IIX0o.x0xO0oo(liveData, "<this>");
        IIX0o.x0xO0oo(function, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$map$2(mediatorLiveData, function)));
        return mediatorLiveData;
    }

    @MainThread
    @xxIXOIIO(name = "switchMap")
    @CheckResult
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, Function function) {
        IIX0o.x0xO0oo(liveData, "<this>");
        IIX0o.x0xO0oo(function, "switchMapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$switchMap$2(function, mediatorLiveData));
        return mediatorLiveData;
    }
}
