package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import XO0OX.II0xO0;
import XO0OX.xoIox;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.X0IIOO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.reflect.oxoX;

public final class ViewModelLazy<VM extends ViewModel> implements X0IIOO<VM> {
    @oOoXoXO
    private VM cached;
    @OOXIXo
    private final oIX0oI<CreationExtras> extrasProducer;
    @OOXIXo
    private final oIX0oI<ViewModelProvider.Factory> factoryProducer;
    @OOXIXo
    private final oIX0oI<ViewModelStore> storeProducer;
    @OOXIXo
    private final oxoX<VM> viewModelClass;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public ViewModelLazy(@OOXIXo oxoX<VM> oxox, @OOXIXo oIX0oI<? extends ViewModelStore> oix0oi, @OOXIXo oIX0oI<? extends ViewModelProvider.Factory> oix0oi2) {
        this(oxox, oix0oi, oix0oi2, (oIX0oI) null, 8, (IIXOooo) null);
        IIX0o.x0xO0oo(oxox, "viewModelClass");
        IIX0o.x0xO0oo(oix0oi, "storeProducer");
        IIX0o.x0xO0oo(oix0oi2, "factoryProducer");
    }

    public boolean isInitialized() {
        if (this.cached != null) {
            return true;
        }
        return false;
    }

    @xoIox
    public ViewModelLazy(@OOXIXo oxoX<VM> oxox, @OOXIXo oIX0oI<? extends ViewModelStore> oix0oi, @OOXIXo oIX0oI<? extends ViewModelProvider.Factory> oix0oi2, @OOXIXo oIX0oI<? extends CreationExtras> oix0oi3) {
        IIX0o.x0xO0oo(oxox, "viewModelClass");
        IIX0o.x0xO0oo(oix0oi, "storeProducer");
        IIX0o.x0xO0oo(oix0oi2, "factoryProducer");
        IIX0o.x0xO0oo(oix0oi3, "extrasProducer");
        this.viewModelClass = oxox;
        this.storeProducer = oix0oi;
        this.factoryProducer = oix0oi2;
        this.extrasProducer = oix0oi3;
    }

    @OOXIXo
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke(), this.extrasProducer.invoke()).get(II0xO0.X0o0xo(this.viewModelClass));
        this.cached = vm2;
        return vm2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelLazy(oxoX oxox, oIX0oI oix0oi, oIX0oI oix0oi2, oIX0oI oix0oi3, int i, IIXOooo iIXOooo) {
        this(oxox, oix0oi, oix0oi2, (i & 8) != 0 ? AnonymousClass1.INSTANCE : oix0oi3);
    }
}
