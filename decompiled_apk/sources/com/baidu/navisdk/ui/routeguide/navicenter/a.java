package com.baidu.navisdk.ui.routeguide.navicenter;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.baidu.navisdk.module.newguide.viewmodels.a;
import com.baidu.navisdk.ui.routeguide.model.n;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ViewModelProvider f9062a;
    private WeakReference<com.baidu.navisdk.ui.routeguide.repository.b> b;
    private WeakReference<com.baidu.navisdk.module.newguide.viewmodels.a> c;

    /* renamed from: com.baidu.navisdk.ui.routeguide.navicenter.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0471a implements Observer<a.c> {
        public C0471a(a aVar) {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable a.c cVar) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Observer<a.d> {
        public b(a aVar) {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable a.d dVar) {
        }
    }

    private void e() {
        ViewModelStore v;
        if (this.f9062a == null && (v = com.baidu.navisdk.ui.routeguide.b.V().v()) != null) {
            this.f9062a = new ViewModelProvider(v, new ViewModelProvider.NewInstanceFactory());
        }
    }

    @Nullable
    public com.baidu.navisdk.ui.routeguide.repository.b a() {
        com.baidu.navisdk.ui.routeguide.repository.b bVar;
        WeakReference<com.baidu.navisdk.ui.routeguide.repository.b> weakReference = this.b;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        e();
        ViewModelProvider viewModelProvider = this.f9062a;
        if (viewModelProvider != null) {
            com.baidu.navisdk.ui.routeguide.repository.b bVar2 = (com.baidu.navisdk.ui.routeguide.repository.b) viewModelProvider.get(com.baidu.navisdk.ui.routeguide.repository.b.class);
            this.b = new WeakReference<>(bVar2);
            return bVar2;
        }
        return bVar;
    }

    @Nullable
    public com.baidu.navisdk.module.newguide.viewmodels.a b() {
        com.baidu.navisdk.module.newguide.viewmodels.a aVar;
        com.baidu.navisdk.ui.routeguide.repository.b a2;
        WeakReference<com.baidu.navisdk.module.newguide.viewmodels.a> weakReference = this.c;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar;
        }
        e();
        if (this.f9062a != null && (a2 = a()) != null) {
            aVar = (com.baidu.navisdk.module.newguide.viewmodels.a) this.f9062a.get(com.baidu.navisdk.module.newguide.viewmodels.a.class);
            aVar.a(a2);
            LifecycleOwner f = com.baidu.navisdk.ui.routeguide.b.V().f();
            if (f != null) {
                aVar.b().observe(f, new C0471a(this));
                aVar.a().observe(f, new b(this));
            }
            this.c = new WeakReference<>(aVar);
        }
        return aVar;
    }

    public n c() {
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            return com.baidu.navisdk.ui.routeguide.b.V().j().l().b();
        }
        return null;
    }

    public void d() {
        this.f9062a = null;
        this.b = null;
        this.c = null;
    }
}
