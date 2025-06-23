package androidx.activity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.StyleRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nComponentDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentDialog.kt\nandroidx/activity/ComponentDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n1#2:128\n*E\n"})
public class ComponentDialog extends Dialog implements LifecycleOwner, OnBackPressedDispatcherOwner, SavedStateRegistryOwner {
    @oOoXoXO
    private LifecycleRegistry _lifecycleRegistry;
    @OOXIXo
    private final OnBackPressedDispatcher onBackPressedDispatcher;
    @OOXIXo
    private final SavedStateRegistryController savedStateRegistryController;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public ComponentDialog(@OOXIXo Context context) {
        this(context, 0, 2, (IIXOooo) null);
        IIX0o.x0xO0oo(context, bn.f.o);
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry lifecycleRegistry = this._lifecycleRegistry;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
        this._lifecycleRegistry = lifecycleRegistry2;
        return lifecycleRegistry2;
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    /* access modifiers changed from: private */
    public static final void onBackPressedDispatcher$lambda$1(ComponentDialog componentDialog) {
        super.onBackPressed();
    }

    public void addContentView(@OOXIXo View view, @oOoXoXO ViewGroup.LayoutParams layoutParams) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        initializeViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    @OOXIXo
    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    @OOXIXo
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @OOXIXo
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @CallSuper
    public void initializeViewTreeOwners() {
        Window window = getWindow();
        IIX0o.ooOOo0oXI(window);
        View decorView = window.getDecorView();
        IIX0o.oO(decorView, "window!!.decorView");
        ViewTreeLifecycleOwner.set(decorView, this);
        Window window2 = getWindow();
        IIX0o.ooOOo0oXI(window2);
        View decorView2 = window2.getDecorView();
        IIX0o.oO(decorView2, "window!!.decorView");
        ViewTreeOnBackPressedDispatcherOwner.set(decorView2, this);
        Window window3 = getWindow();
        IIX0o.ooOOo0oXI(window3);
        View decorView3 = window3.getDecorView();
        IIX0o.oO(decorView3, "window!!.decorView");
        ViewTreeSavedStateRegistryOwner.set(decorView3, this);
    }

    @CallSuper
    public void onBackPressed() {
        this.onBackPressedDispatcher.onBackPressed();
    }

    @CallSuper
    public void onCreate(@oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher2 = this.onBackPressedDispatcher;
            OnBackInvokedDispatcher oIX0oI2 = getOnBackInvokedDispatcher();
            IIX0o.oO(oIX0oI2, "onBackInvokedDispatcher");
            onBackPressedDispatcher2.setOnBackInvokedDispatcher(oIX0oI2);
        }
        this.savedStateRegistryController.performRestore(bundle);
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @OOXIXo
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        IIX0o.oO(onSaveInstanceState, "super.onSaveInstanceState()");
        this.savedStateRegistryController.performSave(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @CallSuper
    public void onStart() {
        super.onStart();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @CallSuper
    public void onStop() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    public void setContentView(int i) {
        initializeViewTreeOwners();
        super.setContentView(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComponentDialog(Context context, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @xoIox
    public ComponentDialog(@OOXIXo Context context, @StyleRes int i) {
        super(context, i);
        IIX0o.x0xO0oo(context, bn.f.o);
        this.savedStateRegistryController = SavedStateRegistryController.Companion.create(this);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new ooOOo0oXI(this));
    }

    public void setContentView(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        initializeViewTreeOwners();
        super.setContentView(view);
    }

    public void setContentView(@OOXIXo View view, @oOoXoXO ViewGroup.LayoutParams layoutParams) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        initializeViewTreeOwners();
        super.setContentView(view, layoutParams);
    }
}
