package com.baidu.navisdk.module.newguide.widgets;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.navisdk.ui.routeguide.widget.d;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class b extends d implements LifecycleOwner, ViewModelStoreOwner {
    protected LifecycleRegistry i;
    protected ViewModelStore j;
    private ViewModelProvider k;

    public b(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        o0();
    }

    private void a(Lifecycle.Event event) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCustomLifecycleOrientationBaseView", "dispatch --> event:" + event);
        }
        LifecycleRegistry lifecycleRegistry = this.i;
        if (lifecycleRegistry != null) {
            lifecycleRegistry.handleLifecycleEvent(event);
        }
    }

    private void o0() {
        if (this.i == null) {
            this.i = new LifecycleRegistry(this);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        a(Lifecycle.Event.ON_CREATE);
        a(Lifecycle.Event.ON_START);
        super.b(bundle);
        a(Lifecycle.Event.ON_RESUME);
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        c(null);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.i;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (this.j == null) {
            this.j = new ViewModelStore();
        }
        return this.j;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        this.k = null;
    }

    public ViewModelProvider n0() {
        if (this.k == null) {
            this.k = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory());
        }
        return this.k;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        return b(null);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c(Bundle bundle) {
        a(Lifecycle.Event.ON_PAUSE);
        super.c(bundle);
        a(Lifecycle.Event.ON_STOP);
        a(Lifecycle.Event.ON_DESTROY);
        ViewModelStore viewModelStore = this.j;
        if (viewModelStore != null) {
            viewModelStore.clear();
            this.j = null;
        }
    }

    public b(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        o0();
    }
}
