package com.baidu.navisdk.pronavi.ui.bucket;

import android.animation.Animator;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.f;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.pronavi.ui.base.b;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.k;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.widget.bucket.BNBucketItem;
import com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket;
import com.baidu.navisdk.uiframe.UiModule;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class RGBaseBucketComponent<C extends com.baidu.navisdk.pronavi.ui.base.b> extends RGUiComponent<C> implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    protected com.baidu.navisdk.pronavi.ui.bucket.factory.a p;
    protected com.baidu.navisdk.pronavi.ui.bucket.config.a q;
    protected BNViewPriorityBucket r;
    protected BNViewPriorityBucket s;
    private boolean t;
    private SparseArray<com.baidu.navisdk.pronavi.ui.bucket.item.a> u;
    protected Runnable v;
    protected Runnable w;
    protected boolean x;
    private View y;
    private a.q0 z;

    /* loaded from: classes7.dex */
    public class a implements Observer<Boolean> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            RGBaseBucketComponent.this.c(bool.booleanValue());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Observer<Boolean> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            RGBaseBucketComponent.this.b(bool.booleanValue());
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.q0 {
        public c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.a.q0
        public void a() {
            x.b().d(((UiModule) RGBaseBucketComponent.this).k);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BNViewPriorityBucket.OnStatueChangeListener {
        public d() {
        }

        @Override // com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket.OnStatueChangeListener
        public void onRemoveView(@Nullable BNBucketItem bNBucketItem, boolean z) {
            if (RGBaseBucketComponent.this.u != null && bNBucketItem != null) {
                RGBaseBucketComponent.this.u.remove(bNBucketItem.getId());
            }
        }

        @Override // com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket.OnStatueChangeListener
        public void onVisibleChange(@Nullable BNBucketItem bNBucketItem) {
            super.onVisibleChange(bNBucketItem);
            RGBaseBucketComponent.this.H();
        }
    }

    public RGBaseBucketComponent(@NonNull C c2, boolean z, boolean z2) {
        super(c2);
        this.y = null;
        this.t = z;
        this.x = z2;
        E();
    }

    private void K() {
        d dVar = new d();
        BNViewPriorityBucket bNViewPriorityBucket = this.r;
        if (bNViewPriorityBucket != null) {
            bNViewPriorityBucket.setStatusChangeListener(dVar);
        }
        BNViewPriorityBucket bNViewPriorityBucket2 = this.s;
        if (bNViewPriorityBucket2 != null) {
            bNViewPriorityBucket2.setStatusChangeListener(dVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void L() {
        this.y = this.k;
        M();
        N();
        G();
        K();
        if (this.o != 2) {
            f t = ((com.baidu.navisdk.pronavi.ui.base.b) n()).t();
            b(x.b().N() + a(t.f6817a, com.baidu.navisdk.ui.routeguide.utils.b.a(true, t), t));
            this.z = new c();
            x.b().a(this.z);
        }
    }

    private void M() {
        BNViewPriorityBucket bNViewPriorityBucket = this.r;
        if (bNViewPriorityBucket != null) {
            bNViewPriorityBucket.removeBucketLayoutChangeListener();
        }
        BNViewPriorityBucket bNViewPriorityBucket2 = this.s;
        if (bNViewPriorityBucket2 != null) {
            bNViewPriorityBucket2.removeBucketLayoutChangeListener();
        }
    }

    private void N() {
        BNViewPriorityBucket bNViewPriorityBucket;
        BNViewPriorityBucket bNViewPriorityBucket2;
        Runnable runnable = this.v;
        if (runnable != null && (bNViewPriorityBucket2 = this.r) != null) {
            bNViewPriorityBucket2.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.w;
        if (runnable2 != null && (bNViewPriorityBucket = this.s) != null) {
            bNViewPriorityBucket.removeCallbacks(runnable2);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent
    public void A() {
        BNViewPriorityBucket bNViewPriorityBucket = this.r;
        if (bNViewPriorityBucket != null) {
            bNViewPriorityBucket.refreshAllViewVisibility();
        }
        BNViewPriorityBucket bNViewPriorityBucket2 = this.s;
        if (bNViewPriorityBucket2 != null) {
            bNViewPriorityBucket2.refreshAllViewVisibility();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        View view;
        View a2;
        SparseArray<com.baidu.navisdk.pronavi.ui.bucket.item.a> sparseArray = this.u;
        if (sparseArray == null || sparseArray.size() == 0 || (view = this.k) == null || view.getVisibility() != 0) {
            return null;
        }
        View[] viewArr = new View[this.u.size()];
        for (int i = 0; i < this.u.size(); i++) {
            com.baidu.navisdk.pronavi.ui.bucket.item.a valueAt = this.u.valueAt(i);
            if (valueAt != null && valueAt.e() && valueAt.q() && (a2 = valueAt.a()) != null) {
                viewArr[i] = a2;
            }
        }
        return viewArr;
    }

    public void C() {
        com.baidu.navisdk.pronavi.hd.normal.i.a c2 = com.baidu.navisdk.ui.routeguide.utils.b.c(true);
        if (c2 != null) {
            c2.b().observe(this, new a());
        }
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(true);
        if (b2 != null) {
            b2.b().observe(this, new b());
        }
    }

    public int D() {
        if (this.x) {
            return this.s.getBottomVisibleSize();
        }
        return this.r.getBottomVisibleSize();
    }

    public void E() {
        if (this.q == null) {
            if (com.baidu.navisdk.module.cloudconfig.a.b().a("NAVI_SUPPORT_NEW_BTN", true)) {
                this.q = new com.baidu.navisdk.pronavi.ui.bucket.config.c();
            } else {
                this.q = new com.baidu.navisdk.pronavi.ui.bucket.config.b();
            }
        }
        if (this.p == null) {
            this.p = new com.baidu.navisdk.pronavi.ui.bucket.factory.b();
        }
    }

    public void F() {
        ArrayList<com.baidu.navisdk.pronavi.ui.bucket.config.d> b2;
        if (this.t) {
            b2 = this.q.a();
        } else {
            b2 = this.q.b();
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(m(), "loadItems: " + b2);
        }
        if (b2 == null) {
            return;
        }
        this.u = new SparseArray<>(b2.size());
        int o = ((com.baidu.navisdk.pronavi.ui.base.b) this.i).o();
        if (gVar.d()) {
            gVar.e(this.g, "loadItems start: " + o + ", " + this.r + "," + this.s);
        }
        for (int i = 0; i < b2.size(); i++) {
            com.baidu.navisdk.pronavi.ui.bucket.config.d dVar = b2.get(i);
            dVar.g = this.t;
            com.baidu.navisdk.pronavi.ui.bucket.item.a a2 = this.p.a((com.baidu.navisdk.pronavi.ui.base.b) this.i, dVar, this);
            if (a2 == null) {
                g gVar2 = g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e(this.g, "loadItems:  item is null");
                }
            } else if (a(a2, o)) {
                this.u.put(a2.getId(), a2);
            }
        }
        g gVar3 = g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e(this.g, "loadItems end: " + this.r + "," + this.s);
        }
    }

    public void G() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onInitBucket: ");
        }
    }

    public void H() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onItemVisibleChange: ");
        }
    }

    public void I() {
        BNViewPriorityBucket bNViewPriorityBucket = this.r;
        if (bNViewPriorityBucket != null) {
            bNViewPriorityBucket.refreshAllViewStyle();
        }
        BNViewPriorityBucket bNViewPriorityBucket2 = this.s;
        if (bNViewPriorityBucket2 != null) {
            bNViewPriorityBucket2.refreshAllViewStyle();
        }
    }

    public void J() {
        BNViewPriorityBucket bNViewPriorityBucket = this.r;
        if (bNViewPriorityBucket != null) {
            bNViewPriorityBucket.refreshAllViewVisibility();
        }
        BNViewPriorityBucket bNViewPriorityBucket2 = this.s;
        if (bNViewPriorityBucket2 != null) {
            bNViewPriorityBucket2.refreshAllViewVisibility();
        }
    }

    public int a(int i, int i2, f fVar) {
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule
    public void c(String str, String str2, Bundle bundle) {
        super.c(str, str2, bundle);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, f fVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "getEnterFullHD fromState: " + i + ",miniHDHeight: " + i2 + ",isPort: " + z + "," + fVar);
        }
        if (z && this.k != null) {
            return b(3, i2, fVar);
        }
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        L();
        F();
        C();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        BNViewPriorityBucket bNViewPriorityBucket = this.r;
        if (bNViewPriorityBucket != null) {
            bNViewPriorityBucket.destroy();
            Runnable runnable = this.v;
            if (runnable != null) {
                this.r.removeCallbacks(runnable);
            }
        }
        BNViewPriorityBucket bNViewPriorityBucket2 = this.s;
        if (bNViewPriorityBucket2 != null) {
            bNViewPriorityBucket2.destroy();
            Runnable runnable2 = this.w;
            if (runnable2 != null) {
                this.s.removeCallbacks(runnable2);
            }
        }
        SparseArray<com.baidu.navisdk.pronavi.ui.bucket.item.a> sparseArray = this.u;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        x.b().b(this.z);
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public String[] t() {
        return new String[]{"onCreate"};
    }

    public void b(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "setBucketMarginBottom: " + i);
        }
        com.baidu.navisdk.pronavi.util.b.f7961a.a(this.k, i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, f fVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "getEnterNormal fromState: " + i + ",miniHDHeight: " + i2 + ",isPort: " + z + "," + fVar);
        }
        if (!z || this.k == null) {
            return null;
        }
        return b(0, i2, fVar);
    }

    private boolean a(com.baidu.navisdk.pronavi.ui.bucket.item.a aVar, int i) {
        if (this.x) {
            if (aVar.getItemLocation() == BNViewPriorityBucket.ItemLocation.START) {
                return this.r.addItem(aVar, i);
            }
            return this.s.addItem(aVar, i);
        }
        return this.r.addItem(aVar, i);
    }

    private List<Animator> b(int i, int i2, f fVar) {
        Animator a2 = com.baidu.navisdk.pronavi.hd.d.f7723a.a(this.k, a(i, i2, fVar));
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(a2);
        return arrayList;
    }

    public void c(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "refreshNormalHDBtnVisible: " + z);
        }
        k kVar = (k) a(36, k.class);
        if (kVar != null) {
            kVar.b(z);
        }
    }

    @Nullable
    public <T> T a(int i, Class<T> cls) {
        SparseArray<com.baidu.navisdk.pronavi.ui.bucket.item.a> sparseArray = this.u;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.a aVar = this.u.get(i);
        if (cls.isInstance(aVar)) {
            return cls.cast(aVar);
        }
        return null;
    }

    public void b(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "refreshHDBtnVisible: " + z);
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.f fVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.f) a(39, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.f.class);
        if (fVar != null) {
            fVar.b(z);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(Configuration configuration) {
        super.a(configuration);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onConfigurationChanged: " + configuration.orientation);
        }
        if (gVar.d()) {
            gVar.e(this.g, "onConfigurationChanged: " + this.y + ", " + this.k);
        }
        View view = this.y;
        if (view != null && this.k != null && view.hashCode() == this.k.hashCode()) {
            if (gVar.d()) {
                gVar.e(this.g, "onConfigurationChanged if:" + this.k);
                return;
            }
            return;
        }
        if (gVar.d()) {
            gVar.e(this.g, "onConfigurationChanged else:" + this.k);
        }
        L();
        SparseArray<com.baidu.navisdk.pronavi.ui.bucket.item.a> sparseArray = this.u;
        if (sparseArray != null && sparseArray.size() > 0) {
            for (int i = 0; i < this.u.size(); i++) {
                com.baidu.navisdk.pronavi.ui.bucket.item.a valueAt = this.u.valueAt(i);
                if (valueAt != null) {
                    valueAt.setGoneByPriority(false);
                    valueAt.onOrientationChangePre(configuration.orientation);
                    valueAt.removeFromParent();
                    if (valueAt.m()) {
                        valueAt.onDestroy();
                    }
                    a(valueAt, configuration.orientation);
                }
            }
        }
        I();
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule
    public void a(boolean z) {
        super.a(z);
        for (int i = 0; i < this.u.size(); i++) {
            com.baidu.navisdk.pronavi.ui.bucket.item.a valueAt = this.u.valueAt(i);
            if (valueAt != null) {
                valueAt.a(z);
            }
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, f fVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "getEnterDoubleMap fromState: " + i + ",miniHDHeight: " + i2 + ",isPort: " + z + "," + fVar);
        }
        if (!z || this.k == null) {
            return null;
        }
        return b(2, i2, fVar);
    }
}
