package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.X0IIOO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements X0IIOO<VM> {

    @OXOo.oOoXoXO
    private VM cached;

    @OXOo.OOXIXo
    private final Oox.oIX0oI<CreationExtras> extrasProducer;

    @OXOo.OOXIXo
    private final Oox.oIX0oI<ViewModelProvider.Factory> factoryProducer;

    @OXOo.OOXIXo
    private final Oox.oIX0oI<ViewModelStore> storeProducer;

    @OXOo.OOXIXo
    private final kotlin.reflect.oxoX<VM> viewModelClass;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ViewModelLazy(@OXOo.OOXIXo kotlin.reflect.oxoX<VM> viewModelClass, @OXOo.OOXIXo Oox.oIX0oI<? extends ViewModelStore> storeProducer, @OXOo.OOXIXo Oox.oIX0oI<? extends ViewModelProvider.Factory> factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        IIX0o.x0xO0oo(viewModelClass, "viewModelClass");
        IIX0o.x0xO0oo(storeProducer, "storeProducer");
        IIX0o.x0xO0oo(factoryProducer, "factoryProducer");
    }

    @Override // kotlin.X0IIOO
    public boolean isInitialized() {
        if (this.cached != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xoIox
    public ViewModelLazy(@OXOo.OOXIXo kotlin.reflect.oxoX<VM> viewModelClass, @OXOo.OOXIXo Oox.oIX0oI<? extends ViewModelStore> storeProducer, @OXOo.OOXIXo Oox.oIX0oI<? extends ViewModelProvider.Factory> factoryProducer, @OXOo.OOXIXo Oox.oIX0oI<? extends CreationExtras> extrasProducer) {
        IIX0o.x0xO0oo(viewModelClass, "viewModelClass");
        IIX0o.x0xO0oo(storeProducer, "storeProducer");
        IIX0o.x0xO0oo(factoryProducer, "factoryProducer");
        IIX0o.x0xO0oo(extrasProducer, "extrasProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
        this.extrasProducer = extrasProducer;
    }

    @Override // kotlin.X0IIOO
    @OXOo.OOXIXo
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke(), this.extrasProducer.invoke()).get(XO0OX.II0xO0.X0o0xo(this.viewModelClass));
        this.cached = vm2;
        return vm2;
    }

    public /* synthetic */ ViewModelLazy(kotlin.reflect.oxoX oxox, Oox.oIX0oI oix0oi, Oox.oIX0oI oix0oi2, Oox.oIX0oI oix0oi3, int i, IIXOooo iIXOooo) {
        this(oxox, oix0oi, oix0oi2, (i & 8) != 0 ? new Oox.oIX0oI<CreationExtras.Empty>() { // from class: androidx.lifecycle.ViewModelLazy.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final CreationExtras.Empty invoke() {
                return CreationExtras.Empty.INSTANCE;
            }
        } : oix0oi3);
    }
}
