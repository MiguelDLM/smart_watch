package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import com.iflytek.sparkchain.plugins.map.tools.MapPlugin;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

@XO0OX.xxIXOIIO(name = "Transformations")
/* loaded from: classes.dex */
public final class Transformations {
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "distinctUntilChanged")
    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(@OXOo.OOXIXo LiveData<X> liveData) {
        IIX0o.x0xO0oo(liveData, "<this>");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (liveData.isInitialized()) {
            mediatorLiveData.setValue(liveData.getValue());
            booleanRef.element = false;
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Oox.oOoXoXO<X, oXIO0o0XI>() { // from class: androidx.lifecycle.Transformations$distinctUntilChanged$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj) {
                invoke2((Transformations$distinctUntilChanged$1<X>) obj);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(X x) {
                X value = mediatorLiveData.getValue();
                if (booleanRef.element || ((value == null && x != null) || !(value == null || IIX0o.Oxx0IOOO(value, x)))) {
                    booleanRef.element = false;
                    mediatorLiveData.setValue(x);
                }
            }
        }));
        return mediatorLiveData;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = MapPlugin.MapSearchTool)
    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(@OXOo.OOXIXo LiveData<X> liveData, @OXOo.OOXIXo final Oox.oOoXoXO<X, Y> transform) {
        IIX0o.x0xO0oo(liveData, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Oox.oOoXoXO<X, oXIO0o0XI>() { // from class: androidx.lifecycle.Transformations$map$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj) {
                invoke2((Transformations$map$1<X>) obj);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(X x) {
                mediatorLiveData.setValue(transform.invoke(x));
            }
        }));
        return mediatorLiveData;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "switchMap")
    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(@OXOo.OOXIXo LiveData<X> liveData, @OXOo.OOXIXo final Oox.oOoXoXO<X, LiveData<Y>> transform) {
        IIX0o.x0xO0oo(liveData, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations$switchMap$1

            @OXOo.oOoXoXO
            private LiveData<Y> liveData;

            @OXOo.oOoXoXO
            public final LiveData<Y> getLiveData() {
                return this.liveData;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.lifecycle.Observer
            public void onChanged(X x) {
                LiveData<Y> liveData2 = (LiveData) transform.invoke(x);
                Object obj = this.liveData;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    MediatorLiveData<Y> mediatorLiveData2 = mediatorLiveData;
                    IIX0o.ooOOo0oXI(obj);
                    mediatorLiveData2.removeSource(obj);
                }
                this.liveData = liveData2;
                if (liveData2 != 0) {
                    MediatorLiveData<Y> mediatorLiveData3 = mediatorLiveData;
                    IIX0o.ooOOo0oXI(liveData2);
                    final MediatorLiveData<Y> mediatorLiveData4 = mediatorLiveData;
                    mediatorLiveData3.addSource(liveData2, new Transformations$sam$androidx_lifecycle_Observer$0(new Oox.oOoXoXO<Y, oXIO0o0XI>() { // from class: androidx.lifecycle.Transformations$switchMap$1$onChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                            invoke2((Transformations$switchMap$1$onChanged$1<Y>) obj2);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Y y) {
                            mediatorLiveData4.setValue(y);
                        }
                    }));
                }
            }

            public final void setLiveData(@OXOo.oOoXoXO LiveData<Y> liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @XO0OX.xxIXOIIO(name = MapPlugin.MapSearchTool)
    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, final Function mapFunction) {
        IIX0o.x0xO0oo(liveData, "<this>");
        IIX0o.x0xO0oo(mapFunction, "mapFunction");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: androidx.lifecycle.Transformations$map$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj) {
                invoke2(obj);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                mediatorLiveData.setValue(mapFunction.apply(obj));
            }
        }));
        return mediatorLiveData;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @XO0OX.xxIXOIIO(name = "switchMap")
    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, final Function switchMapFunction) {
        IIX0o.x0xO0oo(liveData, "<this>");
        IIX0o.x0xO0oo(switchMapFunction, "switchMapFunction");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<Object>() { // from class: androidx.lifecycle.Transformations$switchMap$2

            @OXOo.oOoXoXO
            private LiveData<Object> liveData;

            @OXOo.oOoXoXO
            public final LiveData<Object> getLiveData() {
                return this.liveData;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                LiveData<Object> apply = switchMapFunction.apply(obj);
                LiveData<Object> liveData2 = this.liveData;
                if (liveData2 == apply) {
                    return;
                }
                if (liveData2 != null) {
                    MediatorLiveData<Object> mediatorLiveData2 = mediatorLiveData;
                    IIX0o.ooOOo0oXI(liveData2);
                    mediatorLiveData2.removeSource(liveData2);
                }
                this.liveData = apply;
                if (apply != null) {
                    MediatorLiveData<Object> mediatorLiveData3 = mediatorLiveData;
                    IIX0o.ooOOo0oXI(apply);
                    final MediatorLiveData<Object> mediatorLiveData4 = mediatorLiveData;
                    mediatorLiveData3.addSource(apply, new Transformations$sam$androidx_lifecycle_Observer$0(new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: androidx.lifecycle.Transformations$switchMap$2$onChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                            invoke2(obj2);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj2) {
                            mediatorLiveData4.setValue(obj2);
                        }
                    }));
                }
            }

            public final void setLiveData(@OXOo.oOoXoXO LiveData<Object> liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }
}
