package com.baidu.navisdk.ui.routeguide.control;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.navisdk.embed.R;
import java.util.List;

/* loaded from: classes8.dex */
public class i implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    private static volatile i c;

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<com.baidu.navisdk.ui.routeguide.mapmode.subview.k> f8547a = new SparseArray<>();
    private ViewGroup b = null;

    private i() {
    }

    private void d(int i) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.k kVar = this.f8547a.get(i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("hideInner type:");
            sb.append(kVar == null ? "cardView = null" : Integer.valueOf(kVar.f8808a));
            sb.append(", mContainer =");
            sb.append(this.b);
            gVar.e("RGCardViewController", sb.toString());
        }
        if (this.b != null && kVar != null) {
            View e = kVar.e();
            if (e != null) {
                e.clearAnimation();
                this.b.removeView(e);
            }
            kVar.j();
            if (gVar.d() && e != null) {
                gVar.e("RGCardViewController", "hideInner cardView hashCode: " + e.hashCode());
            }
        }
        this.f8547a.remove(i);
    }

    public static i g() {
        if (c == null) {
            synchronized (i.class) {
                try {
                    if (c == null) {
                        c = new i();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    private void h() {
        SparseArray<com.baidu.navisdk.ui.routeguide.mapmode.subview.k> sparseArray;
        ViewGroup viewGroup = this.b;
        if (viewGroup == null || viewGroup.getVisibility() != 0 || this.b.getChildCount() <= 0 || (sparseArray = this.f8547a) == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.k valueAt = this.f8547a.valueAt(i);
            if (valueAt != null && valueAt.e() != null && valueAt.e().getParent() != null) {
                valueAt.e().setLayoutParams(valueAt.d());
            }
        }
    }

    public void a(com.baidu.navisdk.ui.routeguide.mapmode.subview.k kVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCardViewController", "show -> cardView = " + kVar);
        }
        if (this.f8547a.get(kVar.f8808a) != null) {
            b(kVar.f8808a);
        }
        this.f8547a.put(kVar.f8808a, kVar);
        b(kVar);
    }

    public void b(int i) {
        d(i);
    }

    public boolean c(int i) {
        return this.f8547a.get(i) != null;
    }

    public void e() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCardViewController", "onOrientationChange! mCardViewMap.size() = " + this.f8547a.size());
        }
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.b = null;
        }
        int size = this.f8547a.size();
        for (int i = 0; i < size; i++) {
            a(this.f8547a.valueAt(i));
        }
    }

    public void f() {
        Object valueOf;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeAllCards, mCardViewMap = ");
            SparseArray<com.baidu.navisdk.ui.routeguide.mapmode.subview.k> sparseArray = this.f8547a;
            if (sparseArray == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(sparseArray.size());
            }
            sb.append(valueOf);
            sb.append(", mContainer = ");
            sb.append(this.b);
            gVar.e("RGCardViewController", sb.toString());
        }
        if (this.f8547a != null && this.b != null) {
            for (int i = 0; i < this.f8547a.size(); i++) {
                com.baidu.navisdk.ui.routeguide.mapmode.subview.k kVar = this.f8547a.get(this.f8547a.keyAt(i));
                if (kVar != null) {
                    kVar.j();
                }
            }
            this.b.removeAllViews();
            this.f8547a.clear();
        }
    }

    public boolean b() {
        ViewGroup viewGroup;
        if (this.f8547a.size() > 0 && (viewGroup = this.b) != null && viewGroup.getChildCount() > 0) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (!gVar.d()) {
                return true;
            }
            gVar.e("RGCardViewController", "isShow -> true");
            return true;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (!gVar2.d()) {
            return false;
        }
        gVar2.e("RGCardViewController", "isShow -> false");
        return false;
    }

    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCardViewController", "onBackground!");
        }
        int size = this.f8547a.size();
        for (int i = 0; i < size; i++) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.k valueAt = this.f8547a.valueAt(i);
            if (valueAt != null) {
                valueAt.g();
            }
        }
    }

    private void b(com.baidu.navisdk.ui.routeguide.mapmode.subview.k kVar) {
        boolean s2 = x.b().s2();
        if (this.b == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGCardViewController", "showInner mContainer重新赋值，orien = " + x.b().d0());
            }
            this.b = x.b().b(R.id.navi_rg_card_container);
        }
        a(s2, kVar);
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGCardViewController", "showInner return tmpVG is null type:" + kVar.f8808a);
                return;
            }
            return;
        }
        a(s2, com.baidu.navisdk.ui.routeguide.utils.b.o().b());
        if (kVar != null && kVar.e() != null) {
            ViewParent parent = kVar.e().getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(kVar.e());
            }
            viewGroup.addView(kVar.e(), kVar.d());
            kVar.k();
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGCardViewController", "showInner type:" + kVar.f8808a + ", cardView.getView() = " + kVar.e().isShown() + ", getView.getVisibility = " + kVar.e().getVisibility() + ", mContainer = " + this.b.getVisibility() + ", mContainer.getChildCount = " + this.b.getChildCount() + ", cardView hashCode: " + kVar.e().hashCode() + ", mContainer=" + this.b);
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar4.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("showInner return cardView = ");
            sb.append(kVar);
            sb.append(", cardView.getView() =");
            sb.append(kVar == null ? "null" : kVar.e());
            gVar4.e("RGCardViewController", sb.toString());
        }
    }

    public void a(boolean z) {
        if (this.f8547a.size() == 0) {
            return;
        }
        int size = this.f8547a.size();
        for (int i = 0; i < size; i++) {
            this.f8547a.valueAt(i).a(z);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCardViewController", "getEnterNormal: " + i + "," + z);
        }
        if (z) {
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.b, 0);
        }
        if (i == 2) {
            a(false, false);
        }
        h();
        return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.b, 0, 0);
    }

    private void a(boolean z, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCardViewController", "disposeSafetyPadding: " + z + ",isMultiHDNavi: " + z2);
        }
        if (z || !com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().b()) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().a(2, true, !z2, this.b);
    }

    public void d() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCardViewController", "onForeground!");
        }
        int size = this.f8547a.size();
        for (int i = 0; i < size; i++) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.k valueAt = this.f8547a.valueAt(i);
            if (valueAt != null) {
                valueAt.i();
            }
        }
    }

    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCardViewController", "dispose");
        }
        for (int i = 0; i < this.f8547a.size(); i++) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.k kVar = this.f8547a.get(this.f8547a.keyAt(i));
            if (kVar != null) {
                kVar.h();
            }
        }
        this.f8547a.clear();
        this.b = null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCardViewController", "getEnterFullHD: " + i + "," + z);
        }
        if (z) {
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.b, 0);
        }
        if (i == 2) {
            a(false, false);
        }
        h();
        int k = com.baidu.navisdk.ui.routeguide.utils.b.k();
        return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.b, k, k);
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.subview.k a(int i) {
        return this.f8547a.get(i);
    }

    private int a(int i, com.baidu.navisdk.ui.routeguide.mapmode.subview.k kVar) {
        if (kVar == null && this.f8547a.size() > 0) {
            kVar = this.f8547a.get(r3.size() - 1);
        }
        if (kVar == null || kVar.f()) {
            return i;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCardViewController", "getEnterDoubleMap: " + i + "," + z);
        }
        if (z) {
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.b, a(i2, (com.baidu.navisdk.ui.routeguide.mapmode.subview.k) null));
        }
        a(false, true);
        h();
        return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.b, 0, i2);
    }

    private void a(boolean z, com.baidu.navisdk.ui.routeguide.mapmode.subview.k kVar) {
        int i;
        com.baidu.navisdk.framework.interfaces.pronavi.hd.f o = com.baidu.navisdk.ui.routeguide.utils.b.o();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCardViewController", "initContainerLocation: " + z + ",curHDState: " + o);
        }
        int i2 = o.f6817a;
        if (i2 == 0) {
            return;
        }
        if (z) {
            com.baidu.navisdk.pronavi.hd.d.f7723a.e(this.b, i2 == 2 ? a(com.baidu.navisdk.ui.routeguide.utils.b.a(true, o), kVar) : 0);
            return;
        }
        if (i2 == 2) {
            i = com.baidu.navisdk.ui.routeguide.utils.b.a(false, o);
        } else {
            r3 = com.baidu.navisdk.ui.routeguide.utils.b.k();
            i = r3;
        }
        com.baidu.navisdk.pronavi.hd.d.f7723a.e(this.b, r3, i);
    }
}
