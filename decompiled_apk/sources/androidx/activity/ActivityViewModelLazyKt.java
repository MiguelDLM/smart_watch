package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.DeprecationLevel;
import kotlin.X0IIOO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;

/* loaded from: classes.dex */
public final class ActivityViewModelLazyKt {
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModels that takes a CreationExtras")
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> X0IIOO<VM> viewModels(ComponentActivity componentActivity, Oox.oIX0oI<? extends ViewModelProvider.Factory> oix0oi) {
        IIX0o.x0xO0oo(componentActivity, "<this>");
        if (oix0oi == null) {
            oix0oi = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        IIX0o.OxI(4, "VM");
        return new ViewModelLazy(IO.oxoX(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), oix0oi, new ActivityViewModelLazyKt$viewModels$2(componentActivity));
    }

    public static /* synthetic */ X0IIOO viewModels$default(ComponentActivity componentActivity, Oox.oIX0oI oix0oi, int i, Object obj) {
        if ((i & 1) != 0) {
            oix0oi = null;
        }
        IIX0o.x0xO0oo(componentActivity, "<this>");
        if (oix0oi == null) {
            oix0oi = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        IIX0o.OxI(4, "VM");
        return new ViewModelLazy(IO.oxoX(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), oix0oi, new ActivityViewModelLazyKt$viewModels$2(componentActivity));
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> X0IIOO<VM> viewModels(ComponentActivity componentActivity, Oox.oIX0oI<? extends CreationExtras> oix0oi, Oox.oIX0oI<? extends ViewModelProvider.Factory> oix0oi2) {
        IIX0o.x0xO0oo(componentActivity, "<this>");
        if (oix0oi2 == null) {
            oix0oi2 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        IIX0o.OxI(4, "VM");
        return new ViewModelLazy(IO.oxoX(ViewModel.class), new ActivityViewModelLazyKt$viewModels$3(componentActivity), oix0oi2, new ActivityViewModelLazyKt$viewModels$4(oix0oi, componentActivity));
    }

    public static /* synthetic */ X0IIOO viewModels$default(ComponentActivity componentActivity, Oox.oIX0oI oix0oi, Oox.oIX0oI oix0oi2, int i, Object obj) {
        if ((i & 1) != 0) {
            oix0oi = null;
        }
        if ((i & 2) != 0) {
            oix0oi2 = null;
        }
        IIX0o.x0xO0oo(componentActivity, "<this>");
        if (oix0oi2 == null) {
            oix0oi2 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        IIX0o.OxI(4, "VM");
        return new ViewModelLazy(IO.oxoX(ViewModel.class), new ActivityViewModelLazyKt$viewModels$3(componentActivity), oix0oi2, new ActivityViewModelLazyKt$viewModels$4(oix0oi, componentActivity));
    }
}
